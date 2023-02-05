package hillel;

import hillel.anotation.AfterSuite;
import hillel.anotation.BeforeSuite;
import hillel.anotation.Test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

    @Test
    public void testMyMethod() {

        System.out.println("This is Test annotation");
    }

    @AfterSuite
    public void afterMyMethod()  {


        System.out.println("This is AfterSuite annotation");
    }

    @BeforeSuite
    public void beforeMyMethod()  {

        System.out.println("This is BeforeSuite annotation");


    }

    public static void start(TestRunner c) throws InvocationTargetException, IllegalAccessException {

        for (Method method : c.getClass().getMethods()) {
           if (method.isAnnotationPresent(Test.class)) {
               // int test =
                        method.getDeclaredAnnotation(Test.class).priority();

                method.invoke(c);
            }

            if (method.isAnnotationPresent(BeforeSuite.class)) {
               // int beforeSuite =
                        method.getDeclaredAnnotation(BeforeSuite.class).priority();
                method.invoke(c);
            }

            if (method.isAnnotationPresent(AfterSuite.class)) {
              //  int afterSuite =
                        method.getDeclaredAnnotation(AfterSuite.class).priority();
                method.invoke(c);
            }

        }

    }
}