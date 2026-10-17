---
aliases:
  - Assemble-Link-Execute
  - Build Process
  - make32.bat
  - Listing File
  - Map File
  - Chapter 3
tags:
  - assembly-language
  - masm
  - ia-32
  - build-process
  - exam-critical
  - chapter-3
status: active
created: 2026-09-28
---

# Assembling, Linking, and Running Programs

> [!abstract] Overview
> This note covers the **[[Assemble-Link-Execute Cycle]]**, the `make32.bat` build automation script, and the two key system output files — the **[[Listing File]]** (`.lst`) and the **[[Map File]]** (`.map`) — produced during the build process.

> [!important] Exam Note
> This material was flagged as **highly important theory for exams**, despite being covered in the same lecture as earlier topics.

---

## The Assemble-Link-Execute Cycle

This cycle describes the exact sequential steps required to go from writing a source program to executing the compiled program.

> [!note] Important Repetition Rule
> Whenever the source code is modified, **Steps 2 through 4 must be repeated** to apply the changes. Step 1 only needs to happen once per edit.

~~~mermaid
graph LR
    A[Step 1: Text Editor] -->|Source File| B[Step 2: Assembler]
    B -->|Object File + Listing File| C[Step 3: Linker]
    C -->|Executable File + Map File| D[Step 4: OS Loader]
    D --> E[Output]
~~~

| Step | Tool | Input | Output |
| --- | --- | --- | --- |
| **1** | **[[Text Editor]]** | — | Source File |
| **2** | **[[Assembler]]** | Source File | Object File, Listing File |
| **3** | **[[Linker]]** | Object File + Link Library | Executable File, Map File |
| **4** | **[[OS Loader]]** | Executable File | Final Output |

---

## Build Automation: `make32.bat`

Instead of running the assembler and linker manually, developers use batch files to automate the build process.

> [!note] What It Does
> `make32.bat` is a batch file used to assemble and link **32-bit programs**. It contains the automated commands to execute:
>
> - `ML.EXE` — the Microsoft Assembler
> - `LINK32.EXE` — the 32-bit Microsoft Linker

> [!example] Command-Line Syntax
> `make32 progName`
>
> The `progName` must **not** include the `.asm` file extension.

> [!warning] Real-Mode Alternative
> To assemble and link older **Real-mode** programs, use `make16.bat` instead.

---

## System Output Files

During the build cycle, the assembler and linker produce two important reference files used for debugging and memory tracking.

### 1. The Listing File (`.lst`)

> [!note] Purpose
> Allows the programmer to look under the hood and see exactly how the program was compiled.

*Example file name: `addSub.lst`*

It contains a comprehensive breakdown of the build, including:

- The original source code

- Memory addresses

- The generated object code (raw machine language)

- Segment names

- **[[Symbols]]** (variables, procedures, and constants)

### 2. The Map File (`.map`)

> [!note] Purpose
> Provides specific structural information about each individual program segment.

*Example file name: `addSub.map`*

The details provided for each segment include:

| Detail | Description |
| --- | --- |
| **Starting Address** | Where the segment begins in memory. |
| **Ending Address** | Where the segment ends in memory. |
| **Segment Size** | The total size of the segment. |
| **Segment Type** | The classification of the segment (e.g., code, data). |

---

## Quick Reference Comparison

| File | Extension | Produced By | Primary Use |
| --- | --- | --- | --- |
| **Listing File** | `.lst` | Assembler | Source-to-machine-code breakdown, debugging |
| **Map File** | `.map` | Linker | Segment addresses and sizes, memory layout |
