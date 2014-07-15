package ex2_2;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Digital Clock");
        setSize(500, 120);
        setResizable(false);
        
        ClockPanel clockPanel = new ClockPanel();
        clockPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setSize(e.getComponent().getPreferredSize());
            }
        });
        getContentPane().add(clockPanel);
        setJMenuBar(new ClockMenu());
        
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
