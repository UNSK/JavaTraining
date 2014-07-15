package ex2_2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class ColorChipIcon implements Icon {
    
    private Color color;
    private static final int SIDE = 13;
    
    public ColorChipIcon(Color c) {
        this.color = c;
    }
    
    @Override
    public int getIconHeight() {
        return SIDE;
    }

    @Override
    public int getIconWidth() {
        return SIDE;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillRect(x, y, getIconWidth(), getIconHeight());
    }

}
