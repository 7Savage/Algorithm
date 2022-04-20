package swordtooffer;

//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
// 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
public class P58_I翻转单词顺序 {
    //时间复杂度 O(N) ： 其中 N 为字符串 s 的长度，线性遍历字符串。
    //空间复杂度 O(N) ： 新建的StringBuilder中的字符串总长度 ≤N ，占用 O(N) 大小的额外空间。
    public String reverseWords(String s) {
        s = s.trim();// 删除首尾空格
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = i;
        while (i >= 0) {
            // 搜索首个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            // 添加单词
            sb.append(s, i + 1, j + 1).append(" ");
            // 跳过单词间空格
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        return sb.toString().trim();// 删除最后一个空格转化为字符串并返回
    }
}
