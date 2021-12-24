# separate p with u,v
# u can no longer be separated balanced bracket str
def separate_bracket(p):
	left_bracket_count=0
	right_bracket_count= 0
	u= ''
	v= ''
  # make no longer separated balanced bracket str and assign to u
  # rest strs are assigned to v 
	for bracket_index in range(len(p)):
		if p[bracket_index]=="(":
			left_bracket_count+=1
		else:
			right_bracket_count+=1
		
		if left_bracket_count==right_bracket_count:
			u= p[:bracket_index+1]
			v= p[bracket_index+1:]
			break

	return (u,v)

# judging u is right bracket str or not
def is_right_bracket_str(u):
	loop_count= len(u)//2
	u= list(u)
	pair_count= 0

	if u[0]==")":
		return False

	for _ in range(loop_count):
		for bracket_index in range(len(u)-1):
				if u[bracket_index]!=u[bracket_index+1]:
					pair_count+=1
					u.pop(bracket_index)
					u.pop(bracket_index)
					break

	if pair_count==loop_count:
		return True

	return False

# make p to right bracket str
def bracket_change(p):
	if not p:
		return ''

	u,v= separate_bracket(p)

	if is_right_bracket_str(u):
		u+=bracket_change(v)
		return u

	else:
		result_bracket= '('
		result_bracket+= bracket_change(v)
		result_bracket+=')'

		u= list(u)
		u.pop()
		u.pop(0)
		for bracket_index in range(len(u)):
			if u[bracket_index]=="(":
				u[bracket_index]= ")"
			else:
				u[bracket_index]= "("
		u= ''.join(u)
		result_bracket+=u

		return result_bracket

def solution(p:str)->str:
	answer = ''

	answer= bracket_change(p)

	return answer
