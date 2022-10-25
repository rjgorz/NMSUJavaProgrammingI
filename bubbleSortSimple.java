/*
   OECS 195 JAVA Programming I
   Assigment Module #5
   Code Author: Robert Gorz
   ProgramName: bubbleSortSimple.java
        Utilizes the "bubble sort" method to sort a defined array
            of numbers from largest to smallest value
        Calculates the mean and median values for arrays with both even
            and odd total number of elements
*/

package com.java24hours;

// Java program for implementation of Bubble Sort
class BubbleSortSimple
{
    // simple bubble sort
    public static void main(String args[])
    {
        //create an array of unsorted numbers
        int arr[] = {7, 18, 7, 3, 29, 5, 3, 17, 29, 7, 12, 14, 17, 3, 7, 22, 21, 30, 7, 3, 13};
        // print the unsorted array
        int alength = arr.length; // get the array length once, and store it
        
        System.out.println("Here is the initial unsorted array");
        for (int i=0; i< alength; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        
        //use the BUBBLE SORT algorithm to loop and reloop the array until it is sorted
        // n is the array length
        
        //loop the entire array in the outer loop
        for (int outer = 0; outer < alength - 1; outer++)
        {
            //the inner loop checkes the value of an element against the next element
            //  and swaps if the first is smaller than the second
            // this bubbles the SMALLEST value to the end every time
            // so this loop only needs to go to the element BEFORE it's last element 
            //     from the last loop
            for (int inner = 0; inner < alength - outer - 1; inner++)
            {
                System.out.println("COMPARING elements arr[" + inner + "] and arr[" + (inner + 1) + "]");
                System.out.println("CURRENT VALUES ARE: " + arr[inner] + "  and " + arr[inner + 1]); 
                if (arr[inner] < arr[inner+1])
                {
                    // swap ... HOLD the smaller in temp
                    //  move the LARGER to the array element before its current location
                    //    (where the smaller element was)
                    
                    int temp = arr[inner];
                    arr[inner] = arr[inner+1];
                    arr[inner+1] = temp; //put the smaller element into the higher array element
                    System.out.println("Swapped elements " + inner + " and " + (inner + 1));
                    System.out.println("NEW VALUES ARE: " + arr[inner] + "  and " + arr[inner + 1]);
                }
            }//inner loop
        } //outer loop
        
        System.out.println("");
        System.out.println("SORT COMPLETE!!");
        System.out.println("Here is the final sorted array");
        for (int i=0; i< alength; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
        
        float total = 0;
        
        // loop to add all numbers within the array
        for (int index = 0; index < alength; index++) {
            total = total + arr[index];
        }
        // calculate the mean of the array using the added total and the array length
        float mean = total / alength;
        System.out.println("The mean value is: " + mean);
        
        // condition for arrays with even number of elements
        //  identifies the two middle elements and calculates the average between them to define the median
        if (arr.length % 2 == 0) {
            System.out.println("The array has an even number of elements.");
            int medianLow = (arr.length / 2) - 1;
            int medianHigh = medianLow + 1;
            float median = (float)(arr[medianLow] + arr[medianHigh]) / 2;
            System.out.println("The median value of the array is: " + median);
        }
        // condition for arrays with odd number of elements
        //  identifies the middle element to define the median
        else {
            System.out.println("The array has an odd number of elements.");
            int median = (arr.length - 1) / 2;
            System.out.println("The median value of the array is: " + arr[median]);
        }       
    } //main
}