package ex2_2;

import javax.swing.JFrame;

/**
 * Digital clock 
 * using Swing.JFrame
 */
public class DigitalClock extends JFrame {
    /** serial */
    private static final long serialVersionUID = 1L;
    
    public DigitalClock() {
        super("Digital Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Digital Clock");
        setSize(500, 120);
        setResizable(false);
        
        getContentPane().add(new ClockPanel());
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
    
    
    
}
