package com.java24hours;

class Credits {
    public static void main(String[] arguments) {
        // Set up film information
        String title = "Sharknado";
        int year = 2013;
        String director = "Anthony Ferrante";
        String role1 = "Fin";
        String actor1 = arguments[0];
        String role2 = "April";
        String actor2 = arguments[1];
        String role3 = "George";
        String actor3 = arguments[2];
        String role4 = "Nova";
        String actor4 = arguments[3];
        
        // Display overall information for the film Sharknado
        System.out.println(title + " (" + year + ")\n" +
            "An " + director + " film. \n\n" +
            role1 + "\t" + actor1 + "\n" +
            role2 + "\t" + actor2 + "\n" +
            role3 + "\t" + actor3 + "\n" +
            role4 + "\t" + actor4 + "\n");
        
        // Display actor names along with how many characters are in each name
        System.out.println("arg[0] = " + actor1 + "\t" +
            "arg[0]'s length = " + actor1.length() + "\n" +
            "arg[1] = " + actor2 + "\t" +
            "arg[1]'s length = " +actor2.length() + "\n" +
            "arg[2] = " + actor3 + "\t" +
            "arg[2]'s length = " +actor3.length() + "\n" +
            "arg[3] = " + actor4 + "\t" +
            "arg[3]'s length = " +actor4.length() + "\n");
        
        // Locate the starting string index of the word "Nova" in the variable role4
        int location = role4.indexOf("Nova");
        // Assign new string variable to display the starting string index of the word "Nova"
        String novaLoc = ("The word 'Nova' is located at string index " +
            location + " of variable 'role4'");
        System.out.println(novaLoc);
        
        // Locate the string index of the character 'v' in the variable role4
        location = role4.indexOf('v');
        // Assign new string variable to display the string index location of the character 'v'
        String vLoc = ("The character 'v' is located at string index " +
            location + " of variable 'role4'");
        System.out.println(vLoc + "\n");
        
        // Modify string actor4 to all upper-case and lower-case letters and display
        String uCase = actor4.toUpperCase();
        String lCase = actor4.toLowerCase();
        System.out.println("arg[3] upper = " + uCase + "\n" +
            "arg[3] lower = " + lCase + "\n");
    }
}