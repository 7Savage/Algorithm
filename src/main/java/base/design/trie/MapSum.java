package base.design.trie;

/**
 * 设计一个 map ，满足以下几点:
 * <p>
 * 字符串表示键，整数表示值
 * 返回具有前缀等于给定字符串的键的值的总和
 */
public class MapSum {
    MapSum[] child;
    int val;
    public MapSum() {
        child = new MapSum[26];

    }

    //插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对。
    public void insert(String key, int val) {
        MapSum root = this;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = c - 'a';
            if (root.child[index] == null) {
                root.child[index] = new MapSum();
            }
            root = root.child[index];
        }

        root.val = val;
    }

    //返回所有以该前缀 prefix 开头的键 key 的值的总和
    public int sum(String prefix) {
        MapSum root = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (root.child[index] == null) {
                return 0;
            } else {
                root = root.child[index];
            }
        }
        return dfs(root);
    }

    //获得子节点的值，没有赋值就是0
    private int dfs(MapSum root) {
        if (root == null) {
            return 0;
        }
        int res = root.val > 0 ? root.val : 0;
        //遍历子节点
        for (MapSum child :
                root.child) {
            res += dfs(child);
        }
        return res;
    }


}
