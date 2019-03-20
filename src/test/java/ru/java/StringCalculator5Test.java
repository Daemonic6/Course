package test.java.ru.java;

import org.junit.Assert;

import org.junit.Test;
import ru.java.StringCalculator5;

public class StringCalculator5Test {

  @Test
  public final void when_2_Numbers_Are_Used_Then_No_Exception_Is_Thrown() {
    StringCalculator5.add("1,2");
    Assert.assertTrue(true);
  }

  @Test(expected = RuntimeException.class)
  public final void when_Non_Number_Is_Used_Then_Exception_Is_Thrown() {
    StringCalculator5.add("1,X");
  }

  @Test
  public final void when_Empty_String_Is_Used_Then_Return_Value_Is_0() {
    Assert.assertEquals(0, StringCalculator5.add(""));
  }

  @Test
  public final void when_One_Number_Is_Used_Then_Return_Value_Is_That_Same_Number() {
    Assert.assertEquals(3, StringCalculator5.add("3"));
  }

  @Test
  public final void when_Two_Numbers_Are_Used_Then_Return_Value_Is_Their_Sum() {
    Assert.assertEquals(3+6, StringCalculator5.add("3,6"));
  }

  @Test
  public final void when_Any_Number_Of_Numbers_Is_Used_Then_Return_Values_Are_Their_Sums() {
    Assert.assertEquals(3+6+15+18+46+33, StringCalculator5.add("3,6,15,18,46,33"));
  }

  @Test
  public final void when_NewLine_Is_Used_Between_Numbers_Then_Return_Values_Are_Their_Sums() {
    Assert.assertEquals(3+6+15, StringCalculator5.add("3,6\n15"));
  }

}