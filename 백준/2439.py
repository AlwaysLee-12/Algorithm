a= int(input())
b= "*"

for i in range(a):
	for j in range(a-i-1):
		print(" ",end='')
	print(b)
	b=b+"*"
	
