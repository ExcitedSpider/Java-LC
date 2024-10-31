export function longestPalindromeSubseq(s: string): number {
  const n = s.length;

  const memo: number[][] = new Array(n);
  for(let i = 0; i< n; i++) {
    memo[i] = new Array<number>(n);
    memo[i].fill(-1);
  }


  return lpss(s, 0, s.length - 1);
  
  function lpss(s: string, start: number, end: number): number {

      if(start > end) return 0;
      if(start === end) return 1;
      if(memo[start][end] !== -1) {

        return memo[start][end]
      };
      if(s[start] === s[end]) return 2 + lpss(s, start + 1, end - 1);
      
      const res = Math.max(
          lpss(s, start + 1, end),
          lpss(s, start, end - 1)
      )
      memo[start][end] = res;

      return res;
  } 
}

const res = longestPalindromeSubseq("cbacbd")
console.log(res)