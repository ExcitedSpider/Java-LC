function generate(numRows: number): number[][] {
  const triangle: number[][] = [];

  // construct the triangle
  for(let i = 0; i < numRows; i++) {
    const row: number[] = new Array(i + 1);
    for(let j = 0; j <= i; j++) {
      row[j] = λ(i, j);
    }
    triangle.push(row)
  }

  return triangle;
  
  // λ row col := the value in cell triangle[row][col] 
  function λ(row: number, col: number): number {
    if(col === 0 || col === row) {
      return 1;
    }
    if(triangle[row]?.[col] !== undefined) {
      return triangle[row]?.[col];
    }
    return λ(row - 1, col - 1) + λ(row - 1, col) 
  }
};