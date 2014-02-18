package ex1_2;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Array;
import java.util.Set;


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
		Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	/**
	 * @param parent parent frame
	 */
	public PropertiesDialog(final DigitalClock parent) {
		//set modal true
		super((Frame) parent, true);
		setTitle("Properties");
		//setSize(300,200);
		setResizable(false);
		setLayout(new GridLayout(6, 2));
		
		Font currentFont = parent.getClockFont();
		Color currentClockColor = parent.getClockColor();
		Color currentBGColor = parent.getBgColor();
		
		/* font name choice */
		Label fontNameLabel = new Label("Font name: ");
		add(fontNameLabel);
		final Choice fontChoice = new Choice();
		GraphicsEnvironment ge =
				GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts = ge.getAvailableFontFamilyNames();
		for (String name : fonts) {
			fontChoice.add(name);
		}
		fontChoice.select(currentFont.getFamily());
		add(fontChoice);
		
		/* font size choice */
		Label fontSizeLabel = new Label("Font size: ");
		add(fontSizeLabel);
		final Choice fsizeChoice = new Choice();
		for (int i = MIN_SIZE; i < MAX_SIZE; i += 2) {
			fsizeChoice.add(Integer.toString(i));
		}
		fsizeChoice.select(Integer.toString(currentFont.getSize()));
		add(fsizeChoice);
		
		/* font color */
		Label fontColorLabel = new Label("Font Color: ");
		add(fontColorLabel);
		final Choice fcolorChoice = new Choice();
		for (Color colors : COLORS) {
			fcolorChoice.add(getColorName(colors));
		}
		fcolorChoice.select(getColorName(currentClockColor));
		add(fcolorChoice);
		
		/* frame back ground color */
		Label bgColorLabel = new Label("Background Color: ");
		add(bgColorLabel);
		final Choice bgColorChoice = new Choice();
		for (Color colors : COLORS) {
			bgColorChoice.add(getColorName(colors));
		}
		bgColorChoice.select(getColorName(currentBGColor));
		add(bgColorChoice);
		
		Button okButton = new Button("Apply");
		this.add(okButton);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fontChoice.getSelectedItem();
				parent.setClockFont(new Font(
						fontChoice.getSelectedItem(), 
						Font.PLAIN, 
						Integer.parseInt(fsizeChoice.getSelectedItem())));
				parent.setClockColor(COLORS[fcolorChoice.getSelectedIndex()]);
				parent.setBgColor(COLORS[bgColorChoice.getSelectedIndex()]);
				setVisible(false);
			}
		});
		
		Button cancelButton = new Button("Cancel");
		this.add(cancelButton);
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
		
		pack();
 	}
	
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
