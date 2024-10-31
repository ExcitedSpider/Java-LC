export function longestPalindrome(s: string): string {
  if (s.length <= 1) return s;

  let largest = [0, 0];
  for (let i = 0; i < s.length; i++) {
    let [left, right] = expandAt(i, i);
    if (s[i] == s[i + 1]) {
      const [leftEven, rightEven] = expandAt(i, i + 1);
      if (rightEven - leftEven > right - left) [left, right] = [leftEven, rightEven];
    }

    if (right - left > largest[1] - largest[0]) {
      largest = [left, right]
    };
  }

  return s.substring(largest[0], largest[1] + 1);

  // pre => isPalindrome s[left..right]
  function expandAt(left: number, right: number): [number, number] {
    if (left > 0 && right < s.length - 1 && s[left - 1] === s[right + 1]) return expandAt(left - 1, right + 1);
    return [left, right];
  };
}
