
public class ThisUsing {
	String id;
	String pw;
	
	void show() {System.out.println(id+" "+pw);}
	
	public ThisUsing() {
		this("","");
		System.out.println("������ ȣ��");
	}
	
	public ThisUsing(String id) {
		this(id,"1234");
	}
	
	public ThisUsing(String id,String pw) {
		this.id=id;
		this.pw=pw;
	}
	
	public static void main(String args[]) {
		ThisUsing tu = new ThisUsing();
		ThisUsing ts = new ThisUsing("hi");
		ThisUsing tt = new ThisUsing("hello","2222");
		
	}
}