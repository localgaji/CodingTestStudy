#### 풀이 1. dfs


``` python
N = int(input())

ss = [list(map(int, input().split())) for i in range(N)]

answer = []
def dfs(day, helper):
    if len(day) == N // 2:
        night = [n for n in range(N) if n not in day]
        d, n = 0, 0
        l, r = 0, 1
        while l < len(day) - 1:
            d += ss[day[l]][day[r]] + ss[day[r]][day[l]]
            n += ss[night[l]][night[r]] + ss[night[r]][night[l]]
            
            if r + 1 >= len(day):
                l += 1
                r = l + 1
            else:
                r += 1
        answer.append(abs(d - n))
        return

    for i, x in enumerate(helper):
        day.append(x)
        dfs(day, helper[i+1:])
        day.pop()

dfs([], [i for i in range(N)])
print(min(answer))
```

Runtime: 1099ms   
Memory: 63MB

---

#### 풀이 2. min 함수 사용X, 함수 외부의 최솟값을 업데이트
 
``` python
N = int(input())

ss = [list(map(int, input().split())) for i in range(N)]
min_ = [9999999]
def dfs(day, helper):
    if len(day) == N // 2:
        night = [n for n in range(N) if n not in day]
        d, n = 0, 0
        l, r = 0, 1
        while l < len(day) - 1:
            d += ss[day[l]][day[r]] + ss[day[r]][day[l]]
            n += ss[night[l]][night[r]] + ss[night[r]][night[l]]
            
            if r + 1 >= len(day):
                l += 1
                r = l + 1
            else:
                r += 1
        min_[0] = min(min_[0], abs(d-n))
        return

    for i, x in enumerate(helper):
        day.append(x)
        dfs(day, helper[i+1:])
        day.pop()

dfs([], [i for i in range(N)])
print(min_[0])
```

Runtime: 975ms  
Memory: 46MB  

--- 

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + (있으면 작성)
  


