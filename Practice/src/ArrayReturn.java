//메소드에서 어떤 배열이든지 리턴하면, 배열공간 전체가 아닌 배열의 레퍼런스만 리턴한다.
public class ArrayReturn {
	static int [] makeArray() {
		int temp[] = new int[4];
		for(int i=0;i<temp.length;i++) 
			temp[i]=i;
		return temp;		
	}
	
	public static void main(String args[]) {
		int intArray[];
		intArray = makeArray();
		for(int i=0;i<intArray.length;i++) {
			System.out.println(intArray[i]+" ");
		}
	}
}
