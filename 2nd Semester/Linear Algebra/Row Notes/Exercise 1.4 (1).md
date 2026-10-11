### Question 1(d)
$$
Prove (a+b)C=aC+bC
$$
First, evaluate the sum of the scalars a and b.
$$
a + b = 4 + (-7) = -3
$$
Now, multiply the scalar result by the matrix C.
$$
(a+b)C = -3 \begin{bmatrix} 4 & 1 \\ -3 & -2 \end{bmatrix} = \begin{bmatrix} -12 & -3 \\ 9 & 6 \end{bmatrix}
$$
Next, evaluate the right-hand side by calculating aC and bC separately.
$$
aC = 4 \begin{bmatrix} 4 & 1 \\ -3 & -2 \end{bmatrix} = \begin{bmatrix} 16 & 4 \\ -12 & -8 \end{bmatrix}
$$
$$
bC = -7 \begin{bmatrix} 4 & 1 \\ -3 & -2 \end{bmatrix} = \begin{bmatrix} -28 & -7 \\ 21 & 14 \end{bmatrix}
$$
Finally, add the results of aC and bC together.
$$
aC + bC = \begin{bmatrix} 16 - 28 & 4 - 7 \\ -12 + 21 & -8 + 14 \end{bmatrix} = \begin{bmatrix} -12 & -3 \\ 9 & 6 \end{bmatrix}
$$
### Question 3(a)
$$
(A^{T})^{T}=A
$$
First, find the transpose of matrix A by swapping its rows and columns.
$$
A^T = \begin{bmatrix} 3 & 2 \\ -1 & 4 \end{bmatrix}
$$
Now, transpose the result of A Transpose to return to the original orientation
$$
(A^T)^T = \begin{bmatrix} 3 & -1 \\ 2 & 4 \end{bmatrix}
$$
### Question 5
Calculate the Inverse of:
$$
A = \begin{bmatrix} 2 & -3 \\4 & 4 \end{bmatrix}
$$
Calculate the determinant of the matrix A.
$$
\text{det}(A) = (2)(4) - (-3)(4) = 8 + 12 = 20
$$
Now, apply the 2×2 inverse formula by swapping the main diagonal, negating the off-diagonals, and dividing by the determinant
$$
A^{-1} = \frac{1}{20} \begin{bmatrix} 4 & 3 \\ -4 & 2 \end{bmatrix}
$$
Simplify the final matrix.
$$
A^{-1} = \begin{bmatrix} \frac{1}{5} & \frac{3}{20} \\ -\frac{1}{5} & \frac{1}{10} \end{bmatrix}
$$
### Question 7 
$$
C = \begin{bmatrix} 2 & 0 \\ 0 & 3 \end{bmatrix}
$$
Find the determinant of the diagonal matrix C.
$$
\text{det}(C) = (2)(3) - (0)(0) = 6
$$
Apply the inverse formula.
$$
C^{-1} = \frac{1}{6} \begin{bmatrix} 3 & 0 \\ 0 & 2 \end{bmatrix}
$$
Final simplified form:
$$
C^{-1} = \begin{bmatrix} \frac{1}{2} & 0 \\ 0 & \frac{1}{3} \end{bmatrix}
$$
### Question 9
Find the inverse of:
$$
\begin{bmatrix} \frac{1}{2}(e^{x}+e^{-x}) & \frac{1}{2}(e^{x}-e^{-x}) \\ \frac{1}{2}(e^{x}-e^{-x}) & \frac{1}{2}(e^{x}+e^{-x}) \end{bmatrix}
$$
Calculate the determinant.
$$
\text{det} = \frac{1}{4}(e^{2x} + 2 + e^{-2x}) - \frac{1}{4}(e^{2x} - 2 + e^{-2x}) = 1
$$
Because the determinant is 1, swap the main diagonal elements and negate the off-diagonal elements.
$$
\begin{bmatrix} \frac{1}{2}(e^{x}+e^{-x}) & -\frac{1}{2}(e^{x}-e^{-x}) \\ -\frac{1}{2}(e^{x}-e^{-x}) & \frac{1}{2}(e^{x}+e^{-x}) \end{bmatrix}
$$
### Question 10
Find the inverse of the rotation matrix:
$$
\begin{bmatrix} \cos \theta & \sin \theta \\ -\sin \theta & \cos \theta \end{bmatrix}
$$
Calculate the determinant using the Pythagorean identity:
$$
cos^2θ+sin^2θ=1.
$$
$$
\text{det} = (\cos \theta)(\cos \theta) - (\sin \theta)(-\sin \theta) = \cos^2 \theta + \sin^2 \theta = 1
$$
Swap the diagonal elements and negate the off-diagonal elements to find the inverse.
$$
\begin{bmatrix} \cos \theta & -\sin \theta \\ \sin \theta & \cos \theta \end{bmatrix}
$$
### Question 12 
$$
(A^{-1})^{-1}=A
$$
Take the inverse of A found in Question 5.
$$
A^{-1} = \begin{bmatrix} \frac{1}{5} & \frac{3}{20} \\ -\frac{1}{5} & \frac{1}{10} \end{bmatrix}
$$
Calculate the determinant of A Inverse.
$$
\text{det}(A^{-1}) = (\frac{1}{5})(\frac{1}{10}) - (\frac{3}{20})(-\frac{1}{5}) = \frac{1}{50} + \frac{3}{100} = \frac{5}{100} = \frac{1}{20}
$$
Apply the inverse formula to A Inverse.
$$
(A^{-1})^{-1} = 20 \begin{bmatrix} \frac{1}{10} & -\frac{3}{20} \\ \frac{1}{5} & \frac{1}{5} \end{bmatrix} = \begin{bmatrix} 2 & -3 \\ 4 & 4 \end{bmatrix}
$$
### Question 13
$$
(ABC)^{-1}=C^{-1}B^{-1}A^{-1}
$$
This is a general property where the inverse of a product is the product of the inverses in reverse order.
$$
\text{If } L = ABC, \text{ then } L^{-1} = C^{-1}B^{-1}A^{-1}
$$
### Question 16
Find a Given:
$$
(5A^T)^{-1} = \begin{bmatrix} -3 & -1 \\ 5 & 2 \end{bmatrix}
$$
Invert both sides of the equation to isolate 5A Transpose.
$$
5A^T = \left( \begin{bmatrix} -3 & -1 \\ 5 & 2 \end{bmatrix} \right)^{-1}
$$
Calculate the inverse. The determinant is (−3)(2)−(−1)(5)=−1.
$$
5A^T = \frac{1}{-1} \begin{bmatrix} 2 & 1 \\ -5 & -3 \end{bmatrix} = \begin{bmatrix} -2 & -1 \\ 5 & 3 \end{bmatrix}
$$
Divide by 5 and then transpose to find A.
$$
A^T = \begin{bmatrix} (\frac{-2}{5}) & (\frac{-1}{5}) \\ (\frac{5}{5}) & (\frac{3}{5}) \end{bmatrix} \implies A = \begin{bmatrix} (\frac{-2}{5}) & 1 \\ (\frac{-1}{5}) & (\frac{3}{5}) \end{bmatrix}
$$
### Question 17
$$
(I+2A)^{-1}=\begin{bmatrix} -1 & 2 \\ 4 & 5 \end{bmatrix}
$$
Invert both sides.
$$
I + 2A = \left( \begin{bmatrix} -1 & 2 \\ 4 & 5 \end{bmatrix} \right)^{-1}
$$
The determinant is (−1)(5)−(2)(4)=−13.
$$
I + 2A = \frac{1}{-13} \begin{bmatrix} 5 & -2 \\ -4 & -1 \end{bmatrix} = \begin{bmatrix} -\frac{5}{13} & \frac{2}{13} \\ \frac{4}{13} & \frac{1}{13} \end{bmatrix}
$$
Subtract I and divide by 2.
$$
2A = \begin{bmatrix} -\frac{18}{13} & \frac{2}{13} \\ \frac{4}{13} & -\frac{12}{13} \end{bmatrix} \implies A = \begin{bmatrix} -\frac{9}{13} & \frac{1}{13} \\ \frac{2}{13} & -\frac{6}{13} \end{bmatrix}
$$
### Question 19(a)
$$
A^3 \text{ for } A = \begin{bmatrix} 3 & 1 \\ 2 & 1 \end{bmatrix}
$$
First, find:
$$
A^2
$$
$$
A^2 = \begin{bmatrix} 3 & 1 \\ 2 & 1 \end{bmatrix} \begin{bmatrix} 3 & 1 \\ 2 & 1 \end{bmatrix} = \begin{bmatrix} 11 & 4 \\ 8 & 3 \end{bmatrix}
$$
Now, multiply A Square by A
$$
A^3 = \begin{bmatrix} 11 & 4 \\ 8 & 3 \end{bmatrix} \begin{bmatrix} 3 & 1 \\ 2 & 1 \end{bmatrix} = \begin{bmatrix} 41 & 15 \\ 30 & 11 \end{bmatrix}
$$

