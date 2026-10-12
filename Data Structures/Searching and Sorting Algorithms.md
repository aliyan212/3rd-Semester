---
aliases:
  - Searching Algorithms
  - Sorting Algorithms
  - Linear Search
  - Binary Search
  - Bubble Sort
tags:
  - algorithms
  - searching
  - sorting
  - binary-search
  - bubble-sort
  - java
  - complexity-analysis
status: active
created: 2026-10-12
---


> [!abstract] Overview
> This note covers two families of algorithms. **[[Searching Algorithms]]** find a value or index inside a data structure, using either [[Linear Search]] or [[Binary Search]]. **[[Sorting Algorithms]]** arrange data in a chosen order, and this note works through [[Bubble Sort]] in detail. Complexity is described using [[Big O Notation]].

---

## Searching Algorithms

Searching is the process of finding a specific number, value, or index in a given data structure. There are two primary types:

- **[[Linear Search]]** (also called *Sequential Search*)
- **[[Binary Search]]**

---

### Linear Search

Linear search checks every element in the array one by one, from start to finish, until it finds the target.

- **Data requirement:** works on both *sorted and unsorted* arrays.
- **How it works:** it visits each index in order.

| Case | Time Complexity | Explanation |
| --- | --- | --- |
| **Worst case** | $O(n)$ | The target is at the very end or not in the array at all |
| **Best case** | $O(1)$ | The target is at the first index, `0` |
| **Space** | $O(1)$ | No extra memory is needed |

```java
public int linearSearch(int[] arr, int target) {
    // Traverse each index one by one
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            System.out.println("Number found");
            return i; // Return the index where it was found
        }
    }
    return -1; // Target does not exist in the array
}
```

---

### Binary Search

Binary search repeatedly halves the search space by comparing the target with the **middle element** of the array.

> [!note] Sorted Data Is Mandatory
> The array **must be sorted** first. On unsorted data, binary search gives unreliable results, because discarding half the array is only valid when the order is known.

**How it works:**

1. Set a `left` pointer at the start (`0`) and a `right` pointer at the end (`array.length - 1`).
2. Find the `mid` index halfway between `left` and `right`.
3. If `array[mid]` equals the target, return `mid`.
4. If `array[mid] < target`, the target must be in the right half. Move `left` to `mid + 1`.
5. If `array[mid] > target`, the target must be in the left half. Move `right` to `mid - 1`.

| Case | Time Complexity | Explanation |
| --- | --- | --- |
| **Worst case** | $O(\log n)$ | The search area is cut in half at every step |
| **Best case** | $O(1)$ | The target is the first middle element checked |
| **Space (iterative)** | $O(1)$ | Only a few pointer variables are used |

```java
public int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left <= right) {
        // Overflow-safe middle index
        int mid = left + (right - left) / 2;

        // Case 1: Target is at the middle
        if (array[mid] == target) {
            return mid;
        }
        // Case 2: Target is larger than mid, so search the right half
        else if (array[mid] < target) {
            left = mid + 1;
        }
        // Case 3: Target is smaller than mid, so search the left half
        else {
            right = mid - 1;
        }
    }

    return -1; // Target not found after loop finishes
}
```

~~~mermaid
graph TD
    A["Set left = 0, right = n - 1"] --> B{"left <= right?"}
    B -- No --> C["Return -1"]
    B -- Yes --> D["mid = left + (right - left) / 2"]
    D --> E{"array[mid] vs target"}
    E -- Equal --> F["Return mid"]
    E -- "Less than" --> G["left = mid + 1"]
    E -- "Greater than" --> H["right = mid - 1"]
    G --> B
    H --> B
~~~

---

#### Binary Search Dry Run

> [!example] Visual Concept
> Splitting `[10, 20, 30, 40, 50, 60]` in half gives `[10, 20, 30]` and `[40, 50, 60]`. If the target is `40`, it is in the right half, so the left half is discarded in one comparison.

**Setup:**

- **Array (9 elements, indices `0` to `8`):** `[10, 20, 30, 40, 50, 60, 70, 80, 90]`
- **Target:** `80` (at index `7`)
- **Initial pointers:** `left = 0`, `right = 8`

| Iteration | `left` | `right` | `mid` | `array[mid]` | Comparison | Action           |
| --------- | ------ | ------- | ----- | ------------ | ---------- | ---------------- |
| 1         | `0`    | `8`     | `4`   | `50`         | `50 < 80`  | `left = 5`       |
| 2         | `5`    | `8`     | `6`   | `70`         | `70 < 80`  | `left = 7`       |
| 3         | `7`    | `8`     | `7`   | `80`         | `80 == 80` | Return index `7` |

The target is found in 3 iterations instead of the 8 comparisons a linear search would need.

---

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

## Comparison Summary

| Algorithm | Best Case | Worst Case | Space | Needs Sorted Input |
| --- | --- | --- | --- | --- |
| **[[Linear Search]]** | $O(1)$ | $O(n)$ | $O(1)$ | No |
| **[[Binary Search]]** | $O(1)$ | $O(\log n)$ | $O(1)$ | Yes |
| **[[Bubble Sort]]** | $O(n)$ with flag | $O(n^2)$ | $O(1)$ | No |

---

## Related Concepts

- [[Big O Notation]]: The framework used for every complexity figure above.
- [[Logarithmic Time]]: Why halving the search space gives $O(\log n)$.
- [[Divide and Conquer]]: The strategy behind binary search and [[Merge Sort]].
- [[Array]]: The data structure all of these algorithms operate on.
- [[Linked List]]: A structure where binary search is impractical, since it lacks index-based access to the middle element.