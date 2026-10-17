---
aliases:
  - AddSub2
  - Symbolic Constants
  - EQU
  - TEXTEQU
  - data? Directive
  - Real-Address Mode Programming
  - Location Counter
  - Chapter 3
tags:
  - assembly-language
  - masm
  - ia-32
  - symbolic-constants
  - real-address-mode
  - irvine32
  - chapter-3
status: active
created: 2026-10-12
---

# Variables, Symbolic Constants, and Real-Address Mode

> [!abstract] Overview
> This note covers a [[MASM]] program that does arithmetic with memory variables, the `.data?` directive for uninitialized data, the three **[[Symbolic Constants|symbolic constant]]** directives (`=`, `EQU`, `TEXTEQU`), automatic array size calculation with the **[[Location Counter]]** (`$`), and how to convert a 32-bit program into a 16-bit **[[Real-Address Mode]]** program.

---

## 1. Adding and Subtracting with Variables (`AddSub2.asm`)

To do arithmetic with memory variables instead of hardcoded numbers, declare the variables in the `.data` segment and manipulate them through registers in the `.code` segment.

### Complete Program

~~~assembly
TITLE Add and Subtract, Version 2 (AddSub2.asm)
; This program adds and subtracts 32-bit unsigned
; integers and stores the sum in a variable.
INCLUDE Irvine32.inc

.data
val1     DWORD 10000h
val2     DWORD 40000h
val3     DWORD 20000h
finalVal DWORD ?

.code
main PROC
    mov eax, val1      ; start with 10000h
    add eax, val2      ; add 40000h
    sub eax, val3      ; subtract 20000h
    mov finalVal, eax  ; store the result (30000h)
    call DumpRegs      ; display the registers
    exit
main ENDP
END main
~~~

### Header and Setup

> [!note] TITLE and INCLUDE
> - `TITLE` sets a descriptive title that appears in the **[[Listing File]]** header. It does **not** name or save the file.
>
> - `INCLUDE Irvine32.inc` brings in the **[[Irvine32]]** library definitions, including `DumpRegs` and `exit`.

### Variable Declarations (`.data`)

| Variable | Type | Initial Value |
| --- | --- | --- |
| `val1` | `DWORD` | `10000h` |
| `val2` | `DWORD` | `40000h` |
| `val3` | `DWORD` | `20000h` |
| `finalVal` | `DWORD` | `?` (uninitialized, holds the answer later) |

### Execution Steps (`.code`)

| Step | Instruction | Effect | EAX After |
| --- | --- | --- | --- |
| 1 | `mov eax, val1` | Copies `val1` from memory into `eax`. | `10000h` |
| 2 | `add eax, val2` | Adds `40000h`. | `50000h` |
| 3 | `sub eax, val3` | Subtracts `20000h`. | `30000h` |
| 4 | `mov finalVal, eax` | Copies the result into memory. | `30000h` |
| 5 | `call DumpRegs` | Displays the CPU register state. | `30000h` |

$$10000h + 40000h - 20000h = 30000h$$

> [!note] Why Two Steps to Store
> `mov finalVal, eax` is needed because the arithmetic happens in the register. The variable in memory is only updated when the result is copied back.

---

## 2. Declaring Uninitialized Data (`.data?`)

For large uninitialized variables or arrays, use the `.data?` directive instead of placing everything in the standard `.data` segment.

> [!note] How It Works
> Use `.data?` **exclusively** to declare an uninitialized data segment.

> [!tip] Advantage
> It reduces the size of the compiled `.EXE` file. Initialized data must be stored inside the file, but uninitialized data only needs to be reserved at load time.

### Comparison

> [!example] Inefficient: Mixing Both in `.data`
> ~~~assembly
> .data
> smallArray DWORD 10 DUP(0)
> bigArray   DWORD 5000 DUP(?)
> ~~~

> [!example] Efficient: Splitting with `.data?`
> ~~~assembly
> .data
> smallArray DWORD 10 DUP(0)
>
> .data?
> bigArray   DWORD 5000 DUP(?)
> ~~~

