function maxProfit(prices: number[]): number {
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