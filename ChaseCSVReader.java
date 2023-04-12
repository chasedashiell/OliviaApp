import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;

public class ChaseCSVReader {
    private static String csvSeparator = ",";
    public static ArrayList<String[]> CSVToArrayListOfStringArrays(String fliePath) {
        String line = "";
        ArrayList<String[]> solution = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fliePath));

            while ((line = br.readLine()) != null) {
                String[] values = new String[3];
                values = line.split(csvSeparator);
                solution.add(values);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solution;
    }

    public static void writeCSV(String filePath, ArrayList<String[]> list) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(0).length; j++) {
                    String curValue = list.get(i)[j];
                    // System.out.println("processing line " + i + " which has " + list.get(i).length + " elements ");
                    if (j == 2) {
                        fw.write(curValue);
                        fw.write(System.lineSeparator());
                    } else {
                        fw.write(curValue + csvSeparator);
                    }

                }
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    

    public static void printArrayListOfArrays(ArrayList<String[]> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
    }

    public static ArrayList<String[]> sortArrayListOfStringArrays(ArrayList<String[]> list, int sortBy) {
        for (int i = 1; i < list.size(); i++) {
            int minIndex = i;
            String minValue = list.get(i)[0];
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j)[0].compareTo(minValue) < 0) {
                    minValue = list.get(j)[0];
                    minIndex = j;
                }
            }
            String[] tmp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        String fliePath = "C:\\Users\\230010154\\JAVA\\OliviaApp\\prevSave2.csv";
        ArrayList<String[]> one = CSVToArrayListOfStringArrays(fliePath);
        one = removeDuplicates(one);
        one = sortArrayListOfStringArrays(one, 0);
        // printArrayListOfArrays(one);
        String path = "C:\\Users\\230010154\\JAVA\\OliviaApp\\save2.csv";
        writeCSV(path, one);

    }
}
