
public class StirngEx {

	public static void main(String[] args) {
		String a = new String(" C#");
		String b = new String(" ,C++ ");
		
		System.out.println(a+"�� ���̴� "+ a.length());
		System.out.println(a.contains("#"));
		
		a=a.concat(b); // a+b ���ڿ� ����
		System.out.println(a);
		
		a=a.trim(); // �յ� ��������
		System.out.println(a);
		
		a = a.replace("C#", "JAVA"); // ���ڿ� ��ġ
		System.out.println(a);
		
		String s[] = a.split(",");
		for (int i=0;i<s.length;i++) {
			System.out.println("�и��� ���ڿ� "+ i+": "+s[i]);
		}
		
		a = a.substring(5);//�ε��� 5���� �������� ���꽺Ʈ�� ����
		System.out.println(a);
		
		char c = a.charAt(2);//�ε��� 2�� ���ڿ� ����
		System.out.println(c);
	}
}
