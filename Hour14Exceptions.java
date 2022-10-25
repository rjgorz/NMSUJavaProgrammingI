
package com.java24hours;

//user defined exception accepts string as input
class MyException extends Exception 
{ 
    public MyException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 

class MyException_Demo 
{ 
    public static void main(String args[]) 
    { 
	//divide by 0; arithmetic exception
        try { 
            int n1 = 30, n2 = 0; 
            int n3 = n1/n2;  
            System.out.println ("Answer=" + n3); 
        } 
        catch(ArithmeticException e) { 
            System.out.println ("ArithmeticException"); 
        } 

	//null string pointer (would work for any bad pointer)
       try { 
            String mys = null; //no data in string
            System.out.println(mys.charAt(0)); 
        } 
        catch(NullPointerException e) { 
            System.out.println("NullPointerException"); 
        } 

       //string character index out of bounds exception
       try { 
            String mysoob = "Test for out of bounds character access"; 
            char myc = mysoob.charAt(99);  
            System.out.println(myc); 
        } 
        catch(StringIndexOutOfBoundsException e) { 
            System.out.println("StringIndexOutOfBoundsException"); 
        } 

        //array index out of bounds exception
        try{ 
            int myarray[] = new int[20]; 
            myarray[20] = 9; // last element of array is [19]
        } 
        catch(ArrayIndexOutOfBoundsException e){ 
            System.out.println ("ArrayIndexOutOfBoundsException"); 
        } 
        try { 
            // convert non numeric string to number = format exception 
            int mynum = Integer.parseInt ("qwerty") ; 
            System.out.println(mynum); 
        }
         catch(NumberFormatException e) { 
            System.out.println("NumericFormatException"); 
        } 
   
        //custom exception
        try
        { 
            for (int idx = 0; idx < 6; ++idx)
            {
              switch (idx)
              {
                  //all 'even' values are acceptable
                  case 0:
                  case 2:
                  case 4:
                      System.out.println("EvenValue=" + idx);
                  break;
                      
                  case 1:
                  case 3:
                  case 5:
                    // Throw an object of user defined exception on 3 only
                      if (idx == 3)
                              throw new MyException("String to print with user information = " + idx);
                      else
                          System.out.println("OddValue=" + idx);
                  break;
              }
            }
        } 
        catch (MyException e) 
        { 
            System.out.println("User exception caught!!!"); 
            // Print the message from MyException object 
            System.out.println(e.getMessage()); 
        } 
    } 
} 

