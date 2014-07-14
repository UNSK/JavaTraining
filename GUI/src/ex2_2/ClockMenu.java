package ex2_2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                JOptionPane.showConfirmDialog(null, new PropertiesPanel(),
                        "Properties", JOptionPane.OK_CANCEL_OPTION);
            }
        });
        
        
        fileMenu.add(propertyItem);
        fileMenu.add(exitItem);
        
        add(fileMenu);
    }
}
