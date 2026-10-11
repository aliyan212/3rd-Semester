---
cssclasses: logic-notes
tags:
  - digital-logic
  - boolean-algebra
  - absorption-law
  - duality-principle
  - exam-prep
---

# Boolean Algebra: Absorption Law, Algebraic Simplification & Duality

> [!abstract] Core Concept
> Boolean simplification minimizes the literal count and gate complexity of logic circuits using algebraic reduction axioms and dual mappings.
> * **Absorption Law:** Redundant complement literals embedded in product/sum terms are eliminated directly.
> * **Duality Principle:** Every valid Boolean algebraic identity remains universally true when operators and identity elements are systematically inverted.

---

## 1. The Absorption Law

> [!tip] Shortcut Axioms
> When a term contains an ORed literal alongside an ANDed term holding its exact complement, the complemented literal drops out completely.

$$\begin{aligned}
x + \bar{x}y &= x + y \\
\bar{x} + xy &= \bar{x} + y
\end{aligned}$$

---

## 2. Algebraic Simplification Examples

### Problem 1: Factoring & Identity Elements
Simplify $f(x,y) = x\bar{y} + \bar{x}y + xy + \bar{x}\bar{y}$

$$\begin{aligned}
f(x,y) &= x\bar{y} + \bar{x}y + xy + \bar{x}\bar{y} \\
&= \bar{y}(x + \bar{x}) + y(\bar{x} + x) && \text{(Rearrange and factor out } \bar{y} \text{ and } y\text{)} \\
&= \bar{y}(1) + y(1) && \text{(Apply: } x + \bar{x} = 1\text{)} \\
&= \bar{y} + y \\
&= \mathbf{1} && \text{(Apply: } y + \bar{y} = 1\text{)}
\end{aligned}$$

---

### Problem 2: Distribution & Idempotent Laws
Simplify $A[B + C(AB + AC)]$

$$\begin{aligned}
E &= A[B + C(AB + AC)] \\
&= A[B + ABC + ACC] && \text{(Distribute } C\text{)} \\
&= A[B + ABC + AC] && \text{(Apply: } C \cdot C = C\text{)} \\
&= A[B(1 + AC) + AC] && \text{(Factor out } B\text{ from first two terms)} \\
&= A[B(1) + AC] && \text{(Apply: } 1 + AC = 1\text{)} \\
&= AB + AAC && \text{(Distribute outer } A\text{)} \\
&= AB + AC && \text{(Apply: } A \cdot A = A\text{)} \\
&= \mathbf{A(B + C)} && \text{(Factor out } A\text{ for minimal form)}
\end{aligned}$$

---

### Problem 3: Multi-Variable Reduction with Absorption
Simplify $\bar{A}BC + A\bar{B}\bar{C} + \bar{A}\bar{B}\bar{C} + A\bar{B}C + ABC$

$$\begin{aligned}
E &= \bar{A}BC + A\bar{B}\bar{C} + \bar{A}\bar{B}\bar{C} + A\bar{B}C + ABC \\
&= BC(\bar{A} + A) + \bar{B}\bar{C}(A + \bar{A}) + A\bar{B}C && \text{(Group and factor } BC \text{ and } \bar{B}\bar{C}\text{)} \\
&= BC(1) + \bar{B}\bar{C}(1) + A\bar{B}C && \text{(Apply: } A + \bar{A} = 1\text{)} \\
&= BC + \bar{B}\bar{C} + A\bar{B}C \\
&= BC + \bar{B}(\bar{C} + AC) && \text{(Factor out } \bar{B}\text{ from last two terms)} \\
&= BC + \bar{B}(\bar{C} + A) && \text{(Apply Absorption: } \bar{C} + AC = \bar{C} + A\text{)} \\
&= \mathbf{BC + \bar{B}\bar{C} + A\bar{B}} && \text{(Distribute } \bar{B}\text{)}
\end{aligned}$$

---

## 3. The Duality Principle

> [!info] Dual Conversion Operator Map
> | Original Element | Dual Replacement |
> | :---: | :---: |
> | $\text{AND } (\cdot)$ | $\text{OR } (+)$ |
> | $\text{OR } (+)$ | $\text{AND } (\cdot)$ |
> | $\mathbf{1}$ | $\mathbf{0}$ |
> | $\mathbf{0}$ | $\mathbf{1}$ |

> [!warning] Invariant Literals Rule
> Variables and their complements do **not** change during dual conversion. $A$ remains $A$, and $\bar{A}$ remains $\bar{A}$.

### Proof of Dual Identity

* **Original Boolean Identity:**
  $$A + AB = A$$
* **Dual Expression:**
  $$A \cdot (A + B) = A$$

**Algebraic Proof:**
$$\begin{aligned}
\text{LHS} &= A(A + B) \\
&= AA + AB && \text{(Distributive Law)} \\
&= A + AB && \text{(Idempotent Law: } AA = A\text{)} \\
&= \mathbf{A} && \text{(Absorption Axiom: } A + AB = A = \text{RHS)}
\end{aligned}$$