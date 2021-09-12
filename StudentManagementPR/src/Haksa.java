import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Haksa extends JFrame {
			
	Connection conn=null;
	Statement stmt=null;
	JPanel panel=null;
	
	String jdbcDriver="oracle.jdbc.driver.OracleDriver";
	String jdbcConn="jdbc:oracle:thin:@localhost:1521:xe";
	
	public Haksa() {
		this.setTitle("학사 관리 프로그램");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			//Oracle jdbc driver
			Class.forName(jdbcDriver);
			//Connection
			conn=DriverManager.getConnection(jdbcConn,"user_prac","oracle");
			System.out.println("DB 연결 완료");
			stmt=conn.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//DB Close 응용프로그램 종료시
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JMenuBar bar=new JMenuBar();
		
		JMenu m_student=new JMenu("학생관리");
		bar.add(m_student);
		
		JMenu m_book=new JMenu("도서관리");
		bar.add(m_book);
		
		JMenuItem mi_list = new JMenuItem("학생 정보");
		m_student.add(mi_list);
		mi_list.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				panel.add(new Student());
				panel.setLayout(null);
			}
			
		});
		
		JMenuItem mi_bookRent=new JMenuItem("도서 현황");
		m_book.add(mi_bookRent);
		mi_bookRent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				panel.add(new BookRent());
				panel.setLayout(null);				
			}
			
		});
				
		panel=new JPanel();
		this.add(panel);
		this.setJMenuBar(bar);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Haksa();
	}
	
}
