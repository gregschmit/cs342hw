package edu.uic.cs342;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.json.JSONArray;

public class SentenceParser {

  public JSONArray asJsonArray(String inputTest) {
    return null;
  }

  public List<String> asList(String inputTest) {
    return Arrays.asList(inputTest.trim().split("\\.")).stream()
        .map(x -> x.trim() + ".")
        .collect(Collectors.toList());
  }
}
