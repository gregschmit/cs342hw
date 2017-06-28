// https://docs.oracle.com/javase/8/docs/api/java/io/File.html
import java.io.File;
// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
import java.util.ArrayList;

/**
 * Class for representing Application files (mime type application).
 */
public abstract class MimedApplicationType extends MimedFile {

  MimedApplicationType(File file) {
    super(file);
  }

  public String getMimeTopLevelTypeName() {
    return "application";
  }
}
