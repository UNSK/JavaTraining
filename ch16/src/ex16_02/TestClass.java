package ex16_02;

import java.io.Serializable;

public class TestClass implements Cloneable {
    class Inner implements Serializable {
        class Inner2 extends SuperInner{ }
    }
    
    class SuperInner { }
}
