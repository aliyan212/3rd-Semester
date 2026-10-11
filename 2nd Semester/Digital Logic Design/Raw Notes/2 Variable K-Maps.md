---
cssclasses: logic-notes
tags:
  - digital-logic
  - k-maps
  - exam-prep
---

# Karnaugh Maps (K-Maps): Fundamentals & 2-Variable Simplification

> [!abstract] Core Concept
> A **[[Karnaugh Map (K-Map)]]** is a visual optimization method used to minimize [[Boolean Algebra]] expressions without manually applying algebraic theorems.
> 
> * **Foundation:** K-Maps rely entirely on **[[Gray Code]]** ($00, 01, 11, 10$).
> * **Mechanism:** Adjacent cells differ by only **$1$ single bit**, ensuring that any variable changing state across a group can be eliminated.

---

## 1. 2-Variable K-Map Layout

> [!note] Cell Capacity Formula
> The total number of cells in any K-Map is given by:
> $$\text{Cells} = 2^n$$
> For a **2-variable map** ($A, B$), $n = 2 \implies 2^2 = \mathbf{4\text{ cells}}$.

### Cell Index Reference

| $A \backslash B$ | $0\ (\bar{B})$ | $1\ (B)$ |
| :---: | :---: | :---: |
| **$0\ (\bar{A})$** | $m_0$ | $m_1$ |
| **$1\ (A)$** | $m_2$ | $m_3$ |

---

## 2. Sum of Products (SOP) Simplification

> [!tip] Grouping Rule (SOP)
> 1. Place a **$1$** in cells corresponding to each active [[Minterms|minterm]].
> 2. Group adjacent $1$s in powers of $2$ ($1, 2, 4, \dots$).
> 3. Eliminate variables that change state within each group.

### Example 1: Standard SOP
Simplify $f(A,B) = \Sigma m(1,2,3)$

| $A \backslash B$ | $0\ (\bar{B})$ | $1\ (B)$ |
| :---: | :---: | :---: |
| **$0\ (\bar{A})$** | $0$ | **$1$** |
| **$1\ (A)$** | **$1$** | **$1$** |

* **Group 1 (Vertical — $m_1, m_3$):** $A$ changes ($0 \to 1$) $\implies$ eliminates $A$. Yields **$B$**.
* **Group 2 (Horizontal — $m_2, m_3$):** $B$ changes ($0 \to 1$) $\implies$ eliminates $B$. Yields **$A$**.

$$\mathbf{F(A,B) = A + B}$$

---

### Example 2: Utilizing "Don't Care" Conditions
Simplify $F(A,B) = \Sigma m(0,2) + d(3)$

> [!warning] Don't Care Conditions ($d$)
> Marked with an **$\mathbf{X}$**. They can be treated as $1$s to form larger groups, or as $0$s if they do not help.

| $A \backslash B$ | $0\ (\bar{B})$ | $1\ (B)$ |
| :---: | :---: | :---: |
| **$0\ (\bar{A})$** | **$1$** | $0$ |
| **$1\ (A)$** | **$1$** | **$X$** |

* **Group 1 (Left Column — $m_0, m_2$):** $A$ changes $\implies$ yields **$\bar{B}$**.
* **Group 2 (Bottom Row — $m_2, d_3$):** $B$ changes $\implies$ uses $X$ as a $1$ to yield **$A$**.

$$\mathbf{F(A,B) = \bar{B} + A}$$

---

## 3. Product of Sums (POS) Simplification

> [!tip] Grouping Rule (POS)
> 1. Place a **$0$** in cells corresponding to each active [[Maxterms|maxterm]].
> 2. Group adjacent $0$s in powers of $2$.
> 3. Variables with value $0$ remain normal; variables with value $1$ are complemented.

### Example: Standard POS
Simplify $f(A,B) = \Pi M(1,2,3)$

| $A \backslash B$ | $0\ (B)$ | $1\ (\bar{B})$ |
| :---: | :---: | :---: |
| **$0\ (A)$** | $1$ | **$0$** |
| **$1\ (\bar{A})$** | **$0$** | **$0$** |

* **Group 1 ($M_1, M_3$):** $A$ changes $\implies$ yields **$\bar{B}$**.
* **Group 2 ($M_2, M_3$):** $B$ changes $\implies$ yields **$\bar{A}$**.

$$\mathbf{f(A,B) = \bar{A} \cdot \bar{B}}$$

---

## 4. Worked Practice Problems

### Problem 1
**Expression:** $\bar{A}\bar{B} + \bar{A}B + AB$  
**Active Minterms:** $m_0\ (00),\ m_1\ (01),\ m_3\ (11)$

| $A \backslash B$ | $0$ | $1$ |
| :---: | :---: | :---: |
| **$0$** | **$1$** | **$1$** |
| **$1$** | $0$ | **$1$** |

* **Top Row ($m_0, m_1$):** $B$ changes $\implies$ keeps **$\bar{A}$**.
* **Right Column ($m_1, m_3$):** $A$ changes $\implies$ keeps **$B$**.

$$\mathbf{\text{Result: } \bar{A} + B}$$

---

### Problem 2
**Expression:** $a\bar{b} + ab$  
**Active Minterms:** $m_2\ (10),\ m_3\ (11)$

| $a \backslash b$ | $0$ | $1$ |
| :---: | :---: | :---: |
| **$0$** | $0$ | $0$ |
| **$1$** | **$1$** | **$1$** |

* **Bottom Row ($m_2, m_3$):** $b$ changes ($0 \to 1$) $\implies$ eliminates $b$; $a$ is constant at $1$.

$$\mathbf{\text{Result: } a}$$