/*
Delete Duplicates from Sorted Linked List

Problem:
Given the head of a sorted linked list, delete all duplicate nodes so that each element appears only once. Return the head of the modified linked list.

Approach:
This solution uses the Two Pointers technique. Two pointers are maintained: i points to the current unique node, and j points to the next node. If both nodes have the same value, the duplicate node is removed by updating i.next to skip over j. If the values are different, both pointers move one step forward. Since the linked list is sorted, all duplicate values appear next to each other, making it easy to remove them in a single traversal.

Time Complexity: O(n)

Space Complexity: O(1)

Key Concepts:

Linked List
Two Pointers
In-place Modification

Example:

Input:
head = [1, 1, 2, 3, 3]

Output:
[1, 2, 3]

Explanation:
The duplicate nodes with values 1 and 3 are removed. The resulting linked list contains only unique elements while preserving the original order.
*/
class Solution
{
    public ListNode deleteDuplicate(ListNode head)
    {
        if(head== null || head.next == null)
        {
            return head;
        }
        ListNode i= head;
        ListNode j= head.next;
        while(j!=null)
        {
            if(i.val== j.val)
            {
                i.next=j.next;
                j=i.next;
            }
            else
            {
                i=i.next;
                j=j.next;
            }
        }
        return head;
    }
}
