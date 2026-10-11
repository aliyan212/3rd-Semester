## The Golden Methodology (4 Steps)

To convert any flip-flop into another type, you are essentially designing a combinational logic circuit that sits in front of the **Available** flip-flop to make it behave like the **Desired** flip-flop.

You must always follow these 4 steps:

1. **Identify:** State what you _have_ (Available FF) and what you _want_ (Desired FF).
2. **The Conversion Table:** Create a master table. The inputs are the pins of the Desired FF and the current state ($Q_n$). Use the Desired FF's Characteristic logic to find the Next State ($Q_{n+1}$). Then, use the Available FF's Excitation Table to figure out what physical inputs are required to make that $Q_{n+1}$ happen.
3. **K-Map Derivation:** Plot the required inputs onto K-Maps to find their simplified Boolean equations.
4. **The Circuit Diagram:** Draw the Available FF and wire its inputs using the logic gates derived in Step 3.

---

## Conversion 1: SR to D Flip-Flop

- **Desired:** D Flip-Flop
- **Available:** SR Flip-Flop

**Step 2: The Conversion Table**

We use the D Flip-Flop logic ($Q_{n+1} = D$) to find the next state. Then we use the SR Excitation Table to figure out what $S$ and $R$ need to be to cause that transition.

$$\begin{array}{cc|c|cc} \text{Desired Input} & \text{Current State} & \text{Next State} & \text{Required Available Inputs} \\ D & Q_n & Q_{n+1} & S & R \\ \hline 0 & 0 & 0 & 0 & X \\ 0 & 1 & 0 & 0 & 1 \\ 1 & 0 & 1 & 1 & 0 \\ 1 & 1 & 1 & X & 0 \end{array}$$

**Step 3: K-Map Derivation**

From your conversion table, we plot the required inputs $S$ and $R$ onto separate 2-variable Karnaugh maps based on the inputs $D$ and $Q_n$.

**K-Map for S:**

$$\begin{array}{c|c|c} D \backslash Q_n & 0 & 1 \\ \hline 0 & 0 & 0 \\ \hline 1 & 1 & X \end{array}$$

- **Grouping:** We group the `1` and the Don't Care (`X`) in the bottom row ($D=1$).
    
- **Equation:** $S = D$
    

**K-Map for R:**

$$\begin{array}{c|c|c} D \backslash Q_n & 0 & 1 \\ \hline 0 & X & 1 \\ \hline 1 & 0 & 0 \end{array}$$

- **Grouping:** We group the `X` and the `1` in the top row ($D=0$).
    
- **Equation:** $R = \overline{D}$
    
If we plot $S$ and $R$ onto separate 2-variable K-Maps (for $D$ and $Q_n$), we get very simple loops:

- **For S:** A loop of 1s in the $D=1$ row. Equation:
$$S = D$$
- **For R:** A loop of 1s in the $D=0$ row. Equation:
$$R = \overline{D}$$

**Step 4: Circuit Diagram**

This mathematically proves the D-Latch/Flip-Flop architecture we covered previously. We simply attach an inverter to the $D$ input and route it to $R$.

![[SR To D.png]]

## Conversion 2: T to JK Flip-Flop

- **Desired:** JK Flip-Flop
    
- **Available:** T Flip-Flop
    

**Step 2: The Conversion Table**

We use the JK Characteristic logic to determine $Q_{n+1}$. Then we look at the T Excitation logic (remember, $T=1$ if the state changes, $T=0$ if it holds) to find the required $T$ input.

$$\begin{array}{ccc|c|c} \text{Desired Inputs} & & \text{Current} & \text{Next State} & \text{Req. Input} \\ J & K & Q_n & Q_{n+1} & T \\ \hline 0 & 0 & 0 & 0 & 0 \\ 0 & 0 & 1 & 1 & 0 \\ 0 & 1 & 0 & 0 & 0 \\ 0 & 1 & 1 & 0 & 1 \\ 1 & 0 & 0 & 1 & 1 \\ 1 & 0 & 1 & 1 & 0 \\ 1 & 1 & 0 & 1 & 1 \\ 1 & 1 & 1 & 0 & 1 \end{array}$$

