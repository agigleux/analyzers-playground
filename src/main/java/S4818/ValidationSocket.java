package S4818;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ValidationSocket {

    private ValidationSocket() {
    }

    public void caseSockClient() {
        Socket client = new Socket();
    }

    public void caseSocketServer() throws IOException {
        ServerSocket serverAutomaticPort = new ServerSocket(0);

        ServerSocket serverPort42 = new ServerSocket(42);

        ServerSocket serverUnbound = new ServerSocket();
    }

    public int ServerSocketInstanceMethod() throws IOException {
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        }
    }

    public static int ServerSocketStaticMethod() throws IOException {
        try (ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();
        }
    }
}