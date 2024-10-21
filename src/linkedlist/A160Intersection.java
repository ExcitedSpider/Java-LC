package linkedlist;

public class A160Intersection {
  static int length(ListNode head) {
    var l = 0;
    while (head!=null) {
      head =head.next;
      l ++;
    }
    return l;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // The property of A and B:
    // the ends in the same nodes
    var lenA = length(headA);
    var lenB = length(headB);

    ListNode longerList = lenA > lenB? headA : headB;
    ListNode shorterList = longerList == headA ? headB: headA;
    var diff = Math.abs(lenA - lenB);
    while(diff != 0) {
      longerList = longerList.next;
      diff --;
    }

    var ptrA = longerList;
    var ptrB = shorterList;

    while (ptrA != ptrB) {
      ptrA = ptrA.next;
      ptrB = ptrB.next;
    }
    return ptrA;
  }
}
