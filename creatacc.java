package javaFile;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class creatacc extends JFrame {
	ArrayList<String> ds=new ArrayList<String>();
	private JPanel contentPane;
	private JTextField nname;
	private JTextField npass;
	private JTextField rpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public creatacc() {
		setTitle("Đăng Kí Tài Khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setBounds(48, 47, 60, 20);
		contentPane.add(lblName);
		
		JLabel lblPasswold = new JLabel("Password");
		lblPasswold.setBounds(46, 93, 62, 14);
		contentPane.add(lblPasswold);
		
		nname = new JTextField();
		nname.setBounds(181, 47, 158, 20);
		contentPane.add(nname);
		nname.setColumns(10);
		
		npass = new JTextField();
		npass.setBounds(181, 90, 158, 20);
		contentPane.add(npass);
		npass.setColumns(10);
		
		JLabel lblRetypePassword = new JLabel("Retype PassWord");
		lblRetypePassword.setBounds(44, 142, 105, 14);
		contentPane.add(lblRetypePassword);
		
		rpass = new JTextField();
		rpass.setBounds(181, 139, 158, 20);
		contentPane.add(rpass);
		rpass.setColumns(10);
		
		JButton btnngK = new JButton("Đăng Kí");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter f= new FileWriter("account.txt",true);
					PrintWriter ghi=new PrintWriter(f);
					String newname=nname.getText();
					String newpass=npass.getText();
					String repass=rpass.getText();
					if(!repass.equalsIgnoreCase(newpass)) {
						JOptionPane.showMessageDialog(null, "Mật Khẩu Không khớp!!");
					}
					ds.add(newname);
					ds.add(newpass);
					ghi.print(newname);
					ghi.println("|"+repass);
					ghi.close();
					JOptionPane.showMessageDialog(null, "Đăng Kí Thành Công!!");
					setVisible(false); //đóng frame
					dispose();
					
				} 
				catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi Thao Tác vớI DATA");
				}
				
			}
		});
		btnngK.setBounds(144, 196, 176, 23);
		contentPane.add(btnngK);
	}

}
