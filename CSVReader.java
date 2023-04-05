package OliviaApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVReader {
    public static ArrayList<String[]> CSVToArrayListOfArrays(String path) {
        String line = "";
        ArrayList<String[]> solution = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                solution.add(values);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return solution;
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\dashc\\Downloads\\Copy of Reading List - Sheet1.csv";
        ArrayList<String[]> one = CSVToArrayListOfArrays(path);
        System.out.println(one);
    }
}
