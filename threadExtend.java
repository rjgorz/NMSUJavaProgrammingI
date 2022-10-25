/*
   OECS 195 JAVA Programming I
   Assigment Module #9
   Code Author: Robert Gorz
   ProgramName: threadExtend.java
        Demonstrates the use of multiple threads
        running simultaneously and passing in data
        to the main program
        Measures and displays the time each thread is executed
        and how long it takes to perform a loop of math problems
        while running several other threads
*/

package com.java24hours;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


class WorkerThread extends Thread {

    int threadId; // unique ID passed in by each thread started by the main code
    int threadNumber; // order of threads created
    
    // create a variable to hold the current date/time for display in the thread
    // show MILLISECONDS
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    
    // thread contructor to accept input ID
    WorkerThread(int threadId, int threadNumber)
    {
        this.threadId = threadId;
        this.threadNumber = threadNumber;
    }
    
    
    @Override
    public void run() {
        
        long startns;
        long endns;
        long diffns;
        
        // show each thread unique execution
        /** NOTE the threads are running as simultaneously as possible
         *    see the thread NUMBER and TIME in milliseconds... 
         *    each thread is running 5 loops and sleeping for 250 milliseconds
         *      that is 4 times per second, so for 4 loops, each thread should take 1 second
         */
        for(int i=0; i < 5; i++) {
            // UPDATE the time in every loop
            Date currentdate = new Date();
            
            System.out.println(this.threadNumber + ": thread in loop " + i + " of thread with ID: " + this.threadId);
            String stringDate = sdf.format(currentdate);
            
            System.out.print("  Time of execution: " + stringDate);
            // Sleep for 1/4 second (sleep is in ms)
            
            // identifies when user created thread is running
            // performs math loop and displays the time in nanoseconds to execute
            if (this.threadNumber == 5) {
                System.out.println("  <-- This is Robert's thread... ID " + threadId);
                startns = System.nanoTime();
                // loop to perform several math problems
                for (int idx = 0; idx < 50000; ++idx) {
                    int multiply = 19 * idx;
                    int divide = 541/(idx + 1);
                    double sqrt = Math.sqrt(idx);
                }
                endns = System.nanoTime();
                // utilizes recorded start and end times to display the total elapsed time
                // it took the thread to execute the math loop
                diffns = endns - startns;
                System.out.println(this.threadNumber + ": My thread math loop took: " + diffns + " nanoseconds");
            
            }
            
            // breaks up the output    
            System.out.println("");
            
            try {
                Thread.sleep(250); // each loop should be about 250ms apart
            } catch (InterruptedException e) {
                // Worker class has an  interrupt() method because it inherits from Thread
                // could be used to stop a thread on an alarm from the main code
                System.out.println("\nInterupt caught in thread: "+ this.threadId + " " + e.getMessage() + "\n");
                break;
            }
        }
    }

}

public class threadExtend {
    
    public static void main(String[] args) 
    {
        // create five working threads with unique IDs
        WorkerThread worker1 = new WorkerThread(135,1);
        worker1.start();
        
        try {
            // delay 10 ms before starting second thread
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(threadExtend.class.getName()).log(Level.SEVERE, null, ex);
        }
        WorkerThread worker2 = new WorkerThread(246,2);
        worker2.start();
        
        try {
            // delay 10 ms before starting third thread
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(threadExtend.class.getName()).log(Level.SEVERE, null, ex);
        }
        WorkerThread worker3 = new WorkerThread(790,3);
        worker3.start();
        
        try {
            // delay 10 ms before starting fourth thread
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(threadExtend.class.getName()).log(Level.SEVERE, null, ex);
        }
        WorkerThread worker4 = new WorkerThread(802,4);
        worker4.start();   
        
        try {
            // delay 10 ms before starting fifth thread
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(threadExtend.class.getName()).log(Level.SEVERE, null, ex);
        }
        WorkerThread mathrunner = new WorkerThread(43110,5);
        mathrunner.start();   
        
                
        // You can call interrupt() to cause an exception in a thread
        // The thread code needs to handle interrupts.
        // maybe there was an alarm in the main code that some data feeding worker1 is bad
        try
        {
          Thread.sleep(500); // thread 2 will be interrputed in 1/2 second
          worker2.interrupt();
          Thread.sleep(1000); // all threads should complete by the time this sleep is over
        }
        catch (Exception ex)
        {
           System.out.println("Main Thread Sleep Exception");
        }
    }
    
}