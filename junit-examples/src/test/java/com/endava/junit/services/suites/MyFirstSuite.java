package com.endava.junit.services.suites;

import com.endava.junit.services.CaloryIntakeServiceTest;
import com.endava.junit.services.FirstTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CaloryIntakeServiceTest.class, FirstTest.class})
public class MyFirstSuite {

}
