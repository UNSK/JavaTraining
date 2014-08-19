package ex2_3;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.Timer;

class ClockPanel extends JPanel {
    /** serial */
    private static final long serialVersionUID = 1L;
	/** clock displaying format*/
	private static final String CLOCK_PATTERN = "yyyy-MM-dd E HH:mm ss";
	/** clock data */
	private ClockDataModel model;
	
	/** panel width */
	private int width = 500;
	/** panel height */
	private int height = 120;
	

    /**
     * construct ClockPanel and start Timer
     */
    public ClockPanel() {
        model = DigitalClock.getModel();
        Timer t1 = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        t1.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(model.getClockFont());
        g.setColor(model.getFontColor());
        setBackground(model.getBgColor());
        
        FontMetrics fm = g.getFontMetrics();
        Rectangle textRec = fm.getStringBounds(
                fetchCurrentTime(), g).getBounds();
        width  = 200 + textRec.width;
        height = 120 + textRec.height;
        setSize(width, height);
        g.drawString(fetchCurrentTime(), 100, height / 2);
//                textRec.height / 2 + fm.getMaxAscent());
    }
    
    /**
     * fetch current time to string
     * @return formatted string 
     */
    public String fetchCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(CLOCK_PATTERN, Locale.US);
        return df.format(calendar.getTime());
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
}
