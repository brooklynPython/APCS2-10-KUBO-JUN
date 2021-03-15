public class Driver {
  public static void main (String args[]) {
    int[] data = {1,10,15,2,54,3,66,88,12};
    int start = 3;
    int end = 7;
    Preliminary pre = new Preliminary();
    System.out.println(pre.partition(data, start, end));


    System.out.println("====  Quick Select ====");
    Quick quick = new Quick();
    int x = quick.quickselect(data, 3);
    System.out.println("Quick Select Answer is: " + x);

    
    System.out.println("==== QUick Sort ====");
    quick.quicksort(data);

    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i] + ", ");
    }
  }
}
