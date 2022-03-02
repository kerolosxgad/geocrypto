package info.staturtweets.Mersal_geo;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DBAdapter {
  private static final String DATABASE_NAME = "mer sal_geo";
  
  private static final String DATABASE_TABLE = "encrypted";
  
  private static final int DATABASE_VERSION = 2;
  
  public static final String KEY_ROWID = "_id";
  
  private static final String TAG = "DBAdapter";
  
  private DatabaseHelper DBHelper;
  
  private final Context context;
  
  private SQLiteDatabase db;
  
  String dist;
  
  String lat;
  
  String lng;
  
  public DBAdapter(Context paramContext, String paramString1, String paramString2, String paramString3) {
    this.context = paramContext;
    this.lng = paramString1;
    this.lat = paramString2;
    this.dist = paramString3;
    this.DBHelper = new DatabaseHelper(this.context);
  }
  
  public void Get_const_from_Add(ArrayList<String> paramArrayList) {}
  
  public void add_message(enc_message paramenc_message) {
    String str = "insert into encrypted_data (encrypted_string, lng, lat,dist, isread) values ('" + paramenc_message.getMessage() + "','" + paramenc_message.getLng() + "','" + paramenc_message.getLat() + "','" + paramenc_message.getDist() + "','no')";
    try {
      this.db.execSQL(str);
    } catch (Exception exception) {
      Log.w("Exception", exception.getMessage());
    } 
  }
  
  public void close() {
    this.DBHelper.close();
  }
  
  public void delete_message(String paramString) {
    paramString = "delete from  encrypted_data where _id=" + paramString;
    try {
      this.db.execSQL(paramString);
    } catch (Exception exception) {
      Log.w("Exception", exception.getMessage());
    } 
  }
  
  public Cursor getAllEncrypted() {
    Cursor cursor = null;
    try {
      Cursor cursor1 = this.db.rawQuery("select  _id, encrypted_string, lng, lat,dist, datetime(d),isread from encrypted_data order by d", null);
      cursor = cursor1;
    } catch (Exception exception) {
      Log.w("Exception", exception.getMessage());
    } 
    return cursor;
  }
  
  public void get_const_list(int paramInt) {}
  
  public DBAdapter open() throws SQLException {
    this.db = this.DBHelper.getWritableDatabase();
    Log.w("Badr Con", "connected " + this.db.isOpen());
    return this;
  }
  
  public void set_read(enc_message paramenc_message) {
    String str = "update encrypted_data set isread='yes' where _id=" + paramenc_message.getId();
    try {
      this.db.execSQL(str);
    } catch (Exception exception) {
      Log.w("Exception", exception.getMessage());
    } 
  }
  
  private static class DatabaseHelper extends SQLiteOpenHelper {
    DatabaseHelper(Context param1Context) {
      super(param1Context, "mer sal_geo", null, 2);
    }
    
    public void onCreate(SQLiteDatabase param1SQLiteDatabase) {
      param1SQLiteDatabase.execSQL("CREATE TABLE encrypted_data (_id INTEGER PRIMARY KEY AUTOINCREMENT, encrypted_string Text, lng text, lat text, dist text, d date DEFAULT (datetime('now','localtime')), isread text)");
    }
    
    public void onUpgrade(SQLiteDatabase param1SQLiteDatabase, int param1Int1, int param1Int2) {}
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\DBAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */