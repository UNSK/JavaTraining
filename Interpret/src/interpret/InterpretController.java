package interpret;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.regex.Pattern;

import javax.lang.model.element.Element;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.omg.CORBA.DynAnyPackage.Invalid;


/**
 *
 */
public class InterpretController {
    private final InterpretView view;
    private final ObjectManager objectManager;
    
    private Class<?> selectedClass;
    private Object selectedObject;
    private Field selectedField;
    private Method selectedMethod;
    private Object selectedArrayElem;
    private int selectedArrIndex;

   
    public InterpretController() {
        view = new InterpretView();
        objectManager = new ObjectManager();
    }
    
    public void control() {
        
        //add action listener to class name text field
        view.getCNameField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objectManager.clearConstructorList();
                String className = view.getCNameField().getText();
                try {
                    selectedClass = Class.forName(className);
                    objectManager.listConstructors(selectedClass);
                    view.setStatus("OK", Color.BLACK);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    view.setStatus(ex.toString(), Color.RED);
                }
            }
        });
        
        //add create button listener
        view.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int constIndex = view.getConstructorJList().getSelectedIndex();
                System.out.println(constIndex);
                if (constIndex == -1) {
                    System.err.println("Select a constructor.");
                    view.setStatus("Select a constructor.", Color.RED);
                    return;
                }
                Constructor<?> constructor = ObjectManager.getConstructorListModel().getElementAt(constIndex);
                String[] argText = view.getConstArgsTextField().getText().split(",[\\s]*");
                Type[] parameters = constructor.getParameterTypes();
                Object[] args = stringsToArgs(argText, parameters);
                objectManager.createObject(constructor, args);
            }
        });
        
        //add create array button listener
        view.getCreateArrayButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int size = Integer.parseInt(view.getArraySizeField().getText());
                objectManager.createArray(selectedClass, size);
            }
        });
        
        //add object jList listener
        view.getObjectJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = view.getObjectJList().getSelectedIndex();
                selectedObject = ObjectManager.getObjectListModel().getElementAt(index);
                Class<?> cls = selectedObject.getClass();
              
                objectManager.clearFieldList();
                objectManager.clearArrayList();
                objectManager.clearMethodList();
               
                objectManager.listFields(cls, selectedObject);
                objectManager.listMethods(cls);
                
            }
        });
        
        //add field jList listener
        view.getFieldJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                int index = view.getFieldJList().getSelectedIndex();
                selectedField = ObjectManager.getFieldListModel().getElementAt(index);
                //print value
                selectedField.setAccessible(true);
                Object value = null;
                try {
                    if (selectedObject.getClass().isArray()) {
                        value = selectedField.get(selectedArrayElem);
                    } else {
                        value = selectedField.get(selectedObject);
                    }
                    if (value == null) {
                        value = "null";
                    }
                    view.getValueField().setText(value.toString());
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                    view.setStatus(e.toString(), Color.RED);
                } 
                
            }
        });
        
        //add array value jList listener
        view.getArrayJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedArrIndex = view.getArrayJList().getSelectedIndex();
                //FIXME unstable
                if (selectedArrIndex == -1) return ;
                System.out.println(selectedObject + " " +selectedArrIndex);
                selectedArrayElem = Array.get(selectedObject, selectedArrIndex);
                objectManager.clearConstructorList();
                objectManager.listConstructors(selectedObject.getClass().getComponentType());
                objectManager.clearFieldList();
                objectManager.clearMethodList();
                if (selectedArrayElem != null) {
                    objectManager.listFields(selectedArrayElem.getClass(), selectedArrayElem);
                    objectManager.listMethods(selectedArrayElem.getClass());
                }
            }
        });
        
        //add array element instantiate listener
        view.getArrInitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int constIndex = view.getConstructorJList().getSelectedIndex();
                System.out.println(constIndex);
                if (constIndex == -1) {
                    view.setStatus("Select a constructor", Color.RED);
                    return;
                }
                Constructor<?> constructor = ObjectManager.getConstructorListModel().getElementAt(constIndex);
                String[] argText = view.getArrConstTextField().getText().split(",[\\s]*");
                Type[] parameters = constructor.getParameterTypes();
                Object[] args = stringsToArgs(argText, parameters);
                objectManager.initElement(selectedObject, selectedArrIndex, constructor, args);
                selectedArrayElem = Array.get(selectedObject, selectedArrIndex);
                objectManager.listFields(selectedArrayElem.getClass(), selectedArrayElem);
                objectManager.listMethods(selectedArrayElem.getClass());
            }
        });
        
        //add field set button performed
        view.getFieldSetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputValue = view.getValueField().getText();
                try {
                    if (selectedObject.getClass().isArray()) {
                        selectedField.set(selectedArrayElem,
                                convertToType(inputValue, selectedField.getType()));
                    } else {
                        selectedField.set(selectedObject,
                                convertToType(inputValue, selectedField.getType()));
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    view.setStatus(ex.toString(), Color.RED);
                    ex.printStackTrace();
                }
                
            }
        });
        
        //add method jList listener
        view.getMethodJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                int index = view.getMethodJList().getSelectedIndex();
                selectedMethod = ObjectManager.getMethodListModel().elementAt(index);
            }
        });
        
        //add method invoke button
        view.getMethodInvokeButton().addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] argText = view.getMethodArgsTextField().getText().split(",[\\s]*");
                Type[] parameters = selectedMethod.getParameterTypes();
                Object[] args = stringsToArgs(argText, parameters);
                Object retVal;
                //TODO handling return value
                try {
                    if (selectedObject.getClass().isArray()) {
                        retVal = selectedMethod.invoke(selectedArrayElem, args);
                    } else {
                        retVal = selectedMethod.invoke(selectedObject, args);
                    }
                    if (retVal == null) {
                        retVal = "void";
                    }
                    view.getRetValField().setText(retVal.toString());
                } catch (IllegalAccessException | IllegalArgumentException ex) {
                    view.setStatus(ex.toString(), Color.RED);
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    view.setStatus(ex.getCause().toString(), Color.RED);
                    ex.getCause().printStackTrace();
                }
            }
        });
        
    }
    
    private Object[] stringsToArgs(String[] strings, Type[] argTypes) {
        if (strings.length != argTypes.length && strings.length != 1) {
            System.err.println("invalid arguments");
            throw new IllegalArgumentException();
        }
        //no argument
        if (argTypes.length == 0) {
            return null;
        }
        
        Object[] args = new Object[argTypes.length];
        for (int i = 0; i < args.length; i++) {
            if (strings[i].startsWith("#") ||
                    strings[i].startsWith("&")) {
                args[i] = assignInstance(strings[i], argTypes[i]);
            } else {
                args[i] = convertToType(strings[i], argTypes[i]);
            }
        }
        
        //not implemented yet
        return args;
    }
    
    /**
     * convert string into object
     * @param str to be convert
     * @param type of Object you want to convert
     * @return Object
     */
    private Object convertToType(String str, Type type) {      
        if (type.equals(Integer.class) || type.equals(int.class)) {
            return Integer.parseInt(str);
        } else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
            return Boolean.parseBoolean(str);
        } else if (type.equals(Byte.class) || type.equals(byte.class)) {
            return Byte.parseByte(str);
        } else if (type.equals(Character.class) || type.equals(char.class)) {
            if (str.matches("\'.\'")) {
                return str.charAt(1);
            } else {
                throw new IllegalArgumentException("failed to parse character");
            }
        } else if (type.equals(Float.class) || type.equals(float.class)) {
            return Float.parseFloat(str);
        } else if (type.equals(Double.class) || type.equals(double.class)) {
            return Double.parseDouble(str);
        } else if (type.equals(Long.class) || type.equals(long.class)) {
            return Long.parseLong(str);
        } else if (type.equals(Short.class) || type.equals(short.class)) {
            return Short.parseShort(str);
        } else if (type.equals(String.class)) {
            if (str.matches("\".*\"")) {
                return str.replaceAll("\"", "");
            } else {
                throw new IllegalArgumentException("failed to parse String");
            }
        } else {
            throw new Error("not primitive type");
        }
    }
    
    private Object assignInstance(String str, Type type) {
        if (str.startsWith("#")) { //instance
            int index = Integer.parseInt(str.substring(1));
            Object argObj = ObjectManager.getObjectListModel().getElementAt(index);
            return argObj;
        } else if (str.startsWith("&")) { //array element
            int index = Integer.parseInt(str.substring(1));
            Object argObj = ObjectManager.getArrayValueListModel().getElementAt(index);
            return argObj;
        } else {
            throw new Error();
        }
    }

}
