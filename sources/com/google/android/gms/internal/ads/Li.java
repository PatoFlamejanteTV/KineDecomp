package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class Li<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract void a(B b2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b2, int i, zzbpu zzbpuVar);

    abstract void a(B b2, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, Xi xi) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(InterfaceC1098ti interfaceC1098ti);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b2, InterfaceC1098ti interfaceC1098ti) throws IOException {
        int tag = interfaceC1098ti.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            a((Li<T, B>) b2, i, interfaceC1098ti.e());
            return true;
        }
        if (i2 == 1) {
            b(b2, i, interfaceC1098ti.f());
            return true;
        }
        if (i2 == 2) {
            a((Li<T, B>) b2, i, interfaceC1098ti.p());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                a((Li<T, B>) b2, i, interfaceC1098ti.g());
                return true;
            }
            throw zzbrl.zzanh();
        }
        B a2 = a();
        int i3 = 4 | (i << 3);
        while (interfaceC1098ti.m() != Integer.MAX_VALUE && a((Li<T, B>) a2, interfaceC1098ti)) {
        }
        if (i3 == interfaceC1098ti.getTag()) {
            a((Li<T, B>) b2, i, (int) f(a2));
            return true;
        }
        throw zzbrl.zzang();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T b(Object obj);

    abstract void b(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, Xi xi) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B c(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int d(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(Object obj);

    abstract T f(B b2);
}
