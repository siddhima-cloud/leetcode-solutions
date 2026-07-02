  /*
  # 876. Middle of the Linked List

## Problem Statement

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the **second middle node**.

**Example 1**

```text
Input: head = [1,2,3,4,5]
Output: [3,4,5]

Explanation:
The middle node is 3.
```

**Example 2**

```text
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]

Explanation:
There are two middle nodes (3 and 4), so return the second middle node.
```

---

## Approach

This solution uses the **Slow and Fast Pointer** technique.

- A **slow** pointer moves one node at a time.
- A **fast** pointer moves two nodes at a time.

When the fast pointer reaches the end of the list:

- The slow pointer will be at the middle node.

For even-length linked lists, the slow pointer naturally ends up at the **second middle node**, which matches the problem requirement.

---

## Algorithm

1. Handle edge cases:
   - If the list is empty, return `null`.
   - If the list contains only one node, return that node.
2. Initialize:
   - `slow = head`
   - `fast = head`
3. Traverse the list while:
   - `fast != null`
   - `fast.next != null`
4. Move:
   - `slow` by one node.
   - `fast` by two nodes.
5. When the loop ends, return `slow`.

---

## Complexity Analysis

- **Time Complexity:** `O(n)`
  - Each node is visited at most once.

- **Space Complexity:** `O(1)`
  - Only two pointers are used.

---

## Java Concepts Used

- Singly Linked List
- References
- Two Pointers
- While Loop
- Conditional Statements

---

## Key Learning

- The **Slow and Fast Pointer** technique is one of the most important patterns for linked list problems.
- Moving one pointer twice as fast as the other allows the slower pointer to reach the middle exactly when the faster pointer reaches the end.
- This technique is also useful for problems such as:
  - Detecting a cycle
  - Finding the start of a cycle
  - Checking if a linked list is a palindrome
  - Splitting a linked list

---

## Dry Run

Consider:

```text
1 → 2 → 3 → 4 → 5
```

| Step | Slow | Fast |
|------|------|------|
| Start | 1 | 1 |
| 1 | 2 | 3 |
| 2 | 3 | 5 |
| End | 3 | null |

Returned node:

```text
3
```

---

### Even-Length Example

```text
1 → 2 → 3 → 4 → 5 → 6
```

| Step | Slow | Fast |
|------|------|------|
| Start | 1 | 1 |
| 1 | 2 | 3 |
| 2 | 3 | 5 |
| 3 | 4 | null |

Returned node:

```text
4
```

This satisfies the requirement of returning the **second middle node**.

---

## LeetCode

- **Problem Number:** 876
- **Difficulty:** Easy
- **Topic:** Linked List, Two Pointers
*/


class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null)
        {
            return null;
        }
        if( head.next == null)
        {
            return head;
        }
        ListNode slow = head;
        ListNode fast= head;
        while(fast != null && fast.next != null)
        {
            fast= fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

} 
