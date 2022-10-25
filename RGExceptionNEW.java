package com.java24hours;

// user defined exception accepts string as input
class RGExceptionNEW extends Exception 
{ 
    public RGExceptionNEW(String x) { 
        // call constructor of parent Exception 
        super(x); 
    } 
} 