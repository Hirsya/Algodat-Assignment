# Stack Assignment

A generic stack implementation in Java, built as part of the **Algorithms and Data Structures (Algodat)** course. This assignment focuses on the **Stack** data structure (LIFO): a hand-written `Stack<T>` container is reused across three classic stack applications — bracket matching, infix-to-postfix conversion, and postfix evaluation. `Main` is a plain demo driver that prints the result of every part and also supports a one-off CLI mode.

## Project Structure

| File | Role |
|------|------|
| `Stack.java` | Generic LIFO container backed by a singly linked list (`push`, `pop`, `top`, `isEmpty`, `size`, `clear`). |
| `ParenthesisChecker.java` | Uses a `Stack<Character>` to verify that `()`, `[]`, and `{}` are balanced, and reports the first error. |
| `InfixToPostfix.java` | Shunting-yard conversion of an infix expression to postfix, with an optional step-by-step trace table. |
| `PostfixEvaluator.java` | Evaluates a postfix expression with an operand stack and reports malformed input. |
| `Main.java` | Demo driver: runs all parts with sample input, or evaluates a single expression from the command line. |

All files use the default package, so they can be compiled and run directly from this folder.

## How to Run

Demo mode (runs every part with the built-in sample expressions):

```bash
javac *.java
java Main
```

Single-expression mode (converts one infix expression, prints the trace, and evaluates the result):

```bash
java Main -e "6-(2+3)*3"
```

Expected output of that command:

```text
Infix  : 6-(2+3)*3
No   Symbol   Postfix String           Stack
...
Postfix: 6 2 3 + 3 * -
Value  : -9
```

## Class Details

### `Stack.java`

A generic stack, typed by `T`, so the same class serves characters (parsing) and doubles (evaluation).

- **Nested class** `private static class Node<T>` — one element (`value`) plus a `next` link. Both fields are `final`, so a node is never mutated after creation; the stack only moves its `top` pointer. `private` so the internal representation is not exposed.
- **Variables**
  - `private Node<T> top` — the most recently pushed element; `null` when the stack is empty.
  - `private int size` — number of elements, kept up to date so `size()` is O(1).
- **Constructor** `Stack()` — starts empty (`top = null`, `size = 0`).
- **Methods**
  - `push(T obj)` — creates a new node that points to the old `top`, then makes it the new `top` (O(1)).
  - `pop()` — returns the top value and moves `top` to `top.next` (O(1)). Throws `IllegalStateException` on an empty stack instead of returning `null`, so errors surface immediately instead of silently propagating.
  - `top()` — returns the value on top without removing it; throws `IllegalStateException` when empty.
  - `isEmpty()` — `top == null`.
  - `size()` — returns the stored counter.
  - `clear()` — drops the whole chain by clearing `top` and resets `size` to `0`.
  - `toString()` (override) — prints `bottom [a, b, c] top`. The linked list is traversed top-to-bottom into a temporary list, then printed in reverse so the **bottom** element appears first — the order students are used to from the lecture slides.

### `ParenthesisChecker.java`

Utility class for balanced-bracket checking (all methods static, constructor private so it is never instantiated).

- **Methods**
  - `isBalanced(String)` — convenience wrapper; returns `true` when `firstError` returns `null`.
  - `firstError(String)` — scans the expression once:
    1. An opening bracket `(`, `[`, `{` is pushed.
    2. A closing bracket with an empty stack is "unexpected" and reported with its index.
    3. Otherwise the top is popped; if it is not the matching opening bracket, a mismatch is reported.
    4. After the scan, a non-empty stack means opening brackets were left unclosed; the message includes the leftover count.

  Returning a descriptive `String` (instead of only a boolean) makes the reason for failure visible — useful for the lecture-style output table.
- **Private helpers** `isOpening`, `isClosing`, `matches` — keep the bracket pairs defined in exactly one place.

### `InfixToPostfix.java`

Utility class implementing the **shunting-yard** algorithm (all methods static).

- **`convert(String infix)`** — the main conversion:
  - Whitespace is skipped.
  - A run of digits and dots is gathered into one numeric token, so multi-digit and decimal operands are kept intact.
  - A letter is copied straight to the output as an operand.
  - `(` is pushed; `)` pops operators to the output until `(` is reached, then discards the `(`. An unmatched `)` or `(` throws `IllegalArgumentException`.
  - An operator pops every stacked operator with greater precedence (or equal precedence, except `^`) before being pushed.
  - Any other character is rejected with its index.
  - Finally the remaining operators are drained from the stack.
  - Tokens are joined with single spaces.
