package ex1_1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 　課題1-1 AWTのFrameを使用して、時間を表示するデジタル時計
 */
public class DigitalClock extends Frame implements Runnable {
	/** serial version */
	private static final long serialVersionUID = 1L;
	/** 時計の表示フォーマット */
	private static final String CLOCK_PATTERN = "yyyy-MM-dd E HH:mm ss";
	/** タイマーのセット時間（秒） */
	private static int timerRemain = 0;
	/** スレッド */
	private Thread thread;

	/**
	 * コンストラクタ
	 * タイトル表示、サイズ設定、WindowListnerを設定し、スレッドをスタートする
	 */
	public DigitalClock() {
		super("Digital Clock");
		setSize(500, 120);
		setVisible(true);
		setResizable(false);
		setLayout(new FlowLayout(200));
		Button TimerButton = new Button("timer");
		add(TimerButton);
		TimerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timerRemain = 5;
			}
		});
		addWindowListener(new WindowAdapter() {
			// ウィンドウを閉じる
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.startThread();
	}

	/** Main method */
	public static void main(String[] args) {
		new DigitalClock();
	}

	@Override
	public void paint(Graphics g) {
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		g.drawString(fetchCurrentTime(), 100, 65);
		if (timerRemain >= 0) {
			g.drawString(((Integer)timerRemain--).toString(), 200, 100);
		}
	}

	
	/**
	 * 文字列に変換した現在の時刻を取得する
	 * @return フォーマットで指定された形式の現時刻を表す文字列
	 */
	public String fetchCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(CLOCK_PATTERN, Locale.US);
		return df.format(calendar.getTime());
	}

	/** スレッドをスタートする */
	public void startThread() {
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while (thread == Thread.currentThread()) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("thread failed");
			}
		}
	}
}