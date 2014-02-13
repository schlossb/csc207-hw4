package hw4;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest
{

  Fraction sixth = new Fraction (5,30);
  Fraction one = new Fraction (1,1);
  Fraction half = new Fraction (1,2);
  Fraction three = new Fraction (9,3);
  Fraction unsimp = new Fraction (25, 900);
  Fraction twosixth = new Fraction (300,900);
  Fraction threesixth = new Fraction (3,6);
  @Test
  public void
    ConstructEqualsTest ()
  {
    assertEquals  (true,
                  one.equals(new Fraction (1,1)));
    assertEquals  (true, 
                  sixth.equals (new Fraction ("5/30")));

  } //Constructs
 
  @Test
  public void
    DoubleValTest ()
  {
    assertEquals  (true,
                   one.doubleValue() - 1 <= (.00001));
    
    assertEquals  (true,
                   three.doubleValue() - 3 <= (.00001));
  } //DoubleVal
  
  @Test
  public void
   StringTest ()
  {
    assertEquals  ("5/30", 
                   sixth.toString ());
    assertEquals  ("1/1", 
                   one.toString ());               
  } //StringTest
  
  @Test
  public void
   MathTest ()
  {

    assertEquals  (true,
                   sixth.mult(sixth).equals(unsimp));
    assertEquals  (true,
                   sixth.add(sixth).simplify().equals (new Fraction (1,3)));
    assertEquals  (true,
                   sixth.add(one).equals (new Fraction("35/30"))); 
    assertEquals  (true,
                   sixth.div(sixth).simplify().equals (one.simplify()));
    assertEquals  (true,
                   sixth.sub(sixth).equals (new Fraction (0,30)));
    assertEquals  (true,
                   new Fraction (1,6).sub (new Fraction (1,5)).equals 
                   (new Fraction (-1, 30)));
   
  } //Math Tests
  public void
  HashTest ()
 {

   assertEquals  (true,
                  sixth.hashCode() == (sixth.hashCode()));
   assertEquals  (false,
                  sixth.hashCode() == (new Fraction (1,7).hashCode()));
 } //hashtest
  
  public void
  SimplifyTest ()
 {
   assertEquals  (true,
                  new Fraction (2,6).simplify().equals(new Fraction (1,3)));
   assertEquals  (true,
                  new Fraction (30,120).simplify().equals(new Fraction (1,4)));
 } //Simplification tests
  }// End Tests
