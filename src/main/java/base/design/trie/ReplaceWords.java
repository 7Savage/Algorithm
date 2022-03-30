package base.design.trie;

import java.util.List;

/**
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 */
public class ReplaceWords {
    class Trie {
        Trie[] child;
        boolean isEnd;

        public Trie() {
            child = new Trie[26];
        }

        public void insert(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i);
                int index = c - 'a';
                if (root.child[index] == null) {
                    root.child[index] = new Trie();
                }
                root = root.child[index];
            }
            root.isEnd = true;
        }

        /// 检查word是否以字典树中某一个单词为前缀，并返回前缀长度
        public int minPrefix(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                root = root.child[word.charAt(i) - 'a'];

                if (root == null) {
                    return 0;
                }
                if (root.isEnd) {
                    return i + 1;
                }
            }
            return 0;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (int i = 0; i < dictionary.size(); i++) {
            root.insert(dictionary.get(i));
        }
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            int minLength = root.minPrefix(strs[i]);
            if (minLength != 0) {
                //substring是左闭右开
                sb.append(strs[i], 0, minLength).append(" ");
            } else {
                sb.append(strs[i]).append(" ");
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
