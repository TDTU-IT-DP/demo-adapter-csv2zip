import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVToByteAdapter
 */
public class CSVToByteAdapter extends CSVReader{
    Charset charset = StandardCharsets.UTF_8;
    CSVReader reader;

    public CSVToByteAdapter(CSVReader reader) {
        this.reader = reader;
    }

    public List<byte[]> readByte() throws FileNotFoundException, IOException {
        List<List<String>> data = this.reader.readFile();
        List<byte[]> records = new ArrayList<byte[]>();

        for (List<String> row_data : data) {
            for (String value : row_data){
                byte[] encoded_string =  this.charset.encode(value).array();
                records.add(encoded_string);
            }
        }
        return records;
    }
}