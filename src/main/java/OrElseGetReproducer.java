import java.util.Optional;
import java.util.function.Supplier;

public class OrElseGetReproducer {

  public static final String apiCallWithValue() {
    return "MyValue";
  }

  public static final String apiCallReturningNull() {
    return null;
  }

  private static Optional<String> initOptional() {
    return Optional.empty();
  }

  public static void main(String[] args) {
    Optional<String> oldValue = initOptional();
    System.out.println(oldValue.orElse("MyValue")); // Compliant
    System.out.println(oldValue.orElse(null)); // Compliant

    System.out.println(oldValue.orElseGet(OrElseGetReproducer::apiCallWithValue));
    System.out.println(oldValue.orElseGet(OrElseGetReproducer::apiCallReturningNull));

    Supplier<String> supplier = null;
    Optional<String> value = Optional.empty();
    System.out.println(value.orElseGet(supplier)); // Noncompliant; NPE will be raised at runtime
    System.out.println(value.orElseGet(null)); // Noncompliant; NPE will be raised at runtime
  }

}
