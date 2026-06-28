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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Ek dummy head node banate hain jo result list ka start point track karega
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        
        // Jab tak dono me se kisi ek list me nodes hain ya fir carry bacha hai, loop chalega
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Total sum nikalte hain (current digits + purana carry)
            int sum = carry + x + y;
            
            // Naya carry nikalte hain
            carry = sum / 10;
            
            // Sum ka last digit naye node me store karte hain
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            // Pointers ko aage badhate hain agar list bachi hai to
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // Dummy head ke agla node actual result ka head hoga
        return dummyHead.next;
    }
}