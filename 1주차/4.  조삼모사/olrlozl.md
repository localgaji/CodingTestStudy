#### 풀이 1. 순열과 조합 이용

풀이 설명 & 과정 (또는 코드 중간에 주석 작성)
 
```python
n = int(input())
work = [list(map(int,input().split())) for _ in range(n)]
result = []

from itertools import combinations, permutations

dv = [i for i in combinations(range(n),n//2)]

for i in range(len(dv)):
    morning, night = 0, 0
    for j in permutations(dv[i],2):
        morning += work[j[0]][j[1]]
    for k in permutations(dv[-i-1],2):
        night += work[k[0]][k[1]]
    result.append(abs(morning - night))

print(min(result))
```


실행 시간 : 1228ms    
사용 공간 : 70MB  
풀이 시간 : 20분  

--- 

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + (있으면 작성)
  
