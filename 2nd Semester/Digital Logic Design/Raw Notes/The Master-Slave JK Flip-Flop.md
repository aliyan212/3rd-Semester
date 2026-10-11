## 1. The Race-Around Condition

As discussed, a single-stage, level-triggered JK Latch is mathematically unstable. If you feed the outputs ($Q$ and $Q'$) directly back into the input steering gates while the clock is High (`1`) and inputs are $J=1, K=1$, the circuit will enter a **"Race-Around Condition."** Because it takes only a few nanoseconds for electrons to pass through the gates, the flip-flop will toggle, feed its new toggled state back to the inputs, toggle again, and continue oscillating wildly for as long as the clock remains High.

## 2. The Master-Slave Solution

To solve this, we break the feedback loop using a Master-Slave configuration.

- **The Master:** Receives $J$, $K$, the standard Clock signal, and the feedback from the Slave. It catches the new data when the clock is High.
- **The Slave:** Receives the outputs of the Master and an inverted Clock signal. It only updates the final output when the clock falls to Low.

Because the final output (which drives the feedback loop) only changes when the Master is safely locked, the circuit can only toggle exactly once per clock cycle.

### Circuit Diagram (NAND Implementation)

![[JK Master Slave Flip Flop.png|JK Master Slave Timing Diagram.png]]

## 3. Truth Table (Function Table)

To mathematically represent edge-triggered behavior, we use the falling-edge arrow ($\downarrow$) for the clock. If the clock is steady at 0, 1, or rising, the outputs ignore $J$ and $K$ and hold their state.

$$\begin{array}{ccc|c} Clk & J & K & Q_{n+1} \text{ (Next State)} \\ \hline 0 & X & X & Q_n \text{ (Hold)} \\ 1 & X & X & Q_n \text{ (Hold)} \\ \uparrow & X & X & Q_n \text{ (Hold)} \\ \downarrow & 0 & 0 & Q_n \text{ (Hold)} \\ \downarrow & 0 & 1 & 0 \text{ (Reset)} \\ \downarrow & 1 & 0 & 1 \text{ (Set)} \\ \downarrow & 1 & 1 & \overline{Q}_n \text{ (Toggle)} \end{array}$$

## 4. Timing Diagram Analysis

Timing diagram perfectly illustrates how the Master and Slave isolate the signals.

- **$Q_m$ (Master Output):** $Q_m$ changes while the Clock is High (transparent phase for the Master).
- **$Q_s$ (Slave / Final Output):** $Q_s$ stays perfectly flat until the exact moment the Clock falls (indicated by the dashed vertical lines dropping from the Clock signal).

![[JK Master Slave Timing Diagram.png]]

To clearly understand _why_ the feedback loop allows it to toggle safely without racing around, experiment with this Master-Slave JK timing simulator. Pay close attention to what the Master does when you hold `J=1` and `K=1`.