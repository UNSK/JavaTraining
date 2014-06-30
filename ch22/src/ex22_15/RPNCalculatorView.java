package ex22_15;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RPNCalculatorView extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private JTextField stackField1 = new JTextField(10);
    private JTextField stackField2 = new JTextField(10);
    private JTextField stackField3 = new JTextField(10);
    private JTextField stackField4 = new JTextField(10);
    private JTextField stackField5 = new JTextField(10);

    private JButton[] numButtons = new JButton[10];
    private JButton dotButton;
    private JButton clearButton;
    private JButton plusButton;
    private JButton minusButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton modButton;
    private JButton enterButton;
    
    //math button
    private JButton sinButton;
    private JButton cosButton;
    private JButton tanButton;
    private JButton asinButton;
    private JButton acosButton;
    private JButton atanButton;
    private JButton atan2Button;
    private JButton toRadiansButton;
    private JButton toDegreesButton;
    private JButton expButton;
    private JButton sinhButton;
    private JButton coshButton;
    private JButton tanhButton;
    private JButton powButton;
    private JButton logButton;
    private JButton log10Button;
    private JButton sqrtButton;
    private JButton cbrtButton;
    private JButton signumButton;
    private JButton ceilButton;
    private JButton floorButton;
    private JButton rintButton;
    private JButton roundButton;
    private JButton absButton;
    private JButton maxButton;
    private JButton minButton;
    private JButton hypotButton;
    
    private JLabel statusBar;
    
    public RPNCalculatorView() {
        getContentPane().setLayout(new BorderLayout());

        stackField1.setHorizontalAlignment(JTextField.RIGHT);
        stackField2.setHorizontalAlignment(JTextField.RIGHT);
        stackField3.setHorizontalAlignment(JTextField.RIGHT);
        stackField4.setHorizontalAlignment(JTextField.RIGHT);
        stackField5.setHorizontalAlignment(JTextField.RIGHT);
        stackField1.setEditable(true);
        stackField2.setEditable(false);
        stackField3.setEditable(false);
        stackField4.setEditable(false);
        stackField5.setEditable(false);

        JPanel stackPanel = new JPanel(new GridLayout(5, 1));
        stackPanel.add(stackField5);
        stackPanel.add(stackField4);
        stackPanel.add(stackField3);
        stackPanel.add(stackField2);
        stackPanel.add(stackField1);
        
        getContentPane().add(stackPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = initButtonsPanel();
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        
        JPanel mathPanel = initMathPanel();
        getContentPane().add(mathPanel, BorderLayout.WEST);
        
        statusBar = new JLabel("Ready");
        add(statusBar, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setResizable(false);
        setSize(850, 350);
        setVisible(true);
    }
    
    private JPanel initButtonsPanel() {
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(Integer.toString(i));
        }

        dotButton     = new JButton(".");
        
        clearButton   = new JButton("c");
        plusButton    = new JButton("+");
        minusButton   = new JButton("-");
        mulButton     = new JButton("×");
        divButton     = new JButton("÷");
        modButton     = new JButton("%");
        enterButton   = new JButton("enter");
        
        //set layout
        GridBagLayout gbl = new GridBagLayout();
        JPanel p = new JPanel(gbl);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbl.setConstraints(clearButton, gbc);
        
        gbc.gridx = 1;
        gbl.setConstraints(modButton, gbc);
        
        gbc.gridx = 2;
        gbl.setConstraints(divButton, gbc);
        
        gbc.gridx = 3;
        gbl.setConstraints(mulButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbl.setConstraints(numButtons[7], gbc);
        
        gbc.gridx = 1;
        gbl.setConstraints(numButtons[8], gbc);
        
        gbc.gridx = 2;
        gbl.setConstraints(numButtons[9], gbc);

        gbc.gridx = 3;
        gbl.setConstraints(minusButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbl.setConstraints(numButtons[4], gbc);
        
        gbc.gridx = 1;
        gbl.setConstraints(numButtons[5], gbc);
        
        gbc.gridx = 2;
        gbl.setConstraints(numButtons[6], gbc);
        
        gbc.gridx = 3;
        gbl.setConstraints(plusButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbl.setConstraints(numButtons[1], gbc);
        
        gbc.gridx = 1;
        gbl.setConstraints(numButtons[2], gbc);
        
        gbc.gridx = 2;
        gbl.setConstraints(numButtons[3], gbc);
        
        gbc.gridx = 3;
        gbc.gridheight = 2;
        gbl.setConstraints(enterButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbl.setConstraints(numButtons[0], gbc);
        
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbl.setConstraints(dotButton, gbc);

        //add to panel
        p.add(numButtons[0]);
        p.add(numButtons[1]);
        p.add(numButtons[2]);
        p.add(numButtons[3]);
        p.add(numButtons[4]);
        p.add(numButtons[5]);
        p.add(numButtons[6]);
        p.add(numButtons[7]);
        p.add(numButtons[8]);
        p.add(numButtons[9]);
        p.add(dotButton);
        p.add(plusButton);
        p.add(minusButton);
        p.add(mulButton);
        p.add(divButton);
        p.add(modButton);
        p.add(clearButton);
        p.add(enterButton);
        pack();
        return p;
    }
    
    private JPanel initMathPanel() {
        
    sinButton    = new JButton("sin");
    cosButton    = new JButton("cos");
    tanButton    = new JButton("tan");
    asinButton   = new JButton("asin");
    acosButton   = new JButton("acos");
    atanButton   = new JButton("atan");
    atan2Button  = new JButton("atan2");
    toRadiansButton  = new JButton("toRad");
    toDegreesButton  = new JButton("toDeg");
    expButton    = new JButton("exp");
    sinhButton   = new JButton("sinh");
    coshButton   = new JButton("cosh");
    tanhButton   = new JButton("tanh");
    powButton    = new JButton("pow");
    logButton    = new JButton("log");
    log10Button  = new JButton("log10");
    sqrtButton   = new JButton("sqrt");
    cbrtButton   = new JButton("cbrt");
    signumButton     = new JButton("signum");
    ceilButton   = new JButton("ceil");
    floorButton  = new JButton("floor");
    rintButton   = new JButton("rint");
    roundButton  = new JButton("round");
    absButton    = new JButton("abs");
    maxButton    = new JButton("max");
    minButton    = new JButton("min");
    hypotButton  = new JButton("hypot");

    //set layout
    GridBagLayout gbl = new GridBagLayout();
    JPanel p = new JPanel(gbl);
    
    GridBagConstraints gbc = new GridBagConstraints();
    
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.fill = GridBagConstraints.BOTH;
    gbl.setConstraints(sinButton, gbc);
    
    gbc.gridx = 1;
    gbl.setConstraints(cosButton, gbc);
    
    gbc.gridx = 2;
    gbl.setConstraints(tanButton, gbc);
    
    gbc.gridx = 3;
    gbl.setConstraints(asinButton, gbc);
    
    gbc.gridx = 4;
    gbl.setConstraints(acosButton, gbc);
    
    gbc.gridx = 5;
    gbl.setConstraints(atanButton, gbc);
    
    gbc.gridx = 6;
    gbl.setConstraints(atan2Button, gbc);
    
    gbc.gridx = 7;
    gbl.setConstraints(sinhButton, gbc);
    
    gbc.gridx = 8;
    gbl.setConstraints(coshButton, gbc);
    
    gbc.gridx = 9;
    gbl.setConstraints(tanhButton, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbl.setConstraints(expButton, gbc);
    
    gbc.gridx = 1;
    gbl.setConstraints(powButton, gbc);
    
    gbc.gridx = 2;
    gbl.setConstraints(logButton, gbc);
    
    gbc.gridx = 3;
    gbl.setConstraints(log10Button, gbc);
    
    gbc.gridx = 4;
    gbl.setConstraints(sqrtButton, gbc);
    
    gbc.gridx = 5;
    gbl.setConstraints(cbrtButton, gbc);
    
    gbc.gridx = 6;
    gbl.setConstraints(ceilButton, gbc);
    
    gbc.gridx = 7;
    gbl.setConstraints(floorButton, gbc);
    
    gbc.gridx = 8;
    gbl.setConstraints(absButton, gbc);
    
    gbc.gridy = 2;
    gbc.gridx = 0;
    gbl.setConstraints(maxButton, gbc);

    gbc.gridx = 1;
    gbl.setConstraints(minButton, gbc);

    gbc.gridx = 2;
    gbl.setConstraints(roundButton, gbc);

    gbc.gridx = 3;
    gbl.setConstraints(hypotButton, gbc);

    gbc.gridx = 4;
    gbl.setConstraints(rintButton, gbc);
    
    gbc.gridx = 5;
    gbl.setConstraints(toDegreesButton, gbc);

    gbc.gridx = 6;
    gbl.setConstraints(toRadiansButton, gbc);

    gbc.gridx = 7;
    gbl.setConstraints(signumButton, gbc);
    
    p.add(sinButton);
    p.add(cosButton);
    p.add(tanButton);
    p.add(asinButton);
    p.add(acosButton);
    p.add(atan2Button);
    p.add(atanButton);
    p.add(sinhButton);
    p.add(coshButton);
    p.add(tanhButton);
    p.add(expButton);
    p.add(powButton);
    p.add(log10Button);
    p.add(logButton);
    p.add(sqrtButton);
    p.add(cbrtButton);
    p.add(ceilButton);
    p.add(floorButton);
    p.add(absButton);
    p.add(maxButton);
    p.add(minButton);
    p.add(roundButton);
    p.add(hypotButton);
    p.add(rintButton);
    p.add(toDegreesButton);
    p.add(toRadiansButton);
    p.add(signumButton);
    
    return p;
    }

    /**
     * @return the stackField1
     */
    public JTextField getStackField1() {
        return stackField1;
    }

    /**
     * @return the stackField2
     */
    public JTextField getStackField2() {
        return stackField2;
    }

    /**
     * @return the stackField3
     */
    public JTextField getStackField3() {
        return stackField3;
    }

    /**
     * @return the stackField4
     */
    public JTextField getStackField4() {
        return stackField4;
    }
    
    /**
     * @return the stackField4
     */
    public JTextField getStackField5() {
        return stackField5;
    }

    /**
     * @return the numButtons
     */
    public JButton[] getNumButtons() {
        return numButtons;
    }
    /**
     * @return the dotButton
     */
    public JButton getDotButton() {
        return dotButton;
    }

    /**
     * @return the clearButton
     */
    public JButton getClearButton() {
        return clearButton;
    }

    /**
     * @return the plusButton
     */
    public JButton getPlusButton() {
        return plusButton;
    }

    /**
     * @return the minusButton
     */
    public JButton getMinusButton() {
        return minusButton;
    }

    /**
     * @return the mulButton
     */
    public JButton getMulButton() {
        return mulButton;
    }

    /**
     * @return the divButton
     */
    public JButton getDivButton() {
        return divButton;
    }

    /**
     * @return the modButton
     */
    public JButton getModButton() {
        return modButton;
    }

    /**
     * @return the enterButton
     */
    public JButton getEnterButton() {
        return enterButton;
    }

    /**
     * @return the statusBar
     */
    public JLabel getStatusBar() {
        return statusBar;
    }

    /**
     * @return the sinButton
     */
    public JButton getSinButton() {
        return sinButton;
    }

    /**
     * @return the cosButton
     */
    public JButton getCosButton() {
        return cosButton;
    }

    /**
     * @return the tanButton
     */
    public JButton getTanButton() {
        return tanButton;
    }

    /**
     * @return the asinButton
     */
    public JButton getAsinButton() {
        return asinButton;
    }

    /**
     * @return the acosButton
     */
    public JButton getAcosButton() {
        return acosButton;
    }

    /**
     * @return the atanButton
     */
    public JButton getAtanButton() {
        return atanButton;
    }

    /**
     * @return the atan2Button
     */
    public JButton getAtan2Button() {
        return atan2Button;
    }

    /**
     * @return the toRadiansButton
     */
    public JButton getToRadiansButton() {
        return toRadiansButton;
    }

    /**
     * @return the toDegreesButton
     */
    public JButton getToDegreesButton() {
        return toDegreesButton;
    }

    /**
     * @return the expButton
     */
    public JButton getExpButton() {
        return expButton;
    }

    /**
     * @return the sinhButton
     */
    public JButton getSinhButton() {
        return sinhButton;
    }

    /**
     * @return the coshButton
     */
    public JButton getCoshButton() {
        return coshButton;
    }

    /**
     * @return the tanhButton
     */
    public JButton getTanhButton() {
        return tanhButton;
    }

    /**
     * @return the powButton
     */
    public JButton getPowButton() {
        return powButton;
    }

    /**
     * @return the logButton
     */
    public JButton getLogButton() {
        return logButton;
    }

    /**
     * @return the log10Button
     */
    public JButton getLog10Button() {
        return log10Button;
    }

    /**
     * @return the sqrtButton
     */
    public JButton getSqrtButton() {
        return sqrtButton;
    }

    /**
     * @return the cbrtButton
     */
    public JButton getCbrtButton() {
        return cbrtButton;
    }

    /**
     * @return the signumButton
     */
    public JButton getSignumButton() {
        return signumButton;
    }

    /**
     * @return the ceilButton
     */
    public JButton getCeilButton() {
        return ceilButton;
    }

    /**
     * @return the floorButton
     */
    public JButton getFloorButton() {
        return floorButton;
    }

    /**
     * @return the rintButton
     */
    public JButton getRintButton() {
        return rintButton;
    }

    /**
     * @return the roundButton
     */
    public JButton getRoundButton() {
        return roundButton;
    }

    /**
     * @return the absButton
     */
    public JButton getAbsButton() {
        return absButton;
    }

    /**
     * @return the maxButton
     */
    public JButton getMaxButton() {
        return maxButton;
    }

    /**
     * @return the minButton
     */
    public JButton getMinButton() {
        return minButton;
    }

    /**
     * @return the hypotButton
     */
    public JButton getHypotButton() {
        return hypotButton;
    }
}
