package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.SubjectModel;

public class UI_ClientGV extends JFrame implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JLabel lbTitle, lbSearch, lbSubject, lbResult;
    private JComboBox<String> cbx;
    private SubjectModel subjectModel;
    private String[] items = {"Công nghệ web", "Java"};
    private JTextField txt;
    private JButton btn1, btn2, btnDetail;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private String[] columnNames = {"STT", "Họ Tên", "Ngày sinh", "Lớp", "Điểm BT", "Điểm GK","Điểm CK","Chức năng"};
    

    public UI_ClientGV(String title) {
        super(title);
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

        
       

        lbSubject = new JLabel("Môn học:");
        lbSubject.setBounds(5, 57, 94, 14);
        contentPane.add(lbSubject);

        cbx = new JComboBox<>(items);
        cbx.setBounds(100, 57, 89, 20);
        contentPane.add(cbx);
       

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

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // all cells false
                return false;
            }
        };
        table = new JTable(model);
        scroll = new JScrollPane(table);
        scroll.setBounds(1, 122, 584, 202);
        contentPane.add(scroll);
        configTable();

        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.green);

        lbResult = new JLabel("");
        lbResult.setBounds(10, 335, 400, 14);
        contentPane.add(lbResult);

       

        btn1.addActionListener(this);
        btn2.addActionListener(this);
     
        cbx.addItemListener(this);
        
        btnDetail = new JButton("Xem chi tiết");
        btnDetail.setBounds(464, 331, 109, 23);
        contentPane.add(btnDetail);
      
    }

   

    private void configTable() {
        model.setColumnIdentifiers(columnNames);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(200);
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
        new UI_ClientGV("Kết quả học tập của sinh viên");
    }

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
