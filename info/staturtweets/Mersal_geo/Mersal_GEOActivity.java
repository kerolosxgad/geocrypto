package info.staturtweets.Mersal_geo;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TabHost;
import android.widget.TextView;
import com.google.android.maps.MapView;

public class Mersal_GEOActivity extends TabActivity {
  MapView mv;
  
  SeekBar sb;
  
  TextView tv;
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130903048);
    setRequestedOrientation(1);
    Resources resources = getResources();
    TabHost tabHost = getTabHost();
    Intent intent = (new Intent()).setClass((Context)this, Encrypt_Scrn.class);
    tabHost.addTab(tabHost.newTabSpec("Encrypt").setIndicator("Encrypt", resources.getDrawable(2130837514)).setContent(intent));
    intent = (new Intent()).setClass((Context)this, Decrypt_Scrn.class);
    tabHost.addTab(tabHost.newTabSpec("Map_Loc").setIndicator("Decrypt", resources.getDrawable(2130837507)).setContent(intent));
    tabHost.setCurrentTab(0);
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\Mersal_GEOActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */