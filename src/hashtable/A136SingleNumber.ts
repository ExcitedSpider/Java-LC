function singleNumber(nums: number[]): number {
    const occurrence: Set<number> = new Set();
    nums.forEach(num => {
      if(!occurrence.has(num)) {
        occurrence.add(num);
      }else {
        occurrence.delete(num);
      }
    })

    return Array.from(occurrence.keys())[0]
};

singleNumber([2,2,1])