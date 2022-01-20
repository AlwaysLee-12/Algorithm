# 09시부터 19:59분까지 각 시간대별로 입양이 몇 건이나 발생했는지 조회
# 시간대 순 정렬
# hour(datetime) = 9
# select 절에서 조회한 컬럼 이름을 having절에서 사용
# as hour로 해놓은 컬럼을 having 절에서 사용할 수 있음

SELECT hour(datetime) as hour, count(*)
from animal_outs
group by hour(datetime) 
having hour >= 9 and  hour <= 19
order by hour(datetime)
