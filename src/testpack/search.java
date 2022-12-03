package testpack;
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
    public void testfuc(){
        JFrame search = new JFrame();
        search.setSize(600, 320);
        search.setTitle("검색");
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String header[] = {"value1", "value2", "value3", "value4", "value5", "value6"};
        String[] biccate={"액체류", "jhon", "hyosoo", "namyun"};
        String[] smallcate={"탄산", "214", "645", "098"};
        String[] smallcate1={"콜라", "cxv", "aso", "assc"};
        Container sc = getContentPane();
        sc.setLayout(null);
        Container sc1 = getContentPane();
        sc.setLayout(null);
        Container sc2 = getContentPane();
        sc.setLayout(null);
        Container sc3 = getContentPane();
        sc.setLayout(null);

        JLabel mybox1 = new JLabel("큰 카테고리");
        mybox1.setLocation(10, 10);
        mybox1.setSize(70, 30);
        JComboBox cate= new JComboBox(biccate);
        cate.setLocation(90, 10);
        cate.setSize(100, 30);

        JLabel mybox2 = new JLabel("작은 카테고리");
        mybox2.setLocation(200, 10);
        mybox2.setSize(80, 30);
        JComboBox cate2= new JComboBox(smallcate);
        cate2.setLocation(290, 10);
        cate2.setSize(100, 30);

        JLabel mybox3 = new JLabel("제품명");
        mybox3.setLocation(410, 10);
        mybox3.setSize(50, 30);
        JComboBox cate3= new JComboBox(smallcate1);
        cate3.setLocation(460, 10);
        cate3.setSize(100, 30);
        
        DefaultTableModel model = new DefaultTableModel();
        JTable table1 = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table1);

        for(int C = 0; C < 5; C++){
            model.addColumn(header[C]);
        }
        for(int D = 0; D<17; D++)
                model.addRow(new Object[] {});

        scrollPane.setLocation(10, 110);
        scrollPane.setSize(250, 130);

        JLabel myla1 = new JLabel("현 재고");
        JLabel myla2 = new JLabel("판매가");
        JLabel myla3 = new JLabel("발주량");
        JLabel myla4 = new JLabel("행사");

        JTextField filed1 = new JTextField();
        JTextField filed2 = new JTextField();
        JTextField filed3 = new JTextField();
        JTextField filed4 = new JTextField();

        myla1.setLocation(320, 110);
        myla1.setSize(40, 20);
        myla2.setLocation(420, 110);
        myla2.setSize(40, 20);
        myla3.setLocation(320, 150);
        myla3.setSize(40, 20);
        myla4.setLocation(420, 150);
        myla4.setSize(40, 20);

        filed1.setLocation(370, 110);
        filed1.setSize(40, 20);
        filed2.setLocation(470, 110);
        filed2.setSize(40, 20);
        filed3.setLocation(370, 150);
        filed3.setSize(40, 20);
        filed4.setLocation(470, 150);
        filed4.setSize(40, 20);
        
        sc3.add(myla1);
        sc3.add(myla2);
        sc3.add(myla3);
        sc3.add(myla4);

        sc3.add(filed1);
        sc3.add(filed2);
        sc3.add(filed3);
        sc3.add(filed4);

        JButton btn = new JButton("검색");
        btn.setLocation(460, 50);
        btn.setSize(100, 30);

        JButton btn2 = new JButton("확정");
        btn2.setLocation(430, 210);
        btn2.setSize(100, 30);

        sc.add(cate);
        sc.add(cate2);
        sc.add(cate3);
        sc.add(mybox1);
        sc.add(mybox2);
        sc.add(mybox3);
        sc1.add(btn);
        sc1.add(btn2);
        sc2.add(scrollPane);

        search.add(sc);
        search.add(sc1);
        search.add(sc2);
        search.add(sc3);
     
        search.setVisible(true);
        //return true;

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search.setVisible(false);
            }
        });
    }
}