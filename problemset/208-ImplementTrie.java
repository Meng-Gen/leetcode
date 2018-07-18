class Trie {
    private Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int letterPos = letter - 'a';
            if (curr.children[letterPos] == null) {
                curr.children[letterPos] = new Node(letter);
            }
            curr = curr.children[letterPos];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int letterPos = letter - 'a';
            if (curr.children[letterPos] == null) {
                return false;
            }
            curr = curr.children[letterPos];
        }
        return curr.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            int letterPos = letter - 'a';
            if (curr.children[letterPos] == null) {
                return false;
            }
            curr = curr.children[letterPos];
        }
        return true;
    }
    
    public static class Node {
        public char value;
        public boolean isWord;
        public Node[] children = new Node[26];

        public Node() {
        }

        public Node(char value) {
            this.value = value;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */