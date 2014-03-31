package ex16_03;

import java.lang.reflect.Member;

/**
 * 16.3 Modify ClassContent to show all declared members.
 *      But you don't show anything twice.
 */
public class ClassContent {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName(args[0]);
            System.out.println(c);
            printMembers(c.getFields());
            printMembers(c.getConstructors());
            printMembers(c.getMethods());
        } catch (ClassNotFoundException e) {
            System.out.println("unknown class: " + args[0]);
        }
    }
    
    private static void printMembers(Member[] mems) {
        for (Member m : mems) {
            if (m.getDeclaringClass() == Object.class) {
                continue;
            }
            String decl = m.toString();
            System.out.print("  ");
            System.out.println(strip(decl, "java.lang."));
        }
    }
    
    private static String strip(String decl, String removed) {
        return decl.replaceAll(removed, "");
    }
}
