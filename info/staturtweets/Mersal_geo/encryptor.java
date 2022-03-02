package info.staturtweets.Mersal_geo;

import java.util.StringTokenizer;

public class encryptor {
  private final String mykey = "W&IweW8D5?(qH";
  
  SimpleCrypto sc = new SimpleCrypto();
  
  SimpleCryptoDes scd = new SimpleCryptoDes();
  
  public enc_message create_message_object(String paramString) {
    try {
      String str1 = paramString.substring(0, paramString.indexOf("@"));
      String str2 = paramString.substring(paramString.indexOf("@") + 1);
      StringTokenizer stringTokenizer = new StringTokenizer();
      this(str1, ",");
      String str3 = stringTokenizer.nextToken();
      str1 = stringTokenizer.nextToken();
      String str4 = stringTokenizer.nextToken();
      enc_message enc_message = new enc_message();
      this(str2, str1, str3, str4, "", "No", "");
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (enc_message)exception;
  }
  
  public enc_message decrypt_des(String paramString) {
    try {
      enc_message enc_message = create_message_object(SimpleCrypto.decrypt("W&IweW8D5?(qH", paramString));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (enc_message)exception;
  }
  
  public String encrypt_des(String paramString1, String paramString2, String paramString3, String paramString4) {
    String str;
    paramString1 = String.valueOf(paramString1) + "," + paramString2 + "," + paramString3 + "@" + paramString4;
    try {
      paramString1 = SimpleCrypto.encrypt("W&IweW8D5?(qH", paramString1);
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\encryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */