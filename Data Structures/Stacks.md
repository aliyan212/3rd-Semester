---
aliases:
  - Stack
  - LIFO
  - FILO
  - Stack Data Structure
  - Polish Notation
tags:
  - data-structures
  - algorithms
  - computer-science
  - java
status: complete
created: 2026-09-14
---

> [!abstract] Overview
> A **[[Stack]]** is a [[Linear Data Structure]] that operates strictly on a **[[LIFO]]** (Last In, First Out) or **[[FILO]]** (First In, Last Out) sequence. You can only add or remove elements from one single end, which is called the *top*.

> [!note] Primary Uses
> Stacks are heavily used by computers to manage **[[Recursion|recursive function calls]]** and for **[[Serialization]]** (processing items one by one in a strict order).

---

## Core Operations

A stack relies on three main commands to control its data.

| Operation | Description |
|---|---|
| **[[Push]]** | Adds a new element to the *top* of the stack. |
| **[[Pop]]** | Deletes and returns the element currently at the *top* of the stack. |
| **[[Peek]]** | Returns the value of the *top* element without deleting it. |

---

## Mathematical Expression Formatting

Computers use stacks to read and calculate math equations quickly. This method removes the need for parentheses because the order of operations is built directly into the format.

| Format Type | Notation Name | Rule | Example |
|---|---|---|---|
| **[[Infix Notation]]** | Standard Notation | Operators sit *between* the numbers. | $A + B$ |
| **[[Prefix Notation]]** | Polish Notation | Operators sit *before* the numbers. | $+ A B$ |
| **[[Postfix Notation]]** | Reverse Polish Notation | Operators sit *after* the numbers. | $A B +$ |

---

## Evaluation Algorithms

### 1. [[Postfix Notation|Postfix]] Evaluation
To solve a postfix equation, follow this exact path:

1. Scan the expression from **left to right**.
2. If you see a number (**[[Operand]]**), **push** it onto the stack.
3. If you see a math symbol (**[[Operator]]**), **pop** the top two numbers.
4. *Rule: The first popped value is the right side of the equation, the second popped value is the left side.*
5. Calculate the math and **push** the answer back onto the stack.
6. The final answer is the last number left in the stack.

> [!example] Postfix Trace
> **Evaluate:** $A B / C - D E * +$ 
> (Where $A=12$, $B=6$, $C=3$, $D=4$, $E=5$)
> 
> 1. Read $12, 6$: Push 12, Push 6.
> 2. Read $/$: Pop 6, Pop 12. Compute $12 / 6 = 2$. Push 2.
> 3. Read $3$: Push 3.
> 4. Read $-$: Pop 3, Pop 2. Compute $2 - 3 = -1$. Push -1.
> 5. Read $4, 5$: Push 4, Push 5.
> 6. Read $*$ : Pop 5, Pop 4. Compute $4 \times 5 = 20$. Push 20.
> 7. Read $+$: Pop 20, Pop -1. Compute $-1 + 20 = 19$. Push 19.
> **Final Answer:** 19

### 2. [[Prefix Notation|Prefix]] Evaluation
To solve a prefix equation, reverse two critical steps from the postfix method:

1. Scan the expression **backward** (from right to left).
2. When you pop two numbers for a math symbol, *the first popped value is the left side, and the second popped value is the right side*.

> [!example] Prefix Trace
> **Evaluate:** $+ * 3\ 4\ 5$
> 
> 1. Scan Right-to-Left: $5\ 4\ 3\ *\ +$
> 2. Read 5: Push 5 (Stack: [5])
> 3. Read 4: Push 4 (Stack: [5, 4])
> 4. Read 3: Push 3 (Stack: [5, 4, 3])
> 5. Read $*$ : Pop 3 (left), Pop 4 (right). Compute $3 \times 4 = 12$. Push 12 (Stack: [5, 12])
> 6. Read $+$ : Pop 12 (left), Pop 5 (right). Compute $12 + 5 = 17$. Push 17 (Stack: [17])
> **Final Answer:** 17

~~~mermaid
graph LR
    A[Expression] --> B{Scan Direction}
    B -->|Postfix| C[Left to Right]
    B -->|Prefix| D[Right to Left]
    C --> E[Pop 1 = Right, Pop 2 = Left]
    D --> F[Pop 1 = Left, Pop 2 = Right]
    E --> G[Compute & Push Result]
    F --> G
