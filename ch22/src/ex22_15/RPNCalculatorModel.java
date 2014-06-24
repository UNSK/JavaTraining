package ex22_15;

import java.util.Deque;
import java.util.LinkedList;



/**
 * Model class for rpn calculator
 */
public class RPNCalculatorModel {
    private Deque<Double> stack = new LinkedList<>();
    
    /**
     * @return the operand stack
     */
    public Deque<Double> getStack() {
        return stack;
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
    
    public double getStackHead() {
        return stack.peek();
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
        case SIN:
            stack.push(Math.sin(stack.pop()));
            break;
        case COS:
            stack.push(Math.cos(stack.pop()));
            break;
        case TAN:
            stack.push(Math.tan(stack.pop()));
            break;
        case ASIN:
            if (stack.peek() > 1 || stack.peek() < -1) {
                throw new IllegalStateException();
            }
            stack.push(Math.asin(stack.pop()));
            break;
        case ACOS:
            if (stack.peek() > 1 || stack.peek() < -1) {
                throw new IllegalStateException();
            }
            stack.push(Math.acos(stack.pop()));
            break;
        case ATAN:
            stack.push(Math.atan(stack.pop()));
            break;
        case ATAN2:
            if (stack.size() < 2 || stack.peek() == 0) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp = Math.atan2(stack.pop(), tmp);
            stack.push(tmp);
            break;
        case TORADIANS:
            stack.push(Math.toRadians(stack.pop()));
            break;
        case TODEGREES:
            stack.push(Math.toDegrees(stack.pop()));
            break;
        case EXP:
            stack.push(Math.exp(stack.pop()));
            break;
        case SINH:
            stack.push(Math.sinh(stack.pop()));
            break;
        case COSH:
            stack.push(Math.cosh(stack.pop()));
            break;
        case TANH:
            stack.push(Math.tanh(stack.pop()));
            break;
        case POW:
            if (stack.size() < 2 || stack.peek() == 0) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp = Math.pow(stack.pop(), tmp);
            stack.push(tmp);
            break;
        case LOG:
            stack.push(Math.log(stack.pop()));
            break;
        case LOG10:
            stack.push(Math.log10(stack.pop()));
            break;
        case SQRT:
            stack.push(Math.sqrt(stack.pop()));
            break;
        case CBRT:
            stack.push(Math.cbrt(stack.pop()));
            break;
        case SIGNUM:
            stack.push(Math.signum(stack.pop()));
            break;
        case CEIL:
            stack.push(Math.ceil(stack.pop()));
            break;
        case FLOOR:
            stack.push(Math.floor(stack.pop()));
            break;
        case RINT:
            stack.push(Math.rint(stack.pop()));
            break;
        case ROUND:
            stack.push((double) Math.round(stack.pop()));
            break;
        case ABS:
            stack.push(Math.abs(stack.pop()));
            break;
        case MAX:
            if (stack.size() < 2 || stack.peek() == 0) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp = Math.max(stack.pop(), tmp);
            stack.push(tmp);
            break;
        case MIN:
            if (stack.size() < 2 || stack.peek() == 0) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp = Math.min(stack.pop(), tmp);
            stack.push(tmp);
            break;
        case HYPOT:
            if (stack.size() < 2 || stack.peek() == 0) {
                throw new IllegalStateException();
            }
            tmp = stack.pop();
            tmp = Math.hypot(stack.pop(), tmp);
            stack.push(tmp);
            break;
        default:
            throw new AssertionError();
        }
    }
    
    
    
}
