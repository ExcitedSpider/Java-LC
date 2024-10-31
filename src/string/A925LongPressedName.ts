// pre => 1 <= name.length, typed.length <= 1000 
function isLongPressedName(name: string, typed: string): boolean {
  return compareAt(0, 0);

  function compareAt(nptr: number, tptr: number): boolean {
    // end cases
    if (tptr === typed.length && nptr !== name.length) return false;
    else if (nptr === name.length) {
      while (tptr !== typed.length) {
        if (typed[tptr] !== typed[tptr - 1]) return false;
        tptr++;
      }
      return true;
    }

    // loop cases
    else if (name[nptr] === typed[tptr]) return compareAt(nptr + 1, tptr + 1);
    else {
      while (typed[tptr] === typed[tptr - 1]) tptr++;
      if (name[nptr] === typed[tptr]) return compareAt(nptr + 1, tptr + 1);
      else return false
    }
  }
};


isLongPressedName("alex", "aaleexa")