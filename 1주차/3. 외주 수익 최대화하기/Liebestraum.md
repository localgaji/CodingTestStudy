#### 풀이 1. 동적 계획법

```python
n = int(input())
dp = [0 for _ in range(n+1)] #dp[n] = n일차에 일을 '끝마쳤을 때' 벌 수 있는 돈의 최대값
data = [(0, 0)]

for _ in range(n):
    t, p = map(int, input().split())
    data.append((t, p))

for i in range(1, n+1): #i는 일을 시작하는 날짜, data[i][0]은 일에 걸리는 시간
    if i + data[i][0] - 1 > n: #일을 시작하는 날도 일을 할 수 있으므로 1를 빼준다.
        continue #i + data[i][0] - 1이 n보다 크다는 건, n일차에 일을 끝마칠 수 없다는 것
    dp[i + data[i][0] - 1] = max(max(dp[:i + data[i][0]]), data[i][1] + max(dp[:i])) #x = max(a, b)

print(max(dp))
```
풀이 설명 & 과정 (또는 코드 중간에 주석 작성)

x = i일차에 할 수 있는 일을 시작해서 data[i][0]만큼의 시간을 소요하고 일을 끝마쳤을 때 돈의 최대값
a = [i일차에 주어진 일을 하지 않고 i + data[i][0] - 1일까지 다른 일을 끝마친 경우들의 최대값]
b = i일차에 주어진 일을 했을때의 돈 + i일 전까지의 일들을 끝마쳤을 때 번 돈의 최대값
a, b중 큰 값이 x에 들어간다.

실행 시간 : 77ms    
사용 공간 : 33MB  
풀이 시간 : 60분