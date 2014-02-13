package hw4;

/**
 * A simple Integer calculator
 * 
 * @author mataires & Schlossb
 * @author CSC207 2014S
 */
public class Calculator
{

  static Fraction temp1 = new Fraction (0); // calculation value
  /**
   * Registers
   */
  static Fraction r0 = new Fraction (0);
  static Fraction r1 = new Fraction (0);
  static Fraction r2 = new Fraction (0);
  static Fraction r3 = new Fraction (0);
  static Fraction r4 = new Fraction (0);
  static Fraction r5 = new Fraction (0);
  static Fraction r6 = new Fraction (0);
  static Fraction r7 = new Fraction (0);

  /**
   * make expression into array
   * 
   * @param input
   * @return a string array of the expression (i.e the 'input')
   */
  public static String[]
    breakInput_Int (String input)
  {
    String[] splitedInput = new String[] {};
    splitedInput = (input.split (" "));
    return splitedInput;
  } // breakInput_Int

  /**
   * evaluate expression
   * 
   * @param expression
   * @return answer to expression
   */
  public static Fraction
    evaluateHelper_int (String[] expression)
  {
    Fraction answer = new Fraction (0);

    if (expression[1].equals ("+"))
      {
        answer = new Fraction (expression[0]).add (new Fraction (expression[2]));
      } // If addition
    else if (expression[1].equals ("-"))
      {
        answer = new Fraction (expression[0]).sub (new Fraction (expression[2]));
      } // If subtraction
    else if (expression[1].equals ("*"))
      {
        answer = new Fraction (expression[0]).mult (new Fraction (expression[2]));
      } // If Mult
    else if (expression[1].equals ("/"))
      {
        answer = new Fraction (expression[0]).div (new Fraction (expression[2]));
      } // If Div

    return answer;
  } // End Eval Helper

  /**
   * answer modifier
   * 
   * @param expression
   * @return modified answer
   */

  public static Fraction
    answer_modifier (String[] expression)
  {
    Fraction answer = new Fraction (0);

    if (expression[0].equals ("+"))
      {
        answer = temp1.add (new Fraction (expression[1]));
      } // If addition
    else if (expression[0].equals ("-"))
      {
        answer = temp1.sub (new Fraction (expression[1]));
      } // If subtraction
    else if (expression[0].equals ("*"))
      {
        answer = temp1.mult (new Fraction (expression[1]));
      } // If multiplication
    else if (expression[0].equals ("/"))
      {
        answer = temp1.div (new Fraction (expression[1]));
      } // If division

    return answer;
  } // End answerModifier

  /**
   * evaluates the input expression
   * 
   * @param expression
   * @return final answer (temp1)
   */
  public static Fraction
    evaluate (String expression)
  {
    String[] expree = new String[] {};
    expree = breakInput_Int (expression);

    // expression array
    String[] finalString = new String[3];

    // check whether the user wants to store a value in one of the registers
    if (expree[0].equals ("store"))
      {
        if (expree[1].equals ("r0"))
          {
            r0 = new Fraction (expree[2]);
          } // Store r0
        else if (expree[1].equals ("r1"))
          {
            r1 = new Fraction (expree[2]);
          } // Store r1
        else if (expree[1].equals ("r2"))
          {
            r2 = new Fraction (expree[2]);
          } // Store r2
        else if (expree[1].equals ("r3"))
          {
            r3 = new Fraction (expree[2]);
          } // Store r3
        else if (expree[1].equals ("r4"))
          {
            r4 = new Fraction (expree[2]);
          } // Store r4
        else if (expree[1].equals ("r5"))
          {
            r5 = new Fraction (expree[2]);
          } // Store r5
        else if (expree[1].equals ("r6"))
          {
            r6 = new Fraction (expree[2]);
          } // Store r6
        else if (expree[1].equals ("r7"))
          {
            r7 = new Fraction (expree[2]);
          } // Store r7
      } // End storage

    // simply expressions that have registers included in the expression
    else
      {
        if (expree[0].equals ("+") || expree[0].equals ("-")
            || expree[0].equals ("*") || expree[0].equals ("/")
            || expree[0].equals ("^"))
          {
            // do nothing, just used the input expression
            temp1 = answer_modifier (expree);
          } // End conditional

        // Also simplify expressions with registers included
        else
          {
            if (expree[0].contains ("r"))
              {
                if (expree[0].equals ("r0"))
                  {
                    finalString[0] = r0.toString ();
                  } // convert r0
                else if (expree[0].equals ("r1"))
                  {
                    finalString[0] = r1.toString ();
                  } // convert r1
                else if (expree[0].equals ("r2"))
                  {
                    finalString[0] = r2.toString ();
                  } // convert r2
                else if (expree[0].equals ("r3"))
                  {
                    finalString[0] = r3.toString ();
                  } // convert r3
                else if (expree[0].equals ("r4"))
                  {
                    finalString[0] = r4.toString ();
                  } // convert r4
                else if (expree[0].equals ("r5"))
                  {
                    finalString[0] = r5.toString ();
                  } // convert r5
                else if (expree[0].equals ("r6"))
                  {
                    finalString[0] = r6.toString ();
                  } // convert r6
                else if (expree[0].equals ("r7"))
                  {
                    finalString[0] = r7.toString ();
                  } // convert r7
                // assign the unassigned references
                finalString[1] = expree[1];
                finalString[2] = expree[2];
              } // End Conversion 1
            // Also simplify expressions with registers included
            else if (expree[2].contains ("r"))
              {
                if (expree[2].equals ("r0"))
                  {
                    finalString[2] = r0.toString ();
                  } // Convert r0
                else if (expree[2].equals ("r1"))
                  {
                    finalString[2] = r1.toString ();
                  } // Convert r1
                else if (expree[2].equals ("r2"))
                  {
                    finalString[2] = r2.toString ();
                  } // Convert r2
                else if (expree[2].equals ("r3"))
                  {
                    finalString[2] = r3.toString ();
                  } // Convert r3
                else if (expree[2].equals ("r4"))
                  {
                    finalString[2] = r4.toString ();
                  } // Convert r4
                else if (expree[2].equals ("r5"))
                  {
                    finalString[2] = r5.toString ();
                  } // Convert r5
                else if (expree[2].equals ("r6"))
                  {
                    finalString[2] = r6.toString ();
                  } // Convert r6
                else if (expree[2].equals ("r7"))
                  {
                    finalString[2] = r7.toString ();
                  } // Convert r7
                // assign the unassigned references
                finalString[1] = expree[1];
                finalString[0] = expree[0];
              }// End conversion2
            // no registers - do nothing
            else
              finalString = expree;

            // evaluate - send to evaluate_Helper
            temp1 = evaluateHelper_int (finalString);
          }
      } // End Reg storage
    return temp1.simplify ();
  } // End Evaluate

  /**
   * evaluate input string
   * 
   * @param expressions
   * @return answer string
   */
  public static Fraction[]
    evaluate (String[] expressions)
  {
    Fraction[] resArray = new Fraction[expressions.length];
    for (int i = 0; i < expressions.length; i++)
      {
        // evaluate each array entry
        resArray[i] = evaluate (expressions[i]);

      }//End array parsing
    return resArray;
  } //End array evaluate
  
}// End Calculator
