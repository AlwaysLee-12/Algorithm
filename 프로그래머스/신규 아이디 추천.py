from typing import List
import re

def solution(new_id:str)->str:
    answer = ''
    
    # change to lower character
    new_id= new_id.lower()

    # remove str except lower character, number, -, _, .
    new_id= re.sub('[^a-z0-9-_.]','',new_id)
    
    # if . is continue more than twice, replace it to one .
    new_id=list(new_id)
    for i in range(len(new_id)-1):        
        if new_id[i]==new_id[i+1]=='.':
            new_id[i]=''
    new_id= "".join(new_id)
    # if . is in start or end, remove it
    new_id=list(new_id)
    if new_id[0]=='.':
        new_id[0]=''
    if new_id[-1]=='.':
        new_id[-1]= ''
    new_id= "".join(new_id)

    # if new_id is null, replace it to a
    if not new_id:
        new_id='a'
    
    # if length of new_id is more than 15, remove the exceed thing
    if len(new_id)>15:
        new_id= new_id[0:15]

    if new_id[-1]=='.':
        new_id= new_id[0:-1]
    
    # if length of new_id is lower than 3, append the last str to end
    while len(new_id)<3:
        new_id+=new_id[-1]
    
    answer=new_id
    
    return answer
