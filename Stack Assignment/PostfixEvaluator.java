public final class PostfixEvaluator {

    private PostfixEvaluator() {
    }

    public static double evaluate(String postfix) {
        Stack<Double> operands = new Stack<>();
        String[] tokens = postfix.trim().split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            if (isNumber(token)) {
                operands.push(Double.parseDouble(token));
            } else if (token.length() == 1 && InfixToPostfix.precedence(token.charAt(0)) > 0) {
                if (operands.size() < 2) {
                    throw new IllegalArgumentException(
                            "Operator '" + token + "' has too few operands");
                }
                double right = operands.pop();
                double left = operands.pop();
                operands.push(apply(token.charAt(0), left, right));
            } else {
                throw new IllegalArgumentException("Invalid token \"" + token + "\"");
            }
        }

        if (operands.size() != 1) {
            throw new IllegalArgumentException(
                    "Malformed expression: " + operands.size() + " values left on the stack");
        }
        return operands.pop();
    }

    static double apply(char operator, double left, double right) {
        return switch (operator) {
            case '+' -> left + right;
            case '-' -> left - right;
            case '*' -> left * right;
            case '/' -> {
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                yield left / right;
            }
            case '^' -> Math.pow(left, right);
            default -> throw new IllegalArgumentException("Unknown operator '" + operator + "'");
        };
    }

    private static boolean isNumber(String token) {
        if (token.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
