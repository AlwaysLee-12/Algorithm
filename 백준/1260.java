import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner scan= new Scanner(System.in);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result= new StringBuilder();
        List<List<Integer>> graph= new ArrayList<>();
        int vertexCount, lineCount, startVertexNum, fromVertex, toVertex, currentVertex;
        Stack<Integer> dfsRoute= new Stack<>();
        Queue<Integer> bfsRoute= new LinkedList<>();
        boolean[] isVisitedDfs, isVisitedBfs;

        vertexCount= scan.nextInt();
        lineCount= scan.nextInt();
        startVertexNum= scan.nextInt();
        isVisitedDfs= new boolean[vertexCount+1];
        isVisitedBfs= new boolean[vertexCount+1];
        for(int i=0; i<=vertexCount; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=1; i<=lineCount; i++){
            fromVertex= scan.nextInt();
            toVertex= scan.nextInt();
            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        //DFS
        for(int i=1; i<=vertexCount; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfsRoute.push(startVertexNum);  
        while(!dfsRoute.isEmpty()){
            currentVertex= dfsRoute.pop();
            if(!isVisitedDfs[currentVertex]){
                isVisitedDfs[currentVertex]=true;
                result.append(Integer.toString(currentVertex)+" ");
            } 
            for(int i=0; i<graph.get(currentVertex).size(); i++){
                if(!isVisitedDfs[graph.get(currentVertex).get(i)]){
                    dfsRoute.add(graph.get(currentVertex).get(i));
                }
            }
        }
        System.out.println(result);
        result.delete(0, result.length());
        
        //BFS
        for(int i=1; i<=vertexCount; i++){
            Collections.sort(graph.get(i));
        }

        bfsRoute.add(startVertexNum);
        while(!bfsRoute.isEmpty()){
            currentVertex= bfsRoute.poll();
            if(!isVisitedBfs[currentVertex]){
                isVisitedBfs[currentVertex]= true;
                result.append(Integer.toString(currentVertex)+" ");
            } 
            for(int i=0; i<graph.get(currentVertex).size(); i++){
                if(!isVisitedBfs[graph.get(currentVertex).get(i)]){
                    bfsRoute.add(graph.get(currentVertex).get(i));
                }
            }
        }
        System.out.println(result);
    }
}
