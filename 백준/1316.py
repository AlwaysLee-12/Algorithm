a= int(input())
b= []

for i in range(a):
	b.append(input())
count= len(b)

for i in b:
	for j in range(len(i)-1):
		if i[j] != i[j+1]:
			if i[j] in i[j+1:]:		
				count=count-1
				break
print(count)
