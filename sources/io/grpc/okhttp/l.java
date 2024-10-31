package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.internal.Dc;
import io.grpc.okhttp.internal.framed.ErrorCode;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: AsyncFrameWriter.java */
/* loaded from: classes3.dex */
public class l implements io.grpc.okhttp.internal.framed.b {

    /* renamed from: a */
    private static final Logger f27970a = Logger.getLogger(w.class.getName());

    /* renamed from: b */
    private io.grpc.okhttp.internal.framed.b f27971b;

    /* renamed from: c */
    private Socket f27972c;

    /* renamed from: d */
    private final Dc f27973d;

    /* renamed from: e */
    private final w f27974e;

    /* compiled from: AsyncFrameWriter.java */
    /* loaded from: classes3.dex */
    public abstract class a implements Runnable {
        private a() {
        }

        public abstract void b() throws IOException;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (l.this.f27971b != null) {
                    b();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable frameWriter.");
            } catch (RuntimeException e2) {
                l.this.f27974e.a(e2);
            } catch (Exception e3) {
                l.this.f27974e.a(e3);
            }
        }

        public /* synthetic */ a(l lVar, C2520f c2520f) {
            this();
        }
    }

    public l(w wVar, Dc dc) {
        this.f27974e = wVar;
        this.f27973d = dc;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f27973d.execute(new RunnableC2519e(this));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void flush() {
        this.f27973d.execute(new h(this));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void q() {
        this.f27973d.execute(new C2520f(this));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public int t() {
        io.grpc.okhttp.internal.framed.b bVar = this.f27971b;
        if (bVar == null) {
            return 16384;
        }
        return bVar.t();
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void b(io.grpc.okhttp.internal.framed.g gVar) {
        this.f27973d.execute(new C2515a(this, gVar));
    }

    public void a(io.grpc.okhttp.internal.framed.b bVar, Socket socket) {
        Preconditions.b(this.f27971b == null, "AsyncFrameWriter's setFrameWriter() should only be called once.");
        Preconditions.a(bVar, "frameWriter");
        this.f27971b = bVar;
        Preconditions.a(socket, "socket");
        this.f27972c = socket;
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void a(io.grpc.okhttp.internal.framed.g gVar) {
        this.f27973d.execute(new g(this, gVar));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void a(boolean z, boolean z2, int i, int i2, List<io.grpc.okhttp.internal.framed.c> list) {
        this.f27973d.execute(new i(this, z, z2, i, i2, list));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void a(int i, ErrorCode errorCode) {
        this.f27973d.execute(new j(this, i, errorCode));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void a(boolean z, int i, okio.g gVar, int i2) {
        this.f27973d.execute(new k(this, z, i, gVar, i2));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void a(boolean z, int i, int i2) {
        this.f27973d.execute(new C2516b(this, z, i, i2));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void a(int i, ErrorCode errorCode, byte[] bArr) {
        this.f27973d.execute(new C2517c(this, i, errorCode, bArr));
    }

    @Override // io.grpc.okhttp.internal.framed.b
    public void a(int i, long j) {
        this.f27973d.execute(new C2518d(this, i, j));
    }
}
