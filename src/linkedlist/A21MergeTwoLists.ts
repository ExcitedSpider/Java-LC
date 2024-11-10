import { ListNode } from "./ListNode.ts";

function mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode | null {
  let p1 = list1;
  let p2 = list2;

  const newList = new ListNode();
  let pn = newList;
  while (!!p1 && !!p2) {
    if (p1.val <= p2.val) {
      pn.next = p1;
      pn = p1;
      p1 = p1.next;
    } else {
      pn.next = p2;
      pn = p2;
      p2 = p2.next;
    }
  }
  if(p1) {
     pn.next = p1; 
  }
  if(p2) {
    pn.next = p2;
  }

  return newList.next;
};