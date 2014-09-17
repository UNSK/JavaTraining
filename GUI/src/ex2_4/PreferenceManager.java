package ex2_4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.prefs.Preferences;

/**
 *
 */
final class PreferenceManager {
    
    /** the instance of PreferenceManager */
    private static final PreferenceManager INSTANCE = new PreferenceManager();
    /** preference root name */
    private static final String PREF_ROOT = "DigitalClock_JavaTraining";
    /** the clock model */
    private ClockDataModel model = DigitalClock.getModel();
    /** Preference */
    private Preferences pref;
    
    /**
     * constructor
     */
    private PreferenceManager() {
        pref = Preferences.userRoot().node(PREF_ROOT);
    }
    
    /**
     * save the window location.
     * @param p the Point of Window Location
     */
    public void saveWindowLocation(Point p) {
        pref.putInt("wx", p.x);
        pref.putInt("wy", p.y);
    }
    
    /**
     * load then return window location.
     * @return the Point of window location
     */
    public Point loadWindowLocation() {
        return new Point(pref.getInt("wx", 0),
                         pref.getInt("wy", 0));
    }
    
    /**
     * save the appearance of the clock.
     * (font name, font size, font color, and background color)
     */
    public void saveAppearance() {
        pref.put("fontName", model.getFontName());
        pref.putInt("fontSize", model.getFontSize());
        pref.put("fontColor", getColorName(model.getFontColor()));
        pref.put("bgColor", getColorName(model.getBgColor()));
    }
    
    /**
     * load then set the appearance of the clock.
     */
    public void loadAppearance() {
        model.setClockFont(new Font(
                pref.get("fontName", Font.MONOSPACED), 
                Font.PLAIN, 
                pref.getInt("fontSize", 20)));
        model.setFontColor(fromString(pref.get("fontColor", "Cyan")));
        model.setBgColor(fromString(pref.get("bgColor", "Black")));
    }

    /**
     * return this instance.
     * PreferenceManager is the Singleton Class.
     * @return instance of this class
     */
    public static PreferenceManager getInstance() {
        return INSTANCE;
    }
    
    /** 
     * Color to String 
     * @param str the color name
     * @return the Color instance
     */
    private Color fromString(String str) {
        switch (str) {
        case "Black":
            return Color.BLACK;
        case "Blue":
            return Color.BLUE;
        case "Cyan":
            return Color.CYAN;
        case "Dark Gray":
            return Color.DARK_GRAY;
        case "Gray":
            return Color.GRAY;
        case "Green":
            return Color.GREEN;
        case "Light Gray":
            return Color.LIGHT_GRAY;
        case "Magenta":
            return Color.MAGENTA;
        case "Orange":
            return Color.ORANGE;
        case "Pink":
            return Color.PINK;
        case "Red":
            return Color.RED;
        case "White":
            return Color.WHITE;
        case "Yellow":
            return Color.YELLOW;
        default:
            throw new AssertionError();
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
}
