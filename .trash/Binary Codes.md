

##Binary Codes & Arithmetic

## 1. Classification of Binary Codes

**📝 Theory:**

Binary codes are broadly categorized into alphanumeric codes (for text and characters) and numeric codes (for mathematical operations and number representation).

- **Alphanumeric Codes:**
    
    - **ASCII:** 7-bit code (128 values). Represents 26 upper-case, 26 lower-case, and special characters.
        
    - **EBCDIC:** 8-bit code ($2^8 = 256$ values).
        
    - **Unicode:** Available in 8-bit, 16-bit, and 32-bit formats to represent global character sets.
        
- **Numeric Codes (BCD - Binary Coded Decimal):**
    
    - Represent decimal numbers directly in binary.
        
    - **Weighted Codes:** Each bit position has a specific mathematical weight.
        
        - Examples: `8421` (Standard BCD), `631-1`, `2421`, `3321`.
            
    - **Non-Weighted Codes:** Positional weights do not apply.
        
        - **Gray Code:** A unit distance code where only a single bit changes between two successive numbers.
            
        - **Excess-3 Code:** Created by adding 3 (`0011`) to the standard 8421 BCD value.
            

---

## 2. Standard Conversions Table

Here is the reference table you mapped out for Decimal numbers 0 through 9:

---

## 3. Gray Code Conversions

**📝 Theory:**

Conversions between Binary and Gray Code rely on **XOR Addition** (Exclusive OR). In XOR logic, if the bits are the same, the result is `0`. If the bits are different, the result is `1`.

### Binary to Gray Code

**Rule:** Bring down the Most Significant Bit (MSB) directly. Then, XOR each consecutive pair of adjacent bits in the binary number to get the next Gray code bit.

**🧮 KaTeX Equation (Convert Binary 5 to Gray Code):**

$$\begin{aligned} \text{Binary:} \quad & 0 \quad 1 \quad 0 \quad 1 \\ & \downarrow \quad \text{(XOR adjacent bits)} \\ \text{Gray:} \quad & 0 \quad 1 \quad 1 \quad 1 \end{aligned}$$

### Gray Code to Binary

**Rule:** Bring down the MSB directly. Then, XOR your _newly calculated_ binary bit diagonally with the _next_ Gray code bit to get the next binary bit.

**🧮 KaTeX Equation (Convert Gray Code 6 back to Binary):**

$$\begin{aligned} \text{Gray:} \quad & 0 \quad 1 \quad 0 \quad 1 \\ & \downarrow \quad \swarrow \quad \swarrow \quad \swarrow \quad \text{(Diagonal XOR)} \\ \text{Binary:} \quad & 0 \quad 1 \quad 1 \quad 0 \end{aligned}$$

---

## 4. Excess-3 Code Conversion

**📝 Theory:**

To convert a decimal number to Excess-3 code, you simply take its standard 4-bit Binary (BCD) representation and add `3` (which is `0011` in binary) to it.

**🧮 KaTeX Equation (Convert Decimal 0 to Excess-3):**

$$\begin{array}{ll} & 0000 \quad \text{(Decimal 0)} \\ + & 0011 \quad \text{(Add 3)} \\ \hline & 0011 \quad \text{(Excess-3 Code)} \end{array}$$

---

## 5. BCD Addition

**📝 Theory:**

In BCD (Binary Coded Decimal), each decimal digit is represented by exactly 4 bits. Because 4 bits can hold up to the number 15 (`1111`), but decimal digits only go up to 9 (`1001`), the binary values `1010` through `1111` (10 through 15) are considered **invalid**.

**The BCD Addition Rule:**

1. Add the numbers using standard binary addition.
    
2. If the 4-bit sum is $\le 9$ (`1001`) and there is no carry out, the result is **valid**.
    
3. If the 4-bit sum is $> 9$ OR if it generates a carry into the next nibble, the result is **invalid**. You must add `6` (`0110`) to that 4-bit group to correct it.
    

**🧮 KaTeX Equation (Example 1: Valid Result, 2 + 6):**

$$\begin{array}{lrl} & 0010 & (2) \\ + & 0110 & (6) \\ \hline & 1000 & (8 \rightarrow \text{Valid, } \le 9) \end{array}$$

**🧮 KaTeX Equation (Example 2: Invalid Result, 3 + 8):**

$$\begin{array}{lrl} & 0011 & (3) \\ + & 1000 & (8) \\ \hline & 1011 & (11 \rightarrow \text{Invalid, } > 9) \\ + & 0110 & (\text{Add 6 to correct}) \\ \hline & 0001 \quad 0001 & (1 \text{ and } 1 \text{ in BCD} = 11) \end{array}$$

**🧮 KaTeX Equation (Example 3: Invalid Carry-Out Result, 8 + 8):**

$$\begin{array}{lrl} & 1000 & (8) \\ + & 1000 & (8) \\ \hline & 10000 & (16 \rightarrow \text{Invalid carry generated}) \\ + & 0110 & (\text{Add 6 to correct}) \\ \hline & 0001 \quad 0110 & (1 \text{ and } 6 \text{ in BCD} = 16) \end{array}$$

---

Would you like me to map out BCD Subtraction rules next, or are you moving on to logic gates like AND, OR, and XOR?