package edu.grinnell.csc207.username.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class StringUtilsTest
{

  @Test
  public void
    test1 ()
  {
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitAt ("a:b:c", ':'));
  }
    @Test
    public void
      test2 ()
    {
    assertArrayEquals (new String[] { "a", "b", "c" },
                       StringUtils.splitAt ("a b c", ' '));
    }
    @Test
    public void
      test3 ()
    {
    assertArrayEquals (new String[] { "a:b:c" },
                       StringUtils.splitAt ("a:b:c", ' '));
    }
    @Test
    public void
      test4 ()
    {
    assertArrayEquals ("one field", new String[] { "a" },
                       StringUtils.splitAt ("a", ':'));
    }
    @Test
    public void
      test5 ()
    {
    assertArrayEquals ("empty inner field", new String[] { "a", "", "c" },
                       StringUtils.splitAt ("a::c", ':'));
    }
    @Test
    public void
      test6 ()
    {
    assertArrayEquals ("leading empty field", new String[] { "", "a" },
                       StringUtils.splitAt (":a", ':'));
    }
    @Test
    public void
      test7 ()
    {
    assertArrayEquals ("trailing empty field", new String[] { "a", "" },
                       StringUtils.splitAt ("a:", ':'));
    }
    
    @Test
    public void
      test8 () 
    {
  assertEquals ("e", StringUtils.deLeet ("3"));
    }
    @Test
    public void
      test9 ()
    {
  assertEquals ("leet", StringUtils.deLeet ("133+"));
    }
    @Test
    public void
      test10 ()
    {
  assertEquals ("eat banana", StringUtils.deLeet ("3@+ |3@|\\|@|\\|@"));
    }
    @Test
    public void
      test11 ()
    {
    assertEquals (BigInteger.valueOf (0), Calculator.eval0 ("0"));
    assertEquals (BigInteger.valueOf (2), Calculator.eval0 ("1 + 1"));
    assertEquals (BigInteger.valueOf (4), Calculator.eval0 ("1 + 2 + 1"));
    assertEquals (BigInteger.valueOf (9), Calculator.eval0 ("1 + 2 * 3"));
    }
}


