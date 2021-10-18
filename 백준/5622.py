dial= ['ABC','DEF', 'GHI','JKL','MNO','PQRS','TUV','WXYZ']
a= list(input())
result=0

for i in a:
	for j in dial:
		if i in j:
			result= result+dial.index(j)+3

print(result)
