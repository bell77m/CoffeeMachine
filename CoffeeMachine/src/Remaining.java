import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Remaining extends JFrame implements HomeScene, RecipeScene, FillScene{
    private JButton fillButton;
    public JButton backButton;
    private JPanel panel;
    private JLabel state1;
    private JLabel state2;
    private JLabel state3;
    private JLabel state4;
    private JLabel state5;
    private JButton recipeButton;
    public JButton takeMoneyButton;
    public JButton resetButton;
    private Home home;
    private Recipe recipe;
    private Fill fill;


    public void setRecipe(Recipe recipe){
        this.recipe= recipe;
    }
    public void getRecipe(){
        recipe.setVisible(true);
    }

    public void setFill(Fill fill){
        this.fill= fill;
    }
    public void getFill(){
        fill.setVisible(true);
    }


    public void setState1(String string){
        state1.setText(string);
    }
    public void setState2(String string){
        state2.setText(string);
    }
    public void setState3(String string){
        state3.setText(string);
    }
    public void setState4(String string){
        state4.setText(string);
    }
    public void setState5(String string){
        state5.setText(string);
    }


    Remaining(){



        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750,350);
        validate();
        repaint();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);


        fillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                getRecipe();
            }
        });
        recipeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                getFill();
            }
        });

    }

    @Override
    public void setHome(Home home) {
        this.home= home;
    }

    @Override
    public void getHome() {
        home.setVisible(true);
    }
}