### **Question 20(a)**

Question: Compute $A^3$ using the given matrix $A = \begin{bmatrix}2&0\\4&1\end{bmatrix}$.

First, compute $A^2$ by multiplying matrix $A$ by itself.

$$A^2 = \begin{bmatrix}2&0\\4&1\end{bmatrix} \begin{bmatrix}2&0\\4&1\end{bmatrix} = \begin{bmatrix}(2)(2)+(0)(4) & (2)(0)+(0)(1)\\ (4)(2)+(1)(4) & (4)(0)+(1)(1)\end{bmatrix} = \begin{bmatrix}4&0\\12&1\end{bmatrix}$$

Next, compute $A^3$ by multiplying $A^2$ by $A$.

$$A^3 = \begin{bmatrix}4&0\\12&1\end{bmatrix} \begin{bmatrix}2&0\\4&1\end{bmatrix} = \begin{bmatrix}(4)(2)+(0)(4) & (4)(0)+(0)(1)\\ (12)(2)+(1)(4) & (12)(0)+(1)(1)\end{bmatrix} = \begin{bmatrix}8&0\\28&1\end{bmatrix}$$

---

### **Question 21**

Compute $p(A)$ for the matrix $A = \begin{bmatrix}3&1\\2&1\end{bmatrix}$ and the following polynomials:
(a) $p(x)=x-2$,
(b) $p(x)=2x^2-x+1$, and
(c) $p(x)=x^3-2x+1$.

