class Solution {
    public int trap(int[] height) {

        int maxLeft=height[0];
        int maxRight=height[height.length-1];
        int left=0;
        int right=height.length-1;
        int res=0;
        while(left<right){
            if(maxLeft<maxRight){
            if(maxLeft-height[left]>0){
                res+=maxLeft-height[left];
            }
            else{
                maxLeft=height[left];
            }
            }
            else{
                if(maxRight-height[right]>0){
                res+=maxRight-height[right];
                }
                else{
                    maxRight =height[right];
                }
            }
            if(maxLeft<maxRight){
                left++;
            }
            else{
                right--;
            }

        }
        return res;
        
    }
}