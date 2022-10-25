package GeoGorz;

//triangle calculations inherit rectangle and main geometry classes
public class threeSides extends fourSides
{
    //triangles cut square/rectangle measurements in half
   double inHalf = .5;  
   
   //triangle area is half of rectangle area
   public double getTArea()
   {
       //use the inherited method for area, and cut in half for triangle
       return getShapeArea() * inHalf;
   }
 
   //triangle volume first 3 dimensions multiplied, then cut in half
   public double getTVolume()
   {
      //use the inherited method for volume, and cut in half for triangle
      return (firstDimension * secondDimension * thirdDimension * inHalf);
   }
   
   //triangle perimeter is sum of all dimensions, assuming they represent all 3 side lengths
   public double getTPerimeter()
   {
      return (firstDimension + secondDimension + thirdDimension);
   }
}