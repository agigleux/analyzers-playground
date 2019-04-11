
public class BooleanNull {

  Service service = null;

  public BooleanNull() {
    service = new Service();
  }

  public void serviceNullBoolean() {
    Boolean flag = service.getFlag();
    // that's the unsafe call which could cause a null pointer exception
    if (flag) { // Noncompliant; issue expected here
      // do something
    }
  }

  public class Service {
    public Boolean getFlag() {
      return null;
    }
  }

  public static void main(String[] args) {
    BooleanNull a = new BooleanNull();
    a.serviceNullBoolean();
  }

}
