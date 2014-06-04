package ex22_04;

import java.util.Observable;
import java.util.Observer;

import javax.security.auth.login.FailedLoginException;

public class AttributedObserver implements Observer {

    private AttributedImpl watching;
    
    public AttributedObserver(AttributedImpl attributed) {
        watching = attributed;
        watching.addObserver(this);
    }
    
    @Override
    public void update(Observable attributed, Object attr) {
        if (attributed != watching) {
            throw new IllegalArgumentException();
        }
        if (attr == null) {
            System.out.println("remove attr failed");
        } else {
            System.out.println(attr + " is added/removed");
        }
    }

    
    public static void main(String[] args) {
        AttributedImpl attributed = new AttributedImpl();
        @SuppressWarnings("unused")
        AttributedObserver observer = new AttributedObserver(attributed);
        
        Attr attr = new Attr("test", "foo");
        attributed.add(attr);
        
        attributed.remove("test");
        attributed.remove("nothing");
    }
}
