import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Recipe extends JFrame implements RemainingScene{
    private JPanel panel;
    private JButton backButton;
    public JButton saveButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JComboBox comboBox1;
    public JButton seeButton;
    private JSpinner spinner4;

    private Remaining remaining;
    private int water;
    private int milk;
    private int price;


    public JSpinner getSpinner4() {
        return spinner4;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeebeans() {
        return coffeebeans;
    }

    public void setCoffeebeans(int coffeebeans) {
        this.coffeebeans = coffeebeans;
    }

    private int coffeebeans;


    public JSpinner getSpinner1() {
        return spinner1;
    }

    public JSpinner getSpinner2() {
        return spinner2;
    }

    public JSpinner getSpinner3() {
        return spinner3;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }





    @Override
    public void setRemaining(Remaining remaining) {
        this.remaining = remaining;
    }

    public void getRemaining(){
        remaining.setVisible(true);
    }


    public void defaultSet(int milk, int water, int coffeebeans, int price){
        this.milk = milk;
        this.water = water;
        this.coffeebeans = coffeebeans;
        this.price = price;
    }
    Recipe(){


        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,550);
        validate();
        repaint();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                getRemaining();
            }
        });

        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner1.getValue();
                if (value == -1) {
                    spinner1.setValue(0);
                }
            }
        });
        spinner2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner2.getValue();
                if (value == -1) {
                    spinner2.setValue(0);
                }
            }
        });
        spinner3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner3.getValue();
                if (value == -1) {
                    spinner3.setValue(0);
                }
            }
        });
    }



}
