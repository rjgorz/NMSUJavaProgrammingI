package com.java24hours;
 
public class PrimeFinderInterrupt implements Runnable {
    Thread go;
    StringBuffer primes = new StringBuffer();
    int time = 0;
    int index = 1;
 
    public PrimeFinderInterrupt() {
        start();
        while (primes != null) {
            System.out.println(time);
            if (++index > 7 )
            {
                System.out.println("cancel thread after 7 seconds... too long");
                stop();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exc) {
                // do nothing
            }
            time++;
        }
    }
 
    public void start() {
        if (go == null) {
            go = new Thread(this);
            go.start();
        }
    }
    
    public void stop()
    {
        go.interrupt();
    }
 
    public void run() {
        int quantity = 1_000_000;
        int numPrimes = 0;
        // candidate: the number that might be prime
        int candidate = 2;
        primes.append("\nFirst ").append(quantity).append(" primes:\n\n");
        
        while (numPrimes < quantity) {
            if (isPrime(candidate)) {
                primes.append(candidate).append(" ");
                numPrimes++;
            }
            candidate++;

           if (Thread.currentThread().isInterrupted())
           {
            System.out.println("Thread timeout... exiting");
            primes = null;
            return;
           }
        }
        
        System.out.println(primes);
        primes = null;
        System.out.println("\nTime elapsed: " + time + " seconds");
    }
 
    public static boolean isPrime(int checkNumber) {
        double root = Math.sqrt(checkNumber);
        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arguments) {
        
        long startns = System.nanoTime();
        long startms = System.currentTimeMillis();
        double a=-12.225, b=4, c=0;
        for (int idx = 0; idx < 5000; ++idx)
        {
            c = a + b;
        }
        long endns = System.nanoTime();
        long endms = System.currentTimeMillis();
        long diffns = endns-startns;
        long dms = endms - startms;
        System.out.println("time of 500 divides in ns and ms =" + diffns + "  " + dms);
        
        new PrimeFinderInterrupt();
    }
}
