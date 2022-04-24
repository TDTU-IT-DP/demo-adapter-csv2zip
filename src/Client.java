
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Client {   
  public static void main(String[] args) throws FileNotFoundException, IOException {
    CSVReader csv_reader = new CSVReader("addresses.csv");
    ZIPFile zip_file = new ZIPFile("compressed.zip");
    CSVToByteAdapter adapter = new CSVToByteAdapter(csv_reader);

    List<byte[]> data = adapter.readByte();
    zip_file.compress(data);
  }

}