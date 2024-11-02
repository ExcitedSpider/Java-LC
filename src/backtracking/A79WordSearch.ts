const directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

function exist(board: string[][], word: string): boolean {

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      if (board[i][j] === word[0] && search([i, j], 0)) {
        return true;
      }
    }
  }
  return false;

  function search([i, j]: [number, number], cur: number): boolean {
    if (board[i][j] !== word[cur]) return false;
    if (cur === word.length - 1) return true;
    const temp =  board[i][j];
    board[i][j] = '#';

    const ret = directions.some(([di, dj]) => {
      const newPos: [number, number] = [i + di, j + dj];
      if (isWF(newPos) && search(newPos, cur + 1)) {
        return true;
      }
    })

    board[i][j] = temp;
    return ret;
  }

  function isWF([i, j]: [number, number]) {
    return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
  }
};


const ret = exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], "ABCB")
console.log(ret)

