package fieldsensitive;

public class SimplePOJO {

  private String field1;
  private String field2;
  private String[] tableau1;

  public SimplePOJO(String f1, String f2) {
    this.field1 = f1;
    this.field2 = f2;
    tableau1 = new String[10];
    tableau1[8] = f1;
  }

  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public String getField2() {
    return field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }

  public String[] getTableau1() {
    return tableau1;
  }

  public void setTableau1(String[] tableau1) {
    this.tableau1 = tableau1;
  }

}
