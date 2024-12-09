package org.example;
import java.io.*;
import java.lang.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

// Driver class
public class BasicCalculator {
  // main function
  public static void main(String[] args)
  {
    // Stores two numbers
    double num1, num2;

    // Take input from the user
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the numbers:");

    // Take the inputs
    num1 = sc.nextDouble();
    num2 = sc.nextDouble();

    System.out.println("Enter the operator (+,-,*,/):");

    char op = sc.next().charAt(0);
    double o = 0;

    switch (op) {
      // case to add two numbers
      case '+':
        o = add(num1, num2);
        break;

      // case to subtract two numbers
      case '-':
        o = subtract(num1, num2);
        break;

      // case to multiply two numbers
      case '*':
        o = multiply(num1, num2);
        break;

      // case to divide two numbers
      case '/':
        o = divide(num1, num2);
        break;

      default:
        System.out.println("You enter wrong input");
    }

    System.out.println("The final result:");
    System.out.println();

    // print the final result
    System.out.println(num1 + " " + op + " " + num2
        + " = " + o);
  }
  public static double add(double summand1, double summand2) {
    return summand1 + summand2;
  }
  public static double subtract(double summand1, double summand2) {
    return summand1 - summand2;
  }
  public static double multiply(double summand1, double summand2) {
    return summand1 * summand2;
  }
  public static double divide(double summand1, double summand2) {
    if (summand2 == 0) {
      throw new ArithmeticException("Cannot divide by zero");
    }
    return summand1 / summand2;
  }

  public static ArrayList<Integer> findIndexes(ArrayList<Integer> nums, Integer taget) {
    for (int i = 0; i < nums.size(); i++) {
      for (int j = i+1; j < nums.size(); j++) {
        if(nums.get(i).equals(nums.get(j))){
          return(new ArrayList<Integer>(i));
        }
      }
    }
    return new ArrayList<>();
  }
}
