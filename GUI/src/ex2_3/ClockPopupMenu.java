package ex2_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/** popup menu for DigitalClock */
class ClockPopupMenu extends JPopupMenu {
    /** the serial version UID */
    private static final long serialVersionUID = 1L;
    
    /** constructs pop up menu */
    public ClockPopupMenu() {
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenu propertyItem = new JMenu("Properties");
        
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        add(exitItem);
        propertyItem.add(new FontNameMenu("Font Name"));
        propertyItem.add(new FontSizeMenu("Font Size"));
        propertyItem.add(new FontColorMenu("Font Color"));
        propertyItem.add(new BackGroundColorMenu("Back Ground Color"));
        add(propertyItem);
    }
}
