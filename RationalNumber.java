public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    } else {
      numerator = nume;
      denominator = deno;
    }
  }

  public double getValue(){
    return (Double.valueOf(numerator) / Double.valueOf(denominator));
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    return new RationalNumber(getDenominator(), getNumerator());
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return ((getNumerator() == other.getNumerator())
              && (getDenominator() == other.getDenominator()));
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    if (getNumerator() == 0) return "" + 0;
    if (getDenominator() == 1) return "" + getNumerator();
    return "" + getNumerator() + "/" + getDenominator();
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    /*use euclids method or a better one*/
    //http://sites.math.rutgers.edu/~greenfie/gs2004/euclid.html
    if ((a == 0) || (b == 0)) return 0;

    int bigger = a;
    int smaller = b;
    if (b > a) {
      bigger = b;
      smaller = a;
    }

    while (Math.abs(bigger) % Math.abs(smaller) != 0) {
      int oldBigger = bigger;
      bigger = smaller;
      smaller = (Math.abs(oldBigger) % Math.abs(smaller));
    }

    return smaller;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int gcf = gcd(getNumerator(), getDenominator());
    if ((gcf != 0) && (gcf != 1)) {
      numerator = (getNumerator() / gcf);
      denominator = (getDenominator() / gcf);
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    reduce();
    other.reduce();
    int nume = getNumerator() * (other.getNumerator());
    int deno = getDenominator() * (other.getDenominator());

    RationalNumber product = new RationalNumber(nume, deno);
    product.reduce();

    return product;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    reduce();
    other.reduce();
    int nume = getNumerator() * (other.getDenominator());
    int deno = getDenominator() * (other.getNumerator());

    RationalNumber quot = new RationalNumber(nume, deno);
    quot.reduce();

    return quot;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    return null;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    return null;
  }
}
