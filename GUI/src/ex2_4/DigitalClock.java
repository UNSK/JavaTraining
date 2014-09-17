package ex2_4;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Digital clock 
 * using Swing.JFrame
 */
public class DigitalClock extends JFrame {
    /** serial */
    private static final long serialVersionUID = 1L;
    /** clock data model */
    private static ClockDataModel model;
    
    public DigitalClock() {
        super("Digital Clock");
        model = new ClockDataModel();
        final PreferenceManager prefManager = PreferenceManager.getInstance();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Digital Clock");
        setSize(500, 120);
        setResizable(false);
        
        //load and set window location from preference
        setLocation(prefManager.loadWindowLocation());
        prefManager.loadAppearance();
        
        ClockPanel clockPanel = new ClockPanel();
        clockPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setSize(e.getComponent().getPreferredSize());
            }
        });
        getContentPane().add(clockPanel);
        setJMenuBar(new ClockMenu());
        
        addWindowListener(new WindowAdapter() {
            // close window
            @Override
            public void windowClosing(WindowEvent e) {
                prefManager.saveWindowLocation(getLocation());
                prefManager.saveAppearance();
                System.exit(0);
            }
        });
        
        pack();
        setVisible(true);
    }
    
    /**
     * start Digital Clock
     * @param args not to use
     */
    public static void main(String[] args) {
        new DigitalClock();
    }

    /**
     * @return the model
     */
    public static ClockDataModel getModel() {
        return model;
    }
    
}
