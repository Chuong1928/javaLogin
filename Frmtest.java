package javaFile;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Frmtest extends JFrame {
	ArrayList<String> ds=new ArrayList<String>();
	private JPanel contentPane;
	private JTextField cname;
	private JPasswordField cpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmtest frame = new Frmtest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void getdata() {
				try {
					FileReader r= new FileReader("account.txt");
					BufferedReader f= new BufferedReader(r);
					while(true) {
					String st=f.readLine();
					if(st==""||st==null) break;
					ds.add(st);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "LỖI ĐỌC DỮ LIỆU");
				}
		
	}
	/**
	 * Create the frame.
	 */
	public Frmtest() {
		setTitle("ĐĂNG NHẬP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(41, 35, 46, 14);
		contentPane.add(lblName);
		
		cname = new JTextField();
		cname.setBounds(121, 28, 119, 28);
		contentPane.add(cname);
		cname.setColumns(10);
		
		JLabel lblPassworld = new JLabel("PassWorld");
		lblPassworld.setBounds(41, 76, 70, 14);
		contentPane.add(lblPassworld);
		
		JButton cDangnhap = new JButton("Đăng Nhập");
		cDangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getdata();
				String name=cname.getText();
				String pass=cpass.getText();
				int check=0;
				for(int i=0;i<ds.size();i++) {
					String dt[]=ds.get(i).split("[|]");
					if(name.equalsIgnoreCase(dt[0])&&pass.equalsIgnoreCase(dt[1])) {
						JOptionPane.showMessageDialog(null,"Đăng Nhập Thành Công!!");
						check=1;
						break;
					}
				}
				if(check==0) {
					JOptionPane.showMessageDialog(null,"Đăng Nhập Thất Bại!!");
					JOptionPane.showMessageDialog(null,"Hãy Đăng Kí Tài Khoản Mới");
					
				}
				
			}
			
		});
		cDangnhap.setBounds(57, 138, 114, 23);
		contentPane.add(cDangnhap);
		
		cpass = new JPasswordField();
		cpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				getdata();
				String name=cname.getText();
				String pass=cpass.getText();
				int check=0;
				if(e.getKeyCode()==10) {
					for(int i=0;i<ds.size();i++) {
						String dt[]=ds.get(i).split("[|]");
						if(name.equalsIgnoreCase(dt[0])&&pass.equalsIgnoreCase(dt[1])) {
							JOptionPane.showMessageDialog(null,"Đăng Nhập Thành Công!!");
							check=1;
							break;
						}
					}
					if(check==0) {
						JOptionPane.showMessageDialog(null,"Đăng Nhập Thất Bại!!");
						JOptionPane.showMessageDialog(null,"Hãy Đăng Kí Tài Khoản Mới");
					}
					
				}
			}
			
		});
		cpass.setBounds(121, 73, 119, 28);
		contentPane.add(cpass);
		
		JButton dangki = new JButton("Đăng Kí");
		dangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							creatacc frame = new creatacc();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}
		});
		dangki.setBounds(255, 138, 119, 23);
		contentPane.add(dangki);
	}
}
