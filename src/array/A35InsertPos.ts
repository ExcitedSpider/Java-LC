function searchInsert(nums: number[], target: number): number {

  return bsearch(0, nums.length - 1);

  function bsearch(left: number, right: number): number {
    if (left > right) return left; // only happened when left - right == 1 due to integer arith
    if (left === right) {
      if (nums[left] < target) return left + 1;
      else return left;
    };

    const mid = left + Math.floor((right - left) / 2);
    if (nums[mid] === target) return mid;
    if (nums[mid] > target) return bsearch(left, mid - 1);
    else return bsearch(mid + 1, right);
  }
};