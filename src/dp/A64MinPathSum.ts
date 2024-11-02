function minPathSum(grid: number[][]): number {

  const m = grid.length;
  const n = grid[0].length;
  const memo: number[][] = Array.from({ length: m }, () => new Array(n).fill(-1));

  return search(m - 1, n - 1) + grid[m-1][n-1];

  function search(m: number, n: number): number {
    if (m === 0 && n === 0) return 0;
    if (memo[m][n] !== -1) return memo[m][n];

    const res = Math.min(
      m === 0 ? Number.MAX_SAFE_INTEGER : search(m - 1, n) + grid[m - 1][n],
      n === 0 ? Number.MAX_SAFE_INTEGER : search(m, n - 1) + grid[m][n - 1],
    )
    memo[m][n] = res;
    return res;
  }
};

minPathSum([[1, 3, 1], [1, 5, 1], [4, 2, 1]])