// 90 / 102 testcases passed
// the problem is in merge
// where it decides what should be done when two elements are equal
// it only compares the next element
// while it should compares until the end
function maxNumber(nums1: number[], nums2: number[], k: number): number[] {
  // large list
  const llist = nums1.length > nums2.length ? nums1 : nums2;
  // small list
  const slist = llist == nums1 ? nums2 : nums1;

  let largestSeq: number[] = []
  for (let i = Math.max(0, k - llist.length); i <= Math.min(k, slist.length); i++) {
    const al = createLargeSequence(slist, i);
    const bl = createLargeSequence(llist, k - i);
    const merged = merge(al, bl);
    if (largestSeq.length === 0 || lge(merged, largestSeq)) {
      largestSeq = merged;
    }
  }
  return largestSeq;
};

// pre => seq1.length == seq2.length
function lge(seq1: number[], seq2: number[]): boolean {
  if (seq1.length !== seq2.length) throw new Error("Cannot Compare: Length is not equal." + seq1 + seq2);

  let pos = 0;
  while (pos < seq1.length) {
    if (seq1[pos] > seq2[pos]) {
      return true;
    } else if (seq1[pos] < seq2[pos]) {
      return false;
    }
    pos++;
  }

  return true;

}

function merge(seq1: number[], seq2: number[]): number[] {
  let ptr1 = 0;
  let ptr2 = 0;
  const res = [];

  while (ptr1 !== seq1.length && ptr2 !== seq2.length) {
    if (seq1[ptr1] > seq2[ptr2]) {
      res.push(seq1[ptr1])
      ptr1++;
    } else if (seq1[ptr1] == seq2[ptr2]) {
      if (next(seq1, ptr1) > next(seq2, ptr2)) {
        res.push(seq1[ptr1])
        ptr1++;
      } else {
        res.push(seq2[ptr2])
        ptr2++;
      }
    } else {
      res.push(seq2[ptr2])
      ptr2++;
    }
  }

  while (ptr1 !== seq1.length) {
    res.push(seq1[ptr1]);
    ptr1++;
  }
  while (ptr2 !== seq2.length) {
    res.push(seq2[ptr2]);
    ptr2++;
  }

  return res;

  function next(seq1: number[], ptr1: number): number {
    if (ptr1 < seq1.length - 1) {
      return seq1[ptr1 + 1];
    }
    return -1;
  }
}

// find the largest subsequence by k 
// pre => k <= nums.length
function createLargeSequence(nums: number[], k: number) {
  if (k > nums.length) throw new Error('K is larger than size of nums')

  let dropCap = nums.length - k;
  const seq = [];

  for (let i = 0; i < nums.length; i++) {
    while (dropCap > 0 && nums[i] > seq[seq.length - 1]) {
      seq.pop();
      dropCap--;
    }

    seq.push(nums[i]);
  }

  return seq.slice(0, k);
}

console.log(
  maxNumber(
    [2, 5, 6, 4, 4, 0],
    [7, 3, 8, 0, 6, 5, 7, 6, 2],
    15
  )
)

