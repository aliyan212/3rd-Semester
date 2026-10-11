---
cssclasses: logic-notes
tags:
  - digital-logic
  - combinational-logic
  - encoders
  - priority-encoders
  - exam-prep
---

# Binary Encoders & Priority Encoders

> [!abstract] Core Concepts
> An **[[Encoders | Encoder]]** is a combinational logic circuit that performs the inverse operation of a decoder.
> * **Architecture:** Converts $2^n$ input lines into an $n$-bit coded output ($2^n \to n$).
> * **Standard Operation Assumption:** Assumes exactly *one* input line is logic $1$ at any given moment.
> * **Output Value:** Generates the binary representation of the subscript index of the currently active input line.

---

## 1. 8-to-3 Standard Binary Encoder

> [!info] Structure
> * **Inputs:** $8$ data lines ($D_0 - D_7$)
> * **Outputs:** $3$ binary lines ($A_2, A_1, A_0$)

### Truth Table

| $D_7$ | $D_6$ | $D_5$ | $D_4$ | $D_3$ | $D_2$ | $D_1$ | $D_0$ | $A_2$ | $A_1$ | $A_0$ | Active Input |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | **$1$** | $0$ | $0$ | $0$ | $D_0$ |
| $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | **$1$** | $0$ | $0$ | $0$ | $1$ | $D_1$ |
| $0$ | $0$ | $0$ | $0$ | $0$ | **$1$** | $0$ | $0$ | $0$ | $1$ | $0$ | $D_2$ |
| $0$ | $0$ | $0$ | $0$ | **$1$** | $0$ | $0$ | $0$ | $0$ | $1$ | $1$ | $D_3$ |
| $0$ | $0$ | $0$ | **$1$** | $0$ | $0$ | $0$ | $0$ | $1$ | $0$ | $0$ | $D_4$ |
| $0$ | $0$ | **$1$** | $0$ | $0$ | $0$ | $0$ | $0$ | $1$ | $0$ | $1$ | $D_5$ |
| $0$ | **$1$** | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | $1$ | $1$ | $0$ | $D_6$ |
| **$1$** | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | $1$ | $1$ | $1$ | $D_7$ |

### Boolean Expressions

$$\begin{aligned}
A_0 &= D_1 + D_3 + D_5 + D_7 \\
A_1 &= D_2 + D_3 + D_6 + D_7 \\
A_2 &= D_4 + D_5 + D_6 + D_7
\end{aligned}$$

![[8-to-3 Encoder Circuit.png]]

---

## 2. Limitations of Standard Encoders

> [!danger] Fatal Design Flaws in Standard Encoders
> 1. **Multiple Active Inputs:** If two or more inputs are active simultaneously (e.g., $D_3 = 1$ and $D_6 = 1$), the OR gates produce $A_2A_1A_0 = 111_2$ (Binary $7$), which is incorrect for both active inputs.
> 2. **Ambiguous All-Zero State:** If all inputs are $0$, the output defaults to $000_2$. This is completely indistinguishable from the valid case where $D_0$ is active ($D_0 = 1 \implies 000_2$).

---

## 3. The Priority Encoder

> [!tip] Priority Logic Solutions
> A **[[Priority Encoder]]** addresses both flaws directly:
> * **Priority Arbitration:** If multiple inputs are high, it encodes only the active input with the **highest subscript index**.
> * **Valid Bit ($V$):** An auxiliary output flag indicating circuit activity ($V = 1$ when at least one input is active; $V = 0$ when all inputs are inactive).

---

### 4-to-2 Priority Encoder

> [!note] Highest Priority Scheme: $D_3 > D_2 > D_1 > D_0$
> Any active high-order input makes all lower-order inputs **"Don't Cares" ($X$)**, collapsing the 16-row truth table into 5 rows.

#### Condensed Truth Table

| $D_3$ | $D_2$ | $D_1$ | $D_0$ | $A_1$ | $A_0$ | $V\ (\text{Valid Bit})$ | Active Selection |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| $0$ | $0$ | $0$ | $0$ | $X$ | $X$ | **$0$** | None (Idle) |
| $0$ | $0$ | $0$ | **$1$** | $0$ | $0$ | **$1$** | $D_0$ |
| $0$ | $0$ | **$1$** | $X$ | $0$ | $1$ | **$1$** | $D_1$ |
| $0$ | **$1$** | $X$ | $X$ | $1$ | $0$ | **$1$** | $D_2$ |
| **$1$** | $X$ | $X$ | $X$ | $1$ | $1$ | **$1$** | $D_3$ |

---

### K-Map Minimized Logic Equations

$$\begin{aligned}
A_0 &= D_3 + D_1\bar{D}_2 \\
A_1 &= D_2 + D_3 \\
V   &= D_0 + D_1 + D_2 + D_3
\end{aligned}$$