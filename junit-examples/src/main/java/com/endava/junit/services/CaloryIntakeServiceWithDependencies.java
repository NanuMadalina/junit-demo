package com.endava.junit.services;

import com.endava.junit.model.ArchiveEntry;
import com.endava.junit.model.Item;
import com.endava.junit.exceptions.NotificationServiceException;
import com.endava.junit.model.Operation;
import com.endava.junit.model.SportsItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by astoicovici on 9/27/2018.
 */
public class CaloryIntakeServiceWithDependencies {

    private int total;
    private int dailyGoal;

    private CaloryDiaryService diary = new CaloryDiaryService();
    private NotificationSender notificationSender = new NotificationSender();

    private List<Item> items = new ArrayList();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDailyGoal() {
        return dailyGoal;
    }

    public void setDailyGoal(int dailyGoal) {
        this.dailyGoal = dailyGoal;
    }

    public void addItem(Item item) {
        if (item instanceof SportsItem) {
            total = total - item.getCalories();
        } else {
            total += item.getCalories();
        }
        applyTotalCorrection();
        if (isDailyGoalExceeded()) {
            try {
                notificationSender.sendNotification("Daily goal exceeded");
                //notificationSender.sendNotification();
                notificationSender.sendNotification();
            } catch (NotificationServiceException e) {
               // TODO LOG this exception
            }
        }
        items.add(item);
        diary.addArchiveEntry(new ArchiveEntry(LocalDateTime.now(), item, Operation.ADD));
    }

    public void removeItem(Item item) {
        if (item instanceof SportsItem) {
            total += item.getCalories();
        } else {
            total = total - item.getCalories();
        }

        applyTotalCorrection();
        items.remove(item);
        diary.addArchiveEntry(new ArchiveEntry(LocalDateTime.now(), item, Operation.DELETE));
    }

    public boolean isDailyGoalExceeded() {
        return total >= dailyGoal;
    }

    public double getCompletionPercentage() {
        return Math.round(total * 100 / dailyGoal * 100.0) / 100.0;
    }

    public int getRemainingCalories() {
        if (dailyGoal >= total) {
            return dailyGoal - total;
        }
        return 0;
    }

    public boolean containsItem(Item item) {
        return items.contains(item);
    }

    private void applyTotalCorrection() {
        if(total < 0) {
            total = 0;
        }
    }
}
