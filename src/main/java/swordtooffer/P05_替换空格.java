package swordtooffer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class P05_替换空格 {
    /**
     * 暴力
     * 时间复杂度 O(N)： 遍历使用 O(N)，每轮添加（修改）字符操作使用 O(1)；
     * 空间复杂度 O(N)： Python 新建的 list 和 Java 新建的 StringBuilder 都使用了线性大小的额外空间。
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
