/*

86. Partition List

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
    public ListNode partition(ListNode head, int x) {

        ListNode d1= new ListNode();
        ListNode d2= new ListNode();
        ListNode ptr1= d1;
        ListNode ptr2=d2;
        ListNode temp=head;
        while(temp!=null)
        {
            if(temp.val<x)
            {
                ptr1.next=temp;
                ptr1=ptr1.next;
                temp=temp.next;
            }
            else
            {
                ptr2.next=temp;
                ptr2=ptr2.next;
                temp=temp.next;
            }
        }

        ptr1.next= null;
        ptr2.next=null;
        ptr1.next=d2.next;
        return d1.next;
        
    }
}