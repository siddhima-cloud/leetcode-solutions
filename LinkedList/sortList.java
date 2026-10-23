/*
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
    public ListNode sortList(ListNode head) {
        
        if(head==null|| head.next==null)
        {
            return head;
        }
        ListNode mid= getmid(head);
        ListNode l1= sortList(head);
        ListNode l2= sortList(mid);
        return merge(l1,l2);


    }
    public static ListNode getmid(ListNode temp)
    {
        if(temp==null|| temp.next==null)
        {
            return temp;
        }
        ListNode slow=temp;
        ListNode fast= temp.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode m= slow.next;
        slow.next= null;
        return m;
    }

    public static ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode dummy= new ListNode(0);

        ListNode ptr= dummy;
        while(l1!=null &&l2!= null)
        {
            if(l1.val<=l2.val)
            {
                ptr.next=l1;
                l1=l1.next;
                ptr = ptr.next;
            }
            else 
            {
                 ptr.next=l2;
                l2=l2.next;
                ptr = ptr.next;
            }
        }

        while(l1!=null)
        {
              ptr.next=l1;
                l1=l1.next;
                ptr = ptr.next;
        }

        while(  l2!=null)
        {
             ptr.next=l2;
                l2=l2.next;
                ptr = ptr.next;
        }
        return dummy.next;

    }
}
