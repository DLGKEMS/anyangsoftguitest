package mainSearchgui.balsu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class orders extends JFrame {
    String delbarcode = "";
    public void order() {
        String stock = "";
        String pname = "";
        String count = "";
        String barcode = "";

        makecon kcon = new makecon();

         String[] header = {"barcode", "product_name", "count"
                , "price", "mainclass"};

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

        jm.add(new JMenuItem("메인"));
        jm.addSeparator();
        jm.add(new JMenuItem("폐기등록"));
        jm.addSeparator();    //메뉴 아이템의 구분선 생성
        jm.add(new JMenuItem("재고"));
        mb.add(jm);

        JLabel stocktablename = new JLabel("재고 테이블");
        stocktablename.setLocation(200, 100);
        stocktablename.setSize(720,20);
        JLabel wearingtablename = new JLabel("발주 테이블");
        wearingtablename.setLocation(200, 340);
        wearingtablename.setSize(720,20);

        String [][] data = makecon.readData();
        DefaultTableModel model = new DefaultTableModel(data,header);
        JTable StockTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(StockTable);

        scrollPane.setLocation(200, 130);
        scrollPane.setSize(720, 200);
/////////////////////////////////////
        DefaultTableModel model1 = new DefaultTableModel();
        JTable table2 = new JTable(model1);
        JScrollPane scrollPane2 = new JScrollPane(table2);

        scrollPane2.setLocation(200, 370);
        scrollPane2.setSize(720, 200);

        JButton searchbtn = new JButton("조회");
        searchbtn.setLocation(20,160);
        searchbtn.setSize(150,30);
        JButton allretouchbtn = new JButton("일괄삭제");
        allretouchbtn.setLocation(20,210);
        allretouchbtn.setSize(150,30);
        JButton retouchbtn = new JButton("삭제");
        retouchbtn.setLocation(20,260);
        retouchbtn.setSize(150,30);

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
        c0.add(searchbtn);
        c0.add(allretouchbtn);
        c0.add(retouchbtn);
        c1.add(scrollPane);
        c1.add(scrollPane2);
        c1.add(stocktablename);
        c1.add(wearingtablename);
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

        searchbtn.addActionListener(new ActionListener() { // 검색 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = makecon.InquireData();
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                table2.setModel(model);
            }
        });

        retouchbtn.addActionListener(new ActionListener() { // 삭제 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = makecon.deleteData(delbarcode);
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                table2.setModel(model);
            }
        });

        StockTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String product[] = new String[6];
                String test = "";
                int row = StockTable.getSelectedRow();
                int col = StockTable.getSelectedColumn();
                for (int i=0;i< StockTable.getColumnCount();i++){
                    product[i] = String.valueOf(StockTable.getModel().getValueAt(row,i));
                    System.out.println(product[i]);
                }
                delbarcode = product[0];

            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        allretouchbtn.addActionListener(new ActionListener() { // 일괄삭제 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = makecon.alldeleteData();
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                table2.setModel(model);
            }
        });

    }

    //public static void main(String[] args) {
    //    new order();
    //}
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

/*
class MyActionListenersearch implements ActionListener {
    public  void actionPerformed(ActionEvent e) {

        ArrayList<Data> arr = new ArrayList<Data>();


        // 전체 출력
        for (int i = 0; i < arr.size(); i++) {

        }
    }
}*/


/*
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

        c0.add(jt);
        myGUI.add(c0);
        */