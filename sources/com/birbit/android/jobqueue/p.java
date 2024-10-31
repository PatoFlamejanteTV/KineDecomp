package com.birbit.android.jobqueue;

import android.content.Context;
import java.util.Set;

/* compiled from: JobHolder.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a */
    private Long f8241a;

    /* renamed from: b */
    public final String f8242b;

    /* renamed from: c */
    public final boolean f8243c;

    /* renamed from: d */
    private int f8244d;

    /* renamed from: e */
    public final String f8245e;

    /* renamed from: f */
    private int f8246f;

    /* renamed from: g */
    private long f8247g;

    /* renamed from: h */
    private long f8248h;
    private long i;
    int j;
    private long k;
    private boolean l;
    final transient Job m;
    protected final Set<String> n;
    private volatile boolean o;
    private volatile boolean p;
    y q;
    private Throwable r;

    /* compiled from: JobHolder.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private int f8249a;

        /* renamed from: b */
        private String f8250b;

        /* renamed from: c */
        private boolean f8251c;

        /* renamed from: d */
        private String f8252d;

        /* renamed from: f */
        private Job f8254f;

        /* renamed from: g */
        private long f8255g;
        private Long i;
        private long j;
        private Set<String> n;
        private int o;

        /* renamed from: e */
        private int f8253e = 0;

        /* renamed from: h */
        private long f8256h = Long.MIN_VALUE;
        private long k = Long.MAX_VALUE;
        private boolean l = false;
        private int m = 0;

        public a a(int i) {
            this.f8249a = i;
            this.m |= 1;
            return this;
        }

        public a b(String str) {
            this.f8250b = str;
            this.m |= 4;
            return this;
        }

        public a c(int i) {
            this.f8253e = i;
            return this;
        }

        public a d(long j) {
            this.j = j;
            this.m |= 256;
            return this;
        }

        public a c(long j) {
            this.i = Long.valueOf(j);
            return this;
        }

        public a a(String str) {
            this.f8252d = str;
            this.m |= 8;
            return this;
        }

        public a b(int i) {
            this.o = i;
            this.m |= 1024;
            return this;
        }

        public a a(Set<String> set) {
            this.n = set;
            this.m |= 512;
            return this;
        }

        public a b(long j) {
            this.f8256h = j;
            this.m |= 64;
            return this;
        }

        public a a(boolean z) {
            this.f8251c = z;
            this.m |= 2;
            return this;
        }

        public a a(Job job) {
            this.f8254f = job;
            this.m |= 16;
            return this;
        }

        public a a(long j) {
            this.f8255g = j;
            this.m |= 32;
            return this;
        }

        public a a(long j, boolean z) {
            this.k = j;
            this.l = z;
            this.m |= 128;
            return this;
        }

        public p a() {
            p pVar;
            Job job = this.f8254f;
            if (job != null) {
                int i = this.m & 2047;
                if (i == 2047) {
                    p pVar2 = new p(this.f8250b, this.f8251c, this.f8249a, this.f8252d, this.f8253e, job, this.f8255g, this.f8256h, this.j, this.n, this.o, this.k, this.l);
                    Long l = this.i;
                    if (l != null) {
                        pVar = pVar2;
                        pVar.b(l.longValue());
                    } else {
                        pVar = pVar2;
                    }
                    this.f8254f.updateFromJobHolder(pVar);
                    return pVar;
                }
                throw new IllegalArgumentException("must provide all required fields. your result:" + Long.toBinaryString(i));
            }
            throw new IllegalArgumentException("must provide a job");
        }
    }

    /* synthetic */ p(String str, boolean z, int i, String str2, int i2, Job job, long j, long j2, long j3, Set set, int i3, long j4, boolean z2, o oVar) {
        this(str, z, i, str2, i2, job, j, j2, j3, set, i3, j4, z2);
    }

    public int a(int i, com.birbit.android.jobqueue.i.b bVar) {
        return this.m.safeRun(this, i, bVar);
    }

    public void b(int i) {
        this.f8244d = i;
        this.m.priority = this.f8244d;
    }

    public void c(int i) {
        this.f8246f = i;
    }

    public String d() {
        return this.f8245e;
    }

    public String e() {
        return this.f8242b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f8242b.equals(((p) obj).f8242b);
        }
        return false;
    }

    public Long f() {
        return this.f8241a;
    }

    public Job g() {
        return this.m;
    }

    public int h() {
        return this.f8244d;
    }

    public int hashCode() {
        return this.f8242b.hashCode();
    }

    public int i() {
        return this.j;
    }

    public y j() {
        return this.q;
    }

    public int k() {
        return this.f8246f;
    }

    public long l() {
        return this.i;
    }

    public Set<String> m() {
        return this.n;
    }

    public Throwable n() {
        return this.r;
    }

    public boolean o() {
        return this.k != Long.MAX_VALUE;
    }

    public boolean p() {
        return this.f8247g != Long.MIN_VALUE;
    }

    public boolean q() {
        Set<String> set = this.n;
        return set != null && set.size() > 0;
    }

    public boolean r() {
        return this.o;
    }

    public boolean s() {
        return this.p;
    }

    public void t() {
        this.o = true;
        this.m.cancelled = true;
    }

    public void u() {
        this.p = true;
        t();
    }

    public boolean v() {
        return this.l;
    }

    private p(String str, boolean z, int i, String str2, int i2, Job job, long j, long j2, long j3, Set<String> set, int i3, long j4, boolean z2) {
        this.f8242b = str;
        this.f8243c = z;
        this.f8244d = i;
        this.f8245e = str2;
        this.f8246f = i2;
        this.f8248h = j;
        this.f8247g = j2;
        this.m = job;
        this.i = j3;
        this.j = i3;
        this.n = set;
        this.k = j4;
        this.l = z2;
    }

    public void a(long j) {
        this.f8247g = j;
    }

    public void c(long j) {
        this.i = j;
    }

    public long a() {
        return this.f8248h;
    }

    public void b(long j) {
        this.f8241a = Long.valueOf(j);
    }

    public long c() {
        return this.f8247g;
    }

    public void a(Context context) {
        this.m.setApplicationContext(context);
    }

    public long b() {
        return this.k;
    }

    public void a(boolean z) {
        this.m.setDeadlineReached(z);
    }

    public void a(int i) {
        this.m.onCancel(i, this.r);
    }

    public void a(Throwable th) {
        this.r = th;
    }
}
