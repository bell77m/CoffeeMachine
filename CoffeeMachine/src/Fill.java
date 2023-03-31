import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fill extends JFrame implements RemainingScene{
    private JPanel panel;
    private JButton backButton;
    public JButton setButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private Remaining remaining;

    private int water;
    private int milk;
    private int coffeebeans;
    private int money;
    private int cups;

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffeebeans(int coffeebeans) {
        this.coffeebeans = coffeebeans;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }



    @Override
    public void setRemaining(Remaining remaining) {
        this.remaining = remaining;
    }

    public void getRemaining(){
        remaining.setVisible(true);
    }



    public int getWater() {
        return water;
    }

    public int getCoffeebeans() {
        return coffeebeans;
    }

    public int getMilk() {
        return milk;
    }

    public int getMoney() {
        return money;
    }

    public int getCups() {
        return cups;
    }

    public JSpinner getSpinner1() {
        return spinner1;
    }

    public JSpinner getSpinner2() {
        return spinner2;
    }

    public JSpinner getSpinner3() {
        return spinner3;
    }

    public JSpinner getSpinner4() {
        return spinner4;
    }

    public JSpinner getSpinner5() {
        return spinner5;
    }


    Fill(){
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,600);
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
        spinner4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner4.getValue();
                if (value == -1) {
                    spinner4.setValue(0);
                }
            }
        });
        spinner5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner5.getValue();
                if (value == -1) {
                    spinner5.setValue(0);
                }
            }
        });
    }
}
