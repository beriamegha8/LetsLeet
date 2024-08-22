class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                // Moving right, just push onto stack
                stack.push(asteroid);
            } else {
                // Moving left, handle collisions
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop(); // The right-moving asteroid is smaller and gets destroyed
                }
                
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == Math.abs(asteroid)) {
                    // Both asteroids destroy each other
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    // No collisions, or the current asteroid is moving left with no right-moving asteroid to collide with
                    stack.push(asteroid);
                }
            }
        }
        // Convert the stack to an int array to return
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
