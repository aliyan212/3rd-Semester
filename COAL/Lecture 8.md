---
aliases: [Operand Types, MOV Instruction, MOVZX, MOVSX, XCHG, Direct-Offset Operands, Effective Address]
tags: [assembly-language, masm, ia-32, mov, operands, exam-critical]
status: active
created: 2026-10-14
---

# Operands, MOV, and Data Transfer Instructions

> [!abstract] Overview
> This note covers the three **[[Operand Types|operand types]]**, the shorthand notation used in instruction manuals, **[[Direct Memory Operands]]**, the strict rules of the **[[MOV Instruction]]**, **[[MOVZX]]** and **[[MOVSX]]** for widening values, **[[XCHG]]**, and **[[Direct-Offset Operands]]** for array access. It closes with the solved slide activities.

---

## 1. Operand Types

An **operand** is the value, register, or memory location that an instruction works on. There are three basic types.

| Type | Description | Examples |
| --- | --- | --- |
| **Immediate** | A constant integer of 8, 16, or 32 bits. Fixed at assembly time, so it is encoded directly inside the machine instruction. | `5`, `100`, `20h` |
| **Register** | The name of a CPU register. The assembler converts the name to a binary number and encodes it in the instruction. | `AL`, `BX`, `EAX` |
| **Memory** | A reference to a location in system memory. Either the exact address is encoded in the instruction, or a register holds the address. | `var1`, `count` |

---

## 2. Instruction Operand Notation

Manuals use shorthand to show which operand types and sizes an instruction accepts.

| Symbol | Meaning |
| --- | --- |
| **`r8`** | 8-bit general register: `AH`, `AL`, `BH`, `BL`, `CH`, `CL`, `DH`, `DL` |
| **`r16`** | 16-bit general register: `AX`, `BX`, `CX`, `DX`, `SI`, `DI`, `SP`, `BP` |
| **`r32`** | 32-bit general register: `EAX`, `EBX`, `ECX`, `EDX`, `ESI`, `EDI`, `ESP`, `EBP` |
| **`reg`** | Any general-purpose register |
| **`sreg`** | 16-bit segment register: `CS`, `DS`, `SS`, `ES`, `FS`, `GS` |
| **`imm`** | Any 8-, 16-, or 32-bit immediate value |
| **`imm8`** | 8-bit immediate byte |
| **`imm16`** | 16-bit immediate word |
| **`imm32`** | 32-bit immediate doubleword |
| **`r/m8`** | 8-bit register **or** memory byte |
| **`r/m16`** | 16-bit register **or** memory word |
| **`r/m32`** | 32-bit register **or** memory doubleword |
| **`mem`** | Any 8-, 16-, or 32-bit memory operand |

---

## 3. Direct Memory Operands

A **direct memory operand** is a named reference (a variable label) pointing to storage in memory.

> [!note] Automatic Dereferencing
> When a variable name appears in an instruction, the assembler **dereferences** it. It goes to that memory address and fetches the value stored there.

The name can be written plain (`var1`) or in square brackets (`[var1]`). Both do the same thing in MASM.

~~~assembly
.data
var1 BYTE 10h

.code
mov al, var1    ; AL = 10h
mov al, [var1]  ; AL = 10h (alternate format)
~~~

---

## 4. The MOV Instruction

`MOV` copies data from a source operand to a destination operand.

~~~assembly
MOV destination, source
~~~

### Strict Rules

> [!warning] Five Rules for MOV
>
> 1. **Matching sizes**: both operands must be the same bit size (8 to 8, 16 to 16, 32 to 32).
>
> 2. **At most one memory operand**: memory-to-memory moves are not allowed in a single `MOV`.
>
> 3. **Protected registers**: `CS`, `EIP`, and `IP` cannot be the destination. Changing them directly would derail program execution.
>
> 4. **No immediate-to-segment moves**: a constant cannot go straight into `DS`, `ES`, `SS`, and so on. Pass it through a general register first.
>
> 5. **No immediate destinations**: `mov 25, al` is meaningless because the number 25 cannot be overwritten.