**Part (a):** For the polynomial $p(x) = x - 2$, substitute $x$ with matrix $A$ and the constant $2$ with $2I$, where $I$ is the $2 \times 2$ identity matrix.

$$p(A) = A - 2I = \begin{bmatrix}3&1\\2&1\end{bmatrix} - \begin{bmatrix}2&0\\0&2\end{bmatrix} = \begin{bmatrix}1&1\\2&-1\end{bmatrix}$$

**Part (b):** For $p(x) = 2x^2 - x + 1$, we first need to find $A^2$.

$$A^2 = \begin{bmatrix}3&1\\2&1\end{bmatrix} \begin{bmatrix}3&1\\2&1\end{bmatrix} = \begin{bmatrix}11&4\\8&3\end{bmatrix}$$

Now, substitute $A$ and $I$ into the polynomial $p(A) = 2A^2 - A + I$.

$$p(A) = 2\begin{bmatrix}11&4\\8&3\end{bmatrix} - \begin{bmatrix}3&1\\2&1\end{bmatrix} + \begin{bmatrix}1&0\\0&1\end{bmatrix}$$

Multiply by the scalar and combine the matrices.

$$p(A) = \begin{bmatrix}22&8\\16&6\end{bmatrix} - \begin{bmatrix}3&1\\2&1\end{bmatrix} + \begin{bmatrix}1&0\\0&1\end{bmatrix} = \begin{bmatrix}20&7\\14&6\end{bmatrix}$$

