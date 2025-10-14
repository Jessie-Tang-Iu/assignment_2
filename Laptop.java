//Laptop computer: adds screen size to other Computer info

public class Laptop extends Computer { //Laptop inherits from Computer
    private final String screenSize; //Make final to ensure it is set only in constructor

    // String screenSize=null; -- original code

    //Constructors
    // public Laptop() {} //No-arg constructor

    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        //Inherited from Computer superclass
        super(CPU, RAM, disk);

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

    //Getter
    public String getScreenSize() {
        return this.screenSize;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Laptop\tCPU:" + this.getCPU() + "\tRAM:" + this.getRAM() + 
        "\tDisk:" + this.getDisk() + "\tScreen:" + this.screenSize;
    }
    
}