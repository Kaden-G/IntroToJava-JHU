import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CensusDataReformat {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java CensusDataReformat <sourceFilePath> <destinationFilePath> <numRecords>");
            return;
        }

        String sourceFilePath = args[0];
        String destinationFilePath = args[1];
        int numRecords = Integer.parseInt(args[2]);

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(sourceFilePath));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(destinationFilePath))) {
            // Write CSV headers
            writer.write("StateCode,DistrictID,DistrictName,TotalPopulation,ChildrenPopulation,ChildrenInPoverty\n");

            String line;
            int recordCount = 0;
            while ((line = reader.readLine()) != null && recordCount < numRecords) {
                // Parse fields based on given layout
                String stateCode = line.substring(0, 2).trim();
                String districtID = line.substring(3, 8).trim();
                String districtName = line.substring(9, 81).trim();
                String totalPopulation = line.substring(82, 90).trim();
                String childrenPopulation = line.substring(91, 99).trim();
                String childrenInPoverty = line.substring(100, 108).trim();

                // Write reformatted data to CSV
                writer.write(stateCode + "," + districtID + "," + districtName + "," +
                        totalPopulation + "," + childrenPopulation + "," + childrenInPoverty + "\n");
                recordCount++;
            }
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }
}
