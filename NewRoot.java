/*
   OECS 195 JAVA Programming I
   Assigment Module #6
   Code Author: Robert Gorz
   ProgramName: NewRoot.java
        Converts a user input to numeric value
        to use in several different functions
        pulled from the Math library
*/

package com.java24hours;

class NewRoot {
    public static void main(String args[]) {
        int number = 100;
        // convert the input string to a numeric int value
        if (args.length > 0) {
            number = Integer.parseInt(args[0]);
        }
        
        // raise the input to the third power and display the result
        System.out.println("The third power of "
        + number
        + " is "
        + Math.pow(number, 3)
        );
        
        // convert the input number to its opposite value (positive/negative) and display the result
        int oppNumber = Math.negateExact(number);
        System.out.println("The opposite of "
        + number
        + " is "
        + oppNumber
        );
        
        // initializes properties of a triangle, uses the Math library to convert degrees to radians to use below
        int angleDeg = 30;
        int a = number;
        double angleRad = Math.toRadians(angleDeg);
        
        // displays the known triangle properties and prompts the problem to solve
        System.out.println("A right triangle is know with side length a = "
        + a + " and an angle = "
        + angleDeg + " degrees. Solve for the hypotenuse.");
        
        // calculates the hypotenuse of the triangle using the sine function of the Math library
        double c = (int)(a / Math.sin(angleRad));
        System.out.println("The hypotenuse length = "
        + c
        );
    }
}