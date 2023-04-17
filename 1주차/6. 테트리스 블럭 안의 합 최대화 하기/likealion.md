#### 풀이 1. 풀이 제목

``` python
def cal_max(n, maximum, skip=(None, None)):
    add = 0
    for j, x in enumerate(shape[n]):
        if j != skip[0] and j != skip[1]:
            nr, nc = x[0], x[1]
            add += grid[r + nr][c + nc]
        maximum = max(add, maximum)
    return maximum


row, col = map(int, input().split())
grid = [list(map(int, input().split())) for r in range(row)]
maximum = 0
shape = [[(0, 0), (0, 1), (0, 2), (0, 3)],  # 눕힌 막대
         [(0, 0), (1, 0), (2, 0), (3, 0)],  # 세운 막대
         [(0, 0), (0, 1), (1, 0), (1, 1)],  # 정사각형
         [(0, 0), (0, 1), (1, 0), (1, 1), (2, 0), (2, 1)],  # 세운 직사각형
         [(0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2)]]  # 눕힌 직사각형

for r in range(row):
    for c in range(col):
        if col >= 4 and c <= col - 4:
            maximum = cal_max(0, maximum)  # 1. 눕힌 막대기

        if row >= 4 and r <= row - 4:
            maximum = cal_max(1, maximum)  # 2. 세운 막대기

        if r <= row - 2 and c <= col - 2:
            maximum = cal_max(2, maximum)  # 3. 정사각형

        if r <= row - 3 and c <= col - 2:
            skip = [(0, 2), (1, 3), (2, 4), (3, 5), (0, 4), (1, 5), (0, 5), (1, 4)]
            for s in skip:
                maximum = cal_max(3, maximum, s)

        if r <= row - 2 and c <= col - 3:
            skip = [(1, 2), (0, 1), (4, 5), (3, 4), (0, 2), (3, 5), (2, 3), (0, 5)]
            for s in skip:
                maximum = cal_max(4, maximum, s)

print(maximum)

```

Runtime: 264ms  
Memory: 36MB  
풀이 시간 : 60분  

--- 

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + (있으면 작성)
  


