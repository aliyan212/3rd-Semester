## 1. The Half Adder

**Theory:** A half adder is a combinational circuit that adds two single-bit binary numbers ($A$ and $B$). It has two outputs: the **Sum ($S$)** and the **Carry ($C$)**. It is called a "half" adder because it cannot accept a carry-in from a previous addition.

**Truth Table:**

$$\begin{array}{cc|cc} \text{Inputs} & & \text{Outputs} & \\ A & B & S \text{ (Sum)} & C \text{ (Carry)} \\ \hline 0 & 0 & 0 & 0 \\ 0 & 1 & 1 & 0 \\ 1 & 0 & 1 & 0 \\ 1 & 1 & 0 & 1 \end{array}$$

### K-Map Simplification for Half Adder

**For Sum ($S$):**

Notice the checkerboard pattern. The `1`s cannot be grouped, which is the classic signature of an XOR gate.

$$\begin{array}{c|cc} A \backslash B & 0 & 1 \\ \hline 0 & 0 & \mathbf{1} \\ 1 & \mathbf{1} & 0 \end{array}$$

- **Sum Equation:** $S = \bar{A}B + A\bar{B} = \mathbf{A \oplus B}$
    

**For Carry ($C$):**

$$\begin{array}{c|cc} A \backslash B & 0 & 1 \\ \hline 0 & 0 & 0 \\ 1 & 0 & \mathbf{1} \end{array}$$

- **Carry Equation:** $C = \mathbf{AB}$

### Circuit Diagram for Half Adder

![[Half Adder Circuit Diagram 1.png|339]]  
S=XY'+X'Y
C=XY

**OR**

![[Half Adder Circuit Diagram 2.png|329]]
S = X ⊕ Y
C=XY

## 2. The Full Adder

**Theory:**

A full adder improves upon the half adder by adding three single-bit numbers: $A$, $B$, and a **Carry-In ($C_{in}$)** from a previous less-significant bit stage. This is the building block needed to add multi-bit binary numbers.

**Truth Table:**

$$\begin{array}{ccc|cc} \text{Inputs} & & & \text{Outputs} & \\ A & B & C_{in} & S \text{ (Sum)} & C_{out} \text{ (Carry Out)} \\ \hline 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 1 & 0 \\ 0 & 1 & 0 & 1 & 0 \\ 0 & 1 & 1 & 0 & 1 \\ 1 & 0 & 0 & 1 & 0 \\ 1 & 0 & 1 & 0 & 1 \\ 1 & 1 & 0 & 0 & 1 \\ 1 & 1 & 1 & 1 & 1 \end{array}$$

### K-Map Simplification for Full Adder

**For Sum ($S$):**

Again, a perfect 3-variable checkerboard. No groupings are possible.

$$\begin{array}{c|cccc} A \backslash BC_{in} & 00 & 01 & 11 & 10 \\ \hline 0 & 0 & \mathbf{1} & 0 & \mathbf{1} \\ 1 & \mathbf{1} & 0 & \mathbf{1} & 0 \end{array}$$

- **Sum Equation:** $S = \bar{A}\bar{B}C_{in} + \bar{A}B\bar{C}_{in} + A\bar{B}\bar{C}_{in} + ABC_{in} = \mathbf{A \oplus B \oplus C_{in}}$
    

**For Carry-Out ($C_{out}$):**

Here we can form three separate groups of two.

$$\begin{array}{c|cccc} A \backslash BC_{in} & 00 & 01 & 11 & 10 \\ \hline 0 & 0 & 0 & \mathbf{1} & 0 \\ 1 & 0 & \mathbf{1} & \mathbf{1} & \mathbf{1} \end{array}$$

- **Carry-Out Equation:** $C_{out} = \mathbf{AB + BC_{in} + AC_{in}}$

### Circuit Diagram for Full Adder

![[Full Adder Circuit Diagram.png|440]]  
$S =A'B'C_{in}+ABC_{in}+AB'C_{in}+A'BC_{in}$
$C =BC_{in}+AB_{in}+AC_{in}$

---

## 3. The Half Subtractor

**Theory:**

A half subtractor performs $A - B$. It produces a **Difference ($D$)** and a **Borrow ($B_{out}$)**. The borrow is triggered (set to 1) only when you try to subtract 1 from 0.

**Truth Table:**

$$\begin{array}{cc|cc} \text{Inputs} & & \text{Outputs} & \\ A & B & D \text{ (Difference)} & B_{out} \text{ (Borrow)} \\ \hline 0 & 0 & 0 & 0 \\ 0 & 1 & 1 & 1 \\ 1 & 0 & 1 & 0 \\ 1 & 1 & 0 & 0 \end{array}$$

### K-Map Simplification for Half Subtractor

**For Difference ($D$):**

Identical to the Half Adder Sum!

$$\begin{array}{c|cc} A \backslash B & 0 & 1 \\ \hline 0 & 0 & \mathbf{1} \\ 1 & \mathbf{1} & 0 \end{array}$$

- **Difference Equation:** $D = \bar{A}B + A\bar{B} = \mathbf{A \oplus B}$
    

**For Borrow ($B_{out}$):**

$$\begin{array}{c|cc} A \backslash B & 0 & 1 \\ \hline 0 & 0 & \mathbf{1} \\ 1 & 0 & 0 \end{array}$$

- **Borrow Equation:** $B_{out} = \mathbf{\bar{A}B}$

### Circuit Diagram for Half Subtractor

![[Half Subtractor Circuit Diagram 1.png|339]]  

**OR**

   **A       B**
![[Half Subtractor Circuit Diagram 2.png|329]]


---

## 4. The Full Subtractor

**Theory:**

A full subtractor performs $(A - B - B_{in})$, taking into account a **Borrow-In ($B_{in}$)** requested by a previous, less-significant stage.

**Truth Table:**

$$\begin{array}{ccc|cc} \text{Inputs} & & & \text{Outputs} & \\ A & B & B_{in} & D \text{ (Difference)} & B_{out} \text{ (Borrow Out)} \\ \hline 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 1 & 1 \\ 0 & 1 & 0 & 1 & 1 \\ 0 & 1 & 1 & 0 & 1 \\ 1 & 0 & 0 & 1 & 0 \\ 1 & 0 & 1 & 0 & 0 \\ 1 & 1 & 0 & 0 & 0 \\ 1 & 1 & 1 & 1 & 1 \end{array}$$

### K-Map Simplification for Full Subtractor

**For Difference ($D$):**

Identical to the Full Adder Sum!

$$\begin{array}{c|cccc} A \backslash BB_{in} & 00 & 01 & 11 & 10 \\ \hline 0 & 0 & \mathbf{1} & 0 & \mathbf{1} \\ 1 & \mathbf{1} & 0 & \mathbf{1} & 0 \end{array}$$

- **Difference Equation:** $D = \mathbf{A \oplus B \oplus B_{in}}$
    

**For Borrow-Out ($B_{out}$):**

$$\begin{array}{c|cccc} A \backslash BB_{in} & 00 & 01 & 11 & 10 \\ \hline 0 & 0 & \mathbf{1} & \mathbf{1} & \mathbf{1} \\ 1 & 0 & 0 & \mathbf{1} & 0 \end{array}$$

- **Borrow-Out Equation:** $B_{out} = \mathbf{\bar{A}B + \bar{A}B_{in} + BB_{in}}$

### Circuit Diagram for Full Subtractor

![[Full Subtractor Circuit Diagram.png|440]]  

