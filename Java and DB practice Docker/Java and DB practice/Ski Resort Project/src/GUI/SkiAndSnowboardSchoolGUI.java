package GUI;

import resortInfo.SkiAndSnowboardSchool;
import utillity.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SkiAndSnowboardSchoolGUI{

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    int id;
    JPanel skiAndSnowboardSchoolPanel = new JPanel((new GridLayout(3, 1)));
    JPanel skiAndSnowboardSchoolUpPanel = new JPanel(new GridLayout(7, 1));
    JPanel skiAndSnowboardSchoolMidPanel = new JPanel(new GridLayout(1, 4));
    JPanel skiAndSnowboardSchoolBottomPanel = new JPanel(new GridLayout(1, 1));

    JTable infoTable = new JTable();
    JScrollPane sprScroll = new JScrollPane(infoTable);

    JLabel clientNamesLabel = new JLabel("Имена на клиента");
    JComboBox clientNamesCombo = new JComboBox<>();

    JLabel instructorNamesLabel = new JLabel("Имена на инструктора");
    JComboBox instructorNamesCombo = new JComboBox<>();

    JLabel lessonsTypeLabel = new JLabel("Тип на урока");
    JComboBox lessonsTypeCombo = new JComboBox();

    JLabel lessonValidityLabel = new JLabel("Часове на урока");
    JTextField lessonValidityTf = new JTextField();

    JPanel addLessonButtonPanel = new JPanel();
    JPanel removeLessonButtonPanel = new JPanel();
    JPanel editLessonButtonPanel = new JPanel();
    JPanel refreshLessonsButtonPanel = new JPanel();

    JButton addLessonButton = new JButton("Добави");
    JButton removeLessonButton = new JButton("Изтрий");
    JButton editLessonButton = new JButton("Редактирай");
    JButton refreshLessonButton = new JButton("Обнови");

    public SkiAndSnowboardSchoolGUI() {

        addLessonButton.addActionListener(new AddLessonAction());
        addLessonButtonPanel.add(addLessonButton);

        removeLessonButton.addActionListener(new RemoveLessonAction());
        removeLessonButtonPanel.add(removeLessonButton);

        editLessonButton.addActionListener(new EditLessonAction());
        editLessonButtonPanel.add(editLessonButton);

        refreshLessonButton.addActionListener(new RefreshAction());
        refreshLessonsButtonPanel.add(refreshLessonButton);

        skiAndSnowboardSchoolUpPanel.add(clientNamesLabel);
        skiAndSnowboardSchoolUpPanel.add(clientNamesCombo);
        skiAndSnowboardSchoolUpPanel.add(instructorNamesLabel);
        skiAndSnowboardSchoolUpPanel.add(instructorNamesCombo);
        skiAndSnowboardSchoolUpPanel.add(lessonsTypeLabel);
        skiAndSnowboardSchoolUpPanel.add(lessonsTypeCombo);
        skiAndSnowboardSchoolUpPanel.add(lessonValidityLabel);
        skiAndSnowboardSchoolUpPanel.add(lessonValidityTf);

        skiAndSnowboardSchoolMidPanel.add(addLessonButtonPanel);
        skiAndSnowboardSchoolMidPanel.add(removeLessonButtonPanel);
        skiAndSnowboardSchoolMidPanel.add(editLessonButtonPanel);
        skiAndSnowboardSchoolMidPanel.add(refreshLessonsButtonPanel);

        skiAndSnowboardSchoolBottomPanel.add(sprScroll);

        skiAndSnowboardSchoolPanel.add(skiAndSnowboardSchoolUpPanel);
        skiAndSnowboardSchoolPanel.add(skiAndSnowboardSchoolMidPanel);
        skiAndSnowboardSchoolPanel.add(skiAndSnowboardSchoolBottomPanel);

        infoTable.addMouseListener(new MouseAction());

        refreshClientNamesCombo();
        refreshInstructorNamesCombo();
        refreshLessonsTypeTypeCombo();

        refreshTable();

    }
    SkiAndSnowboardSchool skiAndSnowboardSchool=new SkiAndSnowboardSchool();
    public void clearForm() {
        clientNamesCombo.setSelectedIndex(0);
        instructorNamesCombo.setSelectedIndex(0);
        lessonsTypeCombo.setSelectedIndex(0);
        lessonValidityTf.setText("");
    }

    public void refreshClientNamesCombo() {
        clientNamesCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select client_id, fname, sname, lname from CLIENTS";
        String item = "";
        clientNamesCombo.addItem("");

        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                item = result.getObject(1).toString() + ". "
                        + result.getObject(2).toString() + " "
                        + result.getObject(3).toString() + " "
                        + result.getObject(4).toString();
                clientNamesCombo.addItem(item);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void refreshInstructorNamesCombo() {
        instructorNamesCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select employee_id, fname, sname, lname from EMPLOYEES";
        String item = "";
        instructorNamesCombo.addItem("");

        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                item = result.getObject(1).toString() + ". "
                        + result.getObject(2).toString() + " "
                        + result.getObject(3).toString() + " "
                        + result.getObject(4).toString();

                instructorNamesCombo.addItem(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void refreshLessonsTypeTypeCombo() {
        lessonsTypeCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select ski_and_snowboard_lessons_type_id, ski_and_snowboard_lessons_type_name from SKI_AND_SNOWBOARD_LESSONS_TYPE";
        String item = "";
        lessonsTypeCombo.addItem("");

        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                item = result.getObject(1).toString()+". "
                        + result.getObject(2).toString();
                lessonsTypeCombo.addItem(item);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void refreshTable() {

        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("SELECT SASS.SKI_AND_SNOWBOARD_SCHOOL_RECEIPT_ID,C.CLIENT_ID, CONCAT(C.FNAME,' ',C.SNAME,' ',C.LNAME) AS КЛИЕНТ, EMP.EMPLOYEE_ID,CONCAT(EMP.FNAME,' ',EMP.SNAME,' ',EMP.LNAME) AS ИНСТРУКТОР,SASS.SKI_AND_SNOWBOARD_SCHOOL_LESSONS_TYPE_ID,SASLT.SKI_AND_SNOWBOARD_LESSONS_TYPE_NAME AS ТИП, SASS.SKI_AND_SNOWBOARD_SCHOOL_VALIDITY AS ВРЕМЕТРАЕНЕ FROM CLIENTS AS C, EMPLOYEES AS EMP, SKI_AND_SNOWBOARD_SCHOOL AS SASS, SKI_AND_SNOWBOARD_LESSONS_TYPE AS SASLT WHERE SASS.SKI_AND_SNOWBOARD_SCHOOL_LESSONS_CLIENT_ID=C.CLIENT_ID AND SASS.SKI_AND_SNOWBOARD_SCHOOL_LESSONS_INSTRUCTOR_ID=EMP.EMPLOYEE_ID AND SASS.SKI_AND_SNOWBOARD_SCHOOL_LESSONS_TYPE_ID=SASLT.SKI_AND_SNOWBOARD_LESSONS_TYPE_ID");
            result = state.executeQuery();
            infoTable.setModel(new InfoTable(result));

            infoTable.getColumnModel().getColumn(1).setMinWidth(0);
            infoTable.getColumnModel().getColumn(1).setMaxWidth(0);
            infoTable.getColumnModel().getColumn(1).setWidth(0);

            infoTable.getColumnModel().getColumn(3).setMinWidth(0);
            infoTable.getColumnModel().getColumn(3).setMaxWidth(0);
            infoTable.getColumnModel().getColumn(3).setWidth(0);

            infoTable.getColumnModel().getColumn(5).setMinWidth(0);
            infoTable.getColumnModel().getColumn(5).setMaxWidth(0);
            infoTable.getColumnModel().getColumn(5).setWidth(0);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    class MouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = infoTable.getSelectedRow();
            id = Integer.parseInt(infoTable.getValueAt(row, 0).toString());
            clientNamesCombo.setSelectedIndex(Integer.parseInt(infoTable.getValueAt(row, 0).toString()));
            instructorNamesCombo.setSelectedIndex(Integer.parseInt(infoTable.getValueAt(row, 3).toString()));
            lessonsTypeCombo.setSelectedIndex(Integer.parseInt(infoTable.getValueAt(row, 5).toString()));
            lessonValidityTf.setText(infoTable.getValueAt(row, 7).toString());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    class AddLessonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            skiAndSnowboardSchool.setSkiAndSnowboardSchoolID(id);
            skiAndSnowboardSchool.setClientFullName(clientNamesCombo.getSelectedItem().toString());
            skiAndSnowboardSchool.setInstructorFullName(instructorNamesCombo.getSelectedItem().toString());
            skiAndSnowboardSchool.setLessonType(lessonsTypeCombo.getSelectedItem().toString());
            skiAndSnowboardSchool.setLessonValidity(Integer.parseInt(lessonValidityTf.getText()));

            conn= DBConnection.getConnection();
            if(!clientNamesCombo.getSelectedItem().toString().isEmpty()) {
                String sql="insert into SKI_AND_SNOWBOARD_SCHOOL(SKI_AND_SNOWBOARD_SCHOOL_LESSONS_CLIENT_ID, SKI_AND_SNOWBOARD_SCHOOL_LESSONS_INSTRUCTOR_ID, SKI_AND_SNOWBOARD_SCHOOL_LESSONS_TYPE_ID, SKI_AND_SNOWBOARD_SCHOOL_VALIDITY) values(?,?,?,?)";

                try {
                    state=conn.prepareStatement(sql);

                    state.setInt(1,Integer.parseInt(skiAndSnowboardSchool.getClientFullName().substring(0,skiAndSnowboardSchool.getClientFullName().indexOf("."))));
                    state.setInt(2,Integer.parseInt(skiAndSnowboardSchool.getInstructorFullName().substring(0,skiAndSnowboardSchool.getInstructorFullName().indexOf("."))));
                    state.setInt(3, Integer.parseInt(skiAndSnowboardSchool.getLessonType().substring(0,skiAndSnowboardSchool.getLessonType().indexOf("."))));
                    state.setInt(4, skiAndSnowboardSchool.getLessonValidity());

                    state.execute();
                    refreshTable();
                    refreshClientNamesCombo();
                    refreshInstructorNamesCombo();
                    clearForm();

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


                id=-1;
            }
        }
    }

            class RemoveLessonAction implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    conn = DBConnection.getConnection();

                    if (id > 0) {
                        String sql = "delete from SKI_AND_SNOWBOARD_SCHOOL where ski_and_snowboard_school_receipt_id=?";
                        try {
                            state = conn.prepareStatement(sql);
                            state.setInt(1, id);
                            state.execute();

                            refreshTable();
                            refreshClientNamesCombo();
                            refreshInstructorNamesCombo();
                            clearForm();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                        id = -1;
                    }

                }

            }

            class EditLessonAction implements ActionListener {
                public void actionPerformed(ActionEvent arg0) {

                    skiAndSnowboardSchool.setSkiAndSnowboardSchoolID(id);
                    skiAndSnowboardSchool.setClientFullName(clientNamesCombo.getSelectedItem().toString());
                    skiAndSnowboardSchool.setInstructorFullName(instructorNamesCombo.getSelectedItem().toString());
                    skiAndSnowboardSchool.setLessonType(lessonsTypeCombo.getSelectedItem().toString());
                    skiAndSnowboardSchool.setLessonValidity(Integer.parseInt(lessonValidityTf.getText()));

                    if (id > 0) {
                        String sql = "update SKI_AND_SNOWBOARD_SCHOOL set ski_and_snowboard_school_lessons_client_id=?, ski_and_snowboard_school_lessons_instructor_id=?, ski_and_snowboard_school_lessons_type_id=?, ski_and_snowboard_school_validity=? where ski_and_snowboard_school_receipt_id=?";

                        try {
                            state = conn.prepareStatement(sql);

                            state.setInt(1, Integer.parseInt(skiAndSnowboardSchool.getClientFullName().substring(0,skiAndSnowboardSchool.getClientFullName().indexOf("."))));
                            state.setInt(2, Integer.parseInt(skiAndSnowboardSchool.getInstructorFullName().substring(0,skiAndSnowboardSchool.getInstructorFullName().indexOf("."))));
                            state.setInt(3, Integer.parseInt(skiAndSnowboardSchool.getLessonType().substring(0,skiAndSnowboardSchool.getLessonType().indexOf("."))));
                            state.setInt(4, skiAndSnowboardSchool.getLessonValidity());
                            state.setInt(5, skiAndSnowboardSchool.getSkiAndSnowboardSchoolID());
                            state.execute();

                            refreshTable();
                            refreshClientNamesCombo();
                            refreshInstructorNamesCombo();
                            clearForm();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }


                    }

                }
            }

            class RefreshAction implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {

                    refreshTable();
                    refreshClientNamesCombo();
                    refreshInstructorNamesCombo();
                }
    }
}



