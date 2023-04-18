#### 풀이 1. DFS

```python
n = int(input())
data = []
answer = []
visit = [False for _ in range(n)]

for _ in range(n):
    data.append(list(map(int, input().split())))

def dfs(v, depth):
    if depth == n//2:
        day, night = 0, 0
        for i in range(n):
            for j in range(n):
                if visit[i] and visit[j]:
                    day += data[i][j]
                elif not visit[i] and not visit[j]:
                    night += data[i][j]
        answer.append(abs(day - night))
        return

    for i in range(v+1, n):
        visit[i] = True
        dfs(i, depth + 1)
        visit[i] = False
dfs(0, 0)
print(min(answer))
```

Runtime: 901ms  
Memory: 43MB  