---
aliases:
  - IT Fundamentals
  - Systems Components
  - IAM
  - Management Structures
tags:
  - information-systems
  - cybersecurity
  - iam
  - management
  - foundations
status: active
created: 2026-09-23
---
# Foundations of Information Systems and IAM

> [!abstract] Overview
> This document covers the foundational building blocks of information systems, including [[Identity and Access Management]] (IAM), the five core [[Information System Components]], and the three tiers of [[Management and Decision Structures]].

---

## Identity and Access Management

> [!note] The Three Pillars of IAM
> **[[Authentication]]** is the process used to determine the identity of people, systems, or services.
>
> **[[Authorization]]** is the process of granting access to groups or users based on defined roles.
>
> **[[Accountability]]** and **[[Responsibility]]** are core principles that work alongside authentication and authorization, tracking who did what and who owns the outcome.

### Role-Based Access Levels

| Role | Access Granted |
| --- | --- |
| **[[Frontline Users]]** | Read-only |
| **[[Admin]]** | Read and write |
| **[[Manager]]** | Read, write, and access control |
| **[[IT Professional]]** | Read, write, and execute |
| **Higher-ups (CEO)** | Complete access |

> [!example] A Point Worth Questioning
> This hierarchy is not universal. In many real-world [[Role-Based Access Control]] (RBAC) models, an *Admin* is granted execute permissions too, since administrative tasks often require running scripts or system commands. If your source separates Admin (read/write) from IT Professional (read/write/execute), treat this as a simplified teaching model rather than an industry standard, and confirm which definition your course expects on an exam.

---

## Information System Components

~~~mermaid
graph TD
    A[Information System] --> B(Hardware)
    A --> C(Software)
    A --> D(People)
    A --> E(Data)
    A --> F(Processes)

    B --> B1[Input/Output]
    B --> B2[Processing]
    B --> B3[Storage]
~~~

### Hardware

- **Input/Output**: Monitors, speakers, microphones.
- **Processing**: CPU, GPU, RAM, Motherboard.
- **Storage**: Hard disk, SSD, HDD.

> [!example] RAM Is Not Storage
> **[[RAM]]** is usually placed in both the *Processing* and *Storage* categories. That double placement is worth flagging. RAM is *volatile memory*: it holds data temporarily for active processing and is wiped when power is lost. It supports the CPU during processing, which is why it belongs there. However, it does not belong under *Storage*, which refers to *non-volatile* devices like the Hard disk, SSD, and HDD that retain data permanently. Keeping RAM only under Processing will make your model more accurate.

### Software

Includes **[[System Software]]**, **[[Application Software]]**, and network devices such as **[[Network Interface Cards]]** (NIC).

### People

Individuals interacting with the system, including **[[Users]]** (clients, frontline users), **[[IT Professionals]]**, and **[[Managers]]**.

### Data

The raw information processed by the system.

### Processes

The rules, procedures, standards, and ongoing steps required to operate the system.

---

## Management and Decision Structures

| Tier                           | Decision Type   | Timeline            | Typical Owner       | Example                                    |
| ------------------------------ | --------------- | ------------------- | ------------------- | ------------------------------------------ |
| **[[Operational Management]]** | Structured      | Daily               | Frontline staff     | POS operations, daily inventory restocking |
| **[[Tactical Management]]**    | Semi-structured | 6 months to 2 years | Directors and staff | Hiring and firing employees                |
| **[[Strategic Management]]**   | Unstructured    | Long-term           | Executives          | Setting organizational direction           |

> [!example]  Management Is Long-Term, Not Just "Near Future"
> Since [[Operational Management]] covers daily tasks and [[Tactical Management]] covers 6 months to 2 years, Strategic Management should logically extend *beyond* that window, typically covering multi-year or long-term organizational direction (3 to 5+ years), not the near future. Consider revising your notes to reflect that Strategic Management sits at the far end of this timeline spectrum.

~~~mermaid
graph LR
    A[Decision Timelines] --> B[Operational: Daily]
    A --> C[Tactical: 6mo-2yr]
    A --> D[Strategic: Long-term]
~~~

---

## General Concepts

> [!note] Probabilistic vs. Deterministic
> **[[Probabilistic]]** systems involve uncertainty and produce outcomes that vary. **[[Deterministic]]** systems involve 100 percent certainty, always producing the same output from the same input.

> [!quote] Definition
> The **[[Internet]]** is fundamentally defined as a *"network of networks."*