import java.util.Random;


public class RationalTester {

  public static void main(String[] args) {
    testCreationAndGets();
  }

  public static void testCreationAndGets() {
    boolean[] testResults = new boolean[12];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = (one.getValue() == 0);
    testResults[1] = (two.getValue() == 0);

    testResults[2] = (one.getNumerator() == 0);
    testResults[3] = (one.getDenominator() == 1);

    testResults[4] = (one.getNumerator() == 0);
    testResults[5] = (two.getDenominator() == 1);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(-0, -100);

    testResults[6] = (one.getValue() == -2.5);
    testResults[7] = (two.getValue() == 0.0);

    testResults[8] = (one.getNumerator() == 5);
    testResults[9] = (one.getDenominator() == -2);

    testResults[10] = (two.getNumerator() == 0);
    testResults[11] = (two.getDenominator() == -100);

    printResults(testResults, "Test Creation & Gets");
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }
}
