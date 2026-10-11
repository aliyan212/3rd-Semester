### **Q. 1(i)**
$$
\begin{aligned}
& \text{In Exercises 1-2, suppose that A, B, C, D, and E are matrices with the following sizes:} \\
& \begin{array}{ccccc}
\text{A} & \text{B} & \text{C} & \text{D} & \text{E} \\
(4 \times 5) & (4 \times 5) & (5 \times 2) & (4 \times 2) & (5 \times 4)
\end{array} \\
& \text{In each part, determine whether the given matrix expression is defined.} \\
& \text{For those that are defined, give the size of the resulting matrix.} \\
& \text{(i) } \text{tr}(DD^T)
\end{aligned}
$$
* Based on the provided table, matrix D has dimensions of 4×2.
* Taking the transpose of D reverses these dimensions, resulting in a 2×4 matrix.
* The multiplication of D and its transpose is defined because their inner dimensions match, which results in a 4×4 matrix.
$$
D_{4 \times 2} \times D^T_{2 \times 4} = (DD^T)_{4 \times 4}
$$
### **Q. 2(a)**
$$
\text{Evaluate if } CD^{T} \text{ is defined and determine its size.}
$$
First, we look up the initial dimensions for matrices C and D.
$$
\begin{aligned}
C &\text{ is } 5 \times 2 \\
D &\text{ is } 4 \times 2
\end{aligned}
$$
Taking the transpose of D swaps its rows and columns.
$$
D^{T} \text{ is } 2 \times 4
$$
To see if the multiplication is valid, we check if the inner dimensions match.
$$
(5 \times 2) \times (2 \times 4)
$$
Since the inner numbers (2 and 2) match, the operation is defined. The final matrix takes the outer dimensions.
$$
\text{Size of } CD^{T} = 5 \times 4
$$
### **Q. 3(j)**
Find the trace of:
$$
\begin{aligned}
 \text{ } \text(D-3E)
