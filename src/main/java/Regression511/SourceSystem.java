package Regression511;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class SourceSystem {

  @JsonSerialize(using = StringBooleanSerialiser.class)
  private boolean totalSystemTypeTested;

  public boolean isTotalSystemTypeTested() {
    return this.totalSystemTypeTested;
  }

  public void setTotalSystemTypeTested(boolean totalSystemTypeTested) {
    this.totalSystemTypeTested = totalSystemTypeTested;
  }

}
