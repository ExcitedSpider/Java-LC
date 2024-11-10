function minDistance(word1: string, word2: string): number {
  const m = word1.length;
  const n = word2.length;
  const memo: number[][] = Array.from({ length: m }, _ => new Array(n).fill(-1));
  return λ(m - 1, n - 1);

  // the min distance of word1[0..i] to word[0...j] 
  function λ(i: number, j: number): number {
    // console.log("λ", i, j)
    if(i < 0) return Math.max(0, j);
    if(j < 0) return i + 1;
      
    if (memo[i][j] !== -1) return memo[i][j];

    let result = Number.MAX_SAFE_INTEGER;
    if (word1.charAt(i) === word2.charAt(j)) {
      result = λ(i - 1, j - 1); // greedy
    } else {
      result = Math.min(
        λ(i - 1, j - 1) + 1, // modify
        λ(i, j - 1) + 1, // insert 
        λ(i - 1, j) + 1 // delete
      )
    }
    memo[i][j] = result;
    return result;
  }
};

// console.log(minDistance("h", "r"))
// console.log(minDistance("ho", "ro"))
// console.log(minDistance("hor", "ro"))
// console.log(minDistance("s", ""))
// console.log(minDistance("se", "e"))
// console.log(minDistance("sea", "ea"))
// console.log(minDistance("sea", "eat"))
// console.log(minDistance("sea", "eat"))
console.log(minDistance("horse", "ros"))