package com.endava.junit.services.runners;

import com.endava.junit.services.CaloryIntakeService;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class CustomRunner {
//solutie alternativa fara maven si intellij
    public static void main(String[] args) {
        JUnitCore junitCore = new JUnitCore();
        junitCore.addListener(new TextListener(System.out));
        junitCore.run(CaloryIntakeService.class);


    }

}
