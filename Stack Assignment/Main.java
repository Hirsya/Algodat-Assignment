public final class Main {

    public static void main(String[] args) {
        if (args.length >= 2 && args[0].equals("-e")) {
            runOnce(args[1]);
            return;
        }
        runAllDemos();
    }

    private static void runAllDemos() {
        partZeroStackSample();
        partOneParenthesis();
        partTwoInfixToPostfix();
        partThreePostfixEvaluation();
    }

    private static void partZeroStackSample() {
        title("PART 0 - STACK SAMPLE CODE");

        Stack<String> stack = new Stack<>();
        System.out.println("new Stack()              -> " + stack + "  isEmpty=" + stack.isEmpty());

        stack.push("Electrical");
        System.out.println("push(\"Electrical\")       -> " + stack);

        stack.push("Engineering");
        System.out.println("push(\"Engineering\")      -> " + stack);

        stack.push("Department");
        System.out.println("push(\"Department\")       -> " + stack);

        String str = stack.top();
        System.out.println("top()                    -> \"" + str + "\"");

        stack.pop();
        System.out.println("pop()                    -> " + stack);

        System.out.println("top()                    -> \"" + stack.top() + "\"");
        System.out.println("size()                   -> " + stack.size());
    }

    private static void partOneParenthesis() {
        title("PART 1 - PARENTHESIS MATCHING");

        String[] expressions = {
                "{x+(y-[a+b])}",
                "(a+b)*[c-{d/e}]",
                "((a+b)",
                "a+b)",
                "[(])",
                "{a+[b*(c-d)]}",
                ""
        };

        for (String expr : expressions) {
            String error = ParenthesisChecker.firstError(expr);
            System.out.printf("%-20s -> %-9s %s%n",
                    "\"" + expr + "\"",
                    ParenthesisChecker.isBalanced(expr) ? "BALANCED" : "INVALID",
                    error == null ? "" : "(" + error + ")");
        }
    }

    private static void partTwoInfixToPostfix() {
        title("PART 2 - INFIX TO POSTFIX");

        String[] expressions = {
                "6-(2+3)*3",
                "6+2/3*3",
                "6+2/3^3",
                "(a+b)*(c-d)/e"
        };

        for (String expr : expressions) {
            System.out.println("Expression: " + expr);
            System.out.print(InfixToPostfix.convertWithTrace(expr));
            System.out.println("Result     : " + InfixToPostfix.convert(expr));
            System.out.println();
        }
    }

    private static void partThreePostfixEvaluation() {
        title("PART 3 - POSTFIX EVALUATION");

        String[] expressions = {
                "6 2 3 + - 3 8 2 / + *",
                "6 2 3 + 3 * -",
                "6 2 3 3 ^ / +",
                "5 1 2 + 4 * + 3 -"
        };

        for (String expr : expressions) {
            double value = PostfixEvaluator.evaluate(expr);
            System.out.printf("%-28s = %s%n", expr, format(value));
        }

        title("ERROR HANDLING");
        reportError("Invalid infix", () -> InfixToPostfix.convert("6-(2+3"));
        reportError("Invalid postfix", () -> PostfixEvaluator.evaluate("6 2 + -"));
        reportError("Division by zero", () -> PostfixEvaluator.evaluate("5 0 /"));
    }

    private static void reportError(String label, Runnable action) {
        try {
            action.run();
            System.out.println(label + ": no error (unexpected)");
        } catch (RuntimeException e) {
            System.out.println(label + ": " + e.getMessage());
        }
    }

    private static void runOnce(String infix) {
        String postfix = InfixToPostfix.convert(infix);
        System.out.println("Infix  : " + infix);
        System.out.print(InfixToPostfix.convertWithTrace(infix));
        System.out.println("Postfix: " + postfix);
        System.out.println("Value  : " + format(PostfixEvaluator.evaluate(postfix)));
    }

    private static String format(double value) {
        return value == Math.rint(value) && !Double.isInfinite(value)
                ? String.valueOf((long) value)
                : String.valueOf(value);
    }

    private static void title(String text) {
        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println(" " + text);
        System.out.println("=".repeat(60));
        System.out.println();
    }
}
