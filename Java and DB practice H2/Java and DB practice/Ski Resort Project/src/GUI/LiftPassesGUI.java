package GUI;

import resortInfo.LiftPasses;
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

public class LiftPassesGUI {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    int id;

    JPanel liftPassesPanel =new JPanel((new GridLayout(3,1)));
    JPanel liftPassesUpPanel =new JPanel(new GridLayout(6,1));
    JPanel liftPassesMidPanel =new JPanel(new GridLayout(1,4));
    JPanel liftPassesBottomPanel =new JPanel(new GridLayout(1,1));

    JTable infoTable=new JTable();
    JScrollPane sprScroll=new JScrollPane(infoTable);

    JLabel clientNamesLabel =new JLabel("Имена на клиент");

    JComboBox clientNamesCombo =new JComboBox<>();

    JLabel liftPassTypeLabel =new JLabel("Вид лифт карта или пакет");

    JComboBox liftPassesTypesCombo =new JComboBox();
    JLabel liftPassesValidityLabel =new JLabel("Валидност на лифт картата");

    JComboBox liftPassesValidityCombo =new JComboBox();

    JPanel addLiftPassButtonPanel =new JPanel();
    JPanel removeLiftPassButtonPanel =new JPanel();
    JPanel editLiftPassButtonPanel =new JPanel();
    JPanel refreshLiftPassButtonPanel =new JPanel();
    JButton addLiftPassButton = new JButton("Добави");
    JButton removeLiftPassButton = new JButton("Изтрий");
    JButton editLiftPassButton = new JButton("Редактирай");
    JButton refreshLiftPassButton = new JButton("Обнови");
    public LiftPassesGUI() {

        addLiftPassButton.addActionListener(new AddLiftPassAction());
        addLiftPassButtonPanel.add(addLiftPassButton);

        removeLiftPassButton.addActionListener(new RemoveLiftPassAction());
        removeLiftPassButtonPanel.add(removeLiftPassButton);

        editLiftPassButton.addActionListener(new EditLiftPassAction());
        editLiftPassButtonPanel.add(editLiftPassButton);

        refreshLiftPassButton.addActionListener(new RefreshAction());
        refreshLiftPassButtonPanel.add(refreshLiftPassButton);

        liftPassesUpPanel.add(clientNamesLabel);
        liftPassesUpPanel.add(clientNamesCombo);
        liftPassesUpPanel.add(liftPassTypeLabel);
        liftPassesUpPanel.add(liftPassesTypesCombo);
        liftPassesUpPanel.add(liftPassesValidityLabel);
        liftPassesUpPanel.add(liftPassesValidityCombo);
        liftPassesUpPanel.add(new JLabel(""));

        liftPassesMidPanel.add(addLiftPassButtonPanel);
        liftPassesMidPanel.add(removeLiftPassButtonPanel);
        liftPassesMidPanel.add(editLiftPassButtonPanel);
        liftPassesMidPanel.add(refreshLiftPassButtonPanel);

        liftPassesBottomPanel.add(sprScroll);

        liftPassesPanel.add(liftPassesUpPanel);
        liftPassesPanel.add(liftPassesMidPanel);
        liftPassesPanel.add(liftPassesBottomPanel);

        infoTable.addMouseListener(new MouseAction());

        refreshTable();
        refreshClientNamesCombo();
        refreshLiftPassTypeCombo();
        refreshLiftPassValidityCombo();
    }
   LiftPasses liftPasses=new LiftPasses();

    public void clearForm() {
        clientNamesCombo.setSelectedIndex(0);
        liftPassesTypesCombo.setSelectedIndex(0);
        liftPassesValidityCombo.setSelectedIndex(0);
    }

