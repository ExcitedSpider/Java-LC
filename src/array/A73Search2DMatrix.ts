function searchMatrix(matrix: number[][], target: number): boolean {
  const m = matrix.length;
  const n = matrix[0].length;
  const row = bsearchRow(0, m - 1);
  return bsearch(matrix[row], 0, n - 1) === -1;

  function bsearchRow(left: number, right: number): number {
    if (left >= right) return left;
    const mid = left + Math.floor((right - left) / 2);

    if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) return mid;
    else if (matrix[mid][0] > target) return bsearchRow(left, mid - 1);
    else return bsearchRow(mid + 1, right);
  }

  function bsearch(row: number[], left: number, right: number): number {
    if (left > right) return -1;
    if (left === right) return row[left] === target ? left : -1;

    const mid = left + Math.floor((right - left) / 2);
    if (row[mid] === target) return mid;
    else if (target < row[mid]) return bsearch(row, left, mid - 1);
    return bsearch(row, mid + 1, right);
  }
};

searchMatrix([[1, 3]], 3)