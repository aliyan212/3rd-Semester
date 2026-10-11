---
aliases:
  - IA-32 Registers
  - EFLAGS
  - Status Flags
  - Protected Mode
  - Binary Arithmetic
tags:
  - digital-logic-design
  - computer-architecture
  - ia-32
  - registers
  - assembly-language
status: complete
created: 2026-09-28
---

# IA-32 Registers, EFLAGS, and Protected Mode

> [!abstract] Overview
> This note details the full set of [[IA-32]] [[Registers|registers]], walks through worked binary arithmetic examples for each **[[EFLAGS]]** status flag, and reviews the memory model used in **[[Protected Mode]]**.

---

## General-Purpose Registers

High-speed storage locations inside the CPU used for arithmetic, data movement, and logical operations.

| Register | Role            | Notes                                                                                                       |
| -------- | --------------- | ----------------------------------------------------------------------------------------------------------- |
| **EAX**  | *Accumulator*   | Used heavily for arithmetic operations, mathematical logic, and handling return values from function calls. |
| **EBX**  | *Base Register* | Commonly used as a base pointer for memory access and array indexing.                                       |
| **ECX**  | *Loop Counter*  | Automatically decremented by loop instructions to control loop iterations.                                  |
| **EDX**  | *Data Register* | Used alongside EAX for complex arithmetic (multiplication and division) and for I/O port access.            |

---

## Index and Pointer Registers

These hold memory addresses to navigate data structures and the stack.

| Register | Role | Notes |
| --- | --- | --- |
| **ESP** | *Stack Pointer* | Always points to the current top of the stack. |
| **EBP** | *Base Pointer* | Serves as a fixed reference point for accessing local variables and parameters on the stack during function calls. Often called a "frame pointer" for this reason, though its formal name is Base Pointer. |
| **ESI / EDI** | *Index Registers* | Typically used as source (ESI) and destination (EDI) pointers for high-speed memory block transfers and string operations. |

---

## Specialized and Segment Registers

- **[[EIP]]** (Instruction Pointer): Holds the exact memory address of the next instruction the CPU needs to execute.

- **[[Segment Registers]]** (CS, DS, SS, ES, FS, GS): Hold pointers to different memory segments (Code, Data, Stack, and extra segments) to organize a program's structure.

- **[[EFLAGS]]**: A register where each individual bit acts as a status or control flag detailing the outcome of the last ALU operation.

---

## EFLAGS: Worked Binary Arithmetic Examples

## Carry Flag (CF)

> [!note] Definition
> Triggers on *unsigned* arithmetic that is out of range — a carry out of the most significant bit on addition, or a borrow required on subtraction.

> [!example] CF = 1 (carry out occurs)
>
> $$
> \begin{array}{r}
> 1001\ 0111 \\
> +\ 1010\ 1111 \\
> \hline
> 1\ 0100\ 0110
> \end{array}
> $$
>
> A 9th bit is produced, exceeding the 8-bit limit. **CF = 1**.

> [!example] CF = 0 (no carry out)
>
> $$
> \begin{array}{r}
> 1001\ 0111 \\
> +\ 0010\ 1111 \\
> \hline
> 1100\ 0110
> \end{array}
> $$
>
> The result fits entirely within 8 bits — no 9th bit is generated. **CF = 0**.

---

## Overflow Flag (OF)

> [!note] Definition
> Triggers when a *signed* result falls outside the valid range for the destination size.

| Bit Width | Valid Signed Range |
| --- | --- |
| 4-bit | −8 to 7 |
| 8-bit | −128 to 127 |
| 16-bit | −32768 to 32767 |
| 32-bit | −2147483648 to 2147483647 |

> [!example] 4-bit Example: $1111\ (-1) - 0101\ (5)$
>
> Compute via 2's complement addition. 2's complement of the subtrahend: $0101 \rightarrow 1011$ (−5).
>
> $$
> \begin{array}{r}
> 1111\ (-1) \\
> +\ 1011\ (-5) \\
> \hline
> 1\ 1010\ (-6)
> \end{array}
> $$
>
> Discard the carry out. Result: `1010` (−6).


> [!example] 8-bit Example: $1111\ 0110\ (-10) + 0101\ 1100\ (92)$
>
> $$
> \begin{array}{r}
> 1111\ 0110\ (-10) \\
> +\ 0101\ 1100\ (92) \\
> \hline
> 1\ 0101\ 0010\ (82)
> \end{array}
> $$
>
> Discard the carry out. Result: `0101 0010` (82).
>
> **Carry-in/carry-out check:** the carry *into* the MSB and the carry *out of* the MSB are both 1. $1 \oplus 1 = 0$, so **OF = 0**. This matches the range check: 82 is well within −128 to 127.

---

## Sign Flag (SF)

