#### 풀이 1. DFS 재귀 구조

풀이 설명 & 과정 (또는 코드 중간에 주석 작성)

```python
N = int(input())

works = []
for i in range(N):
    t, p = map(int,input().split())
    works.append((t,p))

combi = []

def dfs(start, money):

    for i in range(start, N):
        t, p = works[i][0], works[i][1]
        end = i + t
        if end < N:
            dfs(end, money + p)
        elif end == N:
            combi.append(money + p)
        else:
            combi.append(money)
dfs(0, 0)

print(max(combi))
```

실행 시간 : 125ms    
사용 공간 : 36MB  
풀이 시간 : 오래걸림  

--- 

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + 재귀 구조가 너무 헷갈린다..
