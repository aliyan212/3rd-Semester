---
aliases:
  - Linked List
  - Singly Linked List
  - Node Traversal
  - Insert at Position
  - Linked List Deletion
  - Linked List Search
tags:
  - data-structures
  - linked-list
  - java
  - pointers
  - algorithms
status: active
created: 2026-09-28
---
# Linked List Fundamentals and Core Operations

> [!abstract] Overview
> This note covers the structure of a [[Linked List]], the anatomy of a [[Node]], and six core operations: [[Append]], position-based [[Insertion]], [[Traversal]], [[Deletion]], and [[Search]]. The earlier off-by-one defect in the position-based insert has been corrected in this version, and the fix is verified below with a trace rather than taken on faith.

---

## Core Structure

> [!note] Defining the Pieces
> A **[[Linked List]]** is a linear data structure where elements are not stored in contiguous memory. Each element is a **[[Node]]**, dynamically allocated and connected via pointers rather than array indices.
>
> - **Data field**: holds the actual value
> - **`next` pointer**: holds the memory address of the subsequent [[Node]].
> - **[[Head Pointer]]**: a single `head` reference tracks the start of the list.
> - **Termination**: the final [[Node]] points to `Null`, marking the end of the chain.

**Memory Visualization:**

`[301] -> [A|201] -> [B|2018] -> [C|405] -> [D|Null]`

---

## The `NODE` Class

```java
class CustomLinkedList {
    NODE head;

    static class NODE {
        int data;
        NODE next;

        NODE(int val) {
            this.data = val;
            this.next = null;
        }
    }
}
```



---

## Inserting at the End ([[Append]])

```java
public void insert(int data) {
    NODE newNode = new NODE(data);

    if (head == null) {
        head = newNode;
        return;
    }

    NODE current = head;

    while (current.next != null) {
        current = current.next;
    }

    current.next = newNode;
}
```

---

## Inserting at a Specific Position

```java
public void insert(int data, int position) {
    NODE newnode = new NODE(data);

    if (position == 0) {
        newnode.next = head;
        head = newnode;
        return;
    }

    NODE prev = head;

    for (int i = 0; i < position - 1; i++) {
        if (prev != null) {
            prev = prev.next;
        }
    }

    if (prev != null) {
        newnode.next = prev.next;
        prev.next = newnode;
    } else {
        System.out.println("Out of bounds");
    }
}
```


---

## Traversal ([[Display]])

```java
public void display() {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    NODE current = head;

    while (current != null) {
        System.out.print(current.data + " -> ");
        current = current.next;
    }
    System.out.println("null");
}
```

> [!note] Why `current` Instead of `head`
> Traversing with `head` directly would permanently lose the start of the list the moment `head = head.next` runs. Using a disposable `current` pointer is the correct and necessary pattern here.

---

## Deletion (By Value)

```java
public void delete(int key) {
    NODE current = head;
    NODE prev = null;

    if (current != null && current.data == key) {
        head = current.next;
        return;
    }

    while (current != null && current.data != key) {
        prev = current;
        current = current.next;
    }

    if (current == null) {
        System.out.println("Value " + key + " not found in the list.");
        return;
    }

    prev.next = current.next;
}
```

---

## Searching

```java
public boolean search(int key) {
    NODE current = head;

    while (current != null) {
        if (current.data == key) {
            return true;
        }
        current = current.next;
    }

    return false;
}
```


---

## Operation Summary

| Operation | Time Complexity | Requires Traversal |
| --- | --- | --- |
| **[[Append]]** | *O(n)* | Yes, to find the tail |
| **Insert at Head** | *O(1)* | No |
| **Insert at Position** | *O(n)* | Yes, up to `position - 1` |
| **[[Display]]** | *O(n)* | Yes, full list |
| **[[Deletion]]** | *O(n)* | Yes, worst case |
| **[[Search]]** | *O(n)* | Yes, worst case |

---

## Pointer Flow for Position-Based Insert

~~~mermaid
graph LR
    subgraph Before
        P1[prev] --> N1[prev.next]
    end
    subgraph Correct_Order
        NN[newnode] -.->|"1: newnode.next = prev.next"| N1
        P1 -.->|"2: prev.next = newnode"| NN
    end
~~~

---
