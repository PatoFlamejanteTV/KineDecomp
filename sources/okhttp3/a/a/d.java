package okhttp3.a.a;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.C2561e;
import okhttp3.I;
import okhttp3.M;
import okhttp3.a.b.f;
import okhttp3.z;

/* compiled from: CacheStrategy.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final I f28861a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final M f28862b;

    d(I i, M m) {
        this.f28861a = i;
        this.f28862b = m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:            if (r3.b().a() == false) goto L33;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(okhttp3.M r3, okhttp3.I r4) {
        /*
            int r0 = r3.c()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.e(r0)
            if (r0 != 0) goto L5a
            okhttp3.e r0 = r3.b()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L5a
            okhttp3.e r0 = r3.b()
            boolean r0 = r0.b()
            if (r0 != 0) goto L5a
            okhttp3.e r0 = r3.b()
            boolean r0 = r0.a()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            okhttp3.e r3 = r3.b()
            boolean r3 = r3.h()
            if (r3 != 0) goto L6f
            okhttp3.e r3 = r4.b()
            boolean r3 = r3.h()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.a.a.d.a(okhttp3.M, okhttp3.I):boolean");
    }

    /* compiled from: CacheStrategy.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f28863a;

        /* renamed from: b, reason: collision with root package name */
        final I f28864b;

        /* renamed from: c, reason: collision with root package name */
        final M f28865c;

        /* renamed from: d, reason: collision with root package name */
        private Date f28866d;

        /* renamed from: e, reason: collision with root package name */
        private String f28867e;

        /* renamed from: f, reason: collision with root package name */
        private Date f28868f;

        /* renamed from: g, reason: collision with root package name */
        private String f28869g;

        /* renamed from: h, reason: collision with root package name */
        private Date f28870h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, I i, M m) {
            this.l = -1;
            this.f28863a = j;
            this.f28864b = i;
            this.f28865c = m;
            if (m != null) {
                this.i = m.A();
                this.j = m.y();
                z s = m.s();
                int b2 = s.b();
                for (int i2 = 0; i2 < b2; i2++) {
                    String a2 = s.a(i2);
                    String b3 = s.b(i2);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f28866d = okhttp3.a.b.e.a(b3);
                        this.f28867e = b3;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.f28870h = okhttp3.a.b.e.a(b3);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f28868f = okhttp3.a.b.e.a(b3);
                        this.f28869g = b3;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.k = b3;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.l = f.a(b3, -1);
                    }
                }
            }
        }

        private long b() {
            Date date = this.f28866d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return max + (j - this.i) + (this.f28863a - j);
        }

        private long c() {
            long j;
            long j2;
            if (this.f28865c.b().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            if (this.f28870h != null) {
                Date date = this.f28866d;
                if (date != null) {
                    j2 = date.getTime();
                } else {
                    j2 = this.j;
                }
                long time = this.f28870h.getTime() - j2;
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f28868f == null || this.f28865c.z().g().l() != null) {
                return 0L;
            }
            Date date2 = this.f28866d;
            if (date2 != null) {
                j = date2.getTime();
            } else {
                j = this.i;
            }
            long time2 = j - this.f28868f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private d d() {
            if (this.f28865c == null) {
                return new d(this.f28864b, null);
            }
            if (this.f28864b.d() && this.f28865c.r() == null) {
                return new d(this.f28864b, null);
            }
            if (!d.a(this.f28865c, this.f28864b)) {
                return new d(this.f28864b, null);
            }
            C2561e b2 = this.f28864b.b();
            if (!b2.g() && !a(this.f28864b)) {
                C2561e b3 = this.f28865c.b();
                long b4 = b();
                long c2 = c();
                if (b2.c() != -1) {
                    c2 = Math.min(c2, TimeUnit.SECONDS.toMillis(b2.c()));
                }
                long j = 0;
                long millis = b2.e() != -1 ? TimeUnit.SECONDS.toMillis(b2.e()) : 0L;
                if (!b3.f() && b2.d() != -1) {
                    j = TimeUnit.SECONDS.toMillis(b2.d());
                }
                if (!b3.g()) {
                    long j2 = millis + b4;
                    if (j2 < j + c2) {
                        M.a w = this.f28865c.w();
                        if (j2 >= c2) {
                            w.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (b4 > 86400000 && e()) {
                            w.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new d(null, w.a());
                    }
                }
                String str = this.k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f28868f != null) {
                    str = this.f28869g;
                } else if (this.f28866d != null) {
                    str = this.f28867e;
                } else {
                    return new d(this.f28864b, null);
                }
                z.a a2 = this.f28864b.c().a();
                okhttp3.a.a.f28854a.a(a2, str2, str);
                I.a f2 = this.f28864b.f();
                f2.a(a2.a());
                return new d(f2.a(), this.f28865c);
            }
            return new d(this.f28864b, null);
        }

        private boolean e() {
            return this.f28865c.b().c() == -1 && this.f28870h == null;
        }

        public d a() {
            d d2 = d();
            return (d2.f28861a == null || !this.f28864b.b().i()) ? d2 : new d(null, null);
        }

        private static boolean a(I i) {
            return (i.a("If-Modified-Since") == null && i.a("If-None-Match") == null) ? false : true;
        }
    }
}
