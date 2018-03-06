package fraction;


public class FractionImpl implements Fraction, Comparable{
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
        FractionImpl f1 = (FractionImpl)f;

        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;
        int c = f1.numerator;
        int d = f1.denominator;

        //Add fractions
        double sumDec = (a*b + b*c)/ b*d;
        sumDec = sumDec*100;
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
    public Fraction subtract(Fraction f) {
        //Typecast argument
        FractionImpl f1 = (FractionImpl)f;

        //Assign Variables
        int a = this.numerator;
        int b = this.denominator;
        int c = f1.numerator;
        int d = f1.denominator;

        //Subtract fractions
        double sumDec = (a*b - b*c)/ b*d;
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
        double sumDec = (a*c) / (b*d);
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
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
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
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return null;
    }
}