`5000 DUP(?)` duplicates an uninitialized `DWORD` 5,000 times:

$$5000 \times 4 = 20{,}000 \text{ bytes}$$

---

## 3. Symbolic Constants and Array Size Calculations

A **symbolic constant** is a name assigned to a value or text expression.

> [!note] Key Properties
> - **Zero storage cost**: unlike a variable, a symbolic constant uses no runtime memory.
>
> - **Assembly-time only**: symbols are evaluated by the assembler during assembly, never at runtime.

### The Three Directives Compared

| Directive | What It Defines | Can It Be Redefined? |
| --- | --- | --- |
| **`=`** (Equal-Sign) | 32-bit integer expression or constant | Yes |
| **`EQU`** | Integer or text expression | No |
| **`TEXTEQU`** | Integer or text expression (text macro) | Yes |

~~~mermaid
graph TD
    A[Need a symbolic constant] --> B{What kind of value?}
    B -->|32-bit integer| C[Use = directive]
    B -->|Text or integer| D{Redefine later?}
    D -->|No| E[Use EQU]
    D -->|Yes| F[Use TEXTEQU]
~~~

---

### A. Equal-Sign Directive (`=`)

> [!note] Syntax
> `name = expression`

- The `expression` must be a 32-bit integer (a math expression or a single constant).

- The `name` is the symbolic constant. Using symbols instead of raw numbers is considered good programming style.

- Unlike `EQU`, a symbol created with `=` **may be redefined** at any point in the program.

> [!example] Assigning a Key Code
> ~~~assembly
> Esc_key = 27
> mov al, Esc_key
> ~~~

> [!example] Redefining a Symbol Mid-Program
> ~~~assembly
> .data
> Count = 5
> array1 BYTE Count DUP(0)    ; reserves 5 bytes
> Count = 10
> array2 BYTE Count DUP(0)    ; reserves 10 bytes
>
> .code
> mov al, Count               ; AL = 10 (the current value)
> ~~~


---

### B. Calculating the Sizes of Arrays and Strings

Instead of counting elements by hand, let the assembler calculate the size using the `=` directive and the **[[Location Counter]]** (`$`).

> [!note] How the Math Works
> Subtracting the starting address of the array (`list`) from the current location counter (`$`) gives the **total number of bytes** the array occupies. To get the **number of elements**, divide that byte total by the size of the data type.

> [!warning] Placement Rule
> The `ListSize` line must come **immediately after** the array declaration. If other data is declared in between, `$` has moved on and the result will include that extra data.

| Array Type | Bytes per Element | Formula | Elements |
| --- | --- | --- | --- |
| `BYTE` | 1 | `($ - list)` | 4 |
| `WORD` | 2 | `($ - list) / 2` | 4 |
| `DWORD` | 4 | `($ - list) / 4` | 4 |

> [!example] Byte Array (1 byte per element)
> The byte difference directly equals the element count.
>
> ~~~assembly
> list BYTE 10,20,30,40
> ListSize = ($ - list)
> ~~~
>
> $$4 \text{ bytes} \div 1 = 4 \text{ elements}$$

> [!example] Word Array (2 bytes per element)
> Divide the byte total by 2.
>
> ~~~assembly
> list WORD 1000h, 2000h, 3000h, 4000h
> ListSize = ($ - list) / 2
> ~~~
>
> $$8 \text{ bytes} \div 2 = 4 \text{ elements}$$

> [!example] Doubleword Array (4 bytes per element)
> Divide the byte total by 4.
>
> ~~~assembly
> list DWORD 1,2,3,4
> ListSize = ($ - list) / 4
> ~~~
>
> $$16 \text{ bytes} \div 4 = 4 \text{ elements}$$

---

### C. `EQU` Directive

Defines a symbol as either an integer or a text expression. Once defined, an `EQU` symbol **cannot be redefined** later in the program.

> [!note] Three Syntax Formats
>
> 1. `Name EQU expression` — a valid integer expression.
>
> 2. `Name EQU Symbol` — an existing symbol name.
>
> 3. `Name EQU <text>` — any text placed inside angle brackets `< >`.

