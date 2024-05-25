package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {

    Function six = new Number(6);
    Function one = new Number(1);
    Function function = new Operation(one, six, '+');
    final Double result = function.calculate();

    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {

    Function twelve = new Number(12);
    Function two = new Number(2);
    Function function = new Operation(twelve, two, '/');
    final Double result = function.calculate();
    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {

    Function nine = new Number(9);
    Function two = new Number(2);
    Function three = new Number(3);
    Function function = new Operation(new Operation(nine, two, '/'), three, '*');
    final Double result = function.calculate();

    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {

    Function twentySeven = new Number(27);
    Function six = new Number(6);
    Function two = new Number(2);
    Function function = new Operation(new Operation(twentySeven, six, '/'), two, '^');
    final Double result = function.calculate();
    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {

    Function z = new Number(36);
    Function half = new Number(0.5);
    Function function = new Operation(z, half, '^');
    final Double result = function.calculate();

    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {

    Function hundredThirtySix = new Number(136);
    Function function = new Operation(hundredThirtySix, null, '|');
    final Double result = function.calculate();
    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function hundredThirtySix = new Number(-136);
    Function function = new Operation(hundredThirtySix, null, '|');
    final Double result = function.calculate();
    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {

    Function five = new Number(5);
    Function eight = new Number(8);
    Function function = new Operation(new Operation(five, five, '-'), eight, '*');
    final Double result = function.calculate();

    assertThat(result, equalTo(0d));
  }
}
