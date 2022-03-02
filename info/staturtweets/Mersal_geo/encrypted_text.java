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

public class encrypted_text extends Activity {
  String Text_in;
  
  String distance;
  
  String lat;
  
  String lng;
  
  public void CreateMenu(Menu paramMenu) {
    MenuItem menuItem = paramMenu.add(0, 0, 0, "Help");
    menuItem.setAlphabeticShortcut('b');
    menuItem.setIcon(17301568);
  }
  
  public boolean MenuChoice(MenuItem paramMenuItem) {
    null = true;
    switch (paramMenuItem.getItemId()) {
      default:
        return false;
      case 0:
        break;
    } 
    Intent intent = new Intent("info.staturtweets.mersal.enc_help_view");
    Bundle bundle = new Bundle();
    bundle.putString("help_type", "enc");
    intent.putExtras(bundle);
    startActivityForResult(intent, 1);
    return SYNTHETIC_LOCAL_VARIABLE_2;
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    setRequestedOrientation(1);
    TextView textView = (TextView)findViewById(2131099659);
    textView.setClickable(true);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null) {
      this.Text_in = paramBundle.getString("text_out");
      textView.setText(this.Text_in);
    } 
    textView.setOnLongClickListener(new View.OnLongClickListener() {
          public boolean onLongClick(View param1View) {
            ((ClipboardManager)encrypted_text.this.getSystemService("clipboard")).setText(encrypted_text.this.Text_in);
            Toast.makeText((Context)encrypted_text.this, "Text Copied to Clipboard", 0).show();
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


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\encrypted_text.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */