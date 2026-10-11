public class Node {
    private String ipAddress;
    private int port;
    public Node(String ip, int port){
        this.ipAddress=ip;
        this.port=port;
    }
    public static void connect(){
        System.out.println("Connecting to open node...");
    }
    public void route(){
        System.out.println("Routing standard traffic over port " + this.port);
    }
    public String getIpAddress(){
        return this.ipAddress;
    }
    public int getPort(){
        return this.port;
    }
}
public class PrivacyNode extends Node{
   private String encryptionProtocol;
    public PrivacyNode(String ip, int port, String encryptionProtocol){
        super(ip, port);
        this.encryptionProtocol=encryptionProtocol;
    }
    public static void connect(){
        System.out.println("Establising secure handshake...");
    }
    @Override
    public void route(){
        System.out.println("Routing encyrpted traffic via " + encryptionProtocol + " over port " + getPort());
    }
}

public static void main (String[] args){
    Node obj = new PrivacyNode("192.168.1.1", 443, "Wireguard");
    obj.connect();
    obj.route();
}
