package info.staturtweets.Mersal_geo;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import java.util.ArrayList;

public class map_overlay extends ItemizedOverlay {
  private Context mContext;
  
  private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
  
  Mersal_geo_map mersal_map;
  
  MapView mv;
  
  GeoPoint p = new GeoPoint(30056269, 31220981);
  
  private int range = 1;
  
  public map_overlay(Drawable paramDrawable) {
    super(paramDrawable);
  }
  
  public map_overlay(Drawable paramDrawable, Context paramContext) {
    super(paramDrawable);
    this.mContext = paramContext;
  }
  
  public void addOverlay(OverlayItem paramOverlayItem) {
    this.mOverlays.add(paramOverlayItem);
    populate();
  }
  
  protected OverlayItem createItem(int paramInt) {
    return this.mOverlays.get(paramInt);
  }
  
  public boolean draw(Canvas paramCanvas, MapView paramMapView, boolean paramBoolean, long paramLong) {
    draw(paramCanvas, paramMapView, paramBoolean);
    Point point = new Point();
    paramMapView.getProjection().toPixels(this.p, point);
    Bitmap bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), 2130837517);
    this.mv.getZoomLevel();
    this.range = 30;
    paramCanvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, this.range, this.range, true), (point.x - this.range / 2), (point.y - this.range / 2), null);
    return true;
  }
  
  public void newPlaceTouched(GeoPoint paramGeoPoint) {
    (float)(paramGeoPoint.getLongitudeE6() / 1000000.0D) + ":" + (float)(paramGeoPoint.getLatitudeE6() / 1000000.0D);
    this.mersal_map.set_loc((float)(paramGeoPoint.getLongitudeE6() / 1000000.0D), (float)(paramGeoPoint.getLatitudeE6() / 1000000.0D));
  }
  
  protected boolean onTap(int paramInt) {
    OverlayItem overlayItem = this.mOverlays.get(paramInt);
    AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
    builder.setTitle(overlayItem.getTitle());
    builder.setMessage(overlayItem.getSnippet());
    builder.show();
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView) {
    if (paramMotionEvent.getAction() == 1) {
      GeoPoint geoPoint = paramMapView.getProjection().fromPixels((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      double d2 = geoPoint.getLongitudeE6() / 1000000.0D;
      double d1 = geoPoint.getLatitudeE6() / 1000000.0D;
      this.mersal_map.set_loc(d2, d1);
      this.p = geoPoint;
      Log.i("location", String.valueOf(geoPoint.getLatitudeE6() / 1000000.0D) + "," + (geoPoint.getLongitudeE6() / 1000000.0D));
    } 
    return false;
  }
  
  public void set_mersal(Mersal_geo_map paramMersal_geo_map) {
    this.mersal_map = paramMersal_geo_map;
  }
  
  public void set_range(int paramInt) {
    this.range = paramInt / 100;
  }
  
  public void setmapview(MapView paramMapView) {
    this.mv = paramMapView;
  }
  
  public int size() {
    return this.mOverlays.size();
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\map_overlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */