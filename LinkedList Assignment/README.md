# LinkedList Assignment

A singly linked list implementation in Java, built as part of the **Algorithms and Data Structures (Algodat)** course. The program provides an interactive command-line menu to add, search, count, and delete nodes.

## Project Structure

| File | Role |
|------|------|
| `Node.java` | Represents a single node (one data value + a link to the next node). |
| `LinkedList.java` | Manages the whole list: `head`, `tail`, and all list operations. |
| `Main.java` | Interactive CLI menu that lets the user run each operation. |

## How to Run

```bash
javac Node.java LinkedList.java Main.java
java Main
```

The program starts with three dummy nodes (`10`, `20`, `30`) so the list is not empty.

## Menu

```
 1. Insert node (append at the back)
 2. Insert at index
 3. Delete node
 4. Search node
 5. Display list
 6. Count node
 0. Exit
```

The screen is cleared on every menu change, and after each action the program waits for **Enter** so the result stays readable.

## Class Details

### `Node.java`
The building block of the list.

- **Variables**
  - `private int data` — the value stored in the node. Made `private` so it can only be read through `getData()` (encapsulation).
  - `Node nextNode` — reference to the next node; `null` if this is the last node.
- **Constructor** `Node(int dataInput)` — sets the node's data.
- **Methods**
  - `getData()` — returns the stored value.
  - `getNextNode()` / `setNextNode(Node)` — read/update the link to the next node.
  - `checkData()` — prints the node's data (used by `displayLinkedList`).

### `LinkedList.java`
Owns and coordinates the nodes.

- **Variables**
  - `Node head` — first node of the list.
  - `Node tail` — last node of the list, kept so appending is O(1) without traversing the whole list.
- **Methods**
  - `insertNode(Node)` — appends at the back. If the list is empty, both `head` and `tail` point to the new node; otherwise the new node is linked after `tail`, then `tail` moves.
  - `getHead()` — returns the first node.
  - `displayLinkedList()` — traverses from `head` using a temporary `current` pointer and prints every value; prints a message when the list is empty.
  - `searchLinkedList(int key)` — traverses the list and reports whether `key` exists.
  - `count()` — traverses and counts the nodes.
  - `insertAt(int index, Node)` — inserts at a specific position, handling three cases: front (`index == 0`), back (`index == count()`, reuse `insertNode`), and middle (walk to the node before the target, then relink). Out-of-range indexes are rejected.
  - `delete(int key)` — removes the node holding `key`, handling four cases: empty list, deleting `head`, deleting a middle/`tail` node (using `prev` and `current`), and value not found. Updates `tail` when the last node is removed.

### `Main.java`
The interactive front end.

- **Static fields**
  - `Scanner input` — reads user input.
  - `LinkedList list` — the single list operated on by the menu.
- **Methods**
  - `main` — preloads the dummy data, then loops over the menu until `0` is chosen.
  - `printMenu()` — prints the options.
  - `insertNodeMenu()`, `insertAtMenu()`, `deleteMenu()`, `searchMenu()` — read input and call the matching `LinkedList` method.
  - `clearScreen()` — clears the terminal using ANSI escape codes.
  - `pause()` — waits for Enter.
  - `readInt()` — safely reads an integer, retrying if the input is not a number.

## Notes on Approach

- A temporary `current` pointer is always used for traversal so `head` is never lost.
- Keeping a `tail` reference makes inserting at the back efficient.
- Pointer order during insertion matters: link the new node to the rest of the list **before** breaking the previous link.
- Edge cases (empty list, single-node list, insert/delete at head or tail, out-of-range index, duplicate/missing values) are handled explicitly.
