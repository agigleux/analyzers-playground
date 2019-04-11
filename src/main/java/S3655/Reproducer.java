package S3655;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Reproducer {

  public int m1(Map<String, List<String>> map1, Map<Integer, Set<String>> map2) {
    for (String u : map1.keySet()) {
      Optional<Integer> v = map2.entrySet().stream().filter(entry -> entry.getValue().contains(u)).map(Map.Entry::getKey).findFirst();
      if (v.isPresent()) {
        return v.get();
      }
    }
    return 0;
  }

  public int m2(Map<String, List<String>> map1, Map<Integer, Set<String>> map2) {
    Set<String> keys = map1.keySet();
    for (Map.Entry<Integer, Set<String>> entry : map2.entrySet()) {
      Set<String> intersection = new HashSet<>(entry.getValue());
      intersection.retainAll(keys);
      if (!intersection.isEmpty()) {
        return entry.getKey();
      }
    }
    return 0;
  }

}
