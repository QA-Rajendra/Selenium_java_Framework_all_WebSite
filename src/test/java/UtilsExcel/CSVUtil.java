package utilsExcel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read CSV files into 2D String arrays.
 */
public class CSVUtil {

    private final String filePath;

    public CSVUtil(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads a CSV file and returns its content as a 2D String array.
     *
     * @param skipHeader if true, skips the first row (header)
     * @return 2D String array with CSV data
     */
    public String[][] getCSVData(boolean skipHeader) {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (skipHeader && isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1); // CSV split, handles commas inside quotes
                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].replace("\"", ""); // Remove surrounding quotes
                }
                records.add(values);
                isFirstLine = false;
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV file: " + e.getMessage(), e);
        }
        return records.toArray(new String[0][]);
    }
}
