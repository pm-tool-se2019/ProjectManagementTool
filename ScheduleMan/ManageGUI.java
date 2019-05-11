package ScheduleMan;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {

    private JButton addBtn= new JButton("업무 추가");
    private JButton deleteBtn=new JButton("업무 삭제");
    private JButton updateBtn=new JButton("업무 수정");

    MainFrame() {
        setTitle("스케쥴 관리");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new GridLayout(6, 6, 1, 1));
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
