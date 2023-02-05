package hillel;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException{
        TestRunner.start(TestRunner.class.newInstance());
    }

}
