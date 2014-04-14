package ex1_4;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Array;
import java.util.Set;
import java.util.prefs.Preferences;


/**
 * modal dialog
 */
public class PropertiesDialog extends Dialog {

	/** serial version */
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
	
	private GridBagLayout gbl = new GridBagLayout();

	/**
	 * @param parent parent frame
	 */
	public PropertiesDialog(final DigitalClock parent) {
		//set modal true
		super((Frame) parent, true);
		setTitle("Properties");
		//setSize(300,200);
		setResizable(false);
		
		Font currentFont = parent.getClockFont();
		Color currentClockColor = parent.getClockColor();
		Color currentBGColor = parent.getBgColor();
		
		/* font name choice */
		Label fontNameLabel = new Label("Font name: ");
		fontNameLabel.setAlignment(Label.RIGHT);
		addContent(fontNameLabel, 0, 0, 1);
		
		final Choice fontChoice = new Choice();
		GraphicsEnvironment ge =
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts = ge.getAvailableFontFamilyNames();
		for (String name : fonts) {
			fontChoice.add(name);
		}
		fontChoice.select(currentFont.getFamily());
		addContent(fontChoice, GridBagConstraints.RELATIVE, 0, 2);
		
		/* font size choice */
		Label fontSizeLabel = new Label("Font size: ");
		fontSizeLabel.setAlignment(Label.RIGHT);
		addContent(fontSizeLabel, 0, 1, 1);
		
		final Choice fsizeChoice = new Choice();
		for (int i = MIN_SIZE; i < MAX_SIZE; i += 2) {
			fsizeChoice.add(Integer.toString(i));
		}
		fsizeChoice.select(Integer.toString(currentFont.getSize()));
		addContent(fsizeChoice, GridBagConstraints.RELATIVE, 1, 2);
		
		/* font color */
		Label fontColorLabel = new Label("Font Color: ");
		fontColorLabel.setAlignment(Label.RIGHT);
		addContent(fontColorLabel, 0, 2, 1);
		
		final Choice fcolorChoice = new Choice();
		for (Color colors : COLORS) {
			fcolorChoice.add(getColorName(colors));
		}
		fcolorChoice.select(getColorName(currentClockColor));
		addContent(fcolorChoice, GridBagConstraints.RELATIVE, 2, 2);
		
		/* frame back ground color */
		Label bgColorLabel = new Label("Background Color: ");
		bgColorLabel.setAlignment(Label.RIGHT);
		addContent(bgColorLabel, 0, 3, 1);

		final Choice bgColorChoice = new Choice();
		for (Color colors : COLORS) {
			bgColorChoice.add(getColorName(colors));
		}
		bgColorChoice.select(getColorName(currentBGColor));
		addContent(bgColorChoice, GridBagConstraints.RELATIVE, 3, 2);
		
		//FIXME forcibly
		addContent(new Label(""), 0, 4, 1);
		
		Button okButton = new Button("Apply");
		addContent(okButton, 2, 4, 1, 60);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			    String fontName = fontChoice.getSelectedItem();
			    int fontSize = Integer.parseInt(fsizeChoice.getSelectedItem());
			    Color fontColor = COLORS[fcolorChoice.getSelectedIndex()];
			    Color bgColor = COLORS[bgColorChoice.getSelectedIndex()];
			    
				parent.setClockFont(new Font(fontName, Font.PLAIN, fontSize));
				parent.setClockColor(fontColor);
				parent.setBgColor(bgColor);
				
				Preferences pref = parent.getPref();
				pref.put("fontName", fontName);
				pref.putInt("fontSize", fontSize);
				pref.put("fontColor", getColorName(fontColor));
				pref.put("bgColor", getColorName(bgColor));
				
				setVisible(false);
			}
		});
		
		Button cancelButton = new Button("Cancel");
		addContent(cancelButton, 3, 4, 1);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				setVisible(false);
			}
		});
		
		setLayout(gbl);
		pack();
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
