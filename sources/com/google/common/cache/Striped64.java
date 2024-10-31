package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Random;
import sun.misc.Unsafe;

@GwtIncompatible
/* loaded from: classes2.dex */
abstract class Striped64 extends Number {

    /* renamed from: a */
    private static final Unsafe f15247a;

    /* renamed from: b */
    private static final long f15248b;

    /* renamed from: c */
    private static final long f15249c;
    volatile transient long base;
    volatile transient int busy;
    volatile transient a[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        private static final Unsafe f15250a;

        /* renamed from: b */
        private static final long f15251b;

        /* renamed from: c */
        volatile long f15252c;

        static {
            try {
                f15250a = Striped64.access$000();
                f15251b = f15250a.objectFieldOffset(a.class.getDeclaredField("c"));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        a(long j) {
            this.f15252c = j;
        }

        public final boolean a(long j, long j2) {
            return f15250a.compareAndSwapLong(this, f15251b, j, j2);
        }
    }

    static {
        try {
            f15247a = a();
            f15248b = f15247a.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            f15249c = f15247a.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    private static Unsafe a() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new p());
            }
        } catch (PrivilegedActionException e2) {
            throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
        }
    }

    static /* synthetic */ Unsafe access$000() {
        return a();
    }

    public final boolean casBase(long j, long j2) {
        return f15247a.compareAndSwapLong(this, f15248b, j, j2);
    }

    final boolean casBusy() {
        return f15247a.compareAndSwapInt(this, f15249c, 0, 1);
    }

    abstract long fn(long j, long j2);

    public final void internalReset(long j) {
        a[] aVarArr = this.cells;
        this.base = j;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                if (aVar != null) {
                    aVar.f15252c = j;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x009d, code lost:            r16.cells = r8;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x008d, code lost:            if (r16.cells != r9) goto L214;     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x008f, code lost:            r8 = new com.google.common.cache.Striped64.a[r10 << 1];        r11 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0094, code lost:            if (r11 >= r10) goto L230;     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0096, code lost:            r8[r11] = r9[r11];        r11 = r11 + 1;     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0022 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void retryUpdate(long r17, int[] r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.retryUpdate(long, int[], boolean):void");
    }
}
