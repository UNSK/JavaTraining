package ex14_02;

import org.junit.Test;

/**
 * Test class for PrintServer
 */
public class TestPrintServer {

    @Test
    public void testPrintServer() {
        PrintServer printServer = new PrintServer();
        printServer.print("foo");
        printServer.print("bar");
    }

    @Test (expected = IllegalStateException.class)
    public void testPrintServerFail() {
        PrintServer printServer = new PrintServer();
        printServer.run();
    }
}
