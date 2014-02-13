package hw4;

import java.math.BigInteger;

///CITATION HERE hash code from object reading

/**
 * A simple implementation of Fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Shaun Mataire
 * @author CSC152 2005S
 * @version 1.0 of February 2005
 */
public class Fraction
{
  // +------------------+---------------------------------------------
  // | Design Decisions |
  // +------------------+
  /*
   * (1) Denominators are always positive. Therefore, negative fractions are
   * represented with a negative numerator. Similarly, if a fraction has a
   * negative numerator, it is negative.
   * 
   * (2) Fractions are not necessarily stored in simplified form. To obtain a
   * fraction in simplified form, one must call the simplify method.
   */

  // +--------+-------------------------------------------------------
  // | Fields |
  // +--------+

  /** The numerator of the fraction. Can be positive, zero or negative. */
  BigInteger num;

  /** The denominator of the fraction. Must be non-negative. */
  BigInteger denom;

  // +--------------+-------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(BigInteger num, BigInteger denom)
  {
    this.num = num;
    this.denom = denom;
  } // Fraction(BigInteger, BigInteger)

  /**
   * Fraction. Buisixth.sub(new Fraction (2, 12))ld a new fraction with numerator num and denominator denom.
   * 
   * Warning! Not yet stable.
   */
  public Fraction(int num, int denom)
  {
    this.num = BigInteger.valueOf(num);
    this.denom = BigInteger.valueOf(denom);
  } // Fraction(int, int)

  /**
   * Build a new fraction from a single integer
   */
  public Fraction(int number)
  {
  this.num = BigInteger.valueOf (number);
  this.denom = BigInteger.valueOf(1);
  } // Fraction(int, int)
  /**
   * Build a new fraction with numerator num and denominator denom. from a
   * string
   */
  public Fraction(String fract)
  {
    if (fract.contains ("/"))
      {
    String[] factString = fract.split("/");
    this.num = BigInteger.valueOf(Integer.parseInt(factString[0]));
    this.denom = BigInteger.valueOf(Integer.parseInt(factString[1]));
      }
    else 
      {
      this.num = new BigInteger (fract);
      this.denom = new BigInteger ("1");
      }
  } // Fraction(int, int)

  // +---------+------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Express this fraction as a double.
   */
  public double doubleValue()
  {
    return this.num.doubleValue() / this.denom.doubleValue();
  } // doubleValue()


  /**
   * Convert this fraction to a string for ease of printing.
   */
  public String toString()
  {
    // Special case: It's zero
    if (this.num.equals(BigInteger.ZERO))
      {
        return "0";
      } // if it's zero

    // Lump together the string represention of the numerator,
    // a slash, and the string representation of the denominator
    // return this.num.toString().concat("/").concat(this.denom.toString());
    return this.num + "/" + this.denom;
  } // toString()

  
  /**
   * Add the fraction other to this fraction.
   */
  public Fraction add(Fraction addMe)
  {
    Fraction result;
    if(addMe.denom == this.denom)
      {
          result = new Fraction(this.num.add(addMe.num), this.denom);
          return result;
      } // if denoms are the same
    
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(addMe.denom);
    // The numerator is more complicated
    resultNumerator =
        (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// add(Fraction)

  
  /**
   * multiplication the fraction other to this fraction.
   */
  public Fraction mult(Fraction multMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // product of this object's denominator
    // and addMe's denominator
    resultDenominator = this.denom.multiply(multMe.denom);
    // Same for complicated
    resultNumerator = this.num.multiply(multMe.num);

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// mult(Fraction)
  
  
  /**
   * Divide the fraction other to this fraction.
   */
  public Fraction div(Fraction divMe)
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;
    resultNumerator = this.num.multiply(divMe.denom);
    resultDenominator = this.denom.multiply(divMe.num);
    return new Fraction(resultNumerator, resultDenominator);
  }// mult(Fraction)
  
  /**
   * subtract the fraction subMe from this fraction.
   */
  public Fraction sub(Fraction subMe)
  {
    Fraction result;
    if(subMe.denom == this.denom)
      {
          result = new Fraction(this.num.subtract(subMe.num), this.denom);
          return result;
      } //If Denoms are the same
    
    BigInteger tempNumerator1 = subMe.denom.multiply(this.num);
    BigInteger tempNumerator2 = this.denom.multiply(subMe.num);
    BigInteger resultDenominator = this.denom.multiply (subMe.denom);
    BigInteger resultNumerator = tempNumerator1.subtract(tempNumerator2);
    result = new Fraction(resultNumerator, resultDenominator);
    return result;
  }// subtract
  /**
   * fractional identifies and returns this fractional value as a Fraction
   */
  public Fraction fractional()
  {
    BigInteger resultNumerator;
    BigInteger resultDenominator;

    // The denominator of the result is the
    // just the same as the intial
    resultDenominator = this.denom;
    // numerator is the mod. with the denominator
    resultNumerator = this.num.mod(this.denom);

    // Return the computed value
    return new Fraction(resultNumerator, resultDenominator);
  }// fractional(Fraction)
  /**
   * fractional identifies and returns this fractional value as a Fraction
   */
  public Object clone ()
  {
    Fraction result = new Fraction(this.num, this.denom);
    return result;
  } // Clone
  
  /**
   * Simplifies this fraction to its most basic form. 5/30 -> 1/6
   */
  public Fraction simplify()
  {
   BigInteger comDenom = this.num.gcd (this.denom);
   this.denom = this.denom.divide(comDenom);
   this.num = this.num.divide(comDenom);
   Fraction result = new Fraction (num, denom);
   return result;   
  } //Simplify
 
  
  /**
   * Compare this fraction to another object.  The two are only
   * equal if they are both fractions and have the same numerator
   * and denominator.
   */
  
  public boolean equals(Fraction other)
  {
    return this.num.equals(other.num)
           && this.denom.equals(other.denom);
  } // equals(Fraction)
  

  /**
   * hashCode produces an integer which represents the Fraction object.
   */
  public int hashCode()
  {
    return this.num.intValue() * this.num.intValue();
  } // hashCode()

} // class Fraction
