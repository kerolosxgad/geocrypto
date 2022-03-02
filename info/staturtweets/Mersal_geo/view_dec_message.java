package info.staturtweets.Mersal_geo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class view_dec_message extends Activity {
  String date = "";
  
  TextView date_tv;
  
  TextView et;
  
  String id = "";
  
  String lat = "";
  
  String lng = "";
  
  String msg = "";
  
  public void CreateMenu(Menu paramMenu) {
    MenuItem menuItem2 = paramMenu.add(0, 0, 0, "Help");
    menuItem2.setAlphabeticShortcut('b');
    menuItem2.setIcon(17301568);
    MenuItem menuItem1 = paramMenu.add(0, 1, 1, "Delete Message");
    menuItem1.setAlphabeticShortcut('c');
    menuItem1.setIcon(17301564);
  }
  
  public boolean MenuChoice(MenuItem paramMenuItem) {
    Bundle bundle;
    Intent intent;
    null = true;
    switch (paramMenuItem.getItemId()) {
      default:
        return false;
      case 0:
        intent = new Intent("info.staturtweets.mersal.enc_help_view");
        bundle = new Bundle();
        bundle.putString("help_type", "dec");
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
        return SYNTHETIC_LOCAL_VARIABLE_2;
      case 1:
        break;
    } 
    DBAdapter dBAdapter = new DBAdapter((Context)this, "", "", "");
    dBAdapter.open();
    dBAdapter.delete_message(this.id);
    dBAdapter.close();
    this.et.setText("");
    this.date_tv.setText("");
    Toast.makeText((Context)this, "Message Deleted!", 1).show();
    finish();
    return SYNTHETIC_LOCAL_VARIABLE_2;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130903049);
    this.et = (TextView)findViewById(2131099670);
    setRequestedOrientation(1);
    this.date_tv = (TextView)findViewById(2131099661);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null) {
      this.msg = paramBundle.getString("msg");
      this.lat = paramBundle.getString("lat");
      this.lng = paramBundle.getString("lng");
      this.date = paramBundle.getString("date");
      this.id = paramBundle.getString("id");
      this.et.setText(this.msg);
      this.date_tv.setText(this.date);
    } 
    this.et.setOnLongClickListener(new View.OnLongClickListener() {
          public boolean onLongClick(View param1View) {
            ((ClipboardManager)view_dec_message.this.getSystemService("clipboard")).setText(view_dec_message.this.msg);
            Toast.makeText((Context)view_dec_message.this, "Text Copied to Clipboard", 0).show();
            return false;
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
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\view_dec_message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */