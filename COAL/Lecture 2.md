---
aliases:
  - IA-32 Architecture
  - Cache Memory
  - CPU Registers
  - Memory Interfacing
tags:
  - digital-logic-design
  - computer-architecture
  - ia-32
  - cache
  - registers
  - pipelining
status: active
created: 2026-09-23
---

# IA-32 Architecture, Cache, and Memory Interfacing

> [!abstract] Overview
> This document covers [[Memory Interfacing]] timing, the [[Cache Memory|cache memory]] hierarchy, [[IA-32]] operating modes, and the full set of [[CPU Registers|CPU registers]] that make up the basic execution environment.

---

## Memory Interfacing

[[Memory]] responds far more slowly than the CPU, so multiple machine cycles are required to read a single piece of data.

> [!note] Memory Read Sequence
>
> 1. The target address is placed on the [[Address Bus]].
>
> 2. The Read Line (RD) signal is set low (0).
>
> 3. The CPU waits one cycle for memory to respond.
>
> 4. The Read Line returns to high (1), indicating the data is now successfully on the [[Data Bus]].

![[Memory Read Timing.png|600]]

---

## Cache Memory

[[Cache]] is high-speed, expensive static RAM used to speed up data access between the CPU and main memory.

| Level | Location | Purpose |
| --- | --- | --- |
| **L1 Cache** | Physically inside the CPU | Fastest access, smallest capacity |
| **L2 Cache** | Located outside the CPU | Larger, slightly slower than L1 |

- **[[Cache Hit]]**: Occurs when the data the CPU needs is already sitting in the cache.

- **[[Cache Miss]]**: Occurs when the needed data is *not* in the cache, forcing a slower fetch from main memory.

---

## IA-32 Processor Architecture and Multitasking

**[[IA-32]]** is the 32-bit x86 processor architecture.

> [!note] Multitasking
> The OS runs multiple programs or threads at the same time using a **scheduler** utility that assigns CPU time to each program, rapidly switching tasks to create the illusion of simultaneous execution.

> [!note] Step-by-Step Flow
>
> 1. **Initiation**: The user begins the process by sending the program name to the Operating System.
>
> 2. **Searching**: The OS searches for the requested program file in two primary locations:
>    - The **Current Directory**
>    - The **System Path**
>
> 3. **Locating Data**: Once the OS finds the program, it retrieves the starting cluster information directly from the file's **[[Directory Entry]]**.
>
> 4. **Execution**: Using that starting cluster, the OS loads the program into memory and starts its execution.
>
> 5. **Termination**: After the program finishes running, it returns control back to the Operating System.
> ![[How program runs.png|600]]



### Modes of Operation

| Mode                           | Description                                                                                                                                                              |
| ------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **[[Protected Mode]]**         | The native mode for modern OSs like Windows and Linux. Supports 4 GB of addressable RAM using 32-bit addresses, with each program assigned a protected memory partition. |
| **[[Real-Address Mode]]**      | The native mode for old MS-DOS. Mimics the 8086 processor, offering only 1 MB of address space via 20-bit addresses.                                                     |
| **[[System Management Mode]]** | Used for power management, security, and diagnostics.                                                                                                                    |
| **[[Virtual-8086 Mode]]**      | A hybrid of protected mode where each program runs inside its own isolated, safe 8086 computer environment.                                                              |

---

## Registers and Basic Execution Environment

[[Registers]] are named, high-speed storage locations located directly inside the CPU.

### General-Purpose Registers

| Register | Full Form                       |
| -------- | ------------------------------- |
| **EAX**  | *Extended Accumulator Register* |
| **EBX**  | *Extended Base Register*        |
| **ECX**  | *Extended Counter Register*     |
| **EDX**  | *Extended Data Register*        |

> [!note] Register Sizes
> You can access different portions of these registers using specific sub-names. For example, the 32-bit **EAX** can be accessed as the 16-bit **AX**, which further splits into two 8-bit halves: **AH** (high) and **AL** (low).

![[Different Sized Register.png|600]]


---