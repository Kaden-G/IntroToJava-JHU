import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class StateLevelReport {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java StateLevelReport <inputFilePath> <numRecords>");
            return;
        }

        String inputFilePath = args[0];
        int numRecords = Integer.parseInt(args[1]);

        Map<String, StateStatistics> stateStatisticsMap = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath))) {
            // Skip CSV header
            reader.readLine();

            String line;
            int recordCount = 0;
            while ((line = reader.readLine()) != null && recordCount < numRecords) {
                String[] fields = line.split(",");
                String stateCode = fields[0];
                int totalPopulation = Integer.parseInt(fields[3]);
                int childrenPopulation = Integer.parseInt(fields[4]);
                int childrenInPoverty = Integer.parseInt(fields[5]);

                StateStatistics stats = stateStatisticsMap.getOrDefault(stateCode, new StateStatistics());
                stats.totalPopulation += totalPopulation;
                stats.childrenPopulation += childrenPopulation;
                stats.childrenInPoverty += childrenInPoverty;
                stateStatisticsMap.put(stateCode, stats);

                recordCount++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Display the report
        System.out.println("File: " + inputFilePath);
        System.out.println("State-Level Summary Report:");
        for (Map.Entry<String, StateStatistics> entry : stateStatisticsMap.entrySet()) {
            String stateCode = entry.getKey();
            StateStatistics stats = entry.getValue();
            System.out.printf("State: %s, Total Population: %d, Children Population: %d, Children in Poverty: %d%n",
                    stateCode, stats.totalPopulation, stats.childrenPopulation, stats.childrenInPoverty);
        }
    }

    static class StateStatistics {
        int totalPopulation;
        int childrenPopulation;
        int childrenInPoverty;
    }
}
