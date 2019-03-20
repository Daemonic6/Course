package ru.java;

public class StringCalculator5 {

  public static int add(final String numbers) {
    int returnValue = 0;
    String[] numbersArray = numbers.split(",|\n");
    for (String number : numbersArray) {
      if (!number.trim().isEmpty()) {
        returnValue += Integer.parseInt(number.trim());
      }
    }
    return returnValue;
  }


}