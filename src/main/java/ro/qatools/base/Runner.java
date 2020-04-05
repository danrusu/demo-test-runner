package ro.qatools.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Runner {
    private int tests;
    private int passed;

    public Runner() { }

    public void run(List<String> testClassesNames){
        testClassesNames.forEach(this::run);
    }

    private void run(String testClassName) {
        Class<?> testClass = null;
        try {
            testClass = Class.forName(testClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for(Method method : testClass.getDeclaredMethods()){
            if (method.isAnnotationPresent(Test.class)){
                tests++;
                try{
                    method.invoke(null);
                    passed++;
                }
                catch (InvocationTargetException wrappedEx){
                    Throwable baseException = wrappedEx.getCause() ;
                    System.out.println(method + "  failed: " + baseException);
                }
                catch(Exception ex){
                    System.out.println("Invalid @Test: " + method);
                }
            }
        }
    }

    public int getTests() {
        return tests;
    }

    public int getPassed() {
        return passed;
    }
}
