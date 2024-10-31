function pivotIndex(nums: number[]): number {
    const sum = nums.reduce((a,b) => a + b, 0);
    
    let acc = 0;
    for (let index = 0; index < nums.length; index++) {
      if(acc === sum - acc - nums[index]) return index;

      acc += nums[index];
    }
    return -1;
};

pivotIndex([1, 7, 3, 6, 5, 6])