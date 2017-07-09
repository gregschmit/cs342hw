import edu.uic.cs342.SentenceParser;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.Assert;

public class SentenceParserTest {

  static Charset TEST_CHARSET = StandardCharsets.UTF_8;

  static String fileToString(String pathName) throws IOException {
    Path filePath = FileSystems.getDefault().getPath("tests", "data", pathName);
    return Files.readAllLines(filePath, SentenceParserTest.TEST_CHARSET)
        .stream()
        .map(x -> x.trim())
        .collect(Collectors.joining("\n"));
  }

  static String fileToTestResult(String pathName) throws IOException {

    Path filePath = FileSystems.getDefault().getPath("tests", "data", pathName);
    String fileContents = Files.readAllLines(filePath, SentenceParserTest.TEST_CHARSET)
        .stream()
        .map(x -> x.trim())
        .collect(Collectors.joining("\n"));

    SentenceParser parser = new SentenceParser();
    List<String> testResult = parser.asList(fileContents);
    return SentenceParserTest.listToString(testResult);
  }

  static String listToString(List<String> inputList) {
    return inputList.stream().collect(Collectors.joining("\n"));
  }

  @Test
  public void toSentencesExample1Test() throws IOException {

    String correctResult = SentenceParserTest.fileToString("1-correct.txt");
    String testResult = SentenceParserTest.fileToTestResult("1-test.txt");

    Assert.assertEquals(correctResult, testResult);
  }
}
