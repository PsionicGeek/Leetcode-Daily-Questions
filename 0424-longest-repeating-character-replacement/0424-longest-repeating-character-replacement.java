class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxLen=0,maxFreq=0;
        int[] freqMap = new int[26];
        Arrays.fill(freqMap,0);
        while(r<s.length()){
            freqMap[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq, freqMap[s.charAt(r)-'A']);
            if((r-l+1)-maxFreq>k){
                freqMap[s.charAt(l)-'A']--;
                maxFreq=0;
                l+=1;
            }
            maxLen= Math.max(maxLen,(r-l+1));
            r+=1;
            
        }
        return maxLen;
        
    }
}