### Valid vs. Invalid Examples

~~~assembly
.data
count BYTE 100
wVal  WORD 2

.code
mov bl, count    ; Valid: both 8-bit
mov ax, wVal     ; Valid: both 16-bit
mov count, al    ; Valid: both 8-bit

mov al, wVal     ; ERROR: wVal is 16-bit, AL is 8-bit
mov ax, count    ; ERROR: count is 8-bit, AX is 16-bit
mov eax, count   ; ERROR: count is 8-bit, EAX is 32-bit
~~~

> [!note] Assembly-Time Errors
> The three invalid lines are rejected by the assembler because of operand size mismatches. The program never builds.

---

### Solved Activity: "Your Turn..." (Slide 8)

**Task:** Explain why each `MOV` statement is invalid.

~~~assembly
.data
bVal  BYTE  100
bVal2 BYTE  ?
wVal  WORD  2
dVal  DWORD 5

.code
mov ds, 45         ; a.
mov esi, wVal      ; b.
mov eip, dVal      ; c.
mov 25, bVal       ; d.
mov bVal2, bVal    ; e.
~~~

| Part | Statement | Reason Invalid |
| --- | --- | --- |
| **a.** | `mov ds, 45` | **Immediate to segment move.** `DS` is a segment register and `45` is an immediate. A constant cannot be moved directly into a segment register. |
| **b.** | `mov esi, wVal` | **Size mismatch.** `ESI` is 32-bit (`r32`) and `wVal` is a 16-bit `WORD`. |
| **c.** | `mov eip, dVal` | **Restricted destination.** `EIP` cannot be the destination of a `MOV`. |
| **d.** | `mov 25, bVal` | **Immediate destination.** `25` is a constant, not a writable storage location. |
| **e.** | `mov bVal2, bVal` | **Memory to memory.** Both operands are memory operands, and only one is allowed. |

---

## 5. Copying Smaller Values into Larger Destinations

A plain `MOV` cannot copy a `BYTE` into a 16-bit or 32-bit register. To widen a value legally, the CPU must be told how to fill the extra upper bits.

~~~mermaid
graph TD
    A[Copy small value into larger register] --> B{Is the value signed?}
    B -->|No, unsigned| C[MOVZX: fill upper bits with 0]
    B -->|Yes, signed| D[MOVSX: fill upper bits with the sign bit]
~~~

> [!warning] Shared Rule
> For both instructions, the **destination must be a register**.

### Zero Extension: MOVZX (Unsigned)

Fills the upper half of the destination with **zeros**.

~~~assembly
mov   bl, 10001111b
movzx ax, bl         ; zero-extension
~~~

$$
\begin{array}{rl}
\text{Source } (BL) & = 1000\ 1111 \\
\text{Destination } (AX) & = 0000\ 0000\ 1000\ 1111
\end{array}
$$

### Sign Extension: MOVSX (Signed)

Filling with zeros would turn a negative number positive by changing its leftmost bit from `1` to `0`. `MOVSX` instead fills the upper half with a **copy of the source's sign bit**.

~~~assembly
mov   bl, 10001111b
movsx ax, bl         ; sign-extension
~~~

$$
\begin{array}{rl}
\text{Source } (BL) & = 1000\ 1111 \quad (\text{sign bit} = 1) \\
\text{Destination } (AX) & = 1111\ 1111\ 1000\ 1111
\end{array}
$$

> [!note] If the Sign Bit Were 0
> If the leftmost bit of `BL` were `0`, `MOVSX` would fill the upper half with `0000 0000`, giving the same result as `MOVZX`.

| Instruction | Fills Upper Bits With | Use For |
| --- | --- | --- |
| **`MOVZX`** | `0` | Unsigned values |
| **`MOVSX`** | Copy of the sign bit | Signed values |

---

## 6. The XCHG Instruction

`XCHG` swaps the values of two operands.

> [!warning] Rules for XCHG
>
> 1. At least one operand must be a **register**. Two memory variables cannot be swapped directly.
>
> 2. **No immediate operands** are allowed.
>
> 3. Both operands must be the **same size**.

