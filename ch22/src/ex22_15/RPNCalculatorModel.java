package ex22_15;

import java.util.Deque;
import java.util.LinkedList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 * Model class for rpn calculator
 */
public class RPNCalculatorModel {
    private Deque<Double> stack = new LinkedList<>();
    private static DefaultTableModel tableModel = new DefaultTableModel();
    
    /**
     * @return the operand stack
     */
    public Deque<Double> getStack() {
        return stack;
    }
    
    public static TableModel getTableModel() {
        return tableModel;
    }
    
    public void addOperand(double val) {
        stack.push(val);
    }
    
    public void clearStackAll() {
        stack.clear();
    }
    
    public void clearStackHead() {
        stack.pop();
    }
    
    public void calculate(Operator op) {
        if (stack.isEmpty()) {
            throw new IllegalStateException();
        }

        double tmp;
        switch (op) {
        case PLUS:
            if (stack.size() < 2) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp += stack.pop();
            stack.push(tmp);
            break;
        case MINUS:
            if (stack.size() < 2) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp = stack.pop() - tmp;
            stack.push(tmp);
            break;
        case MULTIPULY:
            if (stack.size() < 2) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp *= stack.pop();
            stack.push(tmp);
            break;
        case DIVIDE:
            if (stack.size() < 2 || stack.peek() == 0) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp = stack.pop() / tmp;
            stack.push(tmp);
            break;
        case MODULO:
            if (stack.size() < 2 || stack.peek() == 0) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp = stack.pop() % tmp;
            stack.push(tmp);
            break;
        default:
            throw new AssertionError();
        }
    }
    
    
    
}
