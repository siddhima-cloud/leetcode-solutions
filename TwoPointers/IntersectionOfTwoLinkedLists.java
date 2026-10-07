// 160. Intersection of Two Linked Lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int m = numberOfNodes(headA);
        int n=numberOfNodes(headB);
        if(m>n)
        {
            ListNode a=skippedNode(headA,m-n);
            return getNode(a,headB);
        }
        
        
            
            ListNode b=skippedNode(headB,n-m);
             return getNode(headA, b);
        
        
    }
    static ListNode getNode(ListNode node1,ListNode node2)
    {
        int ans=0;
        while(node1!=null && node2!=null)
        {
            if(node1==node2)
            {
                return node1;
            }
            node1= node1.next;
            node2= node2.next;
        }
        return null;

    }
    static int numberOfNodes(ListNode start)
    {
        ListNode temp = start;
        int n=0;
        while(temp!=null)
        {
            n++;
            temp= temp.next;
        }
        return n;
    }

    static ListNode skippedNode(ListNode start,int i)
    {
        ListNode temp = start;
        while(i-->0){
            temp=temp.next;
        }
        return temp;
    }
}