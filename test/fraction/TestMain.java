package fraction;

public class TestMain {

    public static void main(String[] args){
        new TestMain().run();
    }

    public  void run(){
        FractionImpl frac1 = new FractionImpl(1,4);
        FractionImpl frac2 = new FractionImpl(1,4);


        Fraction fracSum = frac1.add(frac2);
        System.out.println(frac2.compareTo(fracSum));
        //System.out.println(frac1.add(frac2));
        //System.out.println(fracSum.getClass().getName());


    }
}
