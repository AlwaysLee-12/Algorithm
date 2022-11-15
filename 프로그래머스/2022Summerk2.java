public class Solution4 {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int tempCap = cap;

        for(int i = n - 1; i >= 0; i--){

            if(deliveries[i] == 0 && pickups[i] == 0){
                continue;
            }
            else if(tempCap >= deliveries[i]){
                
            }
            else{
                tempCap -= deliveries[i];
                tempCap += pickups[i];
            }

        }

        return answer;
    }
    public static void main(String[] args){
        int cap = 4;
        int n = 5;
        int[] deliveries = {1,0,3,1,2};
        int[] pickups = {0,3,0,4,0};

        System.out.println(solution(cap, n, deliveries, pickups));
    }
}
