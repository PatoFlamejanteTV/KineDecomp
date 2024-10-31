package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: FormBody.java */
/* loaded from: classes3.dex */
public final class x extends L {

    /* renamed from: a, reason: collision with root package name */
    private static final C f29213a = C.a("application/x-www-form-urlencoded");

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f29214b;

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f29215c;

    /* compiled from: FormBody.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f29216a;

        /* renamed from: b, reason: collision with root package name */
        private final List<String> f29217b;

        /* renamed from: c, reason: collision with root package name */
        private final Charset f29218c;

        public a() {
            this(null);
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 != null) {
                this.f29216a.add(A.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f29218c));
                this.f29217b.add(A.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f29218c));
                return this;
            }
            throw new NullPointerException("value == null");
        }

        public a b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str2 != null) {
                this.f29216a.add(A.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f29218c));
                this.f29217b.add(A.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f29218c));
                return this;
            }
            throw new NullPointerException("value == null");
        }

        public a(Charset charset) {
            this.f29216a = new ArrayList();
            this.f29217b = new ArrayList();
            this.f29218c = charset;
        }

        public x a() {
            return new x(this.f29216a, this.f29217b);
        }
    }

    x(List<String> list, List<String> list2) {
        this.f29214b = okhttp3.a.e.a(list);
        this.f29215c = okhttp3.a.e.a(list2);
    }

    @Override // okhttp3.L
    public long a() {
        return a((okio.h) null, true);
    }

    @Override // okhttp3.L
    public C b() {
        return f29213a;
    }

    @Override // okhttp3.L
    public void a(okio.h hVar) throws IOException {
        a(hVar, false);
    }

    private long a(@Nullable okio.h hVar, boolean z) {
        okio.g d2;
        if (z) {
            d2 = new okio.g();
        } else {
            d2 = hVar.d();
        }
        int size = this.f29214b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                d2.writeByte(38);
            }
            d2.a(this.f29214b.get(i));
            d2.writeByte(61);
            d2.a(this.f29215c.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = d2.size();
        d2.a();
        return size2;
    }
}
