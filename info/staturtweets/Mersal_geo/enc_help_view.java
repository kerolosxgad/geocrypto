package info.staturtweets.Mersal_geo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class enc_help_view extends Activity {
  String help_type;
  
  TextView tv;
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130903044);
    setRequestedOrientation(1);
    this.tv = (TextView)findViewById(2131099660);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
      this.help_type = paramBundle.getString("help_type"); 
    if (this.help_type.equals("enc")) {
      this.tv.setText("To Encrypt:\n\nType the text you want to encrypt, click proceed to pick a spot on map and a range from that spot, procceed to encrypt your text. \nTo copy the encrypted text touch it for few seconds.\n\nThe encrypted text can only be read when within the specified range from the picked location.");
      return;
    } 
    if (this.help_type.equals("dec"))
      this.tv.setText("To Decrypt:\n\nClick on Menu then Add Message to add a new text to decrypt (text must be copied exactly). \n\nOnce you are in the decryption location click on 'Refresh Location' to check if any of the mssages can be unlocked in that location.\nClicking on the message would open it."); 
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\enc_help_view.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */