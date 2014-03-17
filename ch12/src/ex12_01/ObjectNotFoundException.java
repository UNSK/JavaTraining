package ex12_01;

public class ObjectNotFoundException extends Exception {
	Object object;
	
	ObjectNotFoundException(Object o) {
		super("Not found such object: " + o);
		this.object = o;
	}
	
}
