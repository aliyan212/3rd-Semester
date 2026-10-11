---
aliases:
  - Mathematical Expression Formats
  - Shunting-yard Algorithm
  - Infix to Postfix
  - Infix to Prefix
tags:
  - computer-science
  - data-structures/stack
  - algorithms
  - mathematics
status: complete
created: 2026-09-21
---

> [!abstract] Overview
> Computers and humans evaluate mathematical expressions differently. Humans rely on visual groupings and strict [[Operator Precedence]] rules. Computers process data sequentially using a [[Stack]] data structure. This note explains how to translate human-readable math into machine-readable formats.

---

## The Three [[Mathematical Notations]]

We categorize mathematical expressions into three primary formats based on where the operator is placed relative to its operands. 

| Notation Type | Structure | User Base | Evaluation Logic | Parentheses Required? |
| --- | --- | --- | --- | --- |
| **[[Infix]]** | Operator is *between* operands (e.g., A + B) | Humans | Requires strict precedence rules | Yes, to resolve ambiguities |
| **[[Postfix]]** (Reverse Polish) | Operator *follows* operands (e.g., A B +) | Machines | Strictly left-to-right using [[LIFO]] logic | No |
| **[[Prefix]]** (Polish Notation) | Operator *precedes* operands (e.g., + A B) | Machines | Strictly right-to-left evaluation | No |

---

## The [[Operator Precedence]] Hierarchy

When converting expressions using a [[Stack]], the stack acts as a holding cell for [[Operators]]. Precedence dictates which operator gets to stay in the stack and which gets forced out to the output.

> [!note] Precedence Levels
> 1. **Highest:** `^` (Exponentiation)
> 2. **Medium:** `*` (Multiplication), `/` (Division)
> 3. **Lowest:** `+` (Addition), `-` (Subtraction)

---

## [[Infix to Postfix Conversion]] 

The [[Shunting-yard Algorithm]] reads the [[Infix]] string token by token from left to right.

### Core Algorithm Rules

1. **[[Operands]]** (Letters/Numbers): Always bypass the stack and go directly to the output.
2. **[[Operators]]** (`+`, `-`, `*`, `/`, `^`): Go to the stack, but must obey the **Precedence Check**.
    * *Precedence Check:* If the incoming operator has lower or equal precedence than the top stack operator, the stack operator is popped to the output. Repeat until the stack top is strictly lower precedence or empty. Then push the new operator.
3. **Parentheses** (The Overrides):
    * *Opening* `(` : Pushed directly to the stack, ignoring precedence. Acts as a concrete floor.
    * *Closing* `)` : Never goes into the stack. Triggers a stack purge. Pop every operator to the output until the matching `(` is encountered. Discard both parentheses.
4. **End of String**: Once fully read, pop all remaining operators from the stack to the output.

~~~mermaid
graph LR
    A[Read Token] --> B{Token Type?}
    B -->|Operand| C[Send to Output]
    B -->|Operator| D[Check Precedence & Push/Pop]
    B -->|Left Paren| E[Push to Stack]
    B -->|Right Paren| F[Purge Stack to Output]
~~~

### Simple Trace Examples

> [!example] Trace A: `A + B * C`
> *Higher precedence `*` stacks safely on lower precedence `+`*
> 1. Read `A` $\rightarrow$ Output: `A`
> 2. Read `+` $\rightarrow$ Stack: `[+]`
> 3. Read `B` $\rightarrow$ Output: `A B`
> 4. Read `*` $\rightarrow$ `*` > `+`. Stack: `[+, *]`
> 5. Read `C` $\rightarrow$ Output: `A B C`
> 6. End $\rightarrow$ Pop all. Output: `A B C * +`

> [!example] Trace B: `(A + B) * C`
> *Parentheses force addition to evaluate first*
> 1. Read `(` $\rightarrow$ Stack: `[ ( ]`
> 2. Read `A` $\rightarrow$ Output: `A`
> 3. Read `+` $\rightarrow$ Stack: `[ (, + ]`
> 4. Read `B` $\rightarrow$ Output: `A B`
> 5. Read `)` $\rightarrow$ Purge stack until `(`. Pop `+`. Stack: `[ ]`. Output: `A B +`
> 6. Read `*` $\rightarrow$ Stack: `[ * ]`
> 7. Read `C` $\rightarrow$ Output: `A B + C`
> 8. End $\rightarrow$ Pop all. Output: `A B + C *`

### Complex Trace Example

**Expression:** `A + B * C + (D * E + F) * G`

This tests the precedence hierarchy, left-to-right associativity (equal precedence popping), and parenthesis overrides.

