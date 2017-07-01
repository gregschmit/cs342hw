
import java.io.File;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import uic.redlightcams.Filter;
import uic.redlightcams.FilterException;
import uic.redlightcams.config.FilterParams;
import uic.redlightcams.enums.Column;
import uic.redlightcams.enums.OutputOptions;
import uic.redlightcams.enums.SortDirection;


/**
 * Main entry class for HW4.  This code should not be changed in completing
 * this assignment.  No sorting, filtering or parsing logic is
 * implemented in this class, arguments and configuration are just collected
 * and passed on to other classes.
 */
public class Main {

  /**
   * Entry point for the camfilter application.
   *
   * @param args String[] The commandline provided argments.
   */
  public static void main(String[] args) {

    ArgumentParser parser = ArgumentParsers
        .newArgumentParser("camfilter")
        .defaultHelp(true);
    
    parser.addArgument("--fcol")
        .type(Column.class)
        .help("A column to filter the data set on.  If you select a "
              + "filter column, you must specify a filter value with "
              + "'--fval'");

    parser.addArgument("--fval")
        .help("The value to fitler the given filter column with.  If '--fcol' "
              + "is not specified, this value is ignored.");

    parser.addArgument("--scol")
        .type(Column.class)
        .help("A column to sort the data set by.");
      
    parser.addArgument("--sdir")
        .type(SortDirection.class)
        .help("The direction to sort the given sort column in.  If '--scol' "
              + "is not provided, this argument is ignored.");

    parser.addArgument("--dist")
        .type(Integer.class)
        .help("If provided, reduces the set of data points to only those that "
              + "are '--dist' number of miles from UIC "
              + "(41.8756° N, 87.6244° W)");
    
    parser.addArgument("--merge")
        .action(Arguments.storeTrue())
        .help("If provided, then dates should be merged by date (ie each "
              + "camera would be listed a maximum of one time, and the 'num "
              + "volations' column would be the sum of all the voliations "
              + "that were recorded on each camera, across all relevant "
              + "dates.");
    
    parser.addArgument("--ouput")
        .type(OutputOptions.class)
        .required(true);

    Namespace res;
    try {
      res = parser.parseArgs(args);
    } catch (ArgumentParserException e) {
      parser.handleError(e);
      System.exit(1);
      return;
    }

    FilterParams filterConfig = new FilterParams();

    if (res.get("fcol") != null) {
      if (res.get("fval") == null) {
        System.err.println("Error: Received a filter column option, but "
                           + "missing a filter value option");
        System.exit(1);
        return;
      }
      
      filterConfig.setFilterColumn((Column) res.get("fcol"));
      filterConfig.setFilterValue(res.get("fval"));
    }

    if (res.get("scol") != null) {
      if (res.get("sdir") == null) {
        System.err.println("Error: Received a sort column option, but "
                           + "missing a sort direction option");
        System.exit(1);
        return;
      }

      filterConfig.setSortColumn((Column) res.get("scol"));
      filterConfig.setSortDirection((SortDirection) res.get("sdir"));
    }

    if (res.get("dist") != null) {

      Integer miles = res.getInt("dist");
      if (miles <= 0) {
        System.err.println("Error: If provided, the sort option must be a "
                           + "positive integer.");
        System.exit(1);
        return;
      }

      filterConfig.setMilesFromUic(miles);
    }

    if (res.getBoolean("merge")) {
      filterConfig.setShouldMerge(true);
    }

    File inputData = new File("data/red-light-camera-violations.json");

    try {
      Filter recordFilterer = new Filter(inputData);
      String report = recordFilterer.generateReport(filterConfig, res.get("output"));
      System.out.print(report);
      System.exit(0);
    } catch (FilterException error) {
      System.err.print(error.toString());
      System.exit(1);
    }
  }
}