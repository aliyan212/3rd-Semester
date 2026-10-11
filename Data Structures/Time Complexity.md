---
aliases: [Time Complexity, Big O Notation, Asymptotic Notation, Algorithm Analysis]
tags: [algorithms, complexity-analysis, big-o, data-structures, java]
status: active
created: 2026-09-25
---
# Time Complexity Fundamentals

> [!abstract] Overview
> This note covers **[[Time Complexity]]** and **[[Asymptotic Notation]]**, the mathematical language used to describe how an algorithm's running time scales with input size. It walks through five growth patterns: [[Constant Time]], [[Linear Time]], [[Sequential Loops]], [[Quadratic Time]], and [[Logarithmic Time]].

---

## Why We Use Asymptotic Notation

> [!note] The Core Idea
> **[[Time Complexity]]** measures how an algorithm's runtime scales, not its runtime in literal seconds. Measuring seconds is unreliable because faster hardware finishes sooner, so the same algorithm would appear to have different "speeds" on different machines. **[[Asymptotic Notation]]** solves this by describing growth trends as input size approaches infinity, independent of hardware.

---

## The Three Notations

| Notation                              | Bound Type  | Meaning                                                                                                                                                                                                                                          |
| ------------------------------------- | ----------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **[[Big O Notation]]** ($O$)          | Upper bound | *Worst-case* scenario, the longest an algorithm could take                                                                                                                                                                                       |
| **[[Big Omega Notation]]** ($\Omega$) | Lower bound | *Best-case* scenario, the fastest an algorithm could run                                                                                                                                                                                         |
| **[[Big Theta Notation]]** ($\Theta$) | Tight bound | Big Theta gives you the exact rate. It means the program's speed will consistently scale at this precise pace. no faster, no slower. In simple terms, it tells you exactly how a computer program's running time grows as the workload increases |

---

## Calculating Big O: Rules and Examples

> [!note] The Golden Rule
> Add up the time for each line, then drop constants and lower-order terms, since they stop mattering as input size grows toward infinity.

### 1. Constant Time: $O(1)$

Simple steps like variable assignment, printing, or returning a value take the same time regardless of input size.

```java
class Main {
    public static void main(String[] args) {
        int n = 10;             // O(1) time
        System.out.println(n);  // O(1) time
    }
}
```

**Calculation:** $O(1) + O(1) + O(1) = O(3)$. Since $3$ is a fixed constant, it is dropped. The final complexity is $O(1)$.

---

### 2. Linear Time: $O(n)$

A loop that runs $n$ times has a runtime that grows exactly as fast as $n$.

```java
class Main {
    public static void main(String[] args) {
        int n = 10;

        for (int i = 1; i <= n; i++) {        // Loop runs n times
            System.out.println(n);            // O(1) operation inside an O(n) loop
        }
    }
}
```

**Calculation:** $O(1) + O(n)$. Since $O(n)$ dominates as $n$ grows, the constant $O(1)$ is dropped. The final complexity is $O(n)$.

---

### 3. Sequential Loops: $O(n + m)$

Two separate loops over different variables, run one after another, have their complexities **added**.

```java
class Main {
    public static void main(String[] args) {
        int n = 10;
        int m = 5;

        // First loop relies on n
        for (int i = 1; i <= n; i++) {        // O(n)
            System.out.println(n);
        }

        // Second loop relies on m
        for (int j = 1; j <= m; j++) {        // O(m)
            System.out.println(m);
        }
    }
}
```

**Calculation:** $O(n) + O(m) = O(n + m)$.

---

### 4. Quadratic Time (Nested Loops): $O(n^2)$

A loop nested inside another loop **multiplies** their complexities, rather than adding them.

```java
class Main {
    public static void main(String[] args) {
        int n = 10;

        // Outer loop runs n times
        for (int i = 1; i <= n; i++) {
            System.out.println(n);

            // Inner loop runs n times FOR EACH outer iteration
            for (int j = 1; j <= n; j++) {
                // ...
            }
        }
    }
}
```

**Calculation:** $O(n) \times O(n) = O(n^2)$.

---

### 5. Logarithmic Time: $O(\log n)$

This occurs when the loop counter is multiplied or divided at each step, rather than incremented by a fixed amount. This sharply reduces the number of iterations needed, even for very large $n$. It appears frequently in [[Divide and Conquer]] algorithms such as [[Binary Search]].

```java
class Main {
    public static void main(String[] args) {
        int n = 1000;

        for (int i = 1; i < n; i = i * 2) {   // i doubles each step
            System.out.println(i);
        }
    }
}
```

**Calculation:** The loop counter doubles every iteration, so the number of iterations is roughly $\log_2 n$. The final complexity is $O(\log n)$.

---

## Growth Rate Comparison

~~~mermaid
graph LR
    A[Input Size n Grows] --> B["O(1) — Constant"]
    A --> C["O(log n) — Logarithmic"]
    A --> D["O(n) — Linear"]
    A --> E["O(n + m) — Sequential"]
    A --> F["O(n^2) — Quadratic"]

    B -.->|slowest growth| G[Best Performance]
    F -.->|fastest growth| H[Worst Performance]
~~~

---

