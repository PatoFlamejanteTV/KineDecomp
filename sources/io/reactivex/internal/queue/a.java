package io.reactivex.internal.queue;

import io.reactivex.d.b.m;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes3.dex */
public final class a<T> implements m<T> {

    /* renamed from: a */
    static final int f28379a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: b */
    private static final Object f28380b = new Object();

    /* renamed from: d */
    int f28382d;

    /* renamed from: e */
    long f28383e;

    /* renamed from: f */
    final int f28384f;

    /* renamed from: g */
    AtomicReferenceArray<Object> f28385g;

    /* renamed from: h */
    final int f28386h;
    AtomicReferenceArray<Object> i;

    /* renamed from: c */
    final AtomicLong f28381c = new AtomicLong();
    final AtomicLong j = new AtomicLong();

    public a(int i) {
        int a2 = f.a(Math.max(8, i));
        int i2 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f28385g = atomicReferenceArray;
        this.f28384f = i2;
        a(a2);
        this.i = atomicReferenceArray;
        this.f28386h = i2;
        this.f28383e = i2 - 1;
        b(0L);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        b(j + 1);
        return true;
    }

    private static int b(int i) {
        return i;
    }

    private AtomicReferenceArray<Object> b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) a(atomicReferenceArray, i);
        a(atomicReferenceArray, i, (Object) null);
        return atomicReferenceArray2;
    }

    private long c() {
        return this.j.get();
    }

    private long d() {
        return this.f28381c.get();
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.d.b.n
    public boolean isEmpty() {
        return d() == c();
    }

    @Override // io.reactivex.d.b.n
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f28385g;
            long b2 = b();
            int i = this.f28384f;
            int a2 = a(b2, i);
            if (b2 < this.f28383e) {
                return a(atomicReferenceArray, t, b2, a2);
            }
            long j = this.f28382d + b2;
            if (a(atomicReferenceArray, a(j, i)) == null) {
                this.f28383e = j - 1;
                return a(atomicReferenceArray, t, b2, a2);
            }
            if (a(atomicReferenceArray, a(1 + b2, i)) == null) {
                return a(atomicReferenceArray, t, b2, a2);
            }
            a(atomicReferenceArray, b2, a2, t, i);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.d.b.m, io.reactivex.d.b.n
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long a2 = a();
        int i = this.f28386h;
        int a3 = a(a2, i);
        T t = (T) a(atomicReferenceArray, a3);
        boolean z = t == f28380b;
        if (t == null || z) {
            if (z) {
                return a(b(atomicReferenceArray, i + 1), a2, i);
            }
            return null;
        }
        a(atomicReferenceArray, a3, (Object) null);
        a(a2 + 1);
        return t;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f28385g = atomicReferenceArray2;
        this.f28383e = (j2 + j) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, f28380b);
        b(j + 1);
    }

    private long b() {
        return this.f28381c.get();
    }

    private void b(long j) {
        this.f28381c.lazySet(j);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        a(atomicReferenceArray, length, atomicReferenceArray2);
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.i = atomicReferenceArray;
        int a2 = a(j, i);
        T t = (T) a(atomicReferenceArray, a2);
        if (t != null) {
            a(atomicReferenceArray, a2, (Object) null);
            a(j + 1);
        }
        return t;
    }

    private void a(int i) {
        this.f28382d = Math.min(i / 4, f28379a);
    }

    private long a() {
        return this.j.get();
    }

    private void a(long j) {
        this.j.lazySet(j);
    }

    private static int a(long j, int i) {
        int i2 = ((int) j) & i;
        b(i2);
        return i2;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }
}
