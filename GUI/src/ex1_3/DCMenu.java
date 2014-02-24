package ex1_3;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * MenuBar 
 */
public class DCMenu extends PopupMenu {
	/** serial version */
	private static final long serialVersionUID = 1L;
	
	/**
	 * constructor 
	 */
	public DCMenu() {
		super();
		//MenuBar menuBar = new MenuBar();
		
		Menu menuMain = new Menu("Menu");
		MenuItem mProperties = new MenuItem("Properties");
		MenuItem mExit = new MenuItem("Exit");
		
		mProperties.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//PropertiesDialog dialog = new PropertiesDialog(frame);
				//dialog.setVisible(true);
			}
		});
		
		mExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menuMain.add(mProperties);
		menuMain.add(mExit);
		this.add(menuMain);
		//setMenuBar(menuBar);
	}

}
