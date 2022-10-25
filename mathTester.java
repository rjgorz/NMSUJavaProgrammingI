package com.java24hours;

class mathTester {
    // Number of days in a year, unchanging variable
    static int daysInYear = 365;
        
        public static void main(String[] arguments) {
            int salesYears = 5;
            int salesDays;
            int salesMonths;
            
            // Setting the initial salesDays calculation using the assigned salesYears value of 5 years
            salesDays = daysInYear * salesYears;
            System.out.println("Base salesYears = " + salesYears + " Base salesDays = " + salesDays);
                        
            // Incremental increase to salesYears to calculate a new value of salesDays for
            // one additional year (6 total)
            salesDays = daysInYear * ++salesYears;
            System.out.println("++prefix salesYears = " + salesYears + " New salesDays = " + salesDays);
                        
            // Replaced the postfix++ code with another ++prefix to correctly run the
            // expression's order of operations for another additional year of sales (7 total)
            salesDays = daysInYear * ++salesYears;
            System.out.println("Additoinal ++prefix salesYears = " + salesYears + " New salesDays = " + salesDays);
                        
            // Final correct calculation for the total months of sales based on 7 years
            salesMonths = salesDays / daysInYear * 12;
            System.out.println("Final salesDays = " + salesDays + " Final salesMonths = " + salesMonths);
                        
            double milesPerGal = 32;
            double gasCostPerGal = 2.69;
            double milesPerDay = 40;
            double businessTripMiles = 125;
            double galUsed;
            double totalMiles;
            double totalCost;
            double businessTripCost;
            
            // Calculate the total miles driven over four working days and the business trip combined
            totalMiles = milesPerDay * 4 + businessTripMiles;
            System.out.println("The total miles driven over 4 working days and a business trip is " + totalMiles);
            
            // Figuring the total gallons used in order to calculate total cost
            galUsed = totalMiles / milesPerGal;
            // Calculate the overall cost of gas over four working days and the business trip combined
            totalCost = galUsed * gasCostPerGal;
            System.out.println("The total cost of gas for all work travel is $" + totalCost);
            
            // Calculate the total cost of gas for the business trip mileage only            
            businessTripCost = businessTripMiles / milesPerGal * gasCostPerGal;
            System.out.println("The total cost of gas for the business trip mileage only is $" + businessTripCost);
            
        }
}