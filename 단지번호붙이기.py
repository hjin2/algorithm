# BFS라는 것을 보고 캐치
# 이 문제는 시작점이 여러개인 경우
# 시작점이 한개였다면 시작점으로 bfs돌려서 쉽게 해결 가능   =>  # (0,1)을 시작점으로 두고 bfs를 돌리면 단지 1개밖에 안나옴

# 그래프의 탐색 시작점을 모르기 때문에 전체를 돌면서 1인 지점에서 탐색 시작
# 탐색 중 1인 부분은 0으로 바꿔서 다시 방문하지 않도록 한다.
# 한 번의 BFS가 끝나게 되면 단지가 탄생

# -- 전체 1을 다 돌면서 bfs를 구하면 너무 계산이 많아지니까 1인 곳 한군데 들려서 bfs를 돌리면 그 구역을 찾을 수 있다.
#    이때 bfs를 돌리면서 방문한 곳은 0으로 만들어서 
#    반복문을 돌릴 때 2번 가지 않도록 한다. 즉 각 단지의 시작점을 큐에넣고 앞에서 한 것과 같이 bfs를 돌면 끝


from collections import deque

n = int(input())
# 2차원 리스트의 맵 정보 입력받기
graph = []
for i in range(n):
    graph.append(list(map(int,input())))

# 이동할 네 방향 정의 (상, 하, 좌, 우)
# x행 y열
dx = [-1,1,0,0]
dy = [0,0,-1,1]
houses = []

def bfs(graph,x,y):
    house = 0   # 단지에 속하는 집의 수
    queue = deque()
    queue.append((x,y)) # 큐에 시작점 넣기
    graph[x][y] = 0 # 맨 처음 탐색한 부분은 0으로 바꾸기 -> 다시 방문하지 않기 위해
    house += 1

    while queue:
        x,y = queue.popleft() # tuple (x,y)를 이렇게 간단히 뽑을 수 있음
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= n or ny >= n: # 공간을 벗어난 경우 무시하기
                continue
            if graph[nx][ny] == 0:  # 집이 없는 경우 무시하기
                continue
            if graph[nx][ny] == 1: 
                graph[nx][ny] = 0   # graph에서 1인 부분을 제외시키기 위해 0으로 바꾼다
                house = house + 1   # 단지에 속하는 집 추가
                queue.append((nx,ny))
    return house


for i in range(n):
    for j in range(n):
        if graph[i][j] == 1: 
            house = bfs(graph,i,j)
            houses.append(house)

print(len(houses))
houses.sort()   # 정렬
for i in houses:
    print(i)

