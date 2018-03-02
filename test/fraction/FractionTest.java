package fraction;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FractionTest {
    FractionImpl frac1 = new FractionImpl(12, 30);
    FractionImpl frac2 = new FractionImpl(2);
    FractionImpl frac3 = new FractionImpl("12/30");
    FractionImpl frac4 = new FractionImpl("2");


    // complete the tests and add more
    @Test
    public void testFractionImpl() {
        assertEquals(2, frac1.numerator);
        assertEquals(5, frac1.denominator);

        assertEquals(2, frac2.numerator);
        assertEquals(1, frac2.denominator);

        assertEquals(2, frac3.numerator);
        assertEquals(5, frac3.denominator);

        assertEquals(2, frac4.numerator);
        assertEquals(1, frac4.denominator);
    }

    @Test
    public void testAdd() {
        // Tests that are expected to succeed or fail
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // test that should throw an ArithmeticException
    }
}