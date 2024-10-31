package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzab<E> extends zzz<E> {

    /* renamed from: a */
    private final transient int f13103a;

    /* renamed from: b */
    private final transient int f13104b;
    private final /* synthetic */ zzz zzfp;

    public zzab(zzz zzzVar, int i, int i2) {
        this.zzfp = zzzVar;
        this.f13103a = i;
        this.f13104b = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzv.zza(i, this.f13104b);
        return this.zzfp.get(i + this.f13103a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13104b;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzy
    public final Object[] zzbp() {
        return this.zzfp.zzbp();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzy
    public final int zzbq() {
        return this.zzfp.zzbq() + this.f13103a;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzy
    final int zzbr() {
        return this.zzfp.zzbq() + this.f13103a + this.f13104b;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzz, java.util.List
    /* renamed from: zzc */
    public final zzz<E> subList(int i, int i2) {
        zzv.zza(i, i2, this.f13104b);
        zzz zzzVar = this.zzfp;
        int i3 = this.f13103a;
        return (zzz) zzzVar.subList(i + i3, i2 + i3);
    }
}
