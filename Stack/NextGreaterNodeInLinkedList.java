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

// 1019. Next Greater Node In Linked List
// DECREASING MONOTONIC STACK
class Solution {
    public int[] nextLargerNodes(ListNode head) {
      /*
        ArrayList<Integer> values= new ArrayList<>();
        while(head!=null)
        {
            values.add(head.val);
            head=head.next;
        }

       
        int n=values.size();
        int[] ans= new int[n];
        Stack<Integer> smaller= new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            while(!(smaller.isEmpty())&&(values.get(smaller.peek())<values.get(i)))
            {
                ans[smaller.pop()]= values.get(i);
            }
            smaller.push(i);
        }
      return ans;  
      */


    //   in this istead of traversing the linked list and storing it into arraylist, we will use a pointer and in stack w will store the pair of value and index

     Stack<int[]> smaller= new Stack<>();
     ArrayList<Integer> ans= new ArrayList<>();
      int i=0;
      while(head!=null)
      {
        ans.add(0);
        while((!smaller.isEmpty())&& smaller.peek()[0]<head.val)
        {
            int []a = smaller.pop();
            ans.set(a[1],head.val);
        }

        smaller.push(new int[]{head.val,i});
        head= head.next;
        i++;
      }

      int n= ans.size();
      int[] res= new int[n];
      
      for(int j=0;j<n;j++)
      {
        res[j]= ans.get(j);
      }
      return res;
    }
}