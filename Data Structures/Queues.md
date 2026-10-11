---
aliases: [Queue, FIFO, Linear Queue, Circular Queue]
tags: [data-structures, algorithms, computer-science, java]
status: complete
created: 2026-09-22
---
# Queues: Linear and Circular

> [!abstract] Overview
> A **[[Queue]]** is a [[Linear Data Structure]] that strictly follows a **[[FIFO]]** (First In, First Out) sequence. The first item placed into the queue is always the first item removed. Unlike a [[Stack]], which operates from a single end, a queue uses two distinct [[Pointer|pointers]] to manage its boundaries.

---

## Core Operations and Pointers

A queue uses two pointers to keep track of its data inside an [[Array]].

| Pointer | Purpose | Action |
| --- | --- | --- |
| **[[Front]]** (F) | Tracks the index from which elements are removed. | **[[Dequeue]]** |
| **[[Rear]]** (R) | Tracks the index at which new elements are inserted. | **[[Enqueue]]** |

~~~mermaid
graph LR
    A[Incoming Data] -->|Enqueue| B(Rear Pointer)
    B --> C[Queue Array]
    C --> D(Front Pointer)
    D -->|Dequeue| E[Outgoing Data]
~~~

---

## 1. Linear Custom Queue

In a standard linear queue, you insert items at the back and remove them from the front.

> [!note] Initial State
> When the queue is built, the [[Array]] is allocated based on a maximum size. Both the Front (`F`) and Rear (`R`) pointers start at `-1`. This mathematically represents that the queue is completely empty.

### Java Implementation

~~~java
public class CustomQueue {
    private int[] array;
    private int F, R;
    private int size;

    public CustomQueue(int Qsize) {
        this.size = Qsize;
        this.F = -1;
        this.R = -1;
        this.array = new int[size];
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Overflow: Queue is full.");
            return;
        } else if (F == -1 && R == -1) {
            F = R = 0;
            array[R] = item;
        } else {
            R++;
            array[R] = item;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow: Queue is empty.");
            return -1;
        } else if (F == R) {
            int data = array[F];
            F = R = -1;
            return data;
        } else {
            int data = array[F];
            F++;
            return data;
        }
    }

    public boolean isFull() {
        return R == size - 1;
    }

    public boolean isEmpty() {
        return F == -1;
    }
}
~~~

---

## 2. Circular Queue

A linear queue has a major physical flaw: wasted space. As items are removed, the Front pointer moves forward, leaving empty, unusable slots at the beginning of the array. Once the Rear pointer hits the end of the array, the system treats the queue as full, even if space is available at the front.

A **[[Circular Queue]]** solves this memory issue.

> [!quote] The Solution
> A circular queue uses **[[Modulo Arithmetic]]** (`% size`). This mathematical trick allows the pointers to wrap around back to index `0` when they reach the end of the array. It treats the straight array like an endless circle.

> [!note] How the Full Check Works
> This implementation has no separate `isFull()` method. Instead, `enqueue` tentatively advances `R` with `(R + 1) % size`, then checks if `R` has collided with `F`. If so, the queue was already full *before* this insertion, so `R` is stepped back to undo the tentative move and the item is rejected. This is logically equivalent to checking `(R + 1) % size == F` before writing, just written as write-then-check-then-undo instead of check-then-write.

### Java Implementation

~~~java
public class CircularQueue {
    private int[] Array;
    private int F, R, size;

    public CircularQueue(int Qsize) {
        this.size = Qsize;
        this.F = -1;
        this.R = -1;
        this.Array = new int[size];
    }

    public void enqueue(int item) {
        if (isEmpty()) {
            F = R = 0;
            Array[R] = item;
        } else {
            // Increment the index in a circle
            R = (R + 1) % size;

            if (R == F) {
                System.out.println("Queue is full");
                // Step back if full to avoid overwriting the front
                R = (R - 1 + size) % size;
            } else {
                Array[R] = item;
            }
        }
    }

    public int dequeue() {
        int item = -1;

        if (!isEmpty()) {
            item = Array[F];
            if (F == R) {
                // Reset pointers if it was the very last item
                F = R = -1;
            } else {
                // Increment the front pointer in a circle
                F = (F + 1) % size;
            }
        } else {
            System.out.println("Empty Queue");
        }

        return item;
    }

    public boolean isEmpty() {
        return F == -1;
    }
}
~~~

---

## Linear vs Circular Comparison

| Aspect | [[Linear Queue]] | [[Circular Queue]] |
| --- | --- | --- |
| **Space Reuse** | Wastes space after dequeues; freed front slots are never reused. | Wraps pointers with `% size`, reusing freed slots. |
| **Full Condition** | `R == size - 1`, even if front slots are free. | `R` would collide with `F` after wrapping. |
| **Empty Condition** | `F == -1` | `F == -1` |
| **Reset on Last Item** | `F = R = -1` | `F = R = -1` |