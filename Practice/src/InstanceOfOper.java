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
			super.name = "Shape"; // 정적 바인딩 
			super.draw(); // 정적 바인딩 메모리에 적재 시키는 순간 실행되는 바인딩
			System.out.println(name);
		}
	}
	
}