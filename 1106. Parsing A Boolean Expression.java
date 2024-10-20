class Solution {
    public boolean parseBoolExpr(String expression) {
        // Stack to store characters (expressions and intermediate results)
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ')') {
                Set<Character> seen = new HashSet<>();
                while (stack.peek() != '(') {
                    seen.add(stack.pop()); // Collect elements between '(' and ')'
                }
                stack.pop(); // Remove the '('

                // Get the operator preceding the '('
                char operator = stack.pop();
                if (operator == '&') {
                    stack.push(seen.contains('f') ? 'f' : 't');
                } else if (operator == '|') {
                    stack.push(seen.contains('t') ? 't' : 'f');
                } else if (operator == '!') {
                    stack.push(seen.contains('t') ? 'f' : 't');
                }
            } else if (ch != ',') {
                stack.push(ch);
            }
        }
        return stack.pop() == 't';
    }
}
