package adminMovieSchedule;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class MovieScheduleDemo extends JPanel
        implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    JTable table = null;
    JTextField edits[] = new JTextField[5];

    adminMovieScheduleMgr mgr = new adminMovieScheduleMgr();

    public MovieScheduleDemo() {
        super(new BorderLayout());
        MovieScheduleTableInit();
        JPanel pane = makeBottomPane();
        add(pane, BorderLayout.PAGE_END);
    }
    void MovieScheduleTableInit() {
        mgr.readAll("movieSchedule.txt");

        final String[] columnNames = {"영화코드번호", "시작 시간", "시작 분", "엔딩 시간", "엔딩 분"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (adminMovieSchedule a : adminMovieScheduleMgr.movieScheduleList)
            tableModel.addRow(a.getTexts());

        table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 220));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
    JPanel makeBottomPane() {
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(2, 1));

        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());
        for (int i = 0; i < 5; i++) {
            edits[i] = new JTextField("", 10);
            center.add(edits[i]);
        }
        JButton editBtn = new JButton("저장");
        editBtn.setActionCommand("Done");
        editBtn.addActionListener(this);
        center.add(editBtn);
        pane.add(center);

        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        JButton buttons[] = new JButton[2];
        String btnTexts[] = {"추가", "삭제"};
        for (int i = 0; i < 2; i++) {
            buttons[i] = new JButton(btnTexts[i]);
            buttons[i].addActionListener(this);
            bottom.add(buttons[i]);
        }
        pane.add(bottom);
        return pane;
    }
    int selectedIndex = -1;
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (!lsm.isSelectionEmpty()) {
            selectedIndex = lsm.getMinSelectionIndex();
        }
    }
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel data = (DefaultTableModel)(table.getModel());
        if (e.getActionCommand().equals("Done")) {

        } else if (e.getActionCommand().equals("추가")) {

        } else if (e.getActionCommand().equals("삭제")) {

        }
    }
}