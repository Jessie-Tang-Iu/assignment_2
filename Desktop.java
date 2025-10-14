//Desktop computer: adds GPU type

public class Desktop extends Computer { //Inherits from Computer
    String GPUType=null;

    //Constructors
    public Desktop() {} //No-arg constructor

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        //Inherited from Computer superclass
        this.CPU=CPU;
        this.RAM=RAM;
        this.disk=disk;

        //Only in Desktop subclass
        this.GPUType=GPUType;
    }

    //Setter
    public void setGPUType(String GPUType) {
        this.GPUType=GPUType;
    }

    //Getter
    public String getGPUType() {
        return this.GPUType;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Desktop\tCPU:" + this.CPU + "\tRAM:" + this.RAM + "\tDisk:" + this.disk + "\tGPU:" + this.GPUType;
    }

}