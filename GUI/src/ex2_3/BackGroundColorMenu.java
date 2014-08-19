package ex2_3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * back ground color menu
 */
class BackGroundColorMenu extends ColorMenu {
    /** the serial version UID */
    private static final long serialVersionUID = 1L;
    
    /**
     * constructs new menu with supplied String as its text.
     * @param s the text for menu label
     */
    public BackGroundColorMenu(String s) {
        super(s);
        final ClockDataModel model = DigitalClock.getModel();
        for (final Color c : COLORS) {
            final JMenuItem mi = new JMenuItem(getColorName(c));
            add(mi);
            mi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setBgColor(c); 
                }
            });
        }
    }
}
