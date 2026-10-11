### **Question 1 (Part a)**

**Question:**
Determine whether the given matrix is elementary.

$$\begin{bmatrix} 1 & 0 \\ -5 & 1 \end{bmatrix}$$

**Solution:**

* **Step 1:** Recall the definition of an elementary matrix.
An elementary matrix is a matrix that results from performing a single elementary row operation on an identity matrix.
* **Step 2:** Analyze the given matrix.
Compare the given matrix to the $2 \times 2$ identity matrix $I_2$.

$$I_2 = \begin{bmatrix} 1 & 0 \\ 0 & 1 \end{bmatrix}$$

```
The given matrix has a -5 in the (2, 1) position. This corresponds to the row operation "Add -5 times Row 1 to Row 2" 
```
$$R_2 \leftarrow R_2 - 5R_1$$
* **Conclusion:**
Since the matrix can be obtained by a single row operation on the identity matrix, it **is an elementary matrix**.

---

### **Question 2 (Part a)**

**Question:**
Find a row operation and the corresponding elementary matrix that will restore the given elementary matrix to the identity matrix.

$$\begin{bmatrix} 1 & 0 \\ 0 & \sqrt{3} \end{bmatrix}$$

**Solution:**

* **Step 1:** Identify the row operation that created this matrix.
The matrix shows that Row 2 has been multiplied by $\sqrt{3}$.

$$R_2 \leftarrow \sqrt{3}R_2$$

* **Step 2:** Determine the inverse operation.
To reverse this multiplication, we must multiply Row 2 by the reciprocal of $\sqrt{3}$.

$$R_2 \leftarrow \frac{1}{\sqrt{3}}R_2$$

* **Step 3:** Construct the corresponding elementary matrix.
Apply the inverse operation to the identity matrix.

$$\begin{bmatrix} 1 & 0 \\ 0 & \frac{1}{\sqrt{3}} \end{bmatrix}$$

---

### **Question 3 (Part a)**

**Question:**
Find a row operation and the corresponding elementary matrix that will restore the given elementary matrix to the identity matrix.

$$\begin{bmatrix} 1 & -3 \\ 0 & 1 \end{bmatrix}$$

**Solution:**

* **Step 1:** Identify the original row operation.
This matrix was formed by adding $-3$ times Row 2 to Row 1 ($R_1 \leftarrow R_1 - 3R_2$).
* **Step 2:** Determine the inverse operation.
To restore the identity matrix, we must add $3$ times Row 2 to Row 1.

$$R_1 \leftarrow R_1 + 3R_2$$

* **Step 3:** Construct the elementary matrix.
Apply this inverse operation to the identity matrix.

$$\begin{bmatrix} 1 & 3 \\ 0 & 1 \end{bmatrix}$$

---

### **Question 4 (Part a)**

**Question:**
Find a row operation and the corresponding elementary matrix that will restore the given elementary matrix to the identity matrix.

$$\begin{bmatrix} 1 & 0 \\ -3 & 1 \end{bmatrix}$$

**Solution:**

* **Step 1:** Identify the original row operation.
This matrix was formed by adding $-3$ times Row 1 to Row 2 ($R_2 \leftarrow R_2 - 3R_1$).
* **Step 2:** Determine the inverse operation.
To restore the identity matrix, we must add $3$ times Row 1 to Row 2.

$$R_2 \leftarrow R_2 + 3R_1$$

* **Step 3:** Construct the elementary matrix.

$$\begin{bmatrix} 1 & 0 \\ 3 & 1 \end{bmatrix}$$

---

### **Question 5 (Part a)**

**Question:**
Identify the row operation corresponding to $E$ and verify that the product $EA$ results from applying the row operation to $A$.

$$E = \begin{bmatrix} 0 & 1 \\ 1 & 0 \end{bmatrix}, \quad A = \begin{bmatrix} -1 & -2 & 5 & -1 \\ 3 & -6 & -6 & -6 \end{bmatrix}$$

**Solution:**

