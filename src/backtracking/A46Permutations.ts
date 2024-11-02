function permute(nums: number[]): number[][] {
  const solution: number[][] = []
  const len = nums.length;
  const used: { [key: number]: boolean } = [];
  bt([]);

  return solution;

  function bt(path: number[]): void {
    if (path.length === len) {
      solution.push(Array.from(path))
      return;
    }

    nums.forEach(num => {
      if (!used[num]) {
        used[num] = true;
        path.push(num);
        bt(path);
        path.pop();
        used[num] = false;
      }
    })

  }
};
