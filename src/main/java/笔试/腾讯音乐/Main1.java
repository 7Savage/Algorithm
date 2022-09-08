package 笔试.腾讯音乐;

public class Main1 {
    public int minOperations(String str) {
        int[] arr = new int[26];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 2) {
                judge(arr);
                arr[i] -= 2;
                count++;
            }
        }
        return count;
    }

    public void judge(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                arr[i]++;
                break;
            }
        }
    }
}
