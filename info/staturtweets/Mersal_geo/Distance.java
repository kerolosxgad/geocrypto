package info.staturtweets.Mersal_geo;

import android.location.Location;

public class Distance {
  public static double calc_dist(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Location location1 = new Location("loc1");
    Location location2 = new Location("loc2");
    location1.setLongitude(paramFloat2);
    location1.setLatitude(paramFloat1);
    location2.setLongitude(paramFloat4);
    location2.setLatitude(paramFloat3);
    return location1.distanceTo(location2);
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\Distance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */