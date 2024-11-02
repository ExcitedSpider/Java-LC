// so declarative that do not needs brain
function maxProfit_declarative(prices: number[]): number {
  if (prices.length <= 1) return 0;
  return scanProfit(false, 0, 0);


  function scanProfit(hold: boolean, buyPrice: number, date: number): number {
    if (date === prices.length) return 0;
    if (hold) {
      return Math.max(
        // sell today
        prices[date] + scanProfit(false, 0, date + 1),
        // keep hold
        scanProfit(true, buyPrice, date + 1)
      )
    } else {
      return Math.max(
        // buy today
        - prices[date] + scanProfit(true, prices[date], date + 1),
        // keep unhold
        scanProfit(false, 0, date + 1)
      )
    }
  }
};

function maxProfit_greedy(prices: number[]): number {
  if (prices.length <= 1) return 0;
  return Math.max(0, scanProfit(false, 0, 0));


  function scanProfit(hold: boolean, buyPrice: number, date: number): number {
    if (date === prices.length) return 0;
    if (hold) {
      if (date < prices.length - 1 && prices[date] < prices[date + 1]) {
        return scanProfit(true, buyPrice, date + 1)
      } else {
        return prices[date] + scanProfit(false, 0, date + 1);
      }
    } else {
      if (date === prices.length - 1) {
        return 0;
      } else if (date < prices.length - 1 && prices[date] > prices[date + 1]) {
        return scanProfit(false, 0, date + 1)
      } else {
        return - prices[date] + scanProfit(true, prices[date], date + 1);
      }
    }
  }
};

function maxProfit_iterative(prices: number[]): number {
  if (prices.length <= 1) return 0;

  let hold = false;
  let profit = 0;
  for (let date = 0; date < prices.length; date++) {
    if(date === prices.length) return 0;
    if (hold) {
      if (date < prices.length - 1 && prices[date] < prices[date + 1]) {
        continue;
      } else {
        profit += prices[date];
        hold = false;
      }
    } else {
      if (date === prices.length - 1) {
        continue;
      } else if (date < prices.length - 1 && prices[date] > prices[date + 1]) {
        continue;
      } else {
        profit -= prices[date];
        hold = true;
      }
    }
  }

  return profit;
};

function maxProfit(prices: number[]): number {
  return maxProfit_iterative(prices);
}


maxProfit([7, 1, 5, 3, 6, 4]);