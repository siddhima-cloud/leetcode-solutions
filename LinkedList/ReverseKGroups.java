/*

25. Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null || head.next==null)
        {
            return head;
        }
        
        int n= countNodes(head);

        if(k>n)
        {
            return head;
        }
        ListNode curr= head;
        ListNode dummy= new ListNode(0,head);
        ListNode prev=dummy;
        int i=0;
        while(curr !=null &&i<(n/k))
        {
            ListNode temp= curr;
            int j=1;
            while(temp!=null &&j<k)
            {
                temp=temp.next;
                j++;

            }

            ListNode t= temp.next;
            temp.next= null;
            prev.next= reverse(curr);
            curr.next= t;
            prev=curr;
            curr= t;
            
            i++;
        }

        prev.next=curr;

        return dummy.next;
        
    }

    static int countNodes(ListNode head)
    {
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            temp=temp.next;
            count++;
        }
        return count;
    }

    static ListNode reverse(ListNode head)
    {
        ListNode prev= null;
        ListNode curr= head;
        while(curr !=null)
        {
          ListNode next= curr.next;
          curr.next= prev;
          
          prev= curr;
          curr= next;
        }
        return prev;
    }
}