package BubbleSort;
// Java implementation
public class BubbleSort
{
    public long sort(String[] arr)
    {
        
        String temp;
        int n = arr.length;
 
        long epoch = 1; //Assignment of array length to n
        // Sorting strings using bubble sort
        epoch++; // assignment for j
        for (int j = 0; j < n - 1; j++)
        {
            epoch += 2; //Comparison and arithmetric 
            epoch += 2; //Increament j 

            epoch += 2; //Assignment i and arithmetric
            for (int i = j + 1; i < n; i++)
            {
                epoch++; //Comparison
                epoch+=2; //Increament i

                epoch+= 2; //Function call and comparison
                if (arr[j].compareTo(arr[i]) > 0)
                {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                    epoch+=3; //Assignment
                }
            }
            
        }
        epoch++; //Function return
        return  epoch;
    }
 
}