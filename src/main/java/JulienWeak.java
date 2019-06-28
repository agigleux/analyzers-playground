import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.crypto.cipher.CryptoCipherFactory;
import org.apache.commons.crypto.cipher.CryptoCipherFactory.CipherProvider;
import org.apache.commons.crypto.utils.Utils;

public class JulienWeak {

  public void validation() throws NoSuchAlgorithmException, NoSuchPaddingException, IOException {

    Cipher c = Cipher.getInstance("TAGADA"); // Questionable

    // === apache.commons.crypto ===

    Properties properties = new Properties();
    properties.setProperty(CryptoCipherFactory.CLASSES_KEY, CipherProvider.OPENSSL.getClassName());
    final String transform = "AES/CBC/PKCS5Padding";
    Utils.getCipherInstance(transform, properties); // Questionable
  }

}
