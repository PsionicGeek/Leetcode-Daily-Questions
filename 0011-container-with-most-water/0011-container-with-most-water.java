class Solution {
    public int maxArea(int[] height) {

        int start=0;
        int end=height.length-1;
        int res=0;
        while(start<end){
            int tempRes=(end-start)*(Math.min(height[start],height[end]));
            res=Math.max(res,tempRes);
            if(height[start]<=height[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return res;
        
    }
}