import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GetGUIElements {

    public Component getPanels() {
        return createMainPanel();
    }

    JPanel panel = new JPanel();

    public Component createMainPanel() {

        panel.setLayout(new GridLayout(1, 3));
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.black));

        panel.add(createMainPanelTitle(), BorderLayout.NORTH);
        panel.add(createMainPanelMenu(), BorderLayout.BEFORE_LINE_BEGINS);
        panel.add(createMainContentPanel(), BorderLayout.CENTER);

        return panel;
    }

    JPanel panelTitle = new JPanel();

    public Component createMainPanelTitle() {

        JLabel labelTitle = new JLabel("Име на гараж", JLabel.CENTER);

        panelTitle.setBorder(BorderFactory.createLineBorder(Color.black));

        panelTitle.add(labelTitle);

        return panelTitle;
    }

    JPanel panelMenu = new JPanel();

    public JPanel createMainPanelMenu() {

        JPanel emptyPanel = new JPanel();
        panelMenu.setLayout(new GridLayout(10, 2));
        panelMenu.setBorder(BorderFactory.createLineBorder(Color.black));

        panelMenu.add(cb);
        panelMenu.add(emptyPanel);
        panelMenu.add(new JLabel(""));
        panelMenu.add(new JLabel(""));
        panelMenu.add(new JLabel(""));
        panelMenu.add(new JLabel(""));
        panelMenu.add(new JLabel(""));
        panelMenu.add(new JLabel(""));
        panelMenu.add(createMainPanelMenuButtons());

        return panelMenu;
    }

    JButton addCars = new JButton("Добави");
    JButton showAllCars = new JButton("Покажи всички");

    JPanel buttonPanel = new JPanel();

    public Component createMainPanelMenuButtons() {

        buttonPanel.setLayout(new GridLayout(3, 1));
        buttonPanel.setBorder(new EmptyBorder(0, 10, 0, 10));


        buttonPanel.add(addCars);
        addCars.addActionListener(new AddAction());
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(showAllCars);
        showAllCars.addActionListener(new ShowAllCarsAction());



        return buttonPanel;
    }

    JPanel contentPanel = new JPanel();
    JLabel welcomeTitle = new JLabel();

    public Component createMainContentPanel() {

        JPanel contentMenu = new JPanel();

        welcomeTitle.setText("Здравейте! Моля, изберете кола от гаража.");
        contentPanel.setLayout(new GridLayout(3, 0));
        contentMenu.add(welcomeTitle);

        contentPanel.add(contentMenu);
        return contentPanel;
    }

    JTextField plateNumberTf = new JTextField();
    JTextField fuelConsumptionTf = new JTextField();
    JTextField gasTankCapacityTf = new JTextField();
    JTextField horsePowerTf = new JTextField();
    JTextField yearOfManufacturerTf = new JTextField();
    JTextField dateOfRegistrationTf = new JTextField();
    JTextField dateOfInsuranceTf = new JTextField();
    JTextField dateOfTechnicalReviewTf = new JTextField();
    JTextField dateOfNextTyreChangeTf = new JTextField();
    JTextField kilometersForNextOilChangeTf = new JTextField();

    public JPanel createSecondContentPanel() {
        JPanel secondContentPanel = new JPanel();
        secondContentPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel plateLabel = new JLabel("Регистрационен номер");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        secondContentPanel.add(plateLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        secondContentPanel.add(plateNumberTf, gbc);

        JLabel fuelConsumptionLabel = new JLabel("Разход на гориво");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        secondContentPanel.add(fuelConsumptionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        secondContentPanel.add(fuelConsumptionTf, gbc);

        JLabel gasTankCapacityLabel = new JLabel("Обем на резервоара");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        secondContentPanel.add(gasTankCapacityLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        secondContentPanel.add(gasTankCapacityTf, gbc);

        JLabel fuelKindLabel = new JLabel("Гориво");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        secondContentPanel.add(fuelKindLabel, gbc);

        JComboBox fuelKindCb = new JComboBox(Car.FuelKind.values());
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        secondContentPanel.add(fuelKindCb, gbc);

        JLabel horsePowerLabel = new JLabel("Мощност");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        secondContentPanel.add(horsePowerLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        secondContentPanel.add(horsePowerTf, gbc);

        JLabel transmissionKindLabel = new JLabel("Вид скоростна кутия");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        secondContentPanel.add(transmissionKindLabel, gbc);

        JComboBox transmissionKindCb = new JComboBox(Car.transmissionKind.values());
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        secondContentPanel.add(transmissionKindCb, gbc);

        JLabel yearOfManufacturerLabel = new JLabel("Година на създаване");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        secondContentPanel.add(yearOfManufacturerLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        secondContentPanel.add(yearOfManufacturerTf, gbc);

        JLabel dateOfRegistrationLabel = new JLabel("Дата на регистрация");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        secondContentPanel.add(dateOfRegistrationLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        secondContentPanel.add(dateOfRegistrationTf, gbc);

        JLabel dateOfInsuranceLabel = new JLabel("Дата на затраховка");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        secondContentPanel.add(dateOfInsuranceLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        secondContentPanel.add(dateOfInsuranceTf, gbc);

        JLabel dateOfTechnicalReviewLabel = new JLabel("Дата на преглед");
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        secondContentPanel.add(dateOfTechnicalReviewLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        secondContentPanel.add(dateOfTechnicalReviewTf, gbc);

        JLabel dateOfNextTyreChangeLabel = new JLabel("Дата за следваща смяна на гуми");
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        secondContentPanel.add(dateOfNextTyreChangeLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        secondContentPanel.add(dateOfNextTyreChangeTf, gbc);

        JLabel kilometersForNextOilChangeLabel = new JLabel("Километри за следваща смяна на масло");
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        secondContentPanel.add(kilometersForNextOilChangeLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        secondContentPanel.add(kilometersForNextOilChangeTf, gbc);

        return secondContentPanel;
    }
    JButton searchInGarage=new JButton("Търсене");
    public JPanel createSecondButtonPanel() {

        JPanel secondButtonPanel = new JPanel();

        secondButtonPanel.setLayout(new GridLayout(5, 1));
        secondButtonPanel.setBorder(new EmptyBorder(0, 10, 0, 10));


        JButton addCarsToGarage = new JButton("Добави");
        JButton deleteCar = new JButton("Изтрий");
        JButton updateCar = new JButton("Обнови");

        JPanel panelSearchInGarage=new JPanel();
        JPanel panelAdd = new JPanel();
        JPanel panelDelete = new JPanel();
        JPanel panelUpdate = new JPanel();
        JPanel panelShow = new JPanel();

        panelSearchInGarage.setLayout(new GridLayout(1, 1));
        searchInGarage.addActionListener(new SearchCarAction());
        panelSearchInGarage.add(searchInGarage);

        secondButtonPanel.add(panelSearchInGarage);

        panelAdd.setLayout(new GridLayout(1, 1));
        addCarsToGarage.addActionListener(new AddCarAction());
        panelAdd.add(addCarsToGarage);

        secondButtonPanel.add(panelAdd);

        panelDelete.setLayout(new GridLayout(1, 1));
        deleteCar.addActionListener(new RemoveCarAction());
        panelDelete.add(deleteCar);

        secondButtonPanel.add(panelDelete);

        panelUpdate.setLayout(new GridLayout(1, 1));
        updateCar.addActionListener(new UpdateCarAction());
        panelUpdate.add(updateCar);

        secondButtonPanel.add(panelUpdate);

        panelShow.setLayout(new GridLayout(1, 1));
        panelShow.add(showAllCars);

        secondButtonPanel.add(panelShow);

        return secondButtonPanel;

    }

    JTextField kindOfVehicleTf = new JTextField();
    JTextField brandTf = new JTextField();
    JTextField modelTf = new JTextField();

    public Component createSecondTittlePanel() {
        JPanel secondTitlePanel = new JPanel();
        secondTitlePanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel brandAndModel = new JLabel("Име и марка на кола");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        secondTitlePanel.add(brandAndModel, gbc);

        JLabel kindOfVehicle = new JLabel("Вид на автомобила");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        secondTitlePanel.add(kindOfVehicle, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        secondTitlePanel.add(kindOfVehicleTf, gbc);

        JLabel manufacturerOfCarLabel = new JLabel("Марка на автомобила");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        secondTitlePanel.add(manufacturerOfCarLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        secondTitlePanel.add(brandTf, gbc);

        JLabel modelOfCarLabel = new JLabel("Модел на автомобила");
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        secondTitlePanel.add(modelOfCarLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        secondTitlePanel.add(modelTf, gbc);

        return secondTitlePanel;

    }

    JComboBox<String> cb = new JComboBox<String>();

    public Component createComboBox() {


        return cb;
    }

    public Component messageDialog() {
        JDialog d = new JDialog(new Frame(), "dialog Box");
        d.setLayout(new GridLayout(2, 0));

        JLabel l = new JLabel("Моля въведете корекни данни");
        JButton okButton = new JButton("ОК");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        d.add(l);
        d.add(okButton);
        d.setSize(200, 200);
        d.setVisible(true);
        return d;
    }


    class AddAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            panelMenu.remove(buttonPanel);
            panelMenu.add(createSecondButtonPanel());
            welcomeTitle.removeAll();
            welcomeTitle.setText("Име и марка на кола");
            contentPanel.removeAll();
            contentPanel.add(createSecondTittlePanel());
            contentPanel.add(createSecondContentPanel());
        }
    }

    public ArrayList<Car> showAllCarsList = new ArrayList<Car>();

    class AddCarAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Car car = new Car();

            car.setKindOfVehicle(kindOfVehicleTf.getText());
            car.setBrand(brandTf.getText());
            car.setModel(modelTf.getText());
            car.setPlateNumber(plateNumberTf.getText());
            car.setFuelConsumption(Integer.parseInt(fuelConsumptionTf.getText()));
            car.setGasTankCapacity(Integer.parseInt(gasTankCapacityTf.getText()));
            car.setHorsePower(Integer.parseInt(horsePowerTf.getText()));
            car.setYearOfManufacturer(Integer.parseInt(yearOfManufacturerTf.getText()));
            car.setDateOfRegistration(Integer.parseInt(dateOfRegistrationTf.getText()));
            car.setDateOfInsurance(Integer.parseInt(dateOfInsuranceTf.getText()));
            car.setDateOfTechnicalReview(Integer.parseInt(dateOfTechnicalReviewTf.getText()));
            car.setDateOfNextTyreChange(Integer.parseInt(dateOfNextTyreChangeTf.getText()));
            car.setKilometersForNextOilChange(Integer.parseInt(kilometersForNextOilChangeTf.getText()));

            Validations val = new Validations(car);
            val.runAllValidations();

            if (val.checkBrand()) {
                showAllCarsList.add(new Car(car.getBrand(), car.getModel(), car.getPlateNumber()));
                cb.addItem(car.getBrand());

            } else {
                messageDialog();
            }
            clearField();
        }
    }

    class RemoveCarAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (cb.getSelectedIndex() > -1) {
                int index = cb.getSelectedIndex();
                cb.removeItemAt(index);
                showAllCarsList.remove(index);

            } else {
                messageDialog();
            }
        }
    }

    class UpdateCarAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Car cars = new Car();

            if (cb.getSelectedIndex() > -1) {
                int index = cb.getSelectedIndex();
                cars.setBrand(brandTf.getText());
                cars.setModel(modelTf.getText());
                cars.setPlateNumber(plateNumberTf.getText());
                showAllCarsList.set(index, new Car(cars.getBrand(), cars.getModel(), cars.getPlateNumber()));
            } else {
                messageDialog();
            }
            clearField();
        }
    }

    class ShowAllCarsAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            JFrame f = new JFrame("Налични автомобили");
            JTable jt=new JTable();

            String header[]=new String[]{"Марка","Модел","Регистрационнен номер"};
            DefaultTableModel dtm = new DefaultTableModel(header,0);
            int row,col;

            for (int i=0;i<showAllCarsList.size();i++){
                Object[] objs={showAllCarsList.get(i).getBrand(),showAllCarsList.get(i).getModel(),showAllCarsList.get(i).getPlateNumber()};
                dtm.addRow(objs);
            }

            jt.setModel(dtm);

            jt.setBounds(30,40,200,300);
            JScrollPane sp=new JScrollPane(jt);
            f.add(sp);

            f.setSize(1000, 1000);
            f.setVisible(true);

        }

    }

    class SearchCarAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String input =JOptionPane.showInputDialog("Въведете регистрационнен номер");
            for (int i=0;i<showAllCarsList.size();i++){
                if (showAllCarsList.get(i).getPlateNumber().equalsIgnoreCase(input)) {

                    JOptionPane.showMessageDialog(searchInGarage,"Има такъв автомобил в гаража");

                }
                JOptionPane.showMessageDialog(searchInGarage,"Няма такъв автомобил в гаража");

                }
            }
        }
    private void clearField(){
        brandTf.requestFocus();
        kindOfVehicleTf.setText("");
        brandTf.setText("");
        modelTf.setText("");
        plateNumberTf.setText("");
        horsePowerTf.setText("");
        dateOfInsuranceTf.setText("");
        fuelConsumptionTf.setText("");
        dateOfTechnicalReviewTf.setText("");
        gasTankCapacityTf.setText("");
        yearOfManufacturerTf.setText("");
        dateOfNextTyreChangeTf.setText("");
        dateOfRegistrationTf.setText("");
        kilometersForNextOilChangeTf.setText("");
    }
}



