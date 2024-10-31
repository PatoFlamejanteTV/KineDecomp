package com.google.android.gms.internal.ads;

@zzark
/* renamed from: com.google.android.gms.internal.ads.nf */
/* loaded from: classes2.dex */
final class C1012nf extends zzax {

    /* renamed from: a */
    static final C1012nf f12354a = new C1012nf();

    C1012nf() {
    }

    @Override // com.google.android.gms.internal.ads.zzax
    public final zzbc zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbe();
        }
        if ("mvhd".equals(str)) {
            return new zzbf();
        }
        return new zzbg(str);
    }
}
