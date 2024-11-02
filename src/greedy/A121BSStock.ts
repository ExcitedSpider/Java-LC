// readable but not optimized
function maxProfit_d(prices: number[]): number {
  if (prices.length <= 1) return 0;
  return Math.max(0, searchProfit(prices[0], 1));

  function searchProfit(buyPrice: number, currentDate: number): number {
    if (currentDate === prices.length - 1) return prices[currentDate] - buyPrice;

    return Math.max(
      prices[currentDate] - buyPrice,
      searchProfit(Math.min(prices[currentDate], buyPrice), currentDate + 1),
    )
  }
};

function maxProfit(prices: number[]): number {
  if (prices.length <= 1) return 0;
  let buyPrice = prices[0];
  let profit = 0;

  for (let index = 1; index < prices.length; index++) {
    profit = Math.max(prices[index] - buyPrice, profit);
    buyPrice = Math.min(prices[index], buyPrice);
  }

  return profit;
};