
// Online IDE - Code Editor, Compiler, Interpreter
import java.util.*;
import java.io.*;
//규칙을 찾아 별을 찍는 문제(구현)
public class Main
{
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        
        for(int i = 0; i < 2 * in - 1; i++){
            for(int j = 0; j < Math.abs(in - i - 1); j++){
                bw.write(" ");
            }
            for(int j = 0; j < (2 * in - 1) - Math.abs(in - i - 1) * 2; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
}
