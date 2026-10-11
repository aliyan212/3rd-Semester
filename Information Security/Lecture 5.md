---
aliases:
  - Information Flow
  - Risk Assessment
  - Quantitative Risk Formulas
  - ALE SLE ARO
tags:
  - information-security
  - risk-management
  - information-flow
  - cybersecurity
  - formulas
status: active
created: 2026-09-30
---
# Information Flow and Risk Assessment

> [!abstract] Overview
> This document covers the four **[[Information Flow]]** approaches within an organization, the fundamentals of **[[Risk Assessment]]**, and the **[[Quantitative Risk Assessment]]** formulas used to justify security spending.

---

## Information Flow

> [!note] Definition
> **[[Information Flow]]** is the exchange of information among people, processes, and systems within an organization.

### The Four Approaches

~~~mermaid
graph TD
    A[Information Flow] --> B[Top-Down]
    A --> C[Bottom-Up]
    A --> D[Horizontal]
    A --> E[Diagonal]
~~~

| Approach | Direction | Used For | Example |
| --- | --- | --- | --- |
| **[[Top-Down Approach]]** | Downward through hierarchy | Strategic decisions | CEO to Director to Manager to Admin to Technical staff |
| **[[Bottom-Up Approach]]** | Upward through hierarchy | Operational decisions | Frontline staff reporting issues to management |
| **[[Horizontal Approach]]** | Lateral, same level | Cross-functional coordination | Purchase Manager, Product Manager, Quality Control Manager, and Sales Manager exchanging updates |
| **[[Diagonal Approach]]** | Crosses both hierarchy and department lines | Informal or cross-functional urgent coordination | A Sales Manager communicating directly with an IT Technician in another department, bypassing the normal chain |


---

## Risk Assessment

> [!note] Core Formula
> **Risk = Likelihood x Impact**

### Likelihood Scale

| Level | Value |
| --- | --- |
| Very Low | 1 |
| Low | 2 |
| Medium | 3 |
| High | 4 |
| Very High | 5 |

### Impact

**[[Impact]]** is defined as how much damage an event could cause to the system.

### Risk Severity Scale

| Severity | Score Range |
| --- | --- |
| Low | 1 |
| Medium | 2 to 3 |
| High | 3 to 4 |
| Severe | 4 to 5 |
| Critical | 5 |

> [!example] Overlapping Ranges
> This severity scale has overlapping boundaries. A score of 3 falls under both *Medium* and *High*, and a score of 4 falls under both *High* and *Severe*. In practice, risk matrices usually assign each score to exactly one band (for example, 1 = Low, 2 = Medium, 3 = High, 4 = Severe, 5 = Critical).

### Threats vs. Vulnerabilities

| Term                  | Definition                                             |
| --------------------- | ------------------------------------------------------ |
| **[[Threat]]**        | An event, incident, or continuous danger to the system |
| **[[Vulnerability]]** | A weakness, gap, or fault in the system                |
| **Relationship**      | Vulnerabilities are exploited by threats               |

> [!quote] Exam Note
> Scenario-based questions are likely to appear on the exam. Practice applying the Risk, ALE, and SLE formulas to short word problems, not just memorizing the definitions.

---

## Quantitative Risk Assessment Formulas

> [!abstract] Formula Chain
> These formulas build on each other: **[[Single Loss Expectancy]]** (SLE) feeds into **[[Annual Loss Expectancy]]** (ALE), which then feeds into the **[[Cost-Benefit Analysis]]** for a control.

~~~mermaid
graph LR
    A[Asset Value AV] --> C[SLE = AV x EF]
    B[Exposure Factor EF] --> C
    C --> D[ALE = SLE x ARO]
    E[Annual Rate of Occurrence ARO] --> D
    D --> F[Cost-Benefit Analysis]
~~~

### Single Loss Expectancy (SLE)

**Formula**: `SLE = AV x EF`

| Variable | Meaning |
| --- | --- |
| **AV** | Asset Value, the monetary worth of the asset |
| **EF** | Exposure Factor, the percentage of the asset expected to be lost in a single incident |

### Annual Loss Expectancy (ALE)

**Formula**: `ALE = SLE x ARO`

| Variable | Meaning |
| --- | --- |
| **SLE** | Single Loss Expectancy, calculated above |
| **ARO** | Annual Rate of Occurrence, how many times the event is expected to happen per year |

### Cost-Benefit Analysis for Controls

> [!note] Justification Formula
> A security control is justified when:
>
> `(ALE before control) - (ALE after control) > Cost of control`
>
> In other words, a control is only worth implementing if the money it saves in reduced annual losses exceeds what it costs to deploy and maintain.

> [!example] Worked Scenario
> Suppose a server (AV = 50,000) has an Exposure Factor of 40 percent if compromised, and this is expected to happen twice a year (ARO = 2).
>
> SLE = 50,000 x 0.40 = 20,000
>
> ALE = 20,000 x 2 = 40,000
>
> If a firewall costing 10,000 per year reduces ALE to 10,000, the savings are 40,000 - 10,000 = 30,000, which is greater than the 10,000 cost. The control is justified.

---
