package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class qb<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T a(B b2);

    abstract void a(B b2, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(B b2, int i, zzps zzpsVar);

    abstract void a(B b2, int i, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(T t, Cb cb) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(Za za);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(B b2, Za za) throws IOException {
        int tag = za.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            a((qb<T, B>) b2, i, za.e());
            return true;
        }
        if (i2 == 1) {
            b(b2, i, za.d());
            return true;
        }
        if (i2 == 2) {
            a((qb<T, B>) b2, i, za.h());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 == 5) {
                a((qb<T, B>) b2, i, za.b());
                return true;
            }
            throw zzrk.zzpt();
        }
        B a2 = a();
        int i3 = 4 | (i << 3);
        while (za.m() != Integer.MAX_VALUE && a((qb<T, B>) a2, za)) {
        }
        if (i3 == za.getTag()) {
            a((qb<T, B>) b2, i, (int) a((qb<T, B>) a2));
            return true;
        }
        throw zzrk.zzps();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int b(T t);

    abstract void b(B b2, int i, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(T t, Cb cb) throws IOException;

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
