import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Haksa extends JFrame{
	
	JTextField tfId=null;
	JTextField tfName=null;
	JTextField tfDepartment=null;
	JTextField tfAdress=null;
	
	JTextArea taList=null;
	
	JButton btnInsert=null;
	JButton btnSelect=null;
	JButton btnUpdate=null;
	JButton btnDelete=null;
	
	String jdbcDriver="oracle.jdbc.driver.OracleDriver";
	String jdbcConn="jdbc:oracle:thin:@localhost:1521:xe";
	
	public Haksa() {
		this.setTitle("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=this.getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("학번"));
		this.tfId=new JTextField(22);
		c.add(this.tfId);
		
		c.add(new JLabel("이름"));
		this.tfName=new JTextField(22);
		c.add(this.tfName);
				
		c.add(new JLabel("학과"));
		this.tfDepartment=new JTextField(22);
		c.add(this.tfDepartment);
		
		c.add(new JLabel("주소"));
		this.tfAdress=new JTextField(22);
		c.add(this.tfAdress);
		
		this.taList=new JTextArea(13,22);
		c.add(new JScrollPane(this.taList));
		
		this.btnInsert=new JButton("등록");
		c.add(this.btnInsert);
		this.btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//DB연동 데이터를 insert
				try {
					//oracle jdbc 드라이버 로드
					Class.forName(jdbcDriver);//jdbc driver load
					//Connection
					Connection conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");//연결
					System.out.println("연결완료");
					Statement stmt=conn.createStatement();
					
					//insert
					stmt.executeUpdate("insert into student(id,name,dept,address) values('"+tfId.getText()+"','"+tfName.getText()+"','"+tfDepartment.getText()+"','"+tfAdress.getText()+"')");
					
					//목록초기화
					taList.setText("");
					ResultSet rs=stmt.executeQuery("select * from student");
					
					taList.append("학번\t");
					taList.append("이름\t");
					taList.append("학과\t");
					taList.append("주소\n");
					taList.append("==================================\n");
					
					while(rs.next()) {
//						System.out.println(rs.getString("name"));
//						System.out.println(rs.getString("id"));
//						System.out.println(rs.getString("dept"));
//						System.out.println(rs.getString("address"));
						taList.append(rs.getString("id")+"\t");
						taList.append(rs.getString("name")+"\t");
						taList.append(rs.getString("dept")+"\t");
						taList.append(rs.getString("address")+"\n");
						
					}
					rs.close();
					stmt.close();
					conn.close();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,"등록되었습니다.");
				
			}
		});
		
		this.btnSelect = new JButton("목록");
		c.add(this.btnSelect);
		this.btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName(jdbcDriver);
					
					Connection conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");
					System.out.println("연결완료");
					Statement stmt=conn.createStatement();
					
					//목록 초기화
					taList.setText("");
					ResultSet rs=stmt.executeQuery("select * from student");
					
					taList.append("학번\t");
					taList.append("이름\t");
					taList.append("학과\t");
					taList.append("주소\n");
					taList.append("==================================\n");
					
					while(rs.next()) {
						taList.append(rs.getString("id")+"\t");
						taList.append(rs.getString("name")+"\t");
						taList.append(rs.getString("dept")+"\t");
						taList.append(rs.getString("address")+"\n");
					}
					rs.close();
					stmt.close();
					conn.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		this.btnUpdate = new JButton("수정");
		c.add(this.btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName(jdbcDriver);
					
					Connection conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");
					System.out.println("연결완료");
					Statement stmt = conn.createStatement();
					
					//update Query
					stmt.executeUpdate("update student set name='"+tfName.getText()+"',dept='"+tfDepartment.getText()+"',address='"+tfAdress.getText()+"' where id='"+tfId.getText()+"'");
					
					taList.setText("");
					ResultSet rs = stmt.executeQuery("select * from student");
					taList.append("학번\t");
					taList.append("이름\t");
					taList.append("학과\t");
					taList.append("주소\n");
					taList.append("==================================\n");
					
					while(rs.next()) {
						taList.append(rs.getString("id")+"\t");
						taList.append(rs.getString("name")+"\t");						
						taList.append(rs.getString("dept")+"\t");
						taList.append(rs.getString("address")+"\n");
					}
					rs.close();
					stmt.close();
					conn.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,"수정이 완료되었습니다.");
								
			}
			
		});
		
		this.btnDelete = new JButton("삭제");
		c.add(this.btnDelete);
		
		this.btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"삭제하시겠습니까?","알림",JOptionPane.YES_NO_OPTION);
				System.out.println(result);
				if(result==JOptionPane.YES_NO_OPTION) {
					//삭제처리
					try {
						Class.forName(jdbcDriver);
						Connection conn = DriverManager.getConnection(jdbcConn,"user_prac","oracle");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("delete from student where id='"+tfId.getText()+"'");
						
						taList.setText("");
						ResultSet rs=stmt.executeQuery("select * from student");												
						taList.append("학번\t");
						taList.append("이름\t");
						taList.append("학과\t");
						taList.append("주소\n");
						taList.append("==================================\n");
						
						while(rs.next()) {
							taList.append(rs.getString("id")+"\t");
							taList.append(rs.getString("name")+"\t");
							taList.append(rs.getString("dept")+"\t");
							taList.append(rs.getString("address")+"\n");
						}
						rs.close();
						stmt.close();
						conn.close();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null,"삭제가 완료되었습니다");
					
				}else {
					JOptionPane.showMessageDialog(null,"삭제가 취소되었습니다.");
				}
			}
		});
		
		this.setSize(280,500);
		this.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Haksa();
	}
}