**Part (c):** For $p(x) = x^3 - 2x + 1$, we first need to find $A^3$ by multiplying $A^2$ by $A$.

$$A^3 = \begin{bmatrix}11&4\\8&3\end{bmatrix} \begin{bmatrix}3&1\\2&1\end{bmatrix} = \begin{bmatrix}41&15\\30&11\end{bmatrix}$$

Substitute the matrices into $p(A) = A^3 - 2A + I$.

$$p(A) = \begin{bmatrix}41&15\\30&11\end{bmatrix} - 2\begin{bmatrix}3&1\\2&1\end{bmatrix} + \begin{bmatrix}1&0\\0&1\end{bmatrix}$$

Perform the scalar multiplication and then the matrix addition and subtraction.

$$p(A) = \begin{bmatrix}41&15\\30&11\end{bmatrix} - \begin{bmatrix}6&2\\4&2\end{bmatrix} + \begin{bmatrix}1&0\\0&1\end{bmatrix} = \begin{bmatrix}36&13\\26&10\end{bmatrix}$$

---

### **Question 22**

Compute $p(A)$ for the matrix $A = \begin{bmatrix}2&0\\4&1\end{bmatrix}$ and the same polynomials as Question 21.

First, note that we have already calculated $A^2$ and $A^3$ for this matrix in Question 20(a).

$$A = \begin{bmatrix}2&0\\4&1\end{bmatrix}, \quad A^2 = \begin{bmatrix}4&0\\12&1\end{bmatrix}, \quad A^3 = \begin{bmatrix}8&0\\28&1\end{bmatrix}$$

**Part (a):** For $p(x) = x - 2$, evaluate $p(A) = A - 2I$.

$$p(A) = \begin{bmatrix}2&0\\4&1\end{bmatrix} - \begin{bmatrix}2&0\\0&2\end{bmatrix} = \begin{bmatrix}0&0\\4&-1\end{bmatrix}$$

**Part (b):** For $p(x) = 2x^2 - x + 1$, evaluate $p(A) = 2A^2 - A + I$.

$$p(A) = 2\begin{bmatrix}4&0\\12&1\end{bmatrix} - \begin{bmatrix}2&0\\4&1\end{bmatrix} + \begin{bmatrix}1&0\\0&1\end{bmatrix}$$

$$p(A) = \begin{bmatrix}8&0\\24&2\end{bmatrix} - \begin{bmatrix}2&0\\4&1\end{bmatrix} + \begin{bmatrix}1&0\\0&1\end{bmatrix} = \begin{bmatrix}7&0\\20&2\end{bmatrix}$$

**Part (c):** For $p(x) = x^3 - 2x + 1$, evaluate $p(A) = A^3 - 2A + I$.

$$p(A) = \begin{bmatrix}8&0\\28&1\end{bmatrix} - 2\begin{bmatrix}2&0\\4&1\end{bmatrix} + \begin{bmatrix}1&0\\0&1\end{bmatrix}$$

$$p(A) = \begin{bmatrix}8&0\\28&1\end{bmatrix} - \begin{bmatrix}4&0\\8&2\end{bmatrix} + \begin{bmatrix}1&0\\0&1\end{bmatrix} = \begin{bmatrix}5&0\\20&0\end{bmatrix}$$

---

### **Question 37**

Question: Determine whether $A = \begin{bmatrix}1&0&1\\1&1&0\\0&1&1\end{bmatrix}$ is invertible, and if so, find the inverse.

To find the inverse, we can use the Gauss-Jordan elimination method by creating an augmented matrix $[A | I]$.

