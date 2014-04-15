package interpret;


import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class ObjectManager {
    
    public static DefaultListModel<Constructor<?>> constructorListModel = new DefaultListModel<>();
    public static DefaultListModel<Object> objectListModel = new DefaultListModel<>();
    public static DefaultListModel<Field> fieldListModel = new DefaultListModel<>(); 
    public static DefaultListModel<Method> methodListModel = new DefaultListModel<>();
    public static DefaultListModel<Object> arrayValueListModel = new DefaultListModel<>();

    public void createObject(Constructor<?> constructor, Object... args) {
        try {
            Object obj = constructor.newInstance(args);
            objectListModel.addElement(obj);
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.getCause().printStackTrace();
            
        }
    }
    
    public void createArray(Class<?> cls, int size) {
        try {
            Object array = Array.newInstance(cls, size);
            objectListModel.addElement(array);
        } catch (NegativeArraySizeException e) {
            //TODO handling exception
            e.printStackTrace();
        }
    }
    
    public void initElement(Object array, int index, Constructor<?> constructor, Object...args) {
        try {
            Object obj = constructor.newInstance(args);
            Array.set(array, index, obj);
        } catch (InstantiationException | IllegalAccessException
                | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
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
            for (Field f : cls.getFields()) {
                fieldListModel.addElement(f);
            }
            List<Field> list = Arrays.asList(cls.getFields());
            for (Field f : cls.getDeclaredFields()) {
                if (!list.contains(f)) {
                    fieldListModel.addElement(f);
                }
            }
        }
    }
    
    public void listMethods(Class<?> cls) {
        if (cls.isArray()) {
            return;
        }
        for (Method m : cls.getMethods()) {
            methodListModel.addElement(m);
        }
        List<Method> list = Arrays.asList(cls.getMethods());
        for (Method m : cls.getDeclaredMethods()) {
            if (!list.contains(m)) {
                methodListModel.addElement(m);
            }
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
