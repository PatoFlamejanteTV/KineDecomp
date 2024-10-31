package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Td implements zzy {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f11844a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Vd f11845b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Td(zzazs zzazsVar, String str, Vd vd) {
        this.f11844a = str;
        this.f11845b = vd;
    }

    @Override // com.google.android.gms.internal.ads.zzy
    public final void zzd(zzae zzaeVar) {
        String str = this.f11844a;
        String exc = zzaeVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(exc).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(exc);
        zzbbd.zzeo(sb.toString());
        this.f11845b.zzb(null);
    }
}
