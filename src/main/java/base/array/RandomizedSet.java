package base.array;

import java.util.*;

/**
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 */
public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> valToIndex;//值和索引的键值对
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        //如果包含val，则不插入
        if (valToIndex.containsKey(val)) {
            return false;
        }
        //如果val为空，则插入到链表末端
        list.add(val);
        //记录索引
        valToIndex.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        //如果不包含val
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        //如果包含，记录val的索引
        int index = valToIndex.get(val);
        int last = list.get(list.size() - 1);
        //将链表末尾的值赋给要删除处的索引值
        list.set(index, last);
        //删除末尾元素
        list.remove(list.size() - 1);
        //map添加刚刚交换的元素
        valToIndex.put(last, index);
        //删除末尾元素
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
