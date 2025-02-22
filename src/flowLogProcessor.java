import java.io.*;
import java.util.*;

public class flowLogProcessor {
    private final Map<String, String> lookupMap;
    private final Map<String, Integer> tagCounts = new HashMap<>();
    private final Map<String, Integer> portProtocolCounts = new HashMap<>();

    public flowLogProcessor(Map<String, String> lookupMap) {
        this.lookupMap = lookupMap;
    }

    public void processFlowLogs(String logFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                processLogLine(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading flow logs: " + e.getMessage());
        }
    }

    private void processLogLine(String line) {
        String[] parts = line.split(" ");
        if (parts.length < 11) return;

        String dstPort = parts[5].trim();
        String protocol = parts[7].trim();

        Map<String, String> protocolMap = Map.of(
                "6", "tcp",
                "17", "udp",
                "1", "icmp"
        );

        String protocolName = protocolMap.getOrDefault(protocol, protocol);
        String key = dstPort + "," + protocolName.toLowerCase();
        String tag = lookupMap.getOrDefault(key, "Untagged");

        tagCounts.put(tag, tagCounts.getOrDefault(tag, 0) + 1);
        portProtocolCounts.put(key, portProtocolCounts.getOrDefault(key, 0) + 1);
    }

    public Map<String, Integer> getTagCounts() {
        return tagCounts;
    }

    public Map<String, Integer> getPortProtocolCounts() {
        return portProtocolCounts;
    }
}
