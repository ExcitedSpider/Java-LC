function minPathSum(grid: number[][]): number {

  const m = grid.length;
  const n = grid[0].length;
  const memo: number[][] = Array.from({ length: m }, () => new Array(n).fill(-1));

  return search(m - 1, n - 1);

  // the cost to (m, n)
  function search(m: number, n: number): number {
    if (m === 0 && n === 0) return grid[0][0];
    if (memo[m][n] !== -1) return memo[m][n];
    
    const res = grid[m][n] + Math.min(
      m === 0 ? Number.MAX_SAFE_INTEGER : search(m - 1, n),
      n === 0 ? Number.MAX_SAFE_INTEGER : search(m, n - 1),
    )
    memo[m][n] = res;
    return res;
  }
};
