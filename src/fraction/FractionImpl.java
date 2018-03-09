package fraction;


public class FractionImpl implements Fraction{
    //CHANGE BACK TO PRIVATE
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
                //FIX HERE!
               rem = denominator % numerator;
               //System.out.println("HERE");
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

        if (fraction.length() > 2){
            String[] section = fraction.split("/");
            int numerator = Integer.parseInt(section[0]);
            int denominator = Integer.parseInt(section[1]);
            init(numerator, denominator);
        }else{
            int numerator = Integer.parseInt(fraction);
            init(numerator);
        }
}

    private void init(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }


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

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        //Typecast argument
        FractionImpl f0 = (FractionImpl)this;
        FractionImpl f1 = (FractionImpl)f;

        //Assign Variables
        int a = f0.numerator;
        int b = f0.denominator;
        int c = f1.numerator;
        int d = f1.denominator;

        //Add fractions
        //sumDec = sum as decimal

        int x = (a*d + b*c);
        int y = (b*d);
        double sumDec = (float)x / y;

        sumDec = sumDec*100;
        int sum = (int) sumDec;

        //Normalise fraction
        //Rewrite
        FractionImpl frac = new FractionImpl(sum, 100);
        //System.out.println(frac.numerator);
        //System.out.println(frac.denominator);
        //TODO
        return frac;
    }

    /**
     * @inheritDoc
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

        double sumDec = (float)x / y;

        sumDec = sumDec * 100;
        int sum = (int) sumDec;

        //Normalise fraction
        FractionImpl frac = new FractionImpl(sum, 100);
        //TODO

        return frac;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        //Typecast argument
        FractionImpl f1 = (FractionImpl)f;

        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;
        int c = f1.numerator;
        int d = f1.denominator;

        //Multiply fractions
        int x = (a*c);
        int y = (b*d);

        double sumDec = (float)x / y;

        //double sumDec = (a*c) / (b*d);
        sumDec = sumDec * 100;
        int sum = (int) sumDec;

        //Normalise fraction
        FractionImpl frac = new FractionImpl(sum, 100);

        return frac;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        //Typecast argument
        FractionImpl f1 = (FractionImpl)f;

        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;
        int c = f1.numerator;
        int d = f1.denominator;

        //Divide fractions
        int x = (a*d);
        int y = (b*c);

        double sumDec = (float)x / y;
        sumDec = sumDec * 100;
        int sum = (int) sumDec;

        //Normalise fraction
        FractionImpl result = new FractionImpl(sum, 100);

        return result;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        //Typecast object
        FractionImpl f1 = (FractionImpl)this;

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

        //Normalise fraction
        FractionImpl result = new FractionImpl(sum, 100);

        return result;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        //Typecast object
        FractionImpl f1 = (FractionImpl)this;

        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;

        //Negate
        double sumDec = (float)a/b;
        sumDec = (sumDec) - (sumDec * 2);
        sumDec = sumDec * 100;
        int sum = (int) sumDec;

        //Normalise fraction
        FractionImpl result = new FractionImpl(sum, 100);
        return result;
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
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        //Assign Variables
        int a = this.numerator;
        int b = this.numerator;

        //Inverse
        FractionImpl result = new FractionImpl(b,a);

        return result;
    }

    /**
     * @inheritDoc
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
     */
    @Override
    public String toString() {
        int a = this.numerator;
        int b = this.denominator;

        String result;

        if(b > 1){
            result = a + "/" + b;
        }else if (b == 0){
            result = "0";
        }else {
            result = "a";
        }
        
        return result;
    }
}