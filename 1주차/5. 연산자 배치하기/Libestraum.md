#### 풀이 1. DFS

```python
n = int(input())
data = list(map(int, input().split()))
operater = list(map(int, input().split()))

answer = []

def dfs(now, idx, depth):
    if depth == n:
        answer.append(now)
        return
    else:
        for i in range(3):
            if operater[i] == 0:
                continue
            operater[i] -= 1
            if i == 0:
                dfs(now + data[idx], idx + 1, depth + 1)
            elif i == 1:
                dfs(now - data[idx], idx + 1, depth + 1)
            else:
                dfs(now * data[idx], idx + 1, depth + 1)
            operater[i] += 1

dfs(data[0], 1, 1)
print(min(answer), max(answer))
```

Runtime: 122ms  
Memory: 41MB  