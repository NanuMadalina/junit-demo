package com.endava.junit.model;

/**
 * Created by astoicovici on 9/26/2018.
 */
public class FoodItem extends Item {

    private String description;

    public FoodItem(String name, int calories) {
        super(name, calories);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + " description: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItem)) return false;
        if (!super.equals(o)) return false;

        FoodItem foodItem = (FoodItem) o;

        return description != null ? description.equals(foodItem.description) : foodItem.description == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
