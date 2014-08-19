package ex2_3;

import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;





/**
 * Digital Clock main class
 */
public class DigitalClock extends JWindow {

    /** the serial version UID */
    private static final long serialVersionUID = 1L;
    
    /** clock data model */
    private static ClockDataModel model;
    /** Location of mouse cursor when mouse pressed */
    private Point cursorLocation;
    
    /**
     * Constructs digital clock
     */
    public DigitalClock() {
        super(new JFrame());
        model = new ClockDataModel();
        setSize(500, 120);
        
        ClockPanel clockPanel = new ClockPanel();
        clockPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setSize(e.getComponent().getPreferredSize());
            }
        });
        getContentPane().add(clockPanel);
        
        final JPopupMenu popupMenu = new ClockPopupMenu();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(DigitalClock.this, e.getX(), e.getY());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                cursorLocation = e.getPoint();
            }
        });

        // TODO listen left button only
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point draggedPoint = e.getPoint();
                int xDistance = cursorLocation.x - draggedPoint.x;
                int yDistance = cursorLocation.y - draggedPoint.y;
                DigitalClock.this.setLocation(getLocation().x - xDistance,
                        getLocation().y - yDistance);
            }

        });
        
        
        pack();
        setVisible(true);
    }
    
    /**
     * start digital clock
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
