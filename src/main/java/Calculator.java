import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculator {

  private static final String DEFAULT_SEPARATOR = ",|:";
  private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

  public Integer getSum(String input) {
    if (input.isEmpty()) {
      return 0;
    }

    Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

    if (matcher.find()) {
      String customSeparator = matcher.group(1);
      String[] items = matcher.group(2).split(customSeparator);

      return getSumOfItems(items);
    }

    String[] items = input.split(DEFAULT_SEPARATOR);
    return getSumOfItems(items);
  }

  private Integer getSumOfItems(String[] items) {
    Optional<Integer> results = Arrays.stream(items).map(Integer::parseInt).reduce(Integer::sum);

    return results.orElse(0);
  }
}
