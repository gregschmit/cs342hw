// https://docs.oracle.com/javase/8/docs/api/java/io/File.html
import java.io.File;
// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
import java.util.ArrayList;
// https://docs.oracle.com/javase/8/docs/api/javax/imageio/ImageReader.html
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Class for representing Image files (mime type image).
 */
public abstract class MimedImageType extends MimedFile implements Graphical {

  MimedImageType(File file) {
    super(file);
  }

  public String getMimeTopLevelTypeName() {
    return "image";
  }

  public Integer getHeight() {
    int height;
    ImageInputStream stream;
    Iterator<ImageReader> readers;
    try {
      stream = ImageIO.createImageInputStream(this.file);
      readers = ImageIO.getImageReaders(stream);
    } catch (IOException | IllegalArgumentException e1) {
      System.err.println("fileinfo: exception while getting image height");
      return 0;
    }
    if (readers.hasNext()) {
      ImageReader reader = readers.next();
      try {
        reader.setInput(stream, true);
      } catch (IllegalArgumentException e) {
        System.err.println("fileinfo: exception while getting image height");
        return 0;
      }
      try {
        height = reader.getHeight(0);
      } catch (IllegalStateException | IndexOutOfBoundsException | IOException e) {
        System.err.println("fileinfo: exception while getting image height");
        return 0;
      }
      reader.dispose();
    } else {
      height = 0;
    }
    return height;
  }

  public Integer getWidth() {
    int width;
    ImageInputStream stream;
    Iterator<ImageReader> readers;
    try {
      stream = ImageIO.createImageInputStream(this.file);
      readers = ImageIO.getImageReaders(stream);
    } catch (IOException | IllegalArgumentException e1) {
      System.err.println("fileinfo: exception while getting image width");
      return 0;
    }
    if (readers.hasNext()) {
      ImageReader reader = readers.next();
      try {
        reader.setInput(stream, true);
      } catch (IllegalArgumentException e) {
        System.err.println("fileinfo: exception while getting image width");
        return 0;
      }
      try {
        width = reader.getWidth(0);
      } catch (IllegalStateException | IndexOutOfBoundsException | IOException e) {
        System.err.println("fileinfo: exception while getting image width");
        return 0;
      }
      reader.dispose();
    } else {
      width = 0;
    }
    return width;
  }
}
