a= int(input())

for i in range(a):
	b,c= map(int, input().split())
	print("Case #", end='')
	print(i+1, end='')
	print(":",b+c)
