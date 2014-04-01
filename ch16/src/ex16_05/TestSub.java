package ex16_05;

@TestAnnotation("sub class")
public class TestSub extends TestSuper {
    @TestAnnotation("public field")
    public double d;
    @TestAnnotation("private field")
    private boolean flag;
    
    @TestAnnotation("constructor")
    public TestSub() { }
    public TestSub(int i) { }
    
    @TestAnnotation("public method")
    public void hoge() { }
    @TestAnnotation("private method")
    private void fuga() { }
}
