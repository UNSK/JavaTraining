package ex1_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * MenuBar
 */
public class DCMenu extends PopupMenu {
    /** serial version */
    private static final long serialVersionUID = 1L;

    /** minimal font size */
    private static final int MIN_SIZE = 20;
    /** max font size */
    private static final int MAX_SIZE = 80;
    /** available color list */
    private static final Color[] COLORS = { Color.BLACK, Color.BLUE,
            Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
            Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
            Color.RED, Color.WHITE, Color.YELLOW };

    /**
     * constructor
     */
    public DCMenu(final DigitalClock parent) {
        super();

        /* make color map. (K, V) = (color name, awt.Color) */
        Map<String, Color> colorMap = new HashMap<>();
        for (Color colors : COLORS) {
            colorMap.put(getColorName(colors), colors);
        }

        Menu mProperties = new Menu("Properties");
        Menu mFontName = new Menu("Font name");
        Menu mFontSize = new Menu("Font Size");
        Menu mFontColor = new Menu("Font Color");
        Menu mBGColor = new Menu("BGColor");
        MenuItem mExit = new MenuItem("Exit");

        /* add font name MenuItems */
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames(Locale.US);
        for (String name : fonts) {
            final MenuItem mi = new MenuItem(name);
            mFontName.add(mi);
            mi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Font oldFont = parent.getClockFont();
                    Font newFont = new Font(mi.getLabel(), oldFont.getStyle(),
                            oldFont.getSize());
                    parent.setClockFont(newFont);
                }
            });
        }

        /* add font size MenuItems */
        for (int i = MIN_SIZE; i < MAX_SIZE; i += 2) {
            final MenuItem mi = new MenuItem(Integer.toString(i));
            mFontSize.add(mi);
            mi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Font oldFont = parent.getClockFont();
                    Font newFont = new Font(oldFont.getFontName(), oldFont
                            .getStyle(), Integer.parseInt(mi.getLabel()));
                    parent.setClockFont(newFont);
                }
            });
        }

        /* add font color and bg color MenuItems */
        for (final Map.Entry<String, Color> entry : colorMap.entrySet()) {
            final MenuItem fontColoritem = new MenuItem(entry.getKey());
            final MenuItem bgColoritem = new MenuItem(entry.getKey());
            mFontColor.add(fontColoritem);
            mBGColor.add(bgColoritem);

            fontColoritem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parent.setClockColor(entry.getValue());
                }
            });

            bgColoritem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parent.setBgColor(entry.getValue());
                }
            });
        }

        mProperties.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                // PropertiesDialog dialog = new PropertiesDialog(frame);
                // dialog.setVisible(true);
            }
        });

        mExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(mProperties);
        mProperties.add(mFontName);
        mProperties.add(mFontColor);
        mProperties.add(mFontSize);
        mProperties.add(mBGColor);
        this.add(mExit);
    }

    /**
     * convert Color to the color name
     * 
     * @param color
     *            to be convert String
     * @return String for color name
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
