package fraction;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FractionTest{
    FractionImpl frac1 = new FractionImpl(1, 4);
    FractionImpl frac2 = new FractionImpl(1,2);
    FractionImpl frac3 = new FractionImpl(2,4);
    FractionImpl frac4 = new FractionImpl(2,1);
    FractionImpl frac5 = new FractionImpl(-2);

    // complete the tests and add more
    // Tests that are expected to succeed or fail


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
        Fraction frac1 = new FractionImpl(1,4);

        //Objects/Arguments
        FractionImpl frac2 = new FractionImpl(1,2);
        FractionImpl frac3 = new FractionImpl(1,4);

        //Test
        assertEquals(frac1, frac2.subtract(frac3));
    }

    @Test
    public void testMultiply() {

        //Objects/Arguments
        FractionImpl frac2 = new FractionImpl(1,4);
        FractionImpl frac3 = new FractionImpl(2,1);

        //Test
        assertEquals("1/2", frac2.multiply(frac3).toString());
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

    @Test
    public void testInverse(){
        //Expected answer
        FractionImpl ans1 = new FractionImpl(4,1);

        //Object
        FractionImpl frac1 = new FractionImpl(1,4);

        //Test
        assertEquals(ans1, frac1.inverse());
    }

    @Test
    public void testCompareTo(){
        assertEquals(-1, frac1.compareTo(frac2));
        assertEquals(1, frac2.compareTo(frac1));
        assertEquals(0, frac2.compareTo(frac3));
    }

    @Test
    public void testToString(){
        String a = "1/4";
        String b = "1/2";

        assertTrue(frac1.toString().equals(a));
        assertTrue(frac2.toString().equals(b));
        assertTrue(frac3.toString().equals(b));
    }

    @Test
    public void testEquals(){
        FractionImpl frac1 = new FractionImpl(1,2);
        FractionImpl frac2 = new FractionImpl(1,2);
        FractionImpl frac3 = new FractionImpl(1,4);

        assertTrue(frac1.equals(frac2));
        assertFalse(frac1.equals(frac3));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        FractionImpl frac1 = new FractionImpl(1,0);
        FractionImpl frac2 = new FractionImpl(0,0);
    }
}