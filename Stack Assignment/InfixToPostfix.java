public final class InfixToPostfix {

    private InfixToPostfix() {
    }

    public static String convert(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        int i = 0;

        while (i < infix.length()) {
            char c = infix.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
            } else if (Character.isDigit(c) || c == '.') {
                while (i < infix.length()) {
                    char d = infix.charAt(i);
                    if (Character.isDigit(d) || d == '.') {
                        appendToken(output, String.valueOf(d));
                        i++;
                    } else {
                        break;
                    }
                }
            } else if (isOperand(c)) {
                appendToken(output, String.valueOf(c));
                i++;
            } else if (c == '(') {
                operators.push(c);
                i++;
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.top() != '(') {
                    appendToken(output, String.valueOf(operators.pop()));
                }
                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Unbalanced ')' at index " + i);
                }
                operators.pop();
                i++;
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && operators.top() != '('
                        && shouldPop(operators.top(), c)) {
                    appendToken(output, String.valueOf(operators.pop()));
                }
                operators.push(c);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported character '" + c + "' at index " + i);
            }
        }

        while (!operators.isEmpty()) {
            char op = operators.pop();
            if (op == '(') {
                throw new IllegalArgumentException("Unbalanced '(' in expression");
            }
            appendToken(output, String.valueOf(op));
        }

        return output.toString();
    }

    public static String convertWithTrace(String infix) {
        StringBuilder trace = new StringBuilder();
        StringBuilder output = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        int step = 1;

        trace.append(String.format("%-4s %-8s %-24s %s%n", "No", "Symbol", "Postfix String", "Stack"));
        trace.append("-".repeat(60)).append(System.lineSeparator());

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            }

            if (Character.isDigit(c) || isOperand(c)) {
                appendToken(output, String.valueOf(c));
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.top() != '(') {
                    appendToken(output, String.valueOf(operators.pop()));
                }
                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Unbalanced ')' at index " + i);
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && operators.top() != '(' && shouldPop(operators.top(), c)) {
                    appendToken(output, String.valueOf(operators.pop()));
                }
                operators.push(c);
            } else {
                throw new IllegalArgumentException("Unsupported character '" + c + "' at index " + i);
            }

            trace.append(String.format("%-4d %-8s %-24s %s%n",
                    step++, c, output, operatorsToText(operators)));
        }

        while (!operators.isEmpty()) {
            char op = operators.pop();
            if (op == '(') {
                throw new IllegalArgumentException("Unbalanced '(' in expression");
            }
            appendToken(output, String.valueOf(op));
            trace.append(String.format("%-4d %-8s %-24s %s%n",
                    step++, "", output, operatorsToText(operators)));
        }

        return trace.toString();
    }

    private static boolean shouldPop(char onStack, char incoming) {
        int stackPrec = precedence(onStack);
        int inPrec = precedence(incoming);
        if (stackPrec == inPrec) {
            return incoming != '^';
        }
        return stackPrec > inPrec;
    }

    public static int precedence(char operator) {
        return switch (operator) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }

    private static boolean isOperator(char c) {
        return precedence(c) > 0;
    }

    private static boolean isOperand(char c) {
        return Character.isLetter(c);
    }

    private static void appendToken(StringBuilder output, String token) {
        if (output.length() > 0) {
            output.append(' ');
        }
        output.append(token);
    }

    private static String operatorsToText(Stack<Character> operators) {
        String text = operators.toString();
        int start = text.indexOf('[');
        int end = text.indexOf(']');
        String inside = (start >= 0 && end > start) ? text.substring(start + 1, end) : "";
        return inside.replace(", ", " ");
    }
}
