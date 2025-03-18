/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculator;

import java.util.Scanner;

/**
 *
 * @author YelyzavetaOjog(Dundrum)
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);//Create a Scanner object to take user input
        
        // Declare variables to store results
        double answerD = 0.0;//For storing division results as a double
        long answerLong = 0;// For storing results of other operations as a long
        
        
        
        System.out.println("Enter the first a hall number:");//prompt the user to enter the first integer
        int num1 = userInput.nextInt();//Read the first integer
        System.out.println("Enter the second a hall number:");//prompt the user to enter the second integer
        int num2 = userInput.nextInt();//Read the second integer
        System.out.println("Enter the operation(division /, adding +, subtracting -, multiplication *):");//prompt the user to enter the operation
        String operation = userInput.next();//Read the operation as a string
        
        if(operation.equals("/"))// Check if the operation is division
        {
            if(num1 == 0 || num2 == 0)// Check if either number is 0 (to prevent division by zero)
            {
                System.out.println("This operation is not possible, because one of the nubers is 0. Enter any other hall number except 0");
            }
            else
            {
                answerD = (double) num1 / num2;// Doing calculations
                System.out.printf("%.2f", answerD);// Format the result to 2 decimals after a dot and display it
            }
        }
        else if(operation.equals("+"))//Check if the operation is adding
        {
            answerLong = (long) num1 + num2;//Doing calculations
            System.out.println(answerLong);//Display the result
        }
         else if(operation.equals("-"))//Check if the operation is subtructing
        {
            answerLong = (long) num1 - num2;//Doing calculations
            System.out.println(answerLong);//Display the result
        }
         else if(operation.equals("*"))//Check if the operation is multiplication
        {
            answerLong = (long) num1 * num2;//Doing calculations
            System.out.println(answerLong);//Display the result
        }
        
       
    }
    
    
}
