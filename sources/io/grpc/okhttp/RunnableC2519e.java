package io.grpc.okhttp;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: AsyncFrameWriter.java */
/* renamed from: io.grpc.okhttp.e */
/* loaded from: classes3.dex */
public class RunnableC2519e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ l f27856a;

    public RunnableC2519e(l lVar) {
        this.f27856a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger logger;
        Socket socket;
        if (this.f27856a.f27971b != null) {
            try {
                this.f27856a.f27971b.close();
                socket = this.f27856a.f27972c;
                socket.close();
            } catch (IOException e2) {
                logger = l.f27970a;
                logger.log(Level.WARNING, "Failed closing connection", (Throwable) e2);
            }
        }
    }
}
