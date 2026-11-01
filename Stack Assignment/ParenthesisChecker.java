public final class ParenthesisChecker {

    private ParenthesisChecker() {
    }

    public static boolean isBalanced(String expression) {
        return firstError(expression) == null;
    }

    public static String firstError(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (isOpening(c)) {
                stack.push(c);
            } else if (isClosing(c)) {
                if (stack.isEmpty()) {
                    return "Unexpected '" + c + "' at index " + i + ": no opening bracket to match.";
                }
                char open = stack.pop();
                if (!matches(open, c)) {
                    return "Mismatch at index " + i + ": '" + open + "' is closed by '" + c + "'.";
                }
            }
        }

        if (!stack.isEmpty()) {
            return "Unclosed opening bracket '" + stack.top() + "' (" + stack.size() + " left open).";
        }
        return null;
    }

    private static boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}
