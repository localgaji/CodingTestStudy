#### 풀이 1. 주사위에 적힌 숫자 리스트 dice의 순서를 바꾸기
  

![Screenshot_20230419_222722](https://user-images.githubusercontent.com/111048211/233089959-c52d8589-4a18-4ac1-a2b0-6a0c8129ad68.jpg)
  
  
주사위를 굴릴때마다 `dice` 의 순서를 바꾼다. (위0 아1 앞2 뒤3 왼4 오5)  
  
1. 동쪽 : 0 1 2 3 4 5 -> 4 5 2 3 1 0  
2. 서쪽 : 0 1 2 3 4 5 -> 5 4 2 3 0 1  
3. 북쪽 : 0 1 2 3 4 5 -> 2 3 1 0 4 5  
4. 남쪽 : 0 1 2 3 4 5 -> 3 2 0 1 4 5  
<br/>
  
  
이 작업을 실행하는 `roll`이라는 함수를 선언
+ 파이썬의 다중할당 사용
+ 함수 밖의 리스트의 값을 변경함
<br/>
   
``` python
row, col, r, c, k = map(int, input().split())
grid = [list(map(int, input().split())) for i in range(row)]
directions = list(map(int, input().split()))  # 1:동 2:서 3:북 4:남

move = {1:(0, 1), 2:(0, -1), 3:(-1,0), 4:(1,0)}  # dr, dc (1:동 2:서 3:북 4:남)
dice = [0, 0, 0, 0, 0, 0]  # 주사위에 적힌 숫자 : [위, 아, 앞, 뒤, 왼, 오]
change = {1:([0,1,4,5], [4,5,1,0]), 
        2:([0,1,4,5], [5,4,0,1]), 
        3:([0,1,2,3], [2,3,1,0]), 
        4:([0,1,2,3], [3,2,0,1])}


def roll(direct):
    old, new = change[direct][0], dice_change[direct][1]
    dice[old[0]], dice[old[1]], dice[old[2]], dice[old[3]] = dice[new[0]], dice[new[1]], dice[new[2]], dice[new[3]]


for d in directions:
    dr, dc = move[d] 
    new_r, new_c = r + dr, c + dc

    if not (0 <= new_r < row) or not (0 <= new_c < col):  
        continue  # 판 밖으로 나갈때

    r, c = new_r, new_c
    roll(d) 

    if grid[r][c] == 0:  # 판 숫자가 0일 때 : 판 -> 주사위
        grid[r][c] = dice[1]
    
    else:  # 판 숫자 > 0일 때 : 주사위 -> 판, 판 -> 0
        dice[1] = grid[r][c]
        grid[r][c] = 0

    print(dice[0])    # dice[1] = 아랫면 숫자, dice[0] = 윗면 숫자


```

Runtime: 103ms  
Memory: 33MB  
풀이 시간 : 63분  

--- 

#### 새롭게 알게된 점

#### 어려웠던 점
  + 동서북남 순인데 동서남북으로 잘못 읽음
  


