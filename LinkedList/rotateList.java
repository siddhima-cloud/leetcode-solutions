/**
 * Definition for singly-linked list.
 * */

/*
61. Rotate List

*/
   class ListNode {
 int val;
  ListNode next;
  ListNode() {}
    ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 


class rotateList {
   
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)
        {
            return head;
        }
      ListNode lastNode=null;
      int n=0;
      ListNode t=head;
        while(t!=null)
        {
            n++;
            lastNode=t;
            t=t.next;
        }
       
        lastNode.next=head;
       
        k=k%n;
        ListNode temp=head;
        int pos=n-k;
        int i=1;
        while(i!=pos&&temp!=null)
        {
            temp=temp.next;
            i++;
        }
       head=temp.next;
        temp.next=null;
        return head;

    }
   
}