// deno run --allow-read metrics.ts

// A script to count the solutions
import { format } from "https://deno.land/std@0.224.0/datetime/format.ts";

const targetPath = "src";

async function countFiles(dir: string): Promise<number> {
  let fileCount = 0;
  for await (const dirEntry of Deno.readDir(dir)) {
    if (dirEntry.isFile) {
      fileCount++;
    } else if (dirEntry.isDirectory) {
      await countFiles(`${dir}/${dirEntry.name}`);
    }
  }
  return fileCount;
}

type PathAndName = [string, string];

async function listFolders(dir: string): Promise<Array<PathAndName>> {
  const folderNames = [];

  for await (const dirEntry of Deno.readDir(dir)) {
    if (dirEntry.isDirectory) {
      const entry: PathAndName = [`${dir}/${dirEntry.name}`, dirEntry.name];
      folderNames.push(entry);
    }
  }

  return folderNames;
}

try {
  const folders = await listFolders(targetPath);
  const tasks = folders.map(folder => countFiles(folder[0]).then(num => [num, folder[1]] as [number, string]));
  const numOfEach = await Promise.all(tasks)

  const sum = numOfEach.reduce((a, b) => a + b[0], 0);

  console.log(`On this day: ${format(new Date(), "yyyy-MM-dd")}, the total num of solutions: ${sum}, in which:`)

  numOfEach.sort((a, b) => a[1].localeCompare(b[1])).forEach(topic => {
    console.log(`- ${topic[1]}: ${topic[0]}.`)
  })

} catch (error) {
  console.error("Error reading directory:", error);
}