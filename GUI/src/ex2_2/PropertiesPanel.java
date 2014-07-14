package ex2_2;

import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 */
public class PropertiesPanel extends JPanel {

    /** serial */
    private static final long serialVersionUID = 1L;

    /** minimal font size */
    private static final int MIN_SIZE = 20;
    /** max font size */
    private static final int MAX_SIZE = 80;
    /** color choices */
    private static final Color[] COLORS = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, 
        Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
        };
    
    /** layout */
    private GridBagLayout gbl = new GridBagLayout(); 
    
    public PropertiesPanel() {
        
        // font name
        JLabel fontNameLabel = new JLabel("Font name: ");
        fontNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addContent(fontNameLabel, 0, 0, 1);
        
        GraphicsEnvironment ge = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        JComboBox<String> fontNameBox = new JComboBox<>(fonts);
        addContent(fontNameBox, 1, 0, 1);
        
        // font size
        JLabel fontSizeLabel = new JLabel("Font size: ");
        fontSizeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addContent(fontSizeLabel, 0, 1, 1);
        
        JComboBox<Integer> fontSizeBox = new JComboBox<>();
        for (int i = MIN_SIZE; i < MAX_SIZE; i += 2) {
            fontSizeBox.addItem(i);
        }
        addContent(fontSizeBox, 1, 1, 1);
        
        // color
        JLabel fontColorLabel = new JLabel("Font Color: ");
        fontColorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addContent(fontColorLabel, 0, 2, 1);
        
        //TODO color chips
        JComboBox<?> fontColorBox = new JComboBox<>();
        addContent(fontColorBox, 1, 2, 1);
        
        JLabel bgColorLabel = new JLabel("Background Color: ");
        bgColorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addContent(bgColorLabel, 0, 3, 1);
        
        //TODO color chips
        JComboBox<?> bgColorBox = new JComboBox<>();
        addContent(bgColorBox, 1, 3, 1);
        
        
        
        setLayout(gbl);
    }
    
    
    /**
     * get color name from java.awt.Color
     * @param color java.awt.Color
     * @return color name string
     */
    private String getColorName(Color color) {
        if (color == Color.BLACK) {
            return "Black";
        } else if (color == Color.BLUE) {
            return "Blue";
        } else if (color == Color.CYAN) {
            return "Cyan";
        } else if (color == Color.DARK_GRAY) {
            return "Dark Gray";
        } else if (color == Color.GRAY) {
            return "Gray";
        } else if (color == Color.GREEN) {
            return "Green";
        } else if (color == Color.LIGHT_GRAY) {
            return "Light Gray";
        } else if (color == Color.MAGENTA) {
            return "Magenta";
        } else if (color == Color.ORANGE) {
            return "Orange";
        } else if (color == Color.PINK) {
            return "Pink";
        } else if (color == Color.RED) {
            return "Red";
        } else if (color == Color.WHITE) {
            return "White";
        } else if (color == Color.YELLOW) {
            return "Yellow";
        } else {
            return color.toString();
        }
    }
    
    /**
     * add a content to GridBagLayout
     * @param c component
     * @param x grid x
     * @param y grid y
     * @param w grid width
     */
    private void addContent(Component c, int x, int y, int w) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbl.setConstraints(c, gbc);
        add(c);
    }
    
    /**
     * add a content to GridBagLayout
     * @param c component
     * @param x grid x
     * @param y grid y
     * @param w grid width
     * @param ipadx padding
     */
    private void addContent(Component c, int x, int y, int w, int ipadx) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.ipadx = ipadx;
        gbl.setConstraints(c, gbc);
        add(c);
    }
}
