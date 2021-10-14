a, b= map(int,input().split())

if(b<45):
	if(a==0):
		a=23
	else:
		a=a-1
	b=60-(45-b)
	print(a,b)
else:
	print(a,b-45)
