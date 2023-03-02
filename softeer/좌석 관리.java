import java.util.*;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;


public class Main
{
    static Map<Integer, List<Integer>> eattingList = new HashMap<>(); //현재 좌석에 앉아 식사를 하고 있는 사람들(사번과 좌석의 좌표가 들어있음)
    static List<Integer> ateList = new ArrayList<>(); //이미 식사를 마치고 떠난 사람들
    static boolean[][] seats; //좌석들(사람이 앉아 있는지 여부)
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, -1, 0, 1};

    //현재 좌석의 주변(상하좌우)에 앉아 있는 사람이 있는지 탐색
    static boolean checkNear(int row, int col){
        for(int i = 0; i < 4; i++){
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];

            if(nextRow >= 0 && nextCol >= 0 && nextRow < seats.length && nextCol < seats[0].length){
                if(seats[nextRow][nextCol]){
                    return false;
                }
            }
        }

        return true;
    }
    //앉을 수 있는 자리 탐색
    static String findSeat(int userId){
        //현재 식당에 밥을 먹는 사람이 아무도 없으면, 0,0에 앉기
        if(eattingList.isEmpty()){
            eattingList.put(userId, new ArrayList<>());
            eattingList.get(userId).add(0);
            eattingList.get(userId).add(0);
        }else{
            double degreeOfSafty = 0;
            int selectedRow = 0;
            int selectedCol = 0;
            boolean canSit = false;
            //식당의 모든 좌석 순회
            for(int i = 0; i < seats.length; i++){
                for(int j = 0; j < seats[0].length; j++){
                    double tempDegreeOfSafty = Double.MAX_VALUE;
                    //현재 좌석에 아무도 앉아 있지 않고 주변(좌우상하)에 아무도 없다면
                    if(!seats[i][j] && checkNear(i, j)){
                        //각각 현재 좌석에 앉아 있는 사람들의 위치와 현재 좌석의 위치로 임시 안전도를 검사하고, 그 중 가장 작은 것이 바로 현재 위치에서의 안전도
                        for(Integer targetUserId : eattingList.keySet()){
                            double r1 = Math.pow((double)eattingList.get(targetUserId).get(0) - (double)i, 2);
						                double r2 = Math.pow((double)eattingList.get(targetUserId).get(1) - (double)j, 2);
						                double currentSafety = Math.sqrt(r1 + r2);

                            if(currentSafety < tempDegreeOfSafty){
                                tempDegreeOfSafty = currentSafety;
                            }
                        }
                        //현재 위치에서 구한 안전도가 여태까지 순회했던 좌석들의 안전도보다 크면 현재 좌석을 최적의 좌석으로 지정(자리를 할당받을 수 있으니 canSit = True)
                        if(tempDegreeOfSafty > degreeOfSafty){
                            canSit = true;
                            degreeOfSafty = tempDegreeOfSafty;
                            selectedRow = i;
                            selectedCol = j;
                        }
                    }
                }
            }
            //모든 자리를 순회하고도 앉을 수 있는 곳이 없다면
            if(!canSit){
                return "There are no more seats.";
            }

            eattingList.put(userId, new ArrayList<>());
            eattingList.get(userId).add(selectedRow);
            eattingList.get(userId).add(selectedCol);
        }
        seats[eattingList.get(userId).get(0)][eattingList.get(userId).get(1)] = true;

        return userId + " gets the seat " + "(" + (eattingList.get(userId).get(0) + 1) + ", " + (eattingList.get(userId).get(1) + 1) + ").";
    }

    //In 케이스
    static String checkInCase(int userId, int row, int col){
        //현재 식사 중이라면
        if(eattingList.containsKey(userId)){
            return userId + " already seated.";
        //이미 식사를 마쳤다면
        }else if(ateList.contains(userId)){
            return userId + " already ate lunch.";
        
        }
        
        return findSeat(userId);
    }

    //Out 케이스
    static String checkOutCase(int userId){
        //현재 식사중도 아니고 식사를 마친 적도 없다면
        if(!ateList.contains(userId) && !eattingList.containsKey(userId)){
            return userId + " didn't eat lunch.";
        //이미 식사를 마쳤다면
        }else if(ateList.contains(userId)){
            return userId + " already left seat.";
        }
        //식사를 마치고 떠날 사원을 식사중인 사람들의 리스트에서 제거하고, 식사를 마친 사람들의 리스트에 추가, 그리고 그 사람이 앉았던 자리 다른 사람이 앉을 수 있게 활성화
        String result = userId + " leaves from the seat (" + (eattingList.get(userId).get(0) + 1) + ", " + (eattingList.get(userId).get(1) + 1) + ").";

        seats[eattingList.get(userId).get(0)][eattingList.get(userId).get(1)] = false;
        eattingList.remove(userId);
        ateList.add(userId);

        return result;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int seatRow = Integer.parseInt(st.nextToken());
        int seatCol = Integer.parseInt(st.nextToken());
        int caseCount = Integer.parseInt(st.nextToken());
        seats = new boolean[seatRow][seatCol];

        //주어진 케이스 순회하면서 조건에 맞는 결과 출력
        for(int i = 0; i < caseCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String inOrOut = st.nextToken();
            int userId = Integer.parseInt(st.nextToken());

            //In 케이스인 경우
            if(inOrOut.equals("In")){
                bw.write(checkInCase(userId, seatRow, seatCol) + "\n");
            //Out 케이스인 경우
            }else{
                bw.write(checkOutCase(userId) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
