
public class MathEx {

	public static void main(String[] args) {
		double a= 4.1234;
		System.out.println(Math.PI);//������ ��� ���
		System.out.println(Math.ceil(a));//�ø�
		System.out.println(Math.floor(a));//����
		System.out.println(Math.sqrt(9));
		System.out.println(Math.exp(2));
		System.out.println(Math.round(3.14));
		
		System.out.print("�̹��� ����� ��ȣ�� ");
		for(int i=0;i<5;i++) {
			System.out.print((int)(Math.random()*45+1)+" ");
		}
	}
}