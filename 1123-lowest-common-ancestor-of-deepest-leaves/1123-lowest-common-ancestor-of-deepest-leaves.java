/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    TreeNode node;
    int level=0;
    public Pair(TreeNode n,int l){
        node=n;
        level=l;
    }
 }
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair pair = findLCA(root);
        return pair.node;
    }

    public Pair findLCA(TreeNode cur){
        if(cur==null){
            return new Pair(null,0);
        }

        Pair left = findLCA(cur.left);
        Pair right = findLCA(cur.right);

        if(left.level == right.level){
            return new Pair(cur,1+left.level);
        }
        if(left.level<right.level){
            return new Pair(right.node,1+right.level);
        }
        return new Pair(left.node, 1+left.level);
    }
}