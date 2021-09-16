import java.util.Scanner;

public class Main {
    public static int calculation(int num){
        int numOfhansu=0;

        if((int)(Math.log10(num)+1)<=2){
            numOfhansu=num;
        }
        else{
            numOfhansu=99;
            for(int i=100;i<=num;i++){
                int[] arr=new int[(int)(Math.log10(i)+1)];
                int tmp=i;
                boolean flag=true;

                for(int j=0;j<(int)(Math.log10(i)+1);j++){
                    arr[j]=tmp%10;
                    tmp/=10;
                }

                for(int j=0;j<(int)(Math.log10(i)+1)-1;j++){
                    arr[j]=arr[j]-arr[j+1];
                }

                for(int j=0;j<(int)(Math.log10(i)+1)-2;j++){
                    if(arr[j]!=arr[j+1]) flag=false;
                }

                if(flag==true) numOfhansu++;
            }
        }
        return numOfhansu;
    }

    public static void main(String[] args){
        int num,result;
        Scanner scan=new Scanner(System.in);

        num=scan.nextInt();
        result=calculation(num);

        System.out.print(result);
    }
}