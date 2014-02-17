package ex1_2;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyEditorSupport;
import java.util.ListResourceBundle;

/**
 * modal dialog
 */
public class PropertiesDialog extends Dialog {

	/** serial version */
	private static final long serialVersionUID = 1L;
	
	private PropertyChangeSupport changes;

	/**
	 * @param parent parent frame
	 */
	public PropertiesDialog(final DigitalClock parent) {
		//set modal true
		super((Frame) parent, true);
		setTitle("Properties");
		setSize(200,100);
		setResizable(true);
		setLayout(new FlowLayout());
		
		final Choice fontChoice = new Choice();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fonts = ge.getAvailableFontFamilyNames();
		for (String name : fonts) {
			fontChoice.add(name);
		}
		add(fontChoice);
		
		Button okButton = new Button("OK");
		this.add(okButton);
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fontChoice.getSelectedItem();
				parent.setClockFont(new Font(fontChoice.getSelectedItem(), Font.PLAIN, 30));
				setVisible(false);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				setVisible(false);
			}
		});
 	}

}
