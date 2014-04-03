package interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class InterpretController {
    InterpretView view;
    ObjectManager objectManager;
   
    public InterpretController() {
        view = new InterpretView();
        objectManager = new ObjectManager();
    }
    
    public void start() {
        controlClassCreation();
    }
    
    private void controlClassCreation() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String className = view.getCNameField().getText();
                objectManager.createObject(className);
            }
        };
        view.getCreateButton().addActionListener(al);
    }
    
}