| Read Token | Stack State | Output String |
| --- | --- | --- |
| **A** | `[ ]` | `A` |
| **+** | `[ + ]` | `A` |
| **B** | `[ + ]` | `A B` |
| **\*** | `[ +, * ]` | `A B` |
| **C** | `[ +, * ]` | `A B C` |
| **+** | `[ + ]` | `A B C * +` |
| **(** | `[ +, ( ]` | `A B C * +` |
| **D** | `[ +, ( ]` | `A B C * + D` |
| **\*** | `[ +, (, * ]` | `A B C * + D` |
| **E** | `[ +, (, * ]` | `A B C * + D E` |
| **+** | `[ +, (, + ]` | `A B C * + D E *` |
| **F** | `[ +, (, + ]` | `A B C * + D E * F` |
| **)** | `[ + ]` | `A B C * + D E * F +` |
| **\*** | `[ +, * ]` | `A B C * + D E * F +` |
| **G** | `[ +, * ]` | `A B C * + D E * F + G` |
| **End** | `[ ]` | `A B C * + D E * F + G * +` |

**Final Postfix Result:** `A B C * + D E * F + G * +`

---

## [[Infix to Prefix Conversion]]

To convert [[Infix]] to [[Prefix]] using stack logic, you run a modified three-step process.

1. **Reverse** the original infix expression. Swap opening and closing parentheses (`(` becomes `)` and vice versa).
2. **Convert** the reversed string using the standard Infix to Postfix algorithm, but apply the Equal Precedence Tweak.
3. **Reverse** the final output string.

> [!note] The Equal Precedence Tweak
> Because you reverse the string in Step 1, you are reading the math backward. This changes associativity logic.
> * **Normal Postfix Rule:** Pop if stack precedence is $\ge$ incoming precedence.
> * **Reversed Prefix Rule:** Pop if stack precedence is $>$ incoming precedence. *If they are equal, push it onto the stack.*

### Simple Trace Example A

**Original Expression:** `A + B * C`

**Step 1: Reverse the String and Swap Parentheses**
*Reversed & Swapped:* `C * B + A`

**Step 2: Apply the Modified Postfix Algorithm**

| Read Token | Stack State | Output String |
| ---------- | ----------- | ------------- |
| **C**      | `[ ]`       | `C`           |
| **\***     | `[ * ]`     | `C`           |
| **B**      | `[ * ]`     | `C B`         |
| **+**      | `[ + ]`     | `C B *`       |
| **A**      | `[ + ]`     | `C B * A`     |
| **End**    | `[ ]`       | `C B * A +`   |

**Step 3: Reverse the Final Output String**
*Step 2 Output:* `C B * A +`
**Final Prefix Result:** `+ A * B C`

### Simple Trace Example B

**Original Expression:** `(A + B) * C`

**Step 1: Reverse the String and Swap Parentheses**
*Reversed & Swapped:* `C * (B + A)`

**Step 2: Apply the Modified Postfix Algorithm**

| Read Token | Stack State | Output String |
| --- | --- | --- |
| **C** | `[ ]` | `C` |
| **\*** | `[ * ]` | `C` |
| **(** | `[ *, ( ]` | `C` |
| **B** | `[ *, ( ]` | `C B` |
| **+** | `[ *, (, + ]` | `C B` |
| **A** | `[ *, (, + ]` | `C B A` |
| **)** | `[ * ]` | `C B A +` |
| **End** | `[ ]` | `C B A + *` |

**Step 3: Reverse the Final Output String**
*Step 2 Output:* `C B A + *`
**Final Prefix Result:** `* + A B C`

### Complex Trace Example

**Original Expression:** `A + B * C + (D * E + F) * G`

**Step 1: Reverse the String and Swap Parentheses**
*Reversed & Swapped:* `G * (F + E * D) + C * B + A`

**Step 2: Apply the Modified Postfix Algorithm**

| Read Token | Stack State | Output String |
| --- | --- | --- |
| **G** | `[ ]` | `G` |
| **\*** | `[ * ]` | `G` |
| **(** | `[ *, ( ]` | `G` |
| **F** | `[ *, ( ]` | `G F` |
| **+** | `[ *, (, + ]` | `G F` |
| **E** | `[ *, (, + ]` | `G F E` |
| **\*** | `[ *, (, +, * ]` | `G F E` |
| **D** | `[ *, (, +, * ]` | `G F E D` |
| **)** | `[ * ]` | `G F E D * +` |
| **+** | `[ + ]` | `G F E D * + *` |
| **C** | `[ + ]` | `G F E D * + * C` |
| **\*** | `[ +, * ]` | `G F E D * + * C` |
| **B** | `[ +, * ]` | `G F E D * + * C B` |
| **+** | `[ +, + ]` | `G F E D * + * C B *` |
| **A** | `[ +, + ]` | `G F E D * + * C B * A` |
| **End** | `[ ]` | `G F E D * + * C B * A + +` |

**Step 3: Reverse the Final Output String**
*Step 2 Output:* `G F E D * + * C B * A + +`
**Final Prefix Result:** `+ + A * B C * + * D E F G`