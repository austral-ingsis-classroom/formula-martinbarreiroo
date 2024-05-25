package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";

    Function six = new Number(6);
    Function one = new Number(1);
    Function function = new Operation(one, six, '+');
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";

    Function twelve = new Number(12);
    Function two = new Number(2);
    Function function = new Operation(twelve, two, '/');
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "(9 / 2) * 3";

    Function nine = new Number(9);
    Function two = new Number(2);
    Function three = new Number(3);
    Function function = new Operation(new Operation(nine, two, '/'), three, '*');
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "(27 / 6) ^ 2";

    Function twentySeven = new Number(27);
    Function six = new Number(6);
    Function two = new Number(2);
    Function function = new Operation(new Operation(twentySeven, six, '/'), two, '^');
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";

    Function eight = new Number(8);
    Function value = new Variable("value", 8);
    Function absValue = new Operation(value, null, '|');
    Function function = new Operation(absValue, eight, '-');
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";

    Function eight = new Number(8);
    Function value = new Variable("value", 8);
    Function absValue = new Operation(value, null, '|');
    Function function = new Operation(absValue, eight, '-');
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "(5 - i) * 8";

    Function five = new Number(5);
    Function eight = new Number(8);
    Function i = new Variable("i", 2);
    Function function = new Operation(new Operation(five, i, '-'), eight, '*');
    final String result = function.print();

    assertThat(result, equalTo(expected));
  }
}
