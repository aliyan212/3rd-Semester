## 1. Converting any Base to Decimal (Base 10)
**The Concept:** This is the **Sum of Weights Method**. Every digit in a number sits in a "seat" that has a specific value (weight). To find the total value, you multiply each digit by its weight and add them all up.
### Example: Binary to Decimal
**Problem:** Convert $(1101.101)_{2}​$ to Base 10. )
$$
\begin{aligned}
& (1 \times 2^3) + (1 \times 2^2) + (0 \times 2^1) + (1 \times 2^0) + (1 \times 2^{-1}) + (0 \times 2^{-2}) + (1 \times 2^{-3}) \\
&= 8 + 4 + 0 + 1 + 0.5 + 0 + 0.125 \\
&= \mathbf{13.625_{10}}
\end{aligned}
$$
### Example: Hexadecimal to Decimal
**Problem:** Convert $(AF.9)_{16}​$ to Base 10. _(Note: A=10,F=15)_
$$
\begin{aligned}
& (10 \times 16^1) + (15 \times 16^0) + (9 \times 16^{-1}) \\
&= 160 + 15 + 0.5625 \\
&= \mathbf{175.5625_{10}}
\end{aligned}
$$
## 2. Converting Decimal to any other Base
**The Concept:** When moving _away_ from Decimal, we split the number into two separate processes:
1. **Integer Part:** Use **Repeated Division** by the target base. Record the remainders from **bottom to top**.
2. **Fractional Part:** Use **Successive Multiplication** by the target base. Record the integer parts from **top to bottom**.
### Example: Decimal to Binary (Integer Part)
**Problem:** Convert $(21)_{10}$​ to Binary.
$$
\begin{aligned}
21 \div 2 &= 10 \text{ rem: } \mathbf{1} \text{ (LSB)} \\
10 \div 2 &= 5 \text{ rem: } \mathbf{0} \\
5 \div 2 &= 2 \text{ rem: } \mathbf{1} \\
2 \div 2 &= 1 \text{ rem: } \mathbf{0} \\
1 \div 2 &= 0 \text{ rem: } \mathbf{1} \text{ (MSB)} \\
\text{Result} &= \mathbf{10101_2}
\end{aligned}
$$
### Example: Decimal to Binary (Fractional Part)
**Problem:** Convert $(0.12)_{10}$​ to Binary.
$$
\begin{aligned}
0.12 \times 2 &= \mathbf{0}.24 \\
0.24 \times 2 &= \mathbf{0}.48 \\
0.48 \times 2 &= \mathbf{0}.96 \\
0.96 \times 2 &= \mathbf{1}.92 \\
\text{Result} &\approx \mathbf{.0001_2}
\end{aligned}
$$
## 3. Conversions Between Arbitrary Bases
**The Concept:** If you want to convert from a "weird" base (like Base 7) to another "weird" base (like Base 20), you must use **Decimal as a bridge**. You cannot jump directly; you must go:
Base X⟶Base 10⟶Base Y
### Example: Base 7 to Base 20
**Problem:** Convert $(125)_7​$ to Base 20.
**Step 1: Convert to Decimal**
$$
\begin{aligned}
& (1 \times 7^2) + (2 \times 7^1) + (5 \times 7^0) \\
&= 49 + 14 + 5 \\
&= \mathbf{68_{10}}
\end{aligned}
$$
Step 2: Convert Decimal to Base 20
$$
\begin{aligned}
68 \div 20 &= 3 \text{ rem: } \mathbf{8} \\
3 \div 20 &= 0 \text{ rem: } \mathbf{3} \\
\text{Result} &= \mathbf{38_{20}}
\end{aligned}
$$
### Example: Base 5 to Base 13
**Problem:** Convert $(324)_5$​ to Base 13.
**Step 1: Convert to Decimal**
$$
\begin{aligned}
& (3 \times 5^2) + (2 \times 5^1) + (4 \times 5^0) \\
&= 75 + 10 + 4 \\
&= \mathbf{89_{10}}
\end{aligned}
$$
Step 2: Convert Decimal to Base 13
$$
\begin{aligned}
89 \div 13 &= 6 \text{ rem: } \mathbf{11} \text{ (which is } \mathbf{B} \text{)} \\
6 \div 13 &= 0 \text{ rem: } \mathbf{6} \\
\text{Result} &= \mathbf{6B_{13}}
\end{aligned}
$$
