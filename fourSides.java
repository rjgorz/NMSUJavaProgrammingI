package GeoGorz;

//everyting in basicGeometry can be accessed by foursides... 
public class fourSides extends basicGeometry
{
   
   public void setDimensions(double dimension1, double dimension2, double dimension3)
   {
      // use inherited method for initial area dimensions
      setShape(dimension1,dimension2, dimension3); 

   }
 
   //calculate the area and return to requestor
   public double getShapeArea()
   {
      return firstDimension * secondDimension;
   }
   
   //method to return volume for 4 sided object
   public double getVolume()
   {
      //use the inherited getArea method and apply depth for volume calculation
      return getShapeArea() * thirdDimension;
   }
   
   //method to return perimeter for 4 sided object
   public double getPerimeter()
   {
       return ((firstDimension * 2) + (secondDimension * 2));
   }
}