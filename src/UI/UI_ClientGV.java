package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.StudentInforModel;
import model.StudentModel;
import model.SubjectModel;
import model.TeacherModel;
import remote.IServer;

public class UI_ClientGV extends JFrame implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbTitle, lbSearch, lbSubject, lbResult;
	private JComboBox<String> cbx;
	private SubjectModel subjectModel;
	private StudentModel studentModel;
//	private List<PointModel> points;
	private String[] items;
	private JTextField txt;
	private JButton btn1, btn2, btn3, btn4, btnDetail;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private String[] columnNames = { "MSSV", "Họ Tên", "Ngày sinh", "Lớp", "Môn học", "Điểm BT", "Điểm GK", "Điểm CK",
			"Điểm TB"};
	private IServer server;
	private TeacherModel teacherModel;
	private List<StudentInforModel> studentInfors;
	private long id;
	private List<SubjectModel> subjects;
	
	public UI_ClientGV(Long id) {
		this.id = id;
		teacherModel = getTeacher(id);
		if (teacherModel != null) {
			setTitle("Xin chào giáo viên " + teacherModel.getHoten());
		}
		studentInfors = getStudentInforsList(id);
		subjects = getSubjectsList(id);
		GUI();
		setBounds(300, 100, 800, 450);
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

		/*
		 * lbSubject = new JLabel("Môn học:"); lbSubject.setBounds(5, 57, 94, 14);
		 * contentPane.add(lbSubject);
		 * 
		 * cbx = new JComboBox<>(items); cbx.setBounds(100, 57, 89, 20);
		 * contentPane.add(cbx);
		 */

		lbSearch = new JLabel("Nhập nội dung:");
		lbSearch.setBounds(5, 94, 83, 14);
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
		
		btn3 = new JButton("Xóa");
		btn3.setBounds(590, 88, 89, 23);
		contentPane.add(btn3);
		
		btn4 = new JButton("Cập nhật");
		btn4.setBounds(690, 88, 89, 23);
		contentPane.add(btn4);

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setBounds(1, 122, 780, 202);
		contentPane.add(scroll);
		configTable();

		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.green);

		lbResult = new JLabel("");
		lbResult.setBounds(10, 335, 400, 14);
		contentPane.add(lbResult);

		btn1.addActionListener(this);
		btn2.addActionListener(this);

//		cbx.addItemListener(this);

		// btnDetail = new JButton("Xem chi tiết");
		// btnDetail.setBounds(464, 331, 109, 23);
		// contentPane.add(btnDetail);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				connectSever();
				String searchData = txt.getText().trim().toLowerCase();
				studentInfors = getStudentInforsList(id, searchData);
				model = new DefaultTableModel();
				configTable();
				table.setModel(model);
			}
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
//				System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRows().length == 0) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn hàng nào!");
				} else {
					int input = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa hàng vừa chọn?");
					if(input == 0) {

						System.out.println(input);
						for(int i : table.getSelectedRows()) {
							delete(i);
						}
						model = new DefaultTableModel();
						String searchData = txt.getText();
						studentInfors = getStudentInforsList(id, searchData);
						configTable();
						table.setModel(model);
					}
				}
			}
		});
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				System.out.println("Column: " + e.getColumn() + " Row: " + e.getFirstRow());
			}
		});
	}

	private void configTable() {
		model.setColumnIdentifiers(columnNames);

		if (studentInfors != null) {
			for (StudentInforModel s : studentInfors) {
				model.addRow(new Object[] { s.getUsername(), s.getStudentName(), s.getBirthday(), s.getClassName(),
						s.getSubjectName(), s.getHomeworkPoint(), s.getMidTermPoint(), s.getEndTermPoint(),
						s.getAveragePoint() });
			}
		}

		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
		}

		if (e.getSource() == btn2) {
			txt.setText("");
			lbResult.setText("");
		}
	}

	public static void main(String[] args) {
		new UI_ClientGV(2L);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
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

	private List<StudentInforModel> getStudentInforsList(Long gvID) {
		connectSever();
		if (server == null)
			return null;
		try {
			return server.getStudentInforsList(gvID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<SubjectModel> getSubjectsList(Long gvID) {
		connectSever();
		if (server == null)
			return null;
		try {
			return server.findAllByGVID(gvID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	private List<StudentInforModel> getStudentInforsList(Long gvID, String searchData) {
		connectSever();
		if (server == null)
			return null;
		try {
			return server.getStudentInforsListBysearchData(gvID, searchData);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	private TeacherModel getTeacher(Long gvId) { // lỗi
		connectSever();
		if (server == null)
			return null;
		try {
			return server.getTeacher(gvId);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void delete(int i) {
		try {
			if(server == null) {
				
			} else {
				server.deletePoint(studentInfors.get(i).getId());
			}
		} catch (RemoteException e) {
			// TODO: handle exception
		}
	}
	
	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
    { 
  
        // Create a new ArrayList 
        ArrayList<T> newList = new ArrayList<T>(); 
  
        // Traverse through the first list 
        for (T element : list) { 
  
            // If this element is not present in newList 
            // then add it 
            if (!newList.contains(element)) { 
  
                newList.add(element); 
            } 
        } 
  
        // return the new list 
        return newList; 
    } 
}
