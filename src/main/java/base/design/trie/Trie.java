package base.design.trie;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 */
public class Trie {
    Trie[] child;
    boolean isEnd;

    public Trie() {
        child = new Trie[26];
    }

    /**
     * 向前缀树中插入字符串 word
     * @param word
     */
    public void insert(String word) {
        //注意好了
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                node.child[index] = new Trie();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    /**
     * 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
     * @param word
     * @return
     */
    public boolean search(String word) {
        Trie node = searchWith(word);
        return node != null && node.isEnd;
    }

    /**
     * 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        return searchWith(prefix) != null;
    }


    public Trie searchWith(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                return null;
            }
            node = node.child[index];
        }
        return node;
    }
}
