package org.sonarlint.hotspots;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.Cookie;

public class VeryNotSecuredCode {

  public Cookie createCookie() {
    Cookie cookie = new Cookie("myCookieName", "12");
    return cookie;
  }

  public void cryptMe(String rawText) throws NoSuchAlgorithmException, NoSuchPaddingException {
    Cipher c = Cipher.getInstance("DESede/ECB/PKCS5Padding");
  }

  public void useMD5orSha1() throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("SHA1");
  }

  public void S4432() throws NoSuchAlgorithmException, NoSuchPaddingException {
    Cipher c1 = Cipher.getInstance("AES/ECB/NoPadding");
  }
  
  public void newHotspot(String rawText) throws NoSuchAlgorithmException, NoSuchPaddingException {
    Cipher c = Cipher.getInstance("DESede/ECB/PKCS5Padding");
  }


}
