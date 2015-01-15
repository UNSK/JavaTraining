package view.digitalclock;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ClockPanel extends JPanel {
    /** serial */
    private static final long serialVersionUID = 1L;
	/** clock displaying format*/
	private static final String CLOCK_PATTERN = "yyyy-MM-dd E HH:mm ss";

    /**
     * construct ClockPanel and start Timer
     */
    public ClockPanel() {
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
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        g.drawString(fetchCurrentTime(), 20, 20);
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
        return new Dimension(500, 25);
    }
}
