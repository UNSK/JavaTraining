package ex2_3;

import java.awt.Color;

import javax.swing.JMenu;


/**
 * color menu
 */
class ColorMenu extends JMenu {
    /** the serial version UID */
    private static final long serialVersionUID = 1L;
    
    /** available color list */
    protected static final Color[] COLORS = { Color.BLACK, Color.BLUE,
            Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
            Color.RED, Color.WHITE, Color.YELLOW };
    
    /**
     * constructs new menu with supplied String as its text.
     * @param s the text for menu label
     */
    protected ColorMenu(String s) {
        super(s);
    }
    
    /**
     * convert Color to the color name
     * @param color
     *            to be convert String
     * @return String for color name
     */
    protected String getColorName(Color color) {
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
}
