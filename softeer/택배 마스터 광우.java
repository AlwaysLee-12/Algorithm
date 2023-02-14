import java.util.*;
import java.io.*;


public class Main
{
    static Stack<Integer> stack = new Stack<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static void getMinimumBasketWeight(int workCount, int basketWeight, Object[] rails){
        int currentWorkCount = 1;
        int i = 0;
        int totalWeight = 0;
        
        while(currentWorkCount <= workCount){
            int tempWeight = 0;
            while(i < rails.length && (tempWeight + (int)rails[i]) <= basketWeight){
                tempWeight += (int)rails[i];
                i += 1;
                if(i >= rails.length){
                    i = 0;
                }
            }

            if(i >= rails.length){
                i = 0;
            }
            currentWorkCount += 1;
            totalWeight += tempWeight;
        }

        pq.offer(totalWeight);
    }

    static void dfs(Map<Integer, Boolean> isVisited, int workCount, int basketWeight, int railCount){
        if(stack.size() == railCount){
            getMinimumBasketWeight(workCount, basketWeight, stack.toArray());
            return;
        }

        for(Integer railWeight : isVisited.keySet()){
            if(!isVisited.get(railWeight)){
                isVisited.put(railWeight, true);
                stack.push(railWeight);
                dfs(isVisited, workCount, basketWeight, railCount);
                stack.pop();
                isVisited.put(railWeight, false);
            }
        }
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, Boolean> isVisited = new HashMap<>();

        int railCount = Integer.parseInt(st.nextToken());
        int basketWeight = Integer.parseInt(st.nextToken());
        int workCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < railCount; i++){
            isVisited.put(Integer.parseInt(st.nextToken()), false);
        }

        dfs(isVisited, workCount, basketWeight, railCount);

        bw.write(String.valueOf(pq.poll()));
        bw.flush();
        bw.close();
    }
}

/* 모든 순서의 조합 중 값이 가장 작은 값 구하기
 * 1. 모든 조합 DFS를 통해 구하기
 * 1-1. Stack에 조합 대상들을 담고 그 크기가 문제에서 주어진 일의 횟수에 다다르면 return (Base Case)
 * 1-2. Stack에 쌓고 빼면서 모든 조합 구하기(조합 구할 때, 현재 스택에 없는 것들만. 중복 X)
 * 2. 각각의 조합의 최소 무게 구하기(무게 구할때마다 우선순위 큐에 넣어 답 꺼내기(최소값))
 * 2-1. 배열의 인덱스를 초과할 경우 다시 처음으로 되돌려서 일의 횟수에 다다를때까지(바구니의 무게 초과 전까지 담은걸 일 + 1로 간주) 
 */
