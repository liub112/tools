package orm.decorator;

public class Cream extends Food {
    private Food basicFood;

    public Cream(Food basicFood) {
        this.basicFood = basicFood;
    }

    @Override
    public String make() {
        return basicFood.make()+"+奶油";
    }
}
