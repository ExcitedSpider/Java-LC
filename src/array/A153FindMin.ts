function findMin(nums: number[]): number {
  return nums[search(0, nums.length - 1)];
    
  // search in [left, right]
  function search(left: number, right: number): number {
    if(left >= right) return left;
    const mid = left + Math.floor((right - left) / 2);
    if(nums[left] < nums[mid] && nums[right] > nums[mid]) {
      return left;
    }
    if(nums[mid] < nums[right]) {
      return search(left, mid);
    }else {
      return search(mid + 1, right);
    }
  }
};