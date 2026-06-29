/*
LeetCode: 141
Problem: Linked List Cycle
Difficulty: Easy

Topics:
- Linked List
- Floyd's Cycle Detection
- Slow and Fast Pointers

Approach:
Use two pointers:
- Slow moves one node at a time.
- Fast moves two nodes at a time.
If the linked list contains a cycle, both pointers will eventually meet.
If the fast pointer reaches null, the list does not contain a cycle.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 class Solution {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}