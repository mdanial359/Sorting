package ReadFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.LinkedList;

public class ReadFile {
    public boolean isEmpty (String filename) {
      boolean bool = false;
      File f = new File(filename);
      if (f.length() == 0)
      bool = true;

      return bool;
    }

    // public LinkedList<String>[] readInput (String[] words, int interval) {
    //   int size; 
    //   int count = 0;
    //   int idx = 0;
    //   if (words.length%interval == 0)
    //     size = words.length/interval;
    //     else
    //     size = words.length/interval + 1;

    //   size ++; // Add zero index
    //     LinkedList<String> [ ] wordsList = new LinkedList[ size ];

    //   for( int i = 0; i < wordsList.length; i++ )
    //     wordsList[ i ] = new LinkedList<>( );
     
    //  for (int i = 0; i < size; i ++) {
    //   if (idx > words.length)
    //   idx = words.length;

    //   for (int j = 0; j < idx; j++) {
    //     wordsList[count].add(words[j]);
    //   }
    //   idx += interval;
    //   count ++;
    //  }
    //   return wordsList;
    // }

    public String[] readCount (String[] words, int interval) {
        int size = words.length / interval;
        if (words.length % interval != 0)
        size++;

        String [] input = new String[size];
        int idx = interval;
        for (int i = 0; i < size; i ++) {
        if (idx > words.length)
        idx = words.length;
        input[i] = Integer.toString(idx);
        idx += interval;
     }
      return input;
    }

    public String[][] read2DArray (String filename) throws FileNotFoundException {
      Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
      int rows = getFileLine(filename);
      int columns = getFileCol(filename);;
      String [][] myArray = new String[rows][columns];
      while(sc.hasNextLine()) {
         for (int i=0; i<myArray.length; i++) {
            String[] line = sc.nextLine().trim().split("\t");
            for (int j=0; j<line.length; j++) {
               myArray[i][j] = (line[j]);
            }
         }
      }
      return myArray;
    }

    public boolean isExist (String[][] arr, String str) {
      boolean bool = false;
        for (int i = 0; i <  arr.length; i++) {
          if (arr[i][0].equals(str)) 
          {
            bool = true;
          }
        }
        return bool;
      } 

    public int isExistIndex (String[][] arr, String str) {

      int index = 0;
        for (int i = 0; i <  arr.length; i++) {
          if (arr[i][0].equals(str)) 
          {
            index = i;
          }
        }
        return index;
      } 

    public String[][] editFile (String filename, String str, String[] inputArray) throws FileNotFoundException {

      int col = 4;
      int row;

      
      String[][] arr;
      arr = read2DArray (filename);
      boolean exist = isExist(arr, str);
      int index = isExistIndex(arr, str);

      if (arr.length == 0)
      row = 1;
      else
        if (exist)
          row = arr.length;
          else
            row = arr.length + 1;
      

      String[][] editArr = new String [row][col];
      int count = 0;
        for (int i = 0; i < arr.length; i++) {
          if (exist && i == index)  
          {
            continue;
          }
          else
          {
            for (int j = 0; j < col; j++) {
              editArr[count][j] = arr[i][j];
            }
            count++;
          }     
        }
        
      for (int i = 0; i < col; i++) {
        if (i == 0)
        editArr[row-1][i] = str;
        else
        editArr[row-1][i] = inputArray[i-1];
      }
        return editArr;
    }

    public int getFileLine (String filename) {
      int count = 0;
      try {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            myReader.nextLine();
            count++;
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      //System.out.println(count);
      return count;
    }

    public int getFileCol (String filename) {
      int count = 0;
      // ArrayList<String> arr = new ArrayList<String>();
      try {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
          for (int i = 0; i <= 1; i++) {
            if (i == 0) {
              myReader.nextLine();
            }
            else {
              String[] line = myReader.nextLine().trim().split("\t");
              count = line.length;
            }
             }
             myReader.close();
          } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      //System.out.println(count);
      return count;
    }

    public  LinkedList<String> readList(String filename) {
        String temp = "";
        LinkedList<String> word = new LinkedList<String>();
    
      try {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            temp =  myReader.nextLine();
            word.add(temp);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      return word;
    }

      public  String[] readArray(String filename) {
        LinkedList<String> word = readList(filename);
        return word.toArray(new String[word.size()]);
      }
      
}

