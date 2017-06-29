package uic.redlightcams;

import java.io.File;
import java.util.List;
import org.json.JSONArray;
import uic.redlightcams.DataPoint;
import uic.redlightcams.FilterException;
import uic.redlightcams.config.FilterParams;
import uic.redlightcams.enums.OutputOptions;

/**
 * Class that handles the hard work of reading DataPoint records out of
 * a JSON file, and then filtering them accoring to some given configuraiton
 * parameters.
 */
public class Filter {

  protected List<DataPoint> data;

  /**
   * Constructor for object for filtering DataPoint results.
   *
   * @param inputFile File   A file object pointing at JSON data to process.
   *
   * @throws FilterException If there was an error processing, or otherwise
   *                         processing the data set.
   */
  public Filter(File inputFile) throws FilterException {
    // Your code should do something here to parse the inputFile into a series
    // uic.redlightcams.DataPoint objects.
  }

  /**
   * Generates textual description of the data set.
   *
   * <p>The returned textual description should reflect the inital data set,
   * with the filtering, sorting and aggregating parameters described by
   * the provided filtering paramters applied.
   *
   * <p>In the general case, this will be a rows of columns:
   *   - Intersection
   *   - Camera ID
   *   - Address
   *   - Date
   *   - Num Violations
   *   - Latitude
   *   - Longitude
   *
   * <p>If, though, were aggregating / merging all dates for each camera, then
   * the generated rows should have the columns:
   *   - Intersection
   *   - Camera ID
   *   - Address
   *   - Sum of Num Violations, across all dates
   *   - Latitude
   *   - Longitude
   *
   * @param params FilterParams Settings describing how to modify or restrict
   *                            the data set.
   * @param outputType OutputOptions The type of output to generate (JSON or
   *                                 or CSV).
   *
   * @return String A textual description of the sorted, filtered and aggregated
   *                data set.
   *
   * @throws FilterException If there was an error processing, or otherwise
   *                         processing the data set.
   */
  public String generateReport(FilterParams params, OutputOptions outputType)
      throws FilterException {
    return null;
  }
}