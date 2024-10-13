class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Flatten the input into a list of [value, list index]
        List<int[]> allElements = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int value : nums.get(i)) {
                allElements.add(new int[] {value, i});
            }
        }

        Collections.sort(allElements, (a, b) -> a[0] - b[0]);

        // Use a sliding window to find the smallest range
        int start = 0, end = Integer.MAX_VALUE;
        int left = 0;  // Left pointer of the window
        int count = 0;  // Number of unique lists in the current window
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Traverse the flattened list with the right pointer
        for (int right = 0; right < allElements.size(); right++) {
            int[] element = allElements.get(right);
            int value = element[0];
            int listIndex = element[1];

            // Add the element to the frequency map
            frequencyMap.put(listIndex, frequencyMap.getOrDefault(listIndex, 0) + 1);
            if (frequencyMap.get(listIndex) == 1) {
                count++;  // New list covered
            }

            // Try to shrink the window from the left
            while (count == nums.size()) {
                int leftValue = allElements.get(left)[0];
                int rightValue = allElements.get(right)[0];

                // Update the smallest range if found
                if (rightValue - leftValue < end - start) {
                    start = leftValue;
                    end = rightValue;
                }

                // Remove the left element from the frequency map
                int leftListIndex = allElements.get(left)[1];
                frequencyMap.put(leftListIndex, frequencyMap.get(leftListIndex) - 1);
                if (frequencyMap.get(leftListIndex) == 0) {
                    count--;  // One list is no longer fully covered
                }
                left++;  // Move the left pointer to shrink the window
            }
        }

        // Return the smallest range found
        return new int[] {start, end};
    }
}
