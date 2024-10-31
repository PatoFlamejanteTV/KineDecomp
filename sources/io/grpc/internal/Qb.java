package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.InterfaceC2514o;
import io.grpc.InterfaceC2521p;
import io.grpc.InterfaceC2529y;
import io.grpc.Status;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: MessageFramer.java */
/* loaded from: classes3.dex */
public class Qb implements Ra {

    /* renamed from: a, reason: collision with root package name */
    private final c f27471a;

    /* renamed from: c, reason: collision with root package name */
    private Tc f27473c;

    /* renamed from: h, reason: collision with root package name */
    private final Uc f27478h;
    private final Mc i;
    private boolean j;
    private int k;
    private long m;

    /* renamed from: b, reason: collision with root package name */
    private int f27472b = -1;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC2521p f27474d = InterfaceC2514o.b.f27821a;

    /* renamed from: e, reason: collision with root package name */
    private boolean f27475e = true;

    /* renamed from: f, reason: collision with root package name */
    private final b f27476f = new b();

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f27477g = new byte[5];
    private int l = -1;

    /* compiled from: MessageFramer.java */
    /* loaded from: classes3.dex */
    public interface c {
        void a(@Nullable Tc tc, boolean z, boolean z2, int i);
    }

    public Qb(c cVar, Uc uc, Mc mc) {
        Preconditions.a(cVar, "sink");
        this.f27471a = cVar;
        Preconditions.a(uc, "bufferAllocator");
        this.f27478h = uc;
        Preconditions.a(mc, "statsTraceCtx");
        this.i = mc;
    }

