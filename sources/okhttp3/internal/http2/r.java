package okhttp3.internal.http2;

import android.support.v7.widget.ActivityChooserView;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Writer.java */
/* loaded from: classes3.dex */
public final class r implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f29141a = Logger.getLogger(c.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private final okio.h f29142b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f29143c;

    /* renamed from: f, reason: collision with root package name */
    private boolean f29146f;

    /* renamed from: d, reason: collision with root package name */
    private final okio.g f29144d = new okio.g();

    /* renamed from: g, reason: collision with root package name */
    final b.C0169b f29147g = new b.C0169b(this.f29144d);

    /* renamed from: e, reason: collision with root package name */
    private int f29145e = 16384;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(okio.h hVar, boolean z) {
        this.f29142b = hVar;
        this.f29143c = z;
    }

    private void c(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f29145e, j);
            long j2 = min;
            j -= j2;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f29142b.a(this.f29144d, j2);
        }
    }

    public synchronized void a(v vVar) throws IOException {
        if (!this.f29146f) {
            this.f29145e = vVar.c(this.f29145e);
            if (vVar.b() != -1) {
                this.f29147g.a(vVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f29142b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void b(v vVar) throws IOException {
        if (!this.f29146f) {
            int i = 0;
            a(0, vVar.d() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (vVar.d(i)) {
                    this.f29142b.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f29142b.writeInt(vVar.a(i));
                }
                i++;
            }
            this.f29142b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f29146f = true;
        this.f29142b.close();
    }

    public synchronized void flush() throws IOException {
        if (!this.f29146f) {
            this.f29142b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void q() throws IOException {
        if (!this.f29146f) {
            if (this.f29143c) {
                if (f29141a.isLoggable(Level.FINE)) {
                    f29141a.fine(okhttp3.a.e.a(">> CONNECTION %s", c.f29049a.hex()));
                }
                this.f29142b.write(c.f29049a.toByteArray());
                this.f29142b.flush();
                return;
            }
            return;
        }
        throw new IOException("closed");
    }

    public int t() {
        return this.f29145e;
    }

    public synchronized void a(int i, int i2, List<a> list) throws IOException {
        if (!this.f29146f) {
            this.f29147g.a(list);
            long size = this.f29144d.size();
            int min = (int) Math.min(this.f29145e - 4, size);
            long j = min;
            a(i, min + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
            this.f29142b.writeInt(i2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.f29142b.a(this.f29144d, j);
            if (size > j) {
                c(i, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, int i2, List<a> list) throws IOException {
        if (!this.f29146f) {
            a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, ErrorCode errorCode) throws IOException {
        if (!this.f29146f) {
            if (errorCode.httpCode != -1) {
                a(i, 4, (byte) 3, (byte) 0);
                this.f29142b.writeInt(errorCode.httpCode);
                this.f29142b.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, okio.g gVar, int i2) throws IOException {
        if (!this.f29146f) {
            a(i, z ? (byte) 1 : (byte) 0, gVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    void a(int i, byte b2, okio.g gVar, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f29142b.a(gVar, i2);
        }
    }

    public synchronized void a(boolean z, int i, int i2) throws IOException {
        if (!this.f29146f) {
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f29142b.writeInt(i);
            this.f29142b.writeInt(i2);
            this.f29142b.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (!this.f29146f) {
            if (errorCode.httpCode != -1) {
                a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f29142b.writeInt(i);
                this.f29142b.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.f29142b.write(bArr);
                }
                this.f29142b.flush();
            } else {
                c.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, long j) throws IOException {
        if (this.f29146f) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            a(i, 4, (byte) 8, (byte) 0);
            this.f29142b.writeInt((int) j);
            this.f29142b.flush();
        } else {
            c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    public void a(int i, int i2, byte b2, byte b3) throws IOException {
        if (f29141a.isLoggable(Level.FINE)) {
            f29141a.fine(c.a(false, i, i2, b2, b3));
        }
        int i3 = this.f29145e;
        if (i2 > i3) {
            c.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            a(this.f29142b, i2);
            this.f29142b.writeByte(b2 & 255);
            this.f29142b.writeByte(b3 & 255);
            this.f29142b.writeInt(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            return;
        }
        c.a("reserved bit set: %s", Integer.valueOf(i));
        throw null;
    }

    private static void a(okio.h hVar, int i) throws IOException {
        hVar.writeByte((i >>> 16) & 255);
        hVar.writeByte((i >>> 8) & 255);
        hVar.writeByte(i & 255);
    }

    void a(boolean z, int i, List<a> list) throws IOException {
        if (!this.f29146f) {
            this.f29147g.a(list);
            long size = this.f29144d.size();
            int min = (int) Math.min(this.f29145e, size);
            long j = min;
            byte b2 = size == j ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i, min, (byte) 1, b2);
            this.f29142b.a(this.f29144d, j);
            if (size > j) {
                c(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
