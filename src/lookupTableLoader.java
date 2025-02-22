import java.io.*;
import java.util.*;
public class lookupTableLoader {


    public static Map<String, String> loadLookupTable(String filename) {
        Map<String, String> lookupMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String key = parts[0].trim() + "," + parts[1].trim().toLowerCase();
                    lookupMap.put(key, parts[2].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading lookup table: " + e.getMessage());
        }return lookupMap;
    }
}

