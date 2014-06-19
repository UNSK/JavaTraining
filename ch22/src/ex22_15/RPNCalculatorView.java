package ex22_15;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.omg.CORBA.PRIVATE_MEMBER;

public class RPNCalculatorView extends JFrame {

    private static final long serialVersionUID = 1L;

    public RPNCalculatorView() {
        getContentPane().setLayout(new BorderLayout());
        
        JTable stackTable = new JTable(RPNCalculatorModel.getTableModel());
        
        JScrollPane stackScroll = new JScrollPane(stackTable);
        stackScroll.setPreferredSize(new Dimension(200, 50));
        JPanel stackPanel = new JPanel();
        stackPanel.add(stackScroll);
        
        add(stackPanel);
        
        JPanel buttonPanel = initButtonsPanel();
        add(buttonPanel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setSize(300, 200);
        setVisible(true);
    }
    
    private JPanel initButtonsPanel() {
        JButton zero    = new JButton("0");
        JButton one     = new JButton("1");
        JButton two     = new JButton("2");
        JButton three   = new JButton("3");
        JButton four    = new JButton("4");
        JButton five    = new JButton("5");
        JButton six     = new JButton("6");
        JButton seven   = new JButton("7");
        JButton eight   = new JButton("8");
        JButton nine    = new JButton("9");
        JButton dot     = new JButton(".");
        
        JButton clear   = new JButton("c");
        JButton plus    = new JButton("+");
        JButton minus   = new JButton("-");
        JButton mul     = new JButton("×");
        JButton div     = new JButton("÷");
        JButton mod     = new JButton("%");
        JButton enter   = new JButton("enter");
        
        GridBagLayout gbl = new GridBagLayout();
        JPanel p = new JPanel(gbl);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(clear, gbc);
        
        gbc.gridx = 1;
        gbl.setConstraints(mod, gbc);
        
        gbc.gridx = 2;
        gbl.setConstraints(div, gbc);
        
        gbc.gridx = 3;
        gbl.setConstraints(mul, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbl.setConstraints(seven, gbc);
        
        gbc.gridx = 1;
        gbl.setConstraints(eight, gbc);
        
        gbc.gridx = 2;
        gbl.setConstraints(nine, gbc);

        gbc.gridx = 3;
        gbl.setConstraints(minus, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbl.setConstraints(four, gbc);
        
        gbc.gridx = 1;
        gbl.setConstraints(five, gbc);
        
        gbc.gridx = 2;
        gbl.setConstraints(six, gbc);
        
        gbc.gridx = 3;
        gbl.setConstraints(plus, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbl.setConstraints(one, gbc);
        
        gbc.gridx = 1;
        gbl.setConstraints(two, gbc);
        
        gbc.gridx = 2;
        gbl.setConstraints(three, gbc);
        
        gbc.gridx = 3;
        gbc.gridheight = 2;
        gbl.setConstraints(enter, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbl.setConstraints(zero, gbc);
        
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbl.setConstraints(dot, gbc);
        
        p.add(zero);
        p.add(one);
        p.add(two);
        p.add(three);
        p.add(four);
        p.add(five);
        p.add(six);
        p.add(seven);
        p.add(eight);
        p.add(nine);
        p.add(plus);
        p.add(minus);
        p.add(mul);
        p.add(div);
        p.add(mod);
        p.add(clear);
        p.add(enter);
        return p;
    }
}
