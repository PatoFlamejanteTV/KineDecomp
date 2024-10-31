package com.adobe.creativesdk.foundation.internal.net;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: AdobeNetworkCompositeHttpTaskHandle.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.net.c */
/* loaded from: classes.dex */
public class C0324c extends E {
    private long l = 0;
    private long m = 0;
    private ConcurrentLinkedQueue<b> o = null;
    private ConcurrentLinkedQueue<E> j = null;
    private boolean k = false;
    private ConcurrentLinkedQueue<C0027c> n = null;

    /* compiled from: AdobeNetworkCompositeHttpTaskHandle.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.net.c$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public void a(E e2, long j) {
        if (this.j == null) {
            this.j = new ConcurrentLinkedQueue<>();
            this.n = new ConcurrentLinkedQueue<>();
            this.o = new ConcurrentLinkedQueue<>();
        }
        C0027c c0027c = new C0027c();
        c0027c.f5102b = j;
        c0027c.f5101a = e2;
        c0027c.f5103c = new WeakReference<>(this);
        b bVar = new b();
        bVar.f5099a = j;
        bVar.f5100b = 0.0d;
        this.n.add(c0027c);
        e2.a(c0027c);
        this.o.add(bVar);
        this.j.add(e2);
    }

    public void b(long j) {
        this.l = j;
        long j2 = this.l;
        if (j2 != 0) {
            long j3 = this.m;
            if (j3 != 0) {
                a((int) ((((float) j3) * 100.0f) / ((float) j2)));
            }
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.E
    public boolean c() {
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = this.j;
        if (concurrentLinkedQueue != null) {
            Iterator<E> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                if (it.next().c()) {
                    return true;
                }
            }
        }
        return super.c();
    }

    public void f() {
        this.k = true;
        if (this.j == null) {
            a(100);
        }
    }

    public long g() {
        return this.l;
    }

    public void h() {
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = this.j;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        ConcurrentLinkedQueue<C0027c> concurrentLinkedQueue2 = this.n;
        if (concurrentLinkedQueue2 != null) {
            Iterator<C0027c> it = concurrentLinkedQueue2.iterator();
            while (it.hasNext()) {
                C0027c next = it.next();
                next.f5101a.b(next);
            }
            this.n.clear();
        }
    }

    /* compiled from: AdobeNetworkCompositeHttpTaskHandle.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.net.c$b */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        long f5099a;

        /* renamed from: b */
        double f5100b;

        private b() {
            this.f5099a = 0L;
            this.f5100b = 0.0d;
        }

        /* synthetic */ b(C0323b c0323b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdobeNetworkCompositeHttpTaskHandle.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.net.c$c */
    /* loaded from: classes.dex */
    public static class C0027c implements H {

        /* renamed from: a */
        E f5101a;

        /* renamed from: b */
        long f5102b;

        /* renamed from: c */
        WeakReference<C0324c> f5103c;

        private C0027c() {
            this.f5101a = null;
            this.f5102b = 0L;
            this.f5103c = null;
        }

        @Override // com.adobe.creativesdk.foundation.internal.net.H
        public void a(double d2) {
            C0324c c0324c;
            WeakReference<C0324c> weakReference = this.f5103c;
            if (weakReference == null || weakReference.get() == null || this.f5102b == 0 || this.f5101a == null || d2 <= 0.0d || (c0324c = this.f5103c.get()) == null) {
                return;
            }
            c0324c.a(this.f5102b, d2);
        }

        /* synthetic */ C0027c(C0323b c0323b) {
            this();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.E
    public void a(a aVar) {
        super.a(aVar);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.E
    public void a() {
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = this.j;
        if (concurrentLinkedQueue != null) {
            Iterator<E> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
        super.a();
    }

    public void a(long j) {
        this.m = j;
        long j2 = this.l;
        if (j2 != 0) {
            long j3 = this.m;
            if (j3 != 0) {
                a((int) ((((float) j3) * 100.0f) / ((float) j2)));
            }
        }
    }

    public void a(long j, double d2) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.o;
        double d3 = 0.0d;
        if (concurrentLinkedQueue != null) {
            Iterator<b> it = concurrentLinkedQueue.iterator();
            double d4 = 0.0d;
            while (it.hasNext()) {
                b next = it.next();
                if (next.f5099a == j) {
                    next.f5100b = d2;
                }
                double d5 = next.f5100b;
                if (d5 > 0.0d) {
                    long j2 = next.f5099a;
                    if (j2 > 0) {
                        double d6 = j2;
                        Double.isNaN(d6);
                        d4 += (d6 * d5) / 100.0d;
                    }
                }
            }
            d3 = d4;
        }
        a(Double.valueOf(d3).longValue());
    }
}
