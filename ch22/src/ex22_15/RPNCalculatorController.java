package ex22_15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Deque;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JTextField;


/**
 * control user interfaces
 */
public class RPNCalculatorController {

    private final RPNCalculatorModel model;
    private final RPNCalculatorView view;
    
    public RPNCalculatorController() {
        view = new RPNCalculatorView();
        model = new RPNCalculatorModel();
    }
    
    private void updateStackView() {
        Deque<Double> stack = model.getStack();
        Iterator<Double> ite = stack.iterator();
        
        JTextField[] fields = new JTextField[4];
        fields[0] = view.getStackField2();
        fields[1] = view.getStackField3();
        fields[2] = view.getStackField4();
        fields[3] = view.getStackField5();
        
        for (int i = 0; i < 4; i++) {
            if (ite.hasNext()) {
                fields[i].setText(Double.toString(ite.next()));
            } else {
                fields[i].setText("");
            }
        }
        view.getStackField1().setText("");
    }
    
    /**
     * add action listener to number button
     */
    public void bindNumberButtonListener() {
        JButton[] buttons = view.getNumButtons();
        for (int i = 0; i < 10; i++) {
            final int num = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String org = view.getStackField1().getText();
                    view.getStackField1().setText(org + num);
                }
            });
        }
    }
    
    public void bindEnterButtonListener() {
        view.getEnterButton().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
               JTextField field = view.getStackField1();
               try {
                   model.addOperand(new Double(field.getText()));
                   view.getStatusBar().setText("OK");
               } catch (NumberFormatException ex) {
                   view.getStatusBar().setText("Number Format Error");
               } finally {
                   field.setText("");
               }
               updateStackView();
            }
        });
    }
    
    public void bindDotButtonListener() {
        view.getDotButton().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String org = view.getStackField1().getText();
                view.getStackField1().setText(org + ".");
            }
        });
    }
    
    public void bindClearButtonListener() {
        view.getClearButton().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getStackField1().setText("");
                model.clearStackAll();
                updateStackView();
            }
        });
    }
    
    private void bindOperatorButtonListener(JButton button, Operator op) {
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JTextField field = view.getStackField1();
                    if (!field.getText().equals("")) {
                        model.addOperand(new Double(field.getText()));
                    }
                    model.calculate(op);
                    field.setText(Double.toString(model.getStackHead()));
                } catch (IllegalStateException ex) {
                    view.getStatusBar().setText("Operation Failed");
                } catch (NumberFormatException ex) {
                    view.getStatusBar().setText("Number Format Error");
                }
                updateStackView();
            }
        });
    }
    
    public void bindOperators() {
        bindOperatorButtonListener(view.getPlusButton(), Operator.PLUS);
        bindOperatorButtonListener(view.getMinusButton(), Operator.MINUS);
        bindOperatorButtonListener(view.getMulButton(), Operator.MULTIPULY);
        bindOperatorButtonListener(view.getDivButton(), Operator.DIVIDE);
        bindOperatorButtonListener(view.getModButton(), Operator.MODULO);
        
        bindOperatorButtonListener(view.getSinButton(), Operator.SIN);
        bindOperatorButtonListener(view.getCosButton(), Operator.COS);
        bindOperatorButtonListener(view.getTanButton(), Operator.TAN);
        bindOperatorButtonListener(view.getAsinButton(), Operator.ASIN);
        bindOperatorButtonListener(view.getAcosButton(), Operator.ACOS);
        bindOperatorButtonListener(view.getAtanButton(), Operator.ATAN);
        bindOperatorButtonListener(view.getAtan2Button(), Operator.ATAN2);
        bindOperatorButtonListener(view.getToRadiansButton(), Operator.TORADIANS);
        bindOperatorButtonListener(view.getToDegreesButton(), Operator.TODEGREES);
        bindOperatorButtonListener(view.getExpButton(), Operator.EXP);
        bindOperatorButtonListener(view.getSinhButton(), Operator.SINH);
        bindOperatorButtonListener(view.getCoshButton(), Operator.COSH);
        bindOperatorButtonListener(view.getTanhButton(), Operator.TANH);
        bindOperatorButtonListener(view.getPowButton(), Operator.POW);
        bindOperatorButtonListener(view.getLogButton(), Operator.LOG);
        bindOperatorButtonListener(view.getLog10Button(), Operator.LOG10);
        bindOperatorButtonListener(view.getSqrtButton(), Operator.SQRT);
        bindOperatorButtonListener(view.getCbrtButton(), Operator.CBRT);
        bindOperatorButtonListener(view.getSignumButton(), Operator.SIGNUM);
        bindOperatorButtonListener(view.getCeilButton(), Operator.CEIL);
        bindOperatorButtonListener(view.getFloorButton(), Operator.FLOOR);
        bindOperatorButtonListener(view.getRintButton(), Operator.RINT);
        bindOperatorButtonListener(view.getRoundButton(), Operator.ROUND);
        bindOperatorButtonListener(view.getAbsButton(), Operator.ABS);
        bindOperatorButtonListener(view.getMaxButton(), Operator.MAX);
        bindOperatorButtonListener(view.getMinButton(), Operator.MIN);
        bindOperatorButtonListener(view.getHypotButton(), Operator.HYPOT);
    }
}
