### Fundamental Number Systems
## 1. Decimal System (Base 10)
*   **Definition:** The standard system used by humans for everyday counting and mathematics.
*   **Radix (Base):** 10.
*   **Digits Used:** {0,1,2,3,4,5,6,7,8,9}.
*   **Characteristics:** It is a positional numeral system where the value of a digit depends on its position relative to the decimal point.
*   **Standard Notation:** (n)10​
## 2. Binary System (Base 2)
*   **Definition:** The native language of electronic machinery and computer hardware.
*   **Radix (Base):** 2.
*   **Digits Used:** {0,1} (known as **bits**).
*   **Logic Context:** In digital circuits, **0** represents Low Voltage (OFF) and **1** represents High Voltage (ON).
*   **Standard Notation:** (n)2​
## 3. Octal System (Base 8)
*   **Definition:** A system used primarily as a shorthand for binary to make long strings of bits more readable.
*   **Radix (Base):** 8.
*   **Digits Used:** {0,1,2,3,4,5,6,7}.
*   **Binary Relationship:** One octal digit represents exactly **3 binary bits**.
*   **Standard Notation:** (n)8​
## 4. Hexadecimal System (Base 16)
*   **Definition:** The most common shorthand used in modern computing for memory addresses, color codes, and debugging.
*   **Radix (Base):** 16.
*   **Digits Used:** {0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F}.
	*   A=10,B=11,C=12,D=13,E=14,F=15.
*   **Binary Relationship:** One hexadecimal digit represents exactly **4 binary bits**.
*   **Standard Notation:** (n)16​
---
### General Definitions
## Number System
A **Number System** is a mathematical framework used to represent and express numbers through a consistent set of symbols or digits. In Digital Logic Design (DLD), these systems allow us to communicate information in a way that electronic hardware can process.
## The Radix (Base)
The **Radix** of a number system specifies the total number of unique symbols (digits) used to represent values in that system.
## Positional Weight
In any system with radix r, a number can be represented as a sum of its digits multiplied by the weight of their positions.
$$
\text{Value} = \sum (d_i \times r^i)
$$
*   **MSB (Most Significant Bit/Digit):** The leftmost digit with the highest weight.
*   **LSB (Least Significant Bit/Digit):** The rightmost digit with the lowest weight.