* **Step 1:** Identify the row operation.
Matrix $E$ is the identity matrix with Row 1 and Row 2 swapped. Therefore, the operation is **Interchange Row 1 and Row 2** ($R_1 \leftrightarrow R_2$).
* **Step 2:** Compute the matrix multiplication $EA$.

$$\begin{bmatrix} 0 & 1 \\ 1 & 0 \end{bmatrix} \begin{bmatrix} -1 & -2 & 5 & -1 \\ 3 & -6 & -6 & -6 \end{bmatrix}$$

Calculating the rows:
* Row 1 of result: $0 \cdot (\text{Row 1 of A}) + 1 \cdot (\text{Row 2 of A}) = \text{Row 2 of A}$
* Row 2 of result: $1 \cdot (\text{Row 1 of A}) + 0 \cdot (\text{Row 2 of A}) = \text{Row 1 of A}$



$$EA = \begin{bmatrix} 3 & -6 & -6 & -6 \\ -1 & -2 & 5 & -1 \end{bmatrix}$$

* **Conclusion:**
The product $EA$ is indeed matrix $A$ with its rows swapped, verifying the operation.

---

### **Question 6 (Part a)**

**Question:**
Identify the row operation corresponding to $E$ and verify that the product $EA$ results from applying the row operation to $A$.

$$E = \begin{bmatrix} -6 & 0 \\ 0 & 1 \end{bmatrix}, \quad A = \begin{bmatrix} -1 & -2 & 5 & -1 \\ 3 & -6 & -6 & -6 \end{bmatrix}$$

**Solution:**

* **Step 1:** Identify the row operation.
Matrix $E$ is the identity matrix with the first diagonal element changed to $-6$. This corresponds to **Multiplying Row 1 by -6** ($R_1 \leftarrow -6R_1$).
* **Step 2:** Compute the matrix multiplication $EA$.

$$\begin{bmatrix} -6 & 0 \\ 0 & 1 \end{bmatrix} \begin{bmatrix} -1 & -2 & 5 & -1 \\ 3 & -6 & -6 & -6 \end{bmatrix}$$

```
Calculating the rows:
Row 1: (-6)(-1, -2, 5, -1) = (6, 12, -30, 6)
Row 2: (1)(3, -6, -6, -6) = (3, -6, -6, -6)

```

$$EA = \begin{bmatrix} 6 & 12 & -30 & 6 \\ 3 & -6 & -6 & -6 \end{bmatrix}$$

* **Conclusion:**
The product $EA$ matches matrix $A$ with the first row scaled by $-6$, verifying the operation.

---

### **Question 7 (Part a)**

**Question:**
Find an elementary matrix $E$ such that $EA = B$.

$$A = \begin{bmatrix} 3 & 4 & 1 \\ 2 & -7 & -1 \\ 8 & 1 & 5 \end{bmatrix}, \quad B = \begin{bmatrix} 8 & 1 & 5 \\ 2 & -7 & -1 \\ 3 & 4 & 1 \end{bmatrix}$$

**Solution:**

* **Step 1:** Compare matrices $A$ and $B$ to identify the row operation.
* Row 2 of $B$ is the same as Row 2 of $A$.
* Row 1 of $B$ ($8, 1, 5$) is Row 3 of $A$.
* Row 3 of $B$ ($3, 4, 1$) is Row 1 of $A$.


The operation is **Interchange Row 1 and Row 3** ($R_1 \leftrightarrow R_3$).
* **Step 2:** Construct the elementary matrix $E$.
Apply the swap operation ($R_1 \leftrightarrow R_3$) to the $3 \times 3$ identity matrix.

$$I_3 = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix} \xrightarrow{R_1 \leftrightarrow R_3} E = \begin{bmatrix} 0 & 0 & 1 \\ 0 & 1 & 0 \\ 1 & 0 & 0 \end{bmatrix}$$

**Final Answer:**

$$E = \begin{bmatrix} 0 & 0 & 1 \\ 0 & 1 & 0 \\ 1 & 0 & 0 \end{bmatrix}$$

### **Question 8**

**Question:**
Find an elementary matrix $E$ that satisfies the stated equation for the given matrices:

