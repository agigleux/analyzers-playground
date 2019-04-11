package android;

import android.support.annotation.NonNull;

public class MinimalisticExample {

  @NonNull
  private final Foo a;
  @NonNull
  private final String b;

  public MinimalisticExample(@NonNull String b) {
    this(new Foo(), b);
  }

  private MinimalisticExample(@NonNull Foo a, @NonNull String b) {
    this.a = a;
    this.b = b;
  }

  static class Foo {

    Foo() {

    }
  }

}
