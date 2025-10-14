//Laptop computer: adds screen size to other Computer info

public class Laptop extends Computer { //Laptop inherits from Computer
    String screenSize=null;

    //Constructors
    public Laptop() {} //No-arg constructor

    public Laptop(String CPU, String RAM, String disk, String screenSize) {
        //Inherited from Computer superclass
        this.CPU=CPU;
        this.RAM=RAM;
        this.disk=disk;

        //Only in Laptop subclass
        this.screenSize=screenSize;
    }

    //Setter
    public void setScreenSize(String screenSize) {
        this.screenSize=screenSize;
    }

    //Getter
    public String getScreenSize() {
        return this.screenSize;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Laptop\tCPU:" + this.CPU + "\tRAM:" + this.RAM + "\tDisk:" + this.disk + "\tScreen:" + this.screenSize;
    }
    
}