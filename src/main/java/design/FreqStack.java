package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {
    int maxFreq = 0;
    Map<Integer, Integer> valToFreq = new HashMap<>();
    Map<Integer, Stack<Integer>> freqToVals = new HashMap<>();

    // 在栈中加入一个元素 val
    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0) + 1;
        valToFreq.put(val,freq);
        freqToVals.putIfAbsent(freq, new Stack<>());
        freqToVals.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    // 从栈中删除并返回出现频率最高的元素
    // 如果频率最高的元素不止一个，
    // 则返回最近添加的那个元素
    public int pop() {
        Stack<Integer> stack = freqToVals.get(maxFreq);
        int val = stack.pop();
        int freq = valToFreq.get(val) - 1;
        valToFreq.put(val, freq);
        if (stack.isEmpty()) {
            // 如果 maxFreq 对应的元素空了
            maxFreq--;
        }
        return val;
    }
}
