package GUI;

import resortInfo.Employee;
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

public class EmployeesGUI {

    Connection conn=null;
    PreparedStatement state=null;
    ResultSet result=null;
    int id;
    JPanel employeesPanel =new JPanel((new GridLayout(3,1)));
    JPanel employeesUpPanel =new JPanel(new GridLayout(7,1));
    JPanel employeesMidPanel =new JPanel(new GridLayout(1,4));
    JPanel employeesBottomPanel =new JPanel(new GridLayout(1,1));

    JTable infoTable=new JTable();
    JScrollPane sprScroll=new JScrollPane(infoTable);

    JLabel employeesFirstNameLabel =new JLabel("Име на служител");
    JTextField employeesFirstNameF=new JTextField();

    JLabel employeesSecondNameLabel=new JLabel("Презиме на служител");
    JTextField employeesSecondNameF=new JTextField();

    JLabel employeesLastNameLabel=new JLabel("Фамилия на служител");
    JTextField employeesLastNameF=new JTextField();
    JLabel employeesPositionLabel=new JLabel("Длъжност на служител");

   // String positions[]={"","Ски учител","Сноуборд учител","Касиер","ПВЛ оператор","МУС оператор"};
    //JComboBox employeesPositionsCombo=new JComboBox(positions);
   JComboBox employeesPositionsCombo=new JComboBox();

    JComboBox instructorNamesCombo=new JComboBox<>();
    JPanel addEmployeesButtonPanel=new JPanel();
    JPanel removeEmployeesButtonPanel=new JPanel();
    JPanel editEmployeesButtonPanel=new JPanel();
    JPanel refreshEmployeesButtonPanel=new JPanel();
    JButton addEmployeesButton = new JButton("Добави");
    JButton removeEmployeesButton = new JButton("Изтрий");
    JButton editEmployeesButton = new JButton("Редактирай");
    JButton refreshEmployeesButton = new JButton("Обнови");
    public EmployeesGUI() {

        addEmployeesButton.addActionListener(new AddEmployeeAction());
        addEmployeesButtonPanel.add(addEmployeesButton);

        removeEmployeesButton.addActionListener(new RemoveEmployeeAction());
        removeEmployeesButtonPanel.add(removeEmployeesButton);

        editEmployeesButton.addActionListener(new EditEmployeeAction());
        editEmployeesButtonPanel.add(editEmployeesButton);

        refreshEmployeesButton.addActionListener(new RefreshAction());
        refreshEmployeesButtonPanel.add(refreshEmployeesButton);

        employeesUpPanel.add(employeesFirstNameLabel);
        employeesUpPanel.add(employeesFirstNameF);
        employeesUpPanel.add(employeesSecondNameLabel);
        employeesUpPanel.add(employeesSecondNameF);
        employeesUpPanel.add(employeesLastNameLabel);
        employeesUpPanel.add(employeesLastNameF);
        employeesUpPanel.add(employeesPositionLabel);
        employeesUpPanel.add(employeesPositionsCombo);

        employeesMidPanel.add(addEmployeesButtonPanel);
        employeesMidPanel.add(removeEmployeesButtonPanel);
        employeesMidPanel.add(editEmployeesButtonPanel);
        employeesMidPanel.add(refreshEmployeesButtonPanel);

        employeesBottomPanel.add(sprScroll);

        employeesPanel.add(employeesUpPanel);
        employeesPanel.add(employeesMidPanel);
        employeesPanel.add(employeesBottomPanel);

        infoTable.addMouseListener(new MouseAction());
        refreshTable();
        refreshEmployeesPositionTypeCombo();
    }
        Employee employee=new Employee();

    public void clearForm() {
        employeesFirstNameF.setText("");
        employeesSecondNameF.setText("");
        employeesLastNameF.setText("");
        employeesPositionsCombo.setSelectedIndex(0);
    }

