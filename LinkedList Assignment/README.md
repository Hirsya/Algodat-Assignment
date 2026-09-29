# LinkedList Assignment

A singly linked list implementation in Java, built as part of the **Algorithms and Data Structures (Algodat)** course. This version focuses on applying an **Abstract Data Type (ADT)**: an abstract `LinkedList` container stores any `Entity`, with `Car` and `Driver` as concrete data types. `Main` is a plain test driver (no interactive menu).

## Project Structure

| File | Role |
|------|------|
| `Entity.java` | Abstract base class for all data stored in the list (holds `name`, provides `equals` and `toString`). |
| `Car.java` | `Entity` subclass representing a car (`topSpeed`, `weight`). |
| `Driver.java` | `Entity` subclass representing a driver (`wdc`, `active`). |
| `Node.java` | A single node (one `Entity` + a link to the next node). |
| `LinkedList.java` | Abstract list container: `head`, `tail`, and all list operations. |
| `Main.java` | Simple test program that exercises every list operation. |

## How to Run

```bash
javac *.java
java Main
```

## Class Details

### `Entity.java`
Abstract base class for the stored data (the ADT's element type).

- **Variable**
  - `private String name` — common field for every entity; `private` so it can only be read through `getName()` (encapsulation).
- **Constructor** `Entity(String name)` — sets the name. Because there is no no-argument constructor, subclasses must call `super(name)`.
- **Methods**
  - `getName()` — returns the name.
  - `toString()` (override) — returns `name`; called implicitly when `Node.checkData()` prints the data.
  - `equals(Object)` (override) — compares `getClass()` and `name`, so search/delete work with a freshly created object and a `Car` never equals a `Driver`.

### `Car.java`
An `Entity` subclass.

- **Variables** — `private int topSpeed`, `private int weight`.
- **Constructors**
  - `Car(String name)` — convenience constructor, defaults top speed and weight to `0`.
  - `Car(String name, int topSpeed, int weight)` — full constructor; calls `super(name)`.
- **Methods**
  - `getTopSpeed()` / `getWeight()` — return the stored values.
  - `toString()` (override) — returns `"Car: " + getName()`.

### `Driver.java`
An `Entity` subclass.

- **Variables** — `private int wdc`, `private boolean active`.
- **Constructors**
  - `Driver(String name)` — convenience constructor, defaults `wdc` to `0` and `active` to `false`.
  - `Driver(String name, int wdc, boolean active)` — full constructor; calls `super(name)`.
- **Methods**
  - `getWdc()` — returns the number of world titles.
  - `getActive()` — returns `"Still Active"` or `"Not Active"`.
  - `toString()` (override) — returns `"Driver: " + getName()`.

### `Node.java`
The building block of the list.

- **Variables**
  - `private Entity data` — the stored value, typed as the abstract `Entity`.
  - `Node nextNode` — reference to the next node; `null` if this is the last node.
- **Constructor** `Node(Entity dataInput)` — sets the node's data and initializes `nextNode` to `null`.
- **Methods**
  - `getData()` — returns the stored `Entity`.
  - `getNextNode()` / `setNextNode(Node)` — read/update the link to the next node.
  - `checkData()` — prints the data (implicitly calls `toString()`), used by `displayLinkedList`.

### `LinkedList.java`
Abstract container that owns and coordinates the nodes. It cannot be instantiated directly, so `Main` uses an anonymous subclass.

- **Variables**
  - `Node head` — first node of the list.
  - `Node tail` — last node of the list, kept so appending is O(1) without traversing the whole list.
- **Methods**
  - `add(Node)` — appends at the back. If the list is empty, both `head` and `tail` point to the new node; otherwise the new node is linked after `tail`, then `tail` moves.
  - `getHead()` — returns the first node.
  - `getAt(int index)` — returns the `Entity` at a 0-based index, or prints a message and returns `null` when the index is out of range.
  - `displayLinkedList()` — traverses from `head` using a temporary `current` pointer and prints every value; prints a message when the list is empty.
  - `searchLinkedList(Entity key)` — traverses the list and reports whether `key` exists (using `equals`).
  - `count()` — traverses and counts the nodes.
  - `insertAt(int index, Node)` — inserts at a specific position, handling three cases: front (`index == 0`), back (`index == count()`, reuse `add`), and middle (walk to the node before the target, then relink). Out-of-range indexes are rejected.
  - `delete(Entity key)` — removes the node holding `key`, handling four cases: empty list, deleting `head`, deleting a middle/`tail` node (using `prev` and `current`), and value not found. Updates `tail` when the last node is removed.

### `Main.java`
A plain test driver (no `Scanner` or menu).

- Creates two separate lists — `carList` and `driverList` — both declared as `LinkedList` and instantiated as anonymous subclasses (`new LinkedList(){}`).
- Preloads dummy `Car` and `Driver` objects.
- Demonstrates every operation: `displayLinkedList()`, `getAt()` (with casting to `Car`/`Driver`), `insertAt()`, `searchLinkedList()`, `delete()`, and `count()`.

## Notes on Approach

- **ADT**: `LinkedList` defines the operations, while the element type is abstracted by `Entity`, so the same list works for `Car`, `Driver`, or any future subclass.
- `Node` stores `Entity`; accessing subclass-specific fields requires a cast (`(Car)`, `(Driver)`).
- `equals` lives in `Entity` and is reused by all subclasses, so search/delete compare by meaningful content instead of object identity.
- `toString` is overridden in `Entity`, `Car`, and `Driver` so printed output is readable.
- A temporary `current` pointer is always used for traversal so `head` is never lost.
- Keeping a `tail` reference makes inserting at the back efficient.
- Pointer order during insertion matters: link the new node to the rest of the list **before** breaking the previous link.
- Edge cases (empty list, single-node list, insert/delete at head or tail, out-of-range index, duplicate/missing values) are handled explicitly.
