package com.java24hours;

class Commodity {
    public static void main(String [] args) {
        
        // initialize starting balance, quantity and command to be utilized
        // for testing, args[0] set as buy, args[1] set as sell, args[2] set as trade
        String command = args[1].toUpperCase();
        int balance = 100;
        int quantity = 42;
        int index = 0;
        
        switch (command) {
            // run loop for BUY command for maximum 10 iterations, display starting values before execution
            case "BUY":
                
                System.out.println("Starting Balance: $" + balance + "\n" + "Starting Quantity: " + quantity);
                
                while (index < 10) {
                    
                    // execution while at least a balance of 20 is available to buy 5 quantity
                    if (balance >= 20) {
                        quantity += 5;
                        balance -= 20;
                        index++;
                        System.out.println("Command: " + command + "\n" + "Remaining Balance: $" +
                            balance + "\n" + "Quantity: " + quantity);
                        
                    // error message when balance is insufficient to buy quantity 5
                    } else {
                        System.out.println("Product cannot be purchased, insufficient balance remaining.");
                        index++;
                        break;
                    }
                }
                break;
                
            // run loop for SELL command for maximum 10 iterations, display starting values before execution
            case "SELL":
                
                System.out.println("Starting Balance: $" + balance + "\n" + "Starting Quantity: " + quantity);
                
                while (index < 10) {
                    
                    // execution while at at least 5 quantity is available to sell
                    if (quantity >= 5) {
                        quantity -= 5;
                        balance += 15;
                        index++;
                        System.out.println("Command: " + command + "\n" + "Balance: $" +
                            balance + "\n" + "Remaining Quantity: " + quantity);
                        
                    // error message when quantity would fall below 0
                    } else {
                        System.out.println("Product is out of stock, no more can be sold.");
                        index++;
                        break;
                    }
                }
                break;
                
            // error message to signify an invalid command was entered by the user and terminate the program
            default:
                System.out.println("You have entered an INVALID command, only BUY or SELL are accepted, not: " + command + ".");
                System.exit(0);
        }
        // display final balance and quantity after executing 10 iterations of the BUY or SELL loops
        System.out.println("Final Balance: $" + balance + "\n" + "Final Quantity: " + quantity);
    }
}