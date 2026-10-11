---
cssclasses: logic-notes
tags:
  - digital-logic
  - binary-arithmetic
  - computer-architecture
  - exam-prep
---

# Binary Arithmetic & Signed Complements

> [!abstract] Core Concept
> Binary mathematics forms the operational foundation of digital systems and [[Arithmetic Logic Units (ALU)]].
> * **Subtraction:** Relies on a borrow mechanism where borrowing $1$ from the left equals $(10)_2 = 2_{10}$.
> * **Multiplication:** Operates identically to a logical **[[AND Gate]]** (produces $1$ only when both inputs are $1$).
> * **Sign Representation:** The **Most Significant Bit (MSB)** indicates polarity: `0 = Positive`, `1 = Negative`.

---

## 1. Basic Arithmetic Operations

### A. Addition Rules

> [!tip] Carry Rule
> Binary addition carries over at base $2$ ($(10)_2$) rather than base $10$.

$$\begin{aligned}
0 + 0 &= 0 \\
0 + 1 &= 1 \\
1 + 0 &= 1 \\
1 + 1 &= 10 \quad &&\text{(Sum: } 0\text{, Carry: } 1\text{)} \\
1 + 1 + 1 &= 11 \quad &&\text{(Sum: } 1\text{, Carry: } 1\text{)}
\end{aligned}$$

---

### B. Subtraction Rules

$$\begin{aligned}
0 - 0 &= 0 \\
0 - 1 &= 1 \quad &&\text{(with a borrow of } 1\text{ from the next column)} \\
1 - 0 &= 1 \\
1 - 1 &= 0
\end{aligned}$$

---

### C. Multiplication Rules

$$\begin{aligned}
0 \times 0 &= 0 \\
0 \times 1 &= 0 \\
1 \times 0 &= 0 \\
1 \times 1 &= 1
\end{aligned}$$

---

### D. Binary Long Division

> [!note] Algorithm
> **Divide $\to$ Multiply $\to$ Subtract $\to$ Bring down**
> 1. If $\text{Divisor} \le \text{Current Dividend}$, quotient bit $= 1$; subtract divisor and bring down next bit.
> 2. If $\text{Divisor} > \text{Current Dividend}$, quotient bit $= 0$; bring down next bit and repeat.

#### Example 1: $1001_2 \div 11_2$
$$\begin{array}{ll}
& \phantom{00} 11 \quad \mathbf{\text{(Quotient)}} \\
\hline
11) & 1001 \\
& -11 \downarrow \\
\hline
& \phantom{0} 011 \\
& \phantom{0} -11 \\
\hline
& \phantom{000} \mathbf{0} \quad \mathbf{\text{(Remainder)}}
\end{array}$$

#### Example 2: $101101_2 \div 110_2$
$$\begin{array}{ll}
& \phantom{000} 111 \quad \mathbf{\text{(Quotient)}} \\
\hline
110) & 101101 \\
& -110 \downarrow \downarrow \\
\hline
& \phantom{0} 1010 \\
& -110 \downarrow \\
\hline
& \phantom{00} 1001 \\
& \phantom{0} -110 \\
\hline
& \phantom{000} \mathbf{011} \quad \mathbf{\text{(Remainder)}}
\end{array}$$

---

## 2. Complements & Signed Representation

> [!info] 2's Complement Conversion Rule
> To convert a positive binary number to its negative equivalent:
> 1. **1's Complement:** Invert all bits ($0 \to 1$, $1 \to 0$).
> 2. **2's Complement:** Add $1$ to the Least Significant Bit (LSB).

### Binary 2's Complement Example (5-bit System: $-7$)
$$\begin{aligned}
+7 &= 00111_2 \\
\text{1's Complement} &= 11000_2 \\
\text{2's Complement } (-7) &= 11000_2 + 1 = \mathbf{11001_2}
\end{aligned}$$

### Base-8 (Octal) 8's Complement Example ($7263_8$)
$$\begin{aligned}
\text{7's Complement} &= 7777_8 - 7263_8 = 0514_8 \\
\text{8's Complement} &= 0514_8 + 1 = \mathbf{0515_8}
\end{aligned}$$

---

## 3. Fixed Bit-Length 2's Complement Arithmetic

> [!warning] Fixed-Width Overflow Rule
> In fixed bit-width arithmetic (e.g., $5$-bit system), any carry bit generated beyond the fixed length is **strictly discarded**. The remaining MSB dictates whether the result is positive ($0$) or negative ($1$).

| Scenario                |  Expression   |          Operation (5-bit)          |          Carry Bit           |             Result              |
| :---------------------- | :-----------: | :---------------------------------: | :--------------------------: | :-----------------------------: |
| **Both Negative**       | $(-7) + (-4)$ | $11001 + 11100 = \cancel{1}\ 10101$ | Discarded ($6\text{th}$ bit) | $\mathbf{-11}\ (\text{MSB } 1)$ |
| **Positive > Negative** | $(+7) + (-4)$ | $00111 + 11100 = \cancel{1}\ 00011$ | Discarded ($6\text{th}$ bit) | $\mathbf{+3}\ (\text{MSB } 0)$  |
| **Negative > Positive** | $(+4) + (-7)$ |       $00100 + 11001 = 11101$       |        None generated        | $\mathbf{-3}\ (\text{MSB } 1)$  |