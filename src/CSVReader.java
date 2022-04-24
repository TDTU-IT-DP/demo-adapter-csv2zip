import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    String COMMA_DELIMITER = ",";
    String inputFile;

    public CSVReader(){
        
    }

    public CSVReader(String inputFile){
        this.inputFile = inputFile;
    }

    public List<List<String>> readFile() throws FileNotFoundException, IOException{
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(this.COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }
}
