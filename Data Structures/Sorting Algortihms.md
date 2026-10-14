---
aliases:
  - Selection Sort
  - Insertion Sort
  - Sorting Algorithms
  - Comparison-Based Sorting
tags:
  - algorithms
  - sorting
  - selection-sort
  - insertion-sort
  - java
  - complexity-analysis
status: active
created: 2026-10-13
---

> [!abstract] Overview
> This note covers [[Sorting Algorithms]]. **[[Selection Sort]]** repeatedly picks the smallest remaining element and places it at the front of the unsorted section. **[[Insertion Sort]]** builds a sorted section one element at a time, shifting larger elements right to make room. Both are compared against [[Bubble Sort]] using [[Big O Notation]].
## Sorting Algorithms

Sorting means arranging data in a specified order, such as ascending or descending, according to given criteria.

**Four main types:**

1. **[[Bubble Sort]]**
2. **[[Selection Sort]]**
3. **[[Merge Sort]]**
4. **[[Insertion Sort]]**

---

### Bubble Sort

Bubble Sort is one of the simplest sorting methods. It repeatedly compares each element with its **immediate next element** and swaps them if they are in the wrong order. Larger values gradually "bubble up" to the end of the array.

#### Dry Run

Sorting the array `[4, 19, 1, 3]`:

| Pass | Comparison | Action | Array After Step |
| --- | --- | --- | --- |
| 1 | `4` and `19` | Already in order | `[4, 19, 1, 3]` |
| 1 | `19` and `1` | `19 > 1`, swap | `[4, 1, 19, 3]` |
| 1 | `19` and `3` | `19 > 3`, swap | `[4, 1, 3, 19]` |
| 2 | `4` and `1` | `4 > 1`, swap | `[1, 4, 3, 19]` |
| 2 | `4` and `3` | `4 > 3`, swap | `[1, 3, 4, 19]` |
| 3 | `1` and `3` | Already in order | `[1, 3, 4, 19]` |

After pass 1, `19` is locked at the end. After pass 2, `4` is locked next to it. The final result is **`[1, 3, 4, 19]`**.

| Case | Time Complexity | Explanation |
| --- | --- | --- |
| **Worst case** | $O(n^2)$ | Nested loops compare nearly every pair, for example on a reversed array |
| **Best case** | $O(n)$ | Already-sorted input, with an early-exit flag stopping after one pass |
| **Space** | $O(1)$ | Swaps happen in place using a single `temp` variable |

```java
public void bubbleSort(int[] array) {
    // Outer loop tracks how many elements have bubbled to the end
    for (int i = 0; i < array.length - 1; i++) {
        boolean swapped = false; // Tracks whether this pass changed anything

        // Inner loop compares adjacent elements in the unsorted part
        for (int j = 0; j < array.length - i - 1; j++) {

            // If current element is greater than the NEXT element, swap them
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                swapped = true;
            }
        }

        // No swaps means the array is already sorted, so stop early
        if (!swapped) {
            break;
        }
    }
}
```

> [!quote] Why the Flag Matters
> Without the `swapped` flag, the loops always run to completion, so even a sorted array costs $O(n^2)$. The flag lets the algorithm detect a pass with zero swaps and exit, which is what produces the $O(n)$ best case.


---

## Selection Sort

Selection Sort divides the array into two parts: a *sorted* side on the left and an *unsorted* side on the right. It repeatedly scans the unsorted part to find the **minimum**, then swaps it into the first position of the unsorted section.

### How It Works

1. Start at the first index (`i = 0`) and assume it holds the smallest value (`min = i`).
2. Use a second loop (`j = i + 1`) to scan the rest of the array to the right.
3. Whenever `array[j] < array[min]`, update `min = j`.
4. After the scan, swap `array[min]` with `array[i]`.

```java
public void selectionSort(int[] array) {
    // Outer loop moves the boundary of the unsorted subarray
    for (int i = 0; i < array.length - 1; i++) {
        int min = i; // Assume the current index holds the smallest value

        // Inner loop searches the remaining unsorted elements
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[min]) {
                min = j; // Found a new minimum, save its index
            }
        }

        // Swap the smallest found element into position i
        int temp = array[min];
        array[min] = array[i];
        array[i] = temp;
    }
}
```

### Complexity

| Case | Time Complexity | Explanation |
| --- | --- | --- |
| **Best case** | $O(n^2)$ | Even on a sorted array, the inner loop still scans every remaining element to confirm nothing is smaller |
| **Worst case** | $O(n^2)$ | Two nested loops scan the array |
| **Space** | $O(1)$ | Sorts in place using a single `temp` variable |

### Dry Run

Sorting `[29, 10, 14, 37, 13]`:

