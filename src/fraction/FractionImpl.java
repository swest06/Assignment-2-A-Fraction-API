package fraction;

import java.lang.*;


public class FractionImpl implements Fraction{

    private int numerator;
    private int denominator;


    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    public FractionImpl(int numerator, int denominator) {
        //Stores initial values
        int n = numerator;
        int d = denominator;

        //Euclidean Algorithm for GCD
        if (denominator == 0){
            throw new ArithmeticException("Denominator cannot be 0.");
        }else {
            int rem;

            do{
               rem = denominator % numerator;
                denominator = numerator;
               numerator = rem;
            }while( rem != 0);

            int gCF = denominator;

            this.numerator = n/gCF;
            this.denominator = d/gCF;
        }


    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        if (fraction.contains(" ")){
            fraction = fraction.replaceAll("\\s","");
        }
        if (fraction.contains("/")) {

            String[] section = fraction.split("/");
            int numerator = Integer.parseInt(section[0]);
            int denominator = Integer.parseInt(section[1]);

            init(numerator, denominator);
        }else{
            int numerator = Integer.parseInt(fraction);
            init(numerator);
        }
}

    /**
     *
     * @param numerator representing the whole number
     */
    private void init(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * @param numerator
     * @param denominator
     */
    private void init(int numerator, int denominator) {
        //Stores initial values
        int n = numerator;
        int d = denominator;

        //Euclidean Algorithm for GCF
        if (denominator == 0){
            throw new ArithmeticException("Denominator cannot be 0.");
        }else {
            int rem;
            do{
                rem = denominator % numerator;
                denominator = numerator;
                numerator = rem;
            }while( rem != 0);

            int gCF = denominator;

            this.numerator = n/gCF;
            this.denominator = d/gCF;
        }
    }

    private FractionImpl norm(int x, int y){

        double sumDec = (float)x / y;
        sumDec = sumDec * 100;
        int sum = (int) sumDec;

        return new FractionImpl(sum, 100);
    }

    /**
     * @inheritDoc
     * Adds 2 fraction objects (sum = 'this' + 'that')
     * @param f fraction object
     * @return returns sum of this and that
     */
    @Override
    public Fraction add(Fraction f) {
        //Typecast argument
        FractionImpl f1 = (FractionImpl)f;

        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;
        int c = f1.numerator;
        int d = f1.denominator;

        //Add fractions
        //sumDec = sum as decimal

        int x = (a*d + b*c);
        int y = (b*d);

        //Normalise
        return norm(x, y);
    }

    /**
     * @inheritDoc
     * Subtracts 1 fraction from another (sum = 'this' - 'that')
     * @param f fraction object
     * @return returns 'this' minus 'that'
     */
    @Override
    public Fraction subtract(Fraction f) {
        //Typecast argument
        FractionImpl f1 = (FractionImpl)f;

        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;
        int c = f1.numerator;
        int d = f1.denominator;

        //Subtract fractions
        int x = (a*d - b*c);
        int y = (b*d);

        //Normalise
        return norm(x, y);
    }


    /**
     * @inheritDoc
     * Multiplies 2 fractions (sum = 'this' * 'that')
     * @param f fraction object
     * @return returns 'this' minus 'that'
     */
    @Override
    public Fraction multiply(Fraction f) {
        //Typecast argument
        FractionImpl f1 = (FractionImpl)f;
//
        //Multiply fractions
        int x = (this.numerator * f1.numerator);
        int y = (this.denominator * f1.denominator);

        //Normalise
        return norm(x,y);
    }

    /**
     * @inheritDoc
     * Divides 1 fraction from another (sum = 'this' / 'that')
     * @param f fraction object
     * @return returns 'this' divided by 'that'
     */
    @Override
    public Fraction divide(Fraction f) {
        //Typecast argument
        FractionImpl f1 = (FractionImpl)f;

        //Divide fractions
        int x = (this.numerator * f1.denominator);
        int y = (this.denominator * f1.numerator);

        //Normalise
        return norm(x, y);
    }

    /**
     * @inheritDoc
     * Returns absolute value of object as a fraction
     * @return returns absolute value of 'this'
     */
    @Override
    public Fraction abs() {
        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;

        //Find abs
        double sumDec = (float)a/b;
        if (sumDec < 0) {
            sumDec = (sumDec) - (sumDec * 2);
        }
        sumDec = sumDec * 100;
        int sum = (int) sumDec;

        return new FractionImpl(sum, 100);
    }

    /**
     * @inheritDoc
     * negates fraction ex 1/4 to -1/4
     * @return returns negation of 'this'
     */
    @Override
    public Fraction negate() {
        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;

        //Negate
        double sumDec = (float)a/b;
        sumDec = (sumDec*-1);
        sumDec = sumDec * 100;
        int sum = (int) sumDec;

        return new FractionImpl(sum, 100);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     * Shows if 1 fraction is equal to another
     * @param obj object
     * @return returns true if 'this' has the same value as 'that'
     */
    @Override
    public boolean equals(Object obj) {
        int value;

        if (obj instanceof Fraction){
            FractionImpl frac = (FractionImpl)obj;
            value = this.compareTo(frac);
        }else {
            throw new ClassCastException();
        }

        return value == 0;
    }

    /**
     * @inheritDoc
     * Creates new Fraction object with same value as 'this'
     * @return returns new Fraction object with same value as 'this'
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     * inverses Fraction object (1/4 to 4/1)
     * @return returns inverse of 'this'
     */
    @Override
    public Fraction inverse() {
        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;

        return new FractionImpl(b,a);
    }

    /**
     * @inheritDoc
     * Compares two Fraction objects
     * @param o fraction object
     * @return returns '0' if objects are equal
     */
    @Override
    public int compareTo(Fraction o) {
        //Typecast
        FractionImpl f1 = (FractionImpl) o;

        //Assign values
        double x = (float)this.numerator / this.denominator;
        double y = (float)f1.numerator/ f1.denominator;
        int result;

        if (x > y ){
            result = 1;
        }else if (x < y){
            result = -1;
        }else{
            result = 0;
        }

        return result;
    }

    /**
     * @inheritDoc
     * Converts Fraction object to String
     * @return returns String of 'this'
     */
    @Override
    public String toString() {
        int a = this.numerator;
        int b = this.denominator;

        String result;

        if (a == 0){
            result = "0";
        }else{
            if (b == 1){
                result = ""+a;
            }else if ((a^b)<0){
                result = "-"+a+"/"+b;

                String[] sec = result.split("/");
                 int x = Integer.parseInt(sec[1].replace("-",""));
                 result = "-"+a+"/"+x;
            }else{
                result = ""+a+"/"+b;
            }
        }

        return result;
    }
}