package QuickSort;

// Java implementation of QuickSort 
public class QuickSort{
 
    // private String names[];
    // private int length;
 
    private long epoch;

    public long sort(String array[]) {
        if (array == null || array.length == 0) {
            return 0;
        }
        epoch ++;
        epoch ++;
        int n = array.length;
        quickSort(0, n - 1, array);
        return epoch;
    }
 
 
    private void quickSort(int lowerIndex, int higherIndex, String[] arr) {
        int i = lowerIndex;
        int j = higherIndex;
        epoch += 2;

        String pivot = arr[lowerIndex + (higherIndex - lowerIndex) / 2];
        epoch += 4;

        epoch ++;
        while (i <= j) {
            epoch += 2;
            while (arr[i].compareTo(pivot) < 0) {
                epoch += 2;
                i++;
            }
 
            epoch += 2;
            while (arr[j].compareTo(pivot) > 0) {
                epoch += 2;
                j--;
            }
 
            epoch ++;
            if (i <= j) {
                epoch ++;
                swap(i, j, arr);
                i++;
                j--;
                epoch += 4;
            }  
        }
 
        //call quickSort recursively
        epoch ++;
        if (lowerIndex < j) {
            epoch ++;
           quickSort(lowerIndex, j, arr);
        }
        epoch ++;
        if (i < higherIndex) {
            epoch ++;
            quickSort(i, higherIndex, arr);
        }
     }
 
    private void swap(int i, int j, String[] arr) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        epoch += 3;
    }
}