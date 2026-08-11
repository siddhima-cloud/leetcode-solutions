/*
 Leetcode 203. Remove Linked List Elements




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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev=null;
      
        while(head!=null&&head.val==val)
        {
           
            head=head.next;
        } prev=head;
          ListNode temp=head;
          while(temp!=null&&temp.next!=null)
          {
            if(temp!=null && temp.val!=val)
            {
                prev= temp;
                temp=temp.next;
            }
            else if(temp.val==val)
            {
                prev.next=temp.next;
            
                temp=temp.next;
            }

          }
          if(temp!=null&&temp.val==val)
          {
            prev.next=null;
          }
       return head; 
    }
}