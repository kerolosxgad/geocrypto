package info.staturtweets.Mersal_geo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class Decrypt_Scrn extends Activity {
  DBAdapter dba;
  
  double lat = 0.0D;
  
  double lng = 0.0D;
  
  location_helper loc_h;
  
  ListView lv1;
  
  String[] presidents;
  
  EditText text_out;
  
  public void CreateMenu(Menu paramMenu) {
    MenuItem menuItem2 = paramMenu.add(0, 0, 0, "Help");
    menuItem2.setAlphabeticShortcut('b');
    menuItem2.setIcon(17301568);
    MenuItem menuItem1 = paramMenu.add(0, 1, 1, "Add Message");
    menuItem1.setAlphabeticShortcut('c');
    menuItem1.setIcon(17301555);
  }
  
  public boolean MenuChoice(MenuItem paramMenuItem) {
    Bundle bundle;
    Intent intent2;
    null = true;
    switch (paramMenuItem.getItemId()) {
      default:
        return false;
      case 0:
        intent2 = new Intent("info.staturtweets.mersal.enc_help_view");
        bundle = new Bundle();
        bundle.putString("help_type", "dec");
        intent2.putExtras(bundle);
        startActivityForResult(intent2, 1);
        return SYNTHETIC_LOCAL_VARIABLE_2;
      case 1:
        break;
    } 
    Intent intent1 = new Intent("info.staturtweets.mersal.add_to_dec_list");
    intent1.putExtras(new Bundle());
    startActivityForResult(intent1, 1);
    return SYNTHETIC_LOCAL_VARIABLE_2;
  }
  
  public String[] arrayList_to_Array(ArrayList<String> paramArrayList) {
    String[] arrayOfString = new String[paramArrayList.size()];
    for (byte b = 0;; b++) {
      if (b >= paramArrayList.size())
        return arrayOfString; 
      arrayOfString[b] = paramArrayList.get(b);
    } 
  }
  
  public double get_distance(float paramFloat1, float paramFloat2) {
    new Distance();
    return Distance.calc_dist((float)this.lat, (float)this.lng, paramFloat1, paramFloat2);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    setRequestedOrientation(1);
    this.lv1 = (ListView)findViewById(2131099657);
    this.dba = new DBAdapter((Context)this, "0", "0", "0");
    this.loc_h = new location_helper(this);
    populate();
    this.lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            enc_message enc_message = (enc_message)Decrypt_Scrn.this.lv1.getItemAtPosition(param1Int);
            Decrypt_Scrn.this.open_dec_view_scrn(enc_message);
          }
        });
    ((Button)findViewById(2131099658)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            Decrypt_Scrn.this.populate();
          }
        });
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu) {
    super.onCreateOptionsMenu(paramMenu);
    CreateMenu(paramMenu);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    return MenuChoice(paramMenuItem);
  }
  
  protected void onResume() {
    super.onResume();
    populate();
  }
  
  public void open_dec_view_scrn(enc_message paramenc_message) {
    this.dba.open();
    this.dba.set_read(paramenc_message);
    Intent intent = new Intent("info.staturtweets.mersal.view_dec_message");
    Bundle bundle = new Bundle();
    bundle.putString("msg", paramenc_message.getMessage());
    bundle.putString("lat", paramenc_message.getLat());
    bundle.putString("lng", paramenc_message.getLng());
    bundle.putString("date", paramenc_message.getDate());
    bundle.putString("id", paramenc_message.getId());
    intent.putExtras(bundle);
    startActivityForResult(intent, 1);
  }
  
  public void populate() {
    this.dba.open();
    Cursor cursor = this.dba.getAllEncrypted();
    ArrayList<enc_message> arrayList = new ArrayList();
    byte b = 0;
    while (true) {
      if (!cursor.moveToNext()) {
        this.lv1.setAdapter((ListAdapter)new MyCustomBaseAdapter((Context)this, arrayList));
        this.dba.close();
        return;
      } 
      cursor.getInt(4);
      if (get_distance(cursor.getFloat(3), cursor.getFloat(2)) <= cursor.getInt(4)) {
        arrayList.add(new enc_message(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(0)));
        b++;
        continue;
      } 
      System.out.println("t" + cursor.getInt(2) + "," + cursor.getInt(3));
    } 
  }
  
  public void update_loc(Location paramLocation) {
    if (paramLocation != null) {
      this.lng = paramLocation.getLongitude();
      this.lat = paramLocation.getLatitude();
    } 
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\Decrypt_Scrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */