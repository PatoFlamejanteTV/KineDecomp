package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: ResponseBody.java */
/* loaded from: classes3.dex */
public abstract class O implements Closeable {

    /* renamed from: a */
    @Nullable
    private Reader f28838a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResponseBody.java */
    /* loaded from: classes3.dex */
    public static final class a extends Reader {

        /* renamed from: a */
        private final okio.i f28839a;

        /* renamed from: b */
        private final Charset f28840b;

        /* renamed from: c */
        private boolean f28841c;

        /* renamed from: d */
        @Nullable
        private Reader f28842d;

        a(okio.i iVar, Charset charset) {
            this.f28839a = iVar;
            this.f28840b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f28841c = true;
            Reader reader = this.f28842d;
            if (reader != null) {
                reader.close();
            } else {
                this.f28839a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (!this.f28841c) {
                Reader reader = this.f28842d;
                if (reader == null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(this.f28839a.p(), okhttp3.a.e.a(this.f28839a, this.f28840b));
                    this.f28842d = inputStreamReader;
                    reader = inputStreamReader;
                }
                return reader.read(cArr, i, i2);
            }
            throw new IOException("Stream closed");
        }
    }

    private Charset s() {
        C c2 = c();
        return c2 != null ? c2.a(okhttp3.a.e.j) : okhttp3.a.e.j;
    }

    public final Reader a() {
        Reader reader = this.f28838a;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(r(), s());
        this.f28838a = aVar;
        return aVar;
    }

    public abstract long b();

    @Nullable
    public abstract C c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.a.e.a(r());
    }

    public abstract okio.i r();

    public static O a(@Nullable C c2, byte[] bArr) {
        okio.g gVar = new okio.g();
        gVar.write(bArr);
        return a(c2, bArr.length, gVar);
    }

    public static O a(@Nullable C c2, long j, okio.i iVar) {
        if (iVar != null) {
            return new N(c2, j, iVar);
        }
        throw new NullPointerException("source == null");
    }
}
