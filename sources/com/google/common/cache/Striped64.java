package com.google.common.cache;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
abstract class Striped64 extends Number {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f2624a;
    private static final long b;
    private static final long c;
    volatile transient long base;
    volatile transient int busy;
    volatile transient a[] cells;
    static final c threadHashCode = new c();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    abstract long fn(long j, long j2);

    static /* synthetic */ Unsafe access$000() {
        return a();
    }

    /* loaded from: classes2.dex */
    static final class a {
        private static final Unsafe b;
        private static final long c;

        /* renamed from: a, reason: collision with root package name */
        volatile long f2625a;

        a(long j) {
            this.f2625a = j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean a(long j, long j2) {
            return b.compareAndSwapLong(this, c, j, j2);
        }

        static {
            try {
                b = Striped64.access$000();
                c = b.objectFieldOffset(a.class.getDeclaredField("value"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final Random f2626a = new Random();
        int b;

        b() {
            int nextInt = f2626a.nextInt();
            this.b = nextInt == 0 ? 1 : nextInt;
        }
    }

    /* loaded from: classes2.dex */
    static final class c extends ThreadLocal<b> {
        c() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b initialValue() {
            return new b();
        }
    }

    static {
        try {
            f2624a = a();
            b = f2624a.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            c = f2624a.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean casBase(long j, long j2) {
        return f2624a.compareAndSwapLong(this, b, j, j2);
    }

    final boolean casBusy() {
        return f2624a.compareAndSwapInt(this, c, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void retryUpdate(long j, b bVar, boolean z) {
        int length;
        int length2;
        int i = bVar.b;
        boolean z2 = false;
        while (true) {
            a[] aVarArr = this.cells;
            if (aVarArr != null && (length = aVarArr.length) > 0) {
                a aVar = aVarArr[(length - 1) & i];
                if (aVar == null) {
                    if (this.busy == 0) {
                        a aVar2 = new a(j);
                        if (this.busy == 0 && casBusy()) {
                            boolean z3 = false;
                            try {
                                a[] aVarArr2 = this.cells;
                                if (aVarArr2 != null && (length2 = aVarArr2.length) > 0) {
                                    int i2 = (length2 - 1) & i;
                                    if (aVarArr2[i2] == null) {
                                        aVarArr2[i2] = aVar2;
                                        z3 = true;
                                    }
                                }
                                if (z3) {
                                    break;
                                }
                            } finally {
                            }
                        }
                    }
                    z2 = false;
                    int i3 = i ^ (i << 13);
                    int i4 = i3 ^ (i3 >>> 17);
                    i = i4 ^ (i4 << 5);
                } else {
                    if (!z) {
                        z = true;
                    } else {
                        long j2 = aVar.f2625a;
                        if (aVar.a(j2, fn(j2, j))) {
                            break;
                        }
                        if (length >= NCPU || this.cells != aVarArr) {
                            z2 = false;
                        } else if (!z2) {
                            z2 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == aVarArr) {
                                    a[] aVarArr3 = new a[length << 1];
                                    for (int i5 = 0; i5 < length; i5++) {
                                        aVarArr3[i5] = aVarArr[i5];
                                    }
                                    this.cells = aVarArr3;
                                }
                                this.busy = 0;
                                z2 = false;
                            } finally {
                            }
                        }
                    }
                    int i32 = i ^ (i << 13);
                    int i42 = i32 ^ (i32 >>> 17);
                    i = i42 ^ (i42 << 5);
                }
            } else if (this.busy == 0 && this.cells == aVarArr && casBusy()) {
                boolean z4 = false;
                try {
                    if (this.cells == aVarArr) {
                        a[] aVarArr4 = new a[2];
                        aVarArr4[i & 1] = new a(j);
                        this.cells = aVarArr4;
                        z4 = true;
                    }
                    this.busy = 0;
                    if (z4) {
                        break;
                    }
                } finally {
                }
            } else {
                long j3 = this.base;
                if (casBase(j3, fn(j3, j))) {
                    break;
                }
            }
        }
        bVar.b = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalReset(long j) {
        a[] aVarArr = this.cells;
        this.base = j;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                if (aVar != null) {
                    aVar.f2625a = j;
                }
            }
        }
    }

    private static Unsafe a() {
        try {
            return Unsafe.getUnsafe();
        } catch (SecurityException e) {
            try {
                return (Unsafe) AccessController.doPrivileged(new l());
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }
    }
}
