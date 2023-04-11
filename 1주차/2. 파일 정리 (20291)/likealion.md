#### 풀이 1. 딕셔너리

파일명을 "."을 기준으로 split 해서 확장자를 딕셔너리로 카운트한다


``` python
import sys

N = int(sys.stdin.readline().strip())

dic = {}

for i in range(N):
    filename = sys.stdin.readline().strip()
    ex = filename.split(".")[-1]
    if ex in dic:
        dic[ex] += 1
    else:
        dic[ex] = 1
for i in sorted(list(dic.keys())):
    print(f"{i} {dic[i]}")
```


실행 시간 : 208ms    
사용 공간 : 41240KB  
풀이 시간 : 11분  

--- 

#### 새롭게 알게된 점
  + `input()` 대신 `sys.stdin.readline().strip()`를 썼을때 속도가 10배 빨라짐

#### 어려웠던 점
  + (있으면 작성)
  
