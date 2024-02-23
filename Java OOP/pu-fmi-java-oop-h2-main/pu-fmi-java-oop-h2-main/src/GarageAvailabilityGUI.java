import javax.swing.*;
public class GarageAvailabilityGUI extends GetGUIElements {
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Моят гараж");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        frame.add(getPanels());

        frame.setVisible(true);
            }

        }
