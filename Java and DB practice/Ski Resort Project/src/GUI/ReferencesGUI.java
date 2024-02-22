package GUI;

import utillity.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReferencesGUI {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    int id;

    JPanel referencesPanel =new JPanel((new GridLayout(3,1)));
    JPanel referencesUpPanel =new JPanel(new GridLayout(4,1));
    JPanel referencesMidPanel =new JPanel(new GridLayout(1,1));
    JPanel referencesBottomPanel =new JPanel(new GridLayout(1,1));

    JTable infoTable=new JTable();
    JScrollPane sprScroll=new JScrollPane(infoTable);

    JLabel clientLiftPassLabel =new JLabel(" Въведете вид на лифт карта, за да видите колко човека използват този вид лифт карта");
    JTextField clientLiftPassTf =new JTextField();

    JLabel clientSkiSchoolLabel =new JLabel("Въведете тип на урок за да видите колко хора има записани");
    JTextField clientSkiSchoolTf =new JTextField();

    JPanel searchEmployeeButtonPanel =new JPanel();
    JButton searchButton = new JButton("Търси");

    public ReferencesGUI() {

        searchButton.addActionListener(new SearchDB());
        searchEmployeeButtonPanel.add(searchButton);

        //referencesUpPanel.add(referenceLabel);
        referencesUpPanel.add(clientSkiSchoolLabel);
        referencesUpPanel.add(clientSkiSchoolTf);
        referencesUpPanel.add(clientLiftPassLabel);
        referencesUpPanel.add(clientLiftPassTf);

        referencesMidPanel.add(searchEmployeeButtonPanel);

        referencesBottomPanel.add(sprScroll);

        referencesPanel.add(referencesUpPanel);
        referencesPanel.add(referencesMidPanel);
        referencesPanel.add(referencesBottomPanel);
    }


    class SearchDB implements ActionListener {
        public void actionPerformed (ActionEvent arg0) {

            conn= DBConnection.getConnection();

            String str = "SELECT CONCAT(C.FNAME,' ',C.SNAME,' ',C.LNAME) AS КЛИЕНТИ, LPT.LIFT_PASS_TYPE_NAME, SASSLT.SKI_AND_SNOWBOARD_LESSONS_TYPE_NAME FROM CLIENTS AS C JOIN SKI_AND_SNOWBOARD_SCHOOL AS SASS ON C.CLIENT_ID=SASS.SKI_AND_SNOWBOARD_SCHOOL_LESSONS_CLIENT_ID JOIN LIFT_PASSES AS LP ON C.CLIENT_ID=LP.LIFT_PASS_OWNER_ID JOIN SKI_AND_SNOWBOARD_LESSONS_TYPE AS SASSLT ON SASSLT.SKI_AND_SNOWBOARD_LESSONS_TYPE_ID=SASS.SKI_AND_SNOWBOARD_SCHOOL_LESSONS_TYPE_ID JOIN LIFT_PASS_TYPE AS LPT ON LPT.LIFT_PASS_TYPE_ID=LP.LIFT_PASS_TYPE_ID WHERE SASSLT.SKI_AND_SNOWBOARD_LESSONS_TYPE_NAME='"+clientSkiSchoolTf.getText().toString()+"'"+"AND "+"LPT.LIFT_PASS_TYPE_NAME='"+clientLiftPassTf.getText().toString()+"'";

                    try {
                        state = conn.prepareStatement(str);
                        result = state.executeQuery();
                        infoTable.setModel(new InfoTable(result));
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    clientSkiSchoolTf.setText("");
                    clientLiftPassTf.setText("");
                }
            }
        }




