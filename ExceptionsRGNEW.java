/*
   OECS 195 JAVA Programming I
   Assigment Module #8
   Code Author: Robert Gorz
   ProgramName: ExceptionsRGNEW.java
        Checks to see if user input arguments are prime numbers
        Utilizes custom try/catch block to define an exception
        if the number is not prime
        Catches exceptions for missing input and invalid input
*/

package com.java24hours;

// prime number checker class, requires one input argument
class ExceptionsRGNEW {
    public static void main(String[] args) {
        
        // prompts user to enter an integer
        System.out.println("Please enter the integers to be checked.\n");
        
        try {
            // check to see if an input has been entered, throws exception and bypasses loop if none are present
            if (args.length == 0) {
                int check = Integer.parseInt(args[0]);
            }
            
            // loop to process all input arguments
            for (String arg : args)
                
                try {
                    
                    System.out.println("Checking " + arg + "...");
                    // converts user input to int variable and initializes boolean to assume number is prime
                    int num = Integer.parseInt(arg);
                    boolean prime = true;
            
                    // loop to check if input is not prime, modifies check to false if it's not
                    for (int i = 2; i <= num/2; ++i) {
                        if (num % i == 0) {
                            prime = false;
                            break;
                        }
                    }
                    // object of custom exception thrown for all non prime numbers
                    if (prime == false) {
                        throw new RGExceptionNEW(num + " is not a prime number, sorry!\n");
                    // only prime numbers are accepted
                    } else {
                        System.out.println(num + " is a prime number!\n");
                    }
                }
        
                // prints a user exception is detected, prints the thrown message
                catch (RGExceptionNEW x) {
                    System.out.println("User exception detected...");
                    System.out.println(x.getMessage());
                }
        
                // exception case for when the input argument is not an integer, prompts user to enter a proper integer
                catch (NumberFormatException e) {
                    System.out.println("Input must be an integer! " + arg + " is not an integer.\n");
                }
        }
        // exception case for when no input argument is detected, prompts user to enter one
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No input argument detected! "
                + "Please input an integer.\n");
            }
        
    }
}