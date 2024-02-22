package GUI;

import resortInfo.Client;
import utillity.DBConnection;

import javax.print.DocFlavor;
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

public class ClientsGUI{

    Connection conn=null;
    PreparedStatement state=null;
    ResultSet result=null;
    int id;
    JPanel clientPanel =new JPanel((new GridLayout(3,1)));
    JPanel clientUpPanel =new JPanel(new GridLayout(7,1));
    JPanel clientMidPanel =new JPanel(new GridLayout(1,4));
    JPanel clientBottomPanel =new JPanel(new GridLayout(1,1));

    JTable infoTable=new JTable();
    JScrollPane sprScroll=new JScrollPane(infoTable);

    JLabel clientFirstNameLabel=new JLabel("Име на клиент");
    JTextField clientFirstNameF=new JTextField();
    JLabel clientSecondNameLabel=new JLabel("Презиме на клиент");
    JTextField clientSecondNameF=new JTextField();

    JLabel clientLastNameLabel=new JLabel("Фамилия на клиент");
    JTextField clientLastNameF=new JTextField();

    JLabel clientAgeLabel=new JLabel("Години на клиент");
    JTextField clientAgeF=new JTextField();

    JPanel addClientButtonPanel=new JPanel();
    JPanel removeClientButtonPanel=new JPanel();
    JPanel editClientButtonPanel=new JPanel();
    JPanel refreshClientButtonPanel=new JPanel();
    JButton addClientButton = new JButton("Добави");
    JButton removeClientButton = new JButton("Изтрий");
    JButton editClientButton = new JButton("Редактирай");
    JButton refreshClientButton = new JButton("Обнови");
    JComboBox clientNamesCombo = new JComboBox<>();

    public ClientsGUI() {

        addClientButton.addActionListener(new AddClientAction());
        addClientButtonPanel.add(addClientButton);

        removeClientButton.addActionListener(new RemoveClientAction());
        removeClientButtonPanel.add(removeClientButton);

        editClientButton.addActionListener(new EditClientAction());
        editClientButtonPanel.add(editClientButton);

        refreshClientButton.addActionListener(new RefreshAction());
        refreshClientButtonPanel.add(refreshClientButton);

        clientUpPanel.add(clientFirstNameLabel);
        clientUpPanel.add(clientFirstNameF);
        clientUpPanel.add(clientSecondNameLabel);
        clientUpPanel.add(clientSecondNameF);
        clientUpPanel.add(clientLastNameLabel);
        clientUpPanel.add(clientLastNameF);
        clientUpPanel.add(clientAgeLabel);
        clientUpPanel.add(clientAgeF);

        clientMidPanel.add(addClientButtonPanel);
        clientMidPanel.add(removeClientButtonPanel);
        clientMidPanel.add(editClientButtonPanel);
        clientMidPanel.add(refreshClientButtonPanel);

        clientBottomPanel.add(sprScroll);

        clientPanel.add(clientUpPanel);
        clientPanel.add(clientMidPanel);
        clientPanel.add(clientBottomPanel);

        infoTable.addMouseListener(new MouseAction());

        refreshTable();
        refreshCombo();
    }

    Client client = new Client();


    public void clearForm() {
        clientFirstNameF.setText("");
        clientSecondNameF.setText("");
        clientLastNameF.setText("");
        clientAgeF.setText("");
    }

    public void refreshTable() {

        conn=DBConnection.getConnection();
        try {
            state=conn.prepareStatement("select * from CLIENTS");
            result=state.executeQuery();
            infoTable.setModel(new InfoTable(result));

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public void refreshCombo() {
        clientNamesCombo.removeAllItems();
        conn=DBConnection.getConnection();
        String sql="select client_id, fname, sname, lname from CLIENTS";
        String item="";
        clientNamesCombo.addItem(" ");
        try {
            state=conn.prepareStatement(sql);
            result=state.executeQuery();
            while(result.next()) {
                item=result.getObject(1).toString()+". "
                        +result.getObject(2).toString()+" "
                        +result.getObject(3).toString()+" "
                        +result.getObject(4).toString();
                clientNamesCombo.addItem(item);
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
            clientFirstNameF.setText(infoTable.getValueAt(row, 1).toString());
            clientSecondNameF.setText(infoTable.getValueAt(row, 2).toString());
            clientLastNameF.setText(infoTable.getValueAt(row, 3).toString());
            clientAgeF.setText(infoTable.getValueAt(row, 4).toString());
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
    class AddClientAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            client.setClientID(id);
            client.setClientFirstName(clientFirstNameF.getText());
            client.setClientSecondName(clientSecondNameF.getText());
            client.setClientLastName(clientLastNameF.getText());
            client.setAge(Integer.parseInt(clientAgeF.getText()));

            conn= DBConnection.getConnection();
            if(!clientFirstNameF.getText().isEmpty()) {
                String sql="insert into CLIENTS(fname, sname, lname, age) values(?,?,?,?)";

                try {
                    state=conn.prepareStatement(sql);
                    state.setString(1, client.getClientFirstName());
                    state.setString(2, client.getClientSecondName());
                    state.setString(3, client.getClientLastName());
                    state.setInt(4, client.getAge());

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

    class RemoveClientAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            conn=DBConnection.getConnection();

            if (id>0) {
                String sql="delete from CLIENTS where client_id=?";
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

    class EditClientAction implements ActionListener {
        public void actionPerformed (ActionEvent arg0) {

            client.setClientID(id);
            client.setClientFirstName(clientFirstNameF.getText());
            client.setClientSecondName(clientSecondNameF.getText());
            client.setClientLastName(clientLastNameF.getText());
            client.setAge(Integer.parseInt(clientAgeF.getText()));

            if(id>0) {
                String sql="update CLIENTS set fname=?, sname=?, lname=?, age=? where client_id=?";

                try {
                    state=conn.prepareStatement(sql);

                    state.setString(1, client.getClientFirstName());
                    state.setString(2, client.getClientSecondName());
                    state.setString(3, client.getClientLastName());
                    state.setInt(4, client.getAge());
                    state.setInt(5, client.getClientID());
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
