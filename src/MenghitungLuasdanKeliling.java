import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenghitungLuasdanKeliling {

    public static void main(String[] args) {
        String csvFile = "src/data/data/trapezoid.csv";
        List<AdapterData> trapezoids = readTrapezoidData(csvFile);

        for (AdapterData trapezoid : trapezoids) {
            System.out.println(trapezoid);
        }
    }

    private static List<AdapterData> readTrapezoidData(String csvFile) {
        List<AdapterData> trapezoids = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                double base1 = Double.parseDouble(data[0]);
                double base2 = Double.parseDouble(data[1]);
                double height = Double.parseDouble(data[2]);

                AdapterData trapezoid = new AdapterData(base1, base2, height);
                trapezoids.add(trapezoid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trapezoids;
    }
}