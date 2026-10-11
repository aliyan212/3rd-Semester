---
cssclasses: logic-notes
tags:
  - digital-logic
  - binary-codes
  - bcd
  - exam-prep
---

# Binary Codes & Data Representation

> [!abstract] Classification Overview
> Binary codes are categorized into two primary domains: **Alphanumeric** (for text) and **Numeric** (for mathematical operations).

* **Alphanumeric Codes:**
  * **[[ASCII]]:** 7-bit code ($128$ values). Covers English letters, numbers, and standard symbols.
  * **[[EBCDIC]]:** 8-bit code ($2^8 = 256$ values). Primarily used in legacy IBM mainframes.
  * **[[Unicode]]:** 8-bit, 16-bit, and 32-bit formats designed to represent all global character sets.
* **Numeric Codes ([[BCD | Binary Coded Decimal]]):**
  * **Weighted Codes:** Each bit position carries a specific mathematical weight (e.g., standard **8421 BCD**, 631-1, 2421, 3321).
  * **Non-Weighted Codes:** Positional weights do not apply (e.g., **[[Gray Code]]**, **[[Excess-3]]**).

---

## 1. Standard Reference Table ($0-9$)

| Decimal | Binary (8421) | Gray Code | Excess-3 Code |
| :---: | :---: | :---: | :---: |
| **0** | $0000$ | $0000$ | $0011$ |
| **1** | $0001$ | $0001$ | $0100$ |
| **2** | $0010$ | $0011$ | $0101$ |
| **3** | $0011$ | $0010$ | $0110$ |
| **4** | $0100$ | $0110$ | $0111$ |
| **5** | $0101$ | $0111$ | $1000$ |
| **6** | $0110$ | $0101$ | $1001$ |
| **7** | $0111$ | $0100$ | $1010$ |
| **8** | $1000$ | $1100$ | $1011$ |
| **9** | $1001$ | $1101$ | $1100$ |

---

## 2. Gray Code Conversions

> [!info] The [[XOR Gate]] ($\oplus$) Logic
> Both conversions rely on Exclusive-OR logic: 
> * **Same Bits ($0\oplus0$, $1\oplus1$) $\implies 0$**
> * **Different Bits ($0\oplus1$, $1\oplus0$) $\implies 1$**

### Binary to Gray Code
**Rule:** Bring down the Most Significant Bit (MSB). XOR each consecutive pair of *adjacent binary bits* to get the next Gray code bit.

**Example: Convert Binary 5 ($0101$) to Gray Code**
$$\begin{array}{r c c c c c c c}
\text{Binary:} & 0 & \oplus & 1 & \oplus & 0 & \oplus & 1 \\
& \downarrow & & \downarrow & & \downarrow & & \downarrow \\
\text{Gray:} & \mathbf{0} & & \mathbf{1} & & \mathbf{1} & & \mathbf{1}
\end{array}$$

### Gray Code to Binary
**Rule:** Bring down the MSB directly. XOR your newly calculated binary bit *diagonally* with the next Gray code bit.

**Example: Convert Gray Code 6 ($0101$) to Binary**
$$\begin{array}{r c c c c c c c}
\text{Gray:} & 0 & & 1 & & 0 & & 1 \\
& \downarrow & \nearrow & \downarrow & \nearrow & \downarrow & \nearrow & \downarrow \\
\text{Binary:} & \mathbf{0} & \oplus & \mathbf{1} & \oplus & \mathbf{1} & \oplus & \mathbf{0}
\end{array}$$

---

## 3. Excess-3 Code Conversion

> [!tip] Conversion Rule
> To convert a decimal digit to **Excess-3**, take its standard 4-bit Binary (BCD) representation and **add $3$** ($0011_2$).

**Example: Decimal 0 to Excess-3**
$$\begin{array}{lrl}
& 0000 & (\text{Decimal } 0) \\
+ & 0011 & (\text{Add } 3) \\
\hline
& \mathbf{0011} & (\text{Excess-3 Code})
\end{array}$$

---

## 4. BCD (Binary Coded Decimal) Addition

> [!warning] The $+6$ Correction Rule
> In BCD, 4 bits represent digits $0-9$. Values $10-15$ ($1010 \to 1111$) are invalid.
> 1. Add numbers using standard binary addition.
> 2. **If sum $\le 9$ and no carry:** The result is valid.
> 3. **If sum $> 9$ OR generates a carry-out:** The result is invalid. **Add $6$ ($0110$)** to that 4-bit block to correct it.

### Example 1: Valid Result ($2 + 6$)
$$\begin{array}{lrl}
& 0010 & (2) \\
+ & 0110 & (6) \\
\hline
& \mathbf{1000} & (8 \implies \text{Valid, } \le 9)
\end{array}$$

### Example 2: Invalid Sum Result ($3 + 8$)
$$\begin{array}{lrl}
& 0011 & (3) \\
+ & 1000 & (8) \\
\hline
& 1011 & (11 \implies \text{Invalid, } > 9) \\
+ & 0110 & (\text{Add 6 to correct}) \\
\hline
& \mathbf{0001 \quad 0001} & (\text{BCD for } 11)
\end{array}$$

### Example 3: Invalid Carry-Out Result ($8 + 8$)
$$\begin{array}{lrl}
& 1000 & (8) \\
+ & 1000 & (8) \\
\hline
& 10000 & (16 \implies \text{Invalid carry generated}) \\
+ & 0110 & (\text{Add 6 to correct}) \\
\hline
& \mathbf{0001 \quad 0110} & (\text{BCD for } 16)
\end{array}$$