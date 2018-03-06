package fraction;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FractionTest{
    FractionImpl frac1 = new FractionImpl(12, 30);
    FractionImpl frac2 = new FractionImpl(2);
    FractionImpl frac3 = new FractionImpl("12/30");
    FractionImpl frac4 = new FractionImpl("2");


    // complete the tests and add more
    // Tests that are expected to succeed or fail
    
    @Test
    public void testFractionImpl() {
//        assertEquals(2, frac1.numerator);
//        assertEquals(5, frac1.denominator);
//
//        assertEquals(2, frac2.numerator);
//        assertEquals(1, frac2.denominator);
//
//        assertEquals(2, frac3.numerator);
//        assertEquals(5, frac3.denominator);
//
//        assertEquals(2, frac4.numerator);
//        assertEquals(1, frac4.denominator);
        //TODO
    }

    @Test
    public void testAdd() {
        //Expected answer
        FractionImpl frac1 = new FractionImpl(1,2);

        //Objects/Arguments
        FractionImpl frac2 = new FractionImpl(1,4);
        FractionImpl frac3 = new FractionImpl(1,4);

        //Test
        assertEquals(frac1, frac2.add(frac3));


    }

    @Test
    public void testSubtract() {
        //Expected answer
        FractionImpl frac1 = new FractionImpl(1,4);

        //Objects/Arguments
        FractionImpl frac2 = new FractionImpl(1,2);
        FractionImpl frac3 = new FractionImpl(1,4);

        //Test
        assertEquals(frac1, frac2.subtract(frac3));
    }

    @Test
    public void testMultiply() {
        //Expected answer
        FractionImpl frac1 = new FractionImpl(3, 4);

        //Objects/Arguments
        FractionImpl frac2 = new FractionImpl(1,4);
        FractionImpl frac3 = new FractionImpl(1,2);

        //Test
        assertEquals(frac1, frac2.multiply(frac3));
    }

    @Test
    public void testDivide(){
        //Expected answer
        FractionImpl frac1 = new FractionImpl(3,1);

        //Objects/Arguments
        FractionImpl frac2 = new FractionImpl(1,2);
        FractionImpl frac3 =new FractionImpl(1,6);

        //Test
        assertEquals(frac1, frac2.divide(frac3));
    }

    @Test
    public void testAbs(){
        //Expected answers
        FractionImpl awns = new FractionImpl(1,4);

        //Objects/Arguments
        FractionImpl frac1 = new FractionImpl(1,4);
        FractionImpl frac2 = new FractionImpl(-1,4);

        //Test
        assertEquals(awns, frac1.abs());
        assertEquals(awns, frac2.abs());
    }

    @Test
    public void testNegate(){
        //Expected answers
        FractionImpl ans1 = new FractionImpl(-1,4);
        FractionImpl ans2 = new FractionImpl(1,2);

        //Objects/Arguments
        FractionImpl frac1 = new FractionImpl(1,4);
        FractionImpl frac2 = new FractionImpl(-1,2);

        //Test
        assertEquals(ans1, frac1.negate());
        assertEquals(ans2, frac2.negate());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        // test that should throw an ArithmeticException
    }
}