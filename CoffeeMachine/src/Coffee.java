import java.util.Arrays;

public enum Coffee {

    ESPRESSO("Espresso" , new CoffeeNeeded(), 0), LATTE("Latte", new CoffeeNeeded(), 0), CAPPUCCINO("Cappuccino",new CoffeeNeeded(), 0);



    private String name;
    private CoffeeNeeded coffeeNeeded ;
    public static final int WATER_ML_PER_CUP = 0;
    public static final int MILK_ML_PER_CUP = 1;
    public static final int BEANS_G_PER_CUP = 2;


    private int price;

     private static class CoffeeNeeded{

         interface Value{
             void setValue(int value);
             int getValue();
         }

        enum Espresso implements Value{
            ESPRESSO_WATER_ML_PER_CUP(0), ESPRESSO_MILK_ML_PER_CUP(0), ESPRESSO_BEANS_G_PER_CUP(0);

            private int value;
            Espresso(int value){
                this.value = value;
            }

            @Override
            public void setValue(int value) {
                this.value= value;
            }

            public int getValue() {
                return value;
            }
        }
         enum Latte implements Value{
             LATTE_WATER_ML_PER_CUP(0), LATTE_MILK_ML_PER_CUP(0), LATTE_BEANS_G_PER_CUP(0);

             private int value;
             Latte(int value){
                 this.value = value;
             }

             @Override
             public void setValue(int value) {
                 this.value= value;
             }

             public int getValue() {
                 return value;
             }
         }
         enum Cappuccino implements Value{
             CAPPUCCINO_WATER_ML_PER_CUP(0), CAPPUCCINO_MILK_ML_PER_CUP(0), CAPPUCCINO_BEANS_G_PER_CUP(0);

             private int value;
             Cappuccino(int value){
                 this.value = value;
             }


             @Override
             public int getValue() {
                 return value;
             }

             @Override
             public void setValue(int value) {
                 this.value = value;
             }
         }
         public Espresso[] getEspresso() {
             return Espresso.values();
         }
         public Latte[] getLatte() {
             return Latte.values();
         }

         public Cappuccino[] getCappuccino() {
             return Cappuccino.values();
         }


    }


    Coffee(String name, CoffeeNeeded coffeeNeeded, int price){
         this.coffeeNeeded = coffeeNeeded;
         this.name = name;
         this.price = price;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public CoffeeNeeded.Espresso getEspresso(int indx){
         return Arrays.asList(Coffee.ESPRESSO.coffeeNeeded.getEspresso()).get(indx);
    }
    public CoffeeNeeded.Latte getLatte(int indx){
        return Arrays.asList(Coffee.LATTE.coffeeNeeded.getLatte()).get(indx);
    }
    public CoffeeNeeded.Cappuccino getCappuccino(int indx){
        return Arrays.asList(Coffee.CAPPUCCINO.coffeeNeeded.getCappuccino()).get(indx);
    }

}






