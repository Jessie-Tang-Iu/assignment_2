//Manage Computers program: maintains an ArrayList of Computer objects, 
//can be either Laptop or Desktop, but never just Computer-type objects themselves

import java.util.ArrayList;
import java.util.Scanner;

public class ManageComputers {

    public static void main(String args[]) {
        
         //This ArrayList will hold all the computers in the system. Note that the type of objects expected in this
        //ArrayList are Computer, not Laptop or Desktop, but since those are subclasses of Computer they can be
        //stored in an ArrayLiust<Computer> anyway.


        // One ArrayList to hold all computer objects (Laptop or Desktop)
        ArrayList<Object> computers = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        String menuOption = "";

        do { // Start of main program loop

            //Show computer data in ArrayList<Object>
            showComputers(computers);

            // Display menu and return menu option selected by the user
            menuOption = getMenuSelection(s);

            switch (menuOption) {
                // Add new computer
                case "a":
                    addComputer(computers, s);
                    break;

                // Delete a computer
                case "d":
                    deleteComputer(computers, s);
                    break;

                // Edit a computer
                case "e":
                    editComputer(computers, s);
                    break;
            }

        } while (!menuOption.equals("x")); // Stop when "x" is entered

        s.close(); // Close keyboard scanner
    }

    // -----------------------------
    //Display menu and get user selection, return it
    private static String getMenuSelection(Scanner s) {
        String menuOption="";

        //Display menu options on-screen
        System.out.println("----------");
        System.out.println("A) Add Computer");
        System.out.println("D) Delete Computer");
        System.out.println("E) Edit Computer");
        System.out.println("X) eXit");
        System.out.println("----------");

        //Get menu selection from keyboard
        System.out.print("Enter menu selection:");
        menuOption = s.nextLine();

        menuOption = menuOption.toLowerCase(); //Make lower case for comparison purposes

        return menuOption;
    } //End of getMenuSelection

    // -----------------------------
    // Show all laptops and desktops
    private static void showComputers(ArrayList<Object> computers) {
        int computerListNumber=0; //This variable is used to hold the "list number" for each computer, starting at 1.

        System.out.println("=========");

        System.out.println("LIST OF COMPUTERS:-");

        for (Object c: computers) {

            computerListNumber++; //Increment list number for each computer

            //Call overridden toString() method for current object to get and display its data
            System.out.println(computerListNumber + ": " + c.toString());
        }

        System.out.println("=========");

    } //End of showComputers

    // -----------------------------
    // Add a new Laptop or Desktop

     private static void addComputer(ArrayList<Object> computers, Scanner s) {
        String computerType="";

        Computer tempComputer=null;

        System.out.println("ADDING COMPUTER:-");

        System.out.println("Enter type of computer to add ('L' for Laptop, 'D' for Desktop):");
        computerType=s.nextLine();
        computerType=computerType.toLowerCase(); //Convert to lower case for comparison purposes

        switch(computerType) {

            //Add a laptop
            case "l": 

                //Get CPU, RAM and Disk info
                tempComputer = getComputerData(s); 

                System.out.print("Enter screen size:");
                String screenSize = s.nextLine();

                //Add new Laptop to ArrayList in main() method
                computers.add(new Laptop(tempComputer.getCPU(),tempComputer.getRAM(),tempComputer.getDisk(),screenSize)); 

                break;
            
            //Add a desktop    
            case "d": 

            //Get CPU, RAM and Disk info
                tempComputer = getComputerData(s); 

                System.out.print("Enter GPU:");
                String GPUType = s.nextLine();

                //Add new Desktop to ArrayList in main() method
                computers.add(new Desktop(tempComputer.getCPU(),tempComputer.getRAM(),tempComputer.getDisk(),GPUType)); 

                break;

            //Invalid computer type to add entered
            default:

                System.out.println("Invalid computer type entered!");

        }
    } //End of addComputer


    // -----------------------------
    // Delete a specified computer
   //Delete a specified computer from the ArrayList
    private static void deleteComputer(ArrayList<Object> computers, Scanner s) {
        int computerListNumberToDelete=0;

        System.out.println("DELETE COMPUTER:-");

        System.out.print("Enter number of computer to delete:");
        computerListNumberToDelete = Integer.parseInt(s.nextLine());

        //Check if computer list number is valid before deleting computer from list
        if (computerListNumberToDelete>=1 && computerListNumberToDelete<=computers.size()) {
            //Subtract 1 to get ArrayList index from on-screen list number to create correct index in ArrayList to delete
            computers.remove(computerListNumberToDelete-1); 
        }   
        else {
            System.out.println("Invalid computer number entered!");
        }

    } //End of deleteComputer

    // -----------------------------
    //Edit a computer. Since Laptop and Desktop are mutable classses/object get new data values and replace old
    //attribute values in object being edited using object setter methods
    private static void editComputer(ArrayList<Object> computers, Scanner s) {
    int computerListNumberToEdit = 0;
    String computerType = "";
    Computer tempComputer = null;

    System.out.println("EDIT COMPUTER:-");

    System.out.print("Enter number of computer to edit:");
    computerListNumberToEdit = Integer.parseInt(s.nextLine());

    // Check that computerListNumberToEdit is valid first
    if (computerListNumberToEdit >= 1 && computerListNumberToEdit <= computers.size()) {

        // Determine exact type of computer being edited
        Object obj = computers.get(computerListNumberToEdit - 1);
        if (obj instanceof Laptop) {
            computerType = "laptop";
        } else if (obj instanceof Desktop) {
            computerType = "desktop";
        }

        switch (computerType) {

            case "laptop":
                System.out.println("Editing a Laptop:");

                // Get new CPU, RAM, Disk info
                tempComputer = getComputerData(s);

                System.out.print("Enter screen size:");
                String screenSize = s.nextLine();

                // Create a new Laptop object with updated info
                Laptop updatedLaptop = new Laptop(
                        tempComputer.getCPU(),
                        tempComputer.getRAM(),
                        tempComputer.getDisk(),
                        screenSize);

                // Replace old object in ArrayList
                computers.set(computerListNumberToEdit - 1, updatedLaptop);
                System.out.println("Laptop updated successfully.");
                break;

            case "desktop":
                System.out.println("Editing a Desktop:");

                // Get new CPU, RAM, Disk info
                tempComputer = getComputerData(s);

                System.out.print("Enter GPU:");
                String GPUType = s.nextLine();

                // Create a new Desktop object with updated info
                Desktop updatedDesktop = new Desktop(
                        tempComputer.getCPU(),
                        tempComputer.getRAM(),
                        tempComputer.getDisk(),
                        GPUType);

                // Replace old object in ArrayList
                computers.set(computerListNumberToEdit - 1, updatedDesktop);
                System.out.println("Desktop updated successfully.");
                break;
        }

    } else {
        System.out.println("Invalid computer number entered!");
    }
}
//End of editComputer

    // -----------------------------
    // Helper to get CPU, RAM, Disk info
    private static Computer getComputerData(Scanner s) {
        String CPU="";
        String RAM="";
        String disk="";

        System.out.print("Enter CPU:");
        CPU = s.nextLine();

        System.out.print("Enter RAM:");
        RAM = s.nextLine();

        System.out.print("Enter Disk:");
        disk = s.nextLine();

        return new Computer(CPU,RAM,disk);

    } //End of getComputerData
}