\end{aligned}
$$
*   We are given specific 3×3 matrices for D and E.
*   To evaluate the expression, first multiply matrix E by the scalar 3, and then subtract that result from matrix D.
$$
D - 3E = \begin{bmatrix} 1 & 5 & 2 \\ -1 & 0 & 1 \\ 3 & 2 & 4 \end{bmatrix} - 3\begin{bmatrix} 6 & 1 & 3 \\ -1 & 1 & 2 \\ 4 & 1 & 3 \end{bmatrix}
$$
$$
D - 3E = \begin{bmatrix} 1 & 5 & 2 \\ -1 & 0 & 1 \\ 3 & 2 & 4 \end{bmatrix} - \begin{bmatrix} 18 & 3 & 9 \\ -3 & 3 & 6 \\ 12 & 3 & 9 \end{bmatrix} = \begin{bmatrix} -17 & 2 & -7 \\ 2 & -3 & -5 \\ -9 & -1 & -5 \end{bmatrix}
$$
The trace of a matrix is calculated by taking the sum of the entries located on the main diagonal
$$
tr(D-3E) = -17 + (-3) + (-5) = -25
$$
### Q. 4(a)
$$
\text{Evaluate if } 2A^{T}+C \text{ is defined.}
$$
Identify the dimensions of matrix A and flip them to find the dimensions of its transpose, AT. Scalar multiplication does not alter these dimensions.
$$
A \text{ is } 4 \times 5 \implies A^{T} \text{ is } 5 \times 4
$$
Matrix C has its given dimensions.
$$
C \text{ is } 5 \times 2
$$
Set up the addition operation. Matrix addition is only defined when both matrices have the exact same dimensions.
$$
(5 \times 4) + (5 \times 2)
$$
Because the dimensions do not match, the operation cannot be performed.
$$
\text{Undefined}
$$
### Q. 5(a)
$$
\text{Compute } AB
$$
We start with the specific matrices given for this section.
$$
A = \begin{bmatrix} 3 & 0 \\ -1 & 2 \\ 1 & 1 \end{bmatrix}, \quad B = \begin{bmatrix} 4 & -1 \\ 0 & 2 \end{bmatrix}
$$
To compute the product, multiply the rows of A by the columns of B.
$$
AB = \begin{bmatrix} 
(3)(4)+(0)(0) & (3)(-1)+(0)(2) \\ 
(-1)(4)+(2)(0) & (-1)(-1)+(2)(2) \\ 
(1)(4)+(1)(0) & (1)(-1)+(1)(2) 
\end{bmatrix}
$$
Simplify the arithmetic inside each element to get your final 3×2 matrix.
$$
AB = \begin{bmatrix} 12 & -3 \\ -4 & 5 \\ 4 & 1 \end{bmatrix}
$$
### **Q. 6(f) **
$$
\begin{aligned}
& \text{In Exercises 3-6, use the following matrices to compute the indicated expression if it is defined.} \\
& \text{[Matrices A, B, C, D, E are the same as defined in Q3]} \\
& \text{6(f) } D^TE^T - (ED)^T
\end{aligned}
$$
* This question asks you to evaluate a specific expression involving transposed matrices.
* A standard property of matrix transposes states that the transpose of a product is equal to the product of the individual transposes in reverse order.
$$
(ED)^{T} = D^{T}E^{T}
$$
If you substitute this property back into the original expression, you are subtracting a matrix from itself, which yields a zero matrix.
$$
D^{T}E^{T} - D^{T}E^{T} = \begin{bmatrix} 0 & 0 & 0 \\ 0 & 0 & 0 \\ 0 & 0 & 0 \end{bmatrix}
$$
### **Q. 7(c) **
$$
\begin{aligned}
& \text{In Exercises 7-8, use the following matrices and either the row method or} \\
& \text{the column method, as appropriate, to find the indicated row or column.} \\
& A = \begin{bmatrix} 3 & -2 & 7 \\ 6 & 5 & 4 \\ 0 & 4 & 9 \end{bmatrix} \quad \text{and} \quad B = \begin{bmatrix} 6 & -2 & 4 \\ 0 & 1 & 3 \\ 7 & 7 & 5 \end{bmatrix} \\
& \text{7(c) the second column of } AB
\end{aligned}
$$
* The goal is to isolate and find only the second column of the product of matrices A and B.
* Using the column method, you achieve this by multiplying the entirety of matrix A by just the second column vector of matrix B.
	$$
	A = \begin{bmatrix} 3 & -2 & 7 \\ 6 & 5 & 4 \\ 0 & 4 & 9 \end{bmatrix}, \quad B_{col2} = \begin{bmatrix} -2 \\ 1 \\ 7 \end{bmatrix}
	$$
	$$
	(AB)_{col2} = \begin{bmatrix} 3 & -2 & 7 \\ 6 & 5 & 4 \\ 0 & 4 & 9 \end{bmatrix} \begin{bmatrix} -2 \\ 1 \\ 7 \end{bmatrix}
	$$
