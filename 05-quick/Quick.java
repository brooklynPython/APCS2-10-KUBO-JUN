import java.util.*;
public class Quick {
  public static int partition (int [] data, int start, int end){
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
    System.out.println(" ======  i = " + i + " j = " + j);
    while (i < j) {
      System.out.println("i = " + i + " j = " + j);
      for (i++; data[i] < pivot; i++);
      for (j--; data[j] > pivot; j--);
      if (i < j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
      }
    }

    return j;
  }
  public static int quickselect(int[] data, int k){
    System.out.println("===================================");
    int partition = partition(data, 0, data.length-1);
    System.out.println("quickselect: " + partition + " " + k + " data.length: " + data.length );
    System.out.println("partition: " + partition + " k: " + k);
    if (partition == k) {
      return data[partition];
    }
    else if (partition > k) {
      return quickselect(Arrays.copyOfRange(data,0,partition), k);
    }
    else  {
      return quickselect(Arrays.copyOfRange(data,partition,data.length-1), k);
    }

  }

  public static void quicksort(int[] data){
            if (data.length > 1) {
            int partition = partition(data, 0, data.length-1);
            quicksort(Arrays.copyOfRange(data,0, partition));
            quicksort(Arrays.copyOfRange(data,partition,data.length-1));
          }
        }

}  // end of whole class
