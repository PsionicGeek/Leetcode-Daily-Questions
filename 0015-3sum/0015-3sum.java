class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int start=0;
        List<List<Integer>> result=new LinkedList<>();
        while(start<nums.length-2){
            int low=start+1;
            int high=nums.length-1;
            while(low<high){
                if(nums[low]+nums[high]<-1*nums[start]){
                    int pl=nums[low];
                    while(low<high&&pl==nums[low]){
                        low++;
                    }
                }
                else if(nums[low]+nums[high]>-1*nums[start]){
                    int ph=nums[high];
                    while(high>low&&ph==nums[high]){
                        high--;
                    }
                }
                else{
                    List<Integer> re=new LinkedList<Integer>();
                    re.add(nums[start]);
                    re.add(nums[low]);
                    re.add(nums[high]);
                    result.add(re);
                    int pl=nums[low];
                    while(low<high&&pl==nums[low]){
                        low++;
                    }
                    int ph=nums[high];
                    while(high>low&&ph==nums[high]){
                        high--;
                    }
                }
            }
            int ps=nums[start];
            
            while(start<nums.length&&ps==nums[start]){
                        start++;
                    }
        }
        return result;
    }
}