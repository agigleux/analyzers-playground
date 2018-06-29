package org.sonarlint.hotspots;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VeryNotSecuredCodeTest {

  @Test
  public void dummyTest() {
    VeryNotSecuredCode app = new VeryNotSecuredCode();
    assertEquals(app.stupidMethod(), "tagada");
  }

}
