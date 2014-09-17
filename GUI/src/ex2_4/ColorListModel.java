package ex2_4;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

/**
 * color name with color chip icon
 */
public class ColorListModel extends DefaultComboBoxModel<Map<String, Object>> {
    /** serial */
    private static final long serialVersionUID = 1L;
    
    /** color choices */
    private static final Color[] COLORS = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, 
        Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
        };
    
    /** construct model */
    public ColorListModel() {
        Icon icon;
        for (Color c : COLORS) {
            icon = new ColorChipIcon(c);
            Map<String, Object> map = new HashMap<>();
            map.put("label", getColorName(c));
            map.put("icon", icon);
            map.put("color", c);
            addElement(map);
        }
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
     * return color index of this model
     * @param color the color
     * @return index or IllegalArgumentException
     */
    public int getColorIndex(Color color) {
        int i;
        for (i = 0; i < COLORS.length; i++) {
            if (color.equals(COLORS[i])) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }
}
