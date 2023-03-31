import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int cash;
    private int addedWater;
    private int addedMilk;
    private int addedBeans;
    private int addedCups;
    private int addedCash;

    private int espresso_order;
    private int latte_order;
    private int cappuccino_order;

    public boolean bool;


    public int getEspresso_order() {
        return espresso_order;
    }

    public int getLatte_order() {
        return latte_order;
    }

    public int getCappuccino_order() {
        return cappuccino_order;
    }

    CoffeeMachine(){}

    public CoffeeMachine(int water, int milk, int beans, int cups, int cash){
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.cash = cash;
    }
    public void setAddedWater(int addedWater) {
        this.addedWater = addedWater;
    }

    public void setAddedMilk(int addedMilk) {
        this.addedMilk = addedMilk;
    }

    public void setAddedBeans(int addedBeans) {
        this.addedBeans = addedBeans;
    }

    public void setAddedCups(int addedCups) {
        this.addedCups = addedCups;
    }
    public void setAddedCash(int addedCash) {
        this.addedCash = addedCash;
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

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }





    boolean canMakeCoffee(int waterNeeded, int milkNeeded, int beansNeeded) {
        return water >= waterNeeded &&
                milk >= milkNeeded &&
                beans >= beansNeeded &&
                cups >= 1;
    }
    public void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {





        if (canMakeCoffee(waterNeeded, milkNeeded, beansNeeded)) {
            bool = true;
            water -= waterNeeded ;
            milk -= milkNeeded ;
            beans -= beansNeeded ;
            cups-- ;
            cash += price ;



        } else {
            StringBuilder sb = new StringBuilder();
            if (water < waterNeeded) {
                sb.append("water");
            } else if (milk < milkNeeded) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("milk");
            } else if (beans < beansNeeded) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("coffee beans");
            } else if (cups == 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append("disposable cups");
            }
            bool = false;
            JOptionPane.showMessageDialog(null ,String.format("Sorry, not enough %s!\n", sb.toString()), "Warning", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void makeEspresso() {
        if(Coffee.ESPRESSO.getEspresso(Coffee.WATER_ML_PER_CUP).getValue() != 0 && Coffee.ESPRESSO.getEspresso(Coffee.MILK_ML_PER_CUP).getValue() != 0&& Coffee.ESPRESSO.getEspresso(Coffee.BEANS_G_PER_CUP).getValue() !=0 && Coffee.ESPRESSO.getPrice() !=0){
            makeCoffee(Coffee.ESPRESSO.getEspresso(Coffee.WATER_ML_PER_CUP).getValue(),
                    Coffee.ESPRESSO.getEspresso(Coffee.MILK_ML_PER_CUP).getValue(),
                    Coffee.ESPRESSO.getEspresso(Coffee.BEANS_G_PER_CUP).getValue(),
                    Coffee.ESPRESSO.getPrice());
        }
    }

    public void makeLatte() {
        if(Coffee.LATTE.getLatte(Coffee.WATER_ML_PER_CUP).getValue() != 0 &&Coffee.LATTE.getLatte(Coffee.MILK_ML_PER_CUP).getValue() != 0&& Coffee.LATTE.getLatte(Coffee.BEANS_G_PER_CUP).getValue() !=0 && Coffee.LATTE.getPrice() !=0) {
            makeCoffee(Coffee.LATTE.getCappuccino(Coffee.WATER_ML_PER_CUP).getValue(),
                    Coffee.LATTE.getCappuccino(Coffee.MILK_ML_PER_CUP).getValue(),
                    Coffee.LATTE.getCappuccino(Coffee.BEANS_G_PER_CUP).getValue(),
                    Coffee.LATTE.getPrice());
        }
    }

    public void makeCappuccino() {
        if(Coffee.CAPPUCCINO.getCappuccino(Coffee.WATER_ML_PER_CUP).getValue() != 0 && Coffee.CAPPUCCINO.getCappuccino(Coffee.MILK_ML_PER_CUP).getValue() != 0 && Coffee.CAPPUCCINO.getCappuccino(Coffee.BEANS_G_PER_CUP).getValue() !=0 && Coffee.CAPPUCCINO.getPrice() !=0) {
            makeCoffee(Coffee.CAPPUCCINO.getCappuccino(Coffee.WATER_ML_PER_CUP).getValue(),
                Coffee.CAPPUCCINO.getCappuccino(Coffee.MILK_ML_PER_CUP).getValue(),
                Coffee.CAPPUCCINO.getCappuccino(Coffee.BEANS_G_PER_CUP).getValue(),
                Coffee.CAPPUCCINO.getPrice());
        }
    }

    public void doBuyCoffee(JSpinner cup1, JSpinner cup2, JSpinner cup3) {


            espresso_order = (Integer) cup1.getValue();
            latte_order = (Integer)cup2.getValue();
            cappuccino_order = (Integer) cup3.getValue();

            if(espresso_order != 0){
                makeEspresso();
            }
            else if(latte_order != 0){
                makeLatte();
            }
            else if(cappuccino_order != 0){
                makeCappuccino();
            }
    }

    public void doFilling() {

        water += addedWater;
        milk += addedMilk;
        beans += addedBeans;
        cups += addedCups;
        cash += addedCash;
    }

    public void doTakeMoney() {
        int ask = JOptionPane.showConfirmDialog(null, "Are you sure to take all cash?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(ask==1){
        }else{
            JOptionPane.showMessageDialog(null,"I gave you €" + cash );
            cash = 0;
        }
    }

    public void doReset() {
        int ask = JOptionPane.showConfirmDialog(null, "Are you sure to reset?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(ask==1){
        }else{
            JOptionPane.showMessageDialog(null,"reset complete" );
            water = 0;
            beans = 0;
            milk = 0;
            cash = 0;
            cups =0;
        }
    }

}


