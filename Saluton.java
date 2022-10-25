package com.java24hours;

class Saluton {
        public static void main(String[] arguments)  {
            int length,width,RATE,TIME,DISTANCE;
            
            //main code for program here
            String greeting = "Saluton mondo!";
            System.out.println(greeting);
            
            length = 5;
            width = 3;  //assigning values to rectangle dimensions
            greeting = "The area of the rectangle = ";
            System.out.println(greeting + (length * width));  //calculate the area of a rectangle
            
            RATE = 75;
            TIME = 9;  //assigning values to vehicle speed and time spent driving
            DISTANCE = (RATE * TIME);  //calculate distance traveled to track mileage
            greeting = "The total vehicle mileage for this trip is ";
            System.out.println(greeting + DISTANCE + " miles");
            
            int y = 0;
            for (int x = 0; x <= 100; ++x) {
                y++;
                System.out.println("Variable Y = " +y);
            }
        }
}