package test.java.ru.java;

import org.junit.Assert;

import org.junit.Test;
import ru.java.StringCalculator2;

public class StringCalculator2Test {

  @Test(expected = RuntimeException.class)
  public final void when_More_Than_2_Numbers_Are_Used_Then_Exception_Is_Thrown() {
    StringCalculator2.add("1,2,3");
  }

  @Test
  public final void when_2_Numbers_Are_Used_Then_No_Exception_Is_Thrown() {
    StringCalculator2.add("1,2");
    Assert.assertTrue(true);
  }

  @Test(expected = RuntimeException.class)
  public final void when_Non_Number_Is_Used_Then_Exception_Is_Thrown() {
    StringCalculator2.add("1,X");
  }

  @Test
  public final void when_Empty_String_Is_Used_Then_Return_Value_Is_0() {
    Assert.assertEquals(0, StringCalculator2.add(""));
  }

}