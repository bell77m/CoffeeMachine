import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeMachineTextUI {



    public ImageIcon imageLabel(String path, int width, int height){
        ImageIcon imageIcon = new ImageIcon(path);
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
    public void labelPriceTag(Home home){
        home.setPrice1(String.format("%s %d €", Coffee.ESPRESSO.getName(), Coffee.ESPRESSO.getPrice()));
        home.setPrice2(String.format("%s %d €", Coffee.LATTE.getName(), Coffee.LATTE.getPrice()));
        home.setPrice3(String.format("%s %d €", Coffee.CAPPUCCINO.getName(), Coffee.CAPPUCCINO.getPrice()));
    }

    public void setState(Remaining remaining, CoffeeMachine coffeeMachine){
        remaining.setState1(String.format("%d ml of water\n", coffeeMachine.getWater()));
        remaining.setState2(String.format("%d ml of milk\n", coffeeMachine.getMilk()));
        remaining.setState3(String.format("%d g of coffee beans%n", coffeeMachine.getBeans()));
        remaining.setState4(String.format("%d disposable cups%n", coffeeMachine.getCups()));
        remaining.setState5(String.format("€%d of money%n", coffeeMachine.getCash()));
    }

    public void buyMessage(boolean bool){

            if( bool ){

                    JOptionPane.showMessageDialog(null, "Orders Complete" , "Orders", JOptionPane.PLAIN_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Something went wrongs please try again" , "Waring", JOptionPane.PLAIN_MESSAGE);
            }


    }



}



