package interpret;

/**
 *
 */
public class ObjectManager {
    
    public void createObject(String className) {
        try {
            Class<?> cls = Class.forName(className);
            ClassContent.printAllMembers(cls.getFields(), cls.getDeclaredFields());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    } 
}
