//Laptop computer: adds screen size to other Computer info

public class Laptop { //Composition: Laptop is a Computer
    private final String screenSize; //Make final to ensure it is set only in constructor
    private Computer computer;

    // String screenSize=null; -- original code

    //Constructors
    // public Laptop() {} //No-arg constructor

    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        //Create Computer object
        this.computer = new Computer(CPU, RAM, disk);

        // Original code
        // this.CPU=CPU;
        // this.RAM=RAM;
        // this.disk=disk;

        //Only in Laptop subclass
        this.screenSize=screenSize;
    }

    //Setter (hidden to ensure screen size is set only in constructor)
    // public void setScreenSize(String screenSize) {
    //     this.screenSize=screenSize;
    // }

    //Getter for Laptop attribute
    public String getScreenSize() {
        return this.screenSize;
    }

    //Getters for Computer attributes
    public String getCPU() {
        return this.computer.getCPU();
    }

    public String getRAM() {
        return this.computer.getRAM();
    }

    public String getDisk() {
        return this.computer.getDisk();
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Laptop\tCPU:" + this.getCPU() + "\tRAM:" + this.getRAM() + "\tDisk:" + this.getDisk() + "\tScreen:" + this.screenSize;
    }
    
}