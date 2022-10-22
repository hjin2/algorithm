n = int(input())
nlist = list(map(int,input().split()))
nlist.sort() 

m = int(input())
mlist = list(map(int,input().split()))

ans = []


def binary_search(array,target,start,end):
    if start > end:
        return 0
    mid = (start+end)//2
    if array[mid] == target:
        return 1
    elif array[mid] > target:
        # end = mid - 1
        return binary_search(array,target,start,mid-1)
    else:
        # start = mid + 1
        return binary_search(array,target,mid+1,end)

for i in mlist:
    exist = binary_search(nlist,i,0,n-1)
    ans.append(exist)

for i in ans:
    print(i, end=' ')

