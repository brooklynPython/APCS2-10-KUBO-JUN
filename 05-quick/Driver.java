public class Driver {
  public static void main (String args[]) {
    int[] data = {999,999,999,4,3,2,1,0,999,999,999};
    int start = 3;
    int end = 7;
    Preliminary pre = new Preliminary();
    System.out.println(pre.partition(data, start, end));


    Quick quick = new Quick();
    int x = quick.quickselect(data, 2);
    System.out.println(x);
  }
}
