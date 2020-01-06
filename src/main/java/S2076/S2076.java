package S2076;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.WindowsCodec;

public class S2076 {

    public void runUnsafe(HttpServletRequest request) throws IOException {
        String folder = request.getParameter("folder");

        String cmd = "mkdir " + folder;

        Runtime.getRuntime().exec(cmd);
    }

    public void runUnsafeMatches(HttpServletRequest request) throws IOException {
        String folder = request.getParameter("folder");

        String cmd = "mkdir " + folder;

        if (!cmd.matches("mkdir [a-zA-Z]++")) {
            throw new IllegalArgumentException();
        }

        Runtime.getRuntime().exec(cmd);
    }


    public void runSafe(HttpServletRequest request) throws IOException {
        String folder = request.getParameter("folder");

        String cmd = "mkdir " + ESAPI.encoder().encodeForOS(new WindowsCodec(), folder);

        Runtime.getRuntime().exec(cmd);
    }
}
