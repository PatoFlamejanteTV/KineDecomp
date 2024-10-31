package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2382h;
import com.squareup.okhttp.E;
import com.squareup.okhttp.H;
import com.squareup.okhttp.x;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheStrategy.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final E f25413a;

    /* renamed from: b, reason: collision with root package name */
    public final H f25414b;

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:            if (r3.b().a() == false) goto L33;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.squareup.okhttp.H r3, com.squareup.okhttp.E r4) {
        /*
            int r0 = r3.e()
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
            java.lang.String r0 = r3.a(r0)
            if (r0 != 0) goto L5a
            com.squareup.okhttp.h r0 = r3.b()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L5a
            com.squareup.okhttp.h r0 = r3.b()
            boolean r0 = r0.b()
            if (r0 != 0) goto L5a
            com.squareup.okhttp.h r0 = r3.b()
            boolean r0 = r0.a()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.squareup.okhttp.h r3 = r3.b()
            boolean r3 = r3.h()
            if (r3 != 0) goto L6f
            com.squareup.okhttp.h r3 = r4.b()
            boolean r3 = r3.h()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.d.a(com.squareup.okhttp.H, com.squareup.okhttp.E):boolean");
    }

    private d(E e2, H h2) {
        this.f25413a = e2;
        this.f25414b = h2;
    }

    /* compiled from: CacheStrategy.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f25415a;

        /* renamed from: b, reason: collision with root package name */
        final E f25416b;

        /* renamed from: c, reason: collision with root package name */
        final H f25417c;

        /* renamed from: d, reason: collision with root package name */
        private Date f25418d;

        /* renamed from: e, reason: collision with root package name */
        private String f25419e;

        /* renamed from: f, reason: collision with root package name */
        private Date f25420f;

        /* renamed from: g, reason: collision with root package name */
        private String f25421g;

        /* renamed from: h, reason: collision with root package name */
        private Date f25422h;
        private long i;
        private long j;
        private String k;
        private int l;

        public a(long j, E e2, H h2) {
            this.l = -1;
            this.f25415a = j;
            this.f25416b = e2;
            this.f25417c = h2;
            if (h2 != null) {
                x g2 = h2.g();
                int b2 = g2.b();
                for (int i = 0; i < b2; i++) {
                    String a2 = g2.a(i);
                    String b3 = g2.b(i);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f25418d = j.a(b3);
                        this.f25419e = b3;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.f25422h = j.a(b3);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f25420f = j.a(b3);
                        this.f25421g = b3;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.k = b3;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.l = e.a(b3, -1);
                    } else if (q.f25478c.equalsIgnoreCase(a2)) {
                        this.i = Long.parseLong(b3);
                    } else if (q.f25479d.equalsIgnoreCase(a2)) {
                        this.j = Long.parseLong(b3);
                    }
                }
            }
        }

        private long b() {
            Date date = this.f25418d;
            long max = date != null ? Math.max(0L, this.j - date.getTime()) : 0L;
            int i = this.l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.j;
            return max + (j - this.i) + (this.f25415a - j);
        }

        private long c() {
            if (this.f25417c.b().c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.c());
            }
            if (this.f25422h != null) {
                Date date = this.f25418d;
                long time = this.f25422h.getTime() - (date != null ? date.getTime() : this.j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f25420f == null || this.f25417c.l().d().k() != null) {
                return 0L;
            }
            Date date2 = this.f25418d;
            long time2 = (date2 != null ? date2.getTime() : this.i) - this.f25420f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private d d() {
            H h2 = null;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            byte b6 = 0;
            byte b7 = 0;
            byte b8 = 0;
            byte b9 = 0;
            byte b10 = 0;
            byte b11 = 0;
            byte b12 = 0;
            byte b13 = 0;
            if (this.f25417c == null) {
                return new d(this.f25416b, h2);
            }
            if (this.f25416b.e() && this.f25417c.f() == null) {
                return new d(this.f25416b, b12 == true ? 1 : 0);
            }
            if (!d.a(this.f25417c, this.f25416b)) {
                return new d(this.f25416b, b10 == true ? 1 : 0);
            }
            C2382h b14 = this.f25416b.b();
            if (!b14.g() && !a(this.f25416b)) {
                long b15 = b();
                long c2 = c();
                if (b14.c() != -1) {
                    c2 = Math.min(c2, TimeUnit.SECONDS.toMillis(b14.c()));
                }
                long j = 0;
                long millis = b14.e() != -1 ? TimeUnit.SECONDS.toMillis(b14.e()) : 0L;
                C2382h b16 = this.f25417c.b();
                if (!b16.f() && b14.d() != -1) {
                    j = TimeUnit.SECONDS.toMillis(b14.d());
                }
                if (!b16.g()) {
                    long j2 = millis + b15;
                    if (j2 < j + c2) {
                        H.a j3 = this.f25417c.j();
                        if (j2 >= c2) {
                            j3.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (b15 > 86400000 && e()) {
                            j3.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new d(b8 == true ? 1 : 0, j3.a());
                    }
                }
                E.a g2 = this.f25416b.g();
                String str = this.k;
                if (str != null) {
                    g2.b("If-None-Match", str);
                } else if (this.f25420f != null) {
                    g2.b("If-Modified-Since", this.f25421g);
                } else if (this.f25418d != null) {
                    g2.b("If-Modified-Since", this.f25419e);
                }
                E a2 = g2.a();
                return a(a2) ? new d(a2, this.f25417c) : new d(a2, b5 == true ? 1 : 0);
            }
            return new d(this.f25416b, b3 == true ? 1 : 0);
        }

        private boolean e() {
            return this.f25417c.b().c() == -1 && this.f25422h == null;
        }

        public d a() {
            d d2 = d();
            if (d2.f25413a == null || !this.f25416b.b().i()) {
                return d2;
            }
            return new d(null, 0 == true ? 1 : 0);
        }

        private static boolean a(E e2) {
            return (e2.a("If-Modified-Since") == null && e2.a("If-None-Match") == null) ? false : true;
        }
    }
}