~~~

---

## [[Java]] Implementations

### 1. Built-in Java Stack
Java has a ready-to-use stack tool inside the `java.util` package. You must use wrapper classes (like `Integer` instead of `int`) for basic data types.

~~~java
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        // Must use the Integer wrapper class for primitive ints
        Stack<Integer> myStack = new Stack<>();
        
        myStack.push(10);
        myStack.push(20);
        myStack.pop();
        myStack.peek();
    }
}
~~~

### 2. Custom Array-Based Stack
If you want to build a stack from scratch, you can use a fixed-size [[Array]] and an integer [[Pointer]] named `top` to keep track of the active boundary.

~~~java
import java.util.*;

public class CustomStack {
    private int top;
    private int maxSize;
    private int[] StackArray;

    public CustomStack(int size) {
        this.top = -1; // Always initialize top with -1
        this.maxSize = size;
        this.StackArray = new int[maxSize];
    }

    public void push(int el) {
        if(isFull()) {
            System.out.println("Stack Overflow. Cant insert " + el);
            return;
        }
        // Move pointer up, then save the value
        StackArray[++top] = el; 
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack underflow, Nothing to del");
            return -1;
        }
        // Return the value, then move pointer down
        return StackArray[top--]; 
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return StackArray[top];
    }

    public boolean isFull() {
        // Checks if pointer reached the end of the array
        return top == maxSize - 1; 
    }

    public boolean isEmpty() {
        // Checks if stack is completely empty
        return top == -1; 
    }
}
~~~

---
# Stack-Based String Reversal (LIFO Trace)

## Core Principle

> [!note] Why Reversal Happens
> A stack only allows access at the **top**. The *last* character pushed is therefore the *first* character popped. This structural constraint is what forces reversal, with no extra sorting logic required.

---

## Trace Table

| Original String | Push Sequence (Left to Right) | Stack State `[Top -> Bottom]` | Pop Sequence (Reversed Output) |
| --- | --- | --- | --- |
| **`ABC`** | Push `A`, Push `B`, Push `C` | `[C, B, A]` | Pop `C`, Pop `B`, Pop `A` $\rightarrow$ **`CBA`** |
| **`DMC`** | Push `D`, Push `M`, Push `C` | `[C, M, D]` | Pop `C`, Pop `M`, Pop `D` $\rightarrow$ **`CMD`** |
| **`0709`** | Push `0`, Push `7`, Push `0`, Push `9` | `[9, 0, 7, 0]` | Pop `9`, Pop `0`, Pop `7`, Pop `0` $\rightarrow$ **`9070`** |
| **`2008`** | Push `2`, Push `0`, Push `0`, Push `8` | `[8, 0, 0, 2]` | Pop `8`, Pop `0`, Pop `0`, Pop `2` $\rightarrow$ **`8002`** |

> [!example] Verification
> All four rows check out mechanically: the last-pushed element in each case is the first one listed at the top of the stack, and the pop sequence reads that stack top-to-bottom. The logic holds regardless of whether the tokens are letters or digits.

---

## Visualizing One Trace (`ABC` to `CBA`)

~~~mermaid
graph LR
    subgraph Push_Phase
        A1[Push A] --> A2[Push B] --> A3[Push C]
    end
    subgraph Stack_State
        S["Top: C\nMid: B\nBottom: A"]
    end
    subgraph Pop_Phase
        P1[Pop C] --> P2[Pop B] --> P3[Pop A]
    end
    A3 --> S --> P1
~~~

---

## The Code
~~~java
public static String reverseUsingStack(String input) {
    stacks stack = new stacks(input.length());

    for (int i = 0; i < input.length(); i++) {
        stack.push(input.charAt(i));
    }

    String reversedString = "";
    while (!stack.isEmpty()) {
        reversedString += (char) stack.pop();
    }

    return reversedString;
}
~~~
---

## Related Concepts

- [[Push]]: Adds an element to the top of the stack.
- [[Pop]]: Removes and returns the top element.
- [[Peek]]: Reads the top element without removing it.
- [[Postfix Evaluation Algorithm]]: Another example of stacks processing tokens left to right.
- [[Prefix Evaluation Algorithm]]: Uses the same LIFO mechanics but scans right to left.
