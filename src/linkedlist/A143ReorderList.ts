import { ListNode } from "./ListNode.ts";

function reorderList(head: ListNode | null): void {
    if(head == null) return ;
    let fastPtr = head;
    let slowPtr = head;

    while (fastPtr.next != null) {
        fastPtr = fastPtr.next;
        if(fastPtr.next == null) break;
        fastPtr = fastPtr.next;
        slowPtr = slowPtr.next!;
    }

    let midHead = slowPtr.next;
    midHead = reverse(midHead);
    slowPtr.next = null;

    merge(head, midHead);

    function merge(ls1:ListNode | null, ls2: ListNode | null): ListNode | null {
        if(!ls1 || !ls2) return null;
        const ls1n = ls1.next;
        const ls2n = ls2.next;

        const ls1succ = ls1.next;
        ls1.next = ls2;
        ls2.next = ls1succ;

        return merge(ls1n, ls2n)
    }
};

function reorderList10(head: ListNode | null): void {
    if(head == null) return ;
    const deque: ListNode[] = []
    let ptr: ListNode | null = head;
    while (ptr !== null) {
        deque.push(ptr);
        ptr = ptr.next;
    }

    const nhead = new ListNode();
    ptr = nhead;
    while (deque.length !== 0) {
        ptr!.next = deque.shift() ?? null;
        ptr = ptr!.next;
        if(deque.length === 0) break;
        ptr!.next = deque.pop() ?? null;
        ptr = ptr!.next;
    }

    ptr!.next = null
}

function reorderListTLE(head: ListNode | null): void {
    if(head == null) return;
    let cur: ListNode | null = head;
    let next = cur.next;

    while(next !== null && cur !== null) {
        cur.next = reverse(next)
        cur = cur.next;
        next = cur?.next ?? null;
    }    

};

function reverse(head: ListNode | null): ListNode | null {
    if (head == null) return null;

    return fixpointReverse(null, head);

    function fixpointReverse(pre: ListNode | null, cur: ListNode | null): ListNode | null {
        if(cur == null) return pre; 
        const next = cur.next;
        cur.next = pre;
        return fixpointReverse(cur, next);
    }    
}
