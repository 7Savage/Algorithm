package swordtooffer;

public class P67_把字符串转换成整数 {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        int j = 1;
        int boundary = Integer.MAX_VALUE / 10;
        int sign = 1;
        if (chars[0] == '-') sign = -1;
        else if (chars[0] != '+') j = 0;
        int res = 0;
        for (int i = j; i < chars.length; i++) {
            char c = chars[i];
            if (c < '0' || c > '9') break;
            if (res > boundary || res == boundary && chars[i] > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c - '0');
        }
        return sign * res;
    }
}
