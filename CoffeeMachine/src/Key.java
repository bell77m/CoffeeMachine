import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Key extends  JFrame implements RemainingScene, HomeScene{

    private JPanel panel1;
    public JButton activateButton;

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    private JPasswordField passwordField1;

    private Remaining remaining;
    private Home home;

    Key(){
        panel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        validate();
        repaint();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);


    }


    @Override
    public void setRemaining(Remaining remaining) {
        this.remaining =remaining;
    }

    @Override
    public void getRemaining() {
        remaining.setVisible(true);
    }

    @Override
    public void setHome(Home home) {
        this.home = home;
    }

    @Override
    public void getHome() {
        home.setVisible(true);
    }
}
