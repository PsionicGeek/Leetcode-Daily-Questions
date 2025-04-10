class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int a:arr){
            if(k>0){
                minHeap.offer(a);
                k--;
            }
            else{
                if(Math.abs(minHeap.peek()-x)>Math.abs(a-x)){
                    minHeap.poll();
                    minHeap.offer(a);
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        while(!minHeap.isEmpty()){
            res.add(minHeap.poll());
        }
        return res;
        
    }
}