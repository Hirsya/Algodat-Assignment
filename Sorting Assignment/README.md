# Sorting Assignment

Six classic sorting algorithms in Java, built as part of the **Algorithms and Data Structures (Algodat)** course. This assignment focuses on **sorting**: bubble, selection, insertion, shell, merge, and quick sort are each written by hand as a small utility class, and `Main` is a plain demo driver that runs all six on the same input so the results can be compared side by side.

Every algorithm sorts a **doubly linked list**, not an array. The list is mutated in place by moving values between nodes, and each `sort` returns the head of the sorted list. There is one node class per primitive type (`IntNode`, `LongNode`, `FloatNode`, `DoubleNode`), so no boxing is needed and the same algorithm works for integer and decimal data.

## Project Structure

| File | Role |
|------|------|
| `IntNode.java` | Node holding an `int`, with `prev` and `next` links. |
| `LongNode.java` | Node holding a `long`, with `prev` and `next` links. |
| `FloatNode.java` | Node holding a `float`, with `prev` and `next` links. |
| `DoubleNode.java` | Node holding a `double`, with `prev` and `next` links. |
| `BubbleSort.java` | Adjacent-swap sort with an early-exit flag when a pass makes no swap. |
| `SelectionSort.java` | Repeatedly selects the smallest remaining node and swaps it to the front. |
| `InsertionSort.java` | Grows a sorted prefix by walking backwards with `prev` and shifting values into place. |
| `ShellSort.java` | Insertion sort over shrinking gaps, starting at `n / 2`. |
| `MergeSort.java` | Divide-and-conquer sort that splits the list, sorts each half, then merges by relinking. |
| `QuickSort.java` | Divide-and-conquer sort with Lomuto partitioning around the last node. |
| `Main.java` | Demo driver: sorts random, reversed, already-sorted, and negative data, plus edge cases. |

All files use the default package, so they can be compiled and run directly from this folder.

## How to Run

```bash
javac *.java
java Main
```

Expected output (abridged):

```text
Acak         : [5, 2, 9, 1, 5, 6]
  Bubble     : [1, 2, 5, 5, 6, 9]
  Selection  : [1, 2, 5, 5, 6, 9]
  Insertion  : [1, 2, 5, 5, 6, 9]
  Shell      : [1, 2, 5, 5, 6, 9]
  Merge      : [1, 2, 5, 5, 6, 9]
  Quick      : [1, 2, 5, 5, 6, 9]

Terbalik     : [5, 4, 3, 2, 1]
  Bubble     : [1, 2, 3, 4, 5]
  ...

Sudah urut   : [1, 2, 3, 4, 5]
  Bubble     : [1, 2, 3, 4, 5]
  ...

Negatif      : [-3, 0, -10, 7, -3]
  Bubble     : [-10, -3, -3, 0, 7]
  ...

== Tipe primitif lain ==
Long awal    : [5000000000, 12, 750]
Insertion    : [12, 750, 5000000000]
Double awal  : [3.5, 1.2, 9.9, 2.0]
Merge        : [1.2, 2.0, 3.5, 9.9]
Float awal   : [2.5, 0.5, 4.0]
Shell        : [0.5, 2.5, 4.0]

== Kasus tepi ==
List kosong  : []
  Bubble     : []
  ...
Satu elemen  : [7]
  Bubble     : [7]
  ...
List null    : tidak error
```

## Why a Doubly Linked List

- **No random access needed by the divide-and-conquer algorithms** — merge sort only splits and joins, and quick sort can walk forward from `first` to `last` while keeping node references instead of indexes.
- **Shell sort needs backward movement.** The array version walks with `j -= gap`, which a singly linked list cannot do without restarting from the head. Keeping `prev` on every node makes the translation direct.
- **Insertion sort becomes a literal translation** of the array version: `array[j] > key` turns into `j.data > key` with `j = j.prev`.
- **Merge sort gets cheaper.** The array version allocates `left` and `right` arrays at every level; the linked list version only relinks nodes, so the extra space drops from O(n) to O(1) besides the recursion stack.
- **Node classes stay primitive.** Java generics cannot hold primitives, so one node class per type keeps the same "no boxing" rule the array version followed.

## Class Details

### Node classes (`IntNode.java`, `LongNode.java`, `FloatNode.java`, `DoubleNode.java`)

Plain data holders with three package-private fields: `data`, `prev`, and `next`. There are no getters or setters, because every algorithm and `Main` live in the same default package and need direct field access for speed and clarity. The constructor only stores the value; links start as `null`.

### `BubbleSort.java`

Compares neighbouring nodes and swaps their values when they are out of order, so after each pass the largest remaining value has "bubbled" to the end of the list.

