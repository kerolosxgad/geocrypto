package info.staturtweets.Mersal_geo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import java.util.List;

public class Mersal_geo_map extends MapActivity {
  String Text_in = "";
  
  String Text_out = "";
  
  String dist;
  
  String lat;
  
  String lng;
  
  MapView mv;
  
  SeekBar sb;
  
  TextView tv;
  
  public void encrypt() {
    this.Text_out = (new encryptor()).encrypt_des(this.lat, this.lng, this.dist, this.Text_in);
    Intent intent = new Intent("info.staturtweets.mersal.encrypted_txt");
    Bundle bundle = new Bundle();
    bundle.putString("text_out", this.Text_out);
    intent.putExtras(bundle);
    startActivityForResult(intent, 1);
  }
  
  protected boolean isRouteDisplayed() {
    return false;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130903047);
    setRequestedOrientation(1);
    this.lng = "31.22141";
    this.lat = "30.055299";
    this.dist = "800";
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
      this.Text_in = paramBundle.getString("text_in"); 
    ((Button)findViewById(2131099669)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            Mersal_geo_map.this.encrypt();
          }
        });
    this.mv = (MapView)findViewById(2131099666);
    this.sb = (SeekBar)findViewById(2131099668);
    this.mv.setClickable(true);
    this.mv.setBuiltInZoomControls(true);
    this.tv = (TextView)findViewById(2131099661);
    this.tv.setText("100m");
    this.sb.setMax(49);
    this.sb.setProgress(7);
    this.tv.setText("800m");
    List<map_overlay> list = this.mv.getOverlays();
    final map_overlay itemizedoverlay = new map_overlay(getResources().getDrawable(2130837505), (Context)this);
    map_overlay.set_mersal(this);
    map_overlay.setmapview(this.mv);
    this.sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
            Mersal_geo_map.this.dist = (param1Int + 1) * 100;
            Mersal_geo_map.this.tv.setText(((param1Int + 1) * 100) + "M");
            itemizedoverlay.set_range((param1Int + 1) * 100);
          }
          
          public void onStartTrackingTouch(SeekBar param1SeekBar) {}
          
          public void onStopTrackingTouch(SeekBar param1SeekBar) {}
        });
    OverlayItem overlayItem = new OverlayItem(new GeoPoint(19240000, -99120000), "Hola, Mundo!", "I'm in Mexico City!");
    GeoPoint geoPoint = new GeoPoint(30056269, 31220981);
    new OverlayItem(geoPoint, "Sekai, konichiwa!", "I'm in Japan!");
    map_overlay.addOverlay(overlayItem);
    list.add(map_overlay);
    this.mv.getController().setZoom(15);
    this.mv.getController().setCenter(new GeoPoint(39735007, -8827330));
    this.mv.getController().animateTo(geoPoint);
  }
  
  public void set_loc(String paramString1, String paramString2) {
    this.lng = paramString1;
    this.lat = paramString2;
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\Mersal_geo_map.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */