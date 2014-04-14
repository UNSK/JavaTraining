package ex16_09;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;




/**
 * 16.9 Print all declarations in a class
 */
public class ClassDeclarationsPrinter {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName(args[0]);
            printClassInfo(cls);
            printAllMembers(cls.getFields(), cls.getDeclaredFields());
            printAllMembers(cls.getConstructors(), cls.getDeclaredConstructors());
            printAllMembers(cls.getMethods(), cls.getDeclaredMethods());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    private static void printClassInfo(Class<?> cls) {
        //annotations
        for (Annotation a : cls.getAnnotations()) {
            System.out.println(a);
        }
        //modifiers
        int modifier = cls.getModifiers();
        System.out.print(Modifier.toString(modifier));
        if (modifier != 0) { 
            System.out.print(" ");
        }
        //inheritance info
        System.out.print("Class " + cls.getSimpleName());
        if (cls.getGenericSuperclass() != Object.class) {
            System.out.print(" extends " + cls.getSuperclass().getSimpleName() + " ");
        }
        Type[] interfaces = cls.getGenericInterfaces();
        if (interfaces.length != 0) {
            System.out.print("implements ");
            for (Type t : interfaces) {
                System.out.print(toSimpleName(t) + " ");
            }
        }
        System.out.println("{");
    }
    
    private static void printMembers(Member[] mems) {
        for (Member m : mems) {
            if (m.getDeclaringClass() == Object.class) {
                continue;
            }
            printMember(m);
        }
    }
    
    private static void printAllMembers(Member[] mems, Member[] declMems) {
        printMembers(mems);
        List<Member> memList = Arrays.asList(mems);
        for (Member m : declMems) {
            if (!memList.contains(m)) {
                printMember(m);
            }
        }
    }
    
    private static void printMember(Member m) {
        
      //annotations
        for (Annotation a : ((AccessibleObject) m).getAnnotations()) {
            System.out.print("  ");
            System.out.println(a);
        }
        System.out.print("  ");
        //modifiers
        int modifier = m.getModifiers();
        System.out.print(Modifier.toString(modifier));
        if (modifier != 0) { 
            System.out.print(" ");
        }
        if (m instanceof Field) {
            System.out.print(((Field) m).getType().getSimpleName());
            System.out.print(" " + m.getName());
        } else if (m instanceof Constructor<?>) {
            System.out.print(m.getName());
            Type[] params = ((Constructor<?>) m).getParameterTypes();
            printParameters(params);
            Class<?>[] exs = ((Constructor<?>) m).getExceptionTypes();
            printExceptions(exs);
        } else if (m instanceof Method) {
            System.out.print(((Method) m).getReturnType() + " ");
            System.out.print(m.getName());
            Type[] params = ((Method) m).getParameterTypes();
            printParameters(params);
            Class<?>[] exs = ((Method) m).getExceptionTypes();
            printExceptions(exs);
        }
        System.out.println();
    }
   
    private static void printParameters(Type[] params) { 
            System.out.print("(");
            for (Type t : params) {
                System.out.print(toSimpleName(t) + ", ");
            }
            if (params.length != 0) {
                System.out.printf("\b\b");
            }
            System.out.print(")");      
    }
    
    private static void printExceptions(Class<?>[] exs) {
        if (exs.length == 0) {
            return;
        } else {
            System.out.print(" throws ");
            for (Class<?> c : exs) {
                System.out.print(c.getSimpleName() + ", ");
            }
            System.out.printf("\b\b");
        }
    }
    
    /**
     * convert type name to class simple name
     * @param type be converted
     * @return class simple name 
     */
    private static String toSimpleName(Type type) {
        if (type instanceof Class<?>) {
            return ((Class<?>) type).getSimpleName();
        } else if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(((Class<?>) pType.getRawType()).getSimpleName());
            
            Type[] args = pType.getActualTypeArguments();
            sBuilder.append("<");
            for (Type t: args) {
                sBuilder.append(toSimpleName(t));
                sBuilder.append(", ");
            }
            sBuilder.deleteCharAt(sBuilder.lastIndexOf(","));
            sBuilder.deleteCharAt(sBuilder.lastIndexOf(" "));
            sBuilder.append(">");
            return sBuilder.toString();
        } else {
            return type.toString();
        }
    }
}
