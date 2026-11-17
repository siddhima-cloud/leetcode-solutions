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
    public int pairSum(ListNode head) {
        
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
            int sum=0;
            int ans=Integer.MIN_VALUE;
            while(first!=null && second!= null)
            {
                sum=first.val+ second.val;
                ans= Math.max(sum,ans);
                first=first.next;
                second=second.next;
            }
            return ans;
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