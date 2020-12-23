package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.AccountModel;
import remote.IServer;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginUI extends UnicastRemoteObject implements Remote {

	protected LoginUI() throws RemoteException {
		super();
		initialize();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private static IServer server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 399, 268);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tên đăng nhập:");
		lblNewLabel.setBounds(31, 61, 105, 16);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField("102170075");
		textField.setBounds(148, 58, 183, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1.setBounds(31, 110, 93, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField("123456789");
		textField_1.setBounds(148, 107, 183, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Đăng nhập",JLabel.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(119, 13, 134, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Xóa");
		btnNewButton.setBounds(78, 171, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đăng nhập");
		btnNewButton_1.setBounds(211, 171, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connectSever();
				try {
					String username = textField.getText();
					String password = textField_1.getText();
					AccountModel account = server.login(username, password);
					if(account != null) {
						if(account.getRole().equals("sinhvien")) {
							new UI_Client(account.getId());
						} else if(account.getRole().equals("giangvien")) {
							new UI_ClientGV("UI Giao vien");
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void connectSever() {
		if(server == null) {
			try {
				server = (IServer) Naming.lookup("rmi://localhost:9999/server");
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
