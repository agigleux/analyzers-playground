package android;

import android.text.TextUtils;

public class S2637_Android_TextUtils_isEmpty {

  public void test(String param1) {
    if (TextUtils.isEmpty(param1)) {
      return;
    }

    System.out.println(param1.length()); // no issue expected here
  }

}
