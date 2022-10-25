package GeoGorz;

public class basicGeometry
{
   //length and width of initial shape; for triangle, length is height
   double firstDimension;  
   double secondDimension; 
   double thirdDimension;

   //initialize shape dimensions
   public void setShape(double dim1, double dim2, double dim3)
   {
      firstDimension = dim1;
      secondDimension  = dim2;
      thirdDimension = dim3;
   }
 
}