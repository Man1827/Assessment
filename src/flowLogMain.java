import java.util.*;

public class flowLogMain {
    public static void main(String[] args) {
        String lookupFile = "lookup_table.csv";
        String logFile = "flowlogData.txt";
        String outputFile = "output.txt";

        // Load lookup table
        Map<String, String> lookupMap = lookupTableLoader.loadLookupTable(lookupFile);

        /* Process flow logs */
        flowLogProcessor processor = new flowLogProcessor(lookupMap);
        processor.processFlowLogs(logFile);

        // Write output
        outputWriter.writeOutput(processor.getTagCounts(), processor.getPortProtocolCounts(), outputFile);
    }
}