$$
(AB)_{col2} = \begin{bmatrix} (3)(-2) + (-2)(1) + (7)(7) \\ (6)(-2) + (5)(1) + (4)(7) \\ (0)(-2) + (4)(1) + (9)(7) \end{bmatrix} = \begin{bmatrix} 41 \\ 21 \\ 67 \end{bmatrix}
$$
$$
(AB)_{col2} = \begin{bmatrix} -6+ (-2) + 49 \\ -12 + 5 + 28 \\ 0 + 4 + 63 \end{bmatrix} = \begin{bmatrix} 41 \\ 21 \\ 67 \end{bmatrix}
$$
### Q. 8(a)
$$
\text{Find the first column of } AB
$$
Using the column method, we extract matrix A and only the first column of matrix B.
$$
A = \begin{bmatrix} 3 & -2 & 7 \\ 6 & 5 & 4 \\ 0 & 4 & 9 \end{bmatrix}, \quad B_{col1} = \begin{bmatrix} 6 \\ 0 \\ 7 \end{bmatrix}
$$
Multiply the entire matrix A by this single column vector.
$$
A \times B_{col1} = \begin{bmatrix} 
(3)(6) + (-2)(0) + (7)(7) \\ 
(6)(6) + (5)(0) + (4)(7) \\ 
(0)(6) + (4)(0) + (9)(7) 
\end{bmatrix}
$$
Complete the addition to isolate the first column of the product matrix.
$$
A \times B_{col1} = \begin{bmatrix} 18 + 0 + 49 \\ 36 + 0 + 28 \\ 0 + 0 + 63 \end{bmatrix} = \begin{bmatrix} 67 \\ 64 \\ 63 \end{bmatrix}
$$
### **Q. 11(b) **
$$
\begin{aligned}
& \text{In each part of Exercises 11-12, find matrices A, x, and b that express} \\
& \text{the given linear system as a single matrix equation } Ax=b \text{ and write out this matrix equation.} \\
& 4x_1 \quad\quad - 3x_3 + x_4 = 1 \\ 
& 5x_1 + x_2 \quad\quad - 8x_4 = 3 \\ 
& 2x_1 - 5x_2 + 9x_3 - x_4 = 0 \\ 
& \quad\quad 3x_2 - x_3 + 7x_4 = 2
\end{aligned}
$$
* This linear system consists of equations with four variables.
* To convert this to a matrix equation, map the coefficients into a matrix, placing a 0 wherever a variable is missing from a specific equation.
$$
\begin{bmatrix} 4 & 0 & -3 & 1 \\ 5 & 1 & 0 & -8 \\ 2 & -5 & 9 & -1 \\ 0 & 3 & -1 & 7 \end{bmatrix} \begin{bmatrix} x_{1} \\ x_{2} \\ x_{3} \\ x_{4} \end{bmatrix} = \begin{bmatrix} 1 \\ 3 \\ 0 \\ 2 \end{bmatrix}
$$
### Q. 12(b)
$$
\text{Express the linear system as a single matrix equation } Ax=b: \\
5x_{1} + 3x_{2} + 3x_{3} = -5 \\
-x_{1} - 3x_{2} - 2x_{3} = 3 \\
-4x_{2} + x_{3} = 0
$$
We separate the equations into a coefficient matrix (A), a variable vector (x), and a constants vector (b).
$$
A = \begin{bmatrix} 5 & 3 & 3 \\ -1 & -3 & -2 \\ 0 & -4 & 1 \end{bmatrix}
$$
Notice that the third equation lacks an x1​ term, so its coefficient is 0. We combine everything into the Ax=b format.
$$
\begin{bmatrix} 5 & 3 & 3 \\ -1 & -3 & -2 \\ 0 & -4 & 1 \end{bmatrix} \begin{bmatrix} x_{1} \\ x_{2} \\ x_{3} \end{bmatrix} = \begin{bmatrix} -5 \\ 3 \\ 0 \end{bmatrix}
$$
### Q. 13(a)
$$
\begin{aligned}
& \text{Express the matrix equation as a system of linear equations:} \\
& \begin{bmatrix} 5 & 6 & -7 \\ -1 & -2 & 3 \\ 0 & 4 & -1 \end{bmatrix} \begin{bmatrix} x_{1} \\ x_{2} \\ x_{3} \end{bmatrix} = \begin{bmatrix} 2 \\ 0 \\ 3 \end{bmatrix}
\end{aligned}
$$
We perform the matrix multiplication on the left side. Each row of the 3×3 matrix multiplies by the variable vector.
$$
\begin{matrix} 
5x_{1} + 6x_{2} - 7x_{3} \\ 
-x_{1} - 2x_{2} + 3x_{3} \\ 
0x_{1} + 4x_{2} - x_{3} 
\end{matrix}
$$

