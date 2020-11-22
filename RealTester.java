import java.util.ArrayList;
import java.util.Random;


public class RealTester {

  public static void main(String[] args) {
    testEquals();
  }

  public static void testEquals() {
    boolean[] testResults = new boolean[6];

    RealNumber one = new RealNumber(0);
    RealNumber two = new RealNumber(0);

    testResults[0] = one.equals(two);

    one = new RealNumber(-33);
    two = new RealNumber(1.222);

    testResults[1] = !one.equals(two);

    one = new RealNumber(0.0000002);
    two = new RealNumber(0.0000008);

    testResults[2] = !one.equals(two);

    one = new RealNumber(0.8455);
    two = new RealNumber(0.8455549);

    testResults[3] = !one.equals(two);

    one = new RealNumber(0.84555);
    two = new RealNumber(0.8455549);

    testResults[4] = one.equals(two);

    one = new RealNumber(-7823.0);
    two = new RealNumber(-7823.00000000000001);

    testResults[5] = one.equals(two);

    printResults(testResults, "Test Equals");
  }

  

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }
}
