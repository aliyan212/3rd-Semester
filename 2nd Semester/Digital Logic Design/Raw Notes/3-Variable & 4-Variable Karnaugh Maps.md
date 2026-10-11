---
cssclasses: logic-notes
tags:
  - digital-logic
  - k-maps
  - exam-prep
---

# Karnaugh Maps: 3-Variable & 4-Variable Minimization

> [!abstract] Core Concepts
> Multi-variable K-Maps extend single-variable minimization to larger truth spaces using a 2D **[[Gray Code]]** grid.
> * **3-Variable Map:** $2^3 = \mathbf{8\text{ cells}}$ ($2 \times 4$ layout).
> * **4-Variable Map:** $2^4 = \mathbf{16\text{ cells}}$ ($4 \times 4$ layout).
> * **Toroidal Wrap-around (Map Rolling):** The outer edges (left $\leftrightarrow$ right, top $\leftrightarrow$ bottom) are logically adjacent and form valid grouping loops.

---

## 1. 3-Variable K-Map

> [!warning] Gray Code Column Swap
> Due to Gray Code sequencing ($00 \to 01 \to 11 \to 10$), minterm order skips columns:
> * Row 0: $m_0 \to m_1 \to \mathbf{m_3} \to \mathbf{m_2}$
> * Row 1: $m_4 \to m_5 \to \mathbf{m_7} \to \mathbf{m_6}$

### Grid Layout

| $A \backslash BC$ | $00\ (\bar{B}\bar{C})$ | $01\ (\bar{B}C)$ | $11\ (BC)$ | $10\ (B\bar{C})$ |
| :---: | :---: | :---: | :---: | :---: |
| **$0\ (\bar{A})$** | $m_0$ | $m_1$ | $m_3$ | $m_2$ |
| **$1\ (A)$** | $m_4$ | $m_5$ | $m_7$ | $m_6$ |

---

### Example 1: 3-Variable SOP
Simplify $F(A, B, C) = \Sigma m(0, 1, 6, 7)$

| $A \backslash BC$ | $00$ | $01$ | $11$ | $10$ |
| :---: | :---: | :---: | :---: | :---: |
| **$0$** | **$1$** | **$1$** | $0$ | $0$ |
| **$1$** | $0$ | $0$ | **$1$** | **$1$** |

* **Group 1 ($m_0, m_1$):** $C$ toggles ($0 \to 1$) $\implies$ drops $C$. Retains **$\bar{A}\bar{B}$**.
* **Group 2 ($m_6, m_7$):** $C$ toggles ($1 \to 0$) $\implies$ drops $C$. Retains **$AB$**.

$$\mathbf{F = \bar{A}\bar{B} + AB}$$

---

### Example 2: 3-Variable POS (Grouping 0s)
Simplify $f(A,B,C) = \Pi M(1,2,3,6,7)$

| $A \backslash BC$ | $00\ (B+C)$ | $01\ (B+\bar{C})$ | $11\ (\bar{B}+\bar{C})$ | $10\ (\bar{B}+C)$ |
| :---: | :---: | :---: | :---: | :---: |
| **$0\ (A)$** | $1$ | **$0$** | **$0$** | **$0$** |
| **$1\ (\bar{A})$** | $1$ | $1$ | **$0$** | **$0$** |

* **Group 1 (Quad — $M_2, M_3, M_6, M_7$):** Both $A$ and $C$ change state $\implies$ leaves **$\bar{B}$**.
* **Group 2 (Pair — $M_1, M_3$):** $B$ changes state $\implies$ leaves **$(A + \bar{C})$**.

$$\mathbf{f = \bar{B} \cdot (A + \bar{C})}$$

---

## 2. 4-Variable K-Map

> [!tip] Wrap-around Adjacency Rules
> * **Corners:** All $4$ corners ($m_0, m_2, m_8, m_{10}$) group to eliminate $2$ variables.
> * **Edge Rolling:** Far-left column wraps to far-right column; top row wraps to bottom row.

### Grid Layout

| $AB \backslash CD$ | $00$ | $01$ | $11$ | $10$ |
| :---: | :---: | :---: | :---: | :---: |
| **$00$** | $m_0$ | $m_1$ | $m_3$ | $m_2$ |
| **$01$** | $m_4$ | $m_5$ | $m_7$ | $m_6$ |
| **$11$** | $m_{12}$ | $m_{13}$ | $m_{15}$ | $m_{14}$ |
| **$10$** | $m_8$ | $m_9$ | $m_{11}$ | $m_{10}$ |

---

### Example: 4-Variable SOP with Don't Cares
Simplify $F(A, B, C, D) = \Sigma m(0, 2, 8, 10, 14) + \Sigma d(5, 15)$

| $AB \backslash CD$ | $00$ | $01$ | $11$ | $10$ |
| :---: | :---: | :---: | :---: | :---: |
| **$00$** | **$1$** | $0$ | $0$ | **$1$** |
| **$01$** | $0$ | $\mathbf{X}$ | $0$ | $0$ |
| **$11$** | $0$ | $0$ | $\mathbf{X}$ | **$1$** |
| **$10$** | **$1$** | $0$ | $0$ | **$1$** |

* **Group 1 (Four Corners — $m_0, m_2, m_8, m_{10}$):**
  * $A$ changes ($0 \to 1$), $C$ changes ($0 \to 1$).
  * Retains **$\bar{B}\bar{D}$**.
* **Group 2 (Vertical Pair — $m_{14}, d_{15}$):**
  * Uses $d_{15}\ (X)$ to complete an adjacent pair with $m_{14}$.
  * $D$ changes ($1 \to 0$).
  * Retains **$AC$** (or $AC\bar{D}$ if grouped with $m_{14}$ along column).
* **Unused Terms:** $d_5\ (X)$ is left unselected to prevent redundant terms.

$$\mathbf{F = \bar{B}\bar{D} + AC\bar{D}}$$