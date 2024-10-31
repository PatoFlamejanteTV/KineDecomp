package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzac<E> extends zzz<E> {
    static final zzz<Object> zzfq = new zzac(new Object[0], 0);

    /* renamed from: a */
    private final transient Object[] f13105a;

    /* renamed from: b */
    private final transient int f13106b;

    public zzac(Object[] objArr, int i) {
        this.f13105a = objArr;
        this.f13106b = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzv.zza(i, this.f13106b);
        return (E) this.f13105a[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13106b;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzz, com.google.android.gms.internal.firebase_auth.zzy
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.f13105a, 0, objArr, 0, this.f13106b);
        return this.f13106b + 0;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzy
    public final Object[] zzbp() {
        return this.f13105a;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzy
    public final int zzbq() {
        return 0;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzy
    final int zzbr() {
        return this.f13106b;
    }
}
