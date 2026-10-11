---
aliases: [Linked List Lab, Stack Using Linked List, Queue Using Linked List, Doubly Linked List]
tags: [data-structures, java, linked-list, lab, assignment]
status: active
created: 2026-10-10
---

# Linked List Implementations

> [!abstract] Overview
> This note covers three Java implementations built on the [[Linked List]] structure: a **[[Stack]]**, a **[[Queue]]**, and a **[[Doubly Linked List]]**. Each uses a custom `Node` class and manages memory through references instead of a fixed-size [[Array]].

---

## Core Building Block: The Node

Every program starts with a `Node` that stores a value and one or more references to neighbouring nodes.

| Structure              | Node Fields            | Direction              |
| ---------------------- | ---------------------- | ---------------------- |
| **Stack**              | `data`, `next`         | One way, top to bottom |
| **Queue**              | `data`, `next`         | One way, front to rear |
| **Doubly Linked List** | `data`, `prev`, `next` | Two way                |

> [!warning] File Separation
> All three programs declare their own `Node` class. In Java this only compiles if each program lives in its **own file or package**. Pasted into a single file, the three `Node` declarations would collide.

---

## Question 1: Stack Using Linked List

A **[[Stack]]** follows **[[LIFO]]** order. The `top` reference always points to the most recently pushed node, so every operation happens at one end.

~~~mermaid
graph LR
    T[top] --> A[30]
    A --> B[20]
    B --> C[10]
    C --> D[null]
~~~

### Operations

| Method | Behaviour | Time |
| --- | --- | --- |
| `push(data)` | Creates a node, links it to the old top, moves `top` to it. | $O(1)$ |
| `pop()` | Returns `top.data`, moves `top` to `top.next`. | $O(1)$ |
| `peek()` | Returns `top.data` without removing it. | $O(1)$ |
| `isEmpty()` | Returns `true` when `top == null`. | $O(1)$ |
| `display()` | Walks from `top` to the end, printing each value. | $O(n)$ |

### Java Implementation

~~~java
import java.util.Scanner;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return -1;
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class StackMenu {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nSTACK MENU\n1. Push\n2. Pop\n3. Peek\n4. Check Empty\n5. Display\n6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    stack.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.peek());
                    break;
                case 4:
                    System.out.println(stack.isEmpty());
                    break;
                case 5:
                    stack.display();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
~~~

> [!note] Why No `isFull()`
> The array-based version needs an `isFull()` check because its size is fixed. A linked stack grows one node at a time, so it never overflows until the JVM runs out of memory.

---

## Question 2: Queue Using Linked List

A **[[Queue]]** follows **[[FIFO]]** order. It tracks two references: `front` for removals and `rear` for insertions, so both ends are $O(1)$ with no shifting.

~~~mermaid
graph LR
    F[front] --> A[10]
    A --> B[20]
    B --> C[30]
    C --> D[null]
    R[rear] --> C
~~~

### Operations

| Method | Behaviour | Time |
| --- | --- | --- |
| `enqueue(data)` | Appends at `rear`. If the queue is empty, sets both `front` and `rear`. | $O(1)$ |
| `dequeue()` | Returns `front.data`, advances `front`. | $O(1)$ |
| `peek()` | Returns `front.data` without removing it. | $O(1)$ |
| `isEmpty()` | Returns `true` when `front == null`. | $O(1)$ |
| `display()` | Walks from `front` to the end. | $O(n)$ |

> [!example] The Edge Case in `dequeue()`
> After advancing `front`, the code checks `if (front == null) rear = null;`. Without this line, removing the last item would leave `rear` pointing at a deleted node, and the next `enqueue` would attach to it incorrectly.

### Java Implementation

~~~java
import java.util.Scanner;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node front, rear;
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        int dequeued = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeued;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        }
        return front.data;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class QueueMenu {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nQUEUE MENU\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Check Empty\n5. Display\n6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    queue.enqueue(sc.nextInt());
                    break;
                case 2:
                    System.out.println(queue.dequeue());
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                case 4:
                    System.out.println(queue.isEmpty());
                    break;
                case 5:
                    queue.display();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
~~~

---

## Question 3: Doubly Linked List

A **[[Doubly Linked List]]** gives each node both a `prev` and a `next` reference. The list keeps `head` and `tail` pointers, so it can be traversed in either direction and can remove from the end without scanning.

~~~mermaid
graph LR
    H[head] --> A[10]
    A <--> B[20]
    B <--> C[30]
    T[tail] --> C
~~~

### Operations

| Method | Behaviour | Time |
| --- | --- | --- |
| `insertAtBeginning(data)` | Links a new node before `head`. | $O(1)$ |
| `insertAtEnd(data)` | Links a new node after `tail`. | $O(1)$ |
| `insertAtPosition(data, position)` | Walks to the node before the target position, then splices in. Falls back to beginning or end when out of range. | $O(n)$ |
| `deleteFromBeginning()` | Moves `head` forward and clears its `prev`. | $O(1)$ |
| `deleteFromEnd()` | Moves `tail` backward and clears its `next`. | $O(1)$ |
| `deleteFromPosition(position)` | Walks to the target node and relinks its neighbours. | $O(n)$ |
| `displayForward()` | Prints from `head` using `next`. | $O(n)$ |
| `displayBackward()` | Prints from `tail` using `prev`. | $O(n)$ |

> [!note] The Four-Pointer Splice
> Inserting in the middle requires updating four references in the correct order:
>
> 1. `newNode.next = current.next`
>
> 2. `newNode.prev = current`
>
> 3. `current.next.prev = newNode`
>
> 4. `current.next = newNode`
>
> Doing step 4 before step 3 would lose the only reference to the following node.

### Java Implementation

~~~java
class Node {
    int data;
    Node prev;
    Node next;
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAtPosition(int data, int position) {
        if (position <= 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            insertAtEnd(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    public void deleteFromBeginning() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteFromEnd() {
        if (tail == null) return;
        if (tail == head) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteFromPosition(int position) {
        if (head == null) return;
        if (position < 1) return;
        if (position == 1) {
            deleteFromBeginning();
            return;
        }
        Node current = head;
        for (int i = 1; i < position && current != null; i++) {
            current = current.next;
        }
        if (current == null) return;
        if (current == tail) {
            deleteFromEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}
~~~




---

## Design Notes and Limitations

| Issue | Where | Why It Matters |
| --- | --- | --- |
| **`-1` as error value** | Stack and Queue | `-1` is a legitimate data value, so callers cannot distinguish an empty structure from a stored `-1`. An exception or wrapper type avoids this. |
| **No input validation** | Both menus | `sc.nextInt()` throws `InputMismatchException` on non-numeric input. |
| **No default case** | Both menus | Entering a number outside 1 to 6 silently redraws the menu. |
| **Scanner never closed** | Both menus | `System.exit(0)` ends the program, so it is harmless here, but it is poor practice in larger programs. |
| **No `main` method** | Doubly Linked List | The class cannot be run on its own and needs a separate driver to test it. |

---

## Comparison: Stack vs Queue vs Doubly Linked List

| Aspect | [[Stack]] | [[Queue]] | [[Doubly Linked List]] |
| --- | --- | --- | --- |
| **Order** | LIFO | FIFO | Arbitrary |
| **Pointers Kept** | `top` | `front`, `rear` | `head`, `tail` |
| **Insert Point** | Top only | Rear only | Beginning, end, or any position |
| **Remove Point** | Top only | Front only | Beginning, end, or any position |
| **Traversal** | One direction | One direction | Both directions |
| **Memory per Node** | 1 reference | 1 reference | 2 references |