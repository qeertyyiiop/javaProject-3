package Part1;

public class Packet {
    private int serialNo;
    private String data;

    public Packet(int serialNo, String data) {
        this.serialNo = serialNo;
        this.data = data;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public String getData() {
        return data;
    }
}
