function longestConsecutive(nums: number[]): number {
  const valueSet: Set<number> = new Set();

  nums.forEach(num => valueSet.add(num));

  let maxLc = 0;
  if (valueSet.size > 0) {
    valueSet.forEach(num => {
      if (valueSet.has(num)) {
        let lb = num - 1, ub = num + 1, lc = 1;
        valueSet.delete(num);
        while (valueSet.has(lb)) {
          lc++;
          valueSet.delete(lb);
          lb--;
        }
        while (valueSet.has(ub)) {
          lc++;
          valueSet.delete(ub);
          ub++;
        }
        maxLc = Math.max(lc, maxLc);
      }
    })
  }

  return maxLc;
};