#### 풀이 1. 

```python
n = int(input())
num = list(map(int, input().split()))
plus, minus, multiply = map(int, input().split())

minimum = 1e9
maximum = -1e9

def dfs(depth, total, plus, minus, multiply):
    global minimum, maximum
    if depth == n:
        minimum = min(total, minimum)
        maximum = max(total, maximum)
        return
    if plus:
        dfs(depth+1, total+num[depth], plus-1, minus, multiply)
    if minus:
        dfs(depth+1, total-num[depth], plus, minus-1, multiply)
    if multiply:
        dfs(depth+1, total*num[depth], plus, minus, multiply-1)

dfs(1, num[0], plus, minus, multiply)
print(minimum, maximum)
```


실행 시간 : 89ms    
사용 공간 : 34MB  
풀이 시간 : 00분  


--- 

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + (있으면 작성)
  