| Pass | `i` | Scan Result | Swap | Array After Pass |
| --- | --- | --- | --- | --- |
| 1 | `0` | Minimum is `10` at index `1` | Index `0` with index `1` | `[10, 29, 14, 37, 13]` |
| 2 | `1` | Minimum is `13` at index `4` | Index `1` with index `4` | `[10, 13, 14, 37, 29]` |
| 3 | `2` | Minimum is `14` at index `2` | Index `2` with itself, no change | `[10, 13, 14, 37, 29]` |
| 4 | `3` | Minimum is `29` at index `4` | Index `3` with index `4` | `[10, 13, 14, 29, 37]` |

The final sorted array is **`[10, 13, 14, 29, 37]`**.

> [!note] Pass 1 Detail
> Starting with `min = 0` (value `29`), the scan finds `10 < 29` at `j = 1`, so `min = 1`. The remaining checks (`14`, `37`, `13`) are none smaller than `10`, so `min` stays at `1`.

---

## Insertion Sort

Insertion Sort is **efficient for small or nearly sorted data**. It works like sorting playing cards in your hand: pick up one unsorted card (the `key`), shift larger sorted cards to the right, and drop the `key` into the gap.

### How It Works

1. Pick the current element as the `key` (`key = array[i]`).
2. Set a pointer `j` to the element immediately to its left (`j = i - 1`).
3. While `j >= 0` and `array[j] > key`, move left (`j--`).
4. Shift each larger value one slot right (`array[j + 1] = array[j]`).
5. When a smaller value or the array start is reached, place the key (`array[j + 1] = key`).

```java
public void insertionSort(int[] array) {
    // Start from the second element; index 0 is a sorted section of size one
    for (int i = 1; i < array.length; i++) {
        int key = array[i]; // Element to insert into the sorted left side
        int j = i - 1;      // Last index of the sorted left side

        // Shift elements greater than key one position to the right
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j = j - 1;
        }

        // Insert the key into its correct slot
        array[j + 1] = key;
    }
}
```

> [!note] Loop Bounds
> The outer loop must run from `i = 1` to `i < array.length`. Starting at `1` is correct because a single element at index `0` is already sorted. Running to `array.length` ensures the **last element** is also inserted. A bound of `array.length - 1` would skip it.

### Complexity

| Case | Time Complexity | Explanation |
| --- | --- | --- |
| **Best case** | $O(n)$ | On a sorted array, `array[j] > key` is always false, so the `while` loop never runs |
| **Worst case** | $O(n^2)$ | On a reverse-sorted array, every key shifts all the way back to index `0` |
| **Space** | $O(1)$ | Sorts in place using only `key` and `j` |

### Dry Run

Sorting `[8, 3, 5, 2]`, with `[8]` treated as sorted at the start:

| Pass | `i` | `key` | Shifts | Insert At | Array After Pass |
| --- | --- | --- | --- | --- | --- |
| 1 | `1` | `3` | `8` moves right | Index `0` | `[3, 8, 5, 2]` |
| 2 | `2` | `5` | `8` moves right | Index `1` | `[3, 5, 8, 2]` |
| 3 | `3` | `2` | `8`, `5`, `3` move right | Index `0` | `[2, 3, 5, 8]` |

The final sorted array is **`[2, 3, 5, 8]`**.

~~~mermaid
graph TD
    A["Pick key = array[i]"] --> B["j = i - 1"]
    B --> C{"j >= 0 and array[j] > key?"}
    C -- Yes --> D["array[j + 1] = array[j]"]
    D --> E["j = j - 1"]
    E --> C
    C -- No --> F["array[j + 1] = key"]
    F --> G{"More elements?"}
    G -- Yes --> A
    G -- No --> H["Array sorted"]
~~~

---

## Comparison Summary

| Algorithm | Best Case | Worst Case | Space | Key Behavior |
| --- | --- | --- | --- | --- |
| **[[Bubble Sort]]** | $O(n)$ with flag | $O(n^2)$ | $O(1)$ | Swaps adjacent pairs repeatedly |
| **[[Selection Sort]]** | $O(n^2)$ | $O(n^2)$ | $O(1)$ | Always scans the full unsorted section, so no best-case speedup |
| **[[Insertion Sort]]** | $O(n)$ | $O(n^2)$ | $O(1)$ | Fast on nearly sorted data |

---

## Related Concepts

- [[Sorting Algorithms]]: The parent topic covering all comparison and ordering strategies.
- [[Bubble Sort]]: Another quadratic, in-place sort that shares the same worst case.
- [[Merge Sort]]: A faster [[Divide and Conquer]] alternative, listed in the sorting overview.
- [[Big O Notation]]: The framework behind every complexity figure above.
- [[Array]]: The data structure both algorithms operate on in place.