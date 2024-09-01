class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n= queries.length;
        int[] results= new int[n];
        PriorityQueue<Integer> minHeap= new PriorityQueue<>((a,b)->b-a);
        for (int i=0; i< n; i++){
            int x= queries[i][0];
            int y= queries[i][1];
            int dist= Math.abs(x)+Math.abs(y);
            minHeap.offer(dist);

            if(minHeap.size() > k){
                minHeap.poll();
            }
            if(minHeap.size() < k){
                results[i]= -1;
            }
            else{
                results[i]= minHeap.peek();
            }
        }
        return results;
    }
}
