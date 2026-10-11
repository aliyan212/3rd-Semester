public abstract class FileItem {
    private String fileName;
    private double sizeInMB;
    public FileItem(String fileName, double sizeInMB){
        this.fileName=fileName;
        this.sizeInMB=sizeInMB;
    }
    public String getFileName(){
        return this.fileName;
    }
    public double getSizeInMB(){
        return this.sizeInMB;
    }
    public abstract void open();
}

public class EncryptedDocument extends FileItem{

int encryptionKey;

public EncryptedDocument(String fileName, double sizeInMB, int encryptionKey){
    super(fileName, sizeInMB);
    this.encryptionKey=encryptionKey;
}
    
@Override
public void open(){
    if(encryptionKey>0){
        System.out.println("Decrypting and opening "+getFileName());
    } else{
        System.out.println("Access Denied for" + getFileName());
    }
}
}

public class LosslessAudio extends FileItem{
    int bitDepth;
    public LosslessAudio(String fileName, double sizeInMB, int bitDepth){
        super(fileName, sizeInMB);
        this.bitDepth=bitDepth;
    }
    public int getBitDepth(){
        return this.bitDepth;
    }
    @Override
    public void open(){
        System.out.println("Playing " + getFileName() + " at " + getBitDepth() + "-bit high fidelity"  );
    }
}

public static void main(String[] args){
    FileItem[] Files= new FileItem[3];
    Files[0]=  new EncryptedDocument("Secret.txt", 2, 123);
    Files[1]= new EncryptedDocument("Actual Secret.txt", 1.0, 0);
    Files[2]= new LosslessAudio("Rasputing.flac", 20.0, 24);
    for(int i=0;i<Files.length;i++){
        Files[i].open();
    }
}

