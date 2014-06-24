package ex22_15;

import javax.swing.SwingUtilities;

/**
 * entry class for rpn calculator
 */
public class Main {

    /**
     * @param args not in use.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                RPNCalculatorController controller = new RPNCalculatorController();
                controller.bindNumberButtonListener();
                controller.bindEnterButtonListener();
                controller.bindDotButtonListener();
                controller.bindClearButtonListener();
                controller.bindOperators();
            }
        });
    }
}

