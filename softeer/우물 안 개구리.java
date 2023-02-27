import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, PriorityQueue<Integer>> fMap = new HashMap<>();
        int result = 0;

        int memberCount = Integer.parseInt(st.nextToken());
        int friendshipCount = Integer.parseInt(st.nextToken());
        int[] weightArr = new int[memberCount];

        //멤버별 들 수 있는 무게 리스트 생성, 멤버별 친분 관계를 나타내는 맵 초기화(value에는 우선순위 큐 삽입)
        //우선순위 큐 삽입 이유: 그냥 리스트로 하게 될 경우 최대 형성될 수 있는 관계의 수가 n * n - 1(2 ≤ n ≤ 10^5)이므로 시간 초과
        //최대 우선순위 큐를 만들어 가장 들 수 있는 무게가 큰 사람만 꺼내기 
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < memberCount; i++){
            weightArr[i] = Integer.parseInt(st.nextToken());
            fMap.put(i, new PriorityQueue<>(Collections.reverseOrder()));
        }

        //멤버 간 친분 관계 양방향 연결 (A, B) -> (B, A)
        for(int i = 0; i < friendshipCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken()) - 1;

            fMap.get(key).offer(weightArr[value]);
            fMap.get(value).offer(weightArr[key]);
        }

        //멤버별 친분 관계를 나타내는 맵 쭉 탐색
        for(Integer key : fMap.keySet()){
            //현재 멤버가 들 수 있는 무게
            int keyWeight = weightArr[key];
            //친분 관계가 없으면 result++
            if(fMap.get(key).isEmpty()){
                result += 1;
            }else{
                //친분 관계가 있고, 친분 관계가 있는 사람 중 가장 들 수 있는 무게가 높은 사람과 자신을 비교해 자신이 더 크면 result++
                if(keyWeight > fMap.get(key).poll()){
                    result += 1;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