$$A = \begin{bmatrix} 3 & 4 & 1 \\ 2 & -7 & -1 \\ 8 & 1 & 5 \end{bmatrix}, \quad B = \begin{bmatrix} 8 & 1 & 5 \\ 2 & -7 & -1 \\ 3 & 4 & 1 \end{bmatrix}$$

$$D = \begin{bmatrix} 8 & 1 & 5 \\ -6 & 21 & 3 \\ 3 & 4 & 1 \end{bmatrix}, \quad F = \begin{bmatrix} 8 & 1 & 5 \\ 8 & 1 & 1 \\ 3 & 4 & 1 \end{bmatrix}$$

**Solution (Part a): $EB = D$**

* **Step 1:** Compare matrix $B$ and $D$ to find the row operation.
* Row 1 and Row 3 are identical in both matrices.
* Row 2 of $B$ is $(2, -7, -1)$.
* Row 2 of $D$ is $(-6, 21, 3)$.
* Notice that $(-6, 21, 3) = -3 \times (2, -7, -1)$.
* The operation is: **Multiply Row 2 by -3** ($R_2 \leftarrow -3R_2$).


* **Step 2:** Construct $E$ by applying this operation to the identity matrix.

$$E = \begin{bmatrix} 1 & 0 & 0 \\ 0 & -3 & 0 \\ 0 & 0 & 1 \end{bmatrix}$$

**Solution (Part c): $EB = F$**

* **Step 1:** Compare matrix $B$ and $F$.
* Row 1 and Row 3 are identical.
* Row 2 of $F$ is $(8, 1, 1)$. Row 2 of $B$ is $(2, -7, -1)$.
* Calculate the difference: $R_2(F) - R_2(B) = (8-2, 1-(-7), 1-(-1)) = (6, 8, 2)$.
* Notice that the difference $(6, 8, 2)$ is exactly $2$ times Row 3 of $B$ ($2 \times (3, 4, 1)$).
* The operation is: **Add 2 times Row 3 to Row 2** ($R_2 \leftarrow R_2 + 2R_3$).


* **Step 2:** Construct $E$.

$$E = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 2 \\ 0 & 0 & 1 \end{bmatrix}$$

---

### **Question 9**

**Question:**
Use the inversion algorithm to find $A^{-1}$ if it exists.
(a) $A = \begin{bmatrix} 1 & 4 \\ 2 & 7 \end{bmatrix}$
(b) $A = \begin{bmatrix} 2 & -4 \\ -4 & 8 \end{bmatrix}$

**Solution:**
**(a)**

* **Step 1:** Calculate the determinant.
$\det(A) = (1)(7) - (4)(2) = 7 - 8 = -1$. Since the determinant is nonzero, the inverse exists.
* **Step 2:** Use the formula for a $2 \times 2$ matrix inverse.
$A^{-1} = \frac{1}{\det(A)} \begin{bmatrix} d & -b \\ -c & a \end{bmatrix} = \frac{1}{-1} \begin{bmatrix} 7 & -4 \\ -2 & 1 \end{bmatrix}$
* **Step 3:** Simplify.

$$A^{-1} = \begin{bmatrix} -7 & 4 \\ 2 & -1 \end{bmatrix}$$

**(b)**

* **Step 1:** Calculate the determinant.
$\det(A) = (2)(8) - (-4)(-4) = 16 - 16 = 0$.
* **Conclusion:**
Since the determinant is zero, **the matrix is not invertible**.

---

### **Question 10**

**Question:**
Use the inversion algorithm to find $A^{-1}$ if it exists.
(a) $A = \begin{bmatrix} 1 & -5 \\ 3 & -16 \end{bmatrix}$
(b) $A = \begin{bmatrix} 6 & 4 \\ -3 & -2 \end{bmatrix}$

**Solution:**
**(a)**

* **Step 1:** Calculate the determinant.
$\det(A) = (1)(-16) - (-5)(3) = -16 + 15 = -1$.
* **Step 2:** Apply the $2 \times 2$ inverse formula.
$A^{-1} = \frac{1}{-1} \begin{bmatrix} -16 & 5 \\ -3 & 1 \end{bmatrix}$
* **Step 3:** Simplify.

$$A^{-1} = \begin{bmatrix} 16 & -5 \\ 3 & -1 \end{bmatrix}$$

**(b)**

* **Step 1:** Calculate the determinant.
$\det(A) = (6)(-2) - (4)(-3) = -12 + 12 = 0$.
* **Conclusion:**
**The matrix is not invertible.**

---

### **Question 11**

**Question:**
Use the inversion algorithm to find the inverse of the matrix (if it exists).
(a) $\begin{bmatrix} 1 & 2 & 3 \\ 2 & 5 & 3 \\ 1 & 0 & 8 \end{bmatrix}$

**Solution:**

* **Step 1:** Set up the augmented matrix $[A | I]$.

$$\left[ \begin{array}{ccc|ccc} 1 & 2 & 3 & 1 & 0 & 0 \\ 2 & 5 & 3 & 0 & 1 & 0 \\ 1 & 0 & 8 & 0 & 0 & 1 \end{array} \right]$$

* **Step 2:** Create zeros below the pivot in column 1.
* $R_2 \leftarrow R_2 - 2R_1$
* $R_3 \leftarrow R_3 - R_1$

$$\left[ \begin{array}{ccc|ccc} 1 & 2 & 3 & 1 & 0 & 0 \\ 0 & 1 & -3 & -2 & 1 & 0 \\ 0 & -2 & 5 & -1 & 0 & 1 \end{array} \right]$$

* **Step 3:** Create a zero below the pivot in column 2.
* $R_3 \leftarrow R_3 + 2R_2$

$$\left[ \begin{array}{ccc|ccc} 1 & 2 & 3 & 1 & 0 & 0 \\ 0 & 1 & -3 & -2 & 1 & 0 \\ 0 & 0 & -1 & -5 & 2 & 1 \end{array} \right]$$

* **Step 4:** Normalize the third row.
* $R_3 \leftarrow -1 \times R_3$

$$\left[ \begin{array}{ccc|ccc} 1 & 2 & 3 & 1 & 0 & 0 \\ 0 & 1 & -3 & -2 & 1 & 0 \\ 0 & 0 & 1 & 5 & -2 & -1 \end{array} \right]$$

* **Step 5:** Create zeros above the pivot in column 3.
* $R_2 \leftarrow R_2 + 3R_3$
* $R_1 \leftarrow R_1 - 3R_3$



$$\left[ \begin{array}{ccc|ccc} 1 & 2 & 0 & -14 & 6 & 3 \\ 0 & 1 & 0 & 13 & -5 & -3 \\ 0 & 0 & 1 & 5 & -2 & -1 \end{array} \right]$$

* **Step 6:** Create a zero above the pivot in column 2.
* $R_1 \leftarrow R_1 - 2R_2$



$$\left[ \begin{array}{ccc|ccc} 1 & 0 & 0 & -40 & 16 & 9 \\ 0 & 1 & 0 & 13 & -5 & -3 \\ 0 & 0 & 1 & 5 & -2 & -1 \end{array} \right]$$

* **Final Answer:**

$$A^{-1} = \begin{bmatrix} -40 & 16 & 9 \\ 13 & -5 & -3 \\ 5 & -2 & -1 \end{bmatrix}$$

---

### **Question 13**

**Question:**
Use the inversion algorithm to find the inverse of the matrix.

$$\begin{bmatrix} 1 & 0 & 1 \\ 0 & 1 & 1 \\ 1 & 1 & 0 \end{bmatrix}$$

**Solution:**

* **Step 1:** Set up the augmented matrix.

$$\left[ \begin{array}{ccc|ccc} 1 & 0 & 1 & 1 & 0 & 0 \\ 0 & 1 & 1 & 0 & 1 & 0 \\ 1 & 1 & 0 & 0 & 0 & 1 \end{array} \right]$$

* **Step 2:** eliminate the bottom-left entry.
* $R_3 \leftarrow R_3 - R_1$



$$\left[ \begin{array}{ccc|ccc} 1 & 0 & 1 & 1 & 0 & 0 \\ 0 & 1 & 1 & 0 & 1 & 0 \\ 0 & 1 & -1 & -1 & 0 & 1 \end{array} \right]$$

* **Step 3:** Eliminate the entry below the second pivot.
* $R_3 \leftarrow R_3 - R_2$



$$\left[ \begin{array}{ccc|ccc} 1 & 0 & 1 & 1 & 0 & 0 \\ 0 & 1 & 1 & 0 & 1 & 0 \\ 0 & 0 & -2 & -1 & -1 & 1 \end{array} \right]$$

* **Step 4:** Normalize the third row.
* $R_3 \leftarrow -\frac{1}{2}R_3$



$$\left[ \begin{array}{ccc|ccc} 1 & 0 & 1 & 1 & 0 & 0 \\ 0 & 1 & 1 & 0 & 1 & 0 \\ 0 & 0 & 1 & \frac{1}{2} & \frac{1}{2} & -\frac{1}{2} \end{array} \right]$$

* **Step 5:** Create zeros above the third pivot.
* $R_2 \leftarrow R_2 - R_3$
* $R_1 \leftarrow R_1 - R_3$



$$\left[ \begin{array}{ccc|ccc} 1 & 0 & 0 & \frac{1}{2} & -\frac{1}{2} & \frac{1}{2} \\ 0 & 1 & 0 & -\frac{1}{2} & \frac{1}{2} & \frac{1}{2} \\ 0 & 0 & 1 & \frac{1}{2} & \frac{1}{2} & -\frac{1}{2} \end{array} \right]$$

* **Final Answer:**

$$A^{-1} = \begin{bmatrix} 0.5 & -0.5 & 0.5 \\ -0.5 & 0.5 & 0.5 \\ 0.5 & 0.5 & -0.5 \end{bmatrix}$$

---

### **Question 18**

**Question:**
Use the inversion algorithm to find the inverse of the matrix.

$$\begin{bmatrix} 0 & 0 & 2 & 0 \\ 1 & 0 & 0 & 1 \\ 0 & -1 & 3 & 0 \\ 2 & 1 & 5 & -3 \end{bmatrix}$$

**Solution:**

* **Step 1:** Set up the augmented matrix.

$$\left[ \begin{array}{cccc|cccc} 0 & 0 & 2 & 0 & 1 & 0 & 0 & 0 \\ 1 & 0 & 0 & 1 & 0 & 1 & 0 & 0 \\ 0 & -1 & 3 & 0 & 0 & 0 & 1 & 0 \\ 2 & 1 & 5 & -3 & 0 & 0 & 0 & 1 \end{array} \right]$$

* **Step 2:** Reorder rows to get a pivot in the top-left (Row 1).
* Swap $R_1$ and $R_2$.



$$\left[ \begin{array}{cccc|cccc} 1 & 0 & 0 & 1 & 0 & 1 & 0 & 0 \\ 0 & 0 & 2 & 0 & 1 & 0 & 0 & 0 \\ 0 & -1 & 3 & 0 & 0 & 0 & 1 & 0 \\ 2 & 1 & 5 & -3 & 0 & 0 & 0 & 1 \end{array} \right]$$

* **Step 3:** Eliminate entries below the first pivot.
* $R_4 \leftarrow R_4 - 2R_1$



$$\left[ \begin{array}{cccc|cccc} 1 & 0 & 0 & 1 & 0 & 1 & 0 & 0 \\ 0 & 0 & 2 & 0 & 1 & 0 & 0 & 0 \\ 0 & -1 & 3 & 0 & 0 & 0 & 1 & 0 \\ 0 & 1 & 5 & -5 & 0 & -2 & 0 & 1 \end{array} \right]$$

* **Step 4:** Get a pivot in the second column.
* Swap $R_2$ and $R_3$.

