Here are the step-by-step solutions for the requested exercises from the provided text.

### **Question 39**

**Question:**

Simplify the expression assuming that $A, B, C,$ and $D$ are invertible.

$$(AB)^{-1}(AC^{-1})(D^{-1}C^{-1})^{-1}D^{-1}$$

**Solution:**

- **Step 1:** Apply the reversal law for inverses $(XY)^{-1} = Y^{-1}X^{-1}$ to the first and third terms.
    
    For the first term: $(AB)^{-1} = B^{-1}A^{-1}$.
    
    For the third term: $(D^{-1}C^{-1})^{-1} = (C^{-1})^{-1}(D^{-1})^{-1} = CD$.
    

$$(B^{-1}A^{-1})(AC^{-1})(CD)D^{-1}$$

- **Step 2:** Use the associative property to regroup the terms. Notice that $A^{-1}A$ and $DD^{-1}$ appear in the sequence.
    

$$B^{-1}(A^{-1}A)C^{-1}C(DD^{-1})$$

- **Step 3:** Simplify the products of inverses to the identity matrix $I$.
    
    $A^{-1}A = I$ and $DD^{-1} = I$.
    

$$B^{-1}(I)C^{-1}C(I)$$

- **Step 4:** Remove the identity matrices and simplify $C^{-1}C$.
    
    $C^{-1}C = I$.
    

$$B^{-1}I = B^{-1}$$

**Final Answer:**

$$B^{-1}$$

---

### **Question 40**

**Question:**

Simplify the expression assuming that $A, B, C,$ and $D$ are invertible.

$$(AC^{-1})^{-1}(AC^{-1})(AC^{-1})^{-1}AD^{-1}$$

**Solution:**

- **Step 1:** Observe the structure. The first two terms are inverses of each other. Let $X = AC^{-1}$. The expression begins with $X^{-1}X$.
    

$$\underbrace{(AC^{-1})^{-1}(AC^{-1})}_{I}(AC^{-1})^{-1}AD^{-1}$$

- **Step 2:** Replace the product of inverses with the identity matrix $I$.
    

$$I (AC^{-1})^{-1}AD^{-1} = (AC^{-1})^{-1}AD^{-1}$$

- **Step 3:** Expand the remaining inverse term $(AC^{-1})^{-1}$ using the reversal law $(XY)^{-1} = Y^{-1}X^{-1}$.
    
    $(AC^{-1})^{-1} = (C^{-1})^{-1}A^{-1} = CA^{-1}$.
    

$$(CA^{-1})AD^{-1}$$

- **Step 4:** Regroup and simplify $A^{-1}A$ to the identity matrix $I$.
    

$$C(A^{-1}A)D^{-1} = C(I)D^{-1}$$

**Final Answer:**

$$CD^{-1}$$

---

### **Question 45**

**Question:**

(a) Show that if $A, B,$ and $A+B$ are invertible matrices with the same size, then

$$A(A^{-1}+B^{-1})B(A+B)^{-1}=I$$

(b) What does the result in part (a) tell you about the matrix $A^{-1}+B^{-1}$?

**Solution:**

**Part (a)**

- **Step 1:** Distribute $A$ into the term $(A^{-1}+B^{-1})$.
    

$$(AA^{-1} + AB^{-1})B(A+B)^{-1}$$

$$(I + AB^{-1})B(A+B)^{-1}$$

- **Step 2:** Distribute $B$ into the term $(I + AB^{-1})$.
    

$$(B + AB^{-1}B)(A+B)^{-1}$$

```
Since $B^{-1}B = I$, this simplifies to:
```

$$(B + AI)(A+B)^{-1}$$

- **Step 3:** Simplify and complete the multiplication.
    

$$(B + A)(A+B)^{-1}$$

```
Since matrix addition is commutative (B+A = A+B), we have a matrix multiplied by its own inverse.
```

$$(A+B)(A+B)^{-1} = I$$

```
**Verified.**
```

**Part (b)**

- **Step 1:** Analyze the equation $$A(A^{-1}+B^{-1})B(A+B)^{-1}=I$$
    
    This equation fits the form $X Y Z W = I$, which implies that all matrices involved are invertible. Specifically, we can isolate $(A^{-1}+B^{-1})$.
    
    From $A(A^{-1}+B^{-1})B = A+B$, we can solve for $(A^{-1}+B^{-1})$:
    

$$A^{-1}+B^{-1} = A^{-1}(A+B)B^{-1}$$

- **Conclusion:** The result tells us that the sum of inverses $(A^{-1}+B^{-1})$ is itself an invertible matrix. Furthermore, by taking the inverse of the derived equation, we find a formula for the inverse of a sum of inverses:
    

$$(A^{-1}+B^{-1})^{-1} = B(A+B)^{-1}A$$

---

### **Question 46**

**Question:**

A square matrix $A$ is said to be idempotent if $A^2=A$.

(a) Show that if $A$ is idempotent, then so is $I-A$.

(b) Show that if $A$ is idempotent, then $2A-I$ is invertible and is its own inverse.

**Solution:**

**Part (a)**

- **Step 1:** To prove $I-A$ is idempotent, we must show that $(I-A)^2 = I-A$. Expand the square.
    

$$(I-A)^2 = (I-A)(I-A) = I^2 - IA - AI + A^2$$

- **Step 2:** Simplify using $I^2=I$, $IA=A$, and the given property $A^2=A$.
    

$$I - A - A + A = I - A$$

```
Thus, I-A is idempotent.
```

**Part (b)**

