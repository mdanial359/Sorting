package WriteFile;
import ReadFile.ReadFile;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.PrintWriter;

public class WriteFile {

   ReadFile readFile = new ReadFile();
    public  void writeFileWithHeader (String filename, String [] result, String [] input, String head, String footer) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(head + '\n' + footer + '\n');
            writeTwoArray(myWriter, result, input);
            myWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

  //   public  void writeFileAppend (String filename, String [] result, String head)  {
  //     // try {
  //     //   String [][] arr =  readFile.editFile(filename, head, result);
  //     //   System.out.println(Arrays.deepToString(arr));
  //     // } catch (FileNotFoundException e) {
  //     //   // TODO Auto-generated catch block
  //     //   e.printStackTrace();
  //     // }
  //         try {
  //           String[][] writeArr =  readFile.editFile(filename, head, result);
  //           FileWriter myWriter = new FileWriter(filename);
  //           write2DArray(myWriter, writeArr);
  //           myWriter.close();

  //         } catch (IOException e1) {
  //           // TODO Auto-generated catch block
  //           e1.printStackTrace();
  //         }
  // }

     public  void writeFileTotalCsv (String filename, String[][] result, String[] caseName)  {
            try (PrintWriter writer = new PrintWriter(filename)) {
              StringBuilder sb = new StringBuilder();

              int n = result[0].length;
              int row = result.length;

              for (int i = 0; i < row; i++) {
                sb.append(caseName[i]);
                if(i !=  row - 1)
                sb.append(',');
              }
              sb.append('\n');

              for (int i = 0; i < n; i++) {
                for (int j = 0; j < row; j++) {
                  sb.append(result[j][i]);
                  if(j !=  row - 1)
                  sb.append(',');
                }
                if(i !=  n - 1)
                sb.append('\n');              
              }

              writer.write(sb.toString());
            } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
          }
  }

  public  void writeFileTotalTxt (String filename, String[][] result, String[] input, String[] caseName, String header)  {
    try {
      FileWriter myWriter = new FileWriter(filename);
      System.out.println("Saved");
      myWriter.write(header);
      myWriter.write('\n');

      writeArraySpace(myWriter, input);
      myWriter.write('\n');
      for (int i = 0; i < caseName.length; i++) {
        myWriter.write(caseName[i]);
        myWriter.write(' ');
        writeArraySpace(myWriter, result[i]);
        if (i != caseName.length - 1)
          myWriter.write('\n');
      }
      myWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
}


    public  void writeFile (String filename, String [] result) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            //writeArrayTab(myWriter, result);
            writeArray(myWriter, result); //For horizontal list
            myWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

    // private  void write2DArray (FileWriter myWriter, String [][] result) {
    //   int col = 4;
    //   try {
    //     for (int i = 0; i < result.length; i++) 
    //       {
    //         for (int j = 0; j < col; j++) 
    //         {
    //             myWriter.write(result[i][j]);

    //             if (j < (col - 1))
    //                 myWriter.write('\t');
   
    //         }
    //         if (i < (result.length - 1))
    //             myWriter.write('\n');
              
    //       }
    //   } catch (IOException e) {
    //     // TODO Auto-generated catch block
    //     e.printStackTrace();
    //   }

    // }

    private  void writeTwoArray (FileWriter myWriter, String [] result, String [] input) throws IOException {
              writeArraySpace(myWriter, input);
              myWriter.write('\n');
              writeArraySpace(myWriter, result);
  }

    private  void writeArray (FileWriter myWriter, String [] result) throws IOException {
        for (int i = 0; i < result.length; i++) 
            {
              myWriter.write(result[i]);;
              if (i < (result.length - 1))
                myWriter.write('\n');
            }
    }

    private void writeArraySpace (FileWriter myWriter, String [] result) throws IOException {
      for (int i = 0; i < result.length; i++) 
          {
            myWriter.write(result[i]);
            if (i < (result.length - 1))
              myWriter.write(' ');
          }
  }
 
}