> [!example] Examples
> ~~~assembly
> PI EQU <3.1416>
> pressKey EQU <"Press any key to continue...",0>
>
> .data
> prompt BYTE pressKey
> ~~~

---

### D. `TEXTEQU` Directive

Defines a symbol as either an integer or a text expression. A symbol created with `TEXTEQU` is called a **[[Text Macro]]**, and unlike `EQU`, it **can be redefined** at any time.

> [!note] Three Syntax Formats
>
> 1. `name TEXTEQU <text>` — assigns literal text inside angle brackets.
>
> 2. `name TEXTEQU textmacro` — assigns the contents of an existing text macro.
>
> 3. `name TEXTEQU %constExpr` — the `%` prefix tells the assembler to evaluate a constant integer expression and convert the result into text.

> [!example] Examples
> ~~~assembly
> continueMsg TEXTEQU <"Do you wish to continue (Y/N)?">
> .data
> prompt1 BYTE continueMsg
>
> rowSize = 5
> count   TEXTEQU %(rowSize * 2)  ; Evaluates to 10
> move    TEXTEQU <mov>
> setupAL TEXTEQU <mov al, count> ; Expands to: mov al, 10
> ~~~

---

## 4. Real-Address Mode Programming (16-Bit MS-DOS)

**[[Protected Mode]]** produces 32-bit programs. **[[Real-Address Mode]]** is used to generate **16-bit MS-DOS programs**.

### Advantages and Disadvantages

| Advantages | Disadvantages |
| --- | --- |
| Enables direct calling of MS-DOS and BIOS hardware functions. | You must manually keep track of both memory **segments and offsets**. |
| No memory access restrictions. | Cannot call modern Win32 functions (Windows 95 onward). |
| | Strictly limited to **640K** of program memory. |

### Code Requirements

To convert a 32-bit Protected Mode program into a 16-bit Real-Address Mode program, make two changes:

1. **Include the 16-bit library**: use `INCLUDE Irvine16.inc` instead of `Irvine32.inc`.

2. **Initialize the Data Segment (`DS`) register**: manually point `DS` to the `.data` segment at the very start of `main PROC` using the `@data` symbol.

> [!example] Initializing DS
> ~~~assembly
> mov ax, @data
> mov ds, ax
> ~~~

> [!note] Why the Extra Step
> In real-address mode, the program must tell the CPU where its data segment lives. The segment registers are not set up for you the way the flat model does it in protected mode. `DS` cannot be loaded with an immediate value directly, so the address goes through `ax` first.

### Complete 16-Bit Example (`AddSub2.asm`, 16-Bit Version)

~~~assembly
TITLE Add and Subtract, Version 2 (AddSub2.asm)
INCLUDE Irvine16.inc

.data
val1     DWORD 10000h
val2     DWORD 40000h
val3     DWORD 20000h
finalVal DWORD ?

.code
main PROC
    mov ax, @data      ; initialize DS
    mov ds, ax

    mov eax, val1      ; get first value
    add eax, val2      ; add second value
    sub eax, val3      ; subtract third value
    mov finalVal, eax  ; store the result
    call DumpRegs      ; display registers
    exit
main ENDP
END main
~~~

> [!tip] Save Under a Different Name
> This 16-bit version reuses the title `AddSub2.asm`. If you save it in the same folder as the 32-bit version, it will overwrite it, so give it a distinct file name.

### 32-Bit vs 16-Bit Comparison

| Aspect | Protected Mode (32-bit) | Real-Address Mode (16-bit) |
| --- | --- | --- |
| **Library** | `Irvine32.inc` | `Irvine16.inc` |
| **DS setup** | Not needed | `mov ax, @data` then `mov ds, ax` |
| **Build file** | `make32.bat` | `make16.bat` |
| **Memory limit** | 4 GB | 640K |
| **Win32 calls** | Allowed | Not allowed |
| **MS-DOS and BIOS calls** | Restricted | Direct access |
