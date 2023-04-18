#### 풀이 1. 풀이 제목

풀이 설명 & 과정 (또는 코드 중간에 주석 작성)


``` python
row, col = map(int, input().split())
r, c, d = map(int, input().split())

grid = [list(map(int, input().split())) for i in range(row)]
direct = [(-1, 0), (0, 1), (1, 0), (0, -1)]  #북 동 남 서
visited = set([(r,c)])

while True:
    for i in range(4):  # 4방향 회전
        d -= 1
        if d < 0:  
            d += 4
        new_r , new_c = r + direct[d][0], c + direct[d][1]
        
        if 0 <= new_r <= row and 0 <= new_c <= col:  # 지도 안에 있고
            if (new_r, new_c) not in visited and grid[new_r][new_c] == 0:  # 방문한 적 없고, 도로라면 이동
                r, c = new_r, new_c  
                visited.add((r,c))
                break
                
    if (r, c) != (new_r, new_c) :  #후진
        new_r , new_c = r - direct[d][0], c - direct[d][1]
        if not (0 <= new_r <= row) or not (0 <= new_c <= col) or grid[new_r][new_c] == 1:  # 후진 불가능이면 루프 종료
            break
        else:
            r, c = new_r, new_c 

print(len(visited))

```

Runtime: 79ms  
Memory: 33MB  
풀이 시간 : 20분 

--- 

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + (있으면 작성)
  


