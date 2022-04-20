package 笔试题.Day0402_京东.pic;

public class test1 {
   private int value;
   public void setValue(int value){
       this.value=value;
   }
   public int getValue(){return value;}

    public static void main(String[] args) {
        int v=3;
        test1 test1 = new test1();
        test1.setValue(3);
        System.out.println(test1.getValue());
    }
}