- **`convertWithTrace(String infix)`** — same algorithm, but prints a table of `No | Symbol | Postfix String | Stack` after every symbol (and after each operator drained at the end). This is the textbook hand-calculation table, generated by the program.
- **`precedence(char)`** — `^` = 3, `*` `/` = 2, `+` `-` = 1, anything else = 0 (also used as the "is this an operator" test).
- **`shouldPop(char onStack, char incoming)`** — pops when the stacked operator has higher precedence, or equal precedence except for `^`. The exception makes `^` **right-associative**, as in standard mathematics.
- **Private helpers** — `isOperator`, `isOperand`, `appendToken` (handles the separating space), `operatorsToText` (renders the stack inside `[...]` as a compact space-separated string for the trace column).

### `PostfixEvaluator.java`

Utility class that evaluates a space-separated postfix expression.

- **`evaluate(String postfix)`**
  - Splits the input on whitespace.
  - A numeric token is pushed as a `Double`.
  - A single-character operator pops `right` then `left` (**order matters** for `-`, `/`, and `^`), applies the operator, and pushes the result.
  - An operator with fewer than two operands left, an unknown token, or a stack that does not end with exactly one value throws `IllegalArgumentException`.
- **`apply(char, left, right)`** — supports `+ - * / ^`. Division checks for a zero divisor and throws `ArithmeticException` instead of producing `Infinity`.
- **Private helper** `isNumber(String)` — validates a token with `Double.parseDouble` inside a `try/catch`.

### `Main.java`

A plain demo driver (no interactive menu).

- `main(String[] args)`
  - With `-e <expression>`, calls `runOnce` and exits.
  - Otherwise calls `runAllDemos`.
- `runAllDemos()` — runs the four parts in order.
- **Part 0 — Stack sample code** — reproduces the lecture sample: push `"Electrical"`, `"Engineering"`, `"Department"`, read `top()`, `pop()`, read `top()` again and print `size()`, showing the LIFO behaviour.
- **Part 1 — Parenthesis matching** — checks seven expressions: balanced ones, an unclosed bracket, an extra closing bracket, a mismatched pair (`[(])`), and the empty string (balanced).
- **Part 2 — Infix to postfix** — converts four expressions (`6-(2+3)*3`, `6+2/3*3`, `6+2/3^3`, `(a+b)*(c-d)/e`), printing the trace table followed by the final postfix string.
- **Part 3 — Postfix evaluation** — evaluates four postfix expressions, then demonstrates error handling for an unbalanced infix, an operator with too few operands, and division by zero.
- **Helpers**
  - `reportError(label, Runnable)` — runs a failing operation inside `try/catch` and prints only the exception message, keeping expected-error demos readable.
  - `runOnce(String infix)` — convert + trace + evaluate a single expression.
  - `format(double)` — prints whole results without a trailing `.0`.
  - `title(String)` — prints a `====` section banner.

## Sample Output

```text
PART 1 - PARENTHESIS MATCHING
"{x+(y-[a+b])}"      -> BALANCED
"((a+b)"             -> INVALID   (Unclosed opening bracket '(' (1 left open).)
"[(])"               -> INVALID   (Mismatch at index 2: '(' is closed by ']'.)

PART 3 - POSTFIX EVALUATION
6 2 3 + - 3 8 2 / + *        = 7
6 2 3 + 3 * -                = -9
5 1 2 + 4 * + 3 -            = 14

ERROR HANDLING
Invalid postfix: Operator '-' has too few operands
Division by zero: Division by zero
```

## Notes on Approach

- **Generics**: `Stack<T>` is written once and reused by all three applications (`Stack<Character>` for parsing, `Stack<Double>` for evaluation). The internal `Node<T>` is `private` so no outside code can touch the links.
- **Layered design**: `Stack` knows nothing about math; each application (`ParenthesisChecker`, `InfixToPostfix`, `PostfixEvaluator`) uses the stack as a black box. This mirrors how ADTs are meant to be used, and keeps each algorithm readable.
- **Fail fast**: `pop()` / `top()` on an empty stack, unbalanced brackets, unknown characters, too few operands, and division by zero all throw with a clear message rather than returning a wrong value.
- **Right-associative exponent**: `shouldPop` deliberately does **not** pop a stacked `^` when another `^` arrives, so `2^3^2` is read as `2^(3^2)`.
- **Operand order on pop**: an operator pops the right operand first, then the left, because a stack reverses the reading order.
- **Trace as output**: `convertWithTrace` produces the same table a student would draw by hand, which makes the conversion easy to verify step by step.
- **Single `main`**: all demos live in `Main`, and each part is its own private method, so one part can be re-run or extended without touching the others.
- Edge cases handled: empty expression, whitespace, multi-digit/decimal numbers, nested and mismatched brackets, extra closing brackets, unclosed opening brackets, malformed postfix, and division by zero.
