import javax.swing.*;
import java.io.IOException;
import java.util.Objects;

public class Run {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Coffee espresso  = Coffee.ESPRESSO;
                Coffee latte  = Coffee.LATTE;
                Coffee cappuccino  = Coffee.CAPPUCCINO;


                CoffeeMachine coffeeMachine = new CoffeeMachine(100,100,100,20,500);

                CoffeeMachineTextUI coffeeMachineTextUI = new CoffeeMachineTextUI();

                Home home = new Home();
                Remaining remaining = new Remaining();
                Recipe recipe = new Recipe();
                Fill fill = new Fill();
                Key key = new Key();

                String title = "CoffeeMachine";

                home.setTitle(title);
                remaining.setTitle(title);
                recipe.setTitle(title);
                fill.setTitle(title);
                key.setTitle(title);

                key.setRemaining(remaining);
                fill.setRemaining(remaining);
                recipe.setRemaining(remaining);
                remaining.setFill(fill);
                remaining.setRecipe(recipe);
                home.setKey(key);
                remaining.setHome(home);
                key.setHome(home);


                coffeeMachineTextUI.setState(remaining, coffeeMachine);
                coffeeMachineTextUI.labelPriceTag(home);



                fill.setButton.addActionListener(e -> {
                    fill.setWater(Integer.parseInt(fill.getSpinner1().getValue().toString()));
                    fill.setMilk(Integer.parseInt(fill.getSpinner2().getValue().toString()));
                    fill.setCoffeebeans(Integer.parseInt(fill.getSpinner3().getValue().toString()));
                    fill.setCups(Integer.parseInt(fill.getSpinner4().getValue().toString()));
                    fill.setMoney(Integer.parseInt(fill.getSpinner5().getValue().toString()));

                    coffeeMachine.setAddedWater(fill.getWater());
                    coffeeMachine.setAddedMilk(fill.getMilk());
                    coffeeMachine.setAddedBeans(fill.getCoffeebeans());
                    coffeeMachine.setAddedCups(fill.getCups());
                    coffeeMachine.setAddedCash(fill.getMoney());
                    coffeeMachine.doFilling();

                    coffeeMachineTextUI.setState(remaining, coffeeMachine);


                    JOptionPane.showMessageDialog(null, "Done");
                    fill.getRemaining();
                    fill.setVisible(false);

                });

                remaining.takeMoneyButton.addActionListener(e -> {
                    coffeeMachine.doTakeMoney();
                    coffeeMachine.setCash(coffeeMachine.getCash());
                    coffeeMachineTextUI.setState(remaining, coffeeMachine);
                });

                remaining.resetButton.addActionListener(e -> {
                    coffeeMachine.doReset();
                    coffeeMachineTextUI.setState(remaining, coffeeMachine);
                });

                recipe.saveButton.addActionListener(e -> {
                        if(Objects.equals(recipe.getComboBox1().getSelectedItem(), espresso.getName())){
                            recipe.setWater((Integer) recipe.getSpinner1().getValue());
                            recipe.setMilk((Integer) recipe.getSpinner2().getValue());
                            recipe.setCoffeebeans((Integer) recipe.getSpinner3().getValue());
                            recipe.setPrice((Integer) recipe.getSpinner4().getValue());

                            espresso.getEspresso(Coffee.WATER_ML_PER_CUP).setValue(recipe.getWater());
                            espresso.getEspresso(Coffee.MILK_ML_PER_CUP).setValue(recipe.getMilk());
                            espresso.getEspresso(Coffee.BEANS_G_PER_CUP).setValue(recipe.getCoffeebeans());
                            espresso.setPrice(recipe.getPrice());

                            JOptionPane.showMessageDialog(null, String.format("Recipe of %s was saved", espresso.getName()));



                        }
                        if (Objects.equals(recipe.getComboBox1().getSelectedItem(), latte.getName())) {
                            recipe.setWater((Integer) recipe.getSpinner1().getValue());
                            recipe.setMilk((Integer) recipe.getSpinner2().getValue());
                            recipe.setCoffeebeans((Integer) recipe.getSpinner3().getValue());
                            recipe.setPrice((Integer) recipe.getSpinner4().getValue());

                            latte.getLatte(Coffee.WATER_ML_PER_CUP).setValue(recipe.getWater());
                            latte.getLatte(Coffee.MILK_ML_PER_CUP).setValue(recipe.getMilk());
                            latte.getLatte(Coffee.BEANS_G_PER_CUP).setValue(recipe.getCoffeebeans());
                            latte.setPrice(recipe.getPrice());

                            JOptionPane.showMessageDialog(null, String.format("Recipe of %s was saved", latte.getName()));


                        }
                        if (Objects.equals(recipe.getComboBox1().getSelectedItem(), cappuccino.getName())) {

                            recipe.setWater((Integer) recipe.getSpinner1().getValue());
                            recipe.setMilk((Integer) recipe.getSpinner2().getValue());
                            recipe.setCoffeebeans((Integer) recipe.getSpinner3().getValue());
                            recipe.setPrice((Integer) recipe.getSpinner4().getValue());

                            cappuccino.getCappuccino(Coffee.WATER_ML_PER_CUP).setValue(recipe.getWater());
                            cappuccino.getCappuccino(Coffee.MILK_ML_PER_CUP).setValue(recipe.getMilk());
                            cappuccino.getCappuccino(Coffee.BEANS_G_PER_CUP).setValue(recipe.getCoffeebeans());
                            cappuccino.setPrice(recipe.getPrice());

                            JOptionPane.showMessageDialog(null, String.format("Recipe of %s was saved", cappuccino.getName()));

                        }
                });

