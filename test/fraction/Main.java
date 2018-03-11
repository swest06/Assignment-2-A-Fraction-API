package fraction;

public class Main {

    public static void main(String[] args){
        new Main().run();
    }

    public  void run(){
        FractionImpl frac1 = new FractionImpl(1,4);
        FractionImpl frac2 = new FractionImpl(1,2);
        FractionImpl frac3 = new FractionImpl(3,4);
        FractionImpl frac4 = new FractionImpl(-1,4);

        //Fraction1 as string
        System.out.println(frac1.toString());

        //Fraction2 inverse
        System.out.println(frac2.inverse());

        //4 * 2 using inverse of Fractions 1 and 2
        System.out.println(frac1.inverse().multiply(frac2.inverse()));

        //Absolute value of the sum of Fractions 1 and 2
        System.out.println(frac1.add(frac2).abs());

        //Negation of Fraction 3
        System.out.println(frac3.negate());

        //Negation of Fraction 4
        System.out.println(frac4.negate());


    }
}
