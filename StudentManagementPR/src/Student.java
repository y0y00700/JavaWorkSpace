import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student extends JPanel{
	
	JTextField tfId=null;
	JTextField tfName=null;
	JTextField tfDepartment=null;
	JTextField tfAddress=null;
	
	JTextArea taList=null;
	
	JButton btnInsert=null;
	JButton btnSelect=null;
	JButton btnUpdate=null;
	JButton btnDelete=null;
	
	JButton btnSearch=null;
	
	Connection conn=null;

	Statement stmt=null;
	
	JTable table=null;
	DefaultTableModel model=null;	
	
	String jdbcDriver="oracle.jdbc.driver.OracleDriver";
	String jdbcConn="jdbc:oracle:thin:@localhost:1521:xe";
	
	public Student() {
		//DB Connection
		try {
			//oracle jdbc driver
			Class.forName(jdbcDriver);
			conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");
			System.out.println("DB ���� �Ϸ�");
			stmt=conn.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		this.setLayout(new FlowLayout());
		
		this.add(new JLabel("�й�"));
		tfId=new JTextField(18);
		this.add(tfId);
		btnSearch=new JButton("�˻�");
		this.add(btnSearch);
		this.btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt=conn.createStatement();
					//��� �ʱ�ȭ
					model.setNumRows(0);
					ResultSet rs=stmt.executeQuery("select * from student where id='"+tfId.getText()+"'");
					
					while(rs.next()) {
						tfName.setText(rs.getString("name"));
						tfDepartment.setText(rs.getString("dept"));
						tfAddress.setText(rs.getString("address"));
						
						String[] row = new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						
						model.addRow(row);
					}
					rs.close();
					stmt.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		this.add(new JLabel("�̸�"));
		tfName=new JTextField(25);
		this.add(tfName);
		this.add(new JLabel("�а�"));
		tfDepartment=new JTextField(25);
		this.add(tfDepartment);
		this.add(new JLabel("�ּ�"));
		tfAddress=new JTextField(25);
		this.add(tfAddress);
		
		String colName[] = {"�й�","�̸�","�а�","�ּ�"};
		this.model=new DefaultTableModel(colName,0);//�� ��ü ����
		this.table=new JTable(this.model);//���̺��� ������ �� ��ü �����Ͽ� ����
		this.table.setPreferredScrollableViewportSize(new Dimension(250,200));
		add(new JScrollPane(this.table));//���̺��� Ư������ �����ؼ� TextField�� �� �Է�
		
		btnInsert=new JButton("���");
		this.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt=conn.createStatement();
					//db ��� ���� �޾ƿ� resultSet ��ü�� ������ ������
					stmt.executeUpdate("insert into student values('"+tfId.getText()+"','"+tfName.getText()+"','"+tfDepartment.getText()+"','"+tfAddress.getText()+"')");
					//��� �ʱ�ȭ
					model.setNumRows(0);
					ResultSet rs=stmt.executeQuery("select * from student");
					while(rs.next()) {
						String row[] = new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						
						model.addRow(row);
					}
					rs.close();
					stmt.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		btnSelect = new JButton("���");
		this.add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt=conn.createStatement();
					model.setNumRows(0);
					ResultSet rs=stmt.executeQuery("select * from student");
					while(rs.next()) {
						String row[] = new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						
						model.addRow(row);
					}
					rs.close();
					stmt.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		btnUpdate = new JButton("����");
		this.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt=conn.createStatement();
					stmt.executeUpdate("update student set name='"+tfName.getText()+"',dept='"+tfDepartment.getText()+"',address='"+tfAddress.getText()+"' where id='"+tfId.getText()+"'");
					
					model.setNumRows(0);
					ResultSet rs=stmt.executeQuery("select * from student where id='"+tfId.getText()+"'");
					while(rs.next()) {
						String row[] = new String[4];
						row[0] = rs.getString("id");
						row[1] = rs.getString("name");
						row[2] = rs.getString("dept");
						row[3] = rs.getString("address");
						model.addRow(row);
					}
					rs.close();
					stmt.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		btnDelete = new JButton("����");
		this.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result=JOptionPane.showConfirmDialog(null,"�����Ͻðڽ��ϱ�?","�˸�",JOptionPane.YES_NO_OPTION);
				System.out.println(result);
				if(result==JOptionPane.YES_NO_OPTION) {
					try {
						stmt=conn.createStatement();
						stmt.executeUpdate("delete from student where id='"+tfId.getText()+"'");
						ResultSet rs=stmt.executeQuery("select * from student");
						//��� �ʱ�ȭ
						model.setNumRows(0);
						while(rs.next()) {
							String[] row=new String[4];
							row[0]=rs.getString("id");
							row[1]=rs.getString("name");
							row[2]=rs.getString("dept");
							row[3]=rs.getString("address");
							model.addRow(row);
						}
						rs.close();
						stmt.close();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		this.setSize(280,500);
		this.setVisible(true);
		
	}
}