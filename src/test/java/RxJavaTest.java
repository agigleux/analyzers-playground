import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class RxJavaTest {
  /*
  private static final List<String> WORDS = Arrays.asList(
    "the",
    "quick",
    "brown",
    "fox",
    "jumped",
    "over",
    "the",
    "lazy",
    "dog");

  @Test
  public void testInSameThread() {
    // given:
    List<String> results = new ArrayList<>();
    Observable<String> observable = Observable.fromIterable(WORDS)
      .zipWith(Observable.range(1, Integer.MAX_VALUE),
        (string, index) -> String.format("%2d. %s", index, string));

    // when:
    observable.subscribe(results::add);

    // then:
    assertThat(results, notNullValue());
    assertThat(results, hasSize(9));
    assertThat(results, hasItem(" 4. fox"));
  }

  @Test
  public void testUsingTestObserver() {
    // given:
    TestObserver<String> observer = new TestObserver<>();
    Observable<String> observable = Observable.fromIterable(WORDS)
      .zipWith(Observable.range(1, Integer.MAX_VALUE),
        (string, index) -> String.format("%2d. %s", index, string));

    // when:
    observable.subscribe(observer);

    // then:
    observer.assertComplete();
    observer.assertNoErrors();
    observer.assertValueCount(9);
    //assertThat(observer.values(), hasItem(" 4. fox"));
  }
  */
}
