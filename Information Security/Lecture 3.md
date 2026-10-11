---
aliases: [InfoSec Core Concepts, Threat Terminology, Attack Vocabulary]
tags: [information-security, cybersecurity, threats, vulnerabilities, foundations]
status: active
created: 2026-09-26
---
# Core Concepts of Information Security and Threat Terminology

> [!abstract] Overview
> This document defines the foundational purpose of [[Information Security]], refines the definitions of [[Authentication]] and [[Authorization]], and builds a precise vocabulary for describing [[Threats and Attacks]].

---

## Core Concepts of Information Security

### Authentication

> [!note] Definition
> Authentication specifically means verifying the **identity** of a person, system, or service, typically by checking credentials such as a password, token, or biometric factor against a known identity claim. It answers the question *"are you who you say you are?"*, not a general question about reality.

### Authorization

> [!note] Definition
> **[[Authorization]]** is the process of granting access to a verified identity, defining what that identity is permitted to do once inside the system.


---

## Threats and Attacks Terminology

The terms below are frequently confused with one another. Precision matters because they describe different stages of the same event chain.

~~~mermaid
graph LR
    A[Vulnerability] --> B[Threat]
    B --> C[Threat Agent]
    C --> D[Vector]
    D --> E[Attack]
    E --> F[Exposure]
    F --> G[Incident]
~~~

### Vulnerability

**[[Vulnerability]]**: A weakness or fault in a system that could potentially be exploited.

### Threat

> [!note] Definition: Threat vs. Attack
> Calling a **DDoS attack** an example of a *"threat"* blurs the line between two different stages. A **[[Threat]]** is the *potential* for a danger to be realized, such as the general possibility that a malicious actor could flood your servers. The **DDoS attack itself is the realized [[Attack]]**, not the threat. The threat is the standing possibility; the attack is the actual event that exploits it. It is also worth noting a threat does not have to be continuous; it can be a one-time potential danger as well as an ongoing category of risk.

### Threat Agent

**[[Threat Agent]]** (or threat actor): A specific person, object, or entity, such as an attacker, hacker group, or malicious insider, that carries out or poses a danger to the system.

### Attack

> [!note] Definition
> An attack is more precisely defined as *an attempt to exploit a vulnerability*, whether or not that attempt succeeds. A blocked attack is still an attack; it just did not result in damage.

### Vector

>[!note] Definition
>The carrier or delivery mechanism that transports an attack to its target, such as a malicious email attachment, an infected USB drive, or a compromised website link.

### Exposure

> [!note] Definition
> **Exposure** describes a state where a system or data is *accessible or vulnerable to potential harm*, typically due to a misconfiguration or unintentional disclosure, **before** or independent of any actual exploitation. A device that has already been exploited is better described as *compromised*. Confusing the two collapses the distinction between "at risk" and "already breached."

### Incident

> [!note] Definition 
> An **incident** is typically defined as the actual event or occurrence that violates security policy or threatens data, including the breach itself, not only what happens afterward. The recovery and effects that follow are usually addressed separately, under **[[Incident Response]]**.

---

## Summary Table

| Term | Correct Definition | Common Mistake to Avoid |
| --- | --- | --- |
| **[[Vulnerability]]** | A weakness in a system | Confusing with an active threat |
| **[[Threat]]** | Potential for danger to be realized | Treating a specific attack as the threat itself |
| **[[Threat Agent]]** | The person or entity behind the danger | Conflating agent with the threat concept |
| **[[Vector]]** | The delivery mechanism of an attack | Confusing with the attack itself |
| **[[Attack]]** | An attempt to exploit a vulnerability | Assuming damage must occur |
| **[[Exposure]]** | A state of being accessible to risk, before exploitation | Assuming it only applies after a breach |
| **[[Incident]]** | The actual event or breach | Reducing it to only the aftermath |

---

