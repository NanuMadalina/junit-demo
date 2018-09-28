package com.endava.junit.services;

import com.endava.junit.exceptions.NotificationServiceException;
import com.endava.junit.model.FoodItem;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//sorteaza testele im ordine alfabetica
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CaloryIntakeServiceWithDependeciesTest {

//    @Mocked
//    private NotificationSender notificationSender = new NotificationSender();


    @Test
    public void addItem_WhenAddingFoodItem_ExpectNotificationSent()
    {
        //Arrange
        CaloryIntakeServiceWithDependencies service = new CaloryIntakeServiceWithDependencies();
        service.setDailyGoal(1000);
        service.setTotal(900);
        FoodItem foodItem = new FoodItem("Ice cream", 250);

        //Act
        service.addItem(foodItem);

        //Assert
    }


    @Test
    public void addItem_WhenAddingFoodItem_ExpectNotificationSent2(@Mocked NotificationSender notificationSender) throws NotificationServiceException {
        //Arrange
        CaloryIntakeServiceWithDependencies service = new CaloryIntakeServiceWithDependencies();
        service.setDailyGoal(1000);
        service.setTotal(900);
        FoodItem foodItem = new FoodItem("Ice cream", 250);

        new Expectations(){{
            notificationSender.sendNotification();
            result = false;//trimit raspunsul false din proxi
            minTimes = 0;
            notificationSender.sendNotification((String)any);
            result = new NotificationServiceException("test");
        }};

        //Act
        service.addItem(foodItem);

        //Assert
        new Verifications(){{
            String message;

            notificationSender.sendNotification(); times = 1;//de cate ori a fost apelata
            notificationSender.sendNotification(message = withCapture());
            Assert.assertEquals(message, "Daily goal exceeded");

        }};
    }


    @Test
    public void sendNotificationMocked(@Mocked NotificationSender notificationSender) throws NotificationServiceException {
        //Arrange
        CaloryIntakeServiceWithDependencies service = new CaloryIntakeServiceWithDependencies();
        service.setDailyGoal(1000);
        service.setTotal(900);
        FoodItem foodItem = new FoodItem("Ice cream", 250);


        new Expectations(){{
            notificationSender.sendNotification();
            result = new Delegate() {
                //override metoda originala
                public boolean overrideSendNotification()
                {
                    System.out.println("-----NotificationSender mocked!------");
                    return true;
                }
            };

        }};
        //Act
        service.addItem(foodItem);

        //Assert
    }
}
