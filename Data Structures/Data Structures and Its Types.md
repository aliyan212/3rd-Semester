---
aliases: [DSA, Data Structures and Algorithms]
tags: [computer-science, data-structures, algorithms, programming]
status: complete
created: 2026-09-10
---
> [!abstract] Overview
> A **[[Data Structure]]** is a method of organizing and storing data for efficient use. An **[[Algorithm]]** is a step-by-step procedure used to solve a specific problem. Together, they form the foundation of efficient [[Computer Science]] and software design.

---

## [[Data Structure|Data Structures]]

> [!note] Primitive vs. Non-Primitive
> *Primitive data types* are basic built-in types (e.g., [[Integer|integers]], [[Boolean|booleans]], [[Character|characters]]). *Non-primitive data types* are more complex structures built from primitives, including both linear and non-linear types.

### Linear Data Structures
Data elements are arranged in a sequential or linear order. 

| Structure           | Description                                                                | Access Pattern                 |
| ------------------- | -------------------------------------------------------------------------- | ------------------------------ |
| **[[Array]]**       | A collection of items stored at contiguous memory locations.               | Random Access                  |
| **[[Linked List]]** | Elements point to the next element, forming a sequential chain.            | Sequential                     |
| **[[Stack]]**       | A collection where items are added and removed from the top.               | **LIFO** (Last In, First Out)  |
| **[[Queue]]**       | A collection where items are added at the back and removed from the front. | **FIFO** (First In, First Out) |

### Non-Linear Data Structures
Data elements are not arranged in a sequence; they are interconnected or hierarchical.

* **[[Tree (Data Structure)|Tree]]**: A hierarchical structure with a root value and subtrees of children.
* **[[Graph (Data Structure)|Graph]]**: A set of nodes (vertices) connected by edges.

~~~mermaid
graph LR
    A[Data Structures] --> B[Primitive]
    A --> C[Non-Primitive]
    B --> D[Integer, Boolean, Char]
    C --> E[Linear]
    C --> F[Non-Linear]
    E --> G[Array, Stack, Queue, Linked List]
    F --> H[Tree, Graph]
~~~

---

## [[Algorithm|Algorithms]]

> [!quote] Definition
> An algorithm is a step-by-step procedure to solve a problem and describe it in a real-world language.

### Example: [[Selection Sort]]

> [!example] Sorting an Array
> Selection sort works by repeatedly finding the largest (or smallest) element from the unsorted part and moving it to its correct sorted position.

**Step-by-Step Workflow:**

1. **Assume the largest:** Take the first item in the unsorted portion of the [[Array]] and temporarily assume it is the *largest* value.
2. **Compare with the rest:** Compare this assumed largest value with the next item in the array.
3. **Update the largest:** If you find an item that is bigger than your current assumed largest, update your "largest" marker to point to this new item.
4. **Complete the search:** Continue this comparison process until you have checked every remaining item in the unsorted portion of the array.
5. **Swap into place:** Once you reach the end, swap the true largest item you just found with the item at the very end of your unsorted section.
6. **Repeat for the rest:** Lock that largest item in place (it is now sorted), go back to the remaining unsorted items, and repeat Steps 1–5 until the whole array is sorted.

~~~mermaid
graph TD
    Start[Start Sorting] --> Step1[1. Assume first unsorted item is largest]
    Step1 --> Step2[2. Compare with next item]
    Step2 --> Condition{Is next item bigger?}
    Condition -->|Yes| Step3[3. Update largest marker]
    Condition -->|No| Step4[4. Continue search]
    Step3 --> Step4
    Step4 --> EndCheck{End of unsorted section?}
    EndCheck -->|No| Step2
    EndCheck -->|Yes| Step5[5. Swap largest to the end]
    Step5 --> RepeatCheck{Is array fully sorted?}
    RepeatCheck -->|No| Step1
    RepeatCheck -->|Yes| Finish[Done]
~~~