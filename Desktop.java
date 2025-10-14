//Desktop computer: adds GPU type

public class Desktop extends Computer { //Inherits from Computer
    private final String GPUType; //GPU type

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        //Inherited from Computer superclass
        super(CPU, RAM, disk);
        // only in Desktop subclass
        this.GPUType=GPUType;
    }

    public String getGPUType() {
        return this.GPUType;
    }

    //Return formatted version of data
    public String toString() {
        return "Type:Desktop\tCPU:" + this.CPU + "\tRAM:" + this.RAM + "\tDisk:" + this.disk + "\tGPU:" + this.GPUType;
    }

}