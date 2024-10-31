function searchRange(nums: number[], target: number): number[] {
  return searchBound(nums, 0, nums.length - 1, target);
};

function searchBound(nums: number[], left: number, right: number, target: number): [number, number] {
  if (left > right) return [-1, -1];

  const mid = Math.floor((left + right) / 2);
  if (nums[mid] === target) {
    let lb = mid;
    while (nums[lb - 1] == target) {
      lb -= 1;
    }
    let rb = mid;
    while (nums[rb + 1] == target) {
      rb += 1;
    }
    return [lb, rb];
  }
  else if (nums[mid] > target) return searchBound(nums, left, mid - 1, target);
  else return searchBound(nums, mid + 1, right, target);
}

