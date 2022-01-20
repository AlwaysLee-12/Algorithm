# 동물 이름 중 두 번 이상 쓰인 이름과
# 해당 이름이 쓰인 횟수 조회
# 단, 이름이 없는 동물은 집계에서 제외
# 이름순 조회

SELECT name, count(*)
from animal_ins
group by name
having count(*) >= 2 and name is not null
order by name
