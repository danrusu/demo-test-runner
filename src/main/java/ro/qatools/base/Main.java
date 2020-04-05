package ro.qatools.base;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Runner runner = new Runner();
        runner.run(List.of(
                "ro.qatools.test.Test1",
                "ro.qatools.test.Test2"
        ));

        System.out.printf("\nPassed: %d, Failed: %d",
                runner.getPassed(), runner.getTests() - runner.getPassed());
    }
}
