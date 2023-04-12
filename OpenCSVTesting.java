import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class OpenCSVTesting {

    public static ArrayList<String[]> csvToStringList(String filePath) {
        try {
            CSVReader reader = new com.opencsv.CSVReaderBuilder(new FileReader(filePath)).build();
            String [] nextLine;
            ArrayList<String[]> allLines = new ArrayList<>();
            while ((nextLine = reader.readNext()) != null) {
                allLines.add(nextLine);
            }
    
            for (String[] line : allLines) {
                System.out.println(Arrays.toString(line));
            }

            return allLines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String[]> removeDuplicates(ArrayList<String[]> list) {
        String[] currArray;
        String[] toCheck;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
            currArray = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                toCheck = list.get(j);
                System.out.println("toCheck is: " + Arrays.toString(toCheck));
                System.out.println(currArray[0]);
                System.out.println(currArray[1]);
                System.out.println(currArray[2]);

                if (currArray[0].equals(toCheck[0]) && currArray[1].equals(toCheck[1])
                        && currArray[2].equals(toCheck[2])) {
                    list.remove(i);
                }
            }
        }
        return list;
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
        
        String filePath = "C:\\Users\\230010154\\JAVA\\OliviaApp\\prevSave.csv";
        ArrayList<String[]> data = csvToStringList(filePath);
        data = removeDuplicates(data);
        data = sortArrayListOfStringArrays(data, 0);
        String path = "C:\\Users\\230010154\\JAVA\\OliviaApp\\save3.csv";
        

        // start of method
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(path));
            writer.writeAll(data);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 



        /// end of method


        
        // ArrayList<String[]> one = CSVToArrayListOfStringArrays(fliePath);
        // one = removeDuplicates(one);
        // one = sortArrayListOfStringArrays(one, 0);
        // // printArrayListOfArrays(one);
        // String path = "C:\\Users\\230010154\\JAVA\\OliviaApp\\save2.csv";
        // writeCSV(path, one);

    }
}