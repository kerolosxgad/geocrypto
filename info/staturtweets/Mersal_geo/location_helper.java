package info.staturtweets.Mersal_geo;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class location_helper {
  private static final int TWO_MINUTES = 120000;
  
  public Location Last_loc;
  
  public Context cntxt;
  
  public Location current_Loc;
  
  public Decrypt_Scrn dec_scrn;
  
  public location_helper(Decrypt_Scrn paramDecrypt_Scrn) {
    this.dec_scrn = paramDecrypt_Scrn;
    get_loc();
  }
  
  private void get_loc() {
    LocationManager locationManager = (LocationManager)this.dec_scrn.getSystemService("location");
    LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location param1Location) {
          location_helper.this.makeUseOfNewLocation(param1Location);
        }
        
        public void onProviderDisabled(String param1String) {}
        
        public void onProviderEnabled(String param1String) {}
        
        public void onStatusChanged(String param1String, int param1Int, Bundle param1Bundle) {}
      };
    this.Last_loc = locationManager.getLastKnownLocation("network");
    if (this.current_Loc == null) {
      this.current_Loc = this.Last_loc;
      makeUseOfNewLocation(this.current_Loc);
    } 
    locationManager.requestLocationUpdates("gps", 0L, 0.0F, locationListener);
  }
  
  private boolean isSameProvider(String paramString1, String paramString2) {
    return (paramString1 == null) ? ((paramString2 == null)) : paramString1.equals(paramString2);
  }
  
  public Location get_location() {
    return this.current_Loc;
  }
  
  protected boolean isBetterLocation(Location paramLocation1, Location paramLocation2) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (paramLocation2 == null)
      return true; 
    long l = paramLocation1.getTime() - paramLocation2.getTime();
    if (l > 120000L) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (l < -120000L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (l > 0L) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool1)
      return true; 
    if (bool2)
      return false; 
    int i = (int)(paramLocation1.getAccuracy() - paramLocation2.getAccuracy());
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (i < 0) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (i > 200) {
      i = 1;
    } else {
      i = 0;
    } 
    null = isSameProvider(paramLocation1.getProvider(), paramLocation2.getProvider());
    return bool2 ? true : ((bool3 && !bool1) ? true : ((bool3 && i == 0 && null)));
  }
  
  public void makeUseOfNewLocation(Location paramLocation) {
    if (isBetterLocation(paramLocation, this.current_Loc)) {
      this.Last_loc = this.current_Loc;
      this.current_Loc = paramLocation;
      this.dec_scrn.update_loc(paramLocation);
    } 
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\location_helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */