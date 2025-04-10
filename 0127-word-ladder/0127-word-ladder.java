class Pair{
    String word;
    int steps;
    public Pair(String _word, int _steps){
        this.word=_word;
        this.steps=_steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st= new HashSet<>();
        int len=wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps= q.peek().steps;
            q.poll();

            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArray= word.toCharArray();
                    charArray[i]=ch;
                    String newWord=new String(charArray);
                    if(st.contains(newWord)){
                        st.remove(newWord);
                        q.offer(new Pair(newWord,steps+1));
                    }
                }
            }


        }
        return 0;
        
    }
}