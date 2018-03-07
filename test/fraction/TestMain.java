package fraction;

public class TestMain {

    public static void main(String[] args){
        new TestMain().run();
    }

    public  void run(){
        FractionImpl frac1 = new FractionImpl(1,2);
        FractionImpl frac2 = new FractionImpl(1,4);


        Fraction fracSum = frac1.subtract(frac2);
        System.out.println(fracSum);
    }
}
