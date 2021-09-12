import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class BookRent extends JPanel{
	
	String jdbcDriver="oracle.jdbc.driver.OracleDriver";
	String jdbcConn="jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection conn=null;
	Statement stmt=null;
	DefaultTableModel model=null;
	JTable table=null;
	String query;
	public BookRent() {
		query="select s.id,s.name,b.title,br.rdate "
				+ "from student s, books b, bookrent br "
				+ "where s.id=br.id and b.no=br.bookno";
		
		try {
			 Class.forName(jdbcDriver);
			 conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");
			 stmt=conn.createStatement();			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setLayout(null);
		
		JLabel l_dept=new JLabel("학과");
		l_dept.setBounds(10, 10, 30, 20);
		add(l_dept);
		
		String[] dept= {"전체","컴퓨터시스템","멀티미디어","컴퓨터공학"};
		JComboBox cb_dept=new JComboBox(dept);
		cb_dept.setBounds(45, 10, 100, 20);
		add(cb_dept);
		cb_dept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				query="select s.id, s.name, b.title, br.rdate, s.dept "
						+ " from student s, books b, bookrent br "
						+ " where s.id=br.id and b.no=br.bookno";
				
				JComboBox cb=(JComboBox)e.getSource();
				if(cb.getSelectedIndex()==0) {
					//전체
					query+=" order by s.id";
					System.out.println("전체");
				}else if(cb.getSelectedIndex()==1) {
					query+=" and s.dept='컴퓨터시스템' order by br.no";
					System.out.println("컴퓨터시스템");
				}else if(cb.getSelectedIndex()==2) {
					query+=" and s.dept='멀티미디어' order by br.no";
					System.out.println("멀티미디어");
				}else if(cb.getSelectedIndex()==3) {
					query+=" and s.dept='컴퓨터공학' order by br.no";
					System.out.println("컴공");
				}
				//목록 출력
				list();
								
			}
			
		});
		String colName[]= {"학번","학생이름","도서명","대출일"};
		model=new DefaultTableModel(colName,0);
		table= new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(470,200));
		add(table);
		JScrollPane sp= new JScrollPane(table);
		sp.setBounds(10, 40, 460, 250);
		add(sp);
		
		setSize(490,400);
		setVisible(true);
	}
	
	public void list(){
		try {
			System.out.println("DB 연결 완료");
			System.out.println(query);
			
			ResultSet rs=stmt.executeQuery(query);
			//초기화
			model.setNumRows(0);
			
			while(rs.next()) {
				String[] row=new String[4];
				row[0]=rs.getString("id");
				row[1]=rs.getString("name");
				row[2]=rs.getString("title");
				row[3]=rs.getString("rdate");				
				model.addRow(row);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}
		catch(Exception e1) {
			System.out.println(e1.getMessage());		
		}
	}
}
