package ex2_2;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


/**
 * Menu bar for digital clock
 */
public class ClockMenu extends JMenuBar {
    /** serial */
    private static final long serialVersionUID = 1L;
    
    
    public ClockMenu() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem propertyItem = new JMenuItem("Properties");
        
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        propertyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ret;
                PropertiesPanel prop = new PropertiesPanel();
                ClockDataModel model = DigitalClock.getModel();
                ret = JOptionPane.showConfirmDialog(null, prop,
                        "Properties", JOptionPane.OK_CANCEL_OPTION);
                switch (ret) {
                case JOptionPane.OK_OPTION:
                    String fontName = (String) prop.getFontNameBox().getSelectedItem();
                    int fontSize = (int) prop.getFontSizeBox().getSelectedItem();
                    @SuppressWarnings("unchecked")
                    Color fontColor =
                        (Color) ((Map<String, Object>) prop.getFontColorBox().getSelectedItem()).get("color");
                    @SuppressWarnings("unchecked")
                    Color bgColor =
                        (Color) ((Map<String, Object>) prop.getBgColorBox().getSelectedItem()).get("color");
                            
                    model.setFontName(fontName);
                    model.setFontSize(fontSize);
                    model.setClockFont(new Font(fontName, Font.PLAIN, fontSize));
                    model.setFontColor(fontColor);
                    model.setBgColor(bgColor);
                    break;
                case JOptionPane.CANCEL_OPTION:
                case JOptionPane.CLOSED_OPTION:
                    // nop
                    break;
                default:
                    throw new AssertionError();
                }
                
            }
        });
        
        
        fileMenu.add(propertyItem);
        fileMenu.add(exitItem);
        
        add(fileMenu);
    }
}
