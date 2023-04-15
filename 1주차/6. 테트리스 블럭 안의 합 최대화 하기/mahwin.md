1. 풀이

모든 블럭이 4개의 요소로 구성된 점을 이용해 백트래킹으로 블럭의 모양을 구한다. 좌표를 기준으로 dfs를 수행시 놓치는 부분이 있기 때문에 지나온 경로를 기준으로 4방향을 다 검색한다.

```js
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
let v; // 방문 체크
let n, m;
let max = -Infinity; // 합의 최대 저장

const dirs = [
  // 네 방향으로 서치
  [0, 1],
  [1, 0],
  [-1, 0],
  [0, -1],
];

rl.on("line", function (line) {
  input.push(line.trim().split(" ").map(Number));
}).on("close", function () {
  solution();
  process.exit();
});

// 경계 확인
const isValid = (r, c) => {
  if (r < 0 || c < 0 || r >= n || c >= m) return false;
  return true;
};

// 테트리스 블럭 모양 찾기.
const searchBlock = (roots, cnt, acc) => {
  if (cnt === 4) {
    max = Math.max(max, acc);
    return;
  }

  for (const root of roots) {
    for (const d of dirs) {
      const nr = root[0] + d[0];
      const nc = root[1] + d[1];
      if (isValid(nr, nc) && !v[nr][nc]) {
        v[nr][nc] = true;
        searchBlock([...roots, [nr, nc]], cnt + 1, acc + input[nr][nc]);
        v[nr][nc] = false;
      }
    }
  }
};

const solution = () => {
  [n, m] = input.shift();
  v = Array.from({ length: n }, () => Array.from({ length: m }, () => false));

  for (let r = 0; r < n; r++) {
    for (let c = 0; c < m; c++) {
      console.log(r, c, v);
      v[r][c] = true;
      searchBlock([[r, c]], 1, input[r][c]); // 이동 경로,이동 횟수, 숫자합
    }
  }
  console.log(max);
};
```

실행 시간 : 1185ms  
사용 공간 : 18MB
풀이 시간 : 20분

#### 새롭게 알게된 점

#### 어려웠던 점
