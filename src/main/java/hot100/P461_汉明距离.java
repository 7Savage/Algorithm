package hot100;

public class P461_汉明距离 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance2(int x, int y) {
        int distance = 0;
        int xor = x ^ y;
        while (xor != 0) {
            if (xor % 2 == 1) {
                distance++;
            }
            xor >>= 1;
        }
        return distance;
    }
}
