package org.sonarlint;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class CupUnitTest {

  @Test
  public void testWithNoAssertion() {
    Cup myCup = new Cup();
    // Assertion left off for SonarQube testing purposes
  }

  @Test
  public void testAssertionOnTest() {
    Cup myCup = new Cup();
    assertFalse("A new cup is empty", myCup.isFilled());
  }

  @Test
  public void testNonStaticAssertionOnTest() {
    Cup myCup = new Cup();
    Assert.assertFalse("A new cup is empty", myCup.isFilled());
  }
}
