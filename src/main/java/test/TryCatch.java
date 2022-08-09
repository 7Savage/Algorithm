package test;

public class TryCatch {
    public static int test() {
        try {
            System.out.print(1);
            System.out.print(",");
            System.out.println(1 / 0);
            System.out.print(", ");
        } catch (RuntimeException e) {
            System.out.print(2);
            System.out.print(", ");
        } catch (Exception e) {
            System.out.print(3);
            System.out.print(", ");
        } finally {
            System.out.print(4);
            System.out.print(", ");
        }
        System.out.print(6);
        System.out.print(", ");
        return 5;
    }

    public static void main(String[] args) {
        int test=test();
        System.out.println(test);
    }
}
