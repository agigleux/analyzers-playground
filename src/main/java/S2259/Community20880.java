package S2259;

import java.util.List;
import java.util.Map;

//import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections.MapUtils;

public class Community20880 {

  private void privateMethod1(Map<Long, ContractDefContextEntity> aMap, List<String> aList) {
    if (aMap == null) {
      // Empty
    }

    if (!MapUtils.isEmpty(aMap)) {
      aMap.get("123"); // FP with SonarJava 6.1
    }

    if (aList == null) {
      // Empty
    }
    if (!CollectionUtils.isEmpty(aList)) {
      aList.get(1); // Compliant: no issue raised with SonarJava 6.1 for List
    }
  }

  private void privateMethod2(Map<Long, ContractDefContextEntity> aMap, List<String> aList) {
    if (aMap == null) {

      if (!MapUtils.isEmpty(aMap)) {
        aMap.get("123"); // TP with SonarJava 6.1
      }

    }

    if (aMap != null) {

      if (!MapUtils.isEmpty(aMap)) {
        aMap.get("123"); // Compliant: TN with SonarJava 6.1
      }

    }
  }

}
