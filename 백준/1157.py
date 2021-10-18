a= input().upper()
b= list(set(a))
c=[]

for i in b:
	count= a.count(i)
	c.append(count)

if(c.count(max(c))>1):
	print("?")
else:
	print(b[c.index(max(c))])
