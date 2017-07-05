package uic.redlightcams;

import org.json.JSONArray;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a single day's datapoint for information about
 * how many violations were recorded at a given location, on a give date.
 */
public class DataPoint {

  protected class Coordinates {
    public double latitude;
    public double longitude;

    Coordinates(double in_lat, double in_long) {
      latitude = in_lat;
      longitude = in_long;
    }
  }

  // 1.  Intersection of recording
  // 2.  ID of the camera doing the recording
  // 3.  The address of the camera
  // 4.  The date of the recording
  // 5.  Number of redlight violations that the camera recorded, on this date
  // 6.  The latitude where the camera is located
  // 7.  The longitude where the camera is located
  public String intersection;
  public Integer id;
  public String address;
  public LocalDateTime date;
  public Integer violation_count;
  public Coordinates coordinates;

  DataPoint(JSONArray entry) {
    intersection = new String(entry.getString(0));
    if (!entry.isNull(1)) {
      id = new Integer(entry.getInt(1));
    } else {
      id = -1;
    }
    address = entry.getString(2);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    date = LocalDateTime.parse(entry.getString(3), formatter);
    violation_count = new Integer(entry.getInt(4));
    coordinates = new Coordinates(Double.parseDouble(entry.getString(5)), Double.parseDouble(entry.getString(6)));
  }
}
