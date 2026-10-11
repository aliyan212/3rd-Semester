---
aliases: [Data Definition, BYTE, WORD, DWORD, DUP Operator, Little Endian, Floating Point Types, Memory Offsets]
tags: [assembly-language, masm, ia-32, data-types, memory]
status: active
created: 2026-09-28
---

# Assembly Data Types and Memory Storage

> [!abstract] Overview
> This note covers IEEE floating-point data types, **[[Data Definition Statements]]** for bytes, words, and double words, string and null-termination conventions, the **[[DUP Operator]]** for array allocation, and **[[Little Endian]]** memory ordering on Intel processors.

---

## Intrinsic Data Types (Floating Point)

In addition to standard integer types, Assembly supports specific **[[IEEE Floating-Point]]** types:

| Type | Size | Description |
| --- | --- | --- |
| **REAL4** | 4 bytes | IEEE short real |
| **REAL8** | 8 bytes | IEEE long real |
| **REAL10** | 10 bytes | IEEE extended real |

---

## Data Definition Statements

A data definition statement sets aside memory storage for a variable and optionally assigns a name (or label) to that data.

> [!note] Syntax
> `[name] directive initializer [,initializer] . . .`

- All initializers are ultimately converted into binary data in memory.

- When a variable name (like `value1`) is assigned, it acts as a data label that implies a specific memory offset (an address) for that data.

### Syntax Breakdown

| Component | Required? | Meaning |
| --- | --- | --- |
| **`[name]`** | Optional | The variable name (e.g., `count`, `myString`). If omitted, the assembler still allocates the memory — there is simply no convenient name to reference it by later. |
| **`directive`** | Required | Defines the size of the memory chunk to carve out (e.g., `BYTE` carves out 8 bits, `DWORD` carves out 32 bits). |
| **`initializer`** | Required | The starting value placed inside that carved-out chunk. Using `?` tells the assembler to reserve the space but leave it uninitialized. |

> [!note] Conversion to Binary
> The CPU does not understand decimal numbers, hex codes, or text characters directly. Whether `65` (decimal), `41h` (hex), or `'A'` (character) is used as the initializer, the assembler translates all of them into the exact same raw 8-bit binary pattern before writing it to the hardware:
>
> $$65_{10} = 41_{16} = \texttt{'A'} = 0100\ 0001_2$$

> [!note] The Reality of "Variables" (Memory Offsets)
> In high-level languages (like C++ or Java), a variable feels like a discrete container. In Assembly, there are no true variables. A name like `value1` is strictly a **[[Data Label|data label]]** — a human-readable alias for a raw numeric memory address (an offset).
>
> - The assembler tracks how many bytes each piece of data occupies. If `value1` is the first byte in the data segment, its offset is `0000`. If `value2` comes right after it, its offset is `0001`.
>
> - When writing `mov al, value1`, the assembler simply substitutes the word `value1` with its raw hardware address. The label just saves the programmer from manually calculating and memorizing numeric addresses.

---

## Defining Bytes (8-bit)

You can define single bytes using the `BYTE` (unsigned) or `SBYTE` (signed) directives.

- **Constants**: Can be character constants like `'A'`.

- **Unsigned Limits**: From `0` to `255`.

- **Signed Limits**: From `-128` to `+127`.

- **Uninitialized**: Use a question mark (`?`) to leave a byte uninitialized.

- **Multiple Initializers**: You can declare multiple bytes sequentially by separating them with commas (e.g., `list1 BYTE 10,20,30,40` or `list4 BYTE 0Ah, 20h, 'A', 22h`).

- **Breaking Lists Across Multiple Lines**: When defining an array with a large number of initializers, you can break the list across multiple lines to improve readability. Declare the variable name on the first line, then simply repeat the data type directive on subsequent lines without retyping the variable name.

> [!example] Multi-Line Byte List
> ~~~assembly
> list2 BYTE 10, 20, 30, 40
>       BYTE 50, 60, 70, 80
>       BYTE 81, 82, 83, 84
> ~~~

---

## Defining Words (16-bit)

Use `WORD` (unsigned) or `SWORD` (signed) for 16-bit storage. Words can store 16-bit integers or double characters (e.g., `"AB"`).

| Property | Value |
| --- | --- |
| **Largest Unsigned Value** | `65535` |
| **Smallest Signed Value** | `-32768` |

---

## Defining Double Words (32-bit)

Use `DWORD` (unsigned) or `SDWORD` (signed) to allocate 32-bit integers.

> [!example] Declarations
> - `val1 DWORD 12345678h` — unsigned 32-bit value.
> - `val2 SDWORD -2147483648` — signed 32-bit value.

---

## Defining Strings

A string is implemented as an array of characters, usually enclosed in quotation marks.

> [!note] Null Termination
> Strings usually have a null byte (`0`) at the end to mark where the string stops:
>
> `str1 BYTE "Enter your name",0`

> [!note] Multi-line Strings
> To continue a single string across multiple lines without breaking it, end each line with a comma.

### End-of-Line Characters

| Hex Code | Meaning |
| --- | --- |
| `0Dh` | Carriage Return |
| `0Ah` | Line Feed |

> [!example] Combined Newline Declaration
> `newLine BYTE 0Dh, 0Ah, 0`

---

## Array Allocation: The DUP Operator

The **[[DUP Operator]]** is used to easily allocate space for an array or a repeating string.

> [!warning] Constraint
> Both the counter and the argument must be constants or constant expressions.

> [!example] Example 1 — Zero-Initialized Array
> `var1 BYTE 20 DUP(0)` creates 20 bytes, all initialized to zero.

> [!example] Example 2 — Uninitialized Array
> `var2 BYTE 20 DUP(?)` creates 20 uninitialized bytes.

> [!example] Example 3 — Repeating String
> `var3 BYTE 4 DUP("STACK")` creates a 20-byte string:
>
> `"STACKSTACKSTACKSTACK"`
>
> *(4 repetitions × 5 characters = 20 bytes)*

---

## Memory Architecture: Little Endian Order

Intel processors use **[[Little Endian]]** order for storing data in memory.

> [!note] Rule
> - All data types larger than a single byte store their individual bytes in reverse order.
>
> - The least significant byte is placed at the first (lowest) memory address.

> [!example] Breakdown: `val1 DWORD 12345678h`

| Offset | Byte |
| --- | --- |
| `0000` | `78` |
| `0001` | `56` |
| `0002` | `34` |
| `0003` | `12` |

~~~mermaid
graph LR
    A["12345678h"] --> B["Offset 0000: 78"]
    A --> C["Offset 0001: 56"]
    A --> D["Offset 0002: 34"]
    A --> E["Offset 0003: 12"]
~~~