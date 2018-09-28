package com.endava.junit.model;

/**
 * Created by astoicovici on 9/26/2018.
 */
public class SportsItem extends Item {

    private int duration;

    public SportsItem(String name, int calories) {
        super(name, calories);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + " duration: " + duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportsItem)) return false;
        if (!super.equals(o)) return false;

        SportsItem that = (SportsItem) o;

        return duration == that.duration;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + duration;
        return result;
    }
}
