function isIsomorphic(s: string, t: string): boolean {
  const [es, et] = [s, t].map(encode);

  return es.every((esi, index) => esi === et[index]);

    
  function encode(s:string): number[] {
    let i = 0;

    const encodedArray = new Array<number>(s.length);
    const charset = new Map<number, number>();  
    for (let index = 0; index < s.length; index++) {
      const charCode = s.charCodeAt(index);
      if(!charset.has(charCode)) {
        charset.set(charCode, i++);
      }
      encodedArray[index] = charset.get(charCode)!;
    }
    return encodedArray;
  }
};

isIsomorphic("foo", "bar")