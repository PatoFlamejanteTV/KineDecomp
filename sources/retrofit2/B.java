package retrofit2;

import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.A;
import okhttp3.D;
import okhttp3.I;
import okhttp3.L;
import okhttp3.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestBuilder.java */
/* loaded from: classes3.dex */
public final class B {

    /* renamed from: a */
    private static final char[] f29393a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private static final Pattern f29394b = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: c */
    private final String f29395c;

    /* renamed from: d */
    private final okhttp3.A f29396d;

    /* renamed from: e */
    @Nullable
    private String f29397e;

    /* renamed from: f */
    @Nullable
    private A.a f29398f;

    /* renamed from: g */
    private final I.a f29399g = new I.a();

    /* renamed from: h */
    @Nullable
    private okhttp3.C f29400h;
    private final boolean i;

    @Nullable
    private D.a j;

    @Nullable
    private x.a k;

    @Nullable
    private L l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RequestBuilder.java */
    /* loaded from: classes3.dex */
    public static class a extends L {

        /* renamed from: a */
        private final L f29401a;

        /* renamed from: b */
        private final okhttp3.C f29402b;

        a(L l, okhttp3.C c2) {
            this.f29401a = l;
            this.f29402b = c2;
        }

        @Override // okhttp3.L
        public long a() throws IOException {
            return this.f29401a.a();
        }

        @Override // okhttp3.L
        public okhttp3.C b() {
            return this.f29402b;
        }

        @Override // okhttp3.L
        public void a(okio.h hVar) throws IOException {
            this.f29401a.a(hVar);
        }
    }

    public B(String str, okhttp3.A a2, @Nullable String str2, @Nullable okhttp3.z zVar, @Nullable okhttp3.C c2, boolean z, boolean z2, boolean z3) {
        this.f29395c = str;
        this.f29396d = a2;
        this.f29397e = str2;
        this.f29400h = c2;
        this.i = z;
        if (zVar != null) {
            this.f29399g.a(zVar);
        }
        if (z2) {
            this.k = new x.a();
        } else if (z3) {
            this.j = new D.a();
            this.j.a(okhttp3.D.f28768e);
        }
    }

    public void a(String str, String str2) {
        if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str)) {
            try {
                this.f29400h = okhttp3.C.a(str2);
                return;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        }
        this.f29399g.a(str, str2);
    }

    public void b(String str, String str2, boolean z) {
        if (this.f29397e != null) {
            String a2 = a(str2, z);
            String replace = this.f29397e.replace("{" + str + "}", a2);
            if (!f29394b.matcher(replace).matches()) {
                this.f29397e = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    public void c(String str, @Nullable String str2, boolean z) {
        String str3 = this.f29397e;
        if (str3 != null) {
            this.f29398f = this.f29396d.c(str3);
            if (this.f29398f != null) {
                this.f29397e = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f29396d + ", Relative: " + this.f29397e);
            }
        }
        if (z) {
            this.f29398f.a(str, str2);
        } else {
            this.f29398f.b(str, str2);
        }
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i += Character.charCount(codePointAt);
            } else {
                okio.g gVar = new okio.g();
                gVar.a(str, 0, i);
                a(gVar, str, i, length, z);
                return gVar.s();
            }
        }
        return str;
    }

    private static void a(okio.g gVar, String str, int i, int i2, boolean z) {
        okio.g gVar2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && " \"<>^`{}|\\?#".indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                    gVar.c(codePointAt);
                } else {
                    if (gVar2 == null) {
                        gVar2 = new okio.g();
                    }
                    gVar2.c(codePointAt);
                    while (!gVar2.l()) {
                        int readByte = gVar2.readByte() & 255;
                        gVar.writeByte(37);
                        gVar.writeByte((int) f29393a[(readByte >> 4) & 15]);
                        gVar.writeByte((int) f29393a[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public void a(String str, String str2, boolean z) {
        if (z) {
            this.k.b(str, str2);
        } else {
            this.k.a(str, str2);
        }
    }

    public void a(okhttp3.z zVar, L l) {
        this.j.a(zVar, l);
    }

    public void a(D.b bVar) {
        this.j.a(bVar);
    }

    public I.a a() {
        okhttp3.A e2;
        A.a aVar = this.f29398f;
        if (aVar != null) {
            e2 = aVar.a();
        } else {
            e2 = this.f29396d.e(this.f29397e);
            if (e2 == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f29396d + ", Relative: " + this.f29397e);
            }
        }
        L l = this.l;
        if (l == null) {
            x.a aVar2 = this.k;
            if (aVar2 != null) {
                l = aVar2.a();
            } else {
                D.a aVar3 = this.j;
                if (aVar3 != null) {
                    l = aVar3.a();
                } else if (this.i) {
                    l = L.a((okhttp3.C) null, new byte[0]);
                }
            }
        }
        okhttp3.C c2 = this.f29400h;
        if (c2 != null) {
            if (l != null) {
                l = new a(l, c2);
            } else {
                this.f29399g.a(HttpHeaders.CONTENT_TYPE, c2.toString());
            }
        }
        I.a aVar4 = this.f29399g;
        aVar4.a(e2);
        aVar4.a(this.f29395c, l);
        return aVar4;
    }
}
