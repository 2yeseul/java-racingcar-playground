import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Calculator {

  public int getSum(String input) {
    if (input.isEmpty()) {
      return 0;
    }
    String[] numbers = input.split(",|:");
    Optional<Integer> results = Arrays.stream(numbers).map(Integer::parseInt).reduce(Integer::sum);

    return results.orElse(0);
  }
}
