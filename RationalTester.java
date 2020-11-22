import java.util.Random;


public class RationalTester {

  public static void main(String[] args) {
    testCreationAndGets();
    testReciprocals();
    testEquals();
    testString();
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

  public static void testReciprocals() {
    boolean[] testResults = new boolean[5];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = (one.reciprocal().getValue() == 0);
    testResults[1] = (two.reciprocal().getValue() == 0);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(-0, -100);

    testResults[2] = (one.reciprocal().getValue() == -0.4);
    testResults[3] = (two.reciprocal().getValue() == 0);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();
      int first = rng.nextInt();
      int second = rng.nextInt();
      RationalNumber ratNum = new RationalNumber(first, second);

      double expected = 0.0;
      if (first != 0) expected = (Double.valueOf(second) / Double.valueOf(first));

      if (ratNum.reciprocal().getValue() != expected) {
        testResults[4] = false;
        break;
      } else if (i == 99) {
        testResults[4] = true;
      }
    }

    printResults(testResults, "Test Reciprocals");
  }

  public static void testEquals() {
    boolean[] testResults = new boolean[5];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = one.equals(two);

    one = new RationalNumber(5, -2);
    two = new RationalNumber(-0, -100);

    testResults[1] = !one.equals(two);

    one = new RationalNumber(8, -4);
    two = new RationalNumber(8, -4);

    testResults[2] = one.equals(two);

    two = new RationalNumber(4, -2);

    testResults[3] = !one.equals(two);

    for (int i = 0; i < 100; i++) {
      Random rng = new Random();

      int first = rng.nextInt(10) + 1;
      int second = rng.nextInt(10) + 1;

      int third = rng.nextInt(10) + 1;
      int fourth = rng.nextInt(10) + 1;

      RationalNumber ratNum = new RationalNumber(first, second);
      RationalNumber ratNumTwo = new RationalNumber(third, fourth);

      boolean expected = ((first == third) && (second == fourth));

      if (ratNum.equals(ratNumTwo) != expected) {
        testResults[4] = false;
        break;
      } else if (i == 99) {
        testResults[4] = true;
      }
    }

    printResults(testResults, "Test Equals");
  }

  public static void testString() {
    boolean[] testResults = new boolean[6];

    RationalNumber one = new RationalNumber(0, 1);
    RationalNumber two = new RationalNumber(1, 0);

    testResults[0] = one.toString().equals("0");
    testResults[1] = two.toString().equals("0");

    one = new RationalNumber(5, -2);
    two = new RationalNumber(-0, -100);

    testResults[2] = one.toString().equals("5/-2");
    testResults[3] = two.toString().equals("0");

    one = new RationalNumber(-99, 1);
    two = new RationalNumber(4, 3);

    testResults[4] = one.toString().equals("-99");
    testResults[5] = two.toString().equals("4/3");

    printResults(testResults, "Test toString");
  }

  public static void printResults(boolean[] results, String testName) {
    for (int i = 0; i < results.length; i++) {
      char toShow = 'T';
      if (!results[i]) toShow = 'F';
      System.out.println(testName + " TEST #" + i + ": " + toShow);
    }
  }
}