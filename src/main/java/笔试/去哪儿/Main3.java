package 笔试.去哪儿;

import java.util.*;

public class Main3 {
    private boolean[] isSubsequent(char[] charArray) {
        Arrays.sort(charArray);
        boolean[] res = new boolean[2];

        int len = charArray.length;
        for (int i = 0; i <= len - 5; i++) {
            boolean currFlag = true;
            int j = i + 1;
            for (; j <= i + 4; j++) {
                if (charArray[j] - charArray[j - 1] != 1) {
                    currFlag = false;
                    break;
                }
            }
            if (currFlag) {
                res[0] = true;
                if (charArray[j] == 'A') {
                    res[1] = true;
                }
            }
        }
        return res;
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 翻牌
     *
     * @param inHand string字符串 一组以单空格间隔的手牌(例如：SA HK H9 D8 C5 S5 H4)
     * @return string字符串
     */
    public String showDown(String inHand) {
        // write code here


        Map<Character, StringBuilder> colorsToMap = new HashMap<>();
        colorsToMap.put('S', new StringBuilder());
        colorsToMap.put('H', new StringBuilder());
        colorsToMap.put('C', new StringBuilder());
        colorsToMap.put('D', new StringBuilder());

        Map<Character, Integer> freqToMap = new HashMap<>();
        boolean twoFlag = false;
        boolean threeFlag = false;
        boolean fourFlag = false;
        boolean sameFiveColor = false;
        char sameColor = ' ';

        String[] strArr = inHand.split(" ");
        char[] type = new char[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String curr = strArr[i];
            char color = curr.charAt(0);
            type[i] = curr.charAt(1);
            StringBuilder sb = colorsToMap.get(color);
            sb.append(type[i]);
            if (sb.length() == 5) {
                sameFiveColor = true;
                sameColor = color;
            }
            freqToMap.put(type[i], freqToMap.getOrDefault(type[i], 0) + 1);
            if (freqToMap.get(type[i]) == 2) twoFlag = true;
            if (freqToMap.get(type[i]) == 3) threeFlag = true;
            if (freqToMap.get(type[i]) == 4) fourFlag = true;
        }

        if (sameFiveColor) {
            StringBuilder stringBuilder = colorsToMap.get(sameColor);
            String sameStr = stringBuilder.toString();
            boolean[] subsequent = isSubsequent(sameStr.toCharArray());
            if (subsequent[1]) {
                return "HuangJiaTongHuaShun";
            }

            if (subsequent[0]) {
                return "TongHuaShun";
            }
        }

        if (fourFlag) {
            return "SiTiao";
        }

        if (threeFlag && twoFlag) {
            return "HuLu";
        }

        if (sameFiveColor) {
            return "TongHua";
        }

        boolean[] subsequent = isSubsequent(type);
        if (subsequent[0]) {
            return "ShunZi";
        }

        if (threeFlag) {
            return "SanTiao";
        }

        return "YiDui";
    }


}
