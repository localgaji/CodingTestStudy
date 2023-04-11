1.input 요소 split으로 확장자 명 갖고 와서 cntObj에 카운팅. 2.확장자 명만 모아서 sort
3.sort된 확장자 명을 다시 cntObj에 넣은 후 print

```js
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
const fileObj = {}; // 확장자 수 카운팅
let keys = []; // 확장자 이름 사전순 정렬

rl.on("line", function (line) {
  input.push(line.trim());
}).on("close", function () {
  solution();
  process.exit();
});

const solution = () => {
  const n = Number(input[0]);
  for (let i = 1; i <= n; i++) {
    const ex = input[i].split(".")[1];
    fileObj[ex] = fileObj[ex] ? fileObj[ex] + 1 : 1;
  }

  keys = Object.keys(fileObj).sort();
  printFile();
};

const printFile = () => {
  let result = "";
  for (const key of keys) {
    result += [key, fileObj[key]].join(" ") + "\n";
  }
  console.log(result.trim()); //마지막 \n 제외
};
```

실행 시간 : 508ms
사용 공간 : 67932KB
풀이 시간 : 2분

새롭게 알게된 점 none

어려웠던 점 none
