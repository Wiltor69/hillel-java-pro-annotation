package hillel;

import hillel.anotation.AfterSuite;
import hillel.anotation.BeforeSuite;
import hillel.anotation.Test;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestRunner {

    public static void start(Class <?> c) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
            Constructor<?> constructor = c.getDeclaredConstructor();
            CalculatorTest calculatorTest = (CalculatorTest) constructor.newInstance();
        for (Method method : calculatorTest.getClass().getDeclaredMethods()) {
           if (method.isAnnotationPresent(BeforeSuite.class)) {
                method.getDeclaredAnnotation(BeforeSuite.class);
                method.invoke(calculatorTest);
            }

            if (method.isAnnotationPresent(Test.class)) {
                method.getDeclaredAnnotation(Test.class);
                method.invoke(calculatorTest);
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
                method.getDeclaredAnnotation(AfterSuite.class);
                method.invoke(calculatorTest);
            }

        }

    }
}