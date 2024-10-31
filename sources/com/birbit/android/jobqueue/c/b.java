package com.birbit.android.jobqueue.c;

import android.content.Context;
import com.birbit.android.jobqueue.f.c;
import com.birbit.android.jobqueue.g.f;
import com.birbit.android.jobqueue.m;
import com.birbit.android.jobqueue.x;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

/* compiled from: Configuration.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    String f8121a;

    /* renamed from: b */
    int f8122b;

    /* renamed from: c */
    int f8123c;

    /* renamed from: d */
    int f8124d;

    /* renamed from: e */
    int f8125e;

    /* renamed from: f */
    Context f8126f;

    /* renamed from: g */
    x f8127g;

    /* renamed from: h */
    com.birbit.android.jobqueue.d.a f8128h;
    com.birbit.android.jobqueue.g.b i;
    com.birbit.android.jobqueue.f.a j;
    com.birbit.android.jobqueue.i.b k;
    com.birbit.android.jobqueue.h.a l;
    boolean m;
    boolean n;
    int o;
    boolean p;
    ThreadFactory q;

    /* synthetic */ b(com.birbit.android.jobqueue.c.a aVar) {
        this();
    }

    public boolean a() {
        return this.p;
    }

    public Context b() {
        return this.f8126f;
    }

    public int c() {
        return this.f8124d;
    }

    public com.birbit.android.jobqueue.f.a d() {
        return this.j;
    }

    public com.birbit.android.jobqueue.d.a e() {
        return this.f8128h;
    }

    public String f() {
        return this.f8121a;
    }

    public int g() {
        return this.f8125e;
    }

    public int h() {
        return this.f8122b;
    }

    public int i() {
        return this.f8123c;
    }

    public com.birbit.android.jobqueue.g.b j() {
        return this.i;
    }

    public x k() {
        return this.f8127g;
    }

    public com.birbit.android.jobqueue.h.a l() {
        return this.l;
    }

    public ThreadFactory m() {
        return this.q;
    }

    public int n() {
        return this.o;
    }

    public com.birbit.android.jobqueue.i.b o() {
        return this.k;
    }

    public boolean p() {
        return this.m;
    }

    public boolean q() {
        return this.n;
    }

    private b() {
        this.f8121a = "default_job_manager";
        this.f8122b = 5;
        this.f8123c = 0;
        this.f8124d = 15;
        this.f8125e = 3;
        this.j = new c.a();
        this.m = false;
        this.n = false;
        this.o = 5;
        this.p = true;
        this.q = null;
    }

    /* compiled from: Configuration.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private Pattern f8129a = Pattern.compile("^([A-Za-z]|[0-9]|_|-)+$");

        /* renamed from: b */
        private b f8130b = new b();

        public a(Context context) {
            this.f8130b.f8126f = context.getApplicationContext();
        }

        public a a(String str) {
            if (str != null && this.f8129a.matcher(str).matches()) {
                this.f8130b.f8121a = str;
                return this;
            }
            throw new IllegalArgumentException("id cannot be null or empty and can only include alphanumeric characters, - or _ .");
        }

        public a a(x xVar) {
            if (this.f8130b.f8127g != null && xVar != null) {
                throw new RuntimeException("already set a queue factory. This might happen ifyou've provided a custom job serializer");
            }
            this.f8130b.f8127g = xVar;
            return this;
        }

        public b a() {
            b bVar = this.f8130b;
            if (bVar.f8127g == null) {
                bVar.f8127g = new m();
            }
            b bVar2 = this.f8130b;
            if (bVar2.i == null) {
                bVar2.i = new f(bVar2.f8126f);
            }
            b bVar3 = this.f8130b;
            if (bVar3.k == null) {
                bVar3.k = new com.birbit.android.jobqueue.i.a();
            }
            return this.f8130b;
        }
    }
}
