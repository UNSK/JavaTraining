package ex16_04;

import java.lang.annotation.Annotation;

/**
 * 16.4 print all annotations applied to given type
 */
public class AnnotationPrinter {

    public static void main(String[] args) {
        for (String name : args) {
            try {
                Class<?> cls = Class.forName(name);
                Annotation[] annotations = cls.getAnnotations();
                for (Annotation a : annotations) {
                    System.out.println(a);
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

}
