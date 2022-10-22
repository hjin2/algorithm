d,n = map(int,input().split())
oven = list(map(int,input().split()))
pizza = list(map(int,input().split()))

for i in range(1,d):
    oven[i] = min(oven[i],oven[i-1])    #밑의 오븐은 그 위에보다 같거나 작음

idx = 0
right = d-1

while idx < n:
    result = 0
    for i in range(right,-1,-1):
        if oven[i] >= pizza[idx]:
            result = i+1
            right = i-1
            break
    if result == 0:
        break
    idx += 1

print(result)
