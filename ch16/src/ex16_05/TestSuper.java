package ex16_05;


public class TestSuper {
    
    @TestAnnotation("super field")
    public int i;
    private char secret;
    
    @TestAnnotation("super method")
    public void foo() { }
    protected void bar() { }
}


