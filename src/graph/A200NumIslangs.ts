const directions: [number, number][] = [
  [0, 1],
  [1, 0],
  [-1, 0],
  [0, -1],
]

function numIslands(grid: string[][]): number {
  const M = grid.length;
  const N = grid[0].length;

  const visited: boolean[][] =
    Array.from({ length: M }, _ => Array(N).fill(false));
  let islands = 0;

  for(let m = 0; m < M; m++) {
    for(let n = 0; n < N; n++) {
      if(!visited[m][n] && grid[m][n] ==='1') visit(m, n), islands++;
    }
  }

  return islands;

  function visit(m: number, n: number) {
    if (m < 0 || m >= M || n < 0 || n >= N || grid[m][n] !== '1' || visited[m][n]) {
      return;
    }
    visited[m][n] = true;
    directions.forEach(([dm, dn]) => visit(m + dm, n + dn));
  }
};