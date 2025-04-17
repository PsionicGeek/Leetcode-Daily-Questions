class Solution {
    class Node{
        Node left;
        Node right;
        int val;
        int count;
        Node(int v,int c){
            val=v;
            count=c;
            left=null;
            right=null;
        }
        Node(){}
    }
    public int[] topKFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Node root=new Node();
        int c=0;
        for(int k:map.keySet()){
            if(c==0){
                root.val=k;
                root.count=map.get(k);
            }
            else{
                Node temp=new Node(k,map.get(k));
               root= insertBetween(root,temp);
            }
            c++;
        }
        int[] ans=new int[key];
        for(int i=0;i<key;i++){
            ans[i]=root.val;
            root=root.right;
        }
        return ans;
    }
    public Node insertBetween(Node root,Node in){
        Node temp=root;
        if(root.count<in.count){
            root.left=in;
            in.right=root;
            root=in;
            
        }
        else{
            while(temp.right!=null&&temp.right.count>in.count){
                temp=temp.right;
            }
            if(temp.right==null){
                temp.right=in;
                in.left=temp;
               
            }
            else{
                in.right=temp.right;
                temp.right.left=in;
                temp.right=in;
                in.left=temp;
                
            }
        }
        return root;
    }
}