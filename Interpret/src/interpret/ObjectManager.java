package interpret;


import java.awt.Color;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class ObjectManager {
    
    private static DefaultListModel<Constructor<?>> constructorListModel = new DefaultListModel<>();
    private static DefaultListModel<Object> objectListModel = new DefaultListModel<>();
    private static DefaultListModel<Field> fieldListModel = new DefaultListModel<>(); 
    private static DefaultListModel<Method> methodListModel = new DefaultListModel<>();
    private static DefaultListModel<Object> arrayValueListModel = new DefaultListModel<>();

    public void createObject(Constructor<?> constructor, Object... args) {
        try {
            Object obj = constructor.newInstance(args);
            objectListModel.addElement(obj);
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException e) {
            InterpretView.setStatus(e.toString(), Color.RED);
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            InterpretView.setStatus(e.toString(), Color.RED);
            e.getCause().printStackTrace();
            
        }
    }
    
    public void createArray(Class<?> cls, int size) {
        try {
            Object array = Array.newInstance(cls, size);
            objectListModel.addElement(array);
        } catch (NegativeArraySizeException e) {
            InterpretView.setStatus(e.toString(), Color.RED);
            e.printStackTrace();
        }
    }
    
    public void initElement(Object array, int index, Constructor<?> constructor, Object...args) {
        try {
            Object obj = constructor.newInstance(args);
            Array.set(array, index, obj);
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException e) {
            InterpretView.setStatus(e.toString(), Color.RED);
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            InterpretView.setStatus(e.getCause().toString(), Color.RED);
            e.getCause().printStackTrace();
        }
    }
    
    //HACK list**** should write to an only method.
    
    public void listConstructors(Class<?> cls) {
        for (Constructor<?> c : cls.getConstructors()) {
            constructorListModel.addElement(c);
        }
        List<Constructor<?>> list = Arrays.asList(cls.getConstructors());
        for (Constructor<?> c : cls.getDeclaredConstructors()) {
            if(!list.contains(c))
                constructorListModel.addElement(c);
        }
    }
    
    public void listFields(Class<?> cls, Object obj) {
        if (cls.isArray()) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                arrayValueListModel.addElement(cls.getSimpleName() + "[" + i + "]");
            }
        } else {
        	List<Field> list = new LinkedList<>();
            for (Field f : cls.getFields()) {
            	list.add(f);
            }
            for (Field f : cls.getDeclaredFields()) {
                if (!list.contains(f)) {
                	list.add(f);
                }
            }
            Collections.sort(list, new Comparator<Field>() {
				@Override
				public int compare(Field o1, Field o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
            for (Field f : list) {
            	fieldListModel.addElement(f);
            }
        }
    }
    
    public void listMethods(Class<?> cls) {
        if (cls.isArray()) {
            return;
        }
        List<Method> list = new LinkedList<>();
        for (Method m : cls.getMethods()) {
        	list.add(m);
        }
        for (Method m : cls.getDeclaredMethods()) {
            if (!list.contains(m)) {
                list.add(m);
            }
        }
        Collections.sort(list, new Comparator<Method>() {
			@Override
			public int compare(Method o1, Method o2) {
				 return o1.getName().compareTo(o2.getName());
			}
		});
        for (Method m : list) {
        	methodListModel.addElement(m);
        }
    }
    
    public void clearConstructorList() {
        constructorListModel.clear();
    }
    
    public void clearArrayList() {
        arrayValueListModel.clear();
    }
    
    public void clearFieldList() {
        fieldListModel.clear();
    }
    
    public void clearMethodList() {
        methodListModel.clear();
    }
    
    /**
     * @return the constructorListModel
     */
    public static DefaultListModel<Constructor<?>> getConstructorListModel() {
        return constructorListModel;
    }

    /**
     * @return the objectListModel
     */
    public static ListModel<Object> getObjectListModel() {
        return objectListModel;
    } 
    
    /** 
     * @return the fieldListModel
     */
    public static ListModel<Field> getFieldListModel() {
        return fieldListModel;
    }
    
    /**
     * @return the methodListModel
     */
    public static DefaultListModel<Method> getMethodListModel() {
        return methodListModel;
    }

    /**
     * @return the arrayValueListModel
     */
    public static DefaultListModel<Object> getArrayValueListModel() {
        return arrayValueListModel;
    }
}