- **Methods** — `sort(IntNode)`, `sort(LongNode)`, `sort(FloatNode)`, `sort(DoubleNode)`.
- **`sort(...)`** — `end` marks the first node that is already final (initially `null`, meaning "the end of the list"). Each pass walks `cur` from the head while `cur.next != end`, swapping values when `cur.data > cur.next.data`, then sets `end = cur` so the next pass stops one node earlier.
- **Early exit** — `boolean swapped` is reset at the start of each pass; a pass with no swap means the list is already sorted, so the method returns.
- **Swaps values, not links** — only `data` is exchanged, so `prev`, `next`, and node identity never change and the head can never be lost.
- **Complexity** — O(n) best case (already sorted), O(n²) average and worst, O(1) extra space, **stable**.

### `SelectionSort.java`

Selects the minimum of the unsorted suffix and swaps it to the boundary of the sorted prefix.

- **Methods** — `sort(IntNode)`, `sort(LongNode)`, `sort(FloatNode)`, `sort(DoubleNode)`.
- **`sort(...)`** — for each node `i`, scans the rest of the list with `j` to find the node `min` holding the smallest value, then swaps `i.data` with `min.data`.
- **Conditional swap** — the swap is skipped when `min == i`, so a node already in place is not swapped with itself.
- **Few writes** — at most one swap per position, which is why selection sort is preferred when writes are expensive, even though it always performs O(n²) comparisons.
- **Complexity** — O(n²) in every case, O(1) extra space, **not stable** (a value can jump over an equal value).

### `InsertionSort.java`

Keeps a sorted prefix and inserts each new value into it, like sorting a hand of cards.

- **Methods** — `sort(IntNode)`, `sort(LongNode)`, `sort(FloatNode)`, `sort(DoubleNode)`.
- **`sort(...)`** — stores `cur.data` in `key`, then walks backwards with `j = cur.prev` while `j.data > key`, copying each larger value one node to the right (`j.next.data = j.data`). When `j` falls off the front of the list, `key` belongs in `head.data`; otherwise it is written to `j.next.data`.
- **Shifting instead of swapping** — values move once per step rather than three times per swap, so it is efficient on nearly sorted data.
- **This is the algorithm that needs `prev`** — the backward walk is exactly `j--` from the array version, and it would be O(n) per step on a singly linked list.
- **Complexity** — O(n) best case (already sorted), O(n²) average and worst, O(1) extra space, **stable**.

### `ShellSort.java`

A generalised insertion sort: instead of comparing neighbours, it compares values `gap` nodes apart, then halves the gap until it reaches `1`.

- **Methods** — `sort(IntNode)`, `sort(LongNode)`, `sort(FloatNode)`, `sort(DoubleNode)`, plus three helpers per type: `size(...)`, `stepForward(...)`, and `stepBack(...)`.
- **`sort(...)`** — `size` counts the nodes once. For each `gap` (`n / 2` down to `1`), `cur` starts `gap` nodes in (`stepForward(head, gap)`) and a companion pair `write` / `j` performs the gapped insertion: `j` starts `gap` nodes behind `cur` and keeps stepping back until a smaller value is found, copying values forward by `gap` each time.
- **Why the gap helps** — early passes move values long distances cheaply, so by the time `gap == 1` the list is almost sorted and the final insertion pass does very little work.
- **Gap sequence** — the simple `n / 2` halving sequence is used here; it is the version from the lecture, not the optimal sequence.
- **Complexity** — O(n log n) best case, O(n²) worst case with this gap sequence, O(1) extra space, **not stable**.

### `MergeSort.java`

Divide-and-conquer: split the list in half, sort both halves recursively, then merge the two sorted halves by relinking nodes.

- **Methods** — `sort(IntNode)`, `sort(LongNode)`, `sort(FloatNode)`, `sort(DoubleNode)`, plus one package-private `split(...)` and one `merge(...)` helper per type.
- **`sort(...)`** — calls `split`, recurses on both halves, and returns `merge(left, right)`.
- **`split(...)`** — slow/fast pointers (`fast = head.next`) stop `slow` on the last node of the left half; the list is cut with `slow.next = null` and the right half gets `prev = null`.
- **`merge(...)`** — a dummy node plus a `tail` pointer picks the smaller head each round (`<=` keeps equal values in their original order, so the sort is **stable**). Every splice also fixes `prev`, the remaining run is attached in one step, and the final head gets `prev = null` so the result is a valid doubly linked list.
- **No auxiliary arrays** — unlike the array version there is no `left` / `right` copy at each level, so the extra space is O(1) (plus O(log n) stack frames).
- **Complexity** — O(n log n) in the best, average, and worst case, **stable**.

### `QuickSort.java`

Divide-and-conquer with in-place partitioning: choose a pivot, move smaller values to its left, then sort both sides.

