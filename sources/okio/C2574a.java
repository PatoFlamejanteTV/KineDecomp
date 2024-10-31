package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AsyncTimeout.java */
/* renamed from: okio.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2574a implements y {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f29230a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2576c f29231b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2574a(C2576c c2576c, y yVar) {
        this.f29231b = c2576c;
        this.f29230a = yVar;
    }

    @Override // okio.y
    public void a(g gVar, long j) throws IOException {
        C.a(gVar.f29244c, 0L, j);
        while (true) {
            long j2 = 0;
            if (j <= 0) {
                return;
            }
            w wVar = gVar.f29243b;
            while (true) {
                if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    break;
                }
                j2 += wVar.f29274c - wVar.f29273b;
                if (j2 >= j) {
                    j2 = j;
                    break;
                }
                wVar = wVar.f29277f;
            }
            this.f29231b.h();
            try {
                try {
                    this.f29230a.a(gVar, j2);
                    j -= j2;
                    this.f29231b.a(true);
                } catch (IOException e2) {
                    throw this.f29231b.a(e2);
                }
            } catch (Throwable th) {
                this.f29231b.a(false);
                throw th;
            }
        }
    }

    @Override // okio.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29231b.h();
        try {
            try {
                this.f29230a.close();
                this.f29231b.a(true);
            } catch (IOException e2) {
                throw this.f29231b.a(e2);
            }
        } catch (Throwable th) {
            this.f29231b.a(false);
            throw th;
        }
    }

    @Override // okio.y
    public B e() {
        return this.f29231b;
    }

    @Override // okio.y, java.io.Flushable
    public void flush() throws IOException {
        this.f29231b.h();
        try {
            try {
                this.f29230a.flush();
                this.f29231b.a(true);
            } catch (IOException e2) {
                throw this.f29231b.a(e2);
            }
        } catch (Throwable th) {
            this.f29231b.a(false);
            throw th;
        }
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.f29230a + ")";
    }
}
