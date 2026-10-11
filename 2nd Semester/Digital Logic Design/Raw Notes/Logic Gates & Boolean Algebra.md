## 1. Classification of Logic Gates

**Theory:**

Logic gates are the physical hardware building blocks of digital circuits. They can be broadly classified into three categories, and circuits built from them are either **Combinational** (output depends only on current input) or **Sequential** (output depends on current input and past states/memory).

- **Basic Gates:** AND, OR, NOT

- **Universal Gates:** NAND, NOR (Called "universal" because you can build any other gate using only these).

- **Arithmetic / Derived Gates:** XOR (Exclusive-OR), XNOR (Exclusive-NOR).

---

## 2. Logic Gate Truth Tables

**Theory:**

A truth table defines the output behavior of a logic gate for every possible combination of inputs. In Boolean addition, remember that $1 + 1 = 1$ (because 1 represents "True" or "High voltage", and True + True is still True).

**Basic & Universal Gates:**

$$\begin{array}{cc|cc|cc} \text{Inputs} & & \text{AND} & \text{OR} & \text{NAND} & \text{NOR} \\ A & B & y = A \cdot B & y = A + B & y = \overline{A \cdot B} & y = \overline{A + B} \\ \hline 0 & 0 & 0 & 0 & 1 & 1 \\ 0 & 1 & 0 & 1 & 1 & 0 \\ 1 & 0 & 0 & 1 & 1 & 0 \\ 1 & 1 & 1 & 1 & 0 & 0 \end{array}$$

**Arithmetic Gates:**

$$\begin{array}{cc|cc} \text{Inputs} & & \text{XOR} & \text{XNOR} \\ A & B & y = A \oplus B & y = \overline{A \oplus B} \\ \hline 0 & 0 & 0 & 1 \\ 0 & 1 & 1 & 0 \\ 1 & 0 & 1 & 0 \\ 1 & 1 & 0 & 1 \end{array}$$

---

## 3. Boolean Algebra Fundamentals

**Theory:**

Boolean algebra is the mathematics of digital logic. Instead of standard numbers, it uses binary variables to represent logical states.

- **Variable:** A symbol used to represent a logical quantity (e.g., $A, B, C, x, y, z$).

- **Complement:** The exact inverse of a variable, denoted by a bar over the letter (e.g., $\overline{A}, \overline{B}, \overline{C}$).

- **Literal:** A variable or its complement (both $A$ and $\overline{A}$ are literals).

### The Three Basic Laws

$$\begin{aligned} \text{Commutative Law:} \quad & A + B = B + A \\ & A \cdot B = B \cdot A \\ \\ \text{Associative Law:} \quad & A + (B + C) = (A + B) + C \\ & A \cdot (B \cdot C) = (A \cdot B) \cdot C \\ \\ \text{Distributive Law:} \quad & X \cdot (Y + Z) = XY + XZ \\ & A + BC = (A + B)(A + C) \end{aligned}$$

---

## 4. Boolean Rules & Identities

**Theory:**

These 12 rules are the shortcuts you need to simplify complex digital circuits. Memorizing these will save you massive amounts of time when minimizing logic expressions.

$$\begin{array}{ll} 1. \quad A + 0 = A & 7. \quad A \cdot A = A \\ 2. \quad A + 1 = 1 & 8. \quad A \cdot \overline{A} = 0 \\ 3. \quad A \cdot 0 = 0 & 9. \quad \overline{\overline{A}} = A \\ 4. \quad A \cdot 1 = A & 10. \quad A + AB = A \\ 5. \quad A + A = A & 11. \quad A + \overline{A}B = A + B \\ 6. \quad A + \overline{A} = 1 & 12. \quad (A + B)(A + C) = A + BC \end{array}$$

---

## 5. Boolean Proofs

**Theory:**

We can prove complex Boolean rules by breaking them down algebraically using the basic identities listed above.

**(Proof 1: Distributive Rule Expansion)**

$$\begin{aligned} (A+B)(A+C) &= AA + AC + AB + BC \quad && \text{(Standard multiplication)} \\ &= A + AC + AB + BC \quad && \text{(Apply Rule 7: } AA = A\text{)} \\ &= A(1+C) + AB + BC \quad && \text{(Factor out } A\text{)} \\ &= A(1) + AB + BC \quad && \text{(Apply Rule 2: } 1+C = 1\text{)} \\ &= A(1+B) + BC \quad && \text{(Factor out } A \text{ again)} \\ &= A(1) + BC \quad && \text{(Apply Rule 2: } 1+B = 1\text{)} \\ &= A + BC \quad && \textbf{(Proved)} \end{aligned}$$

**(Proof 2: Rule 11)**

$$\begin{aligned} A + \overline{A}B &= A \cdot A + AB + \overline{A}B \quad && \text{(Expand } A \text{ into } A \cdot A + AB\text{)} \\ &= A \cdot A + AB + A\overline{A} + \overline{A}B \quad && \text{(Add } A\overline{A}\text{, which equals } 0\text{)} \\ &= A(A+B) + \overline{A}(A+B) \quad && \text{(Factor } A \text{ from first pair, } \overline{A} \text{ from second)} \\ &= (A+\overline{A})(A+B) \quad && \text{(Combine terms)} \\ &= 1 \cdot (A+B) \quad && \text{(Apply Rule 6: } A+\overline{A} = 1\text{)} \\ &= A + B \quad && \textbf{(Proved)} \end{aligned}$$

---
