package ex2_2;

import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;

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
    private static final int MIN_SIZE = 10;
    /** max font size */
    private static final int MAX_SIZE = 70;
   
    
    /** layout */
    private GridBagLayout gbl = new GridBagLayout(); 
    
    private JComboBox<String> fontNameBox;
    private JComboBox<Integer> fontSizeBox;
    private JComboBox<Map<String, Object>> fontColorBox;
    private JComboBox<Map<String, Object>> bgColorBox;
    
    public PropertiesPanel() {
        ClockDataModel model = DigitalClock.getModel();
        
        // font name
        JLabel fontNameLabel = new JLabel("Font name: ");
        fontNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addContent(fontNameLabel, 0, 0, 1);
        
        GraphicsEnvironment ge = 
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        fontNameBox = new JComboBox<>(fonts);
        fontNameBox.setSelectedItem(model.getFontName());
        addContent(fontNameBox, 1, 0, 1);
        
        // font size
        JLabel fontSizeLabel = new JLabel("Font size: ");
        fontSizeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addContent(fontSizeLabel, 0, 1, 1);
        
        fontSizeBox = new JComboBox<>();
        for (int i = MIN_SIZE; i < MAX_SIZE; i += 2) {
            fontSizeBox.addItem(i);
        }
        fontSizeBox.setSelectedItem(model.getFontSize());
        addContent(fontSizeBox, 1, 1, 1);
        
        // color  
        ColorListRenderer renderer = new ColorListRenderer();
        
        // clock color
        JLabel fontColorLabel = new JLabel("Font Color: ");
        fontColorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addContent(fontColorLabel, 0, 2, 1);
        
        ColorListModel fontColorModel = new ColorListModel();
        fontColorBox = new JComboBox<>(fontColorModel);
        fontColorBox.setSelectedIndex(fontColorModel.getColorIndex(model.getFontColor()));
        fontColorBox.setRenderer(renderer);
        addContent(fontColorBox, 1, 2, 1);
        
        // back ground color
        JLabel bgColorLabel = new JLabel("Background Color: ");
        bgColorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addContent(bgColorLabel, 0, 3, 1);
        
        ColorListModel bgColorModel = new ColorListModel();
        bgColorBox = new JComboBox<>(bgColorModel);
        bgColorBox.setSelectedIndex(bgColorModel.getColorIndex(model.getBgColor()));
        bgColorBox.setRenderer(renderer);
        addContent(bgColorBox, 1, 3, 1);
        
        setLayout(gbl);
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
     * @return the fontNameBox
     */
    public JComboBox<String> getFontNameBox() {
        return fontNameBox;
    }
    
    /**
     * @return the fontSizeBox
     */
    public JComboBox<Integer> getFontSizeBox() {
        return fontSizeBox;
    }

    /**
     * @return the fontColorBox
     */
    public JComboBox<Map<String, Object>> getFontColorBox() {
        return fontColorBox;
    }

    /**
     * @return the bgColorBox
     */
    public JComboBox<Map<String, Object>> getBgColorBox() {
        return bgColorBox;
    }
}
