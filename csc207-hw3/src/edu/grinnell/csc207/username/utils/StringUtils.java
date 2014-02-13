package edu.grinnell.csc207.username.utils;



public class StringUtils
{
  //Method: splitAt
  //Takes a string and a character
  //Splits a String into a number of substrings, separating the strings at the character ch.
  //The String " A:B:C:D:E" when separating at the : would return an array of the strings "A" "B" "C" "D" "E".
  
  public static
 String[] splitAt (String str, char ch)
 {
   java.io.PrintWriter pen = new java.io.PrintWriter (System.out, true);
   //ArrayList to store a variable amount of substrings
   java.util.ArrayList<String> DynStrs = new java.util.ArrayList<String>();

   //The most recent ch
int lastbreak = 0;
  //The last ch in the string
int finalbreak = str.lastIndexOf (ch);
pen.print ("final break: " + finalbreak);
  //the next ch in the string
int nextbreak = str.indexOf (ch);
if (nextbreak == 0)
DynStrs.add ("");

while (lastbreak < finalbreak)
  {
      nextbreak = str.indexOf(ch, lastbreak);
      //if ((str.charAt(lastbreak) == ch) && (str.charAt(lastbreak - 1) == ch))
         // DynStrs.add ("f");      
      DynStrs.add (str.substring (lastbreak, nextbreak));
      lastbreak = (nextbreak + 1);
   
  }//End String Parsing
   DynStrs.add (str.substring (finalbreak + 1));
   DynStrs.trimToSize ();

String[] result = new String[DynStrs.size ()];
DynStrs.toArray (result);
return result;

 }// stringSplit
  
  
  //Method deLeet:
  //Takes a string of 1337 text and translates it to plain english. Only letters: a, b, c, d, e, l, n, o, t implemented.
    public static
  String deLeet (String str)
  {
    //counter variable for while loop
    int counter = 0;
    //Current char
    char ch;
    //StringBuffer to build the string with
    StringBuffer buf = new StringBuffer();    
    //Parses string char by char. 
        while (counter < str.length())
      {
        ch = str.charAt(counter);
        if (ch == 32){
          buf.append (' ');
          counter++;
         }//space
        
        else if (ch == 64){
            buf.append ('a');
            counter++;
         }// @
        else if (ch == 51){
            buf.append ('e');
            counter++;
          }// 3
          else if ((ch == 124) && str.charAt(counter + 1) == 51){
          buf.append ('b');
          counter = counter + 2;
          }// |3
        else if (ch == 60){
          buf.append ('c');
          counter++;
          }// <
          else if (ch == 60 && str.charAt(counter + 1) == 124){
          buf.append ('d');
          counter = counter + 2;
          }// <|
        else if (ch == 49){
          buf.append ('l');
          counter++;
          }// 1
        else if ((ch == 124) && str.charAt(counter + 2) == 124){
          buf.append ('n');
          counter = counter + 3;
          }// |\|
        else if (ch == 48){
          buf.append ('o');
          counter++;
          }// 0
        else if (ch == 43){
          buf.append ('t');
          counter++;
          }// +
        else
        counter++;
      }//End While Loop
        return buf.toString();    
  } //deLeet
  
    //method nameGame
    //Takes a name in string form
    //Returns a rhyme based on the inputed name. Whill drop the first letter (or first letters for names like Cheryl) to make it easier to rhyme
  public static
  void nameGame (String str)
  {
    java.io.PrintWriter pen = new java.io.PrintWriter (System.out, true);
    String name;
    //test if the name has a common two cons start
    if (str.charAt (1) == 'h' && ( 
        (str.charAt(0) == 'S')||
        (str.charAt(0) == 'P')||
        (str.charAt(0) == 'T')|| 
        (str.charAt(0) == 'C') ) )
      {
        name = str.substring (2);
      }
    else
      //name w/o starting consonants
       name = str.substring (1);
    //print song
    pen.println (str + "!");
    pen.println (str + ", " + str + " bo B" + name + " Bonana fanna fo F" + name );
    pen.println ("Fee fy mo M" + name + ", " + str);
  }//name game

  

  /**
   * @param args
   */
  public static void
    main (String[] args)
  {
  nameGame ("Shirley");
  nameGame ("Lincoln");
  nameGame ("Phineas");

  } //Main Tests

}//End Class
