function findAnagrams(s: string, p: string): number[] {
  const pFreq: Map<string, number> = new Map();
  
  for (let i = 0; i < p.length; i++) {
    pFreq.set(p.charAt(i), (pFreq.get(p.charAt(i)) ?? 0) + 1)
  }

  const windowFreq: Map<string, number> = new Map();
  const windowSize = p.length;
  s.slice(0, windowSize).split("").forEach(c => {
    windowFreq.set(c, (windowFreq.get(c) ?? 0) + 1)
  })

  const ans: number[] = []

  const adjustWindowFreq = adjustFreq.bind(null, windowFreq);

  for (let i = 0; i < s.length - windowSize + 1; i++) {
    if (isFreqMatch(pFreq, windowFreq)) {
      ans.push(i);
    }
    adjustWindowFreq(s.charAt(i), false);
    adjustWindowFreq(s.charAt(i + windowSize), true);
    console.log(windowFreq);
  }

  return ans;

  // returns true if two frequency maps are equal
  function isFreqMatch(a: Map<string, number>, b: Map<string, number>) {
    return a.size == b.size && Array.from(a.entries()).every(([k, v]) => b.get(k) === v)
  }

  // adjust the frequency relation by adding or delete a char
  function adjustFreq(freqRel: Map<string, number>, char: string, increment: boolean) {
    const newFreq = (freqRel.get(char) ?? 0) + (increment ? 1 : -1);
    if (newFreq === 0) {
      freqRel.delete(char);
    } else {
      freqRel.set(char, newFreq);
    }
  }
};

findAnagrams("cbaebabacd", "abc")