#### 풀이 1. 풀이 제목

풀이 설명 & 과정

``` python
s = input()
dic = {'q':1, "u":2, 'a':3, 'c':4, 'k':5}
ducks = []
for i in s:
    if dic[i] - 1 in ducks:
        for n in range(len(ducks)):
            if dic[i] - 1 == ducks[n]:
                ducks[n] = dic[i]
                if ducks[n] == 5:
                    ducks[n] = 0
                break
    else:
        if dic[i] == 1:
            ducks.append(1)
        else:
            print(-1)
            quit()
        
if len(set(ducks)) > 1 or list(set(ducks))[0] != 0:
    print(-1)
    quit()
print(len(ducks))
```

실행 시간 : 52ms    
사용 공간 : 31256KB  
풀이 시간 : 35분  

---

#### 새롭게 알게된 점
  + (있으면 작성)

#### 어려웠던 점
  + (있으면 작성)
