package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class tb<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b2);

    abstract void a(B b2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b2, int i, zzte zzteVar);

    abstract void a(B b2, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, Fb fb) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(InterfaceC1350bb interfaceC1350bb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b2, InterfaceC1350bb interfaceC1350bb) throws IOException {
        int tag = interfaceC1350bb.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            a((tb<T, B>) b2, i, interfaceC1350bb.zzul());
            return true;
        }
        if (i2 == 1) {
            b(b2, i, interfaceC1350bb.f());
            return true;
        }
        if (i2 == 2) {
            a((tb<T, B>) b2, i, interfaceC1350bb.zzur());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                a((tb<T, B>) b2, i, interfaceC1350bb.e());
                return true;
            }
            throw zzuv.zzwu();
        }
        B a2 = a();
        int i3 = 4 | (i << 3);
        while (interfaceC1350bb.zzvh() != Integer.MAX_VALUE && a((tb<T, B>) a2, interfaceC1350bb)) {
        }
        if (i3 == interfaceC1350bb.getTag()) {
            a((tb<T, B>) b2, i, (int) a((tb<T, B>) a2));
            return true;
        }
        throw zzuv.zzwt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b(T t);

    abstract void b(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, Fb fb) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f(Object obj);
}
