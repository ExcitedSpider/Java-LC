package linkedlist;

/*
 * Lemma 1: 
 * forall x y,
 * two pointers which the first walks 2 steps at a time 
 * and the second walks 1 step at a time ->
 * x is the length from start to the entry of circle  -> 
 * (x + y) is the length from start to the meeting point ->
 * exists n z, x + y = n(y + z)
 * Proof: 
 * Let (z + y) be the length of circle.
 * since fast ptr moves twice faster than slowPtr and they meet in the circle, it must has:
 * (x + y)*2 = x + y + n*(x + y).  <- eq
 * where x + y is the distance that slowPtr have walked, and 
 * x + y + n*(x + y) is the distance that the fast ptr walks
 * Simplify eq, we have x + y = n(y + z)
 * 
 */

public class A142CircularList {
  public ListNode detectCycle(ListNode head) {
    var fastPtr = head;
    var slowPtr = head;

    while (fastPtr != null && fastPtr.next != null && slowPtr != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;

      if (fastPtr == slowPtr) {
        return findEntry(head, fastPtr);
      }
    }

    return null;
  }

  private ListNode findEntry(ListNode head, ListNode fastPtr) {
    while (head != fastPtr) {
      return findEntry(head.next, fastPtr.next);
    }
    return head;
  }
}
