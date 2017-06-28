// https://docs.oracle.com/javase/8/docs/api/java/io/File.html
import java.io.File;
// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
import java.util.ArrayList;

/**
 * Class for representing Javascript files (mime type application/x-javascript).
 */
public class MimedJavascriptFile extends MimedApplicationType {

  MimedJavascriptFile(File file) {
    super(file);
  }

  public String getMimeSubTypeName() {
    return "x-javascript";
  }
}
