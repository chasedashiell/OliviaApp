package OliviaApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVReader {
    public static ArrayList<String[]> CSVToArrayListOfStringArrays(String path) {
        String line = "";
        ArrayList<String[]> solution = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
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

    public static ArrayList<String[]> removeDuplicates(ArrayList<String[]> list) {
        String[] currArray;
        String[] toCheck;
        for (int i = 0; i < list.size(); i++) {
            currArray = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                toCheck = list.get(j);
                if (currArray[0].equals(toCheck[0]) && currArray[1].equals(toCheck[1])
                        && currArray[2].equals(toCheck[2])) {
                    list.remove(i);
                }
            }
        }
        return list;
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
        String path = "C:\\Users\\230010154\\Desktop\\java\\OliviaApp\\Copy of Reading List - Sheet1.csv";
        ArrayList<String[]> one = CSVToArrayListOfStringArrays(path);
        one = removeDuplicates(one);
        one = sortArrayListOfStringArrays(one, 0);
        printArrayListOfArrays(one);

    }
}
