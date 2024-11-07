function sortColors(nums: number[]): void {
  const freqDict: { [color: number]: number } = {}
  nums.forEach(num => {
    freqDict[num] = typeof freqDict[num] === 'number' ? freqDict[num] + 1 : 1
  })

  let index = 0;
  for (let color = 0; color < 3; color++) {
    for (let i = 0; i < freqDict[color]; i++) {
      nums[index] = color;
      index++;
    }
  }
};