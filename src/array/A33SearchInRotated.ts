function search(nums: number[], target: number): number {

  return bsearch(0, nums.length - 1);

  function bsearch(left: number, right: number): number {
    if (left > right) return -1;
    else if (left === right) return nums[left] == target ? left : -1;

    const mid = Math.floor((left + right) / 2);

    if(right - left === 1) {
      if(nums[left] == target) return left 
      if(nums[right] == target) return right 
      return -1;
    } 

    if (nums[mid] === target) return mid;
    if (nums[mid] > nums[left]) {
      // left half is sorted
      if (target < nums[left] || target > nums[mid]) {
        return bsearch(mid + 1, right);
      } else {
        return bsearch(left, mid - 1);
      }
    } else {
      // right half is sorted
      if (target > nums[right] || target < nums[mid]) {
        return bsearch(left, mid - 1);
      } else {
        return bsearch(mid + 1, right);
      }
    }
  }
};
