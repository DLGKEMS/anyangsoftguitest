package mainSearchgui.balsu;
import java.awt.*;
import javax.swing.*;

public class WeeklyIncome extends JFrame
{
    public void fc()
    {
        JFrame frame = new JFrame("주간 수입 그래프");
        frame.setLocation(500,200);
        frame.setPreferredSize(new Dimension(800,350));
        Container contentPane = frame.getContentPane();

        DrawingPanel drawingPanel = new DrawingPanel();
        contentPane.add(drawingPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //"그래프 그리기" 버튼을 눌렀을때 작동 할 리스터등록
        frame.pack();
        frame.setVisible(true);
    }
}

//그래피를 그리는 패널 클래스

class DrawingPanel extends JPanel
{
    int dey1 = 23000, dey2 = 45, dey3 = 90, dey4 = 100, dey5 = 4, dey6 = 45, dey7 = 83;
    public void paint(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        g.drawLine(50,250,800,250);
        for(int cnt = 1 ;cnt<11;cnt++)
        {
            g.drawString(cnt *10000 +"",5,255-20*cnt);
            g.drawLine(50, 250-20*cnt, 800,250-20*cnt);
        }
        g.drawLine(50,20,50,250);
        g.drawString("월",110,270);
        g.drawString("화",210,270);
        g.drawString("수",310,270);
        g.drawString("목",410,270);
        g.drawString("금",510,270);
        g.drawString("토",610,270);
        g.drawString("일",710,270);
        g.setColor(Color.RED);
        if (dey1>0)
            g.fillRect(110,250-(dey1/1000)*2,10,(dey1/1000)*2);
        if(dey2>0)
            g.fillRect(210,250-dey2*2,10,dey2*2);
        if(dey3>0)
            g.fillRect(310,250-dey3*2,10,dey3*2);
        if (dey4>0)
            g.fillRect(410,250-dey4*2,10,dey4*2);
        if(dey5>0)
            g.fillRect(510,250-dey5*2,10,dey5*2);
        if(dey6>0)
            g.fillRect(610,250-dey6*2,10,dey6*2);
        if(dey7>0)
            g.fillRect(710,250-dey7*2,10,dey7*2);
    }
}

