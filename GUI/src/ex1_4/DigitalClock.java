package ex1_4;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.sql.Savepoint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.prefs.Preferences;

/**
 * 　課題1-2 メニューの追加、プロパティダイアログの追加
 * 		プロパティダイアログ内にフォント指定の追加
 * 		ダブルバッファリングの実装
 * 		フォントサイズに応じてフレームの大きさを変更
 */
public class DigitalClock extends Frame implements Runnable {
	/** serial version */
	private static final long serialVersionUID = 1L;
	/** 時計の表示フォーマット */
	private static final String CLOCK_PATTERN = "yyyy-MM-dd E HH:mm ss";
	/** タイマーのセット時間（秒） */
	private static int timerRemain = 0;
	/** is timer running */
	private static boolean isTimerRun = false;
	/** Thread */
	private Thread thread;
	
	/** Font Settings*/
	private Font clockFont; 
	/** Clock string color */
	private Color clockColor;
	/** frame background color */
	private Color bgColor;
	
	/** buffer strategy */
	private BufferStrategy buf;
	
	private Preferences pref;
	/** window location */
	private int wx, wy;
	
	/**
	 * set title, window size. add EventListener
	 * start thread
	 */
	public DigitalClock() {
		super("Digital Clock");
		setSize(500, 120);
		setResizable(false);
		setLayout(new FlowLayout(200));
		setMenuBar(new DCMenu(this).getMenuBar());
		loadPreference();
		setLocation(wx, wy);
		
		
		/* add set time field */
		TextField timerText = new TextField(8);
		add(timerText);
		timerText.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent textEvent) {
				TextField t = (TextField) textEvent.getSource();
				try {
					if (!isTimerRun) {
						timerRemain = Integer.parseInt(t.getText());
						repaint();
					} else {
						t.setText("");	
					}
				} catch (NumberFormatException e) {
					t.setText(""); // field clear
				}
			}
		});
		
		/* add timer start button */
		Button timerButton = new Button("Timer");
		add(timerButton);
		timerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isTimerRun) { // toggle switch
					isTimerRun = false;
				} else {
					isTimerRun = true;
				}
			}
		});
			
		addWindowListener(new WindowAdapter() {
			// close window
			@Override
			public void windowClosing(WindowEvent e) {
			    saveWindowPoint();
				System.exit(0);
			}
		});
		
		setVisible(true);
		createBufferStrategy(2);
		buf = getBufferStrategy();
		this.startThread();
	}

	/** Main method */
	public static void main(String[] args) {
		new DigitalClock();
	}

	@Override
	public void paint(Graphics g) {
		Graphics bufGraphics = buf.getDrawGraphics();
		if (!buf.contentsLost()) {
		setBackground(bgColor);
		bufGraphics.clearRect(0, 0, getSize().width, getSize().height);
		bufGraphics.setFont(clockFont);
		bufGraphics.setColor(clockColor);
		
		FontMetrics fm = bufGraphics.getFontMetrics();
		Rectangle textRec = fm.getStringBounds(
				fetchCurrentTime(), bufGraphics).getBounds();
		int newWidth = 200 + textRec.width;
		int newHeight = 120 + textRec.height;
		setSize(newWidth, newHeight);
		bufGraphics.drawString(fetchCurrentTime(), 100,
				120 - textRec.height/2 + fm.getMaxAscent());
		if (isTimerRun) {
			bufGraphics.drawString("Timer " 
					+ ((Integer) timerRemain) + " sec", 200, 90);
		} else {
			bufGraphics.drawString("      " 
					+ ((Integer) timerRemain) + " sec", 200, 90);
		}
		buf.show();
		bufGraphics.dispose();
		}
	}
	
	/**
	 * fetch current time to string
	 * @return フォーマットで指定された形式の現時刻を表す文字列
	 */
	public String fetchCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(CLOCK_PATTERN, Locale.US);
		return df.format(calendar.getTime());
	}

	/** start thread */
	public void startThread() {
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while (thread == Thread.currentThread()) {
			repaint();
			if (isTimerRun) {
				if (timerRemain == 0) {
					isTimerRun = false;
				} else {
					timerRemain--;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("thread failed");
			}
		}
	}
	
	void saveWindowPoint() {
	    pref.putInt("wx", this.getLocation().x);
	    pref.putInt("wy", this.getLocation().y);
	}
	
	private void loadPreference() {
	    pref = Preferences.userRoot().node("DCpreference_JavaTraining");
	    wx = pref.getInt("wx", 0);
	    wy = pref.getInt("wy", 0);
	    
	    setClockFont(new Font(
	            pref.get("fontName", Font.MONOSPACED), 
	            Font.PLAIN, 
	            pref.getInt("fontSize", 20)));
	    setClockColor(toColor(pref.get("fontColor", "Cyan")));
	    setBgColor(toColor(pref.get("bgColor", "Black")));
	}
	
	/** @param font the clockFont to set */
	public void setClockFont(Font font) {
		clockFont = font;
	}
	
	/** @return the ClockFont */
	public Font getClockFont() {
		return clockFont;
	}
	
	/** @param color the clockColor to set */
	public void setClockColor(Color color) {
		clockColor = color;
	}
	
	/** @return the clockColor */
	public Color getClockColor() {
		return clockColor;
	}
	
	/** @param color the bgColor to set */
	public void setBgColor(Color color) {
		bgColor = color;
	}
	
	/** @return the bgColor */
	public Color getBgColor() {
		return bgColor;
	}
	
	/** @return the pref */
	public Preferences getPref() {
	    return pref;
	}
	
	private Color toColor(String str) {
	    switch (str) {
	    case "Black":
	        return Color.BLACK;
	    case "Blue":
	        return Color.BLUE;
	    case "Cyan":
	        return Color.CYAN;
	    case "Dark Gray":
	        return Color.DARK_GRAY;
	    case "Gray":
	        return Color.GRAY;
	    case "Green":
	        return Color.GREEN;
	    case "Light Gray":
	        return Color.LIGHT_GRAY;
	    case "Magenta":
	        return Color.MAGENTA;
	    case "Orange":
	        return Color.ORANGE;
	    case "Pink":
	        return Color.PINK;
	    case "Red":
	        return Color.RED;
	    case "White":
	        return Color.WHITE;
	    case "Yellow":
	        return Color.YELLOW;
        default:
            throw new IllegalArgumentException();
	    }
	}
}
