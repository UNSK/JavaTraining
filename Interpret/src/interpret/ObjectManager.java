package interpret;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;


/**
 *
 */
public class ObjectManager {
    
    public static DefaultListModel<Constructor<?>> constructorListModel = new DefaultListModel<>();
    public static DefaultListModel<Object> objectListModel = new DefaultListModel<>();
    public static DefaultListModel<Field> fieldListModel = new DefaultListModel<>(); 
    public static DefaultListModel<Method> methodListModel = new DefaultListModel<>();

    public void createObject(Constructor<?> constructor, Object...args) {
            Object obj = null;
            System.out.println(constructor);
            try {
                obj = constructor.newInstance(args);
            } catch (InstantiationException | IllegalAccessException
                    | IllegalArgumentException | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            objectListModel.addElement(obj);
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
    
    public void listFields(Class<?> cls) {
        for (Field f : cls.getFields()) {
            fieldListModel.addElement(f);
        }
        List<Field> list = Arrays.asList(cls.getFields());
        for (Field f : cls.getDeclaredFields()) {
            if(!list.contains(f)) 
                fieldListModel.addElement(f);
        }
    }
    
    public void listMethods(Class<?> cls) {
        for (Method m : cls.getMethods()) {
            methodListModel.addElement(m);
        }
        List<Method> list = Arrays.asList(cls.getMethods());
        for (Method m : cls.getDeclaredMethods()) {
            if(!list.contains(m))
                methodListModel.addElement(m);
        }
    }
    
    public void clearConstructorList() {
        constructorListModel.clear();
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
}
