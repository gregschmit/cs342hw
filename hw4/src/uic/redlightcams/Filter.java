package uic.redlightcams;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import uic.redlightcams.config.FilterParams;
import uic.redlightcams.data.DataPoint;

/**
 * Class that handles the hard work of reading DataPoint records out of
 * a JSON file, and then filtering them accoring to some given configuraiton
 * parameters.
 */
public class Filter {

  protected ArrayList<DataPoint> data;

  public Filter(File inputFile) {
    // Your code should do something here to parse the inputFile into a series
    // uic.redlightcams.data.DataPoint objects.
  }

  /**
   * Generates textual description of the data set.
   *
   * <p>The returned textual description should reflect the inital data set,
   * with the filtering, sorting and aggregating parameters described by
   * the provided filtering paramters applied.
   *
   * <p>In the general case, this will be a comma seperated value (CSV)
   * formatted report, of columns:
   *   - Intersection
   *   - Camera ID
   *   - Address
   *   - Date
   *   - Num Violations
   *   - Latitude
   *   - Longitude
   *
   * <p>If, though, were aggregating / merging all dates for each camera, then
   * the generated CSV should have the columns:
   *   - Intersection
   *   - Camera ID
   *   - Address
   *   - Sum of Num Violations, across all dates
   *   - Latitude
   *   - Longitude
   *
   * @param params FilterParams Settings describing how to modify or restrict
   *                            the data set.
   *
   * @return String A textual description of the sorted, filtered and aggregated
   *                data set.
   */
  public String generateReport(FilterParams params) {
    return null;
  }
}