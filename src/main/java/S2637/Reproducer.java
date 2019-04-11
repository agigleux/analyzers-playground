package S2637;

import android.support.annotation.NonNull;

public class Reproducer {

  @NonNull
  private final String a;

  Reproducer() {
    this("test");
  }

  private Reproducer(@NonNull String b) {
    this.a = b;
  }
}
