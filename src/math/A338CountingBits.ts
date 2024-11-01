function countBits(n: number): number[] {
  const res: number[] = [0, 1];
  if (n <= 1) {
    return res.slice(0, n + 1);
  }

  for (let val = 2; val < n; val++) {
    if (val % 2 === 0) res[val] = res[val / 2];
    else res[val] = res[val - 1] + 1
  }

  return res;

};
