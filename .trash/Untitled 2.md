# Combinational Logic: Multiplexers (MUX)

## 1. Introduction to Multiplexers

- A digital logic circuit that is capable of accepting several inputs and generating a single output is known as a multiplexer or MUX.
    
- The multiplexer functions as a data selector that takes many inputs and provides one selected output.
    
- In a multiplexer, there are 2n input lines and 1 output line, where n represents the number of select lines.
    
- Because of this specific architecture, the multiplexer is commonly referred to as a "many-to-one" circuit.
    

**Types of Multiplexers:** Multiplexers are primarily classified into four types based on their input and select line configurations:

1. 2-to-1 multiplexer (1 select line)
    
2. 4-to-1 multiplexer (2 select lines)
    
3. 8-to-1 multiplexer (3 select lines)
    
4. 16-to-1 multiplexer (4 select lines)
    

---

## 2. The 2x1 Multiplexer

- The 2×1 MUX is a fundamental circuit used to choose one signal from two inputs and transmit it to the output.
    
- It consists of two input lines (I0​,I1​), one output line (Y), and a single selection line (S).
    

**Truth Table:**

S (Select)01​Y (Output)I0​I1​​​

**Boolean Expression:** When the select line S is logic 0, I0​ is selected, and when S is logic 1, I1​ is selected.

Y=SI0​+SI1​

+1

---

## 3. The 4x1 Multiplexer

- A 4×1 MUX has four data inputs (I0​,I1​,I2​,I3​) and only one output (Y).
    
- It requires 2 select lines (S1​,S0​) for operation.
    

**Logic Rules:**

- When both select lines are logic 0 (S1​=0,S0​=0), I0​ is selected.
    
- When S1​ is logic 0 and S0​ is logic 1, I1​ is selected.
    
- When S1​ is logic 1 and S0​ is logic 0, I2​ is selected.
    
- When both select lines are logic 1 (S1​=1,S0​=1), I3​ is selected.
    

**Truth Table:**

S1​0011​S0​0101​Y (Output)I0​I1​I2​I3​​​

**Boolean Expression:**

Y=S1​S0​I0​+S1​S0​I1​+S1​S0​I2​+S1​S0​I3​

+1

---

## 4. The 8x1 Multiplexer

- In the 8×1 multiplexer, there are eight inputs (A0​ to A7​), 3 selection lines (S2​,S1​,S0​), and a single output (Y).
    
- Based on the binary combination present at the selection lines, one of the 8 inputs is connected to the output.
    

**Truth Table:**

S2​00001111​S1​00110011​S0​01010101​Y (Output)A0​A1​A2​A3​A4​A5​A6​A7​​​

**Boolean Expression:**

Y=S2​S1​S0​A0​+S2​S1​S0​A1​+S2​S1​S0​A2​+S2​S1​S0​A3​+S2​S1​S0​A4​+S2​S1​S0​A5​+S2​S1​S0​A6​+S2​S1​S0​A7​

---

## 5. The 16x1 Multiplexer

- The 16×1 multiplexer has 16 inputs (A0​ to A15​), 4 selection lines (S3​,S2​,S1​,S0​), and a single output (Y).
    
- Based on the specific combination of inputs present at the selection lines, one of the 16 inputs will be routed to the output.
    

**Truth Table:**

S3​0000000011111111​S2​0000111100001111​S1​0011001100110011​S0​0101010101010101​Y (Output)A0​A1​A2​A3​A4​A5​A6​A7​A8​A9​A10​A11​A12​A13​A14​A15​​​

**Boolean Expression:**

Y=S3​S2​S1​S0​A0​+S3​S2​S1​S0​A1​+S3​S2​S1​S0​A2​+...+S3​S2​S1​S0​A15​

_(Expands to cover all 16 minterms associated with their respective data lines)_.

---

## 6. Multiplexer Implementation (Cascading)

Higher-order multiplexers can be implemented using combinations of lower-order multiplexers. The mathematical approach to finding the number of required MUXes is defined by successive division of data lines.

### Implementation 1: 4:1 MUX using 2:1 MUX

- **Required MUX:** 4:1 (n=4 data lines)
    
    +1
    
- **Available MUX:** 2:1 (p=2 data lines)
    
    +1
    
- **Stage 1 (f):** n/p=4/2=2
    
- **Stage 2 (s):** f/p=2/2=1
    
- **Total 2:1 MUXes Required:** f+s=2+1=3
    

### Implementation 2: 8x1 MUX using 4x1 and 2x1 MUX

- We need two 4×1 multiplexers and one 2×1 multiplexer.
    
- **Stage 1:** For getting 8 data inputs, we need two 4×1 multiplexers (8 / 4 = 2).
    
    +1
    
- **Stage 2:** The 4×1 multiplexers produce two outputs total. To get the final output, we need one 2×1 multiplexer (2 / 2 = 1).
    
    +1
    
- **Total Required:** Two 4×1 MUXes and one 2×1 MUX.
    

### Implementation 3: 8x1 MUX using only 2x1 MUX

- **Required MUX:** 8:1 (n=8 data lines)
    
    +1
    
- **Available MUX:** 2:1 (p=2 data lines)
    
    +1
    
- **Stage 1 (f):** n/p=8/2=4
    
- **Stage 2 (s):** f/p=4/2=2
    
- **Stage 3 (t):** s/p=2/2=1
    
- **Total 2:1 MUXes Required:** f+s+t=4+2+1=7
    

### Implementation 4: 16:1 MUX using 8:1 and 2:1 MUX

- **Required MUX:** 16:1 (n=16 data lines)
    
    +1
    
- **Available MUXes:** 8:1 (p1​=8) and 2:1 (p2​=2)
    
    +1
    
- **Stage 1:** n/p1​=16/8=2 (Requires two 8:1 MUXes)
    
- **Stage 2:** f/p2​=2/2=1 (Requires one 2:1 MUX)
    
- **Total Required:** Two 8:1 MUXes and one 2:1 MUX
    

### Implementation 5: 16x1 MUX using only 4x1 MUX

- **Required MUX:** 16:1 (n=16 data lines)
    
    +1
    
- **Available MUX:** 4:1 (p=4 data lines)
    
    +1
    
- **Stage 1 (f):** n/p=16/4=4
    
- **Stage 2 (s):** f/p=4/4=1
    
- **Total 4:1 MUXes Required:** f+s=4+1=5