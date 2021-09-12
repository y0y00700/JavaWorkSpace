
public class ForEach {

	enum Week {월,화,수,목,금,토,일}
	
	public static void main(String[] args) {
		int []n= {1,2,3,4,5};
		String names[] = {"사과","배","바나나","체리","딸기","포토"};
		
		int sum=0;
		
		for(int k : n) {
			System.out.println(k+" ");//반복되는 k 값 출력
			sum+=k;
		}
		System.out.println("합: "+sum);
		
		for(String s : names) 
			System.out.print(s+" ");
		System.out.println("");
		
		for(Week day : Week.values())
			System.out.print(day +"요일 ");
		System.out.println("");
		
		int tenArr[] = {1,2,3,4,5,6,7,8,9,10};
		int sumArr=0;
		System.out.println(tenArr.length);
		for(int t:tenArr)
			sumArr+=t;
		System.out.println("sumArr : "+sumArr);
			
	}	
}
