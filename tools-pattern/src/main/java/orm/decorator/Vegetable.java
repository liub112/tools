package orm.decorator;

public class Vegetable extends Food {
    private Food basicFood;

    public Vegetable(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make()+"+蔬菜";
    }
}
