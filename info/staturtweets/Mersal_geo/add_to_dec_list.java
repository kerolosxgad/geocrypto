package info.staturtweets.Mersal_geo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_to_dec_list extends Activity {
  EditText et;
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    setRequestedOrientation(1);
    this.et = (EditText)findViewById(2131099649);
    ((Button)findViewById(2131099651)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            add_to_dec_list.this.et.setText("");
          }
        });
    ((Button)findViewById(2131099652)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            if (!add_to_dec_list.this.et.getEditableText().toString().equals("")) {
              enc_message enc_message = (new encryptor()).decrypt_des(add_to_dec_list.this.et.getEditableText().toString());
              DBAdapter dBAdapter = new DBAdapter((Context)add_to_dec_list.this, "", "", "");
              dBAdapter.open();
              if (enc_message != null)
                dBAdapter.add_message(enc_message); 
              dBAdapter.close();
              AlertDialog.Builder builder = new AlertDialog.Builder((Context)add_to_dec_list.this);
              builder.setCancelable(true);
              builder.setIcon(17301555);
              builder.setTitle("Add another?");
              builder.setInverseBackgroundForced(true);
              builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      (add_to_dec_list.null.access$0(add_to_dec_list.null.this)).et.setText("");
                      param2DialogInterface.dismiss();
                    }
                  });
              builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      add_to_dec_list.null.access$0(add_to_dec_list.null.this).finish();
                      param2DialogInterface.dismiss();
                    }
                  });
              builder.create().show();
            } 
          }
        });
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\add_to_dec_list.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */