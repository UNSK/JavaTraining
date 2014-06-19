package ex22_15;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

/**
 * test logic
 */
public class RPNCalculatorModelTest {

    private RPNCalculatorModel calc;
    
    @Before
    public void setUp() {
        calc = new RPNCalculatorModel();
    }
    
    @Test
    public void plusTest() {
        calc.addOperand(2.0);
        calc.addOperand(1.5);
        calc.calculate(Operator.PLUS);
        
        assertThat(calc.getStack().pop(), is(3.5));
    }

    @Test
    public void minusTest() {
        calc.addOperand(2.0);
        calc.addOperand(1.5);
        calc.calculate(Operator.MINUS);
        
        assertThat(calc.getStack().pop(), is(0.5));
    }
}
