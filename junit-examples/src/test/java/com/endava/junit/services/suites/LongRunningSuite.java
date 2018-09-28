package com.endava.junit.services.suites;

import com.endava.junit.services.CaloryIntakeServiceTest;
import com.endava.junit.services.FirstTest;
import com.endava.junit.services.categories.LongRunningCategories;
import com.endava.junit.services.categories.SmokeCategories;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(SmokeCategories.class)
@Categories.IncludeCategory(LongRunningCategories.class)
@Suite.SuiteClasses(
        {CaloryIntakeServiceTest.class,
            FirstTest.class })
public class LongRunningSuite {


}
