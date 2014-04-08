package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 */
public class InterpretController {
    InterpretView view;
    ObjectManager objectManager;
   
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
                    objectManager.listConstructors(Class.forName(className));
                } catch (ClassNotFoundException ex) {
                    
                    ex.printStackTrace();
                }
            }
        });
        
        //add create button listener
        view.getCreateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String className = view.getCNameField().getText();
                int constIndex = view.constructorJList.getSelectedIndex();
                System.out.println(constIndex);
                if (constIndex == -1) {
                    System.err.println("Select a constructor.");
                    return;
                }
                try {
                    objectManager.createObject(Class.forName(className),
                            ObjectManager.getConstructorListModel().getElementAt(constIndex));
                } catch (ClassNotFoundException e1) {
                    
                    e1.printStackTrace();
                }
            }
        });
        
        //add object jList listener
        view.getObjectJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = view.getObjectJList().getSelectedIndex();
                Class<?> cls = ObjectManager
                        .getObjectListModel().getElementAt(index).getClass();
              
                objectManager.clearFieldList();
                objectManager.clearMethodList();
                
                objectManager.listFields(cls);
                objectManager.listMethods(cls);
            }
        });
        
        //add field jList listener
        view.getFieldJList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                int index = view.getFieldJList().getSelectedIndex();
                Field field = ObjectManager.getFieldListModel().getElementAt(index);
                view.getFieldLabel().setText(field.getName());
                //print value
                field.setAccessible(true);
                int objectListIndex = view.getObjectJList().getSelectedIndex();
                Object value = null;
                try {
                    value = field.get(ObjectManager.getObjectListModel().getElementAt(objectListIndex));
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
                view.getValueField().setText(value.toString());
            }
        });
        
    }
    

}
