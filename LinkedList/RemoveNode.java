/*
2487. Remove Nodes From Linked List
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
if(head==null ||head.next==null)
{
    return head;
}
        
        
        head= reverse(head);
        ListNode prev=head;
        ListNode curr= head.next;
        int currMax=head.val;
        while(curr !=null)
        {
            if(currMax<=curr.val)
            {
                currMax= Math.max(currMax,curr.val);
                prev= curr;
                curr= curr.next;
            }
            else
            {
                prev.next=curr.next;
                curr= curr.next;
            }
        }
        head= reverse(head);
        return head;
    }

    static ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode prev= null;
        ListNode curr= head;
        while(curr !=null)
        {
            ListNode next= curr.next;
            curr.next=prev;
            prev=curr;
            curr= next;
        }
        return prev;
    }
}