```js
const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
let n; // 전체 수
let works; // 전체 일의 인덱스
let target; // 전체 수의 반
let result = Infinity;
const selectSet = new Set(); // 계산 했던 일의 집합 저장해서 반복 줄이기. key = '0,1,2,3'
let v = [];
const permutation = []; //2개씩 뽑는 순열 저장.
rl.on("line", (line) => {
  input.push(line);
});

rl.on("close", () => {
  for (let i = 1; i <= Number(input[0]); i++) {
    input[i] = input[i].split(" ").map(Number);
  }
  solution();
  process.exit();
});

// 차 계산하기
const cal = (morning, afternoon) => {
  let morningScore = 0;
  let afternoonScore = 0;

  for (let i = 0; i < permutation.length; i++) {
    const [j, k] = permutation[i];
    morningScore += input[morning[j]][morning[k]];
    morningScore += input[morning[k]][morning[j]];
    afternoonScore += input[afternoon[j]][afternoon[k]];
    afternoonScore += input[afternoon[k]][afternoon[j]];
  }
  result = Math.min(result, Math.abs(morningScore - afternoonScore));
};

// 2개씩 뽑아주는 순열
const getPermutation = (node, arr) => {
  if (2 === arr.length) {
    permutation.push(arr);
    return;
  }
  for (let i = node; i < target; i++) {
    getPermutation(i + 1, [...arr, i]);
  }
};

//아침 점심으로 일 나눠주기.
const dfs = (node, morning) => {
  if (target === morning.length) {
    let afternoon = works.filter((work) => !morning.includes(work));
    let afternoonKey = afternoon.join(","); // 배열로 값 비교하면 오래걸려서 join 해줌. 순서대로 moring에 집어넣기 때문에 sort 상관 x

    if (selectSet.has(afternoonKey)) return;
    selectSet.add(afternoonKey);
    selectSet.add(morning.join(","));
    cal(morning, afternoon);
    return;
  }

  for (let i = node; i < n; i++) {
    dfs(i + 1, [...morning, i]);
  }
};

const solution = () => {
  n = Number(input.shift());
  target = n / 2;
  works = Array.from({ length: n }, (_, i) => i);
  v = Array.from({ length: target }, () => false);

  getPermutation(0, []);

  dfs(0, []); // 확인할 일의 인덱스, 아침에 할 일.
  console.log(result);
};

실행 시간 : 1600ms
사용 공간 : 66MB
풀이 시간 : 45분

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
let input = [];
let n; // 전체 수
let target; // 전체 수의 반
let afternoon = [];
let result = Infinity;
const permutation = []; //2개씩 뽑는 순열 저장.
rl.on("line", (line) => {
  input.push(line);
});

rl.on("close", () => {
  for (let i = 1; i <= Number(input[0]); i++) {
    input[i] = input[i].split(" ").map(Number);
  }

  solution();
  process.exit();
});

const cal = () => {
  let morningScore = 0;
  let afternoonScore = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (afternoon[i] && afternoon[j]) {
        afternoonScore += input[i][j];
      }
      if (!afternoon[i] && !afternoon[j]) {
        morningScore += input[i][j];
      }
    }
  }

  result = Math.min(result, Math.abs(morningScore - afternoonScore));
};

//아침 점심으로 일 나눠주기.
const dfs = (node, cnt) => {
  if (cnt === target) {
    cal();
    return;
  }

  if (node === n) return;

  dfs(node + 1, cnt);

  afternoon[node] = true;
  dfs(node + 1, cnt + 1);
  afternoon[node] = false;
};

const solution = () => {
  n = Number(input.shift());
  target = n / 2;
  afternoon = Array.from({ length: target }, () => false);

  dfs(0, 0); // 확인할 일의 인덱스, 아침에 할 일.
  console.log(result);
};
```

실행 시간 : 996ms
사용 공간 : 66Mb

- 해설지 보고 옮김

#### 새롭게 알게된 점

배열을 직접 넘기는 것보다 하나 위의 스코프(글로벌)을 사용해서 다른 함수들이 그 배열에 접근할 수 있게 하는게 공간 복잡도를 크게 줄여줄 수 있다.

#### 어려웠던 점
