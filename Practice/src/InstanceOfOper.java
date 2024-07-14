public class InstanceOfOper{
	class Shape{
		protected String name;
		public void paint() {
			draw();
		}
		public void draw() {
			System.out.println(name);
		}
	}
	
	public class Circle extends Shape{
		protected String name;
		
		@Override
		public void draw() {
			name = "Circle";
			super.name = "Shape"; // ���� ���ε� 
			super.draw(); // ���� ���ε� �޸𸮿� ���� ��Ű�� ���� ����Ǵ� ���ε�
			System.out.println(name);
		}
	}
	
}