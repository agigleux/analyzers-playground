package S2479;

public class HiddenControlCharacters {

  String s1 = "DirContext#search()Ljavax/naming/NamingEnumeration;";
  String s2 = "DirContext#search​​​​​​()"; // Noncompliant; not visible character at the end of the String

  public static void main(String[] args) {
    HiddenControlCharacters app = new HiddenControlCharacters();

    // let's select the first 19 characters of each s1 and s2 Strings corresponding to "DirContext#search​​​​​​()"
    // it should return the same value but ...
    System.out.println(app.s1.substring(0, 19).getBytes().length); // returns 19
    System.out.println(app.s2.substring(0, 19).getBytes().length); // returns 23

    if (app.s1.startsWith(app.s2)) {
      System.out.println("TRUE");
    } else {
      System.out.println("FALSE"); // FALSE will be printed
    }
  }
}