$$\left[ \begin{array}{ccc|ccc} 1&0&1 & 1&0&0 \\ 1&1&0 & 0&1&0 \\ 0&1&1 & 0&0&1 \end{array} \right]$$

Subtract Row 1 from Row 2 ($R_2 \leftarrow R_2 - R_1$).

$$\left[ \begin{array}{ccc|ccc} 1&0&1 & 1&0&0 \\ 0&1&-1 & -1&1&0 \\ 0&1&1 & 0&0&1 \end{array} \right]$$

Subtract Row 2 from Row 3 ($R_3 \leftarrow R_3 - R_2$).

$$\left[ \begin{array}{ccc|ccc} 1&0&1 & 1&0&0 \\ 0&1&-1 & -1&1&0 \\ 0&0&2 & 1&-1&1 \end{array} \right]$$

Divide Row 3 by 2 ($R_3 \leftarrow \frac{1}{2}R_3$).

$$\left[ \begin{array}{ccc|ccc} 1&0&1 & 1&0&0 \\ 0&1&-1 & -1&1&0 \\ 0&0&1 & \frac{1}{2}&-\frac{1}{2}&\frac{1}{2} \end{array} \right]$$

Add Row 3 to Row 2 ($R_2 \leftarrow R_2 + R_3$).

$$\left[ \begin{array}{ccc|ccc} 1&0&1 & 1&0&0 \\ 0&1&0 & -\frac{1}{2}&\frac{1}{2}&\frac{1}{2} \\ 0&0&1 & \frac{1}{2}&-\frac{1}{2}&\frac{1}{2} \end{array} \right]$$

Subtract Row 3 from Row 1 ($R_1 \leftarrow R_1 - R_3$).

$$\left[ \begin{array}{ccc|ccc} 1&0&0 & \frac{1}{2}&\frac{1}{2}&-\frac{1}{2} \\ 0&1&0 & -\frac{1}{2}&\frac{1}{2}&\frac{1}{2} \\ 0&0&1 & \frac{1}{2}&-\frac{1}{2}&\frac{1}{2} \end{array} \right]$$

Since the left side has been transformed into the identity matrix, matrix $A$ is invertible. The right side is the inverse matrix $A^{-1}$.

$$A^{-1} = \begin{bmatrix} \frac{1}{2}&\frac{1}{2}&-\frac{1}{2} \\ -\frac{1}{2}&\frac{1}{2}&\frac{1}{2} \\ \frac{1}{2}&-\frac{1}{2}&\frac{1}{2} \end{bmatrix}$$

---

### **Question 38**

Determine whether $A = \begin{bmatrix}1&1&1\\1&0&0\\0&1&1\end{bmatrix}$ is invertible, and if so, find the inverse.

We set up the augmented matrix $[A | I]$ to test for invertibility.

$$\left[ \begin{array}{ccc|ccc} 1&1&1 & 1&0&0 \\ 1&0&0 & 0&1&0 \\ 0&1&1 & 0&0&1 \end{array} \right]$$

Swap Row 1 and Row 2 ($R_1 \leftrightarrow R_2$) to simplify the pivot matrix.

$$\left[ \begin{array}{ccc|ccc} 1&0&0 & 0&1&0 \\ 1&1&1 & 1&0&0 \\ 0&1&1 & 0&0&1 \end{array} \right]$$

Subtract Row 1 from Row 2 ($R_2 \leftarrow R_2 - R_1$).

$$\left[ \begin{array}{ccc|ccc} 1&0&0 & 0&1&0 \\ 0&1&1 & 1&-1&0 \\ 0&1&1 & 0&0&1 \end{array} \right]$$

Subtract Row 2 from Row 3 ($R_3 \leftarrow R_3 - R_2$).

$$\left[ \begin{array}{ccc|ccc} 1&0&0 & 0&1&0 \\ 0&1&1 & 1&-1&0 \\ 0&0&0 & -1&1&1 \end{array} \right]$$

Since the entire third row of the left side is composed of zeros, it is impossible to transform it 

