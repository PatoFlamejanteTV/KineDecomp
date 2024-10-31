package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzem extends zzer {
    private final int zzst;
    private final int zzsu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzem(byte[] bArr, int i, int i2) {
        super(bArr);
        zzeh.zzd(i, i + i2, bArr.length);
        this.zzst = i;
        this.zzsu = i2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzer, com.google.android.gms.internal.firebase_auth.zzeh
    public final int size() {
        return this.zzsu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzer, com.google.android.gms.internal.firebase_auth.zzeh
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzsw, zzff() + i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzer
    protected final int zzff() {
        return this.zzst;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzer, com.google.android.gms.internal.firebase_auth.zzeh
    public final byte zzk(int i) {
        zzeh.zze(i, size());
        return this.zzsw[this.zzst + i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.zzer, com.google.android.gms.internal.firebase_auth.zzeh
    public final byte zzl(int i) {
        return this.zzsw[this.zzst + i];
    }
}