    public void refreshClientNamesCombo() {
        clientNamesCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select client_id, fname, sname, lname from clients";
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

    public void refreshLiftPassTypeCombo() {
        liftPassesTypesCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select lift_pass_type_id,lift_pass_type_name from lift_pass_type";
        String item = "";
        liftPassesTypesCombo.addItem("");

        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                item = result.getObject(1).toString()+". "
                        +result.getObject(2).toString();
                liftPassesTypesCombo.addItem(item);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void refreshLiftPassValidityCombo() {
        liftPassesValidityCombo.removeAllItems();
        conn = DBConnection.getConnection();
        String sql = "select lift_pass_validity_id,lift_pass_validity_name from lift_pass_validity";
        String item = "";
        liftPassesValidityCombo.addItem("");

        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                item = result.getObject(1).toString()+". "
                +result.getObject(2).toString();
                liftPassesValidityCombo.addItem(item);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void refreshTable() {

        conn = DBConnection.getConnection();
        try {
            state = conn.prepareStatement("SELECT LP.LIFT_PASS_RECEIPT_ID,C.CLIENT_ID ,CONCAT(C.FNAME,' ',C.SNAME,' ',C.LNAME) AS КЛИЕНТ, LPT.LIFT_PASS_TYPE_ID,LPT.LIFT_PASS_TYPE_NAME,LPV.LIFT_PASS_VALIDITY_ID,LPV.LIFT_PASS_VALIDITY_NAME FROM CLIENTS AS C, LIFT_PASSES AS LP, LIFT_PASS_TYPE AS LPT,LIFT_PASS_VALIDITY AS LPV WHERE C.CLIENT_ID=LP.LIFT_PASS_OWNER_ID AND LP.LIFT_PASS_TYPE_ID=LPT.LIFT_PASS_TYPE_ID AND LP.LIFT_PASS_VALIDITY_ID=LPV.LIFT_PASS_VALIDITY_ID");
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
            clientNamesCombo.setSelectedIndex(Integer.parseInt(infoTable.getValueAt(row, 1).toString()));
            liftPassesTypesCombo.setSelectedIndex(Integer.parseInt(infoTable.getValueAt(row, 3).toString()));
            liftPassesValidityCombo.setSelectedIndex(Integer.parseInt(infoTable.getValueAt(row, 5).toString()));
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

    class AddLiftPassAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            liftPasses.setLiftPassID(id);
            liftPasses.setClientLiftPassFullName(clientNamesCombo.getSelectedItem().toString());
            liftPasses.setLiftPassType(liftPassesTypesCombo.getSelectedItem().toString());
            liftPasses.setLiftPassValidity(liftPassesValidityCombo.getSelectedItem().toString());

            conn= DBConnection.getConnection();
            if(!clientNamesCombo.getSelectedItem().toString().isEmpty()) {
                String sql="insert into lift_passes(lift_pass_owner_id, lift_pass_type_id, lift_pass_validity_id) values(?,?,?)";

                try {
                    state=conn.prepareStatement(sql);
                    state.setInt(1,Integer.parseInt(liftPasses.getClientLiftPassFullName().substring(0,liftPasses.getClientLiftPassFullName().indexOf("."))));
                    state.setInt(2, Integer.parseInt(liftPasses.getLiftPassType().substring(0,liftPasses.getLiftPassType().indexOf("."))));
                    state.setInt(3, Integer.parseInt(liftPasses.getLiftPassValidity().substring(0,liftPasses.getLiftPassValidity().indexOf("."))));

                    state.execute();
                    refreshTable();
                    refreshClientNamesCombo();
                    clearForm();

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }


                id=-1;
            }
        }
    }

    class RemoveLiftPassAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.getConnection();

            if (id > 0) {
                String sql = "delete from lift_passes where lift_pass_receipt_id=?";
                try {
                    state = conn.prepareStatement(sql);
                    state.setInt(1, id);
                    state.execute();

                    refreshTable();
                    refreshClientNamesCombo();
                    clearForm();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

                id = -1;
            }

        }

    }

    class EditLiftPassAction implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {

            liftPasses.setLiftPassID(id);
            liftPasses.setClientLiftPassFullName(clientNamesCombo.getSelectedItem().toString());
            liftPasses.setLiftPassType(liftPassesTypesCombo.getSelectedItem().toString());
            liftPasses.setLiftPassValidity(liftPassesValidityCombo.getSelectedItem().toString());

            if (id > 0) {
                String sql = "update lift_passes set lift_pass_owner_id=?, lift_pass_type_id=?, lift_pass_validity_id=? where lift_pass_receipt_id=?";

                try {
                    state = conn.prepareStatement(sql);
                    state.setInt(1, Integer.parseInt(liftPasses.getClientLiftPassFullName().substring(0,liftPasses.getClientLiftPassFullName().indexOf("."))));
                    state.setInt(2, Integer.parseInt(liftPasses.getLiftPassType().substring(0,liftPasses.getLiftPassType().indexOf("."))));
                    state.setInt(3, Integer.parseInt(liftPasses.getLiftPassValidity().substring(0,liftPasses.getLiftPassValidity().indexOf("."))));
                    state.setInt(4, liftPasses.getLiftPassID());
                    state.execute();

                    refreshTable();
                    refreshClientNamesCombo();
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
        }
    }
}




