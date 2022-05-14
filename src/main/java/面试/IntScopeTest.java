package 面试;

public class IntScopeTest {
    public static void main(String[] args) {
        int a = 128;
        int b = 128;
        System.out.println("a==b:" + (a == b));
        Integer c = 128;
        Integer d = 128;
        System.out.println("c==d:" + (c == d));
        System.out.println("c.equals(d):" + (c.equals(d)));
        System.out.println("a==c:" + (a == c));
        System.out.println("c.equals(a):" + (c.equals(a)));
        Integer e = 127;
        Integer f = 127;
        System.out.println("e==f:" + (e == f));
        Integer g = new Integer(128);
        Integer h = new Integer(127);
        System.out.println("d==g:" + (d == g));
        System.out.println("e==h:" + (e == h));
    }
}
