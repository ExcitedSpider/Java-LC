function quicksort(arr: number[]): number[] {
  if (arr.length <= 1) return arr;
  const pivot = arr[0];
  const smalls = []
  const larges = []

  for (const item of arr.slice(1)) {
    if (pivot <= item) larges.push(item)
    else smalls.push(item)
  }

  return quicksort(smalls).concat([pivot]).concat(quicksort(larges))

}

console.log(quicksort([4, 1, 3, 7, 9, 5]))