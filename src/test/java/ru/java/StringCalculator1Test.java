package test.java.ru.java;

import org.junit.Assert;
import org.junit.Test;
import ru.java.StringCalculator1;


public class StringCalculator1Test {
  @Test(expected = RuntimeException.class)
  public final void when_More_Than_2_Numbers_Are_Used_Then_Exception_Is_Thrown() {
    StringCalculator1.add("1,2,3");
  }
  @Test
  public final void when_2_Numbers_Are_Used_Then_No_Exception_Is_Thrown() {
    StringCalculator1.add("1,2");
    Assert.assertTrue(true);
  }
  @Test(expected = RuntimeException.class)
  public final void when_Non_Number_Is_Used_Then_Exception_Is_Thrown() {
    StringCalculator1.add("1,X");
  }
}
