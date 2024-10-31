package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.qm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1061qm implements com.google.android.gms.ads.internal.gmsg.zzu<zzajr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzrs f12471a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1061qm(zzrs zzrsVar) {
        this.f12471a = zzrsVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzajr zzajrVar, Map map) {
        zzrg zzrgVar;
        com.google.android.gms.ads.internal.gmsg.zzaa zzaaVar;
        zzajr zzajrVar2 = zzajrVar;
        zzrgVar = this.f12471a.zzbvr;
        if (zzrgVar.zzc(map)) {
            zzaaVar = this.f12471a.zzbvx;
            zzaaVar.zza(zzajrVar2, map);
        }
    }
}
