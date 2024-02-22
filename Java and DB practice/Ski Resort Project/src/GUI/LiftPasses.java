package GUI;

import javax.swing.*;
import java.awt.*;

public class LiftPasses {

    JPanel liftPassesPanel =new JPanel((new GridLayout(3,1)));
    JPanel liftPassesUpPanel =new JPanel(new GridLayout(6,1));
    JPanel liftPassesMidPanel =new JPanel(new GridLayout(1,4));
    JPanel liftPassesBottomPanel =new JPanel(new GridLayout(1,1));

    JTable infoTable=new JTable();
    JScrollPane sprScroll=new JScrollPane(infoTable);

    JLabel clientNamesLabel =new JLabel("Имена на клиент");
    JTextField clientNamesTf =new JTextField();

    JLabel liftPassTypeLabel =new JLabel("Вид лифт карта или пакет");

    String liftPassesTypes[]={"","Дете (7-11)","Младеж(12-17)","Възрастен(18+)"};
    JComboBox liftPassesTypesCombo =new JComboBox(liftPassesTypes);

    JLabel liftPassesValidityLabel =new JLabel("Валидност на лифт картата");

    String liftPassesValidity[]={"","1/2 ден","1-ден","2-дена","3-дена","4-дена","5-дена","6-дена","7-дена","Сезонна"};
    JComboBox liftPassesValidityCombo =new JComboBox(liftPassesValidity);

    JPanel addLiftPassButtonPanel =new JPanel();
    JPanel removeLiftPassButtonPanel =new JPanel();
    JPanel editLiftPassButtonPanel =new JPanel();
    JPanel refreshLiftPassButtonPanel =new JPanel();
    JButton addLiftPassButton = new JButton("Добави");
    JButton removeLiftPassButton = new JButton("Изтрий");
    JButton editLiftPassButton = new JButton("Редактирай");
    JButton refreshLiftPassButton = new JButton("Обнови");
    public LiftPasses() {

        addLiftPassButtonPanel.add(addLiftPassButton);
        removeLiftPassButtonPanel.add(removeLiftPassButton);
        editLiftPassButtonPanel.add(editLiftPassButton);
        refreshLiftPassButtonPanel.add(refreshLiftPassButton);

        liftPassesUpPanel.add(clientNamesLabel);
        liftPassesUpPanel.add(clientNamesTf);
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
    }


}
