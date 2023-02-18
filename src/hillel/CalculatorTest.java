package hillel;

import hillel.anotation.AfterSuite;
import hillel.anotation.BeforeSuite;
import hillel.anotation.Test;

public class CalculatorTest {
    private Calculator calculator;

    public CalculatorTest() {
    }

    @BeforeSuite
    public void setUp(){
        calculator = new Calculator();
        System.out.println("This is start");
    }
    @Test (priority = 6)
    public void addTest(){
        double a = 50;
        double b = 40;
        double expected = 90;
        double actual = calculator.addition(50,40);
        assert expected == actual;
        System.out.println("addTest");
    }
    @Test
    public void subTest(){
        double a = 50;
        double b = 40;
        double expected = 10;
        double actual = calculator.subtraction(50,40);
        assert expected == actual;
        System.out.println("subTest");
    }
    @AfterSuite
    public void finishedDown(){
        System.out.println("This is finish");
    }

}
