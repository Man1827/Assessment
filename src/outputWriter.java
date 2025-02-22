import java.io.*;
import java.util.*;

public class outputWriter {
    public static void writeOutput(Map<String, Integer> tagCounts, Map<String, Integer> portProtocolCounts, String outputFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Tag Counts:\n");
            bw.write("Tag,Count\n");
            for (Map.Entry<String, Integer> entry : tagCounts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            bw.write("\nPort/Protocol Combination Counts:\n");
            bw.write("Port,Protocol,Count\n");
            for (Map.Entry<String, Integer> entry : portProtocolCounts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing output: " + e.getMessage());
        }
    }
}