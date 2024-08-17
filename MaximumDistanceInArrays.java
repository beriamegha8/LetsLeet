class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0); //1st element of 1st array
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1); //last element of 1st array
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            int distance1 = Math.abs(currentMax - globalMin);
            int distance2 = Math.abs(globalMax - currentMin);

            maxDistance = Math.max(maxDistance, Math.max(distance1, distance2));

            globalMin = Math.min(globalMin, currentMin);
            globalMax = Math.max(globalMax, currentMax);
        }

        return maxDistance;
    }
}
