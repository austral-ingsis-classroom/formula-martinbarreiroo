package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function one = new Number(1);
    Function six = new Number(6);
    Function function = new Operation(one, six, '+');
    final List<String> result = function.listVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function div = new Variable("div", 2);
    Function twelve = new Number(12);
    Function function = new Operation(twelve, div, '/');
    final List<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function x = new Variable("x", 3);
    Function y = new Variable("y", 4);
    Function nine = new Number(9);
    Function function = new Operation(new Operation(nine, x, '/'), y, '*');
    final List<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function a = new Variable("a", 9);
    Function b = new Variable("b", 3);
    Function twentySeven = new Number(27);
    Function function = new Operation(new Operation(twentySeven, a, '/'), b, '^');
    final List<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function z = new Variable("z", 36);
    Function half = new Number(0.5);
    Function function = new Operation(z, half, '^');
    final List<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function value = new Variable("value", -10);
    Function eight = new Number(8);
    Function absValue = new Operation(value, null, '|');
    Function function = new Operation(absValue, eight, '-');

    final List<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {

    Function value = new Variable("value", -10);
    Function eight = new Number(8);
    Function absValue = new Operation(value, null, '|');
    Function function = new Operation(absValue, eight, '-');

    final List<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {

    Function i = new Variable("i", 2);
    Function five = new Number(5);
    Function eight = new Number(8);
    Function function = new Operation(new Operation(five, i, '-'), eight, '*');

    final List<String> result = function.listVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
