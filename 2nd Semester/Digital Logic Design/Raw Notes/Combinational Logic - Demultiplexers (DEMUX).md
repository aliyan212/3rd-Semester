---
cssclasses: logic-notes
tags:
  - digital-logic
  - combinational-logic
  - demultiplexers
  - data-routing
  - exam-prep
---

# Demultiplexers (DEMUX): Architectures, Logic Expressions & Cascading Trees

> [!abstract] Core Concepts
> A **[[Demultiplexer (DEMUX)]]** is a combinational data distributor that takes a **single input line** and routes it to one of **$2^n$ output lines** based on the status of **$n$ select lines**.
> * **Architecture:** $1 \to 2^n$ (commonly known as a **"one-to-many"** circuit).
> * **Relation to Decoders:** A DEMUX is functionally equivalent to a **[[Binary Decoders | Decoder]] with an Enable pin**, where the data input $I$ acts as the active Enable signal.

---

## 1. Classification & Specifications Summary

| Type | Data Inputs ($I$) | Select Lines ($n$) | Output Lines ($2^n$) | Select Variables |
| :---: | :---: | :---: | :---: | :---: |
| **$1 \times 2$** | $1$ | $1$ | $2$ | $S$ |
| **$1 \times 4$** | $1$ | $2$ | $4$ | $S_1, S_0$ |
| **$1 \times 8$** | $1$ | $3$ | $8$ | $S_2, S_1, S_0$ |
| **$1 \times 16$** | $1$ | $4$ | $16$ | $S_3, S_2, S_1, S_0$ |

---

## 2. Low-Order Demultiplexers ($1 \times 2$ & $1 \times 4$)

### A. $1 \times 2$ Demultiplexer

#### Truth Table & Logic Equations

| $S$ | $Y_0$ | $Y_1$ |
| :---: | :---: | :---: |
| $0$ | $I$ | $0$ |
| $1$ | $0$ | $I$ |

$$\begin{aligned}
Y_0 &= \bar{S}I \\
Y_1 &= SI
\end{aligned}$$

---

### B. $1 \times 4$ Demultiplexer

#### Truth Table & Logic Equations

| $S_1$ | $S_0$ | $Y_0$ | $Y_1$ | $Y_2$ | $Y_3$ |
| :---: | :---: | :---: | :---: | :---: | :---: |
| $0$ | $0$ | **$I$** | $0$ | $0$ | $0$ |
| $0$ | $1$ | $0$ | **$I$** | $0$ | $0$ |
| $1$ | $0$ | $0$ | $0$ | **$I$** | $0$ |
| $1$ | $1$ | $0$ | $0$ | $0$ | **$I$** |

$$\begin{aligned}
Y_0 &= \bar{S}_1\bar{S}_0I \\
Y_1 &= \bar{S}_1S_0I \\
Y_2 &= S_1\bar{S}_0I \\
Y_3 &= S_1S_0I
\end{aligned}$$

---

## 3. High-Order Demultiplexers ($1 \times 8$ & $1 \times 16$)

### A. $1 \times 8$ Demultiplexer

#### Truth Table

| $S_2$ | $S_1$ | $S_0$ | $Y_0$ | $Y_1$ | $Y_2$ | $Y_3$ | $Y_4$ | $Y_5$ | $Y_6$ | $Y_7$ |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| $0$ | $0$ | $0$ | **$I$** | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ |
| $0$ | $0$ | $1$ | $0$ | **$I$** | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ |
| $0$ | $1$ | $0$ | $0$ | $0$ | **$I$** | $0$ | $0$ | $0$ | $0$ | $0$ |
| $0$ | $1$ | $1$ | $0$ | $0$ | $0$ | **$I$** | $0$ | $0$ | $0$ | $0$ |
| $1$ | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | **$I$** | $0$ | $0$ | $0$ |
| $1$ | $0$ | $1$ | $0$ | $0$ | $0$ | $0$ | $0$ | **$I$** | $0$ | $0$ |
| $1$ | $1$ | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | **$I$** | $0$ |
| $1$ | $1$ | $1$ | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | $0$ | **$I$** |

#### Boolean Equations
$$\begin{aligned}
Y_0 &= \bar{S}_2\bar{S}_1\bar{S}_0I &\quad Y_4 &= S_2\bar{S}_1\bar{S}_0I \\
Y_1 &= \bar{S}_2\bar{S}_1S_0I       &\quad Y_5 &= S_2\bar{S}_1S_0I \\
Y_2 &= \bar{S}_2S_1\bar{S}_0I       &\quad Y_6 &= S_2S_1\bar{S}_0I \\
Y_3 &= \bar{S}_2S_1S_0I             &\quad Y_7 &= S_2S_1S_0I
\end{aligned}$$

---

### B. $1 \times 16$ Demultiplexer

> [!note] Active Line Mapping
> For any output index $k \in [0, 15]$, $Y_k = I$ when the binary value of $(S_3S_2S_1S_0)_2 = k$; otherwise $Y_k = 0$.

