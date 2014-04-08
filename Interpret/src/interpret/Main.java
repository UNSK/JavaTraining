package interpret;

import javax.swing.SwingUtilities;

/**
 * Interpret main class.
 */
public class Main {

    /** @param args not Using */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                InterpretController controller = new InterpretController();
                controller.control();
            }
        });
    }

}
