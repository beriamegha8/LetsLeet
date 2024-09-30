class CustomStack {
    private int[] stack;
    private int top;
    private int maxSize;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = -1;                  // Start with an empty stack
    }
    
    public void push(int x) {
        if (top < maxSize - 1) {   // If stack isn't full
            stack[++top] = x;      // Increment top and add element
        }
    }
    
    public int pop() {
        if (top == -1) return -1;           // If stack is empty
        return stack[top--];       // Return the top element and decrement top
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, top + 1); i++) { //// Increment up to k elements or the size of the stack
            stack[i] += val;       // Increment each of the bottom k elements
        }
    }
}