~~~assembly
.data
var1 WORD 1000h
var2 WORD 2000h

.code
xchg ax, bx      ; Valid: two 16-bit registers
xchg ah, al      ; Valid: two 8-bit registers
xchg var1, bx    ; Valid: 16-bit memory and 16-bit register
xchg eax, ebx    ; Valid: two 32-bit registers

xchg var1, var2  ; ERROR: two memory operands
~~~

> [!tip] Swapping Two Memory Variables
> Load one variable into a register first, then use `XCHG` between the register and the other variable.

---

## 7. Direct-Offset Operands

A **direct-offset operand** accesses an array element by adding a constant byte offset to a variable label.

> [!note] Effective Address (EA)
> Adding a constant to a data label produces an **Effective Address**, the exact memory address of the target element. That address is then dereferenced to fetch the value stored there.

### Byte Arrays (1 byte per step)

~~~assembly
.data
arrayB BYTE 10h, 20h, 30h, 40h

.code
mov al, arrayB+1    ; AL = 20h
mov al, [arrayB+1]  ; AL = 20h (alternative notation)
~~~

| Expression | Offset | Value |
| --- | --- | --- |
| `arrayB` | `+0` | `10h` |
| `arrayB+1` | `+1` | `20h` |
| `arrayB+2` | `+2` | `30h` |
| `arrayB+3` | `+3` | `40h` |

> [!question] Why doesn't `arrayB+1` produce `11h`?
> The `+1` is added to the **memory address** of `arrayB` at assembly time, not to the value `10h` stored inside it. Stepping 1 byte forward from the start lands on the second element, which holds `20h`.

### Word and Doubleword Arrays (stepping by byte size)

Memory addresses count **bytes**, whatever the data type. Offsets must therefore be multiples of the element size.

| Array Type | Bytes per Element | Offsets |
| --- | --- | --- |
| `WORD` | 2 | `+0`, `+2`, `+4`, `+6` |
| `DWORD` | 4 | `+0`, `+4`, `+8`, `+12` |

~~~assembly
.data
arrayW WORD  1000h, 2000h, 3000h
arrayD DWORD 1, 2, 3, 4

.code
mov ax, [arrayW+2]   ; AX = 2000h (2nd element)
mov ax, [arrayW+4]   ; AX = 3000h (3rd element)
mov eax, [arrayD+4]  ; EAX = 00000002h (2nd element)
~~~

> [!question] Will these statements assemble and run?
> ~~~assembly
> mov ax, [arrayW-2]   ; ??
> mov eax, [arrayD+16] ; ??
> ~~~
>
> **Yes, both assemble and run.** MASM does not bounds-check effective addresses. Both are still **out-of-bounds bugs**:
>
> 1. `[arrayW-2]` reads 2 bytes **before** `arrayW`, loading unrelated data into `AX`.
>
> 2. `arrayD` has four elements at offsets `+0`, `+4`, `+8`, and `+12`. `[arrayD+16]` reads 4 bytes **past the end**, pulling unrelated memory into `EAX`.

---

## 8. Solved Activities

### Activity 1: Rearranging a Doubleword Array 

**Task:** Rearrange `arrayD DWORD 1, 2, 3` so the array holds `3, 1, 2`.

| Position | Address | Initial Value |
| --- | --- | --- |
| 1st | `arrayD` (`+0`) | `1` |
| 2nd | `[arrayD+4]` (`+4`) | `2` |
| 3rd | `[arrayD+8]` (`+8`) | `3` |

~~~assembly
.data
arrayD DWORD 1, 2, 3

.code
mov  eax, arrayD        ; EAX = 1
xchg eax, [arrayD+4]    ; EAX = 2, array = 1, 1, 3
xchg eax, [arrayD+8]    ; EAX = 3, array = 1, 1, 2
mov  arrayD, eax        ; array = 3, 1, 2
~~~

