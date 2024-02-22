package GUI;

import javax.swing.*;

public class SkiResortGUI extends JFrame{
    JFrame mainFrame=new JFrame("Ски курорт");
    JTabbedPane tab=new JTabbedPane();

    ClientsGUI clientsGUI=new ClientsGUI();
    EmployeesGUI employeesGUI=new EmployeesGUI();
    SkiAndSnowboardSchoolGUI skiAndSnowboardSchoolGUI=new SkiAndSnowboardSchoolGUI();
    LiftPassesGUI liftPassesGUI =new LiftPassesGUI();
    ReferencesGUI referencesGUI=new ReferencesGUI();

    public SkiResortGUI() {

        mainFrame.setSize(600, 800);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        tab.add(clientsGUI.clientPanel, "Клиенти");
        tab.add(employeesGUI.employeesPanel,"Служители");
        tab.add(skiAndSnowboardSchoolGUI.skiAndSnowboardSchoolPanel,"Ски училище");
        tab.add(liftPassesGUI.liftPassesPanel,"Лифт карти");
        tab.add(referencesGUI.referencesPanel,"Справка");

        mainFrame.add(tab);

        mainFrame.setVisible(true);
    }
}
