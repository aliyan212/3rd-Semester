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
> This note covers two families of algorithms. **[[Searching Algorithms]]** find a value or index inside a data structure, using either [[Linear Search]] or [[Binary Search]]. Complexity is described using [[Big O Notation]].

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

## Comparison Summary

| Algorithm             | Best Case        | Worst Case  | Space  | Needs Sorted Input |
| --------------------- | ---------------- | ----------- | ------ | ------------------ |
| **[[Linear Search]]** | $O(1)$           | $O(n)$      | $O(1)$ | No                 |
| **[[Binary Search]]** | $O(1)$           | $O(\log n)$ | $O(1)$ | Yes                |
| **[[Bubble Sort]]**   | $O(n)$ with flag | $O(n^2)$    | $O(1)$ | No                 |

---

## Related Concepts

- [[Big O Notation]]: The framework used for every complexity figure above.
- [[Logarithmic Time]]: Why halving the search space gives $O(\log n)$.
- [[Divide and Conquer]]: The strategy behind binary search and [[Merge Sort]].
- [[Array]]: The data structure all of these algorithms operate on.
- [[Linked List]]: A structure where binary search is impractical, since it lacks index-based access to the middle element.