import java.io.*;
import java.util.*;
public class BufferedIOEx {

	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("c:\\temp\\text.txt");
			BufferedOutputStream out = new BufferedOutputStream(System.out,5);
			while((c=fin.read()) !=-1) {
				out.write(c);
			}
			//���� �����Ͱ� ��� ��µ� ����
			new Scanner(System.in).nextLine();//EnterŰ �Է�
			out.flush();//���ۿ� ���� �ִ� ���� ��� ���
			fin.close();
			out.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}