- **Methods** — `sort(IntNode / LongNode / FloatNode / DoubleNode)`, an overload `sort(first, last)` that sorts an inclusive segment, `partition(first, last)` that returns the pivot node, and `last(head)` that finds the final node.
- **`partition(...)`** — **Lomuto scheme** with the pivot taken from the last node: `i` is the node marking the boundary of the "smaller than pivot" region, and every `j` with `j.data < pivot` is swapped up to `i` before `i` advances. The pivot value is finally swapped into `i`, which is returned. Both pointers only move forward, so no backward scan is needed here.
- **`sort(first, last)`** — uses a `while` loop instead of plain double recursion. After partitioning it measures both sides (forward from `first`, backward from `last` using `prev`), recurses into the **smaller** side, and continues the loop on the larger side, so the stack depth stays at O(log n) even for adversarial input.
- **Empty-segment guard** — the loop stops when `first == last`, when either reference is `null`, or when `first.prev == last` (the segment is empty).
- **Complexity** — O(n log n) average, O(n²) worst case (already sorted input with a last-node pivot), O(log n) extra space, and **not stable**.

### `Main.java`

A plain demo driver (no `Scanner` or menu).

- `main(String[] args)` — runs the same six algorithms over four different `int` inputs:
  1. **Acak** — `{5, 2, 9, 1, 5, 6}` (random order, contains duplicates).
  2. **Terbalik** — `{5, 4, 3, 2, 1}` (reverse order, the worst case for bubble/insertion).
  3. **Sudah urut** — `{1, 2, 3, 4, 5}` (best case, shows the early exit).
  4. **Negatif** — `{-3, 0, -10, 7, -3}` (negative numbers and duplicates).
- **Other primitive types** — a `long[]` through `InsertionSort`, a `double[]` through `MergeSort`, and a `float[]` through `ShellSort`, to show the node classes work beyond `int`.
- **Edge cases** — an empty list, a single-node list, and a `null` list are passed through all six algorithms; nothing is printed per algorithm for the `null` case because none of them throw.
- **`toList(...)`** — four overloads build a doubly linked list from an array literal, wiring `prev` as well as `next`. This replaces `clone()` from the array version: every algorithm receives a fresh, unsorted list.
- **`listToString(...)`** — four overloads walk the list with a `StringBuilder` and produce the same `[1, 2, 3]` format `Arrays.toString` used to give.
- **`(IntNode) null`** — the cast is required because each class has four `sort` overloads (one per node type), so a bare `null` would be ambiguous.

## Notes on Approach

- **One class per algorithm** — each algorithm is a small utility class with only `static` methods, so it can be called as `BubbleSort.sort(list)` without creating an object. The class name says exactly what it does, which keeps `Main` readable.
- **Node classes instead of generics** — `int`, `long`, `float`, and `double` each get their own node type and their own `sort`, because Java generics cannot hold primitives. The cost is repetition, but it avoids boxing, exactly like the primitive overloads of the array version.
- **Return the head** — every `sort` returns a node reference and callers must reassign: `head = MergeSort.sort(head);`. Merge sort can genuinely change the head; the other five only swap values and return the same reference.
- **Guard clause everywhere** — every `sort` starts with `if (head == null || head.next == null) return head;`. Empty, single-node, and `null` inputs are no-ops, so callers do not need their own checks.
- **Values move, links survive** — bubble, selection, insertion, shell, and quick only exchange `data`, so links stay valid and no node is ever lost. Merge sort is the exception: it relinks nodes deliberately and repairs `prev` while doing so.
- **Complexity gap** — the simple algorithms (bubble, selection, insertion, shell) are O(n²) in the worst case; merge and quick reach O(n log n) average and are the ones to prefer for large data.
- **Stability** — insertion, bubble, and merge keep equal values in their original order (`<=` in `merge`); selection, shell, and quick may reorder them.
- **Comparison demo** — running all six algorithms on the same input in `Main` shows that the correct output is identical; the real difference is how much work each one does to get there.

## Complexity Summary

| Algorithm | Best | Average | Worst | Extra space | Stable |
|-----------|------|---------|-------|-------------|--------|
| Bubble sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Shell sort | O(n log n) | depends on gap sequence | O(n²) | O(1) | No |
| Merge sort | O(n log n) | O(n log n) | O(n log n) | O(1) + O(log n) stack | Yes |
| Quick sort | O(n log n) | O(n log n) | O(n²) | O(log n) stack | No |

## Testing Notes

The six algorithms were checked against `Arrays.sort` as the reference for every primitive type, with list sizes from 0 to 40 and hundreds of random inputs, plus 2000-element lists that were random, already sorted, and reversed. Each result was verified for three things: the values match the reference, the node count is unchanged, and the `prev` chain is intact (`head.prev == null` and `cur.prev.next == cur`).
