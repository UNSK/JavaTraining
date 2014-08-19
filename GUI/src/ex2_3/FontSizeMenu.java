package ex2_3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * font size menu
 */
class FontSizeMenu extends JMenu {
    /** the serial version UID */
    private static final long serialVersionUID = 1L;
    
    /** minimal font size */
    private static final int MIN_SIZE = 20;
    /** max font size */
    private static final int MAX_SIZE = 80;

    /**
     * constructs new font size menu with supplied String as its text.
     * @param s the text for menu label
     */
    public FontSizeMenu(String s) {
        super(s);
        final ClockDataModel model = DigitalClock.getModel();
        
        for (int i = MIN_SIZE; i < MAX_SIZE; i += 2) {
            final JMenuItem mi = new JMenuItem(Integer.toString(i));
            add(mi);
            mi.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setFontSize(Integer.parseInt(mi.getText()));
                    model.renewFont();
                }
            });
        }
    }
}
