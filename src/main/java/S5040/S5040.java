package S5040;

import java.util.ArrayList;
import java.util.List;

public class S5040 {

  public static void main(String[] args) {
    List<String> list = (List<String>) getAttributes(); // Noncompliant; List<Integer> return by getAttributes() is not be casted to List<String> 
    String s = list.get(0); // java.lang.ClassCastException will be raised here
  }

  private static List<?> getAttributes() {
    List<Integer> result = new ArrayList<>();
    result.add(0);
    return result;
  }

}
