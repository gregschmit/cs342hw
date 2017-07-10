package edu.uic.cs342;

import edu.uic.cs342.SentenceParserException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceParser {

  /**
   * Parses a given text and splits it into sentences.
   *
   * @param inputTest String A text to split into sentences.
   *
   * @return A list of Strings, each being a full English sentence.
   *
   * @throws SentenceParserException Generic exception class to indicate
   *                                 something went wrong during parsing
   *                                 the text into sentences.
   */
  public List<String> asList(String inputTest) throws SentenceParserException {

    String[] sentencesWithOutPeriods = inputTest.trim().split("\\.");

    return Arrays.asList(sentencesWithOutPeriods).stream()
        .map(x -> x.trim() + ".")
        .collect(Collectors.toList());
  }
}
