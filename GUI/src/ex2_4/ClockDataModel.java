package ex2_4;

import java.awt.Color;
import java.awt.Font;

/**
 * clock data (font, size, color...)
 */
public class ClockDataModel {
    private String fontName;
    private int fontSize;
    private Font clockFont;
    private Color fontColor;
    private Color bgColor;
    
    /** initialize clock data */
    public ClockDataModel() {
        fontName = Font.MONOSPACED;
        fontSize = 20;
        clockFont = new Font(fontName, Font.PLAIN, fontSize);
        fontColor = Color.BLACK;
        bgColor = Color.WHITE;
    }
    
    /**
     * @return the fontName
     */
    public String getFontName() {
        return fontName;
    }

    /**
     * @param fontName the fontName to set
     */
    public void setFontName(String fontName) {
        this.fontName = fontName;
    }
    
    /**
     * @return the fontSize
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize the fontSize to set
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * @return the clockFont
     */
    public Font getClockFont() {
        return clockFont;
    }
    /**
     * @return the fontColor
     */
    public Color getFontColor() {
        return fontColor;
    }
    /**
     * @return the bgColor
     */
    public Color getBgColor() {
        return bgColor;
    }
    /**
     * @param clockFont the clockFont to set
     */
    public void setClockFont(Font clockFont) {
        this.clockFont = clockFont;
    }
    /**
     * @param fontColor the fontColor to set
     */
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }
    /**
     * @param bgColor the bgColor to set
     */
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }
}
