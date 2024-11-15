class Solution {
    public int[] twoSum(int[] nums, int target) {
        if((nums.length<2||nums.length>10000)||(-Math.pow(10,9)>target||target>Math.pow(10,9)))
            return null;
           HashMap<Integer, Integer> p2= new HashMap<Integer, Integer>();
        for(int p1=0;p1<nums.length;p1++){
            int numToFind= target-nums[p1];
            // if(-Math.pow(10,9)>nums[p1]||nums[p1]>Math.pow(10,9))
            //     return null;
         
            if(p2.get(nums[p1])==null){
                 p2.put(numToFind,p1);
            }
            else{
               return new int[] {p2.get(nums[p1]),p1};
            }
        }
        return null;
    }
}