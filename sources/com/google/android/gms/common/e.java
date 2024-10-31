package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
abstract class e extends c {

    /* renamed from: b */
    private static final WeakReference<byte[]> f11021b = new WeakReference<>(null);

    /* renamed from: c */
    private WeakReference<byte[]> f11022c;

    public e(byte[] bArr) {
        super(bArr);
        this.f11022c = f11021b;
    }

    @Override // com.google.android.gms.common.c
    public final byte[] v() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f11022c.get();
            if (bArr == null) {
                bArr = zzd();
                this.f11022c = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] zzd();
}
