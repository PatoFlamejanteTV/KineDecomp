package okhttp3;

import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.server.http.HttpHeaders;
import com.umeng.commonsdk.proguard.ap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okio.ByteString;

/* compiled from: MultipartBody.java */
/* loaded from: classes3.dex */
public final class D extends L {

    /* renamed from: a, reason: collision with root package name */
    public static final C f28764a = C.a("multipart/mixed");

    /* renamed from: b, reason: collision with root package name */
    public static final C f28765b = C.a("multipart/alternative");

    /* renamed from: c, reason: collision with root package name */
    public static final C f28766c = C.a("multipart/digest");

    /* renamed from: d, reason: collision with root package name */
    public static final C f28767d = C.a("multipart/parallel");

    /* renamed from: e, reason: collision with root package name */
    public static final C f28768e = C.a("multipart/form-data");

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f28769f = {58, 32};

    /* renamed from: g, reason: collision with root package name */
    private static final byte[] f28770g = {ap.k, 10};

    /* renamed from: h, reason: collision with root package name */
    private static final byte[] f28771h = {Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX};
    private final ByteString i;
    private final C j;
    private final C k;
    private final List<b> l;
    private long m = -1;

    /* compiled from: MultipartBody.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final ByteString f28772a;

        /* renamed from: b, reason: collision with root package name */
        private C f28773b;

        /* renamed from: c, reason: collision with root package name */
        private final List<b> f28774c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(C c2) {
            if (c2 != null) {
                if (c2.c().equals("multipart")) {
                    this.f28773b = c2;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + c2);
            }
            throw new NullPointerException("type == null");
        }

        public a(String str) {
            this.f28773b = D.f28764a;
            this.f28774c = new ArrayList();
            this.f28772a = ByteString.encodeUtf8(str);
        }

        public a a(@Nullable z zVar, L l) {
            a(b.a(zVar, l));
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.f28774c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public D a() {
            if (!this.f28774c.isEmpty()) {
                return new D(this.f28772a, this.f28773b, this.f28774c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* compiled from: MultipartBody.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        final z f28775a;

        /* renamed from: b, reason: collision with root package name */
        final L f28776b;

        private b(@Nullable z zVar, L l) {
            this.f28775a = zVar;
            this.f28776b = l;
        }

        public static b a(@Nullable z zVar, L l) {
            if (l != null) {
                if (zVar != null && zVar.b(HttpHeaders.CONTENT_TYPE) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if (zVar != null && zVar.b(HttpHeaders.CONTENT_LENGTH) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                return new b(zVar, l);
            }
            throw new NullPointerException("body == null");
        }
    }

    D(ByteString byteString, C c2, List<b> list) {
        this.i = byteString;
        this.j = c2;
        this.k = C.a(c2 + "; boundary=" + byteString.utf8());
        this.l = okhttp3.a.e.a(list);
    }

    @Override // okhttp3.L
    public long a() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((okio.h) null, true);
        this.m = a2;
        return a2;
    }

    @Override // okhttp3.L
    public C b() {
        return this.k;
    }

    @Override // okhttp3.L
    public void a(okio.h hVar) throws IOException {
        a(hVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(@Nullable okio.h hVar, boolean z) throws IOException {
        okio.g gVar;
        if (z) {
            hVar = new okio.g();
            gVar = hVar;
        } else {
            gVar = 0;
        }
        int size = this.l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.l.get(i);
            z zVar = bVar.f28775a;
            L l = bVar.f28776b;
            hVar.write(f28771h);
            hVar.a(this.i);
            hVar.write(f28770g);
            if (zVar != null) {
                int b2 = zVar.b();
                for (int i2 = 0; i2 < b2; i2++) {
                    hVar.a(zVar.a(i2)).write(f28769f).a(zVar.b(i2)).write(f28770g);
                }
            }
            C b3 = l.b();
            if (b3 != null) {
                hVar.a("Content-Type: ").a(b3.toString()).write(f28770g);
            }
            long a2 = l.a();
            if (a2 != -1) {
                hVar.a("Content-Length: ").d(a2).write(f28770g);
            } else if (z) {
                gVar.a();
                return -1L;
            }
            hVar.write(f28770g);
            if (z) {
                j += a2;
            } else {
                l.a(hVar);
            }
            hVar.write(f28770g);
        }
        hVar.write(f28771h);
        hVar.a(this.i);
        hVar.write(f28771h);
        hVar.write(f28770g);
        if (!z) {
            return j;
        }
        long size2 = j + gVar.size();
        gVar.a();
        return size2;
    }
}
