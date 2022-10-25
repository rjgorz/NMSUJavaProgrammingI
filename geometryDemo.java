/*
   OECS 195 JAVA Programming I
   Assigment Module #6
   Code Author: Robert Gorz
   ProgramName: geometryDemo.java
        Calculates the area/volume/perimeter
        of triangles and squares/rectangles
        based on the input argument or lack there of
*/

package GeoGorz;

/* geometryDemo to show class inheritance 
   super class 'basicGeometry' is inherited by class 'fourSides'
   class fourSides is inherited by class 'threeSides'
 */
public class geometryDemo
{
   public static void main(String[] args)
   {
      // Create the main object. the threeSides class includes all functions, so use that 
       // because threeSides inherits (extends) all of the 4 sides public data and methods
      threeSides myGeometry = new threeSides();
      
      // OR make a 3Sides and a 4Sides, if that is easier for you to keep track of
      // from a MAINTENANCE perspective, it might be better
      fourSides geom4Sides = new fourSides();
      
      //variables for calculation outputs
      double outArea = 0;
      double outVolume = 0;
      double outPerimeter = 0;
      
      // variable acount to use in switch statement
      // variable i used to control do-while loop
      int acount;
      int i;
      
     // if input argument is detected, converts string to int value and initializes
     // variable i in order to terminate the do-while loop after one iteration
     if (args.length != 0)
     {
         acount = Integer.valueOf(args[0]);
         i = 4;
     }
     
     // if no input argument is detected, initializes variable acount and i in order
     // to run the do-while loop twice, once for 3 sided and again for 4 sided
     else {
         System.out.println("*No input parameter detected* - Calculations will be run for both 3 and 4 sided shapes.\n");
         acount = 3;
         i = 3;
     }
         //pass in number of sides... NOTE this will still crash if input is not a number
     
     
     //initialize all dimensions (firstDimension, secondDimension, thirdDimension)
     // This is INSTEAD of initializing the class object as you have done before
     //  rather than passing the values in when you create the object like
     //  threeSides myGeometry = new threeSides(12, 20, 4);
     // a method is needed to send in the initial data... 
     
     myGeometry.setDimensions(12, 20, 4);
     //initialize the 4 sided only object
     geom4Sides.setDimensions(12,20,4);
    
     // do-while used in order to check conditions after the first run, this allows one iteration
     // when an input argument is entered and two iterations when no input argument is entered
     do {
        // determine which methods for area and volume to call based on number of sides
        switch (acount)
        {
             case 3:
                 System.out.println("Triangle calculations:");
                 outArea = myGeometry.getTArea();
                 outVolume = myGeometry.getTVolume();
                 outPerimeter = myGeometry.getTPerimeter();
                 // need new call here to get perimeter, 
                   // method added to 3 sides, getTPerimeter
                 i++;
             
                 break;
             
            case 4:
                System.out.println("Square/rectangle calculations:");
                outArea = myGeometry.getShapeArea();
                outVolume = myGeometry.getVolume();
                outPerimeter = myGeometry.getPerimeter();
             
                // let's see if we get the same values using the generic myGeometry that is
                  // class threeSides inheriting (extending) 4 sides, or the actual 4sides class
                  double fsArea = geom4Sides.getShapeArea();
                 double fsVolume = geom4Sides.getVolume();
                 double fsPerimeter = geom4Sides.getPerimeter();
                 System.out.println("Using the fourSides class, Area=" + fsArea + "   Volume=" + fsVolume
                    + "   Perimeter=" + fsPerimeter);
              
                 // need new call here to get perimeter, 
                  // method added to 4 sides, getPerimeter
             
              break;
         
             // prompts the user that an invalid input was entered
             default:
                 System.out.println("Invalid argument count = " + acount + " Pass in 3 or 4 arguments");
        }

        // display the calculated area and volume
         System.out.println("Area=" + outArea + "   Volume=" + outVolume + "   Perimeter=" + outPerimeter);
         acount++;
     } while (i <= 4 && acount <=4);
   }
}