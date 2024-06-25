import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UrutanTerkecilkeTerbesar {
    public static void main(String[] args) {
        String csvFile = "src/data/data/trapezoid.csv";
        String outputFile = "urutankeliling.txt"; // Nama file output
        String line;
        String csvSplitBy = ",";
        List<AdapterData> trapezoids = new ArrayList<>();

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

        // Sort trapezoids by perimeter
        Collections.sort(trapezoids, new Comparator<AdapterData>() {
            @Override
            public int compare(AdapterData t1, AdapterData t2) {
                return Double.compare(t1.calculatePerimeter(), t2.calculatePerimeter());
            }
        });

        try (FileWriter writer = new FileWriter(outputFile)) {
            int index = 1;
            for (AdapterData trapezoid : trapezoids) {
                String output = "keliling " + index + ": " + trapezoid.calculatePerimeter() + "\n";
                writer.write(output);
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
