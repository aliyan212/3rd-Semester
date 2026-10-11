Here is exactly how you can add the "Weighted vs. Non-Weighted" concept to your Obsidian or AppFlowy notes.

I have formatted these examples using the same clean `array` structure so the column weights align perfectly over the binary bits.

# Weighted vs. Non-Weighted Binary Codes

**📝 Theory:**
A **weighted code** is a system where every bit position (column) has a specific, fixed mathematical value (a "weight"). To find the decimal equivalent, you simply multiply each bit by its column's weight and add them all together.

A **non-weighted code** (like Gray Code or Excess-3) does not assign mathematical values to columns. It is just a sequential pattern or logic rule, meaning you cannot calculate its decimal value by adding up columns.

---

### Example 1: The Standard 8421 Code (BCD)

This is standard binary. The column weights are powers of 2 (). Let's represent the decimal number **9**.

### Example 2: The 2421 Code

Engineers created other weighted codes to make hardware design (like subtraction circuits) easier. In this system, the weights are literally  and . Let's represent the decimal number **7**.

### Example 3: The 6 3 1 -1 Code

Weights can even be negative! If we want to represent the decimal number **5**, we need to turn on the `6` column and the `-1` column, because .

---

This structure directly answers *why* the numbers in your notes are grouped as "weighted" and proves the math behind them.

Would you like me to format your notes on BCD Addition (with the rule for adding `0110` when a number is invalid) into these clean arrays next?