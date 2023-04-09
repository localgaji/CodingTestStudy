#### 풀이 1. 문자를 숫자화, 리스트 사용

``` python
s = input()
dic = {'q':1, "u":2, 'a':3, 'c':4, 'k':5}
ducks = []
for i in s:
    if dic[i] - 1 in ducks:
        for n in range(len(ducks)):
            
            if dic[i] - 1 == ducks[n]:
                ducks[n] += 1
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
  + `ducks`에서 `dic[i]-1` 요소를 찾아서 변경할 때, 요소를 하나 찾아서 바꿨으면 `break` 해줘야 함 -> 1차틀림  
  + 순회 마친 후 `ducks` 리스트에 오직 `0`만 남아있어야 함 -> 2차틀림  
  + `len` 함수, `set`함수를 써도 괜찮은걸까
