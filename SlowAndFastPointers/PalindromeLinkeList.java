/*
 *
 * Definition for singly-linked list.
 * public class ListNode
 * {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 


// The reason we put fast at head.next instead of head is:

We want slow to stop at the LAST node of the first half, not at the middle/right side.
*/


class Solution {
    public boolean isPalindrome(ListNode head)
     {
            if(head==null||head.next==null)
            {
                return true;
            }
            if(head.next.next==null)
            {
               if( head.val !=head.next.val)
               {
                return false;
               }
               else
               {
                return true;
               }
            }
            ListNode slow=head;
            ListNode fast=head.next;

            while(fast!= null &&  fast.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
            }

            ListNode first=head;
            ListNode second=slow.next;
            slow.next=null;
            second=reverse(second);

            while(first!=null && second!= null)
            {
                if(first.val!= second.val)
                {
                    return false;
                }
                first=first.next;
                second=second.next;
            }
            return true;
    }

    private ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}