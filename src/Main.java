
import ReadFile.ReadFile;
import WriteFile.WriteFile;
import QuickSort.QuickSort;
import RadixSort.RadixSort;
import InsertionSort.InsertionSort;
import BubbleSort.BubbleSort;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.time.Duration;


class Sort {
    private ReadFile readFile = new ReadFile();
    private BubbleSort bSort =  new BubbleSort();
    private InsertionSort iSort =  new InsertionSort();
    private QuickSort qSort =  new QuickSort();
    private RadixSort rSort =  new RadixSort();

    private long epoch;

    private String name;
    private String file;

    public static String[] sliceArray(String[] arr, 
                                     int start, int end)
    {
        // Get the slice of the Array
        String[] slice = new String[end - start];

        // Copy elements of arr to slice
        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }
  
        // return the slice
        return slice;
    }

    public String[] sort (Main obj, String caseName, String[] words, String[] input ,int intval, String sortName) 
    {
        System.out.println();
        System.out.println(caseName + ": ");

        int size = words.length / intval;
        if (words.length % intval != 0)
        size++;

        String [] iter = new String[size];
        // System.out.println(iter.length);
        int idx = intval;
        for (int i = 0; i < iter.length; i++) {
            if (idx > words.length)
            idx = words.length;
            String[] wordsSlice = sliceArray(words, 0, idx);
            switch(sortName) {
                case "Bubble":
                case "bubble":
                iter[i] = String.valueOf(obj.bubbleSort(wordsSlice));
                break;
                case "Insertion":
                case "insertion":
                iter[i] = String.valueOf(obj.insertionSort(wordsSlice));
                  break;
                case "Quick":
                case "quick":
                iter[i] = String.valueOf(obj.quickSort(wordsSlice));
                break;
                case "Radix":
                case "radix":
                iter[i] = String.valueOf(obj.radixSort(wordsSlice));
                break;
                default:
        }
        System.out.println("Count: " + wordsSlice.length + " - " + iter[i]);
        idx += intval;
    }
        return iter;

    }

    public long bubbleSort (String[] arr)
    {
        epoch = bSort.sort(arr);
        return epoch;
    }
    public long insertionSort (String[] arr)
    {
        epoch = iSort.sort(arr);
        return epoch;
    }
    public long quickSort (String[] arr)
    {
        epoch = qSort.sort(arr);
        return epoch;
    }
    public long radixSort (String[] arr)
    {
        int maxWordSize = 0;
        
        ArrayList<String> word = new ArrayList<String>();
        for (int x = 0; x < arr.length; x++){
            word.add(arr[x]);
            //searching for the maximum word length
            if (arr[x].length() > maxWordSize){
                maxWordSize = arr[x].length();
                // System.out.println(temp +" " + temp.charAt(maxWordSize-2));
            }

        }
        
        ArrayList<String> [][] dataset = new ArrayList[2][128];
        for(int i=0; i<2;i++){
            for(int j=0; j<128; j++){
                dataset[i][j]= new ArrayList<String>();
            }
        }
        
        // System.out.println("inserting data to 2d arraylist");

        long outEpoch = 1;  // premitive counter
        // inserting data into 2d arraylist
        for(int i=0; i<word.size(); i++){
            outEpoch+=8;    // for loop, assign position, call get(), call charAt(), call get(), call length(), arithmetic
            int position = (int) word.get(i).charAt(word.get(i).length()-1);
            // System.out.println(position);
            dataset[0][position].add(word.get(i));
            outEpoch+=2;    //call add(), call get()
        }
        
        // System.out.println("sorting...");

        outEpoch+=3;   // assign currentPosition, arithmetic, for loop
        int currentPosition = maxWordSize-1;
        for (int q=0; q<maxWordSize;q++){
            outEpoch += rSort.simplySort(dataset, q%2, currentPosition);
            currentPosition--;
            outEpoch+=4;    // for loop, call function, decrement 
        }
        // epoch = rSort.sort(arr);
        return outEpoch;
    }

    public void setName(String s) {
        name = s;
    }

    public void setFile(String f) {
        file = f;
    }

    public String getName() {
        return name;
    }

    public String getFile() {
        return file;
    }
}

// public class Main {
//         public static void main(String[] args) {
//             ReadFile readFile = new ReadFile();


//             //Prepare graph data
//         String[] caseName = {"Best", "Average", "Worst"};
//         String[][] words = new String [caseName.length][];

//         for (int i = 0; i < caseName.length; i++) {
//             words[i] = readFile.readArray(caseName[i] + "List.txt");
//         }

//         QuickSort qSort = new QuickSort();

//         long test = qSort.sort(words[1]);

//         for (String strings : words[1]) {
//             System.out.println(strings);
//         }
//         }

// }
public class Main extends Sort{
    public static void main(String[] args) {

        Main sortObj = new Main();
       
        ReadFile readFile = new ReadFile();
        WriteFile writeFile = new WriteFile();

        //Prepare graph data
        String[] caseName = {"Best", "Average", "Worst"};
        String[][] words = new String [caseName.length][];

        for (int i = 0; i < caseName.length; i++) {
            words[i] = readFile.readArray(caseName[i] + "List.txt");
        }
        

        Instant start = Instant.now();
        System.out.println("Sorting started!");
        
        //To change sorting type 
        //Set sorting name accordingly
        sortObj.setName("Bubble"); //Insert sorting type here
        int intval = 10000;
        String[] input = readFile.readCount(words[0], intval);
        String result[][] = new String[caseName.length][];

        for (int i = 0; i < caseName.length; i++) {
            result[i] = sortObj.sort(sortObj, caseName[i], words[i], input, intval, sortObj.getName());
        }


        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toSeconds();
        System.out.println("----------------------------------------------");
        //System.out.println("Average: ");
        System.out.println("(" + sortObj.getName() + " sort) Time taken: " + (timeElapsed / 60) + " minutes, " + (timeElapsed % 60) + " seconds");
        //System.out.println("Number of iteration: " + aveIter);

        //Write into file 
        sortObj.setFile(sortObj.getName() + "Sort.txt");

        //Graph data
        //Set for individual graph
        String header = sortObj.getName();

        String totalGraphName = header + "TotalGraphData.";
        writeFile.writeFileTotalTxt(totalGraphName + "txt", result, input, caseName, header);
        writeFile.writeFileTotalCsv(totalGraphName + "csv", result, caseName);
}
    

}