**Step 3: K-Map Derivation**

We plot the required $T$ input onto a 3-variable K-Map based on the desired inputs ($J, K$) and the current state ($Q_n$).

**K-Map for T:**

$$\begin{array}{c|c|c|c|c} J \backslash K Q_n & 00 & 01 & 11 & 10 \\ \hline 0 & 0 & 0 & 1 & 0 \\ \hline 1 & 1 & 0 & 1 & 1 \end{array}$$

- **Grouping 1:** Group the `1`s at `100` and `110`. This eliminates $K$. The remaining term is $J\overline{Q}_n$.
- **Grouping 2:** Group the `1`s at `011` and `111`. This eliminates $J$. The remaining term is $KQ_n$.
- **Equation:** $T = J\overline{Q}_n + KQ_n$

- Group 1 groups the 1s where $J=1$ and $Q_n=0$.
- Group 2 groups the 1s where $K=1$ and $Q_n=1$.

Equation:

$$T = J\overline{Q}_n + KQ_n$$

**Step 4: Circuit Diagram**

We must use two AND gates and an OR gate to feed the correct logic into the $T$ pin.

![[T To JK.png]]

---

## Conversion 3: SR to JK Flip-Flop

- **Desired:** JK Flip-Flop
- **Available:** SR Flip-Flop

**Step 2: The Conversion Table**

We map all 8 possible combinations of $J, K, Q_n$ to find $Q_{n+1}$, and then use the SR Excitation logic to map out the required $S$ and $R$ inputs.

$$\begin{array}{ccc|c|cc} \text{Desired Inputs} & & \text{Current} & \text{Next State} & \text{Req. Inputs} \\ J & K & Q_n & Q_{n+1} & S & R \\ \hline 0 & 0 & 0 & 0 & 0 & X \\ 0 & 0 & 1 & 1 & X & 0 \\ 0 & 1 & 0 & 0 & 0 & X \\ 0 & 1 & 1 & 0 & 0 & 1 \\ 1 & 0 & 0 & 1 & 1 & 0 \\ 1 & 0 & 1 & 1 & X & 0 \\ 1 & 1 & 0 & 1 & 1 & 0 \\ 1 & 1 & 1 & 0 & 0 & 1 \end{array}$$

**Step 3: K-Map Derivation**

**K-Map for S:**

$$\begin{array}{c|c|c|c|c} J \backslash K Q_n & 00 & 01 & 11 & 10 \\ \hline 0 & 0 & X & 0 & 0 \\ \hline 1 & 1 & X & 0 & 1 \end{array}$$

- **Grouping:** We loop the `1`s at `100` and `110`. We _ignore_ the `X`s in the `01` column because looping them wouldn't help us form a valid 4-cell group with the existing `1`s.
- **Equation:** $S = J\overline{Q}_n$

**K-Map for R:**

$$\begin{array}{c|c|c|c|c} J \backslash K Q_n & 00 & 01 & 11 & 10 \\ \hline 0 & X & 0 & 1 & X \\ \hline 1 & 0 & 0 & 1 & 0 \end{array}$$

- **Grouping:** We loop the `1`s at `011` and `111`. We ignore the `X`s in the `00` and `10` columns.
- **Equation:** $R = KQ_n$

- **For S:** We group the 1s and Xs where $J=1$ and $Q_n=0$Equation:    $$S = J\overline{Q}_n$$
- **For R:** We group the 1s and Xs where $K=1$ and $Q_n=1$Equation:$$R = KQ_n$$
**Step 4: Circuit Diagram**

Look closely at this final diagram. By routing the outputs $Q$ and $Q'$ back to the front via AND gates, we have mathematically proven _exactly_ how the original JK Flip-Flop was invented to solve the SR Flip-Flop's invalid state!

![[SR to JK.png]]
