package mainSearchgui.balsu;

import javax.swing.*;
//import javax.swing.event.TreeSelectionEvent;
//import javax.swing.event.TreeSelectionListener;
//import javax.swing.plaf.FontUIResource;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.*;
public class search extends JFrame{
    static int boxindex = 0;
    static String biccase = "";
    String barcode = "";
    String count = "";
    public void testfuc(){
        makecon kcon = new makecon();
        JFrame search = new JFrame();
        search.setSize(600, 320);
        search.setTitle("검색");
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] header = {"barcode", "product_name", "count"
                , "price", "mainclass", "subclass"};
        String[] biccate={"음료", "식품"};

        String[] smallcate1={"과자", "빵", "샌드위치"};

        Container sc = getContentPane();
        sc.setLayout(null);
        Container sc1 = getContentPane();
        sc.setLayout(null);
        Container sc2 = getContentPane();
        sc.setLayout(null);
        Container sc3 = getContentPane();
        sc.setLayout(null);

        //String [] box1 = makecon.searchData(1);
        JLabel mybox1 = new JLabel("큰 카테고리");
        mybox1.setLocation(10, 10);
        mybox1.setSize(70, 30);
        JComboBox cate= new JComboBox(biccate);
        cate.setLocation(90, 10);
        cate.setSize(100, 30);

        JLabel mybox3 = new JLabel("제품명");
        mybox3.setLocation(250, 10);
        mybox3.setSize(50, 30);
        JTextField cate3 = new JTextField("");
        cate3.setLocation(310, 10);
        cate3.setSize(100, 30);

        cate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource(); // 콤보박스 알아내기

                int index = cb.getSelectedIndex();// 선택된 아이템의 인덱스
                biccase = biccate[index];
                System.out.println(biccate[index]); // 인덱스의 이미지를 이미지 레이블에 출력
            }
        });

        String [][] data = makecon.readData();
        DefaultTableModel model = new DefaultTableModel(data, header);
        JTable table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);

        scrollPane.setLocation(10, 110);
        scrollPane.setSize(350, 130);

        JLabel myla1 = new JLabel("현재고");
        JLabel myla2 = new JLabel("발주량");
        JLabel myla3 = new JLabel("상품명");


        JTextField filed1 = new JTextField("null");
        JTextField filed2 = new JTextField();
        JTextField filed3 = new JTextField("null");


        myla1.setLocation(370, 110);
        myla1.setSize(40, 20);
        myla2.setLocation(470, 110);
        myla2.setSize(40, 20);
        myla3.setLocation(370, 150);
        myla3.setSize(40, 20);

        filed1.setLocation(420, 110);
        filed1.setSize(40, 20);
        filed2.setLocation(520, 110);
        filed2.setSize(40, 20);
        filed3.setLocation(420, 150);
        filed3.setSize(100, 20);

        sc3.add(myla1);
        sc3.add(myla2);
        sc3.add(myla3);

        sc3.add(filed1);
        sc3.add(filed2);
        sc3.add(filed3);

        JButton btn = new JButton("검색");
        btn.setLocation(460, 10);
        btn.setSize(100, 30);

        JButton btn2 = new JButton("확정");
        btn2.setLocation(420, 210);
        btn2.setSize(60, 30);

        JButton exitbtn = new JButton("나가기");
        exitbtn.setLocation(490, 210);
        exitbtn.setSize(80, 30);

        sc.add(cate);
        sc.add(cate3);
        sc.add(mybox1);
        sc.add(mybox3);
        sc1.add(btn);
        sc1.add(btn2);
        sc1.add(exitbtn);
        sc2.add(scrollPane);

        search.add(sc);
        search.add(sc1);
        search.add(sc2);
        search.add(sc3);

        search.setVisible(true);
        //return true;

        table1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String product[] = new String[6];
                int row = table1.getSelectedRow();
                int col = table1.getSelectedColumn();
                for (int i=0;i< table1.getColumnCount();i++){
                    product[i] = String.valueOf(table1.getModel().getValueAt(row,i));
                    System.out.println(product[i]);
                }
                barcode = product[0];
                filed1.setText(product[2]);
                filed3.setText(product[1]);
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

        exitbtn.addActionListener(new ActionListener() { //나가기 버튼
            public void actionPerformed(ActionEvent e) {
                search.setVisible(false);
            }
        });

        btn2.addActionListener(new ActionListener() { //확정 버튼
            public void actionPerformed(ActionEvent e) {
                count = filed2.getText();
                makecon.moveW(barcode, count);
            }
        });

        btn.addActionListener(new ActionListener() { // 검색 버튼
            public void actionPerformed(ActionEvent e) {
                String pname = cate3.getText();
                System.out.println(pname);
                System.out.println(biccase);
                String [][] newdata = makecon.searchData(pname,biccase);
                DefaultTableModel model = new DefaultTableModel(newdata,header);
                table1.setModel(model);

            }
        });
    }
}
