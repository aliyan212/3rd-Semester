---
cssclasses: logic-notes
tags:
  - digital-logic
  - combinational-logic
  - decoders
  - encoders
  - exam-prep
---

# Combinational Modules: Encoders, Decoders & Circuit Implementation

> [!abstract] Core Concepts
> **[[Encoders]]** and **[[Decoders]]** are standard MSI (Medium Scale Integration) combinational logic circuits used for data routing, decoding, and compression.
> * **[[Binary Decoders]]:** Convert an $n$-bit coded input into exactly one active output line among $2^n$ outputs ($n \to 2^n$).
> * **[[Binary Encoders]]:** Perform the inverse operation, converting one active input out of $2^n$ lines into an $n$-bit binary code ($2^n \to n$).
> * **Basic Logic Unit:** Decoder networks are constructed using **[[AND Gate|AND gates]]** because an AND gate outputs $1$ only for its unique matching minterm.

---

## 1. Binary Decoders

### A. 2-to-4 Decoder
A 2-to-4 decoder decodes a 2-bit input ($A_1, A_0$) into 4 active-high outputs ($D_0 - D_3$).

#### Truth Table & Minterm Output

| $A_1$ | $A_0$ | $D_0$ | $D_1$ | $D_2$ | $D_3$ | Active Output Equation |
| :---: | :---: | :---: | :---: | :---: | :---: | :--- |
| $0$ | $0$ | **$1$** | $0$ | $0$ | $0$ | $D_0 = \bar{A}_1\bar{A}_0 = m_0$ |
| $0$ | $1$ | $0$ | **$1$** | $0$ | $0$ | $D_1 = \bar{A}_1A_0 = m_1$ |
| $1$ | $0$ | $0$ | $0$ | **$1$** | $0$ | $D_2 = A_1\bar{A}_0 = m_2$ |
| $1$ | $1$ | $0$ | $0$ | $0$ | **$1$** | $D_3 = A_1A_0 = m_3$ |

---

### B. Decoders with Enable ($EN$) Pin

> [!tip] Enable Pin Operation
> * **$EN = 0$:** The chip is disabled. All outputs are forced to $0$ regardless of inputs.
> * **$EN = 1$:** The chip functions normally according to the selected inputs.

| $EN$ | $A_1$ | $A_0$ | $D_0$ | $D_1$ | $D_2$ | $D_3$ |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| $0$ | $X$ | $X$ | $0$ | $0$ | $0$ | $0$ |
| $1$ | $0$ | $0$ | **$1$** | $0$ | $0$ | $0$ |
| $1$ | $0$ | $1$ | $0$ | **$1$** | $0$ | $0$ |
| $1$ | $1$ | $0$ | $0$ | $0$ | **$1$** | $0$ |
| $1$ | $1$ | $1$ | $0$ | $0$ | $0$ | **$1$** |

$$\begin{aligned}
D_0 &= EN \cdot \bar{A}_1\bar{A}_0 \\
D_1 &= EN \cdot \bar{A}_1A_0 \\
D_2 &= EN \cdot A_1\bar{A}_0 \\
D_3 &= EN \cdot A_1A_0
\end{aligned}$$

---

### C. 3-to-8 Decoder
Takes $3$ inputs ($X, Y, Z$) and generates $8$ unique minterms ($F_0 - F_7$).

| $X$ | $Y$ | $Z$ | Active Output | Boolean Equation |
| :---: | :---: | :---: | :---: | :--- |
| $0$ | $0$ | $0$ | $F_0$ | $F_0 = \bar{X}\bar{Y}\bar{Z} = m_0$ |
| $0$ | $0$ | $1$ | $F_1$ | $F_1 = \bar{X}\bar{Y}Z = m_1$ |
| $0$ | $1$ | $0$ | $F_2$ | $F_2 = \bar{X}Y\bar{Z} = m_2$ |
| $0$ | $1$ | $1$ | $F_3$ | $F_3 = \bar{X}YZ = m_3$ |
| $1$ | $0$ | $0$ | $F_4$ | $F_4 = X\bar{Y}\bar{Z} = m_4$ |
| $1$ | $0$ | $1$ | $F_5$ | $F_5 = X\bar{Y}Z = m_5$ |
| $1$ | $1$ | $0$ | $F_6$ | $F_6 = XY\bar{Z} = m_6$ |
| $1$ | $1$ | $1$ | $F_7$ | $F_7 = XYZ = m_7$ |

