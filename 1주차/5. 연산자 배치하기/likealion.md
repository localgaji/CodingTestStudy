#### 풀이 1. dfs 탐색

```python
N = int(input())
numbers = list(map(int, input().split()))
# index 0: 덧셈, 1:뺄셈, 2:곱셈
operators = list(map(int, input().split())) 

min_max=[99999999999999999999999999999, -99999999999999999999999999999]

# 연산자의 순열 구하기 : 같은 것이 있는 순열
def dfs(order, helper):
    if len(order) == N - 1:
        answer = numbers[0]
        for n in range(N-1):
            if order[n] == 0:
                answer += numbers[n+1]
            elif order[n] == 1:
                answer -= numbers[n+1]
            else:
                answer *= numbers[n+1]
        min_max[0], min_max[1] = min(min_max[0], answer), max(min_max[1], answer)
        return
    
    for i, x in enumerate(helper):
        if helper[i] != 0:
            order.append(i)
            new_helper = helper[:]
            new_helper[i] -= 1
            dfs(order, new_helper)
            order.pop()

dfs([], operators)

print(f"{min_max[0]} {min_max[1]}")
```

Runtime: 143ms
Memory: 41MB

--- 

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + 최댓값의 초기값을 설정할 때, 0이 아닌 -infinity를 해주어야 한다 (최댓값이 음수일수도 있으므로)
