a= int(input())
c= a
count=0 

while True:
	b= (a//10)+(a%10)
	a= int(str(a%10)+str(b%10))
	count=count+1
	if(a==c):
		break
print(count)