Set each resulting expression equal to its corresponding row in the constants vector on the right side.
$$
\begin{aligned} 
5x_{1} + 6x_{2} - 7x_{3} &= 2 \\ 
-x_{1} - 2x_{2} + 3x_{3} &= 0 \\ 
4x_{2} - x_{3} &= 3 
\end{aligned}
$$
### **Q. 14(b) 
$$
\begin{aligned}
& \text{In each part of Exercises 13-14, express the matrix equation as a system of linear equations.} \\
& \begin{bmatrix} 
3 & -2 & 0 & 1 \\ 
5 & 0 & 2 & -2 \\ 
3 & 1 & 4 & 7 \\ 
-2 & 5 & 1 & 6 
\end{bmatrix}
\begin{bmatrix} w \\ x \\ y \\ z \end{bmatrix} = 
\begin{bmatrix} 0 \\ 0 \\ 0 \\ 0 \end{bmatrix}
\end{aligned}
$$
* Here, you are reversing the process by converting a matrix equation back into a system of linear equations.
$$
\begin{bmatrix} 3 & -2 & 0 & 1 \\ 5 & 0 & 2 & -2 \\ 3 & 1 & 4 & 7 \\ -2 & 5 & 1 & 6 \end{bmatrix} \begin{bmatrix} w \\ x \\ y \\ z \end{bmatrix} = \begin{bmatrix} 0 \\ 0 \\ 0 \\ 0 \end{bmatrix}
$$
* Multiply each row of the 4×4 coefficient matrix by the column vector containing the variables.
$$
\begin{aligned} 3w - 2x + z &= 0 \\ 5w + 2y - 2z &= 0 \\ 3w + x + 4y + 7z &= 0 \\ -2w + 5x + y + 6z &= 0 \end{aligned}
$$
### Q. 15
$$
\begin{aligned}
& \text{Find all values of } k \text{, if any, that satisfy the equation:} \\
& \begin{bmatrix} k & 1 & 1 \end{bmatrix} \begin{bmatrix} 1 & 1 & 0 \\ 1 & 0 & 2 \\ 0 & 2 & -3 \end{bmatrix} \begin{bmatrix} k \\ 1 \\ 1 \end{bmatrix} = 0
\end{aligned}
$$
First, multiply the initial 1×3 row vector by the 3×3 matrix.
$$
\begin{bmatrix} 
(k)(1)+(1)(1)+(1)(0) & (k)(1)+(1)(0)+(1)(2) & (k)(0)+(1)(2)+(1)(-3) 
\end{bmatrix}
$$
Simplify this to get a new row vector.
$$
= \begin{bmatrix} k+1 & k+2 & -1 \end{bmatrix}
$$
Substitute this new vector back into the equation and multiply it by the final column vector.
$$
\begin{bmatrix} k+1 & k+2 & -1 \end{bmatrix} \begin{bmatrix} k \\ 1 \\ 1 \end{bmatrix} = 0
$$
Expand the dot product into an algebraic equation.
$$
(k+1)(k) + (k+2)(1) + (-1)(1) = 0
$$
Distribute the terms and combine them to form a standard quadratic equation.
$$
k^{2} + k + k + 2 - 1 = 0 \implies k^{2} + 2k + 1 = 0
$$
Factor the perfect square trinomial to solve for k.
$$
(k+1)^{2} = 0 \implies k = -1
$$
### **Q. 16**

$$\begin{bmatrix} 2 & 2 & k \end{bmatrix} \begin{bmatrix} 1 & 2 & 0 \\ 2 & 0 & 3 \\ 0 & 3 & 1 \end{bmatrix} \begin{bmatrix} 2 \\ 2 \\ k \end{bmatrix} = 0$$

Multiplying the row vector by the $3 \times 3$ matrix

$$\begin{bmatrix} 2 & 2 & k \end{bmatrix} \begin{bmatrix} 1 & 2 & 0 \\ 2 & 0 & 3 \\ 0 & 3 & 1 \end{bmatrix} = \begin{bmatrix} (2)(1) + (2)(2) + (k)(0) & (2)(2) + (2)(0) + (k)(3) & (2)(0) + (2)(3) + (k)(1) \end{bmatrix}$$

Simplifying the resulting row vector

$$\begin{bmatrix} 2+4+0 & 4+0+3k & 0+6+k \end{bmatrix} = \begin{bmatrix} 6 & 4+3k & 6+k \end{bmatrix}$$

Multiplying the new row vector by the column vector

$$\begin{bmatrix} 6 & 4+3k & 6+k \end{bmatrix} \begin{bmatrix} 2 \\ 2 \\ k \end{bmatrix} = 0$$

Expanding the dot product
$$(6)(2) + (4+3k)(2) + (6+k)(k) = 0$$

Simplifying into a standard quadratic equation

$$12 + 8 + 6k + 6k + k^2 = 0$$

$$k^2 + 12k + 20 = 0$$

Factoring the quadratic equation

$$(k + 10)(k + 2) = 0$$

Solving for $k$

$$k + 10 = 0 \implies k = -10$$

$$k + 2 = 0 \implies k = -2$$