function groupAnagrams(strs: string[]): string[][] {
    const dict: {[key:string]: string[]} = {}

    strs.map(str => {
      const key = str.split("").sort().join()
      dict[key] = [...dict[key] ?? [], str]
    })

    return Object.values(dict)
};