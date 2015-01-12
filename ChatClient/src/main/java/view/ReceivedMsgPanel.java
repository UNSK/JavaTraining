package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReceivedMsgPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea receivedMsgArea;

	public ReceivedMsgPanel() {
		receivedMsgArea = new JTextArea();
		receivedMsgArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(receivedMsgArea);
		scrollPane.setPreferredSize(new Dimension(200,200));
		receivedMsgArea.append("hoge");
		add(scrollPane);
		//add(receivedMsgArea);
	}
	
	public JTextArea getReceivedMsgArea() {
		return receivedMsgArea;
	}
}
