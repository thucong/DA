package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.AccountModel;
import model.PointModel;
import model.StudentModel;
import remote.IServer;

public class UI_Client extends JFrame {
	private static IServer server;
	private AccountModel account;
	private StudentModel studentModel;
	private List<PointModel> points;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbTitle, lbSearch, lbResult;
	private JTextField txt;
	private JButton btn1, btn2, btnDetail;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private String[] columnNames = { "Tên môn học", "Điểm BT", "Điểm GK", "Điểm Thi", "TB Điểm" };

	public UI_Client(Long id) {
		studentModel = getStudentInfor(id);
		if (studentModel != null) {
			setTitle("Xin chào " + studentModel.getHoten());
		}
		points = getPointsList(id);
		GUI();
		setBounds(300, 100, 600, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	private void GUI() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbTitle = new JLabel("KẾT QUẢ HỌC TẬP");
		lbTitle.setBounds(200, 15, 450, 20);
		lbTitle.setFont(new Font("Serif", Font.BOLD, 20));
		lbTitle.setForeground(Color.RED);
		contentPane.add(lbTitle);

		lbSearch = new JLabel("Nhập nội dung:");
		lbSearch.setBounds(10, 94, 83, 14);
		contentPane.add(lbSearch);

		txt = new JTextField();
		txt.setBounds(98, 91, 273, 20);
		contentPane.add(txt);
		txt.setColumns(10);

		btn1 = new JButton("Tìm kiếm");
		btn1.setBounds(385, 88, 89, 23);
		contentPane.add(btn1);

		btn2 = new JButton("Reset");
		btn2.setBounds(484, 88, 89, 23);
		contentPane.add(btn2);

		btnDetail = new JButton("Xem chi tiết");
		btnDetail.setBounds(464, 331, 109, 23);
		contentPane.add(btnDetail);

		model = new DefaultTableModel() {
			Class[] types = new Class[] {
					// COL. TYPES ARE HERE!!!
					java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class,
					java.lang.Double.class };

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		};

		table = new JTable();
		table.setModel(model);
		scroll = new JScrollPane(table);
		scroll.setBounds(1, 122, 584, 202);
		contentPane.add(scroll);
		configTable();

		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.green);

		lbResult = new JLabel("");
		lbResult.setBounds(10, 335, 400, 14);
		contentPane.add(lbResult);

		btnDetail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connectSever();
				Long id_user = account.getId();
				try {
					StudentModel student = server.getStudentInfor(id_user);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void connectSever() {
		if (server == null) {
			try {
				server = (IServer) Naming.lookup("rmi://localhost:9999/server");
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void configTable() {
		model.setColumnIdentifiers(columnNames);
		if (points != null) {
			for (PointModel p : points) {
				p.setAveragePoint();
				model.addRow(new Object[] { p.getSubjectName(), p.getHomeworkPoint(), p.getMidTermPoint(),
						p.getEndTermPoint(), p.getAveragePoint() });
			}
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(220);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
	}

	private List<PointModel> getPointsList(Long userId) {
		connectSever();
		if (server == null)
			return null;
		try {
			return server.getPointsList(userId);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	private StudentModel getStudentInfor(Long userId) {
		connectSever();
		if (server == null)
			return null;
		try {
			return server.getStudentInfor(userId);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		new UI_Client(1L);
	}
}
