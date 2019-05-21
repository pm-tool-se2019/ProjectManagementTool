package ScheduleMan;

import javax.swing.*;

// Will use javaFX
class MainFrame extends JFrame {

    private JButton addBtn= new JButton("업무 추가");
    private JButton deleteBtn=new JButton("업무 삭제");
    private JButton updateBtn=new JButton("업무 수정");

    private JPanel jContentPane = null;

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);

            JPanel button_panel = new JPanel();

            button_panel.setBounds(100, 300, 100, 300);
            button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.Y_AXIS));
            jContentPane.add(button_panel);


            button_panel.add(Box.createVerticalStrut(button_panel.getY()/5));
            button_panel.add(addBtn);
            button_panel.add(Box.createVerticalStrut(button_panel.getY()/10));
            button_panel.add(deleteBtn);
            button_panel.add(Box.createVerticalStrut(button_panel.getY()/10));
            button_panel.add(updateBtn);
            button_panel.add(Box.createVerticalStrut(button_panel.getY()/10));
        }
        return jContentPane;
    }
    MainFrame() {
        setTitle("스케쥴 관리");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setContentPane(getJContentPane());  // 전체적인 레이아웃을 다 여기서 정의함.
        add(addBtn);
        add(deleteBtn);
        add(updateBtn);
    }
}

public class ManageGUI {
    /* 테스트용 Main 메소드 */
    public static void main(String[] args)
    {
        MainFrame main_frame=new MainFrame();
    }
}
