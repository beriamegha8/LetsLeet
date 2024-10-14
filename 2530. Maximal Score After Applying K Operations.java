// import java.util.PriorityQueue;
class Solution {
    public long maxKelements(int[] nums, int k) {
        // Max-heap to store elements in descending order
        PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a, b) -> b - a);
        //adding all the elements
        for (int num : nums) {
            maxHeap.offer(num);
        }
        long score= 0;
        for (int i= 0; i < k; i++) {
            int maxEl= maxHeap.poll();  //extracting the largest element
            score+= maxEl;
            int newEl= (int)Math.ceil(maxEl/ 3.0); 
            maxHeap.offer(newEl);  //pushing the new element back into the heap
        }
        return score;
    }
}
