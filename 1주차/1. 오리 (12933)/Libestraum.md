### 접근 방법 1
--- <
k까지 울고 나서 다시 q가 시작될 경우 한 마리의 오리로 취급급
### 접근 방법 2
---
u, a, c, k가 음수가 될 경우, 올바르지 않은 녹음 소리이다.


```python
sound = list(input())
dic = {'q': 0, 'u' : 1, 'a' : 2, 'c' : 3, 'k' : 4}
duck = [0, 0, 0, 0, 0] #각각 q, u, a, c를 나타낸다
answer, cnt = 0, 0

for s in sound:
    duck[dic[s]] += 1
    if s == 'q':
        cnt += 1
    if s != 'q':
        duck[dic[s] - 1] -= 1
        if duck[dic[s] - 1] < 0:
            break
    if s == 'k':
        cnt -= 1
    answer = max(answer, cnt)

print(-1 if (-1 in duck or sum(duck[:4]) != 0) else answer)
```