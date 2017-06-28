// https://docs.oracle.com/javase/8/docs/api/java/io/File.html
import java.io.File;
// https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html
import java.io.IOException;
// https://pdfbox.apache.org/docs/2.0.5/javadocs/org/apache/pdfbox/pdmodel/PDDocument.html
import org.apache.pdfbox.pdmodel.PDDocument;
// https://pdfbox.apache.org/docs/2.0.5/javadocs/org/apache/pdfbox/pdmodel/PDPage.html
import org.apache.pdfbox.pdmodel.PDPage;
// https://pdfbox.apache.org/docs/2.0.5/javadocs/org/apache/pdfbox/pdmodel/common/PDRectangle.html
import org.apache.pdfbox.pdmodel.common.PDRectangle;
// https://pdfbox.apache.org/docs/2.0.5/javadocs/org/apache/pdfbox/pdmodel/encryption/InvalidPasswordException.html
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
// (not needed by the compiler, but provided as a nudge to the programmer :)
import java.lang.Math;

/**
 * Class for representing PDF files (mime type application/pdf).
 */
public class MimedPdfFile extends MimedApplicationType implements Graphical {

  MimedPdfFile(File file) {
    super(file);
  }

  public String getMimeSubTypeName() {
    return "pdf";
  }

  public Integer getHeight() {
    //ImageReader image = new ImageReader(this.file);
    return 0;
  }

  public Integer getWidth() {
    return 0;
  }
}
