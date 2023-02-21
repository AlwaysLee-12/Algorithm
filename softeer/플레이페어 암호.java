import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Boolean> isWritten = new HashMap<>();
        char[][] map = new char[5][5];
        List<String> dividedMsg = new ArrayList<>();

        String message = br.readLine();
        String key = br.readLine();

        for(int i = 65; i <= 90; i++){
            if(i == 74) continue;
            isWritten.put((char)i, false);
        }

        //5x5 표 만들기(j는 없음 i와 j를 동일한 것으로 간주. 이미 넣은 알파벳은 넣지 않음)
        int i = 0;
        int j = 0;
        int k = 0;
        while(k < key.length() && j < 5){
            char c = key.charAt(k);
            //이미 넣은 알파벳은 넣지 않기
            if(!isWritten.get(c)){
                isWritten.put(c, true);
                map[i][j] = c;

                if(j == 4){
                    j = 0;
                    i += 1;
                }else{
                    j += 1;
                }
            }

            k += 1;
        }

        //표가 남았으면 채워주기
        for(Character c : isWritten.keySet()){
            if(!isWritten.get(c) && j < 5){
                isWritten.put(c, true);
                map[i][j] = c;

                if(j == 4){
                    j = 0;
                    i += 1;
                }else{
                    j += 1;
                }
            }
        }
        
        //암호화 메세지 두 글자씩 나누기(같은 알파벳이면 사이에 X를 넣기, XX면 Q넣기 마지막 남은게 하나이고 X면 예외적으로 XX)
        Queue<Character> q = new LinkedList<>();
        for(i = 0; i < message.length(); i++){
            if(q.isEmpty()){
                q.offer(message.charAt(i));
            }else{
                if(q.peek() != message.charAt(i)){
                    dividedMsg.add(Character.toString(q.poll()) + Character.toString(message.charAt(i)));
                }
                else if(q.peek() == message.charAt(i)){
                    if(Character.toString(q.peek()).equals("X")){
                        dividedMsg.add(Character.toString(q.poll()) + "Q");
                    }else{
                        dividedMsg.add(Character.toString(q.poll()) + "X");
                    }
                    q.offer(message.charAt(i));
                }
            }
        }
        if(!q.isEmpty()){
            dividedMsg.add(Character.toString(q.poll()) + "X");
        }

        //쌍을 암호화
        String result = "";
        for(String pair : dividedMsg){
            int firstCRow = 0;
            int firstCCol = 0;
            int secondCRow = 0;
            int secondCCol = 0;

            //각 문자의 지도상에서의 위치 탐색
            for(i = 0; i < 5; i++){
                for(j = 0; j < 5; j++){
                    //첫 번째 문자 위치 탐색
                    if(map[i][j] == pair.charAt(0)){
                        firstCRow = i;
                        firstCCol = j;
                    }
                    //두 번째 문자 위치 탐색(if로 한 이유: 같은 문자일 수도 있음(for XX의 경우))
                    if(map[i][j] == pair.charAt(1)){
                        secondCRow = i;
                        secondCCol = j;
                    }
                }
            }

            //1. 표에서 같은 행에 존재하면 오른쪽으로 한 칸 이동한 칸에 글자로 암호화(XX는 하나. 인덱스 넘어가면 첫 번쨰 인덱스)
            if(firstCRow == secondCRow){
                if(firstCCol == 4){
                    result += map[firstCRow][0];
                }else{
                    result += map[firstCRow][firstCCol + 1];
                }

                if(secondCCol == 4){
                    result += map[secondCRow][0];
                }else{
                    result += map[secondCRow][secondCCol + 1];
                }
            }

            //2. 표에서 같은 열에 존재하면 아래쪽으로 한 칸 이동한 칸에 글자로 암호화
            else if(firstCCol == secondCCol){
                if(firstCRow == 4){
                    result += map[0][firstCCol];
                }else{
                    result += map[firstCRow + 1][firstCCol];
                }

                if(secondCRow == 4){
                    result += map[0][secondCCol];
                }else{
                    result += map[secondCRow + 1][secondCCol];
                }
            }

            //3. 다른 행과 열에 존재하면 두 글자의 열을 서로 교환한 칸에 글자로 암호화
            else if(firstCRow != secondCRow && firstCCol != secondCCol){
                result += map[firstCRow][secondCCol];
                result += map[secondCRow][firstCCol];
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}
