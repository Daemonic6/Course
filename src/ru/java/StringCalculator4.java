package ru.java;

  public class StringCalculator4 {

    public static int add(final String numbers) {
      int returnValue = 0;
      String[] numbersArray = numbers.split(",");
      for (String number : numbersArray) {
        if (!number.trim().isEmpty()) {
          returnValue += Integer.parseInt(number);
        }
      }
      return returnValue;
    }


  }
