package edu.grinnell.csc207.username.utils;
import java.math.BigInteger;
public class Calculator
{
//Method: Calculator
//Inputs a string of numbers and operands seperated by spaces, and calculates the result, ignoring OOP
//Example: Inputed String "5 + 10 / 5" would return the BigInteger 3.
 public static
  BigInteger eval0 (String str)
  {
    //Splits the string into strings for every element
    String[] terms = StringUtils.splitAt (str, ' ');
    //Makes the initial value = to the value of the # in the first new string
   BigInteger result = new BigInteger(terms[0]);
   //Counter variable
   int counter = 1;
   //The next term to consider
   BigInteger next;
   //Loops through the array of strings til it reaches one before the end
   while (counter < (terms.length -1))
     {
       //Sets next term to 1 more than counter's value
       next = new BigInteger(terms[counter + 1]);
       //Checks what operation is currently at counter's value and does the operation
       if (terms[counter].equals ("+"))
        result = result.add (next);
       else if (terms[counter].equals("-"))
         result = result.subtract (next);       
       else if (terms[counter].equals ("*"))
        result = result.multiply (next);
       else if (terms[counter].equals ("/"))
       result = result.divide (next);
       else if (terms[counter].equals ("^"))
       result =  result.pow (next.intValue ());
       //Increments counter by 2
       counter = counter + 2;
     }//End Calculations
   return result;
  } // End Calculator

}
