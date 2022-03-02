package info.staturtweets.Mersal_geo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Encrypt_Scrn extends Activity {
  EditText text_in;
  
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
    setContentView(2130903045);
    this.text_in = (EditText)findViewById(2131099649);
    setRequestedOrientation(1);
    ((Button)findViewById(2131099663)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            Encrypt_Scrn.this.text_in.setText("");
          }
        });
    ((Button)findViewById(2131099664)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            Intent intent = new Intent("info.staturtweets.mersal.encrypt_geo");
            Bundle bundle = new Bundle();
            bundle.putString("text_in", Encrypt_Scrn.this.text_in.getEditableText().toString());
            intent.putExtras(bundle);
            Encrypt_Scrn.this.startActivityForResult(intent, 1);
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


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\Encrypt_Scrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */