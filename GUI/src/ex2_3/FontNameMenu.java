package ex2_3;

import java.awt.GraphicsEnvironment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * font name menu
 */
class FontNameMenu extends JMenu {
    /** the serial version UID */
    private static final long serialVersionUID = 1L;

    /**
     * constructs new font name menu with supplied String as its text.
     * @param s the text for menu label
     */
    public FontNameMenu(String s) {
        super(s);
        final ClockDataModel model = DigitalClock.getModel();
        
        GraphicsEnvironment ge = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        for (String name : fonts) {
            final JMenuItem mi = new JMenuItem(name);
            add(mi);
            mi.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setFontName(mi.getText());
                    model.renewFont();
                }
            });
        }
    }
}
