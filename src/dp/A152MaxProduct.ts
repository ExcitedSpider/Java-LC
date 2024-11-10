function maxProduct(nums: number[]): number {
  let maxProd = Number.MIN_SAFE_INTEGER;
  λ(nums.length - 1);
  return maxProd;

  // [maxProduct, minProduct] in nums ends with i
  function λ(i: number): [number, number] {
    if (i < 0) return [1, 1]; // 1 is the unit on the group
    
    const [preMax, preMin] = λ(i - 1);
    
    let curMax, curMin: number;
    if (nums[i] === 0) {
      [curMax, curMin] = [0, 0];
    };
    if (nums[i] > 0) {
      [curMax, curMin] = [
        Math.max(preMax * nums[i], nums[i]),
        Math.min(preMin * nums[i], nums[i])
      ]
    } else {
      [curMax, curMin] = [
        Math.max(preMin * nums[i], nums[i]),
        Math.min(preMax * nums[i], nums[i]),
      ]
    }

    maxProd = Math.max(curMax, maxProd);
    return [curMax, curMin];
  }
};

console.log(maxProduct([-2, 3, -2, 4]))