package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import javax.annotation.Nullable;

/* compiled from: Okio.java */
/* loaded from: classes3.dex */
public final class r extends C2576c {
    final /* synthetic */ Socket k;

    public r(Socket socket) {
        this.k = socket;
    }

    @Override // okio.C2576c
    protected IOException b(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.C2576c
    protected void j() {
        try {
            this.k.close();
        } catch (AssertionError e2) {
            if (s.a(e2)) {
                s.f29264a.log(Level.WARNING, "Failed to close timed out socket " + this.k, (Throwable) e2);
                return;
            }
            throw e2;
        } catch (Exception e3) {
            s.f29264a.log(Level.WARNING, "Failed to close timed out socket " + this.k, (Throwable) e3);
        }
    }
}
