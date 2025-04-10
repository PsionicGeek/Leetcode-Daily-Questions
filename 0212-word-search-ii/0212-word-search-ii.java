class TrieNode{
    TrieNode[] links= new TrieNode[26];
    String word=null;
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m= board.length;
        int n=board[0].length;
        HashSet<String> res=new HashSet<>();
        TrieNode root = buildTrie(words);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(i,j,root,board,res);
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(int i, int j, TrieNode root,char[][] board, HashSet<String> res ){
        if(i<0||i>=board.length||j<0||j>=board[0].length){
            return;
        }
        char ch = board[i][j];
        if(ch=='#'||root.links[ch-'a']==null)
        return;
        root=root.links[ch-'a'];
        if(root.word!=null)
        res.add(root.word);

        board[i][j]='#';
        dfs(i,j-1,root,board,res);
        dfs(i,j+1,root,board,res);
        dfs(i-1,j,root,board,res);
        dfs(i+1,j,root,board,res);

        board[i][j]=ch;

    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w:words){
            TrieNode curr =root;
            for(char c: w.toCharArray()){
                if(curr.links[c-'a']==null){
                    curr.links[c-'a']=new TrieNode();
                }
                curr=curr.links[c-'a'];
            }
            curr.word=w;
        }
        return root;
    }
}