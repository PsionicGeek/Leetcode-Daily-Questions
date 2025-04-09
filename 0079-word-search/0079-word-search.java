class Solution {
    int[][] visited;
    public boolean exist(char[][] board, String word) {
        int ROW= board.length;
        int COL=board[0].length;
        visited=new int[ROW][COL];

        for(int r=0;r<ROW;r++){
            for(int c=0;c<COL;c++){
                if(dfs(ROW,COL,0,board,word,r,c)){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean dfs(int ROW,int COL, int i,char[][] board, String word,int r,int c){
        if(i==word.length()){
            return true;
        }
        if(r<0||c<0||r>=ROW||c>=COL||board[r][c]!=word.charAt(i)||visited[r][c]==1){
            return false;
        }
        visited[r][c]=1;
        boolean res=dfs(ROW,COL,i+1,board,word,r+1,c)||dfs(ROW,COL,i+1,board,word,r-1,c)||dfs(ROW,COL,i+1,board,word,r,c+1)||dfs(ROW,COL,i+1,board,word,r,c-1);
        visited[r][c]=0;
        return res;
    }

}