/*
LeetCode: 142
Problem: Linked List Cycle II
Difficulty: Medium

Topics:
- Linked List
- Floyd's Cycle Detection
- Slow and Fast Pointers

Approach:
Use Floyd's Cycle Detection to determine whether a cycle exists.
If slow and fast pointers meet, reset the slow pointer to the head.
Move both pointers one step at a time.
The node where they meet again is the starting node of the cycle.

Time Complexity: O(n)
Space Complexity: O(1)
*/
/**
 * Definition for singly-linked list.
 *  */
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
         next = null;
     }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
        {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                slow = head;
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;

                }
                return slow;
            }
        }
        return null;
    }
}