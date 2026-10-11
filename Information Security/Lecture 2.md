---
aliases: [Advanced Information Security, Security Models, NIST Framework]
tags: [information-security, cybersecurity, nist, threat-intelligence, compliance]
status: active
created: 2026-09-19
---
# Advanced Security Models and Frameworks

> [!abstract] Overview
> This document expands upon foundational security concepts by introducing advanced frameworks like the [[Parkerian Hexad]], the [[NIST]] regulatory playbook, specialized environments, and the application of modern [[Threat Intelligence]].

---

## The Domain Hierarchy

> [!note] Defining the Boundaries
> **[[Information Security]]** (InfoSec) is the broad parent discipline. It protects all forms of data, including physical paper, human knowledge, and digital files. It utilizes physical locks, corporate policies, and document shredders.
> 
> **[[Cybersecurity]]** is a specialized subset of InfoSec. It strictly protects digital assets, networks, and hardware using technical controls like firewalls, encryption, and antivirus software.

---

## Core Security Models

The models below form the theoretical basis for all data protection strategies and threat assessments.

### The [[CIA Triad]]
The universal standard for security design rests on three pillars:
- **[[Confidentiality]]**: Keeping data secret from unauthorized people.
- **[[Integrity]]**: Ensuring data has not been tampered with or modified.
- **[[Availability]]**: Ensuring systems and data are accessible when needed.

### The [[Parkerian Hexad]]
This model expands upon the CIA Triad, adding three extra layers for more complex [[Threat Modeling]]:

| Hexad Element | Definition | Real-World Context |
| --- | --- | --- |
| **[[Possession]]** (Control) | Holding the physical or digital asset. | If a thief steals an encrypted hard drive, the data is still confidential, but you have lost possession. |
| **[[Utility]]** | The data is in a usable format. | If you lose the decryption key to your own file, it is secure but has lost utility. |
| **[[Authenticity]]** | Verifying the true source. | Ensuring an email sender or system user is genuinely who they claim to be. |

~~~mermaid
graph LR
    A[Security Models] --> B(CIA Triad)
    A --> C(Parkerian Hexad)
    
    B --> D[Confidentiality]
    B --> E[Integrity]
    B --> F[Availability]
    
    C --> D
    C --> E
    C --> F
    C --> G[Possession]
    C --> H[Utility]
    C --> I[Authenticity]
~~~

---

## The [[NIST]] Playbook

The National Institute of Standards and Technology ([[NIST]]) sets the standard for how government and private sectors secure their systems. 

### Risk and Categorization
- **[[FIPS 199]]**: Categorizes the potential impact of a data breach as *Low*, *Moderate*, or *High*.
- **[[High Water Mark]]**: A rule stating a system's overall risk rating must equal its highest individual CIA rating. 
> [!example] High Water Mark Concept
> If a system's Confidentiality is rated Low, but its Availability is rated High, the entire system must be protected at a High level.
- **[[NIST SP 800-30]]**: The official manual for Risk Assessment. It calculates risk by multiplying the *likelihood* of a threat by its potential *impact*.

### Security Controls ([[NIST SP 800-53]])
This is the main catalog of actual defenses deployed based on the FIPS 199 rating. 

| Control Family | Identifier | Purpose |
| --- | --- | --- |
| **[[Access Control]]** | AC | Enforces *Least Privilege*, ensuring users only get the access they absolutely need to do their jobs. |
| **[[Audit and Accountability]]** | AU | Involves logging and tracking all system actions for forensic investigations. |
| **[[Incident Response]]** | IR | Creating strategic plans for how to stop an active attack and recover normal operations. |
| **[[Supply Chain Risk]]** | SR | Vetting third-party vendors to prevent outside contamination of the network. |

---

## Specialized Security Environments

Different computing environments require entirely unique security approaches and priorities.

- **[[Zero Trust]]** (NIST SP 800-207): Operates on the strict assumption that the network is already breached. It never trusts a user simply because they are inside the building or VPN. It continuously verifies user identity and device safety before granting access.
- **[[Operational Technology]]** (OT - NIST SP 800-82): Used for physical infrastructure like power grids and factory floors. In OT, Availability and Integrity are prioritized over Confidentiality because system downtime can cause physical harm or death.
- **[[Cloud Computing]]** (NIST SP 800-145): Operates on a *shared responsibility* model. The cloud provider secures the physical servers and infrastructure, while the customer is responsible for securing the data and access policies inside them.

---

## Legal and Regulatory Reporting

Organizations are legally required to report breaches to government bodies promptly.

> [!quote] Mandatory Disclosures
> - **[[SEC Form 8-K]]** (Item 1.05): Public companies must publicly report any material cyber incident (one that causes significant financial or reputational damage) within 4 business days.
> - **[[CIRCIA]]**: Critical infrastructure sectors (hospitals, power grids, banks) must report substantial cyber incidents to CISA within 72 hours, and must report any ransom payments within 24 hours.

---

## Applied [[Threat Intelligence]]

Modern security relies heavily on [[AI]] and automated systems to detect and report threats rapidly.

### Combating Phishing with AI
The **[[PhiUSIIL]]** dataset is a massive database of both legitimate and malicious URLs. It is used to train AI models to spot phishing attempts without relying on simple, easily bypassed lists of blocked websites.

Instead of just reading words, the AI looks for structural red flags:
- Overly long URLs.
- Direct IP addresses (which intentionally bypass normal DNS routing).
- Strange character repetition.
- Lookalike domains (for example, replacing a lowercase letter 'l' with the number '1').