package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class Fa<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj);

    abstract void a(B b2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b2, int i, zzeh zzehVar);

    abstract void a(B b2, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, Ra ra) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(InterfaceC1255ia interfaceC1255ia);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b2, InterfaceC1255ia interfaceC1255ia) throws IOException {
        int tag = interfaceC1255ia.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            a((Fa<T, B>) b2, i, interfaceC1255ia.g());
            return true;
        }
        if (i2 == 1) {
            b(b2, i, interfaceC1255ia.k());
            return true;
        }
        if (i2 == 2) {
            a((Fa<T, B>) b2, i, interfaceC1255ia.n());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                a((Fa<T, B>) b2, i, interfaceC1255ia.h());
                return true;
            }
            throw zzgc.zzhv();
        }
        B a2 = a();
        int i3 = 4 | (i << 3);
        while (interfaceC1255ia.c() != Integer.MAX_VALUE && a((Fa<T, B>) a2, interfaceC1255ia)) {
        }
        if (i3 == interfaceC1255ia.getTag()) {
            a((Fa<T, B>) b2, i, (int) b(a2));
            return true;
        }
        throw zzgc.zzhu();
    }

    abstract T b(B b2);

    abstract void b(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, Ra ra) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int c(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T c(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T d(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B e(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int f(T t);
}
