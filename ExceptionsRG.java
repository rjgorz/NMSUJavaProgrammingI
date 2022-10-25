/*
   OECS 195 JAVA Programming I
   Assigment Module #8
   Code Author: Robert Gorz
   ProgramName: ExceptionsRG.java
        Checks to see if a user input argument is a prime number
        Utilizes custom try/catch block to define an exception
        if the number is not prime
        Catches exceptions for missing input and invalid input
*/

package com.java24hours;

// user defined exception accepts string as input
class RGException extends Exception 
{ 
    public RGException(String x) { 
        // call constructor of parent Exception 
        super(x); 
    } 
} 

// prime number checker class, requires one input argument
class ExceptionRG {
    public static void main(String[] args) {
        
        try {
            // prompts user to enter an integer
            System.out.println("Please enter an integer to be checked. "
                    + "Only the first integer will be processed.");
            
            // converts user input to int variable and initializes boolean to assume number is prime
            int num = Integer.parseInt(args[0]);
            boolean check = true;
            
            // loop to check if input is not prime, modifies check to false if it's not
            for (int i = 2; i <= num/2; ++i) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            // object of custom exception thrown for all non prime numbers
            if (check == false) {
                System.out.println("Checking...");
                throw new RGException(num + " is not prime, it won't work!");
            // only prime numbers are accepted
            } else {
                System.out.println("Checking...");
                System.out.println("Perfect, " + num + " is a prime number!");
            }
        }
        
        // prints a user exception is detected, prints the thrown message
        catch (RGException x) {
                System.out.println("User exception detected...");
                System.out.println(x.getMessage());
        }
        
        // exception case for when no input argument is detected, prompts user to enter one
        catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("No input argument detected! "
                    + "Please input an integer.");
        }
        
        // exception case for when the input argument is not an integer, prompts user to enter a proper integer
        catch (NumberFormatException e) {
                System.out.println("Input must be an integer! " + args[0] + " is not an integer.");
        }
    }
}

