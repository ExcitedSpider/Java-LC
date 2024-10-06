package linkedlist;

class ListNode {
  public ListNode next;
  public int val;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode getNode(int index, ListNode head) {
    if(head == null) {
      return null;
    } else if(index == 0) {
      return head;
    } else {
      return getNode(index - 1, head.next);
    }
  }

  public static String toString(ListNode head) {
    StringBuilder builder = new StringBuilder(); 
    while (head != null) {
      builder.append(String.format("%d, ", head.val));
      head = head.next;
    }

    return builder.toString();
  }
}

class MyLinkedList {
  private ListNode head;

  public MyLinkedList() {
    head = null;
  }

  public int get(int index) {
    var node = ListNode.getNode(index, head);
    if(node == null) {
      return -1;
    }else{
      return node.val;
    }
  }

  public void addAtHead(int val) {
    var node = new ListNode();
    node.val = val;
    node.next = head;
    head = node;
  }

  public void addAtTail(int val) {
    if(this.head == null) {
      this.head = new ListNode(val);
    } else {
      var ptr = head;
      while(ptr.next != null) {
        ptr = ptr.next;
      }
      ptr.next = new ListNode(val);
    }
  }

  public void addAtIndex(int index, int val) {
    if(index == 0) {
      addAtHead(val);
      return;
    }

    var node = ListNode.getNode(index - 1, head);
    if(node == null) {
      return;
    }
    var next = node.next;
    node.next = new ListNode(val, next);
  }

  public void deleteAtIndex(int index) {
    if(this.head == null) {
      return;
    }
    if(index == 0) {
      head = head.next;
      return;
    }

    var node = ListNode.getNode(index - 1, head);
    if(node == null || node.next == null) {
      return;
    }
    node.next = node.next.next;
  }
}

public class A707DesginLinkedList {
  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList();
    myLinkedList.addAtHead(1);
    myLinkedList.addAtTail(3);
    myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
    myLinkedList.get(1);              // return 2
    myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
    myLinkedList.get(1);              // return 3
    System.err.println(myLinkedList.toString());
  }
}