package RadixSort;
import java.util.ArrayList;

public class RadixSort
{
    /*
     * Radix sort an array of Strings
     * Assume all are all ASCII
     * Assume all have length bounded by maxLen
     */
    // a function to simply sort
    public long sort(ArrayList<String> [][] array3, int arraynum1, int currentposition){
        int arraynum2 = 1 - arraynum1;
        long epoch = 2; // arithmetic and assigning

        // rearrangging from array1 to array2
        // run through the list of all characters in form of "i"
        
        epoch++;    // initialize i
        for(int i=0; i<128; i++){
            epoch+=5;   // for loop initialize theSize, and call function size
            // getting the list size in an array character
            int theSize = array3[arraynum1][i].size();

            epoch++;    // initialize loop
            for (int x = 0; x < theSize; x++){
                epoch+=3;   // for loop, assign temp, call get(), assign tempLowerCase, call toLowerCase()
                // storing word of index x in temp 
                String temp = array3[arraynum1][i].get(x);
                String tempLowerCase = temp.toLowerCase();

                epoch+=2;    // if statement, arithmetic
                if (currentposition > temp.length()-1){
                    array3[arraynum2][0].add(temp);
                    epoch++;    // call add()
                }
                else {
                    array3[arraynum2][(int) tempLowerCase.charAt(currentposition)].add(temp);
                    epoch+=2;    // call add(), call charAt()
                }
            }
        }

        epoch++;    // for loop initialize
        // clearing array2 for new input and arrangement - should put at the last
        for(int i=0; i<128; i++){
            array3[arraynum1][i].clear();
            epoch+=3;   // for loop, call clear()
        }

        return epoch;

    }
}