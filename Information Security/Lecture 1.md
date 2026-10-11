---
aliases: [Expanded Information Security Concepts, Deep Dive InfoSec]
tags: [information-security, cybersecurity, network-security, system-security, cia-triad, networking]
status: active
created: 2026-09-10
---
> [!abstract] Overview
> This note expands on the foundational concepts of [[Information Security]]. It provides a deeper look into the [[CIA Triad]] and clearly breaks down the boundaries and overlaps between [[Cybersecurity]], [[System Security]], and [[Network Security]].

---

## Breaking Down the Security Domains

It is easy to confuse these terms, but they represent different layers of defense.

> [!quote] The Hierarchy of Protection
> "All Cybersecurity is Information Security, but not all Information Security is Cybersecurity."

~~~mermaid
graph TD
    A[Information Security] --> B[Cybersecurity]
    A --> C[Physical Security]
    
    B --> D[Network Security]
    B --> E[System Security]
    B --> F[Application Security]
~~~

### [[Information Security]] (InfoSec)
This is the widest category. It covers the protection of *all* data, no matter where it lives or what form it takes. 
*   **Scope:** It includes digital data on a hard drive, spoken secrets in a meeting room, and physical paper files in a locked drawer. 
*   **Goal:** To protect the value of information itself.

### [[Cybersecurity]]
This domain lives inside Information Security. It focuses entirely on protecting *digital* information and electronic systems from attacks that come from the internet or other digital networks.
*   **Scope:** Defending against malware, ransomware, phishing emails, and remote hackers.
*   **Goal:** To defend the digital infrastructure from malicious cyber threats.

### [[Network Security]]
This is a specialized branch of Cybersecurity. If you think of computers as houses, Network Security is about guarding the roads connecting those houses.
*   **Scope:** Protecting data while it is moving (in transit). 
*   **Tools:** [[Firewalls]] to block bad traffic, [[VPNs]] to encrypt data traveling over the internet, and [[Intrusion Detection Systems]] to watch for suspicious network behavior.
*   **Goal:** To stop attackers before they can even reach the computers.

### [[System Security]]
This is another specialized branch. Returning to the house analogy, System Security is about locking the doors and windows of the house itself.
*   **Scope:** Protecting individual devices (servers, laptops, smartphones) and their internal operating systems.
*   **Tools:** Antivirus software, regular operating system updates (patching), and full disk encryption.
*   **Goal:** To ensure the standalone machine is locked down, even if the network it connects to is unsafe.

---

## Detailed Domain Comparison

| Domain                       | Core Focus                             | Key Tools & Methods                   | Real-World Target                              |
| :--------------------------- | :------------------------------------- | :------------------------------------ | :--------------------------------------------- |
| **[[Information Security]]** | Data everywhere (digital and physical) | Filing cabinets, shredders, policies  | Protecting a printed patient medical record    |
| **[[Cybersecurity]]**        | Digital data and systems               | Threat hunting, incident response     | Stopping a ransomware group                    |
| **[[Network Security]]**     | Data in transit (moving)               | Routers, firewalls, Wi-Fi passwords   | Blocking a hacker from private Wi-Fi           |
| **[[System Security]]**      | Data at rest (stored)                  | Antivirus, OS patching, user accounts | Preventing malware from installing on a laptop |

---

> [!example] A Complete Security Scenario
> Imagine you are sending a highly sensitive financial report to your boss.
> 
> 1. You put a password on the document so only your boss can open it. This is **[[Information Security]]** (specifically, [[Confidentiality]]).
> 2. You connect to the company [[VPN]] so the internet provider cannot read the email as it sends. This is **[[Network Security]]**.
> 3. Your company's email server scans the incoming file to make sure a hacker didn't attach a virus to it. This is **[[System Security]]**.
> 4. The entire framework that allows your company to monitor these steps and respond if something goes wrong is **[[Cybersecurity]]**.

---

## The Core Concept: The CIA Triad

The **[[CIA Triad]]** is the gold standard for evaluating how secure a system or organization really is. Every security rule, tool, and policy is created to support at least one of these three pillars.

### 1. [[Confidentiality]]
Confidentiality means keeping secrets safe. It ensures that sensitive information is only seen by people or systems that have the right to see it.
*   **How it works:** We use *access controls* (like usernames and passwords) and *encryption* (scrambling data so it cannot be read without a key).
*   **Failure example:** A hacker steals a database of customer credit card numbers and posts it online. This is a massive breach of confidentiality.

### 2. [[Integrity]]
Integrity means keeping data accurate and trustworthy. It ensures that information is not changed, deleted, or corrupted by accident or by malicious actors.
*   **How it works:** We use *hashing* (creating a unique mathematical fingerprint for a file) and strict *permissions* (only allowing certain users to edit files).
*   **Failure example:** An angry employee alters the company payroll spreadsheet to pay themselves twice as much. The data has lost its integrity.

### 3. [[Availability]]
Availability means keeping systems online and data accessible. It ensures that authorized users can get to the information whenever they need it.
*   **How it works:** We use *backups*, *redundant servers* (having a backup server ready if the main one fails), and *surge protection*.
*   **Failure example:** A hacker floods a website with fake traffic so real customers cannot log in (a [[DDoS Attack]]). The system has lost its availability.

---
