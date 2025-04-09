class Solution {

    

 
    

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

       
        HashMap<String, HashMap<String,Double>> equationMap = new HashMap<>();
        for(int i=0;i<equations.size();i++){
           

            String nem= equations.get(i).get(0);
            String den= equations.get(i).get(1);
            double value = values[i];
            if(!equationMap.containsKey(nem)){
                equationMap.put(nem, new HashMap<>());
            }
            equationMap.get(nem).put(den,value);
              if(!equationMap.containsKey(den)){
                equationMap.put(den, new HashMap<>());
            }
            equationMap.get(den).put(nem,1.0/value);
        }
        double[] res= new double[queries.size()];
        int count=0;

        for(List<String> query:queries){
            if(!(equationMap.containsKey(query.get(0))&&equationMap.containsKey(query.get(1))))
            {
                res[count++]=-1.0;
                continue;
            }
            if(query.get(0).equals(query.get(1))){
                res[count++]=1.0;
            }
            else{
            res[count++]=calculateQuery(query,equationMap);
            }

            if(!equationMap.containsKey(query.get(0))){
                equationMap.put(query.get(0), new HashMap<>());
            }
            equationMap.get(query.get(0)).put(query.get(1),res[count-1]);
              if(!equationMap.containsKey(query.get(1))){
                equationMap.put(query.get(1), new HashMap<>());
            }
            equationMap.get(query.get(1)).put(query.get(0),1.0/res[count-1]);

        }
        return res;
    }

    public double calculateQuery(List<String> query,HashMap<String, HashMap<String,Double>> equationMap){
        Queue<String> q = new LinkedList<>();
        Queue<Double> val=new LinkedList<>();
        String nem=query.get(0);
        String den=query.get(1);
        q.offer(nem);
        val.offer(1.0);

        Set<String> visited = new HashSet();
        while(!q.isEmpty()){
            String curr=q.poll();
            double num = val.poll();
            if(visited.contains(curr)){
                continue;
            }
            visited.add(curr);
            if(equationMap.containsKey(curr)){
                Map<String, Double> dens= equationMap.get(curr);
                for(String key: dens.keySet()){
                    if(!visited.contains(key)){
                        q.offer(key);
                        if(key.equals(den)){
                            return num*dens.get(key);
                        }
                        val.offer(num*dens.get(key));
                    }
                }

            }

        }
        return -1;
        
    }

    
}