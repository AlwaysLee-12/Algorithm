a= int(input())

for i in range(a):
	b,c= input().split()
	c= list(c)
	for j in c:
		print(j*int(b),end='')
	print()
