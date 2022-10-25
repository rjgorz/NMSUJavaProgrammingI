/*
   OECS 195 JAVA Programming I
   Assigment Module #6
   Code Author: Robert Gorz
   ProgramName: petConstructor.java
        Utilizes a constructor to receive String inputs
        for pet names and pet types
        Displays the constructed pet1 and pet2 characteristics
*/

package com.java24hours;

// new class and initializing variables to use in the constructor
class myPet {
    String pName;
    String pType;
    
    // constructor to receive String values as arguments with the new statement for variables pName and pType
    public myPet(String name, String type) {
        pName = name;
        pType = type;
    }        
}

public class petConstructor {
    public static void main(String[] args) {
        
    // calls upon the myPet constructor to assign input String arguments to name and type for pet1/pet2
    myPet pet1 = new myPet("Mellow", "Cat");
    myPet pet2 = new myPet ("Remy", "Dog");
    
    // displays the constructed name and type for pet1/pet2
    System.out.println("pet1 Name=" + pet1.pName + " Type=" +pet1.pType);
    System.out.println("pet2 Name=" + pet2.pName + " Type=" +pet2.pType);
    }
}