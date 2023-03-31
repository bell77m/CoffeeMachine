public interface Scene extends RemainingScene, HomeScene, FillScene, RecipeScene, KeyScene{
}
interface RemainingScene {

    void setRemaining(Remaining remaining);
    void getRemaining();
}

interface HomeScene {

    void setHome(Home home);
    void getHome();
}

interface FillScene {

    void setFill(Fill fill);
    void getFill();
}

interface RecipeScene {

    void setRecipe(Recipe recipe);
    void getRecipe();
}

interface KeyScene {
    void setKey(Key key);
    void getKey();
}
