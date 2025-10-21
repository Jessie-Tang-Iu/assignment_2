//Desktop computer: adds GPU type

public class Desktop { //Composition: Desktop is a Computer
    private final String GPUType; //GPU type
    private Computer computer; 

    public Desktop(String CPU, String RAM, String disk, String GPUType) {
        //Create Computer object
        this.computer = new Computer(CPU, RAM, disk);
        // only in Desktop subclass
        this.GPUType=GPUType;
    }

    //Getters for Computer attributes
    public String getGPUType() {
        return this.GPUType;
    }

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
        return "Type:Desktop\tCPU:" + this.getCPU() + "\tRAM:" + this.getRAM() + "\tDisk:" + this.getDisk() + "\tGPU:" + this.GPUType;
    }

}