package info.staturtweets.Mersal_geo;

public class enc_message {
  private String Message;
  
  private boolean Read;
  
  private String date;
  
  private String dist;
  
  String id;
  
  private String lat;
  
  private String lng;
  
  public enc_message(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    this.lng = paramString2;
    this.lat = paramString3;
    this.date = paramString5;
    this.Message = paramString1;
    this.dist = paramString4;
    if (paramString6.equals("yes")) {
      this.Read = true;
    } else {
      this.Read = false;
    } 
    this.id = paramString7;
  }
  
  void SetRead(String paramString) {
    if (paramString.equals("yes")) {
      this.Read = true;
      return;
    } 
    this.Read = false;
  }
  
  public String getDate() {
    return this.date;
  }
  
  String getDist() {
    return this.dist;
  }
  
  public String getId() {
    return this.id;
  }
  
  String getLat() {
    return this.lat;
  }
  
  String getLng() {
    return this.lng;
  }
  
  String getMessage() {
    return this.Message;
  }
  
  boolean getRead() {
    return this.Read;
  }
  
  public void setDate(String paramString) {
    this.date = paramString;
  }
  
  void setDist(String paramString) {
    this.dist = paramString;
  }
  
  public void setId(String paramString) {
    this.id = paramString;
  }
  
  void setLat(String paramString) {
    this.lat = paramString;
  }
  
  void setLng(String paramString) {
    this.lng = paramString;
  }
  
  void setMessage(String paramString) {
    this.Message = paramString;
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\enc_message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */