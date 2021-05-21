package be.bxl.formation.exo_03_recyclerview.models;

public class Food {

    public enum Category {
        VEGETABLE,
        MEAT,
        FRUIT
    }

    private String name;
    private double calory;
    private Category category;

    public Food(String name, double calory, Category category) {
        this.name = name;
        this.calory = calory;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalory() {
        return calory;
    }

    public void setCalory(double calory) {
        this.calory = calory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
