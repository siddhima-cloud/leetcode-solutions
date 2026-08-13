/*

Leetcode 19. Remove Nth Node From End of List



method 1: using two pass linked list traversal.
length based approach
time complexity= O(l)
space complexity=O(1)


Method 2 : two pointer slow and fast pointer approach
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
          if(head==null ||(head.next==null &&n==1))
          {
            return null;
          }
          
          int prev= prevOfRemoved( head,n);
          if(prev==0)
          {
            head=head.next;
            return head;
          }
          int count =1;
          ListNode temp=head;
          while(count<prev && temp!=null  )
          {
            temp=temp.next;
            count+=1;

          }

          if(count==prev &&temp!=null)
          {
            if(temp.next!=null)
            {
                temp.next= temp.next.next;
            }
          }
          return head;

    }
    public int prevOfRemoved(ListNode head, int n)
    {
        
        ListNode curr= head;
        int count=0;
        
        while(curr!=null)
        {
            curr=curr.next;
            count+=1;
        }
       return (count-n);
    }
     
}