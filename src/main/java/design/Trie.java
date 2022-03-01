package design;

public class Trie {
    Trie[] child;
    boolean isEnd;

    public Trie() {
        child = new Trie[26];
    }

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

    public boolean search(String word) {
        Trie node = searchWith(word);
        return node != null && node.isEnd;
    }

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
