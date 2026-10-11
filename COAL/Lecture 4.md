---
aliases: [MASM Syntax, Assembly Constants, Data Types, Program Vocabulary, Hexadecimal Arithmetic]
tags: [assembly-language, masm, ia-32, data-types, syntax]
status: active
created: 2026-09-28
---

# Assembly Language Basics: Constants and Data Types

> [!abstract] Overview
> This note covers the building blocks of **[[MASM]]** (Microsoft Macro Assembler) programs: integer and string constants, data type attributes, program vocabulary (identifiers, directives, instructions), and a worked hexadecimal arithmetic example.

---

## Integer Constants

> [!note] Syntax Format
> `[{+|-}] digits [radix]`

### Radix (Base) Identifiers

The base of a number is defined using a trailing character:

| Suffix | Base |
| --- | --- |
| `d` (or none) | Decimal |
| `h` | Hexadecimal |
| `b` | Binary |
| `q` or `o` | Octal |

> [!example] Examples
> - `42` or `30d` → decimal
> - `1101b` → binary
> - `63q` or `63o` → octal

> [!warning] Hexadecimal Rule
> If a hexadecimal constant begins with a letter (A through F), it **must** be prefixed with a leading zero so the assembler recognizes it as a number rather than a variable name.
>
> Correct: `0A5h`
> Incorrect: `A5h`

---

## Character and String Constants

### Characters

Enclosed in single (`'A'`) or double (`"A"`) quotes. Each individual character occupies exactly **1 byte** (8 bits) of memory.

> [!example] ASCII References
> - `'A'` = 65
> - `'B'` = 66
> - `'a'` = 97
> - `'b'` = 98
>
> For example, the character `'B'` (66) is stored in binary as:
>
> $$0100\ 0010$$

### Strings

Enclosed in single or double quotes (e.g., `"Hello"` or `'Hello'`). Each character within the string takes up a single byte.

> [!note] Embedded Quotes
> Quotes can be included within a string by alternating the quote types:
>
> `'Say "Goodnight," Gracie'`

---

## Data Types (Attributes)

Attributes tell the MASM assembler the size and usage of variables.

### Unsigned Types

| Type | Size |
| --- | --- |
| `BYTE` | 8 bits |
| `WORD` | 16 bits |
| `DWORD` | 32 bits |
| `QWORD` | 64 bits |

### Signed Types

Prefixed with `S`: `SBYTE`, `SWORD`, `SDWORD`. The Most Significant Bit acts as the sign flag — `1` means negative, `0` means positive.

---

## Program Vocabulary and Structure

### Identifiers and Reserved Words

- **[[Identifiers]]**: Programmer-chosen names used for variables, functions, and constants.

- **[[Reserved Words]]**: Words with special built-in meaning in MASM — instruction mnemonics, register names, attributes, operators, predefined symbols (like `@data`), and directives.

### Operators

Used to evaluate constant expressions at assembly time, in the following precedence order:

1. Parentheses `()`

2. Unary plus/minus `+`, `-`

3. Multiply `*`, Divide `/`, Modulus `MOD`

4. Add `+`, Subtract `-`

---

## Directives vs. Instructions

> [!note] Directives
> Setup commands that tell the assembler how to organize the program (e.g., `.stack`, `.data`, `.code`). These are **not** part of the Intel processor's instruction set, and different assemblers use different directives — MASM directives differ from NASM directives.

> [!note] Instructions
> Intel [[IA-32]] commands that are actually converted into machine code and executed by the CPU at runtime. An instruction statement contains up to four parts: **Label**, **Mnemonic**, **Operand**, and **Comment**.

---

## Anatomy of an Instruction

### Labels

Act as place markers for memory addresses.

| Label Type | Rule | Example |
| --- | --- | --- |
| **Data Labels** | Must be unique; no colon | `myArray BYTE 58d` |
| **Code Labels** | Used as jump/loop targets; must end with a colon | `L1:` |

### Mnemonics

Action words like `MOV`, `ADD`, `SUB`, `MUL`, `DIV`, `INC` (increment), and `DEC` (decrement).

### Operands

The targets of the instruction — constants, expressions, registers, or memory locations.

> [!example] Operand Counts
> - **Zero operands**: `stc`
> - **One operand**: `inc eax`
> - **Two operands**: `add ebx, ecx`

### Comments

- **Single-line**: start with a semicolon (`;`).

- **Multi-line**: begin with the `COMMENT` directive followed by a user-chosen symbol, ending when that same symbol appears again.

---

## Code Example and Hexadecimal Arithmetic

MASM programs are structured into sections using directives. Variables are declared in `.data`, and logic goes in `.code` inside a procedure (like `main PROC`).

~~~assembly
.code
main PROC
    mov ax, 1234h    ; move 1234h into register ax
    mov dx, 5678h    ; move 5678h into register dx

    ; Syntax for two operands is usually: Mnemonic Destination, Source
    add ax, dx       ; Destination (ax) = ax + dx
main endp
end main
~~~

### Arithmetic Breakdown (`ax = ax + dx`)

The processor adds the binary equivalents of the hexadecimal numbers `1234h` and `5678h`.

$$
\begin{array}{r}
0001\ 0010\ 0011\ 0100\ (1234h) \\
+\ 0101\ 0110\ 0111\ 1000\ (5678h) \\
\hline
0110\ 1000\ 1010\ 1100\ (68ACh)
\end{array}
$$

> [!example] Result
> The register `ax` now holds the value `68ACh`.