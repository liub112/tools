package orm.decorator;

public class Food {
    private String foodName;

    public Food(){}

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public String make(){
        return foodName;
    }
}
