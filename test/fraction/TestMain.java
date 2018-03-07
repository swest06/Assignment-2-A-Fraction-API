package fraction;

public class TestMain {

    public static void main(String[] args){
        new TestMain().run();
    }

    public  void run(){
        FractionImpl frac1 = new FractionImpl(1,2);
        FractionImpl frac2 = new FractionImpl(1,4);

        Fraction fracA = (Fraction)frac1;
        Fraction fracB = (Fraction)frac2;



        Fraction fracSum = fracA.add(fracB);
        System.out.println(fracSum);
    }
}
