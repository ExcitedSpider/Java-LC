package linkedlist;

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
