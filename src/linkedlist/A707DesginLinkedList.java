package linkedlist;

class MyListNode {
  public MyListNode next;
  public int val;

  public MyListNode() {
  }

  public MyListNode(int val) {
    this.val = val;
  }

  public MyListNode(int val, MyListNode next) {
    this.val = val;
    this.next = next;
  }

  public static MyListNode getNode(int index, MyListNode head) {
    if(head == null) {
      return null;
    } else if(index == 0) {
      return head;
    } else {
      return getNode(index - 1, head.next);
    }
  }

  public static String toString(MyListNode head) {
    StringBuilder builder = new StringBuilder(); 
    while (head != null) {
      builder.append(String.format("%d, ", head.val));
      head = head.next;
    }

    return builder.toString();
  }
}

class MyLinkedList {
  private MyListNode head;

  public MyLinkedList() {
    head = null;
  }

  public int get(int index) {
    var node = MyListNode.getNode(index, head);
    if(node == null) {
      return -1;
    }else{
      return node.val;
    }
  }

  public void addAtHead(int val) {
    var node = new MyListNode();
    node.val = val;
    node.next = head;
    head = node;
  }

  public void addAtTail(int val) {
    if(this.head == null) {
      this.head = new MyListNode(val);
    } else {
      var ptr = head;
      while(ptr.next != null) {
        ptr = ptr.next;
      }
      ptr.next = new MyListNode(val);
    }
  }

  public void addAtIndex(int index, int val) {
    if(index == 0) {
      addAtHead(val);
      return;
    }

    var node = MyListNode.getNode(index - 1, head);
    if(node == null) {
      return;
    }
    var next = node.next;
    node.next = new MyListNode(val, next);
  }

  public void deleteAtIndex(int index) {
    if(this.head == null) {
      return;
    }
    if(index == 0) {
      head = head.next;
      return;
    }

    var node = MyListNode.getNode(index - 1, head);
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