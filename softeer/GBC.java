import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<List<Integer>> sectorQ = new LinkedList<>();
        Queue<List<Integer>> testQ = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sectorCount = Integer.parseInt(st.nextToken());
        int testCaseCount = Integer.parseInt(st.nextToken());

        // 구간 별 기준 거리, 속도 Queue에 삽입
        for(int i = 0; i < sectorCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int distance = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            list.add(distance);
            list.add(speed);

            sectorQ.offer(list);
        }

        // 테스트 케이스 별 기준 거리, 속도 Queue에 삽입
        for(int i = 0; i < testCaseCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int distance = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            list.add(distance);
            list.add(speed);

            testQ.offer(list);
        }

        while(testQ.size() > 0){
            int testDistance = testQ.peek().get(0);
            int testSpeed = testQ.poll().get(1);
            
            while(testDistance > 0){
                if(testDistance >= sectorQ.peek().get(0)){
                    testDistance -= sectorQ.peek().get(0);
                    int sectorSpeed = sectorQ.poll().get(1);
                    if(testSpeed > sectorSpeed){
                        pq.offer(testSpeed - sectorSpeed); 
                    }
                }else{
                    sectorQ.peek().set(0, sectorQ.peek().get(0) - testDistance);
                    if(testSpeed > sectorQ.peek().get(1)){
                        pq.offer(testSpeed - sectorQ.peek().get(1)); 
                    }
                    testDistance = 0;
                }
            }
        }

        if(pq.size() == 0){
            bw.write("0");
        }else{
            bw.write(String.valueOf(pq.poll()));
        }
        bw.flush();
        bw.close();
    }
}

/*
 * 구간별 거리와 속도, 테스트 케이스별 거리와 속도가 주어지면, 속도를 비교해 초과하는 것 중 최대값 구하기
 * 1. 구간별, 테스트 케이스별 거리와 속도를 입력 받고 각각 큐에 넣음
 * 2. 테스트 케이스별 제한 속도 벗어나는 것들 우선순위 큐에 넣음
 * 2-1. 테스트 케이스의 거리가 더 크면, 속도가 기준에 초과하는지 판단 후 구간별 큐에서 다음 요소로 넘어감
 * 2-2. 테스트 케이스의 거리가 더 작으면, 속도가 기준에 초과하는지 판단 후 구간별 큐에서 현재 요소의 거리 테스트 케이스의 거리만큼 뺀 값 업데이트 해주고 테스트 케이스 거리 0으로 세팅
 * 2-3. 테스트 케이스의 거리가 0일때까지 2-1부터 반복
 * 3. 우선순위 큐가 비어있으면, 0출력 아니면 poll(제일 큰 값) 출력
*/