> [!note] Definition
> Set to 1 if the Most Significant Bit (MSB) of the result is 1 (the result is negative). Set to 0 if the MSB is 0.

> [!example] Worked Example: $6 - 13$
>
> **Step 1 — Represent 13 and find its negative:**
>
> $$
> \begin{array}{rl}
> 13 & = 0000\ 1101 \\
> \text{1's complement} & = 1111\ 0010 \\
> \text{2's complement} & = 1111\ 0011 \ \rightarrow -13
> \end{array}
> $$
>
> **Step 2 — Add 6 and −13:**
>
> $$
> \begin{array}{r}
> 0000\ 0110\ (6) \\
> +\ 1111\ 0011\ (-13) \\
> \hline
> 1111\ 1001\ (-7)
> \end{array}
> $$
>
> **Step 3 — Verify the magnitude:**
>
> $$
> \begin{array}{rl}
> \text{1's complement of } 1111\ 1001 & = 0000\ 0110 \\
> \text{2's complement} & = 0000\ 0111 = 7 \ \rightarrow -7
> \end{array}
> $$
>
> The MSB of the result is `1`, so **SF = 1**.

---

## Zero Flag (ZF)

> [!note] Definition
> Active only if the result is *completely* zero.

> [!example] ZF = 0 (OR operation)
>
> $$
> \begin{array}{r}
> 1111\ 0111 \\
> \text{OR}\ 1010\ 0001 \\
> \hline
> 1111\ 0111
> \end{array}
> $$
>
> The result is not all zero. **ZF = 0**.

> [!example] ZF = 1 (AND operation)
>
> $$
> \begin{array}{r}
> 0101\ 0110 \\
> \text{AND}\ 1010\ 1001 \\
> \hline
> 0000\ 0000
> \end{array}
> $$
>
> The entire result is zero. **ZF = 1**.

---

## Auxiliary Carry Flag (AC)

> [!note] Definition
> Triggers when addition produces a carry that moves from bit 3 into bit 4 — that is, from the lower nibble into the upper nibble.

> [!example] AC = 1
>
> $$
> \begin{array}{r}
> 0101\ 1110 \\
> +\ 1010\ 1101 \\
> \hline
> 1\ 0000\ 1011
> \end{array}
> $$
>
> The lower nibble (`1110 + 1101`) produces a carry into the upper nibble. **AC = 1**.

> [!example] AC = 0
>
> $$
> \begin{array}{r}
> 0101\ 1110 \\
> +\ 1010\ 0001 \\
> \hline
> 1111\ 1111
> \end{array}
> $$
>
> The lower nibble (`1110 + 0001 = 1111`) does *not* overflow into the upper nibble. **AC = 0**.

---

## Parity Flag (PF)

> [!note] Definition
> Triggers when the number of `1` bits in the lowest byte of the result is even.

> [!example] PF = 1
>
> $$
> \begin{array}{r}
> 0101\ 1110 \\
> +\ 1010\ 0001 \\
> \hline
> 1111\ 1111
> \end{array}
> $$
>
> The result contains exactly eight `1` bits. Since 8 is even, **PF = 1**.

---

## Summary Table

| Flag | Trigger Condition | Example Result |
| --- | --- | --- |
| **CF** | Unsigned result out of range | `1001 0111 + 1010 1111` → CF = 1 |
| **OF** | Signed result out of range | `1111 0110 + 0101 1100` → OF = 0 |
| **SF** | MSB of result is 1 | `6 - 13 = -7` → SF = 1 |
| **ZF** | Result is exactly zero | `0101 0110 AND 1010 1001` → ZF = 1 |
| **AC** | Carry from bit 3 to bit 4 | `0101 1110 + 1010 1101` → AC = 1 |
| **PF** | Even number of 1s in low byte | `0101 1110 + 1010 0001` → PF = 1 |

---

## Protected Mode Architecture

**[[Protected Mode]]** is the native operating state for modern OS environments like Linux and MS-Windows, designed explicitly for robust multitasking and system stability.

- **Memory Capabilities**: Grants access to 4 GB of addressable RAM using 32-bit addresses spanning from `00000000h` to `FFFFFFFFh`.

- **Partition Security**: Every running program is assigned its own memory partition. The processor hardware actively protects these partitions, preventing programs from interfering with or crashing each other.

- **Segment Descriptor Tables**: Memory program structures (code, data, and stack areas) are managed using **segment descriptors** stored in tables — primarily the **[[Global Descriptor Table]]** (GDT). Segment registers hold *selectors* that index into this table, not the descriptors themselves.

- **[[Flat Memory Model]]**: To simplify memory management for programmers, modern **[[MASM]]** (Microsoft Macro Assembler) applications use the Microsoft flat memory model, which overlays code, data, and stack segments into a single, continuous 32-bit address space.