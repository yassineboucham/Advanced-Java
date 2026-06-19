# Java Data Structures — Complete Guide

A comprehensive reference for all major data structures in Java, including complexity analysis, code examples, and when to use each one.

---

## Table of Contents

1. [Array](#1-array)
2. [ArrayList](#2-arraylist)
3. [LinkedList](#3-linkedlist)
4. [Stack](#4-stack)
5. [Queue & ArrayDeque](#5-queue--arraydeque)
6. [PriorityQueue](#6-priorityqueue)
7. [HashMap](#7-hashmap)
8. [LinkedHashMap](#8-linkedhashmap)
9. [TreeMap](#9-treemap)
10. [HashSet](#10-hashset)
11. [LinkedHashSet](#11-linkedhashset)
12. [TreeSet](#12-treeset)
13. [2D Array (Matrix)](#13-2d-array-matrix)
14. [Complexity Summary Table](#14-complexity-summary-table)
15. [Choosing the Right Structure](#15-choosing-the-right-structure)

---

## 1. Array

The most fundamental data structure in Java. Fixed size, stores elements of the same type in contiguous memory.

```java
// Declaration and initialization
int[] nums = new int[5];          // default values: 0
String[] names = {"Alice", "Bob", "Charlie"};

// Access and update — O(1)
nums[0] = 42;
System.out.println(names[1]);     // Bob

// Iterate
for (int i = 0; i < nums.length; i++) {
    System.out.println(nums[i]);
}

// Enhanced for-loop
for (String name : names) {
    System.out.println(name);
}

// Useful utility
import java.util.Arrays;
Arrays.sort(nums);                // O(n log n)
Arrays.fill(nums, 0);            // fill with value
System.out.println(Arrays.toString(nums));
```

**Complexity:**

| Operation | Average | Worst |
|-----------|---------|-------|
| Access    | O(1)    | O(1)  |
| Search    | O(n)    | O(n)  |
| Insert    | O(n)    | O(n)  |
| Delete    | O(n)    | O(n)  |

**When to use:** Raw performance, known fixed size, primitive types (avoids boxing overhead).

---

## 2. ArrayList

A resizable array backed by a dynamic array. The most commonly used `List` implementation.

```java
import java.util.ArrayList;
import java.util.List;

List<String> list = new ArrayList<>();

// Add elements
list.add("Java");           // append — O(1) amortized
list.add(0, "Python");      // insert at index — O(n)

// Access
String first = list.get(0); // O(1)
int size = list.size();

// Update
list.set(1, "JavaScript");  // O(1)

// Remove
list.remove(0);             // by index — O(n)
list.remove("Java");        // by value — O(n)

// Search
boolean found = list.contains("Java");   // O(n)
int idx = list.indexOf("Java");          // O(n)

// Iterate
for (String lang : list) {
    System.out.println(lang);
}

// Sort
import java.util.Collections;
Collections.sort(list);
```

**Complexity:**

| Operation  | Average    | Worst |
|------------|------------|-------|
| get(i)     | O(1)       | O(1)  |
| add (end)  | O(1)*      | O(n)  |
| add (mid)  | O(n)       | O(n)  |
| remove     | O(n)       | O(n)  |
| contains   | O(n)       | O(n)  |

> `*` amortized — occasional resize copies the array

**When to use:** Default list choice. Random access needed. More reads than writes.

---

## 3. LinkedList

A doubly-linked list. Each element is a node holding a reference to the previous and next nodes.

```java
import java.util.LinkedList;

LinkedList<Integer> ll = new LinkedList<>();

// Add at ends — O(1)
ll.addFirst(1);
ll.addLast(3);
ll.add(2);          // same as addLast

// Add at index — O(n) to reach position, O(1) to link
ll.add(1, 99);

// Access — O(n)
int val = ll.get(0);
int first = ll.getFirst();
int last  = ll.getLast();

// Remove — O(1) at ends, O(n) to find middle
ll.removeFirst();
ll.removeLast();
ll.remove(Integer.valueOf(99)); // by value

// Also usable as a Deque (double-ended queue)
ll.push(10);    // addFirst
ll.pop();       // removeFirst
ll.peek();      // getFirst without removing
```

**Complexity:**

| Operation      | Average | Worst |
|----------------|---------|-------|
| get(i)         | O(n)    | O(n)  |
| add head/tail  | O(1)    | O(1)  |
| add middle     | O(n)    | O(n)  |
| remove head/tail | O(1) | O(1)  |

**When to use:** Frequent insertion/deletion at both ends. Implementing Deque or Queue manually.

---

## 4. Stack

A **LIFO** (Last In, First Out) structure.  
> **Best practice:** Use `ArrayDeque` instead of the legacy `Stack` class — it is faster and not synchronized.

```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> stack = new ArrayDeque<>();

// Push — O(1)
stack.push(1);
stack.push(2);
stack.push(3);

// Pop (removes top) — O(1)
int top = stack.pop();   // 3

// Peek (view top without removing) — O(1)
int peek = stack.peek(); // 2

// Check empty
boolean empty = stack.isEmpty();
int size = stack.size();
```

**Classic use cases:**
- Undo/redo operations
- Balanced parentheses checking
- DFS (Depth-First Search)
- Function call simulation

**Complexity:**

| Operation | Time |
|-----------|------|
| push      | O(1) |
| pop       | O(1) |
| peek      | O(1) |

---

## 5. Queue & ArrayDeque

A **FIFO** (First In, First Out) structure. `ArrayDeque` is the recommended implementation.

```java
import java.util.ArrayDeque;
import java.util.Queue;

Queue<String> queue = new ArrayDeque<>();

// Enqueue — O(1)
queue.offer("A");
queue.offer("B");
queue.offer("C");

// Dequeue (removes front) — O(1)
String front = queue.poll();  // "A"

// Peek (view front without removing) — O(1)
String next = queue.peek();   // "B"

// Check size / empty
System.out.println(queue.size());
System.out.println(queue.isEmpty());

// ArrayDeque as double-ended queue
ArrayDeque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);
deque.addLast(2);
deque.removeFirst();
deque.removeLast();
```

**Classic use cases:**
- BFS (Breadth-First Search)
- Task scheduling
- Sliding window problems

**Complexity:**

| Operation | Time |
|-----------|------|
| offer     | O(1) |
| poll      | O(1) |
| peek      | O(1) |

---

## 6. PriorityQueue

A **min-heap** by default. Always `poll()`s the smallest element first.

```java
import java.util.PriorityQueue;
import java.util.Collections;

// Min-heap (default)
PriorityQueue<Integer> minPQ = new PriorityQueue<>();
minPQ.offer(5);
minPQ.offer(1);
minPQ.offer(3);
System.out.println(minPQ.poll()); // 1 (smallest)

// Max-heap using reversed order
PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
maxPQ.offer(5);
maxPQ.offer(1);
maxPQ.offer(3);
System.out.println(maxPQ.poll()); // 5 (largest)

// Custom Comparator (e.g., sort by string length)
PriorityQueue<String> customPQ = new PriorityQueue<>(
    (a, b) -> a.length() - b.length()
);
customPQ.offer("banana");
customPQ.offer("kiwi");
customPQ.offer("fig");
System.out.println(customPQ.poll()); // "fig"
```

**Classic use cases:**
- Dijkstra's shortest path
- Prim's MST algorithm
- Merge K sorted lists
- Top K elements problems

**Complexity:**

| Operation | Average    | Worst      |
|-----------|------------|------------|
| offer     | O(log n)   | O(log n)   |
| poll      | O(log n)   | O(log n)   |
| peek      | O(1)       | O(1)       |
| build     | O(n)       | O(n)       |

---

## 7. HashMap

Key-value pairs with **O(1) average** access. The most widely used Map implementation.

```java
import java.util.HashMap;
import java.util.Map;

Map<String, Integer> map = new HashMap<>();

// Put / update — O(1) average
map.put("age", 25);
map.put("score", 100);

// Get — O(1) average
int age = map.get("age");           // 25
int val = map.getOrDefault("x", 0); // 0 if key absent

// Check existence
boolean hasKey = map.containsKey("age");   // true
boolean hasVal = map.containsValue(100);   // true

// Remove
map.remove("score");

// Iterate entries
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}

// Common patterns
map.put("count", map.getOrDefault("count", 0) + 1); // frequency counter
map.putIfAbsent("key", 42);
map.computeIfAbsent("list", k -> new ArrayList<>()).add("item");
```

**Properties:**
- Unordered (no guaranteed iteration order)
- Allows one `null` key and multiple `null` values
- Not thread-safe (use `ConcurrentHashMap` for concurrency)

**Complexity:**

| Operation   | Average | Worst |
|-------------|---------|-------|
| get         | O(1)    | O(n)  |
| put         | O(1)    | O(n)  |
| remove      | O(1)    | O(n)  |
| containsKey | O(1)    | O(n)  |

> Worst case O(n) occurs with hash collisions (rare in practice).

---

## 8. LinkedHashMap

Like `HashMap` but **maintains insertion order** (or access order if configured).

```java
import java.util.LinkedHashMap;
import java.util.Map;

Map<String, Integer> lhm = new LinkedHashMap<>();
lhm.put("banana", 2);
lhm.put("apple", 5);
lhm.put("cherry", 1);

// Iterates in insertion order: banana, apple, cherry
for (Map.Entry<String, Integer> e : lhm.entrySet()) {
    System.out.println(e.getKey());
}

// Access-order mode (LRU Cache pattern)
Map<String, Integer> lru = new LinkedHashMap<>(16, 0.75f, true) {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > 3; // max 3 entries
    }
};
```

**When to use:** Need HashMap performance + predictable iteration order. LRU cache implementation.

---

## 9. TreeMap

Sorted key-value map backed by a **Red-Black tree**. Keys are always in natural order (or Comparator order).

```java
import java.util.TreeMap;

TreeMap<String, Integer> tm = new TreeMap<>();
tm.put("banana", 2);
tm.put("apple", 5);
tm.put("cherry", 1);

// Always iterates in sorted key order: apple, banana, cherry
System.out.println(tm.firstKey());        // "apple"
System.out.println(tm.lastKey());         // "cherry"
System.out.println(tm.floorKey("b"));     // "banana" (≤ "b")
System.out.println(tm.ceilingKey("b"));   // "banana" (≥ "b")

// Sub-map views
tm.headMap("cherry");              // keys < "cherry"
tm.tailMap("banana");              // keys >= "banana"
tm.subMap("apple", "cherry");      // keys in [apple, cherry)
```

**Properties:**
- Keys always sorted
- Does NOT allow `null` keys
- All operations O(log n)
- Implements `NavigableMap` — supports range queries

**Complexity:**

| Operation | Time     |
|-----------|----------|
| get / put | O(log n) |
| firstKey  | O(log n) |
| headMap   | O(log n) |

**When to use:** Need sorted keys, range queries, or ceiling/floor lookups.

---

## 10. HashSet

A collection of **unique elements** backed by a `HashMap`. Fast membership checking.

```java
import java.util.HashSet;
import java.util.Set;

Set<String> set = new HashSet<>();

// Add — O(1) average
set.add("Java");
set.add("Python");
set.add("Java");   // ignored — no duplicates

System.out.println(set.size());         // 2
System.out.println(set.contains("Java")); // true — O(1)

// Remove — O(1) average
set.remove("Python");

// Set operations
Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3));
Set<Integer> b = new HashSet<>(Arrays.asList(2, 3, 4));

a.retainAll(b); // intersection: {2, 3}
a.addAll(b);    // union
a.removeAll(b); // difference
```

**When to use:** Remove duplicates from a collection. Fast `contains()` check. Set math (union, intersection, difference).

---

## 11. LinkedHashSet

Like `HashSet` but **maintains insertion order**.

```java
import java.util.LinkedHashSet;

Set<String> lhs = new LinkedHashSet<>();
lhs.add("banana");
lhs.add("apple");
lhs.add("cherry");
lhs.add("banana"); // ignored

// Iterates in insertion order: banana, apple, cherry
for (String s : lhs) System.out.println(s);
```

**When to use:** Need unique elements + predictable iteration order.

---

## 12. TreeSet

A sorted set backed by a **Red-Black tree**. Elements always in natural or Comparator order.

```java
import java.util.TreeSet;

TreeSet<Integer> ts = new TreeSet<>();
ts.add(5);
ts.add(1);
ts.add(3);
ts.add(2);

System.out.println(ts);          // [1, 2, 3, 5] — always sorted
System.out.println(ts.first());  // 1
System.out.println(ts.last());   // 5
System.out.println(ts.floor(3)); // 3 (≤ 3)
System.out.println(ts.ceiling(4)); // 5 (≥ 4)

// Range views
ts.headSet(3);          // {1, 2}    — elements < 3
ts.tailSet(3);          // {3, 5}    — elements >= 3
ts.subSet(2, 4);        // {2, 3}    — [2, 4)
```

**Complexity:**

| Operation     | Time     |
|---------------|----------|
| add / remove  | O(log n) |
| contains      | O(log n) |
| first / last  | O(log n) |

**When to use:** Unique sorted elements. Frequent range or nearest-element queries.

---

## 13. 2D Array (Matrix)

An array of arrays, used for grids, matrices, and DP tables.

```java
// Declare and allocate
int[][] grid = new int[3][4];         // 3 rows, 4 columns — default 0

// Initialize with values
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Access — O(1)
int val = matrix[1][2];   // 6 (row 1, col 2)
int rows = matrix.length;
int cols = matrix[0].length;

// Traverse
for (int r = 0; r < rows; r++) {
    for (int c = 0; c < cols; c++) {
        System.out.print(matrix[r][c] + " ");
    }
    System.out.println();
}

// Jagged array (different column sizes per row)
int[][] jagged = new int[3][];
jagged[0] = new int[2];
jagged[1] = new int[4];
jagged[2] = new int[1];
```

**Classic use cases:**
- Dynamic Programming (DP tables)
- Graph adjacency matrix
- Image processing (pixel grids)
- Game boards (chess, minesweeper)

---

## 14. Complexity Summary Table

| Data Structure  | Access  | Search  | Insert  | Delete  | Space  |
|-----------------|---------|---------|---------|---------|--------|
| Array           | O(1)    | O(n)    | O(n)    | O(n)    | O(n)   |
| ArrayList       | O(1)    | O(n)    | O(n)    | O(n)    | O(n)   |
| LinkedList      | O(n)    | O(n)    | O(1)*   | O(1)*   | O(n)   |
| Stack (Deque)   | O(n)    | O(n)    | O(1)    | O(1)    | O(n)   |
| Queue (Deque)   | O(n)    | O(n)    | O(1)    | O(1)    | O(n)   |
| PriorityQueue   | O(1)**  | O(n)    | O(log n)| O(log n)| O(n)   |
| HashMap         | O(1)†   | O(1)†   | O(1)†   | O(1)†   | O(n)   |
| TreeMap         | O(log n)| O(log n)| O(log n)| O(log n)| O(n)   |
| HashSet         | —       | O(1)†   | O(1)†   | O(1)†   | O(n)   |
| TreeSet         | —       | O(log n)| O(log n)| O(log n)| O(n)   |

> `*` O(1) only if you already have the node reference  
> `**` O(1) for `peek()` only; poll() is O(log n)  
> `†` average case; worst case O(n) due to hash collisions

---

## 15. Choosing the Right Structure

```
Need a list of elements?
│
├── Random access important? → ArrayList
├── Frequent insert/delete at ends? → LinkedList or ArrayDeque
└── Unknown size, general use? → ArrayList (default)

Need key-value pairs?
│
├── Fast lookup, no order needed? → HashMap
├── Need insertion order? → LinkedHashMap
└── Need sorted keys / range queries? → TreeMap

Need unique elements?
│
├── No order needed? → HashSet
├── Need insertion order? → LinkedHashSet
└── Need sorted elements / range queries? → TreeSet

Need LIFO (stack)?
└── ArrayDeque.push() / pop()

Need FIFO (queue)?
└── ArrayDeque.offer() / poll()

Need priority-based processing?
└── PriorityQueue (min-heap by default)

Need a fixed-size grid or matrix?
└── int[][] or Object[][]
```

---

## Quick Import Reference

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Queue;
import java.util.Deque;
import java.util.Collections;
import java.util.Arrays;
```

---

*Made with ❤️ for Java learners — covers Java 8+*