    private int b(InputStream inputStream) throws IOException {
        if ((inputStream instanceof io.grpc.I) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    @Override // io.grpc.internal.Ra
    public void c(int i) {
        Preconditions.b(this.f27472b == -1, "max size already set");
        this.f27472b = i;
    }

    @Override // io.grpc.internal.Ra
    public void close() {
        if (isClosed()) {
            return;
        }
        this.j = true;
        Tc tc = this.f27473c;
        if (tc != null && tc.B() == 0) {
            a();
        }
        a(true, true);
    }

    @Override // io.grpc.internal.Ra
    public void flush() {
        Tc tc = this.f27473c;
        if (tc == null || tc.B() <= 0) {
            return;
        }
        a(false, true);
    }

    @Override // io.grpc.internal.Ra
    public boolean isClosed() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MessageFramer.java */
    /* loaded from: classes3.dex */
    public class b extends OutputStream {
        private b() {
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            Qb.this.a(bArr, i, i2);
        }
    }

    private int b(InputStream inputStream, int i) throws IOException {
        int i2 = this.f27472b;
        if (i2 >= 0 && i > i2) {
            throw Status.k.b(String.format("message too large %d > %d", Integer.valueOf(i), Integer.valueOf(this.f27472b))).c();
        }
        ByteBuffer wrap = ByteBuffer.wrap(this.f27477g);
        wrap.put((byte) 0);
        wrap.putInt(i);
        if (this.f27473c == null) {
            this.f27473c = this.f27478h.a(wrap.position() + i);
        }
        a(this.f27477g, 0, wrap.position());
        return a(inputStream, this.f27476f);
    }

    private int c(InputStream inputStream, int i) throws IOException {
        if (i != -1) {
            this.m = i;
            return b(inputStream, i);
        }
        a aVar = new a();
        int a2 = a(inputStream, aVar);
        int i2 = this.f27472b;
        if (i2 >= 0 && a2 > i2) {
            throw Status.k.b(String.format("message too large %d > %d", Integer.valueOf(a2), Integer.valueOf(this.f27472b))).c();
        }
        a(aVar, false);
        return a2;
    }

    @Override // io.grpc.internal.Ra
    public /* bridge */ /* synthetic */ Ra a(InterfaceC2521p interfaceC2521p) {
        a(interfaceC2521p);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MessageFramer.java */
    /* loaded from: classes3.dex */
    public final class a extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final List<Tc> f27479a;

        /* renamed from: b, reason: collision with root package name */
        private Tc f27480b;

        private a() {
            this.f27479a = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int B() {
            Iterator<Tc> it = this.f27479a.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += it.next().B();
            }
            return i;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            Tc tc = this.f27480b;
            if (tc != null && tc.a() > 0) {
                this.f27480b.a((byte) i);
            } else {
                write(new byte[]{(byte) i}, 0, 1);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.f27480b == null) {
                this.f27480b = Qb.this.f27478h.a(i2);
                this.f27479a.add(this.f27480b);
            }
            while (i2 > 0) {
                int min = Math.min(i2, this.f27480b.a());
                if (min == 0) {
                    this.f27480b = Qb.this.f27478h.a(Math.max(i2, this.f27480b.B() * 2));
                    this.f27479a.add(this.f27480b);
                } else {
                    this.f27480b.write(bArr, i, min);
                    i += min;
                    i2 -= min;
                }
            }
        }
    }

    @Override // io.grpc.internal.Ra
    public Qb a(InterfaceC2521p interfaceC2521p) {
        Preconditions.a(interfaceC2521p, "Can't pass an empty compressor");
        this.f27474d = interfaceC2521p;
        return this;
    }

    @Override // io.grpc.internal.Ra
    public void a(InputStream inputStream) {
        int c2;
        b();
        this.k++;
        this.l++;
        this.m = 0L;
        this.i.b(this.l);
        boolean z = this.f27475e && this.f27474d != InterfaceC2514o.b.f27821a;
        try {
            int b2 = b(inputStream);
            if (b2 != 0 && z) {
                c2 = a(inputStream, b2);
            } else {
                c2 = c(inputStream, b2);
            }
            if (b2 != -1 && c2 != b2) {
                throw Status.p.b(String.format("Message length inaccurate %s != %s", Integer.valueOf(c2), Integer.valueOf(b2))).c();
            }
            long j = c2;
            this.i.c(j);
            this.i.d(this.m);
            this.i.b(this.l, this.m, j);
        } catch (IOException e2) {
            throw Status.p.b("Failed to frame message").b(e2).c();
        } catch (RuntimeException e3) {
            throw Status.p.b("Failed to frame message").b(e3).c();
        }
    }

    private void b() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    private int a(InputStream inputStream, int i) throws IOException {
        a aVar = new a();
        OutputStream a2 = this.f27474d.a(aVar);
        try {
            int a3 = a(inputStream, a2);
            a2.close();
            int i2 = this.f27472b;
            if (i2 >= 0 && a3 > i2) {
                throw Status.k.b(String.format("message too large %d > %d", Integer.valueOf(a3), Integer.valueOf(this.f27472b))).c();
            }
            a(aVar, true);
            return a3;
        } catch (Throwable th) {
            a2.close();
            throw th;
        }
    }

    private void a(a aVar, boolean z) {
        ByteBuffer wrap = ByteBuffer.wrap(this.f27477g);
        wrap.put(z ? (byte) 1 : (byte) 0);
        int B = aVar.B();
        wrap.putInt(B);
        Tc a2 = this.f27478h.a(5);
        a2.write(this.f27477g, 0, wrap.position());
        if (B == 0) {
            this.f27473c = a2;
            return;
        }
        this.f27471a.a(a2, false, false, this.k - 1);
        this.k = 1;
        List list = aVar.f27479a;
        for (int i = 0; i < list.size() - 1; i++) {
            this.f27471a.a((Tc) list.get(i), false, false, 0);
        }
        this.f27473c = (Tc) list.get(list.size() - 1);
        this.m = B;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof InterfaceC2529y) {
            return ((InterfaceC2529y) inputStream).a(outputStream);
        }
        long a2 = C2465nb.a(inputStream, outputStream);
        Preconditions.a(a2 <= 2147483647L, "Message size overflow: %s", a2);
        return (int) a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            Tc tc = this.f27473c;
            if (tc != null && tc.a() == 0) {
                a(false, false);
            }
            if (this.f27473c == null) {
                this.f27473c = this.f27478h.a(i2);
            }
            int min = Math.min(i2, this.f27473c.a());
            this.f27473c.write(bArr, i, min);
            i += min;
            i2 -= min;
        }
    }

    private void a() {
        Tc tc = this.f27473c;
        if (tc != null) {
            tc.release();
            this.f27473c = null;
        }
    }

    private void a(boolean z, boolean z2) {
        Tc tc = this.f27473c;
        this.f27473c = null;
        this.f27471a.a(tc, z, z2, this.k);
        this.k = 0;
    }
}
