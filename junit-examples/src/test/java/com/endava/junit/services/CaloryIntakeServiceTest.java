package com.endava.junit.services;

import com.endava.junit.exceptions.NegativeCaloryException;
import com.endava.junit.model.FoodItem;
import com.endava.junit.model.Item;
import com.endava.junit.services.categories.LongRunningCategories;
import com.endava.junit.services.categories.SmokeCategories;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

public class CaloryIntakeServiceTest {

    private CaloryIntakeService serviceUnderTest;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void setUpForAll()
    {
        //apeleaza doar metode statice
        System.out.println("----before class-----");
    }

    @Before
    public void setUp()
    {
        serviceUnderTest = new CaloryIntakeService();
        System.out.println("--------Before---------");
    }

    //curatenie dupa fiecare test
    @After
    public void tearDown()
    {
        System.out.println("Cleaning code...");
    }


    //curatenie dupa toate testele
    @AfterClass
    public static void tearDownForAll()
    {
        //apeleaza doar metode statice
        System.out.println("----after class-----");
    }

    @Category(SmokeCategories.class)
    @Test
    public void setDailyGoal_WhenSetting1000_ExpectDailyGoalSet() throws NegativeCaloryException
    {
        //Arrange
        setUp();

        //Act
        serviceUnderTest.setDailyGoal(1000);

        //Assert
        Assert.assertEquals("Daily goal is not 1000", 1000, serviceUnderTest.getDailyGoal());
        Assert.assertTrue(1000 == serviceUnderTest.getDailyGoal());

    }

    //asteapta sa arunce NegativeCaloryException
    @Category({LongRunningCategories.class, SmokeCategories.class})
    @Test(expected = NegativeCaloryException.class)
    public void setDailyGoal_WhenSettingNegativeValue_ExpectDailyGoalZero()throws NegativeCaloryException
    {
        //Arrange
        setUp();

        //Act
        serviceUnderTest.setDailyGoal(-1);

        //Assert
        Assert.assertTrue(serviceUnderTest.getDailyGoal() == 0);

    }


    @Test
    public void addItem_WhenAddingFoodItem_ExpectTotalIncreased() throws NegativeCaloryException
    {
        //Arrange
        setUp();
        serviceUnderTest.setTotal(600);
        serviceUnderTest.setDailyGoal(1500);
        FoodItem item = new FoodItem("Shaorma", 1000);

        //Act
        serviceUnderTest.addItem(item);

        //Assert
        int total = serviceUnderTest.getTotal();
        Assert.assertTrue("Total was not increasd after adding food item!",
                total == 1600);
        Assert.assertTrue("Item was not added!",
                serviceUnderTest.containsItem(item));

    }



    @Category(LongRunningCategories.class)
    @Test//(Rule = thrown)
    public void setDailyGoal_WhenSettingNegativeValue_ExpectedException() throws NegativeCaloryException
    {
        //Arrange
        thrown.expect(NegativeCaloryException.class);
        thrown.expectMessage("Daily goal negative!");
        //Act
        serviceUnderTest.setDailyGoal(-1);

        //Assert


    }


    @Test(timeout = 10)
    @Ignore
    public void reallyLongTest()
    {
        //Arrange
        for(int i=0; i < 9000000; i++)
        {
            System.out.println("i");
        }

    }


}
