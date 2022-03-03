package hot100;

public class P136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num :
                nums) {
            single ^= num;
        }
        return single;
    }
}
