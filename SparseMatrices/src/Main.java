import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        compareDepSize();
    }

    public static void compareDepSize() throws IOException {
        String filename = "results.csv";
        FileWriter writer = new FileWriter(filename);
        writer.write("Size,Band,Density,DenseWithChoosing,BandWithChoosing,SparseWithChoosing,DenseWithoutChoosing,BandWithoutChoosing,SparseWithoutChoosing\n"); // nagłówek pliku
        int[] arguments = new int[]{50, 10, 50};
        for (int i = 0; i < 5; i++) {
            double[] result = Tests.testCol(arguments);
            writer.write(arguments[0] + "," + arguments[1] + "," + arguments[2] + "," + result[0] + "," + result[1] + "," + result[2] + "," + result[3] + "," + result[4] + "," + result[5] + "\n");
            arguments[0] += 50;
        }
        writer.close();
        System.out.println("Results saved to file: " + filename);
    }
}