- **Step 1:** To prove $2A-I$ is its own inverse, we must show that $(2A-I)(2A-I) = I$. Expand the product.
    

$$(2A-I)(2A-I) = 4A^2 - 2AI - 2IA + I^2$$

- **Step 2:** Simplify using $A^2=A$ and $I^2=I$.
    

$$4A - 2A - 2A + I$$

- **Step 3:** Combine like terms.
    

$$4A - 4A + I = I$$

```
Since the product is the identity matrix, $2A-I$ is invertible and is its own inverse.
```

---

### **Question 47**

**Question:**

Show that if $A$ is a square matrix such that $A^k=0$ for some positive integer $k$, then the matrix $I-A$ is invertible and

$$(I-A)^{-1}=I+A+A^{2}+\dots+A^{k-1}$$

**Solution:**

- **Step 1:** To verify the inverse, multiply $(I-A)$ by the proposed inverse $(I+A+A^{2}+\dots+A^{k-1})$ and show the result is $I$.
    

$$(I-A)(I+A+A^{2}+\dots+A^{k-1})$$

- **Step 2:** Distribute $(I-A)$ across the sum. This effectively splits into two sums.
    

$$I(I+A+\dots+A^{k-1}) - A(I+A+\dots+A^{k-1})$$

$$(I+A+A^2+\dots+A^{k-1}) - (A+A^2+A^3+\dots+A^{k})$$

- **Step 3:** Observe the telescoping nature of the sum. All intermediate terms cancel out ($A-A$, $A^2-A^2$, etc.), leaving only the first term of the first sum and the last term of the second sum.
    

$$I - A^k$$

- **Step 4:** Apply the given condition $A^k = 0$.
    

$$I - 0 = I$$

```
Since the product is the identity matrix, the formula is correct.
```

---

### **Question 49**

**Question:**

Assuming that all matrices are $n\times n$ and invertible, solve for $D$.

$$C^{T}B^{-1}A^{2}BAC^{-1}DA^{-2}B^{T}C^{-2}=C^{T}$$

**Solution:**

- **Step 1:** Isolate $D$ by peeling away matrices from the left side of the equation first.
    
    Multiply by $(C^T)^{-1}$ on the left of both sides:
    

$$B^{-1}A^{2}BAC^{-1}DA^{-2}B^{T}C^{-2} = (C^T)^{-1}C^T = I$$

- **Step 2:** Remove $B^{-1}$ by multiplying by $B$ on the left.
    

$$A^{2}BAC^{-1}DA^{-2}B^{T}C^{-2} = B$$

- **Step 3:** Remove $A^2$ by multiplying by $A^{-2}$ on the left.
    

$$BAC^{-1}DA^{-2}B^{T}C^{-2} = A^{-2}B$$

- **Step 4:** Remove $B$ by multiplying by $B^{-1}$ on the left.
    

$$AC^{-1}DA^{-2}B^{T}C^{-2} = B^{-1}A^{-2}B$$

- **Step 5:** Remove $A$ by multiplying by $A^{-1}$ on the left.
    

$$C^{-1}DA^{-2}B^{T}C^{-2} = A^{-1}B^{-1}A^{-2}B$$

- **Step 6:** Remove $C^{-1}$ by multiplying by $C$ on the left.
    

$$DA^{-2}B^{T}C^{-2} = C A^{-1}B^{-1}A^{-2}B$$

- **Step 7:** Now peel away matrices from the right side. Remove $C^{-2}$ by multiplying by $C^2$ on the right.
    

$$DA^{-2}B^{T} = C A^{-1}B^{-1}A^{-2}B C^2$$

- **Step 8:** Remove $B^T$ by multiplying by $(B^T)^{-1}$ on the right.
    

$$DA^{-2} = C A^{-1}B^{-1}A^{-2}B C^2 (B^T)^{-1}$$

- **Step 9:** Finally, remove $A^{-2}$ by multiplying by $A^2$ on the right.
    

$$D = C A^{-1}B^{-1}A^{-2}B C^2 (B^T)^{-1} A^2$$

---

### **Question 50**

**Question:**

Assuming that all matrices are $n\times n$ and invertible, solve for $D$.

$$ABC^{T}DBA^{T}C=AB^{T}$$

**Solution:**

- **Step 1:** Remove $A$ from the left side by multiplying by $A^{-1}$ on the left.
    

$$BC^{T}DBA^{T}C = A^{-1}AB^{T} = B^{T}$$

- **Step 2:** Remove $B$ from the left side by multiplying by $B^{-1}$ on the left.
    

$$C^{T}DBA^{T}C = B^{-1}B^{T}$$

- **Step 3:** Remove $C^T$ from the left side by multiplying by $(C^T)^{-1}$ on the left.
    

$$DBA^{T}C = (C^T)^{-1}B^{-1}B^{T}$$

- **Step 4:** Now remove matrices from the right side to isolate $D$. Remove $C$ by multiplying by $C^{-1}$ on the right.
    

$$DBA^{T} = (C^T)^{-1}B^{-1}B^{T}C^{-1}$$

- **Step 5:** Remove $A^T$ by multiplying by $(A^T)^{-1}$ on the right.
    

$$DB = (C^T)^{-1}B^{-1}B^{T}C^{-1}(A^T)^{-1}$$

- **Step 6:** Finally, remove $B$ by multiplying by $B^{-1}$ on the right.
    

$$D = (C^T)^{-1}B^{-1}B^{T}C^{-1}(A^T)^{-1}B^{-1}$$