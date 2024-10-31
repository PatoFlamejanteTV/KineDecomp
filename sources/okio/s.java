package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* compiled from: Okio.java */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: a */
    static final Logger f29264a = Logger.getLogger(s.class.getName());

    private s() {
    }

    public static i a(z zVar) {
        return new v(zVar);
    }

    public static y b(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static z c(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static h a(y yVar) {
        return new t(yVar);
    }

    public static y a(OutputStream outputStream) {
        return a(outputStream, new B());
    }

    public static z b(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                C2576c c2 = c(socket);
                return c2.a(a(socket.getInputStream(), c2));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static C2576c c(Socket socket) {
        return new r(socket);
    }

    private static y a(OutputStream outputStream, B b2) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (b2 != null) {
            return new p(b2, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static y a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                C2576c c2 = c(socket);
                return c2.a(a(socket.getOutputStream(), c2));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static z a(InputStream inputStream) {
        return a(inputStream, new B());
    }

    private static z a(InputStream inputStream, B b2) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (b2 != null) {
            return new q(b2, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static y a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
