
public class ArrayPassingEx {

	static void replaceSpace(char a[]) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==' ') {
				a[i]=',';
			}
		}
	}
	
	static void printCharArray(char a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		char c[]= {'H','e','l','l','o',' ','M'};
		printCharArray(c);
		replaceSpace(c);
		printCharArray(c);
	}
}