$$\left[ \begin{array}{cccc|cccc} 1 & 0 & 0 & 1 & 0 & 1 & 0 & 0 \\ 0 & -1 & 3 & 0 & 0 & 0 & 1 & 0 \\ 0 & 0 & 2 & 0 & 1 & 0 & 0 & 0 \\ 0 & 1 & 5 & -5 & 0 & -2 & 0 & 1 \end{array} \right]$$


* Multiply $R_2$ by $-1$.

$$\left[ \begin{array}{cccc|cccc} 1 & 0 & 0 & 1 & 0 & 1 & 0 & 0 \\ 0 & 1 & -3 & 0 & 0 & 0 & -1 & 0 \\ 0 & 0 & 2 & 0 & 1 & 0 & 0 & 0 \\ 0 & 1 & 5 & -5 & 0 & -2 & 0 & 1 \end{array} \right]$$

* **Step 5:** Eliminate below the second pivot.
* $R_4 \leftarrow R_4 - R_2$

$$\left[ \begin{array}{cccc|cccc} 1 & 0 & 0 & 1 & 0 & 1 & 0 & 0 \\ 0 & 1 & -3 & 0 & 0 & 0 & -1 & 0 \\ 0 & 0 & 2 & 0 & 1 & 0 & 0 & 0 \\ 0 & 0 & 8 & -5 & 0 & -2 & 1 & 1 \end{array} \right]$$

* **Step 6:** Eliminate below the third pivot (Row 3).
* $R_4 \leftarrow R_4 - 4R_3$ (Since $8 - 4(2) = 0$).

$$\left[ \begin{array}{cccc|cccc} 1 & 0 & 0 & 1 & 0 & 1 & 0 & 0 \\ 0 & 1 & -3 & 0 & 0 & 0 & -1 & 0 \\ 0 & 0 & 2 & 0 & 1 & 0 & 0 & 0 \\ 0 & 0 & 0 & -5 & -4 & -2 & 1 & 1 \end{array} \right]$$

* **Step 7:** Normalize pivots (Row 3 and Row 4).
* $R_3 \leftarrow \frac{1}{2}R_3$
* $R_4 \leftarrow -\frac{1}{5}R_4$

$$\left[ \begin{array}{cccc|cccc} 1 & 0 & 0 & 1 & 0 & 1 & 0 & 0 \\ 0 & 1 & -3 & 0 & 0 & 0 & -1 & 0 \\ 0 & 0 & 1 & 0 & 0.5 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 & 0.8 & 0.4 & -0.2 & -0.2 \end{array} \right]$$

* **Step 8:** Back-substitution (eliminate entries above pivots).
* $R_1 \leftarrow R_1 - R_4$
* $R_2 \leftarrow R_2 + 3R_3$ (Note: $R_2$ already has a 0 in col 4, so just clear col 3).

$$\text{Row 1}: [0, 1, 0, 0] - [0.8, 0.4, -0.2, -0.2] = [-0.8, 0.6, 0.2, 0.2]$$

$$\text{Row 2}: [0, 0, -1, 0] + [1.5, 0, 0, 0] = [1.5, 0, -1, 0]$$

$$\left[ \begin{array}{cccc|cccc} 1 & 0 & 0 & 0 & -0.8 & 0.6 & 0.2 & 0.2 \\ 0 & 1 & 0 & 0 & 1.5 & 0 & -1 & 0 \\ 0 & 0 & 1 & 0 & 0.5 & 0 & 0 & 0 \\ 0 & 0 & 0 & 1 & 0.8 & 0.4 & -0.2 & -0.2 \end{array} \right]$$

* **Final Answer:**

$$A^{-1} = \begin{bmatrix} -0.8 & 0.6 & 0.2 & 0.2 \\ 1.5 & 0 & -1 & 0 \\ 0.5 & 0 & 0 & 0 \\ 0.8 & 0.4 & -0.2 & -0.2 \end{bmatrix} = \begin{bmatrix} -4/5 & 3/5 & 1/5 & 1/5 \\ 3/2 & 0 & -1 & 0 \\ 1/2 & 0 & 0 & 0 \\ 4/5 & 2/5 & -1/5 & -1/5 \end{bmatrix}$$