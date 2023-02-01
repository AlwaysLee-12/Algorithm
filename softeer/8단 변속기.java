import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[8];
        Stack<Integer> ascendingStack = new Stack<>();
        Stack<Integer> descendingStack = new Stack<>();

        for(int i = 0; i < 8; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int num : arr){
            if(ascendingStack.isEmpty() || descendingStack.isEmpty()){
                if(ascendingStack.isEmpty() && num == 1){
                    ascendingStack.push(num);
                }else if(descendingStack.isEmpty() && num == 8){
                    descendingStack.push(num); 
                }
            }
                
            if(!ascendingStack.isEmpty() && ascendingStack.peek() + 1 == num){
                ascendingStack.push(num);
            }else if(!descendingStack.isEmpty() && descendingStack.peek() - 1 == num){
                descendingStack.push(num);
            } 
        }

        if(ascendingStack.size() == 8){
            bw.write("ascending");
        }else if(descendingStack.size() == 8){
            bw.write("descending");
        }else{
            bw.write("mixed");
        }

        bw.flush();
        bw.close();
    };
}

/**
  * 8개의 숫자(1~8)가 하나씩 주어지고, 1~8 연속된 숫자 => ascending 출력, 8~1 연속된 숫자 => descending 출력, else mixed 출력
  */

/**
  * 1. 8개의 숫자 입력
  * 2. 스택 2개 생성(ascending용, descending 용)
  * 3. 배열 탐색
  * 4-1. ascending용 스택이 비어있고, 현재 숫자가 1이면 ascending용 스택에 push
  * 4-2. ascending용 스택 top의 수보다 현재 숫자가 1 크면 push
  * 5-1. descending용 스택이 비어있고, 현재 숫자가 8이면 descending 스택에 push
  * 5-2. descending용 스택 top의 수보다 현재 숫자가 1 작으면 push
  * 6. ascending용 스택의 길이가 8이면 ascending return, descending용 스택의 길이가 그러하면 descending return, else mixed return
  */
