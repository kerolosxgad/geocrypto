package info.staturtweets.Mersal_geo;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class SimpleCryptoDes {
  private static final String HEX = "0123456789ABCDEF";
  
  private static void appendHex(StringBuffer paramStringBuffer, byte paramByte) {
    paramStringBuffer.append("0123456789ABCDEF".charAt(paramByte >> 4 & 0xF)).append("0123456789ABCDEF".charAt(paramByte & 0xF));
  }
  
  public static String decrypt(String paramString1, String paramString2) throws Exception {
    return new String(decrypt(getRawKey(paramString1.getBytes()), toByte(paramString2)));
  }
  
  private static byte[] decrypt(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "DES");
    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(2, secretKeySpec);
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static String encrypt(String paramString1, String paramString2) throws Exception {
    return toHex(encrypt(getRawKey(paramString1.getBytes()), paramString2.getBytes()));
  }
  
  private static byte[] encrypt(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws Exception {
    SecretKeySpec secretKeySpec = new SecretKeySpec(paramArrayOfbyte1, "DES");
    Cipher cipher = Cipher.getInstance("DES");
    cipher.init(1, secretKeySpec);
    return cipher.doFinal(paramArrayOfbyte2);
  }
  
  public static String fromHex(String paramString) {
    return new String(toByte(paramString));
  }
  
  private static byte[] getRawKey(byte[] paramArrayOfbyte) throws Exception {
    KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
    SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
    secureRandom.setSeed(paramArrayOfbyte);
    keyGenerator.init(128, secureRandom);
    return keyGenerator.generateKey().getEncoded();
  }
  
  public static byte[] toByte(String paramString) {
    int i = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i];
    for (byte b = 0;; b++) {
      if (b >= i)
        return arrayOfByte; 
      arrayOfByte[b] = Integer.valueOf(paramString.substring(b * 2, b * 2 + 2), 8).byteValue();
    } 
  }
  
  public static String toHex(String paramString) {
    return toHex(paramString.getBytes());
  }
  
  public static String toHex(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer(paramArrayOfbyte.length * 2);
    for (byte b = 0;; b++) {
      if (b >= paramArrayOfbyte.length)
        return stringBuffer.toString(); 
      appendHex(stringBuffer, paramArrayOfbyte[b]);
    } 
  }
}


/* Location:              D:\geoo\dex-tools-2.1\classes-dex2jar.jar!\info\staturtweets\Mersal_geo\SimpleCryptoDes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */