package testpack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class order extends JFrame {

    private static String dburl = "jdbc:mysql://localhost:3304/connectdb1?serverTimezone=Asia/Seoul&useSSL=false";
    private static String dbUser = "connectuser";
    private static String dbpasswd = "비밀번호";
    public order() {
        
        
        JFrame myGUI = new JFrame();
        myGUI.setSize(960, 720);
        myGUI.setTitle("발주 시스템");
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        Container c0 = getContentPane();
        c.setLayout(null);
        Container c1 = getContentPane();
        c1.setLayout(null);
        Container c2 = getContentPane();
        c2.setLayout(null);
        Container c3 = getContentPane();
        c3.setLayout(null);
        JMenuBar mb = new JMenuBar();
        JMenu jm = new JMenu("목록");
        mb.setLocation(860, 25);
        mb.setSize(50, 40);
        

        String header[] = {"testvalue1", "testvalue2", "testvalue3", "testvalue4", "testvalue5", "testvalue6"};
        String header2[] = {"value1", "value2", "value3", "value4", "value5", "value6"};

        jm.add(new JMenuItem("메인"));
        jm.addSeparator(); 
        jm.add(new JMenuItem("폐기등록"));
        jm.addSeparator();    //메뉴 아이템의 구분선 생성
        jm.add(new JMenuItem("재고"));
        mb.add(jm);

        DefaultMutableTreeNode open = new DefaultMutableTreeNode("열기");
        DefaultMutableTreeNode room = new DefaultMutableTreeNode("바구니");
        DefaultMutableTreeNode op = new DefaultMutableTreeNode("발주 옵션");
        DefaultMutableTreeNode cha = new DefaultMutableTreeNode("발주 수정");
        DefaultMutableTreeNode rm = new DefaultMutableTreeNode("발주 삭제");
        DefaultMutableTreeNode get = new DefaultMutableTreeNode("바구니 추가");

        open.add(room);
        open.add(op);
        op.add(cha);
        op.add(rm);
        op.add(get);
        JTree jt = new JTree(open);
        jt.setLocation(20, 160);
        jt.setSize(170, 420);
        DefaultTableModel model = new DefaultTableModel();
        JTable table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);
        
        DefaultTableModel model2 = new DefaultTableModel();
        JTable table2 = new JTable(model2);
        JScrollPane scrollPane2 = new JScrollPane(table2);

        for(int C = 0; C < 5; C++){
            model.addColumn(header[C]);
        }
        for(int D = 0; D<17; D++)
                model.addRow(new Object[] {});

        scrollPane.setLocation(200, 160);
        scrollPane.setSize(720, 200);

        for(int C = 0; C < 5; C++){
            model2.addColumn(header2[C]);
        }
        for(int D = 0; D<17; D++)
        model2.addRow(new Object[] {});

        scrollPane2.setLocation(200, 380);
        scrollPane2.setSize(720, 200);

        JButton btn = new JButton("취소");
        btn.setLocation(20, 600);
        btn.setSize(100, 20);
        JButton btn1 = new JButton("검색");
        btn1.setLocation(130, 600);
        btn1.setSize(100, 20);
        btn1.addActionListener(new MyActionListener());
        JButton btn3 = new JButton("주간 수입");
        btn3.setLocation(240, 600);
        btn3.setSize(100, 20);
        btn3.addActionListener(new MyActionListener2());
        JButton btn2 = new JButton("확정");
        btn2.setLocation(830, 600);
        btn2.setSize(100, 20);


        c.add(mb);
        c0.add(jt);
        c1.add(scrollPane);
        c1.add(scrollPane2);
        c2.add(btn);
        c3.add(btn1);
        c2.add(btn2);
        c2.add(btn3);
        myGUI.add(c);
        myGUI.add(c0);
        myGUI.add(c1);
        myGUI.add(c2);
        myGUI.add(c3);
        
        myGUI.setVisible(true);

        
    }

    public static void main(String[] args) {
        new order();
    }
}
class MyActionListener implements ActionListener { 
    public void actionPerformed(ActionEvent e) {
        search sr = new search();
        sr.testfuc();
    }
  }

  class MyActionListener2 implements ActionListener { 
    public void actionPerformed(ActionEvent e) {
        WeeklyIncome gr = new WeeklyIncome();
        gr.fc();
    }
  }
