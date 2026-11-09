# Queue Assignment

A generic queue implementation in Java, built as part of the **Algorithms and Data Structures (Algodat)** course. This assignment focuses on the **Queue** data structure (FIFO): a hand-written `HirsyaQueue<T>` container backed by a singly linked list, with `front`/`end` pointers so enqueue and dequeue are both O(1). `Main` is a plain demo driver that exercises every operation and prints the result.

## Project Structure

| File | Role |
|------|------|
| `HirsyaQueue.java` | Generic FIFO container backed by a singly linked list (`add`, `remove`, `getFront`, `isEmpty`, `size`, `clear`). |
| `Main.java` | Demo driver: enqueues, reads the front, dequeues, clears, and refills the queue with `String` values. |

Both files use the default package, so they can be compiled and run directly from this folder.

## How to Run

```bash
javac *.java
java Main
```

Expected output:

```text
Isi queue : [A, B, C]
Size      : 3
Front     : A
Empty     : false
Remove    : A
Remove    : B
Front     : C
Sisa      : [C]
Setelah clear: size=0 empty=true
Tambah lagi  : [X] size=1
Kosong       : size=0 empty=true
```

## Class Details

### `HirsyaQueue.java`

A generic queue, typed by `T`, so the same class can hold any object (`Main` uses `HirsyaQueue<String>`).

- **Nested class** `private static class Node<T>` — one element (`value`) plus a `next` link. `value` is `final`, so a node's payload never changes after creation; the queue only moves its pointers. `private` so the internal representation is not exposed.
- **Variables**
  - `private Node<T> front` — the element at the head of the queue (the next one to be removed); `null` when empty.
  - `private Node<T> end` — the last element; new nodes are linked here, so `add` does not need to walk the list.
  - `private int size` — number of elements, kept up to date so `size()` is O(1).
- **Constructor** `HirsyaQueue()` — starts empty (`front = null`, `end = null`, `size = 0`).
- **Methods**
  - `add(T obj)` — creates a new node and appends it: when the queue is empty it also becomes `front`, otherwise it is linked after `end`. `end` is then moved to the new node (O(1)).
  - `remove()` — returns the value at `front` and advances `front` to `front.next` (O(1)). If that empties the queue, `end` is reset to `null` so the two pointers stay consistent. On an empty queue it prints `Queue is empty` and returns `null` instead of throwing a `NullPointerException`.
  - `getFront()` — returns the value at `front` without removing it; prints `Queue is empty` and returns `null` when empty.
  - `isEmpty()` — `size == 0`.
  - `size()` — returns the stored counter.
  - `clear()` — drops the whole chain by clearing both pointers and resets `size` to `0`. The old nodes become unreachable and are collected by the garbage collector.
  - `toString()` (override) — prints `[a, b, c]` in queue order (front first), traversing the list once from `front`.

### `Main.java`

A plain demo driver (no interactive menu).

- `main(String[] args)` — uses a `HirsyaQueue<String>`:
  1. Enqueues `"A"`, `"B"`, `"C"`, then prints the contents, `size()`, `getFront()`, and `isEmpty()`.
  2. Calls `remove()` twice, prints the new `front`, and shows the remaining queue.
  3. Calls `clear()` and confirms the queue is empty.
  4. Enqueues `"X"` again to show the queue is reusable after `clear`, then removes it and confirms it is empty.

## Notes on Approach

- **FIFO with two pointers**: keeping both `front` and `end` is what makes a linked-list queue efficient — `add` never has to traverse to the tail, and `remove` never has to shift elements. Both operations are O(1).
- **Consistent pointers**: whenever the last element is removed, `end` is reset to `null`; otherwise the next `add` would link onto a stale node.
- **Generics**: the class is written once as `HirsyaQueue<T>` and can be reused for any type, not just `String`.
- **Name prefix**: the class is named `HirsyaQueue` (with the student's name prefix) to avoid clashing with `java.util.Queue`, following the same convention as the other assignments.
- **No silent crashes**: `remove()` and `getFront()` guard against an empty queue, so a mistaken call prints a message and returns `null` instead of throwing.
