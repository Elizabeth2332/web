/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package craps;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author elizabeth
 */
public class CRAPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //loop
        //call play
        Scanner userInput = new Scanner(System.in);//Scaner for the user input
        do{
            System.out.println("GAME OF CAPS!");
            CRAPS myGame =  new CRAPS();// Create a new CRAPS instance and play the game
            myGame.rollDice(); // Call initial dice roll 
            myGame.play();// Call play function 
             // Ask the player if they want to play again
            System.out.println("Do you whant to play again? Enter Y to play again,N to end: ");
            String input = userInput.nextLine();
            
             // Exit if the user chooses "N"
            if (input.equalsIgnoreCase("N")){
                System.out.println("Thank you for playing!");
                break;
            }
        }while(true);
        
    }
    
    public int rollDice(){
        Random r = new Random();//generate random numbers
        int num1 = 1 + r.nextInt(6);//First number of a dice roll
        int num2 = 1 + r.nextInt(6);//Second number of a dice roll
        int sum = num1 + num2;//calculate the sum of two random numbers
        return sum; //return the sum of two dice rolls
    }
    
    //Main game logic for playing every round 
    public void play(){
        //call rollDice
        int sum = rollDice();//First dice roll
        System.out.println("Point: "+ sum);
        
        //Check for an immediate loss on the first dice roll
        if(sum == 2 || sum == 3 || sum == 12 ){
            System.out.println("You lost");
        }
        //Check for an immediate win
        else if(sum == 7|| sum == 11){
            String ImmedWin = "Immediate win with:";
            System.out.printf("%-15s %15s %n",ImmedWin, sum);
        }
        //Continue rolling 
        else {
            
            int point = sum;
            String heading1 = "New Roll";
            String heading2 = "Outcome";
            System.out.printf( "%-15s %15s %n", heading1, heading2);
            /*System.out.println("New Roll                     Outcome");**/
            System.out.println("------------------------------------");
            
              // Loop until the player wins by making the point or loses by rolling a 7
            while(true){
                sum = rollDice();
                // Check if the player makes the point and wins
                if(point == sum){
                    String won = "Made point, won!";
                    System.out.printf("%-15s %15s %n", point, won);
                    break;
                }
                // Check if the player loses by rolling a 7
                else if(sum == 7){
                    String seven = "7";
                    String lost = "You lost with 7";
                    System.out.printf( "%-15s %15s %n", seven, lost);
                    break;
                }
                //Continue rolling
                else {
                    String noHelp = "No Help";
                    System.out.printf("%-15s %15s %n", sum, noHelp);
                }
            }  
        }
    }
}
