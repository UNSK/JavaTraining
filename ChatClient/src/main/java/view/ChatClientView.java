package view;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ChatClientView extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ReceivedMsgPanel receivedMsgPanel;
	
	public ChatClientView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("chat");
		setSize(500, 500);
		
		receivedMsgPanel = new ReceivedMsgPanel();
//		reciptMsgPanel.addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentResized(ComponentEvent e) {
//				setSize(e.getComponent().getPreferredSize());
//			}
//		});
		getContentPane().add(receivedMsgPanel, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ChatClientView();
	}
	
	public void showReceivedMsg(String s) {
		receivedMsgPanel.getReceivedMsgArea().append(s + "%n");
	}
}
