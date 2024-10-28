function wordBreak(s: string, wordDict: string[]): boolean {

  const memo = new Array<boolean>(s.length + 1);
  return canBreak(s.length, memo)

  // if [0, pos) can be break in wordDict
  function canBreak(pos: number, memo: boolean[]): boolean {
    if (pos <= 0) { return true }
    if (memo[pos] !== undefined) return memo[pos]

    for (const word of wordDict) {
      if (s.substring(0, pos).endsWith(word)) {
        if(canBreak(pos - word.length, memo)) {
          memo[pos] = true;
          return true;
        }
      }
    }

    memo[pos] = false;
    return false;
  }
};
