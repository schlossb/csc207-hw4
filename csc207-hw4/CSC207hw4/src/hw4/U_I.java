package hw4;



import java.util.Scanner;
import java.io.PrintWriter;

/**
 * User Interface (UI) class
 * 
 * @author mataires
 * @author CSC207 2014S
 */
public class U_I
{
  /**
   * check validity of input expression
   * 
   * @param expresion
   * @return
   */
  public static boolean validity(String expresion)
  {
    boolean result = true;
    String[] splitedExpression = new String[] {};
    splitedExpression = (expresion.split(""));
    for (int j = 0; j < splitedExpression.length; j++)
      {
        // are there any two, or more, consecrative operators?
        if (((splitedExpression[j].equals("+"))
             || (splitedExpression[j].equals("-"))
             || (splitedExpression[j].equals("/")) || (splitedExpression[j].equals("*")))
            && ((splitedExpression[j + 1].equals("+"))
                || (splitedExpression[j + 1].equals("-"))
                || (splitedExpression[j + 1].equals("/")) || (splitedExpression[j + 1].equals("*"))))
          {
            result = false;// if above is true
          } // End error if there are two operators in a row
      } // End loop (j)
    // are there an operators right at the end of the expression?
    if ((splitedExpression[splitedExpression.length - 1].equals("+"))
        || (splitedExpression[splitedExpression.length - 1].equals("-"))
        || (splitedExpression[splitedExpression.length - 1].equals("/"))
        || (splitedExpression[splitedExpression.length - 1].equals("*")))
      {

        result = false;// if above is true
      } // End operators on right side check
    return result;
  }// end validity checker

  /**
   * Main
   * 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args)
    throws Exception
  {
    Calculator nc = new Calculator();
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("Please input expression with individual " 
                + "operators and numbers seperated by a single spaces \n"
                + "For example: 1/2 + 4");
    pen.println("Or make an assignment to a storage in the form 'store r1 Expression'");
    Scanner in = new Scanner(System.in);
    
    // make calculator mode selection
    pen.println("Please select mode (type either Expr or Exprs): ");
    String mode = in.nextLine();

    //make 5 math operations before the calculator stops running
    for (int k = 0; k < 5; k++)
      {
        if (mode.equals("Expr"))
          {
            //input expression
            pen.println("input Expresion");
            String expre = in.nextLine();
            if ((validity(expre)) == false)
              {
               // validity fails
                //Code inspired by http://stackoverflow.com/questions/10344187/illegalargumentexception
                throw new IllegalArgumentException(
                                                   "you entered an invalid expression");
              } //End Validity check
         // validity pass
            else
              {
                //evaluate expression
                pen.println(nc.evaluate(expre));
              }//Print result
          } //End Expr mode
      }// End operations

    if (mode.equals("Exprs"))
      {
        String[] tryArray = new String[5];

        pen.println("You can only enter a string of length 5");
        for (int g = 0; g < 5; g++)
          {
            pen.println("enter expression #" + g);
            String expre = in.nextLine();
            if ((validity(expre)) == false)
              {
                //Code inspired by http://stackoverflow.com/questions/10344187/illegalargumentexception
                throw new IllegalArgumentException(
                                                   "you entered an invalid expression");
              } //end Validity check
            else
              {
                tryArray[g] = expre;
                pen.println((expre));
              } //Print Expressions
          } // End printing and check expressions
        for (int h = 0; h < 5; h++)
          {
            pen.println(tryArray[h] + " = " + Calculator.evaluate(tryArray)[h]);
          } // Print ANswers

      } // End Exprs mode
    //close scanner
   in.close();
   
  } // End Main
}// End U_I