                recipe.seeButton.addActionListener(e -> {
                    if(Objects.equals(recipe.getComboBox1().getSelectedItem(), espresso.getName())){
                        JOptionPane.showMessageDialog(null, String.format("Recipe of %s: Water %d ml, Milk %d ml, Coffee Beans: %d cup, Price: %d €", espresso.getName(), espresso.getEspresso(Coffee.WATER_ML_PER_CUP).getValue(), espresso.getEspresso(Coffee.MILK_ML_PER_CUP).getValue(), espresso.getEspresso(Coffee.BEANS_G_PER_CUP).getValue(), espresso.getPrice()));

                    } else if (Objects.equals(recipe.getComboBox1().getSelectedItem(), latte.getName())) {
                        JOptionPane.showMessageDialog(null, String.format("Recipe of %s: Water %d ml, Milk %d ml, Coffee Beans: %d cup, Price: %d €", latte.getName(), latte.getLatte(Coffee.WATER_ML_PER_CUP).getValue(), latte.getLatte(Coffee.MILK_ML_PER_CUP).getValue(), latte.getLatte(Coffee.BEANS_G_PER_CUP).getValue(), latte.getPrice()));

                    }else if (Objects.equals(recipe.getComboBox1().getSelectedItem(), cappuccino.getName())) {
                        JOptionPane.showMessageDialog(null, String.format("Recipe of %s: Water %d ml, Milk %d ml, Coffee Beans: %d cup, Price: %d €", cappuccino.getName(), cappuccino.getCappuccino(Coffee.WATER_ML_PER_CUP).getValue(), cappuccino.getCappuccino(Coffee.MILK_ML_PER_CUP).getValue(), cappuccino.getCappuccino(Coffee.BEANS_G_PER_CUP).getValue(), cappuccino.getPrice()));
                    }


                });

                home.buyButton.addActionListener(e -> {
                    coffeeMachine.doBuyCoffee(home.getSpinner1(), home.getSpinner2(), home.getSpinner3());
                    coffeeMachineTextUI.buyMessage(coffeeMachine.bool);
                    coffeeMachineTextUI.setState(remaining, coffeeMachine);

                });
                key.activateButton.addActionListener(e -> {

                    if(String.valueOf(key.getPasswordField1().getPassword()).equals("12345678")) {
                        JOptionPane.showMessageDialog(null,
                                "Machine was Activated", "Activator", JOptionPane.PLAIN_MESSAGE);
                        key.dispose();
                        coffeeMachineTextUI.setState(remaining, coffeeMachine);
                        key.getRemaining();
                    }else{
                        key.dispose();
                        JOptionPane.showMessageDialog(null,
                                "Something went wrong please try again",
                                "Activator",
                                JOptionPane.ERROR_MESSAGE);
                        key.getHome();
                    }
                });

                remaining.backButton.addActionListener(e -> {
                    remaining.dispose();
                    coffeeMachineTextUI.labelPriceTag(home);
                    remaining.getHome();
                });




            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
