import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int callNumsCount, callNums;
        PriorityQueue<Integer> maxPriorityQueue= new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPriorityQueue= new PriorityQueue<>();
        StringBuilder sb= new StringBuilder();

        callNumsCount= Integer.parseInt(br.readLine());
        for(int i=0; i<callNumsCount; i++){
            callNums= Integer.parseInt(br.readLine());
            if(i==0){ 
                maxPriorityQueue.add(callNums); 
            }
            else if(i==1){
                minPriorityQueue.add(callNums);
                if(maxPriorityQueue.peek()>minPriorityQueue.peek()){
                    minPriorityQueue.add(maxPriorityQueue.poll());
                    maxPriorityQueue.add(minPriorityQueue.poll());
                }
            }
            else if(minPriorityQueue.size()==0 || callNums<minPriorityQueue.peek()){
                maxPriorityQueue.add(callNums);
                if(maxPriorityQueue.size()>=minPriorityQueue.size()+2){
                    minPriorityQueue.add(maxPriorityQueue.poll());
                }   
            }
            else{
                minPriorityQueue.add(callNums);
                if(minPriorityQueue.size()>=maxPriorityQueue.size()+1){
                    maxPriorityQueue.add(minPriorityQueue.poll());
                }
            }
            sb.append(maxPriorityQueue.peek()+"\n");
        }

        System.out.println(sb);
    }
}