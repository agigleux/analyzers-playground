package spotbugs;

public class IL_INFINITE_LOOP {
  public static void main(String[] args) {
    while (true) {
      System.out.println("IL_INFINITE_LOOP");
    }
  }
}