| Step | Instruction | EAX | Array State |
| --- | --- | --- | --- |
| 1 | `mov eax, arrayD` | `1` | `1, 2, 3` |
| 2 | `xchg eax, [arrayD+4]` | `2` | `1, 1, 3` |
| 3 | `xchg eax, [arrayD+8]` | `3` | `1, 1, 2` |
| 4 | `mov arrayD, eax` | `3` | `3, 1, 2` |

---

### Activity 2: "Evaluate This..." Adding Three Bytes 

**Task:** Sum the three bytes below.

~~~assembly
.data
myBytes BYTE 80h, 66h, 0A5h
~~~

The true sum is:

$$80h + 66h + A5h = 128 + 102 + 165 = 395 = 18Bh$$

> [!warning] Why This Is a Trap
> `18Bh` is larger than `FFh` (255), so the result needs **more than 8 bits**.

#### Part 1: First Snippet 

~~~assembly
mov al, myBytes
add al, [myBytes+1]
add al, [myBytes+2]
~~~

This assembles and runs but gives the **wrong answer** because of 8-bit unsigned overflow.

| Step | Instruction | AL | CF | OF |
| --- | --- | --- | --- | --- |
| 1 | `mov al, myBytes` | `80h` | unchanged | unchanged |
| 2 | `add al, [myBytes+1]` | `E6h` | 0 | 0 |
| 3 | `add al, [myBytes+2]` | `8Bh` | 1 | 0 |

$$
\begin{array}{r}
1110\ 0110\ (E6h) \\
+\ 1010\ 0101\ (A5h) \\
\hline
1\ 1000\ 1011\ (18Bh)
\end{array}
$$

The carry bit is lost, so only `8Bh` remains in `AL`.

> [!warning] Correction to the Source
> The source claimed `OF = 1` at step 2. As signed values, $-128 + 102 = -26$, which is inside the range of -128 to 127, so **OF = 0**. Step 3 is also OF = 0, since $-26 + (-91) = -117$ is in range. Only CF changes.

#### Part 2: Second Snippet

~~~assembly
mov ax, myBytes
add ax, [myBytes+1]
add ax, [myBytes+2]
~~~

This **does not assemble**. `AX` is 16-bit but `myBytes` is an 8-bit `BYTE`, so every line is a size mismatch.

#### Part 3: The Proposed Fix

~~~assembly
movzx ax, myBytes
mov   bl, [myBytes+1]
add   ax, bx
mov   bl, [myBytes+2]
add   ax, bx          ; AX = sum
~~~

> [!question] Is anything missing?
> **Yes: `mov bx, 0` must run before the first `add`.** The code loads only `BL`, but `add ax, bx` adds the **whole** 16-bit `BX`. Whatever garbage sits in `BH` is added into the sum.

~~~assembly
mov   bx, 0           ; clear BH and BL
movzx ax, myBytes
mov   bl, [myBytes+1]
add   ax, bx
mov   bl, [myBytes+2]
add   ax, bx          ; AX = 018Bh
~~~

| Step | Instruction | AX | BX |
| --- | --- | --- | --- |
| 1 | `mov bx, 0` | unchanged | `0000h` |
| 2 | `movzx ax, myBytes` | `0080h` | `0000h` |
| 3 | `mov bl, [myBytes+1]` | `0080h` | `0066h` |
| 4 | `add ax, bx` | `00E6h` | `0066h` |
| 5 | `mov bl, [myBytes+2]` | `00E6h` | `00A5h` |
| 6 | `add ax, bx` | `018Bh` | `00A5h` |

> [!tip] Alternative Fix
> Replace each `mov bl, ...` with `movzx bx, [myBytes+n]`. `MOVZX` zeroes `BH` automatically, so `mov bx, 0` is unnecessary.

---

## Quick Reference

| Instruction | Purpose                    | Key Restriction                       |
| ----------- | -------------------------- | ------------------------------------- |
| **`MOV`**   | Copy source to destination | Same size, at most one memory operand |
| **`MOVZX`** | Widen an unsigned value    | Destination must be a register        |
| **`MOVSX`** | Widen a signed value       | Destination must be a register        |
| **`XCHG`**  | Swap two operands          | At least one register, no immediates  |