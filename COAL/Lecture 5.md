---
aliases:
  - Assembly Syntax
  - Program Structure
  - Labels
  - Mnemonics
  - Operands
  - Irvine32
  - Chapter 3
tags:
  - assembly-language
  - masm
  - ia-32
  - syntax
  - irvine32
  - chapter-3
status: active
created: 2026-09-28
---

# Assembly Language Syntax and Program Structure

> [!abstract] Overview
> This note covers **[[Comments]]**, **[[Labels]]**, **[[Mnemonics]]** and **[[Operands]]**, instruction formats, a worked **Add and Subtract** program using the **[[Irvine32]]** library, and suggested coding standards for consistent assembly style.

---

## Comments

### Single-Line Comments

Begin with a semicolon (`;`).

### Multi-Line Comments

Use the `COMMENT` directive followed by a programmer-chosen delimiter character. The comment block ends when that same delimiter reappears.

> [!example] Using `\` as the Delimiter
> ~~~text
> COMMENT \
> This is the creation of class
> This line tells the programmer how to initialize a variable
> \
> ~~~

---

## Labels

Labels act as markers in a program and can be created in both the `.data` and `.code` segments.

> [!warning] Identifier Rule
> Label names cannot contain spaces. Use `my_Array`, never `my Array`.

| Label Type | Segment | Trailing Colon | Purpose |
| --- | --- | --- | --- |
| **Data Labels** | `.data` | No | Declare or initialize variables in memory (e.g., `myArray`). |
| **Code Labels** | `.code` | Yes | Serve as jump targets (e.g., `L1:`). |

> [!note] Code Labels and Jumps
> Code labels function similarly to the `goto` statement in C++. To perform an unconditional jump to a label, use:
>
> `jmp L1`

---

## Mnemonics and Operands

### Mnemonics

The action words (keywords) of an instruction, such as `MOV` (used for assigning values), `ADD`, `SUB`, `MUL`, `INC`, and `DEC`.

### Operands

The specific targets the mnemonic acts upon. For example, in `mov ah, 32d`, both `ah` and `32d` are operands.

> [!note] Operand Categories
>
> 1. **Immediate**: A constant value coded directly into the instruction (e.g., `32d`, `5`, `2`).
>
> 2. **Memory**: A data label representing a variable stored in memory (e.g., `myByte`).
>
> 3. **Registers**: A CPU register used directly for holding or assigning values (e.g., `ah`).

---

## Instruction Format Examples

### No Operand

`stc` — automatically sets the Carry Flag, so `CF = 1`.

### One Operand

- `inc eax` — using a register.

- `inc myByte` — using a memory variable.

### Two Operands

- `add ebx, ecx` — register, register.

- `sub myByte, 25` — memory, constant.

- `add eax, 36*25` — register, constant expression.

---

## Code Example: Add and Subtract Program

This program demonstrates adding and subtracting 32-bit integers. It uses the **[[Irvine32]]** library (`INCLUDE Irvine32.inc`) to enable 32-bit functionality.

~~~assembly
INCLUDE Irvine32.inc

.code
main PROC
    mov eax, 10000h      ; EAX = 10000h
    add eax, 40000h      ; EAX = 10000h + 40000h = 50000h
    sub eax, 20000h      ; EAX = 50000h - 20000h = 30000h

    call DumpRegs        ; Displays the current state of the Registers
    exit
main ENDP
END main
~~~

### Register Trace

| Step | Instruction | EAX Value |
| --- | --- | --- |
| 1 | `mov eax, 10000h` | `10000h` |
| 2 | `add eax, 40000h` | `50000h` |
| 3 | `sub eax, 20000h` | `30000h` |

---

## Suggested Coding Standards

> [!note] Capitalization Styles
> Consistency is key when writing assembly code. Pick one approach and stick to it:
>
> 1. Capitalize nothing.
>
> 2. Capitalize everything.
>
> 3. Capitalize all reserved words, including instruction mnemonics and registers.
>
> 4. Capitalize only directives and operators.

> [!note] Indentation
> Ensure clear spacing and indentation between distinct program segments, such as `.data` and `.code`, to maintain readability.