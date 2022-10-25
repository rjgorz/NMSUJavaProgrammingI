package com.java24hours;

import java.util.logging.Level;
import java.util.logging.Logger;

class WorkerThreadR implements Runnable {

    int threadId; // unique ID passed in by each thread started by the main code
    
    // thread contructor to accept input ID
    WorkerThreadR(int threadId)
    {
        this.threadId = threadId;
    }
    
    @Override
    public void run() {
        
        
        //show exch thread unique execution
        for(int i=0; i<10; i++) {
            System.out.println("'implements' thread in loop" + i + " of thread: " + this.threadId);
            
            // Sleep for 1/4 second (sleep is in ms)
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                // Worker class has an  interrupt() method because it inherits from Thread
                // could be used to stop a thread on an alarm from the main code
                System.out.println("Interupt caught in thread: "+ this.threadId + " " + e.getMessage());
                break;
            }
        }
    }

}

public class threadRunnable {
    
    public static void main(String[] args) 
    {
        // create 2 working threads with unique IDs
        // this type of thread requires the constructor to be instantiated
        // then passed to the thread
        WorkerThreadR worker1 = new WorkerThreadR(135);
        Thread threadw1 = new Thread(worker1);
        threadw1.start();
        
        try {
            // delay 10 ms before starting second thread
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(threadExtend.class.getName()).log(Level.SEVERE, null, ex);
        }
        WorkerThreadR worker2 = new WorkerThreadR(246);
        Thread threadw2 = new Thread(worker2);
        threadw2.start();
        
        // You can call interrupt() to cause an exception in a thread
        // The thread code needs to handle interrupts.
        // maybe there was an alarm in the main code that some data feeding worker1 is bad
        try
        {
          Thread.sleep(1000); // thread 1 will be interrputed in 1 second
          threadw1.interrupt();
        }
        catch (Exception ex)
        {
           System.out.println("Main Thread Sleep Exception");
        }
    }
    
}