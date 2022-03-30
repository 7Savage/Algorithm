package base.design.trie;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配
 */
public class WordDictionary {
    WordDictionary[] child;
    boolean isEnd;

    //初始化词典对象
    public WordDictionary() {
        child = new WordDictionary[26];
    }

    //将 word 添加到数据结构中，之后可以对它进行匹配
    public void addWord(String word) {
        WordDictionary root = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (root.child[index] == null) {
                root.child[index] = new WordDictionary();
            }
            root = root.child[index];
        }
        root.isEnd = true;
    }

    // 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
    public boolean search(String word) {
        WordDictionary root = this;
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, WordDictionary node, int i) {
        if (node == null) {
            return false;
        }
        if (i == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(i);
        if (c == '.') {
            for (WordDictionary child :
                    node.child) {
                if (dfs(word, child, i + 1)){
                    return true;
                }
            }
            return false;
        } else {
            return dfs(word, node.child[c - 'a'], i + 1);
        }
    }
}
