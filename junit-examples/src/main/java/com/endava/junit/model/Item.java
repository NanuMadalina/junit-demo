package com.endava.junit.model;

public abstract class Item {

	private int id;
	private String name;
	private int calories;
	
	public Item(String name, int calories) {
		this.name = name;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	@Override
	public String toString() {
		return "name: " + name + "; calories: " + calories;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Item item = (Item) o;

		if (calories != item.calories) return false;
		return name.equals(item.name);
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + calories;
		return result;
	}

}
