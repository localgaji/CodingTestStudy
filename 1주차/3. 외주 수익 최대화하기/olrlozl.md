#### 풀이 1. 풀이 제목

```python
n = int(input())
data = [list(map(int, input().split())) for _ in range(n)]
result = []

def dfs(start, pay):
    for i in range(start, n):
        t, p = data[i][0], data[i][1]
        end = i + t
        if end < n:
            dfs(end, pay+p)
        elif end == n:
            result.append(pay+p)
        else:
            result.append(pay)
            
dfs(0, 0)
print(max(result))
```

실행 시간 : 142ms    
사용 공간 : 41MB  
풀이 시간 : 00분  

--- 

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + (있으면 작성)
  
