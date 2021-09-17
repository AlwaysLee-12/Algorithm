import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		int treesNum, treeLengthToHome, mid, start=0, last=0;
		Scanner scan= new Scanner(System.in);
		ArrayList<Integer> treesHeight= new ArrayList<>();
		int cutterHeight=0;

		treesNum= scan.nextInt();
		treeLengthToHome= scan.nextInt();
		for(int i=0; i<treesNum; i++){
			treesHeight.add(scan.nextInt());
			if(last<treesHeight.get(i)) last=treesHeight.get(i);
		}

		while(start<last){
			long tempTreeLenghtToHome=0;
			mid=(start+last)/2;
			if(start==mid) break;
			for(int i=0; i<treesHeight.size();i++){
				if(treesHeight.get(i)>mid){
					tempTreeLenghtToHome+=(treesHeight.get(i)-mid);	
				}
			}
			if(tempTreeLenghtToHome>=treeLengthToHome){
				cutterHeight=mid;
				start=mid;
			}
			else{
				last=mid;
			}
		}
		System.out.println(cutterHeight);
	}
}
