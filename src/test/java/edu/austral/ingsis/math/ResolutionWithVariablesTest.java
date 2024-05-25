package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {

    Function xEq3 = new Variable("x", 3);
    Function one = new Number(1);
    Function function = new Operation(one, xEq3, '+');
    final Double result = function.calculate();

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {

    Function div = new Variable("div", 4);
    Function twelve = new Number(12);
    Function function = new Operation(twelve, div, '/');
    final Double result = function.calculate();

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {

    Function x = new Variable("x", 3);
    Function y = new Variable("y", 4);
    Function nine = new Number(9);
    Function function = new Operation(new Operation(nine, x, '/'), y, '*');
    final Double result = function.calculate();

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {

    Function a = new Variable("a", 9);
    Function b = new Variable("b", 3);
    Function twentySeven = new Number(27);
    Function function = new Operation(new Operation(twentySeven, a, '/'), b, '^');
    final Double result = function.calculate();

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {

    Function z = new Variable("z", 36);
    Function half = new Number(0.5);
    Function function = new Operation(z, half, '^');
    final Double result = function.calculate();

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {

    Function value = new Variable("value", 8);
    Function eight = new Number(8);
    Function absValue = new Operation(value, null, '|');
    Function function = new Operation(absValue, eight, '-');
    final Double result = function.calculate();

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Function value = new Variable("value", 8);
    Function eight = new Number(8);
    Function absValue = new Operation(value, null, '|');
    Function function = new Operation(absValue, eight, '-');
    final Double result = function.calculate();

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {

    Function i = new Variable("i", 2);
    Function five = new Number(5);
    Function eight = new Number(8);
    Function function = new Operation(new Operation(five, i, '-'), eight, '*');
    final Double result = function.calculate();

    assertThat(result, equalTo(24d));
  }
}
