
// S2163_AlwaysTrueOrFalse 
public class S2163_AlwaysTrueOrFalse_Fruit extends Food {
  private Season ripe;

  public boolean equals(Object obj) {
    return ripe.equals(this); // Noncompliant
  }
}

class Food {

}

class Season {

}
