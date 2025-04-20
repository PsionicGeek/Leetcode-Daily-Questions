/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }

        int level = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int childCount =(int)Math.pow(2,level);
            while(childCount>1){
                Node curr = q.poll();
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                 if(curr.right!=null){
                    q.offer(curr.right);
                }
                Node nextNode = q.peek();
                curr.next=nextNode;
                childCount--;
            }
            Node levelLastNode = q.poll();
            if(levelLastNode.left!=null){
                    q.offer(levelLastNode.left);
                }
                 if(levelLastNode.right!=null){
                    q.offer(levelLastNode.right);
                }
            levelLastNode.next= null;
            level++;
        }
        return root;


        
    }
}