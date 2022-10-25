import java.util.Arrays;
import java.util.Stack;

public class Solution5 {
    static Stack<Double[]> stack = new Stack<Double[]>();
    static int[] answer = {0, 0};

    public static void dfs(int[] discounts, int[] emoticons, int[][] users){
        if(stack.size() == emoticons.length){
            int plusFriendCount = 0;
            Double totalPrice = 0.0;

            for(int[] user : users){
                Double userTotalPrice = 0.0;
                for(Double[] emoticon : stack){
                    if(emoticon[0] >= user[0]){
                        userTotalPrice += emoticon[1];
                    }
                }
                if(userTotalPrice >= user[1]){
                    plusFriendCount++;
                }else{
                    totalPrice += userTotalPrice;
                }
            }            
            
            if(plusFriendCount > answer[0]){
                answer[0] = plusFriendCount;
                answer[1] = totalPrice.intValue();
            } else if(plusFriendCount == answer[0]){
                if(totalPrice >= answer[1]){
                    answer[0] = plusFriendCount;
                    answer[1] = totalPrice.intValue();
                }
            }

            return;
        }
        
        for(int i = 0; i < discounts.length; i++){
            Double[] tempArr = {(double)discounts[i], emoticons[stack.size()] * ((100 - discounts[i]) / 100.0)};
            stack.add(tempArr);

            dfs(discounts, emoticons, users);

            stack.pop();
        }
        return;
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] discounts = {10,20,30,40};
        int[][] combinations = new int[(int) Math.pow(4, emoticons.length)][2];
        
    

        for(int i = 0; i < emoticons.length; i++){
            for(int j = 0; j < discounts.length; j++){
                System.out.println(combinations[i][0] + " " + combinations[i][1]);
            }
        }

        dfs(discounts, emoticons, users);

        return answer;
    }

    public static void main(String[] args){
        // int[][] users = {{40,10000},{25,10000}};
        // int[] emoticons = {7000,9000};

        int[][] users = {{40,2900},{23,10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};

        System.out.println(Arrays.toString(solution(users, emoticons)));
    }
}
