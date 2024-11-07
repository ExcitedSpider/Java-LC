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

    
  // a plain way to do it
  // for(let m = 0; m < M; m++) {
  //   for(let n = 0; n < N; n++) {
  //     if(!visited[m][n] && grid[m][n] ==='1') visit(m, n), islands++;
  //   }
  // }
  // 
  // return islands;

  // a fancy way to do this
  return grid.reduce((acc, row, m) => acc + unvisitedIslandsOfRow(row, m), 0)

  function unvisitedIslandsOfRow(row: string[], m: number) {
    return row.reduce(
      (acc, cell, n) => {
        if (!visited[m][n] && cell === '1') {
          visit(m, n);
          return acc + 1;
        }
        return acc;
      }, 0);
  }

  function visit(m: number, n: number) {
    if (m < 0 || m >= M || n < 0 || n >= N || grid[m][n] !== '1' || visited[m][n]) {
      return;
    }
    console.log("Visit", m, n)
    visited[m][n] = true;
    directions.forEach(([dm, dn]) => visit(m + dm, n + dn));
  }
};

numIslands(
  [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
)