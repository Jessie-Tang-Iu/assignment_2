//Computer class: manages computer CPU, RAM and Disk information

public class Computer {
    String CPU=null;
    String RAM=null;
    String disk=null;

    //Constructors
    public Computer() {} //No-arg contructor

    public Computer(String CPU, String RAM, String disk) {
        this.CPU=CPU;
        this.RAM=RAM;
        this.disk=disk;
    }

    //Setters
    public void setCPU(String CPU) {
        this.CPU=CPU;
    }

    public void setRAM(String RAM) {
        this.RAM=RAM;
    }

    public void setDisk(String disk) {
        this.disk=disk;
    }

    //Getters
    public String getCPU() {
        return this.CPU;
    }

    public String getRAM() {
        return this.RAM;
    }

    public String getDisk() {
        return this.disk;
    }


}