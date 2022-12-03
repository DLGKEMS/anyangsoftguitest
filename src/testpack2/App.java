package testpack2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class App extends JFrame {
    public JFrame frame;
    // 시재점검 패널에서 사용
    public JTextField cash_reserves;
    public JTextField Pos_money;
    public JTextField result_money;
    String MenuName;
    private JTable cash;
    private JTextField cash_sumtext;
    // 재고관리 패널에서 사용

    public static void main(String[] args) {
        new App();
    }

    public App() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(960, 720);
        frame.setPreferredSize(new Dimension(960, 720));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        // p_cGUI();
        inv_mngGUI();
        // mainGUI();
        frame.setVisible(true);
    }

    public void inv_mngGUI() {
        frame.setTitle("반품관리");
        JPanel Inv_Mng_Panel = new JPanel();
        Inv_Mng_Panel.setLayout(null);
        Inv_Mng_Panel.setSize(960, 720);
        Inv_Mng_Panel.setPreferredSize(new Dimension(960, 720));
        frame.getContentPane().add(Inv_Mng_Panel);
        Inv_Mng_Panel.setVisible(true);
        String MenuBar[] = { "메인", "시재점검" };
        String header[] = { "물품 ID", "물품 명", "재고 수", "금액", "비고"};
        String Cash[][] = {
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
        };

        // ------------------- 재고관리 패널 선언
        JComboBox Main_back = new JComboBox<String>(MenuBar);
        Main_back.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        Main_back.setBounds(854, 20, 80, 40);
        Main_back.setBackground(Color.WHITE);
        JLabel title = new JLabel(" 반품관리");
        title.setFont(new Font("고딕", Font.BOLD, 40));
        title.setBounds(5, 5, 200, 50);
        title.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        
        JButton inv_mng_DataAccess = new JButton("확정");
        inv_mng_DataAccess.setFont(new Font("고딕", Font.BOLD, 21));
        inv_mng_DataAccess.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        inv_mng_DataAccess.setBackground(Color.WHITE);
        inv_mng_DataAccess.setBounds(40, 520, 120, 41);

        JButton inv_mng_DataFailed = new JButton("리셋");
        inv_mng_DataFailed.setFont(new Font("고딕", Font.BOLD, 21));
        inv_mng_DataFailed.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        inv_mng_DataFailed.setBackground(Color.WHITE);
        inv_mng_DataFailed.setBounds(278, 520, 120, 41);

        JButton inv_mng_search = new JButton("검색");
        inv_mng_search.setFont(new Font("고딕", Font.BOLD, 21));
        inv_mng_search.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        inv_mng_search.setBackground(Color.WHITE);
        inv_mng_search.setBounds(408, 520, 120, 41);

        JLabel inv_mng_searchtext = new JLabel("");
        inv_mng_searchtext.setHorizontalAlignment(SwingConstants.RIGHT);
        inv_mng_searchtext.setFont(new Font("Dialog", Font.BOLD, 17));
        inv_mng_searchtext.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        inv_mng_searchtext.setBackground(Color.WHITE);
        inv_mng_searchtext.setForeground(Color.WHITE);
        inv_mng_searchtext.setBounds(527, 520, 379, 41);

        // 테이블 패널
        JPanel inv_table = new JPanel();
        inv_table.setLayout(null);
        inv_table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        inv_table.setBackground(Color.WHITE);
        inv_table.setBounds(40, 101, 867, 396);

        JTable cash = new JTable(Cash, header);
        JScrollPane cash_scroll = new JScrollPane(cash);
        cash.setRowHeight(25);
        cash.getTableHeader().setReorderingAllowed(false);
        cash.getTableHeader().setResizingAllowed(false);
        cash_scroll.setBorder(new LineBorder(Color.GRAY, 2));
        cash_scroll.setFont(new Font("고딕", Font.PLAIN, 20));
        cash_scroll.setBounds(12, 10, 843, 374);

        

        // ------------------- 버튼 이벤트
        Main_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent E) {
                String selectMenu = Main_back.getSelectedItem().toString();
                if (selectMenu.equals("메인")) {
                    Inv_Mng_Panel.setVisible(false);
                    mainGUI();
                    MenuName = selectMenu;
                } else if (selectMenu.equals("시재점검")) {
               Inv_Mng_Panel.setVisible(false);
               p_cGUI();
               MenuName = selectMenu;
           }
            }
        });

        // ------------------- 재고관리 패널 추가
        Inv_Mng_Panel.add(title);
        Inv_Mng_Panel.add(Main_back);
        Inv_Mng_Panel.add(inv_table);
        Inv_Mng_Panel.add(inv_mng_DataAccess);
        Inv_Mng_Panel.add(inv_mng_DataFailed);
        Inv_Mng_Panel.add(inv_mng_search);
        Inv_Mng_Panel.add(inv_mng_searchtext);

        inv_table.add(cash_scroll);

    } // ------------------- 재고관리 패널 종료 -------------------

    protected void p_cGUI() {
    }

    protected void mainGUI() {
    }
}