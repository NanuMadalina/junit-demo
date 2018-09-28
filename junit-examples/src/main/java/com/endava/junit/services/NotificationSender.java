package com.endava.junit.services;

import com.endava.junit.exceptions.NotificationServiceException;

/**
 * Created by astoicovici on 9/27/2018.
 */
public class NotificationSender {

    public void sendNotification(final String message) throws NotificationServiceException {
        ////
        // Some third party libraries used
        // and business logic
        ////
        System.out.println("--- Real implementation of NotificationSender ---");
        System.out.println(message);
    }

    public boolean sendNotification() throws NotificationServiceException
    {
        System.out.println("--Real implementantion of NotificationSender----");
        System.out.println("Default message!");
        return true;
    }
}
