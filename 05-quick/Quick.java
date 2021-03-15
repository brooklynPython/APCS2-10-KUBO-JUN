import java.util.*;
public class Quick {
  public static int partition (int [] data, int start, int end){
    if (start == end) return start;
    if (data.length == 1) return start;
    Random rand = new Random();
    System.out.println("end and start is: " + end + " " + start);
    int index = rand.nextInt(end-start) + start;
    int pivot = data[index];
    System.out.println("index is: " + index);
    System.out.println("random pivot is: " + data[index]);
    data[index] = data[start];
    data[start] = pivot;
    int i = start;
    int j = end;
    System.out.println(" ======  i = " + i + " j = " + j + " data length = " + data.length);
    while (i < j) {
      System.out.println("i = " + i + " j = " + j + "pivot: " + pivot);
      for (i++; i < data.length && data[i] < pivot; i++);
      for (j--;  j >= 0 && data[j] > pivot; j--);
      if (i < j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
      }
    }

    return j;
  }

  public static int quickselect(int[] data, int k){
    int low = 0;
    int high = data.length - 1;
    int index = k;

    while (low < high) {
        int pv = partition(data, low, high);
        if (pv <= index) low = pv + 1;
        else if (pv > index) high = pv -1;
        else return data[pv];
    }
    return data[low];
  }

  public static void quicksort(int[] data){
            if (data.length > 2) {
            int partition = partition(data, 0, data.length-1);
            quicksort(Arrays.copyOfRange(data,0, partition));
            quicksort(Arrays.copyOfRange(data,partition,data.length-1));
          }
        }

}  // end of whole class
