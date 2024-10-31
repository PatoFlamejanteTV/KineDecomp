package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.C2570n;

/* compiled from: ConnectionSpecSelector.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    private final List<C2570n> f28992a;

    /* renamed from: b */
    private int f28993b = 0;

    /* renamed from: c */
    private boolean f28994c;

    /* renamed from: d */
    private boolean f28995d;

    public b(List<C2570n> list) {
        this.f28992a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.f28993b; i < this.f28992a.size(); i++) {
            if (this.f28992a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public C2570n a(SSLSocket sSLSocket) throws IOException {
        C2570n c2570n;
        int i = this.f28993b;
        int size = this.f28992a.size();
        while (true) {
            if (i >= size) {
                c2570n = null;
                break;
            }
            c2570n = this.f28992a.get(i);
            if (c2570n.a(sSLSocket)) {
                this.f28993b = i + 1;
                break;
            }
            i++;
        }
        if (c2570n != null) {
            this.f28994c = b(sSLSocket);
            okhttp3.a.a.f28854a.a(c2570n, sSLSocket, this.f28995d);
            return c2570n;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f28995d + ", modes=" + this.f28992a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f28995d = true;
        if (!this.f28994c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException);
    }
}
