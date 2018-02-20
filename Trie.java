
public class TrieConstruct {
    
    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
        public TrieNode() {}
    }
    
    class Trie {
        
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode r = root;
            for( char c : word.toCharArray() ){
                if( r.children[c-'a'] == null  ){
                    r.children[c-'a'] = new TrieNode();
                }
                r = r.children[c-'a'];
            }
            r.isWord = true;
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode r = root;
            for( char c : word.toCharArray() ){
                if( r.children[c-'a'] == null  ) return false;
                r = r.children[c-'a'];
            }
            return r.isWord;
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode r = root;
            for( char c : prefix.toCharArray() ){
                if( r.children[c-'a'] == null  ) return false;
                r = r.children[c-'a'];
            }
            return true;
        }
    }

}