| $S_3$ | $S_2$ | $S_1$ | $S_0$ | Active Output Line ($Y_n = I$) | Minterm Equivalent Logic |
| :---: | :---: | :---: | :---: | :---: | :--- |
| $0$ | $0$ | $0$ | $0$ | **$Y_0$** | $Y_0 = \bar{S}_3\bar{S}_2\bar{S}_1\bar{S}_0I$ |
| $0$ | $0$ | $0$ | $1$ | **$Y_1$** | $Y_1 = \bar{S}_3\bar{S}_2\bar{S}_1S_0I$ |
| $0$ | $0$ | $1$ | $0$ | **$Y_2$** | $Y_2 = \bar{S}_3\bar{S}_2S_1\bar{S}_0I$ |
| $0$ | $0$ | $1$ | $1$ | **$Y_3$** | $Y_3 = \bar{S}_3\bar{S}_2S_1S_0I$ |
| $0$ | $1$ | $0$ | $0$ | **$Y_4$** | $Y_4 = \bar{S}_3S_2\bar{S}_1\bar{S}_0I$ |
| $0$ | $1$ | $0$ | $1$ | **$Y_5$** | $Y_5 = \bar{S}_3S_2\bar{S}_1S_0I$ |
| $0$ | $1$ | $1$ | $0$ | **$Y_6$** | $Y_6 = \bar{S}_3S_2S_1\bar{S}_0I$ |
| $0$ | $1$ | $1$ | $1$ | **$Y_7$** | $Y_7 = \bar{S}_3S_2S_1S_0I$ |
| $1$ | $0$ | $0$ | $0$ | **$Y_8$** | $Y_8 = S_3\bar{S}_2\bar{S}_1\bar{S}_0I$ |
| $1$ | $0$ | $0$ | $1$ | **$Y_9$** | $Y_9 = S_3\bar{S}_2\bar{S}_1S_0I$ |
| $1$ | $0$ | $1$ | $0$ | **$Y_{10}$** | $Y_{10} = S_3\bar{S}_2S_1\bar{S}_0I$ |
| $1$ | $0$ | $1$ | $1$ | **$Y_{11}$** | $Y_{11} = S_3\bar{S}_2S_1S_0I$ |
| $1$ | $1$ | $0$ | $0$ | **$Y_{12}$** | $Y_{12} = S_3S_2\bar{S}_1\bar{S}_0I$ |
| $1$ | $1$ | $0$ | $1$ | **$Y_{13}$** | $Y_{13} = S_3S_2\bar{S}_1S_0I$ |
| $1$ | $1$ | $1$ | $0$ | **$Y_{14}$** | $Y_{14} = S_3S_2S_1\bar{S}_0I$ |
| $1$ | $1$ | $1$ | $1$ | **$Y_{15}$** | $Y_{15} = S_3S_2S_1S_0I$ |

---

## 4. Demultiplexer Tree Implementation (Cascading)

> [!tip] Tree Calculation Formula
> To construct a target DEMUX with $N$ outputs using smaller DEMUX units of capacity $P$:
> $$\text{Stage 1} = \frac{N}{P}, \quad \text{Stage 2} = \frac{\text{Stage 1}}{P}, \quad \dots \quad \implies \mathbf{\text{Total Blocks} = \sum \text{Stages}}$$

### Cascading Design Reference

| Target DEMUX      | Module Used                        | Staged Calculation                                                   | Total Units Required  | Schematic Diagram                           |
| :---------------- | :--------------------------------- | :------------------------------------------------------------------- | :-------------------: | :------------------------------------------ |
| **$1 \times 4$**  | $1 \times 2$                       | $\frac{4}{2} = 2 \implies \frac{2}{2} = 1$                           |   **$3$** ($2 + 1$)   | ![[1:4 DEMUX using 1:2 DEMUX.png]]          |
| **$1 \times 8$**  | $1 \times 4\text{ and }1 \times 2$ | Stage 1: $1 \times (1 \times 2)$<br>Stage 2: $2 \times (1 \times 4)$ |   **$3$** ($1 + 2$)   | ![[1x8 DEMUX using 1x4 and 1x2 DEMUX.png]]  |
| **$1 \times 8$**  | $1 \times 2$ only                  | $\frac{8}{2} = 4 \implies \frac{4}{2} = 2 \implies \frac{2}{2} = 1$  | **$7$** ($4 + 2 + 1$) | ![[1x8 DEMUX using only 1x2 DEMUX.png]]     |
| **$1 \times 16$** | $1 \times 8\text{ and }1 \times 2$ | Stage 1: $1 \times (1 \times 2)$<br>Stage 2: $2 \times (1 \times 8)$ |   **$3$** ($1 + 2$)   | ![[1:16 DEMUX using 1:8 and 1:2 DEMUX.png]] |
| **$1 \times 16$** | $1 \times 4$ only                  | $\frac{16}{4} = 4 \implies \frac{4}{4} = 1$                          |   **$5$** ($4 + 1$)   | ![[1x16 DEMUX using only 1x4 DEMUX.png]]    |
