## 1. SR vs. JK Behavior

The primary purpose of the JK Latch is to resolve the undefined/invalid state of the SR Latch. By crisscrossing the final outputs back to the input gates, the circuit uses its own current state to determine how to handle a `1, 1` input.

As shown , the function tables compare directly:

**SR Latch Function:**

$$\begin{array}{cc|c} S & R & Q \\ \hline 0 & 0 & \text{Hold} \\ 0 & 1 & 0 \\ 1 & 0 & 1 \\ 1 & 1 & \text{Invalid} \end{array}$$

**JK Latch Function:**

$$\begin{array}{cc|c} J & K & Q_n \\ \hline 0 & 0 & \text{Hold} \\ 0 & 1 & 0 \\ 1 & 0 & 1 \\ 1 & 1 & \text{Toggle} \end{array}$$

## 2. Circuit Diagram (NAND Implementation)

This is the schematic you drew at the top of the page. Notice how it is essentially a clocked SR latch, but with the outputs $Q$ and $\overline{Q}$ fed all the way back into the front steering NAND gates.

![[JK Flip Flop.png]]

---

## 3. The Analytical Tables

These are the tables which explicitly map out the math behind the JK logic.
### A. Characteristic Table

This table defines exactly what the next state ($Q_{n+1}$) will be based on the current inputs ($J, K$) and the current state ($Q_n$).

$$\begin{array}{ccc|c} J & K & Q_n & Q_{n+1} \\ \hline 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 1 \\ 0 & 1 & 0 & 0 \\ 0 & 1 & 1 & 0 \\ 1 & 0 & 0 & 1 \\ 1 & 0 & 1 & 1 \\ 1 & 1 & 0 & 1 \\ 1 & 1 & 1 & 0 \end{array}$$

_(Notice the last two rows: When $J=1$ and $K=1$, the next state is always the exact opposite of the current state $Q_n$. This is the Toggle feature in action)._

### B. Excitation Table

This table is used backward for circuit design. It tells you what inputs to apply to $J$ and $K$ if you want to force a specific state transition.

$$\begin{array}{cc|cc} Q_n & Q_{n+1} & J & K \\ \hline 0 & 0 & 0 & X \\ 0 & 1 & 1 & X \\ 1 & 0 & X & 1 \\ 1 & 1 & X & 0 \end{array}$$
### 4. K-Map Derivation for the Characteristic Equation

To find the equation for the Next State ($Q_{n+1}$), we plot the outputs from the JK Characteristic Table onto a 3-variable K-Map based on the inputs $J$, $K$, and $Q_n$.

Unlike the SR Flip-Flop, the JK Flip-Flop has no "Invalid" states, meaning there are absolutely no "Don't Cares" ($X$) to use as wildcards. We must rely entirely on the definitive `1`s.

$$\begin{array}{c|c|c|c|c} J \backslash K Q_n & 00 & 01 & 11 & 10 \\ \hline 0 & 0 & 1 & 0 & 0 \\ \hline 1 & 1 & 1 & 0 & 1 \end{array}$$

**Grouping the K-Map:**

We have four `1`s on the board, and we can group them into two distinct pairs (loops of 2).

1. **Group 1 (The Bottom Corners):** Look at the bottom row ($J=1$). There is a `1` in the `00` column and a `1` in the `10` column. Because K-Maps wrap around the edges, we can group these two corners together.
    - Across these two cells, $K$ changes from $0$ to $1$, so it is eliminated.
    - The constant variables are $J=1$ and $Q_n=0$.
    - **Resulting Term:** $J\overline{Q}_n$
2. **Group 2 (The Vertical Column):** Look at the column where $K=0$ and $Q_n=1$ (the `01` column). There is a `1` in the top row and a `1` in the bottom row. We group these vertically.
    - Across these two cells, $J$ changes from $0$ to $1$, so it is eliminated.
    - The constant variables are $K=0$ and $Q_n=1$.
    - **Resulting Term:** $\overline{K}Q_n$

**The Final Derived Equation:**

By ORing these two groups together, we get the minimized Characteristic Equation that governs the JK Flip-Flop:

$$Q_{n+1} = J\overline{Q}_n + \overline{K}Q_n$$