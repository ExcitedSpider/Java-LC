function subarraySum(nums: number[], k: number): number {
  return search(0,0,0,{ 0: 1 });


  // search => return the num of subarrays that match k
  // invariant:
  // - prefixSum[i] := in [0, pos), the number of prefix that sums to i  
  // - preSum := sum of [0, pos)
  // - matches := #(subarrays that sum to k in [0, pos))  
  function search(pos: number, preSum: number, counter: number, prefixSum: { [sum: number]: number }) {
    if (pos === nums.length) return counter;

    const currentSum = preSum + nums[pos];
    const newCounter = counter +  (prefixSum[currentSum - k] ?? 0);
    prefixSum[currentSum] =  (prefixSum[currentSum] ?? 0) + 1;

    return search(
      pos + 1,
      currentSum,
      newCounter,
      prefixSum
    )
  }
};

console.log(subarraySum([1], 0))
console.log(subarraySumIt([1], 0))


function subarraySumIt(nums: number[], k: number): number {
  let matches = 0, sum = 0;
  const prefixSumCount: { [key: number]: number }  = {0: 1};
  
  for(const num of nums) {
    sum += num;
    matches += prefixSumCount[sum - k] ?? 0;
    prefixSumCount[sum] = (prefixSumCount[sum] || 0) + 1;
  }

  return matches;
};