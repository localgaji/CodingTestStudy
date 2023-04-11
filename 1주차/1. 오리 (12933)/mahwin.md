```js
//input 받기
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input;

rl.on("line", (line) => {
  input = line.trim();
  rl.close();
});

rl.on("close", () => {
  console.log(solution());
  process.exit();
});

// 반복문을 돌면서 음절의 수를 세고, 그 수가 q >= u >= a >= c >= k면 오류가 없다고 가정하고 반복문 작성
const solution = () => {
  let result = -Infinity;
  const sound = "quack";

  const soundMap = {};
  sound.split("").forEach((s, i) => (soundMap[s] = i)); => // {'q':0 'b':1 }

  let ducks = Array.from({ length: sound.length }, () => 0);

  for (let i = 0; i < input.length; i++) {
    const current = input[i];
    const key = soundMap[current];
    ducks[key]++;

    for (let i = 0; i < 4; i++) {
      if (ducks[i] < ducks[i + 1]) {
        return -1;
      }
    }
    result = Math.max(result, ducks[0] - ducks[4]);
  }
  //울다 말았을 경우 -1 ex) [5,5,5,5,5] 정상
  return ducks[0] === ducks[4] ? result : -1;
};
```

실행 시간 : 200ms  
사용 공간 : 9840KB  
풀이 시간 : 10분

```js
//ducks 배열에 각각의 오리가 낼 다음 소리에 대한 인덱스를 저장하고 앞의 오리부터 탐색하며 일치하면 다음 소리를 val을 +1 하여 다음 인덱스를 찾도록함
//ducks ['qua','qu','q'] => [3,2,1]
const solution = () => {
  let result = -Infinity;
  let ducks = [];
  const sound = "quack";
  for (let i = 0; i < input.length; i++) {
    const current = input[i];
    if (current === "q") {
      ducks.push(1);
      result = Math.max(result, ducks.length);
      continue;
    }

    let flag = false; // 현재 소리를 낼 수 있는 오리가 있으면 true
    for (let duckIdx = 0; duckIdx < ducks.length; duckIdx++) {
      const nextSound = ducks[duckIdx];
      if (sound[nextSound] === current) {
        ducks[duckIdx]++;
        flag = true;
        //ducks의 요소가 5면 모든 소리를 낸 경우라 spice로 배열 삭제
        if (ducks[duckIdx] === 5) ducks.splice(duckIdx, 1);
        break;
      }
    }
    if (!flag) return -1;

    result = Math.max(result, ducks.length);
  }
  //아직 울음이 끝나지 않은 오리가 있으면 -1
  return ducks.length === 0 ? result : -1;
};
```

실행 시간 : 224ms  
사용 공간 : 10080KB  
풀이 시간 : 20분

#### 새롭게 알게된 점

- (있으면 작성)

#### 어려웠던 점

- solution 2에서 들리는 소리가 q면 새로운 오리로 추가하고 다음 소리로 바로 넘어갔는데 qk가 연달아 나오는 경우 집계가 안되는 경우가 있었음

['quac'] => [4]
q가 들어오면 ['quac','q']인데 바로 continue해서 result에 반영 X
다음 K가 들어오면 ['quack','q']인데 'quack'는 완성이라 빠져서 ['q']만 있는 걸로 체크됨.

if (current === "q") {
ducks.push(1);
continue;
}

if (current === "q") {
ducks.push(1);
result = Math.max(result, ducks.length); <= 이부분 추가
continue;
}
