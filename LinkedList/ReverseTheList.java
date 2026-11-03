public class ReverseTheList {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
    public ListNode reverseList(ListNode head) {

      /*
      METHOD1 : ITERATIVE
      
        if(head==null|| head.next==null)
        {
            return head;
        }
        
        ListNode prev= null;
        ListNode curr= head;
        while(curr!=null)
        {
            ListNode next= curr.next;
            curr.next=prev;
            prev=curr;
            curr= next;
        }
        return prev;
       */

            //base case for empty and single node linked list 
         if(head==null||head.next==null)
         {
            return head;
         } 

         ListNode p= reverseList(head.next); // non-tail recursion cause operations are performed after recursive call
         head.next.next=head; // resetting the node
         head.next=null;
         // setting head.next to null so that when we return back to the firstnode, it is set to null;
         return p;
         //returning the last node coz that will serve as head of reversed list;
    }

    
}
