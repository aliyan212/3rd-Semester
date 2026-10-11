## 1. De Morgan's Laws

**Theory:**
De Morgan's Laws provide a mathematical way to break large inversion bars (complements) that cover entire expressions. They are essential for converting NAND and NOR logic into basic AND/OR logic.

- **Law 1 ("Break the line, change the sign"):** The complement of a product is equal to the sum of the complements.
$$\begin{aligned} 1. \quad \overline{x \cdot y} &= \overline{x} + \overline{y} \\\end{aligned}$$
- **Law 2 ("Break the line, change the sign"):** The complement of a sum is equal to the product of the complements.
$$\begin{aligned} 2. \quad \overline{x \text{+} y} &= \overline{x} \cdot \overline{y} \\\end{aligned}$$

---

## 2. Applying De Morgan's Laws (Examples)

**Theory:**
When dealing with complex expressions, treat large groups of variables as a single temporary variable (like $x$ or $y$). Once you split the main bar, you can apply De Morgan's law recursively to the smaller sections.

### Example A: Complex Expansion

Break the expression down step-by-step. First, define your $x$ and $y$ to split the main addition sign.

**Equation:**

$$\begin{aligned} & \overline{(A + B\overline{C}) + D(E + \overline{F})} \\ \text{Let } x &= (A + B\overline{C}) \text{ and } y = D(E + \overline{F}) \\ \\ &= \overline{(A + B\overline{C})} \cdot \overline{D(E + \overline{F})} \quad && \text{(Applied Law 2)} \\ &= (\overline{A + B\overline{C}}) \cdot (\overline{D} + \overline{E + \overline{F}}) \quad && \text{(Applied Law 1 to second term)} \\ &= (\overline{A + B\overline{C}}) \cdot (\overline{D} + \overline{E} \cdot \overline{\overline{F}}) \quad && \text{(Applied Law 2 to inner term)} \\ &= (\overline{A + B\overline{C}}) \cdot (\overline{D} + \overline{E}F) \quad && \text{(Double inversion cancels out)} \end{aligned}$$

### Example B: Sum of Products Inversion

**Equation:**

$$\begin{aligned} & \overline{(A + B + C)D} \\ \text{Let } x &= (A + B + C) \text{ and } y = D \\ \\ &= \overline{(A + B + C)} + \overline{D} \quad && \text{(Applied Law 1)} \\ &= \overline{A}\overline{B}\overline{C} + \overline{D} \quad && \text{(Applied Law 2 to first term)} \end{aligned}$$

### Example C: Grouped Variables

**Equation:**

$$\begin{aligned} & \overline{ABC + DEF} \\ \text{Let } x &= ABC \text{ and } y = DEF \\ \\ &= \overline{ABC} \cdot \overline{DEF} \quad && \text{(Applied Law 2)} \\ &= (\overline{A} + \overline{B} + \overline{C}) \cdot (\overline{D} + \overline{E} + \overline{F}) \quad && \text{(Applied Law 1)} \end{aligned}$$

### Practice Problem 1

**Theory:** Treat the three main chunks ($A\overline{B}$, $\overline{C}D$, and $EF$) as individual terms first. Break the main sum into products, and then apply De Morgan's Law again to break the individual products into sums.

**Equation:**

$$\begin{aligned}
& \overline{A\overline{B} + \overline{C}D + EF} \\
&= \overline{(A\overline{B})} \cdot \overline{(\overline{C}D)} \cdot \overline{(EF)} \quad && \text{(Applied Law 2: Break the main addition signs)} \\
&= (\overline{A} + \overline{\overline{B}}) \cdot (\overline{\overline{C}} + \overline{D}) \cdot (\overline{E} + \overline{F}) \quad && \text{(Applied Law 1 to each product term)} \\
&= (\overline{A} + B)(C + \overline{D})(\overline{E} + \overline{F}) \quad && \text{(Simplified double inversions)}
\end{aligned}$$

---

### Practice Problem 2

**Theory:** This one looks intimidating but is actually the easiest of the three. It is a great test of realizing that a double bar over an entire expression completely cancels out.

**Equation:**

$$\begin{aligned}
& \overline{\overline{(A+B)} + \overline{C}} \\
&= \overline{\overline{(A+B)}} \cdot \overline{\overline{C}} \quad && \text{(Applied Law 2: Break the main addition line)} \\
&= (A+B) \cdot C \quad && \text{(Simplified double inversions)}
\end{aligned}$$

---

### Practice Problem 3

**Theory:** Similar to the first problem, break the main sum into three distinct products first. Be careful to keep parentheses around the $CD$ term when you break its bar so you don't accidentally ruin the order of operations.

**Equation:**

$$\begin{aligned}
& \overline{\overline{A} + B + CD} \\
&= \overline{\overline{A}} \cdot \overline{B} \cdot \overline{CD} \quad && \text{(Applied Law 2: Break the main addition signs)} \\
&= A \cdot \overline{B} \cdot \overline{CD} \quad && \text{(Simplified double inversion on A)} \\
&= A\overline{B}(\overline{C} + \overline{D}) \quad && \text{(Applied Law 1 to break the CD product)}
\end{aligned}$$


---

## 3. Boolean Analysis of Logic Gates

**Theory:**

To build a physical circuit from a Boolean expression , we map the mathematical operators to their corresponding hardware logic gates.

- Addition ($+$) $\rightarrow$ **OR Gate**
    
- Multiplication ($\cdot$) $\rightarrow$ **AND Gate**
    
- Complement ($-$) $\rightarrow$ **NOT Gate (Inverter)**
    
- XOR ($\oplus$) $\rightarrow$ **Exclusive-OR Gate**
 ![[Screenshot_20260314-122632~2.png]]
 
Design: $y = A \cdot (\overline{B} + C)$


![[Screenshot_20260314-122012~2.png]]
