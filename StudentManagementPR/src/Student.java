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
			System.out.println("DB 연동 완료");
			stmt=conn.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		this.setLayout(new FlowLayout());
		
		this.add(new JLabel("학번"));
		tfId=new JTextField(18);
		this.add(tfId);
		btnSearch=new JButton("검색");
		this.add(btnSearch);
		this.btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt=conn.createStatement();
					//목록 초기화
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
		
		this.add(new JLabel("이름"));
		tfName=new JTextField(25);
		this.add(tfName);
		this.add(new JLabel("학과"));
		tfDepartment=new JTextField(25);
		this.add(tfDepartment);
		this.add(new JLabel("주소"));
		tfAddress=new JTextField(25);
		this.add(tfAddress);
		
		String colName[] = {"학번","이름","학과","주소"};
		this.model=new DefaultTableModel(colName,0);//모델 객체 생성
		this.table=new JTable(this.model);//테이블에 생성된 모델 객체 적용하여 생성
		this.table.setPreferredScrollableViewportSize(new Dimension(250,200));
		add(new JScrollPane(this.table));//테이블의 특정행을 선택해서 TextField에 값 입력
		
		btnInsert=new JButton("등록");
		this.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt=conn.createStatement();
					//db 결과 값을 받아올 resultSet 객체가 실행할 쿼리문
					stmt.executeUpdate("insert into student values('"+tfId.getText()+"','"+tfName.getText()+"','"+tfDepartment.getText()+"','"+tfAddress.getText()+"')");
					//목록 초기화
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
		
		btnSelect = new JButton("목록");
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
		
		btnUpdate = new JButton("수정");
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
		
		btnDelete = new JButton("삭제");
		this.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result=JOptionPane.showConfirmDialog(null,"삭제하시겠습니까?","알림",JOptionPane.YES_NO_OPTION);
				System.out.println(result);
				if(result==JOptionPane.YES_NO_OPTION) {
					try {
						stmt=conn.createStatement();
						stmt.executeUpdate("delete from student where id='"+tfId.getText()+"'");
						ResultSet rs=stmt.executeQuery("select * from student");
						//목록 초기화
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
