// https://docs.oracle.com/javase/8/docs/api/java/io/File.html
import java.io.File;
// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
import java.util.ArrayList;

/**
 * Class for representing Text files (mime type text/html).
 */
public class MimedHtmlFile extends MimedFile  {

  MimedHtmlFile(File file) {
    super(file);
  }
}
