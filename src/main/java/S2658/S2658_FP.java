package S2658;

public class S2658_FP {
  private static final String DATE_TIME_CLASS = "org.joda.time.DateTime";

  public static void main(String[] args) {
    try {
      Class cls1 = Class.forName("java.lang.ClassLoader");
      Class cls2 = Class.forName(DATE_TIME_CLASS);
    } catch (ClassNotFoundException ex) {
    }
  }
}
