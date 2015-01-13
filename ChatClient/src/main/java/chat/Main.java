package chat;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import view.ClientController;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager
                            .getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ClientController controller = new ClientController();
                controller.control();
            }
        });
    }
}
