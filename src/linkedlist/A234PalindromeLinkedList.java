package linkedlist;

public class A234PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null)
      return true;
    var mid = splitLinkedList(head);
    mid = reverse(mid);

    while (mid != null) {
      if (head.val != mid.val)
        return false;
      mid = mid.next;
      head = head.next;
    }

    return true;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    return reverse(null, head);
  }

  private ListNode reverse(ListNode pre, ListNode cur) {
    if (cur == null)
      return pre;

    var next = cur.next;
    cur.next = pre;
    return reverse(cur, next);
  }

  // pre => head != null && head.next != null && isEven #(len)
  private ListNode splitLinkedList(ListNode head) {
    var slowPtr = head;
    var fastPtr = head;

    while (fastPtr.next != null) {
      fastPtr = fastPtr.next;
      if(fastPtr.next == null) break;
      fastPtr = fastPtr.next;
      slowPtr = slowPtr.next;
    }
    var headOfMid = slowPtr.next;
    slowPtr.next = null;
    return headOfMid;
  }

}
