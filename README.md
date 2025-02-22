In this project, I have modularized different functionalities into separate components, each handling a specific task:

Modules & Responsibilities
1. lookupTableLoader.java
Responsible for reading the lookup table CSV file and storing the data in a HashMap for quick lookup.
Ensures that only valid entries are loaded like three-column format with valid data).
Converts protocol numbers to lowercase string values.

2. flowLogProcessor.java
Reads and processes flow log entries line by line.
Extracts destination port and protocol and matches them against the lookup table.
Counts tagged and untagged entries.
Converts numeric protocol values into meaningful names (TCP, UDP, ICMP).

3. OutputWriter.java
Generates the final report in a structured format.
Writes two sections:
Tag Counts: The number of times each tag appears in the log file.
Port/Protocol Combination Counts: The number of times each port/protocol pair appears in the log.

