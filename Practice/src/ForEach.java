
public class ForEach {

	enum Week {��,ȭ,��,��,��,��,��}
	
	public static void main(String[] args) {
		int []n= {1,2,3,4,5};
		String names[] = {"���","��","�ٳ���","ü��","����","����"};
		
		int sum=0;
		
		for(int k : n) {
			System.out.println(k+" ");//�ݺ��Ǵ� k �� ���
			sum+=k;
		}
		System.out.println("��: "+sum);
		
		for(String s : names) 
			System.out.print(s+" ");
		System.out.println("");
		
		for(Week day : Week.values())
			System.out.print(day +"���� ");
		System.out.println("");
		
		int tenArr[] = {1,2,3,4,5,6,7,8,9,10};
		int sumArr=0;
		System.out.println(tenArr.length);
		for(int t:tenArr)
			sumArr+=t;
		System.out.println("sumArr : "+sumArr);
			
	}	
}