    public void refreshTable() {

        conn= DBConnection.getConnection();
        try {
            state=conn.prepareStatement("SELECT E.EMPLOYEE_ID,E.FNAME,E.SNAME,E.LNAME,SRD.SKI_RESORT_DEPARTMENT_ID,SRD.SKI_RESORT_DEPARTMENT_NAME FROM EMPLOYEES AS E,SKI_RESORT_DEPARTMENTS AS SRD WHERE SRD.SKI_RESORT_DEPARTMENT_ID=E.EMPLOYEE_DEPARTMENT_ID");
            result=state.executeQuery();
            infoTable.setModel(new InfoTable(result));

            infoTable.getColumnModel().getColumn(4).setMinWidth(0);
            infoTable.getColumnModel().getColumn(4).setMaxWidth(0);
            infoTable.getColumnModel().getColumn(4).setWidth(0);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void refreshCombo() {
        instructorNamesCombo.removeAllItems();
        conn=DBConnection.getConnection();
        String sql="select employee_id, fname, sname, lname from employees";
        String item="";
        instructorNamesCombo.addItem("");
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            while(result.next()) {
                item=result.getObject(1).toString()+". "
                        +result.getObject(2).toString()+" "
                        +result.getObject(3).toString()+" "
                        +result.getObject(4).toString();
                instructorNamesCombo.addItem(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void refreshEmployeesPositionTypeCombo() {
        employeesPositionsCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select ski_resort_department_id, ski_resort_department_name from ski_resort_departments";
        String item = "";
        employeesPositionsCombo.addItem("");

        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                item = result.getObject(1).toString() +". "
                        + result.getObject(2).toString();
                employeesPositionsCombo.addItem(item);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    class MouseAction implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = infoTable.getSelectedRow();
            id = Integer.parseInt(infoTable.getValueAt(row, 0).toString());
            employeesFirstNameF.setText(infoTable.getValueAt(row, 1).toString());
            employeesSecondNameF.setText(infoTable.getValueAt(row, 2).toString());
            employeesLastNameF.setText(infoTable.getValueAt(row, 3).toString());
            employeesPositionsCombo.setSelectedIndex(Integer.parseInt((infoTable.getValueAt(row, 4).toString())));

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
    class AddEmployeeAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            employee.setEmployeeID(id);
            employee.setEmployeeFirstName(employeesFirstNameF.getText());
            employee.setEmployeeSecondName(employeesSecondNameF.getText());
            employee.setEmployeeLastName(employeesLastNameF.getText());
            employee.setEmployeePosition(employeesPositionsCombo.getSelectedItem().toString());

            conn= DBConnection.getConnection();
            if(!employeesFirstNameF.getText().isEmpty()) {
                String sql="insert into employees(fname, sname, lname, employee_department_id) values(?,?,?,?)";

                try {
                    state=conn.prepareStatement(sql);
                    state.setString(1, employee.getEmployeeFirstName());
                    state.setString(2, employee.getEmployeeSecondName());
                    state.setString(3, employee.getEmployeeLastName());
                    state.setInt(4,Integer.parseInt(employee.getEmployeePosition().substring(0,employee.getEmployeePosition().indexOf("."))));

                    state.execute();
                    refreshTable();
                    refreshCombo();
                    clearForm();

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


                id=-1;
            }
        }
    }

    class RemoveEmployeeAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            conn=DBConnection.getConnection();

            if (id>0) {
                String sql="delete from employees where employee_id=?";
                try {
                    state=conn.prepareStatement(sql);
                    state.setInt(1, id);
                    state.execute();

                    refreshTable();
                    refreshCombo();
                    clearForm();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                id=-1;
            }

        }

    }

    class EditEmployeeAction implements ActionListener {
        public void actionPerformed (ActionEvent arg0) {

            employee.setEmployeeID(id);
            employee.setEmployeeFirstName(employeesFirstNameF.getText());
            employee.setEmployeeSecondName(employeesSecondNameF.getText());
            employee.setEmployeeLastName(employeesLastNameF.getText());
            employee.setEmployeePosition(employeesPositionsCombo.getSelectedItem().toString());

            if(id>0) {
                String sql="update employees set fname=?, sname=?, lname=?, employee_department_id=? where employee_id=?";

                try {
                    state=conn.prepareStatement(sql);

                    state.setString(1, employee.getEmployeeFirstName());
                    state.setString(2, employee.getEmployeeSecondName());
                    state.setString(3, employee.getEmployeeLastName());
                    state.setInt(4,Integer.parseInt(employee.getEmployeePosition().substring(0,employee.getEmployeePosition().indexOf("."))));
                    state.setInt(5, employee.getEmployeeID());
                    state.execute();

                    refreshTable();
                    refreshCombo();
                    clearForm();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


            }

        }
    }

    class RefreshAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            refreshTable();
            refreshCombo();
        }

    }

}

