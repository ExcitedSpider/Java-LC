function generateParenthesis(n: number): string[] {

  const solution: string[] = [];
  bt(0, 0, '');
  return solution;
  // left: the number of left parentheses
  function bt(left: number, right: number, str: string): void {
    if (left === right && left === n) {
      solution.push(str);
      return;
    };
    if (left < n) bt(left + 1, right, str + '(')
    if (right < n && left > right) bt(left, right + 1, str + ')')
  }
};