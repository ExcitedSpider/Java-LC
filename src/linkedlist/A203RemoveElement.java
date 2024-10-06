package linkedlist;

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}

public class A203RemoveElement {
  /* efficient but ugly */
  public static ListNode removeElements0(ListNode head, int val) {
    var nhead = new ListNode();
    nhead.next = head;
    var ptr = nhead; 

    while(ptr.next != null) {
      if(ptr.next.val == val) {
        ptr.next = ptr.next.next;
      } else {
        ptr = ptr.next;
      }
    }

    return nhead.next;
  }

  /* very elegant functional style */
  public static ListNode removeElements(ListNode head, int val) {
    if(head == null) {
      return null;
    }else if(head.val == val) {
      return removeElements(head.next, val);
    } else {
      head.next = removeElements(head.next, val);
      return head;
    }
  }

  public static void main(String[] args) {
    var list = new ListNode(7, 
      new ListNode(7,
      new ListNode(7, null))
    );

    var res = removeElements(list, 7);
    System.err.println(res);
  }
}
