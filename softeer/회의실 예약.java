import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, boolean[]> rooms = new HashMap<>();

        int roomCount = Integer.parseInt(st.nextToken());
        int reserveCount = Integer.parseInt(st.nextToken());

        for(int i = 0; i < roomCount; i++){
            st = new StringTokenizer(br.readLine());
            rooms.put(st.nextToken(), new boolean[9]);
        }

        for(int i = 0; i < reserveCount; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String room = st.nextToken();
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken()); 
            boolean noDuplicate = true;

            for(int j = startTime - 9; j < endTime - 9; j++){
                if(rooms.get(room)[j]){
                    noDuplicate = false;
                    break;
                }
            }

            if(noDuplicate){
                for(int j = startTime - 9; j < endTime - 9; j++){
                    rooms.get(room)[j] = true;
                }
            }
        }

        List<String> keySet = new ArrayList<>(rooms.keySet());
        keySet.sort((k1, k2) -> k1.compareTo(k2));

        int possibleTimeCount = 0;
        for(String room : keySet){
            possibleTimeCount += 1;

            List<String> possibleTimes = new ArrayList<>();
            bw.write("Room " + room + ":" + "\n");

            for(int i = 0; i < rooms.get(room).length; i++){
                int tempStart = 0;
                int tempEnd = 0;

                if(!rooms.get(room)[i]){
                    tempStart = i + 9;

                    rooms.get(room)[i] = true;

                    for(int j = i + 1; j < rooms.get(room).length; j++){
                        if(rooms.get(room)[j]){
                            tempEnd = j + 9;
                            break;
                        }else if(j == rooms.get(room).length - 1){
                            tempEnd = j + 10;
                            rooms.get(room)[j] = true;
                        }else{
                            rooms.get(room)[j] = true;
                        }
                    }
                }

                if(tempStart == 17 && tempEnd == 0){
                    tempEnd = i + 10;
                }

                if(tempStart == 9 && tempStart >= 9 && tempEnd >= 9){
                    possibleTimes.add("0" + String.valueOf(tempStart) + "-" + String.valueOf(tempEnd));
                }else if(tempStart > 9 && tempStart >= 9 && tempEnd >= 9){
                    possibleTimes.add(String.valueOf(tempStart) + "-" + String.valueOf(tempEnd));
                }
            }

            if(possibleTimes.size() > 0){
                bw.write(String.valueOf(possibleTimes.size()) + " available:" + "\n");

                for(int i = 0; i < possibleTimes.size(); i++){
                    bw.write(possibleTimes.get(i) + "\n");
                }
            }else{
                bw.write("Not available" + "\n");
            }

            if(possibleTimeCount < keySet.size()){
                bw.write("-----" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
