public class Driver {
  public static void main (String args[]) {
    int[] data = {999,999,999,4,3,2,1,0,999,999,999};
    int start = 3;
    int end = 7;
    Preliminary pre = new Preliminary();
    System.out.println(pre.partition(data, start, end));


    Quick quick = new Quick();
    //int x = quick.quickselect(data, 5);
    //System.out.println(x);

    quick.quicksort(data);

    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i] + ", ");
    }
  }
}
