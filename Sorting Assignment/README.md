# Sorting Assignment

Six classic sorting algorithms in Java, built as part of the **Algorithms and Data Structures (Algodat)** course. This assignment focuses on **sorting**: bubble, selection, insertion, shell, merge, and quick sort are each written by hand as a small utility class, and `Main` is a plain demo driver that runs all six on the same input so the results can be compared side by side.

Every algorithm sorts **in place** on the caller's array and provides one overload per primitive type (`int`, `long`, `double`, `float`), so no boxing is needed and the same class works for integer and decimal data.

## Project Structure

| File | Role |
|------|------|
| `BubbleSort.java` | Adjacent-swap sort with an early-exit flag when a pass makes no swap. |
| `SelectionSort.java` | Repeatedly selects the smallest remaining element and moves it to the front. |
| `InsertionSort.java` | Grows a sorted prefix by shifting each new element into place. |
| `ShellSort.java` | Insertion sort over shrinking gaps, starting at `n / 2`. |
| `MergeSort.java` | Divide-and-conquer sort that splits, sorts each half, then merges. |
| `QuickSort.java` | Divide-and-conquer sort with Lomuto partitioning around the last element. |
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
Array kosong : []
Satu elemen  : [7]
Array null   : tidak error
```

## Class Details

### `BubbleSort.java`

Compares neighbouring pairs and swaps them when out of order, so after each pass the largest remaining element has "bubbled" to the end.

- **Methods** — `sort(int[])`, `sort(long[])`, `sort(double[])`, `sort(float[])`.
- **`sort(...)`** — for each pass `0 .. n-2`, scans the unsorted part (`i < n - 1 - pass`, since the tail is already final) and swaps `array[i]` with `array[i + 1]` when they are out of order.
- **Early exit** — a `boolean swapped` flag is reset at the start of each pass; if a pass performs no swap the array is already sorted and the method returns immediately. This makes the best case (already sorted input) a single O(n) pass.

### `SelectionSort.java`

Selects the minimum of the unsorted suffix and puts it at the boundary of the sorted prefix.

- **Methods** — `sort(int[])`, `sort(float[])`, `sort(double[])`, `sort(long[])`.
- **`sort(...)`** — for each position `i`, scans `j = i + 1 .. n-1` to find `minIndex`, then swaps `array[i]` with `array[minIndex]`.
- **Conditional swap** — the swap only runs when `minIndex != i`, so an element already in place is not swapped with itself.
- **Constant swaps** — at most one swap per position, which is why selection sort is preferred when writes are expensive, even though it always performs O(n²) comparisons.

### `InsertionSort.java`

Keeps a sorted prefix and inserts each new element into it, like sorting a hand of cards.

- **Methods** — `sort(int[])`, `sort(long[])`, `sort(float[])`, `sort(double[])`.
- **`sort(...)`** — stores `array[i]` in `key`, then walks backwards with `j` while `array[j] > key`, shifting each larger element one slot to the right; `key` is finally written to `array[j + 1]`.
- **Shifting instead of swapping** — elements move once per step rather than three times per swap, so it is efficient on nearly sorted data.
- **Best case** — if the input is already sorted the inner `while` never runs, giving O(n) time.

### `ShellSort.java`

A generalised insertion sort: instead of comparing neighbours, it compares elements `gap` apart, then halves the gap until it reaches `1`.

- **Methods** — `sort(int[])`, `sort(long[])`, `sort(float[])`, `sort(double[])`.
- **`sort(...)`** — outer loop `for (gap = n / 2; gap > 0; gap /= 2)`; for each gap it runs a gapped insertion sort (`j -= gap` instead of `j--`, writing to `array[j + gap]`).
- **Why gaps help** — early passes move elements long distances cheaply, so by the time `gap == 1` the array is almost sorted and the final insertion pass does very little work.
- **Gap sequence** — the simple `n / 2` halving sequence is used here; it is the version from the lecture, not the optimal sequence.

### `MergeSort.java`

Divide-and-conquer: split the array in half, sort both halves recursively, then merge the two sorted halves back into the original array.

- **Methods** — `sort(int[])`, `sort(long[])`, `sort(float[])`, `sort(double[])`, plus one package-private `merge(...)` helper per type.
- **`sort(...)`** — computes `mid = n / 2`, copies the two halves into new `left` and `right` arrays, recurses on each, then calls `merge`.
- **`merge(...)`** — three indexes (`i` for left, `j` for right, `k` for the output) pick the smaller head element each round (`<=` keeps equal elements in their original order, so the sort is **stable**), then copies any remainder.
- **Stability and predictability** — O(n log n) in the best, average, and worst case, at the cost of O(n) extra memory per merge level.

### `QuickSort.java`

Divide-and-conquer with in-place partitioning: choose a pivot, move smaller elements to its left, then recurse on both sides.

- **Methods** — `sort(int[] / long[] / float[] / double[])`, an overload `sort(array, low, high)`, and `partition(array, low, high)` that returns the pivot index.
- **`partition(...)`** — **Lomuto scheme** with the pivot taken from `array[high]`: `i` marks the boundary of the "smaller than pivot" region, and every `array[j] < pivot` is swapped up to `i` and `i` advances. The pivot is finally swapped to `i`, which is returned.
- **`sort(array, low, high)`** — uses a `while (low < high)` loop instead of plain double recursion:
  - recurses into the **smaller** side first, then continues the loop on the larger side. The larger side needs no stack frame, so the recursion depth stays at O(log n) even for adversarial input.
- **Complexity** — O(n log n) average, O(n²) worst case (already sorted input with a last-element pivot), O(log n) extra space, and **not stable**.

### `Main.java`

A plain demo driver (no `Scanner` or menu).

- `main(String[] args)` — runs the same six algorithms over four different `int[]` inputs:
  1. **Acak** — `{5, 2, 9, 1, 5, 6}` (random order, contains duplicates).
  2. **Terbalik** — `{5, 4, 3, 2, 1}` (reverse order, the worst case for bubble/insertion).
  3. **Sudah urut** — `{1, 2, 3, 4, 5}` (best case, shows the early exit).
  4. **Negatif** — `{-3, 0, -10, 7, -3}` (negative numbers and duplicates).
- **Other primitive types** — a `long[]` through `InsertionSort`, a `double[]` through `MergeSort`, and a `float[]` through `ShellSort`, to show the overloads work beyond `int`.
- **Edge cases** — an empty array, a single-element array, and a `null` array are passed through all six algorithms; nothing is printed per algorithm because none of them throw.
- `runAll(int[])` — **clones** the input before each call (`data.clone()`), so every algorithm receives the original unsorted data instead of the result of the previous one.

## Notes on Approach

- **One class per algorithm** — each algorithm is a small utility class with only `static` methods, so it can be called as `BubbleSort.sort(array)` without creating an object. The class name says exactly what it does, which keeps `Main` readable.
- **Primitive overloads instead of generics** — `int`, `long`, `float`, and `double` each get their own `sort`, because Java generics cannot hold primitives. The cost is repetition, but it avoids boxing and works with plain arrays.
- **In place, `void` return** — the array is modified directly; nothing is returned, so a caller must keep the reference it passed in.
- **Guard clause everywhere** — every `sort` starts with `if (array == null || array.length < 2) return;`. Empty, single-element, and `null` inputs are no-ops, so callers do not need their own checks.
- **Complexity gap** — the simple algorithms (bubble, selection, insertion, shell) are O(n²) in the worst case; merge and quick reach O(n log n) average and are the ones to prefer for large data.
- **Stability** — insertion, bubble, and merge keep equal elements in their original order (`<=` in `merge`); selection and quick may reorder them.
- **Comparison demo** — running all six algorithms on the same input in `Main` shows that the correct output is identical; the real difference is how much work each one does to get there.

## Complexity Summary

| Algorithm | Best | Average | Worst | Extra space | Stable |
|-----------|------|---------|-------|-------------|--------|
| Bubble sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Shell sort | O(n log n) | depends on gap sequence | O(n²) | O(1) | No |
| Merge sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
