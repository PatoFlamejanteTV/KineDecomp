package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.nm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1019nm implements com.google.android.gms.ads.internal.gmsg.zzu<zzajr> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzrs f12369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1019nm(zzrs zzrsVar) {
        this.f12369a = zzrsVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzajr zzajrVar, Map map) {
        zzrg zzrgVar;
        zzrg zzrgVar2;
        zzrgVar = this.f12369a.zzbvr;
        if (zzrgVar.zzc(map)) {
            zzrgVar2 = this.f12369a.zzbvr;
            zzrgVar2.zza(this.f12369a, (Map<String, String>) map);
        }
    }
}
