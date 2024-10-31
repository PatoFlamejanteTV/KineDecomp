package com.bumptech.glide.load.b;

import java.util.Queue;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class t<A, B> {

    /* renamed from: a */
    private final com.bumptech.glide.g.i<a<A>, B> f8641a;

    public t(long j) {
        this.f8641a = new s(this, j);
    }

    public B a(A a2, int i, int i2) {
        a<A> a3 = a.a(a2, i, i2);
        B a4 = this.f8641a.a((com.bumptech.glide.g.i<a<A>, B>) a3);
        a3.a();
        return a4;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f8641a.b(a.a(a2, i, i2), b2);
    }

    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    public static final class a<A> {

        /* renamed from: a */
        private static final Queue<a<?>> f8642a = com.bumptech.glide.g.n.a(0);

        /* renamed from: b */
        private int f8643b;

        /* renamed from: c */
        private int f8644c;

        /* renamed from: d */
        private A f8645d;

        private a() {
        }

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar;
            synchronized (f8642a) {
                aVar = (a) f8642a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private void b(A a2, int i, int i2) {
            this.f8645d = a2;
            this.f8644c = i;
            this.f8643b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8644c == aVar.f8644c && this.f8643b == aVar.f8643b && this.f8645d.equals(aVar.f8645d);
        }

        public int hashCode() {
            return (((this.f8643b * 31) + this.f8644c) * 31) + this.f8645d.hashCode();
        }

        public void a() {
            synchronized (f8642a) {
                f8642a.offer(this);
            }
        }
    }
}
