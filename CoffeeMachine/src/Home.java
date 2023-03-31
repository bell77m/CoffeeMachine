import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.io.IOException;


public class Home extends JFrame implements KeyScene{
    private JSpinner spinner1;
    private JPanel panel1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JLabel label1;
    public JButton buyButton;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JLabel price1;
    private JLabel price2;
    private JLabel price3;

    private Key key;

    public void setPrice1(String string) {
        price1.setText(string);
    }
    public void setPrice2(String string) {
        price2.setText(string);
    }
    public void setPrice3(String string) {
        price3.setText(string);
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


    Home() throws IOException {

        label1.setIcon(new CoffeeMachineTextUI().imageLabel("src/img1.png", 200, 200));
        label2.setIcon(new CoffeeMachineTextUI().imageLabel("src/img2.png", 200, 200));
        label3.setIcon(new CoffeeMachineTextUI().imageLabel("src/img3.png", 200, 200));



        panel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,550);
        validate();
        repaint();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                getKey();
            }
        });

        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner1.getValue();
                if (value == -1) {
                    spinner1.setValue(0);

                }



                if(value > 0) {
                    spinner2.setValue(0);
                    spinner3.setValue(0);

                    spinner2.setEnabled(false);
                    spinner3.setEnabled(false);
                }
                if(value == 2){
                    spinner1.setValue(1);
                }
                if(value ==0){

                    spinner2.setEnabled(true);
                    spinner3.setEnabled(true);
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

                if(value > 0){

                    spinner1.setValue(0);
                    spinner3.setValue(0);
                    spinner1.setEnabled(false);
                    spinner3.setEnabled(false);
                }
                if(value == 2){
                    spinner2.setValue(1);
                }
                if(value ==0){

                    spinner1.setEnabled(true);
                    spinner3.setEnabled(true);
                }

            }
        });

        spinner3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = (Integer) spinner3.getValue();
                if (value == -1 ) {
                    spinner3.setValue(0);
                }


                if(value > 0){

                    spinner1.setValue(0);
                    spinner2.setValue(0);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);

                }

                if(value ==2){
                    spinner3.setValue(1);
                }
                if(value ==0){
                    spinner1.setEnabled(true);
                    spinner2.setEnabled(true);
                }

            }
        });


    }


    @Override
    public void setKey(Key key) {
        this.key = key;
    }

    @Override
    public void getKey() {
        key.setVisible(true);
    }
}
