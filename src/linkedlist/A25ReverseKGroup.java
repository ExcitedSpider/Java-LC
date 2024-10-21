package linkedlist;

import java.util.Stack;

public class A25ReverseKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    // filter junk input
    if(k == 1) return head;

    var oldHead = head;
    var newHead = reverseK(oldHead, k);
    var ret = newHead;
    while (newHead != oldHead) {
      var endOFLastSeg = oldHead;
      oldHead = oldHead . next;
      // this is important, updating the end of last segment
      // to point to the reverted new head
      endOFLastSeg.next = reverseK(oldHead, k);
      newHead = endOFLastSeg.next;
    }
    return ret;
  }

  /**
   * reverse first k nodes, return its new head
   */
  private ListNode reverseK(ListNode head, int k) {
    Stack<ListNode> nodes = new Stack<>();
    var ptr = head;
    while (k > 0 && ptr != null) {
      nodes.push(ptr);
      ptr = ptr.next;
      k--;
    }
    if (k > 0) {
      return head; // can't fill in all
    }
    var nextToEnd = ptr;
    var newHead = nodes.pop();
    var pre = newHead;
    ListNode cur = null;
    while (nodes.size() != 0) {
      cur = nodes.pop();
      pre.next = cur;
      pre = cur;
    }

    cur.next = nextToEnd;
    return newHead;
  }

  static A25ReverseKGroup ins = new A25ReverseKGroup();

  public static void main(String[] args) {
    var lists = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    var head = ins.reverseKGroup(lists, 2);
    while (head != null) {
      System.err.println(head.val);
      head = head.next;
    }
  }
}
