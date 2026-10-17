---
aliases:
  - x86 Review Questions
  - IA-32 Review
  - Registers and Flags Q&A
  - Chapter 2
tags:
  - assembly-language
  - ia-32
  - registers
  - eflags
  - review
  - exam-critical
  - chapter-2
status: active
created: 2026-09-28
---

# x86 Architecture: Review Questions

> [!abstract] Overview
> This note is a question-and-answer review of the [[IA-32]] processor: operating modes, [[Registers|registers]], **[[EFLAGS]]** status flags, and the [[Floating-Point Unit]].

---

## Q1. Basic Modes of Operation

> [!question] What are the x86 processor's three basic modes of operation?
> The three basic modes are:
>
> 1. **[[Protected Mode]]**
>
> 2. **[[Real-Address Mode]]**
>
> 3. **[[System Management Mode]]**

> [!note] Virtual-8086 Mode
> **[[Virtual-8086 Mode]]** is a special case of protected mode, which is why it is not counted as a separate basic mode in this answer. Some texts list it as a fourth mode, so both counts are valid depending on the source.

---

## Q2. The Eight 32-bit General-Purpose Registers

> [!question] Name all eight 32-bit general-purpose registers.

| Register | Full Name |
| --- | --- |
| **EAX** | Extended Accumulator Register |
| **EBX** | Extended Base Register |
| **ECX** | Extended Counter Register |
| **EDX** | Extended Data Register |
| **ESI** | Extended Source Index |
| **EDI** | Extended Destination Index |
| **EBP** | Extended Base Pointer |
| **ESP** | Extended Stack Pointer |

> [!note] Counting Rule
> ESI, EDI, EBP, and ESP are grouped as index and pointer registers in earlier notes, but they still count among the **eight** general-purpose registers.

---

## Q3. The Six Segment Registers

> [!question] Name all six segment registers.

| Register | Full Name |
| --- | --- |
| **CS** | Code Segment |
| **DS** | Data Segment |
| **SS** | Stack Segment |
| **ES** | Extra Segment |
| **FS** | Additional data segment |
| **GS** | Additional data segment |

---

## Q4. Special Purpose of ECX

> [!question] What special purpose does the ECX register serve?
> ECX (Extended Counter Register) is typically used by the processor as the default **loop counter** for repetitive operations.

---

## Q5. Stack Variable Registers

> [!question] Besides ESP, what other register points to variables on the stack?
> **EBP** (Extended Base Pointer) is generally used to reference variables and parameters located on the stack. Because ESP moves as data is pushed and popped, EBP provides a stable reference point.

---

## Q6. CPU Status Flags

> [!question] Name at least four CPU status flags.

| Flag | Name |
| --- | --- |
| **CF** | [[Carry Flag]] |
| **ZF** | [[Zero Flag]] |
| **SF** | [[Sign Flag]] |
| **OF** | [[Overflow Flag]] |

---

## Q7 to Q9. Flag Identification

| Question | Flag | Explanation |
| --- | --- | --- |
| **Q7.** Which flag is set when an *unsigned* result is too large for the destination? | **Carry Flag (CF)** | An unsigned operation produces a result that exceeds the destination's capacity. |
| **Q8.** Which flag is set when a *signed* result is too large or too small for the destination? | **Overflow Flag (OF)** | A signed calculation falls outside the valid range for the destination operand. |
| **Q9.** Which flag is set when an operation generates a *negative* result? | **Sign Flag (SF)** | The most significant bit of the result is `1`. |

> [!tip] Memory Aid
> - Carry is for **unsigned** out-of-range.
>
> - Overflow is for **signed** out-of-range.
>
> - Sign reports whether the result is **negative**.

~~~mermaid
graph LR
    A[Arithmetic Result] --> B{Type of Check}
    B -->|Unsigned out of range| C[Carry Flag]
    B -->|Signed out of range| D[Overflow Flag]
    B -->|Negative result| E[Sign Flag]
    B -->|Exactly zero| F[Zero Flag]
~~~

---

## Q10. Floating-Point Arithmetic

> [!question] Which part of the CPU performs floating-point arithmetic?
> The **[[Floating-Point Unit]]** (FPU), a dedicated section of the CPU, handles floating-point arithmetic operations.