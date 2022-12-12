package pacDisposal;


import mainSearchgui.balsu.makecon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;


public class Disposal extends JFrame{
    static String delbarcode = "";
    public Disposal(){

        disposalmakecon dmakecon = new disposalmakecon();
        String header[] = {"barcode","product_name","count","price","mainclass"}; // 프레임 생성
        JFrame frm = new JFrame(); // 프레임 제목 설정
        frm.setTitle("폐기 관리"); // 프레임 크기 설정
        frm.setSize(960, 720);
        frm.setLocationRelativeTo(null);    // 프레임을 화면 가운데에 배치
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 프레임을 닫았을 때 메모리에서 제거되도록 설정

        // 레이아웃 설정
        //frm.getContentPane().setLayout(null);

        Container c = getContentPane(); // 버튼
        c.setLayout(null);
        Container c0 = getContentPane(); // 테이블
        c.setLayout(null);
        Container c1 = getContentPane(); // 테이블
        c.setLayout(null);

        // 버튼 생성
        JButton registrationbtn = new JButton("폐기 등록");
        JButton retouchbtn = new JButton("폐기 수정");
        JButton inquirebtn = new JButton("폐기 조회");
        JButton Confirmationbtn = new JButton("확정");

        registrationbtn.setFont(new FontUIResource("고딕", Font.BOLD, 15));
        retouchbtn.setFont(new FontUIResource("고딕", Font.BOLD, 15));
        inquirebtn.setFont(new FontUIResource("고딕", Font.BOLD, 15));
        Confirmationbtn.setFont(new FontUIResource("고딕", Font.BOLD, 15));


        DefaultTableModel model1 = new DefaultTableModel();
        JTable disposaltable = new JTable(model1);
        JScrollPane scrollPane1 = new JScrollPane(disposaltable);

        scrollPane1.setLocation(230, 150);
        scrollPane1.setSize(620,200);

        c0.add(scrollPane1);

        JLabel insertbarcode = new JLabel("바코드");
        insertbarcode.setSize(200,20);
        insertbarcode.setLocation(230,400);
        JLabel insertproductname = new JLabel("상품명");
        insertproductname.setSize(200,20);
        insertproductname.setLocation(440,400);
        JLabel insertcount = new JLabel("개수");
        insertcount.setSize(200,20);
        insertcount.setLocation(650,400);

        JTextField barcodefiled = new JTextField("");
        barcodefiled.setSize(200,40);
        barcodefiled.setLocation(230,440);
        JTextField productnamefiled = new JTextField("");
        productnamefiled.setSize(200,40);
        productnamefiled.setLocation(440,440);
        JTextField countfiled = new JTextField("");
        countfiled.setSize(200,40);
        countfiled.setLocation(650,440);

        JMenuBar mb = new JMenuBar();
        JMenu jm = new JMenu("목록");
        mb.setLocation(860, 25);
        mb.setSize(50, 50);

        jm.add(new JMenuItem("시스템a"));
        jm.addSeparator();
        jm.add(new JMenuItem("시스템b"));
        jm.addSeparator();    //메뉴 아이템의 구분선 생성
        jm.add(new JMenuItem("시스템c"));
        jm.setFont(new FontUIResource("고딕", Font.BOLD, 15));
        mb.add(jm);

        frm.add(mb);

        // 버튼 위치와 크기 설정
        registrationbtn.setBounds(50, 200, 130, 50);
        retouchbtn.setBounds(50, 300, 130, 50);
        inquirebtn.setBounds(50, 400, 130, 50);
        Confirmationbtn.setBounds(430, 570, 70, 70);

        c.add(registrationbtn);
        c.add(retouchbtn);
        c.add(inquirebtn);
        c.add(Confirmationbtn);
        c1.add(insertbarcode);
        c1.add(insertproductname);
        c1.add(insertcount);
        c1.add(barcodefiled);
        c1.add(productnamefiled);
        c1.add(countfiled);
        frm.add(c);
        frm.add(c1);
        // 프레임이 보이도록 설정
        frm.setVisible(true);

        Confirmationbtn.addActionListener(new ActionListener() { // 확정 버튼
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i<disposaltable.getColumnCount();i++) {
                    String getbarcode = (String) disposaltable.getValueAt(i,0);
                    String getcount = (String) disposaltable.getValueAt(i,2);
                    System.out.println(getcount);
                    dmakecon.conf(getbarcode, getcount);
                }
            }
        });

        retouchbtn.addActionListener(new ActionListener() { // 일괄삭제 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = dmakecon.alldeleteData();
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                disposaltable.setModel(model);
            }
        });


        disposaltable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String product = "";
                String test = "";
                int row = disposaltable.getSelectedRow();
                int col = disposaltable.getSelectedColumn();

                product = String.valueOf(disposaltable.getModel().getValueAt(row,0));
                System.out.println(product);
                delbarcode = product;
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



        registrationbtn.addActionListener(new ActionListener() { //등록 버튼
            public void actionPerformed(ActionEvent e) {
                String dbarcode = barcodefiled.getText();
                String dproductname = productnamefiled.getText();
                String dcount = countfiled.getText();

                dmakecon.moveD(dbarcode, dcount);
            }
        });

        inquirebtn.addActionListener(new ActionListener() { // 조회 버튼
            public void actionPerformed(ActionEvent e) {
                String[] header2 = {"barcode", "product_name", "count"
                        , "price", "mainclass"};
                String [][] newdata = disposalmakecon.disposalInquireData();
                DefaultTableModel model = new DefaultTableModel(newdata,header2);
                disposaltable.setModel(model);
            }
        });

    }

    public static void main(String[] args) {
       new Disposal();
    }
}
