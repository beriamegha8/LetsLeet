class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.computeIfAbsent(start, k -> new Stack<>()).push(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }
        int startNode = pairs[0][0];
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) - inDegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }        // Hierholzer's algorithm for Eulerian path
        LinkedList<int[]> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                // Traverse an edge
                stack.push(graph.get(node).pop());
            } else {
                // Backtrack
                stack.pop();
                if (!stack.isEmpty()) {
                    result.addFirst(new int[]{stack.peek(), node});
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}
