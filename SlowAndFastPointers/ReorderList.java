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



/*
        leetcode 143: Reorder LinkedList

        input: 1->2->3->4->5
        output: 1->5->2->4->3



        approach
        step1: find middle element using slow and fast pointer
                slow=head; 
                fast=head;
                while(fast!=null &&fast.next!= null)
                {
                slow=slow.next;
                fast=fast.next.next;
                }
                middle=slow;

        step2: split the list into two list. The first list contains node from start to middle and the second list contains rest of the node
                
                ListNode first= head;
                ListNode second= middle.next; //head of second node
                middle.next= null; //spliting list;
                
        step3: reverse the second list
                prev=null;
                curr=head;

               1.save the next node
                    next=curr.next;
               2.Reverse
                    curr.next=prev;
               3. Move
                    prev=curr;
                    curr=next;

                At the end:
                    curr=null;
                    prev=new head;

        step4: merge both lists alternatively
                for merging the list the idea is:
                1. store what you are about to lose
                     ListNode firstNext=first.next;
                     ListNode secondNext=second.next;

                2. change the links
                    first.next=second;
                    second.next=firstNext;

                3. move forward
                    first=firstNext;
                    second=secondNext;



*/
class Solution {
    public void reorderList(ListNode head) {

        if(head==null ||head.next==null ||head.next.next==null)
        {
            return ;
        }
        ListNode slow=head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }
        ListNode second=slow.next;
        slow.next=null;
        ListNode first=head;
        second =reverse(second);
        

        while(first!=null&& second!=null)
        {
            ListNode firstNext=first.next;
            ListNode secondNext=second.next;

            first.next=second;
            second.next=firstNext;

            first=firstNext;
            second=secondNext;

        }

        
    }

    private ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr = head;
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