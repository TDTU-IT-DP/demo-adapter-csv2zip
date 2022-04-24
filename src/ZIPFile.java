import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIPFile {
    String outputFile;
    public ZIPFile(String outputFile){
        this.outputFile = outputFile;
    }

    public FileOutputStream getStream() throws FileNotFoundException{
        return new FileOutputStream(this.outputFile);
    }
    
    public void compress(List<byte[]> bytes) throws IOException {
        FileOutputStream stream = getStream();
        ZipOutputStream zipOut = new ZipOutputStream(stream);
        ZipEntry zipEntry = new ZipEntry(this.outputFile);
        zipOut.putNextEntry(zipEntry);

        int length;
        for (byte[] b : bytes) {
            length = b.length;
            zipOut.write(b, 0, length);
        }
        zipOut.close();
    }   
}