---

## 2. Implementing Logic Functions with Decoders

> [!note] Universal Implementation Rule
> Any combinational function with $n$ inputs and $m$ outputs can be built using:
> 1. An **$n$-to-$2^n$ Decoder** (to generate all minterms).
> 2. **$m$ OR Gates** (to sum the active minterms required for each function).

### Example 1: Full Adder Implementation
Inputs: $x, y, z$ (where $z = C_{\text{in}}$). Outputs: $S$ (Sum), $C$ (Carry-out).

| Minterm | $x$ | $y$ | $z$ | $S\ (\text{Sum})$ | $C\ (\text{Carry})$ |
| :---: | :---: | :---: | :---: | :---: | :---: |
| $m_0$ | $0$ | $0$ | $0$ | $0$ | $0$ |
| $m_1$ | $0$ | $0$ | $1$ | **$1$** | $0$ |
| $m_2$ | $0$ | $1$ | $0$ | **$1$** | $0$ |
| $m_3$ | $0$ | $1$ | $1$ | $0$ | **$1$** |
| $m_4$ | $1$ | $0$ | $0$ | **$1$** | $0$ |
| $m_5$ | $1$ | $0$ | $1$ | $0$ | **$1$** |
| $m_6$ | $1$ | $1$ | $0$ | $0$ | **$1$** |
| $m_7$ | $1$ | $1$ | $1$ | **$1$** | **$1$** |

$$\begin{aligned}
S(x,y,z) &= \Sigma m(1, 2, 4, 7) = \bar{x}\bar{y}z + \bar{x}y\bar{z} + x\bar{y}\bar{z} + xyz \\
C(x,y,z) &= \Sigma m(3, 5, 6, 7) = \bar{x}yz + x\bar{y}z + xy\bar{z} + xyz
\end{aligned}$$

---

### Example 2: Analyzing Decoder Output Functions

* **Solving for $F_2$ (OR Gate connected to Pins 12, 13, 14):**
  $$\begin{aligned}
  \text{Pin 12 } (1100_2) &= AB\bar{C}\bar{D} \\
  \text{Pin 13 } (1101_2) &= AB\bar{C}D \\
  \text{Pin 14 } (1110_2) &= ABC\bar{D} \\
  \mathbf{F_2} &= \mathbf{AB\bar{C}\bar{D} + AB\bar{C}D + ABC\bar{D}}
  \end{aligned}$$

* **Solving for $F_3$ (Inverter connected to Pin 15):**
  $$\begin{aligned}
  \text{Pin 15 } (1111_2) &= ABCD \\
  \mathbf{F_3} &= (ABCD)' = \mathbf{\bar{A} + \bar{B} + \bar{C} + \bar{D}} \quad \text{([[De Morgan's Laws]])}
  \end{aligned}$$

---

## 3. Decoder Expansion (Cascading)

> [!tip] Cascading Rule (4-to-16 using two 3-to-8 Decoders)
> * **Data Inputs ($x, y, z$):** Connected in parallel to inputs of both decoders.
> * **Master Select ($w$ - MSB):** Wired to the **$EN$** pins.
>   * $w = 0 \implies$ Top decoder active (handles minterms $m_0 - m_7$).
>   * $w = 1 \implies$ Bottom decoder active (handles minterms $m_8 - m_{15}$).

![[Decoder Expansion.png]]