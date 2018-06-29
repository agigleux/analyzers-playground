package org.sonarlint.hotspots;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.Cookie;

public class VeryNotSecuredCode {

  public void S2068() {
    String password = "blue";
    System.out.println(password);
  }

  public Socket S1313() throws UnknownHostException, IOException {
    String ip = "127.0.0.1";
    return new Socket(ip, 6667);
  }

  public Cookie createCookie() {
    Cookie cookie = new Cookie("myCookieName", "12");
    return cookie;
  }

  public void secondNewHotspot(String rawText) throws NoSuchAlgorithmException, NoSuchPaddingException {
    Cipher c = Cipher.getInstance("DESede/ECB/PKCS5Padding");
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

  public String stupidMethod() {
    return "tagada";
  }

}
