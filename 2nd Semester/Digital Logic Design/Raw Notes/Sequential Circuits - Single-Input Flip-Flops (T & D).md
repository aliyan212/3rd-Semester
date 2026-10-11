While SR and JK flip-flops offer multiple control inputs, we often only need a circuit to do one of two specific things: act as a pure memory delay (D) or act as a frequency toggler (T). We can create these single-input flip-flops by mathematically modifying our existing dual-input circuits.

---

## 1. The T (Toggle) Flip-Flop

The T flip-flop is created by tying the $J$ and $K$ inputs of a JK Flip-Flop together into a single wire called $T$.

- If $T = 0$, both $J$ and $K$ receive `0`, meaning the circuit Holds its state.
- If $T = 1$, both $J$ and $K$ receive `1`, meaning the circuit Toggles its state on the clock edge.

Because holding $T=1$ causes the output to invert on every single clock cycle, the T Flip-Flop is widely used to build binary counters and frequency dividers (it cuts the clock frequency exactly in half).

### Circuit Diagram

![[T Flip Flop.png]]
### Fundamental Tables

**Truth Table (Function Table):**

$$\begin{array}{cc|c} Clk & T & Q_{n+1} \\ \hline 0 & 0 & Q_n \text{ (No Change)} \\ 1 & 1 & \overline{Q}_n \text{ (Toggle)} \end{array}$$

**Characteristic Table:**

$$\begin{array}{cc|c} T & Q_n & Q_{n+1} \\ \hline 0 & 0 & 0 \\ 0 & 1 & 1 \\ 1 & 0 & 1 \\ 1 & 1 & 0 \end{array}$$

**Excitation Table:**

$$\begin{array}{cc|c} Q_n & Q_{n+1} & T \\ \hline 0 & 0 & 0 \\ 0 & 1 & 1 \\ 1 & 0 & 1 \\ 1 & 1 & 0 \end{array}$$

### Characteristic Equation

If you look closely at the Characteristic Table, the output $Q_{n+1}$ is `1` only when $T$ and $Q_n$ are _different_. This is the exact definition of an Exclusive-OR (XOR) gate.

$$Q_{n+1} = T \oplus Q_n$$

_(Expanded: $Q_{n+1} = T\overline{Q}_n + \overline{T}Q_n$)_

---

## 2. The D (Data/Delay) Flip-Flop

The D flip-flop is created by attaching an inverter (NOT gate) between the $S$ and $R$ inputs of an SR Flip-Flop, creating a single input $D$.

- This guarantees that $S$ and $R$ are always opposites, completely eliminating the Invalid ($1, 1$) state.
- Whatever data is on the $D$ pin is simply passed through to the $Q$ output on the active clock edge.

Because it just captures and holds the input, it is the standard building block for computer memory (RAM) and data registers.

### Circuit Diagram

![[D Flip Flop.png]]

### Fundamental Tables

**Truth Table (Function Table):**

$$\begin{array}{cc|c} Clk & D & Q_{n+1} \\ \hline 0 & X & Q_{n} \\ 1& 0 & 0\\ 1 & 1 & 1 \end{array}$$

**Characteristic Table:**

$$\begin{array}{cc|c} D & Q_n & Q_{n+1} \\ \hline 0 & 0 & 0 \\ 0 & 1 & 0 \\ 1 & 0 & 1 \\ 1 & 1 & 1 \end{array}$$

**Excitation Table:**

$$\begin{array}{cc|c} Q_n & Q_{n+1} & D \\ \hline 0 & 0 & 0 \\ 0 & 1 & 1 \\ 1 & 0 & 0 \\ 1 & 1 & 1 \end{array}$$

### Characteristic Equation

Because the next state ($Q_{n+1}$) completely ignores the current state ($Q_n$) and simply copies the $D$ input exactly, the equation is incredibly simple:

$$Q_{n+1} = D$$
