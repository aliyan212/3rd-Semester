---
cssclasses: logic-notes
tags: #digital-logic #exam-prep
---

# Boolean Algebra: Canonical & Standard Forms

> [!abstract] Core Concept
> Boolean expressions are generally written in one of two fundamental formats:
> * **[[SOP (Sum of Products)]]**: Two or more ANDed terms that are ORed together (e.g., $F = xyz + xy$).
> * **[[POS (Product of Sums)]]**: Two or more ORed terms that are ANDed together (e.g., $F = (A+B)(A+\bar{B}C)$).

---

## 1. Standard (Canonical) Forms

> [!note] Rule of Thumb
> A **Standard Form** means that *every single term* in the expression must contain all the variables present in the domain. 
> * *Example:* If the domain is $A, B, C, D$, the term $A\bar{B}C$ is non-standard because it is missing $D$.

---

## 2. Converting to Standard SOP

> [!tip] Conversion Strategy
> To add a missing variable to an SOP term, multiply the term by $1$. In Boolean algebra, $1 = (X + \bar{X})$ where $X$ is your missing variable.

### Example 1: Adding one missing variable ($D$)
$$\begin{aligned}
A\bar{B}C &= A\bar{B}C \cdot 1 \\
&= A\bar{B}C(D + \bar{D}) \\
&= A\bar{B}CD + A\bar{B}C\bar{D}
\end{aligned}$$

### Example 2: Adding two missing variables ($C$ and $D$)
$$\begin{aligned}
\bar{A}\bar{B} &= \bar{A}\bar{B} \cdot 1 \cdot 1 \\
&= \bar{A}\bar{B}(C + \bar{C})(D + \bar{D}) \\
&= \bar{A}\bar{B}(CD + C\bar{D} + \bar{C}D + \bar{C}\bar{D}) \\
&= \bar{A}\bar{B}CD + \bar{A}\bar{B}C\bar{D} + \bar{A}\bar{B}\bar{C}D + \bar{A}\bar{B}\bar{C}\bar{D}
\end{aligned}$$

---

## 3. Converting to Standard POS

> [!tip] Conversion Strategy
> To add a missing variable to a POS term, add $0$ to the term ($0 = X\bar{X}$), then apply the distributive law: $A + BC = (A+B)(A+C)$.

### Example 1: Expanding $F(A,B) = (\bar{A}+B)B$
$$\begin{aligned}
F(A,B) &= (\bar{A}+B) \cdot (B + 0) && \text{(Add 0 to the incomplete term)} \\
&= (\bar{A}+B) \cdot (B + A\bar{A}) && \text{(Replace 0 with } A\bar{A}\text{)} \\
&= (\bar{A}+B) \cdot (B+A)(B+\bar{A}) && \text{(Apply distributive law)} 
\end{aligned}$$

---

## 4. Minterms and Maxterms

> [!info] Quick Definitions
> * **[[Minterms]] ($m$):** Used in SOP. Variable is normal if $1$, complemented (bar) if $0$.
> * **[[Maxterms]] ($M$):** Used in POS. Variable is normal if $0$, complemented (bar) if $1$.

### 2-Variable Truth Table Reference

| Decimal | $A \quad B$ | Minterm (SOP) | Designation | Maxterm (POS) | Designation |
| :---: | :---: | :---: | :---: | :---: | :---: |
| **0** | $0 \quad 0$ | $\bar{A}\bar{B}$ | $m_0$ | $A + B$ | $M_0$ |
| **1** | $0 \quad 1$ | $\bar{A}B$ | $m_1$ | $A + \bar{B}$ | $M_1$ |
| **2** | $1 \quad 0$ | $A\bar{B}$ | $m_2$ | $\bar{A} + B$ | $M_2$ |
| **3** | $1 \quad 1$ | $AB$ | $m_3$ | $\bar{A} + \bar{B}$ | $M_3$ |

> [!success] Sigma Notation Shortcut
> We can express Boolean functions as a sum of specific minterms using the $\Sigma$ symbol:
> $$F(A,B) = \Sigma m(1,2) = m_1 + m_2 = \bar{A}B + A\bar{B} \quad \text{(XOR Logic!)}$$