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
		this.setTitle("�л����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=this.getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("�й�"));
		this.tfId=new JTextField(22);
		c.add(this.tfId);
		
		c.add(new JLabel("�̸�"));
		this.tfName=new JTextField(22);
		c.add(this.tfName);
				
		c.add(new JLabel("�а�"));
		this.tfDepartment=new JTextField(22);
		c.add(this.tfDepartment);
		
		c.add(new JLabel("�ּ�"));
		this.tfAdress=new JTextField(22);
		c.add(this.tfAdress);
		
		this.taList=new JTextArea(13,22);
		c.add(new JScrollPane(this.taList));
		
		this.btnInsert=new JButton("���");
		c.add(this.btnInsert);
		this.btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//DB���� �����͸� insert
				try {
					//oracle jdbc ����̹� �ε�
					Class.forName(jdbcDriver);//jdbc driver load
					//Connection
					Connection conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");//����
					System.out.println("����Ϸ�");
					Statement stmt=conn.createStatement();
					
					//insert
					stmt.executeUpdate("insert into student(id,name,dept,address) values('"+tfId.getText()+"','"+tfName.getText()+"','"+tfDepartment.getText()+"','"+tfAdress.getText()+"')");
					
					//����ʱ�ȭ
					taList.setText("");
					ResultSet rs=stmt.executeQuery("select * from student");
					
					taList.append("�й�\t");
					taList.append("�̸�\t");
					taList.append("�а�\t");
					taList.append("�ּ�\n");
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
				
				JOptionPane.showMessageDialog(null,"��ϵǾ����ϴ�.");
				
			}
		});
		
		this.btnSelect = new JButton("���");
		c.add(this.btnSelect);
		this.btnSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName(jdbcDriver);
					
					Connection conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");
					System.out.println("����Ϸ�");
					Statement stmt=conn.createStatement();
					
					//��� �ʱ�ȭ
					taList.setText("");
					ResultSet rs=stmt.executeQuery("select * from student");
					
					taList.append("�й�\t");
					taList.append("�̸�\t");
					taList.append("�а�\t");
					taList.append("�ּ�\n");
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
		
		this.btnUpdate = new JButton("����");
		c.add(this.btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName(jdbcDriver);
					
					Connection conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");
					System.out.println("����Ϸ�");
					Statement stmt = conn.createStatement();
					
					//update Query
					stmt.executeUpdate("update student set name='"+tfName.getText()+"',dept='"+tfDepartment.getText()+"',address='"+tfAdress.getText()+"' where id='"+tfId.getText()+"'");
					
					taList.setText("");
					ResultSet rs = stmt.executeQuery("select * from student");
					taList.append("�й�\t");
					taList.append("�̸�\t");
					taList.append("�а�\t");
					taList.append("�ּ�\n");
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
				
				JOptionPane.showMessageDialog(null,"������ �Ϸ�Ǿ����ϴ�.");
								
			}
			
		});
		
		this.btnDelete = new JButton("����");
		c.add(this.btnDelete);
		
		this.btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","�˸�",JOptionPane.YES_NO_OPTION);
				System.out.println(result);
				if(result==JOptionPane.YES_NO_OPTION) {
					//����ó��
					try {
						Class.forName(jdbcDriver);
						Connection conn = DriverManager.getConnection(jdbcConn,"user_prac","oracle");
						Statement stmt = conn.createStatement();
						stmt.executeUpdate("delete from student where id='"+tfId.getText()+"'");
						
						taList.setText("");
						ResultSet rs=stmt.executeQuery("select * from student");												
						taList.append("�й�\t");
						taList.append("�̸�\t");
						taList.append("�а�\t");
						taList.append("�ּ�\n");
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
					
					JOptionPane.showMessageDialog(null,"������ �Ϸ�Ǿ����ϴ�");
					
				}else {
					JOptionPane.showMessageDialog(null,"������ ��ҵǾ����ϴ�.");
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


