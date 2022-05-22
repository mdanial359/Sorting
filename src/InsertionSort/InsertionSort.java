package InsertionSort;

public class InsertionSort{

public long sort(String[] arr) {
  long epoch = 0;
  int i,j;
  String key;
  for (j = 1; j < arr.length; j++) { //the condition has changed
    key = arr[j];
    i = j - 1;
    while (i >= 0) {
      if (key.compareTo(arr[i]) > 0) {//here too
        break;
      }
      arr[i + 1] = arr[i];
      i--;
      //Counter placement is to change
      //Put where you thought would be suitable
      epoch++;
    }
    arr[i + 1] = key;
  }
  return epoch;
}
    }